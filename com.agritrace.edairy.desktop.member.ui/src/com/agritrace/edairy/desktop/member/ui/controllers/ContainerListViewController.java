package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.MemberRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.ContainerListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;

public class ContainerListViewController extends BaseListViewController {

	/**
	 * Open member search dialog, IActionListener for search button
	 * 
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = new MemberSearchDialog(null);
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				selectedMember = memberDialog.getSelectedMember();
				final String memberName = MemberUtil.formattedMemberName(selectedMember.getMember());
				memberNameFilter.setText(memberName);
				updateFarmCombo();
				if (searchButton != null) {
					searchButton.setEnabled(true);
				}
			}
		}
	}

	private final class AddContainerAction implements IActionListener {
		@Override
		public void callback() {
			Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.LITRE, null, 0.0);
			final AddContainerDialog memberDialog = new AddContainerDialog(AbstractDirectoryController.getShell());
			final List<Farm> inputFarms = new ArrayList<Farm>();
			final int index = farmCombo.getSelectionIndex();
			if (index != -1) {
				if (index == 0) {
					inputFarms.addAll(farmCombofarms);
				} else {
					inputFarms.add(farmCombofarms.get(index - 1));
				}
				memberDialog.getController().setContext(
						ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, container);
				memberDialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST,
						inputFarms);

				final int returnCode = memberDialog.open();
				if (returnCode == AbstractWindowController.OK) {
					container = (Container) memberDialog.getController().getContext(
							ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
					container.getOwner().getCans().add(container);
					farmRepository.update(container.getOwner());
					memberRepository.update(selectedMember);
					refreshInputList();
				}
			}
		}
	}

	private final class ViewContainerAction implements IActionListener {

		@Override
		public void callback() {
			final ContainerListViewTableNode selectedNode = (ContainerListViewTableNode) containerListTable
					.getSelection().get(0);
			final ViewContainerDialog dialog = new ViewContainerDialog(AbstractDirectoryController.getShell());
			final List<Farm> inputFarms = new ArrayList<Farm>();
			inputFarms.add(selectedNode.getContainer().getOwner());

			dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER,
					selectedNode.getContainer());
			dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, inputFarms);

			final int returnCode = dialog.open();
			if (returnCode == AbstractWindowController.OK) {
				final Container container = (Container) dialog.getController().getContext(
						ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
				farmRepository.update(container.getOwner());
				memberRepository.update(selectedMember);
				refreshInputList();
			} else if (returnCode == 2) {
				// confirm for delete
				if (selectedNode != null) {
					if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), DELETE_DIALOG_TITLE,
							DELETE_DIALOG_MESSAGE)) {
						final Farm farm = selectedNode.getContainer().getOwner();
						farm.getCans().remove(selectedNode.getContainer());
						farmRepository.update(farm);
						memberRepository.update(selectedNode.getMembership());
						refreshInputList();
					}
				}
			}
		}
	}

	public static final String ALL_FARM = "All Farms";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected container?";
	public static final String DELETE_DIALOG_TITLE = "Delete Container";
	private IActionRidget addRidget;
	private IActionRidget clearButton;

	private final String[] containerColumnHeaders = { "Member ID", "Member Name", "Farm Name", "Container ID", "Type",
			"Unit of Measure", "Capacity" };
	private ITableRidget containerListTable;

	private final String[] containerPropertyNames = { "membership", "membership", "container", "container",
			"container", "container", "container" };
	private IComboRidget farmCombo;
	private final List<Farm> farmCombofarms = new ArrayList<Farm>();
	private final List<String> farmNames = new ArrayList<String>();
	private final IFarmRepository farmRepository;
	private IActionRidget memberLookupBtn;
	// filter
	private ITextRidget memberNameFilter;
	private final IMemberRepository memberRepository;
	private IActionRidget searchButton;

	private Membership selectedMember;

	private final List<ContainerListViewTableNode> tableInput = new ArrayList<ContainerListViewTableNode>();

	private IActionRidget viewRidget;

	public ContainerListViewController() {
		memberRepository = new MemberRepository();
		farmRepository = new FarmRepository();
	}

	public void refreshInputList() {
		tableInput.clear();
		tableInput.addAll(getFilteredResult());
		containerListTable.updateFromModel();
	}

	private void clearInputs() {
		tableInput.clear();
		containerListTable.updateFromModel();
	}

	private void setColumnFormatters() {
		// memberId
		containerListTable.setColumnFormatter(0, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Membership membership = ((ContainerListViewTableNode) element).getMembership();
					if (membership != null) {
						return membership.getMemberId() + "";
					}
				}
				return null;
			}
		});
		// memberName
		containerListTable.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Membership membership = ((ContainerListViewTableNode) element).getMembership();
					if (membership != null) {
						final Person member = (membership).getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return container.getOwner().getName();
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(3, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return String.valueOf(container.getContainerId());
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(4, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return container.getType().toString();
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(5, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return String.valueOf(container.getMeasureType().toString());
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(6, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return String.valueOf(container.getCapacity());
					}
				}
				return null;
			}
		});
	}

	private void updateFarmCombo() {
		if (selectedMember != null) {
			selectedMember = memberRepository.findByKey(selectedMember.getMemberId());
			farmCombofarms.clear();
			if (farmCombo != null) {
				final String currentSelection = farmCombo.getText();
				farmNames.clear();
				farmNames.add(ALL_FARM);
				final List<Farm> farms = selectedMember.getMember().getFarms();
				for (final Farm farm : farms) {
					farmNames.add(farm.getName());
					farmCombofarms.add(farm);
				}
				farmCombo.updateFromModel();
				if (MemberUtil.check(currentSelection)) {
					final int index = farmNames.indexOf(currentSelection);
					if (index != -1) {
						farmCombo.setSelection(index);
						return;
					}

				}
				// select the "All Farm" by default
				farmCombo.setSelection(0);
				addRidget.setEnabled(farmNames.size() > 1);
			}
		}
	}

	@Override
	protected void configureFilterGroup() {
		// search text
		memberNameFilter = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberLookupBtn = getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		memberLookupBtn.addListener(new MemberLookupAction());
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.FARM_LIST_ROUTE_COMBO);
		farmCombo.bindToModel(new WritableList(farmNames, String.class), String.class, null, new WritableValue());

		searchButton = getRidget(IActionRidget.class, ViewWidgetId.memberInfo_searchButton);
		searchButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				refreshInputList();

			}
		});
		searchButton.setEnabled(false);

		clearButton = getRidget(IActionRidget.class, ViewWidgetId.cancelButton);
		clearButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				clearInputs();
				viewRidget.setEnabled(false);
			}
		});

	}

	@Override
	protected void configureListGroup() {
		containerListTable = getRidget(ITableRidget.class, ViewWidgetId.CONTAINER_TABLE);

		refreshInputList();
		containerListTable.bindToModel(new WritableList(tableInput, ContainerListViewTableNode.class),
				ContainerListViewTableNode.class, containerPropertyNames, containerColumnHeaders);
		setColumnFormatters();

		containerListTable.addSelectionListener(new ISelectionListener() {

			@Override
			public void ridgetSelected(SelectionEvent event) {
				if (event.getSource() == containerListTable) {
					viewRidget.setEnabled(containerListTable.getSelection().size() > 0);
				}
			}
		});
		containerListTable.updateFromModel();
		addRidget = getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_ADD);
		if (addRidget != null) {
			addRidget.setEnabled(false);
			addRidget.addListener(new AddContainerAction());
		}
		viewRidget = getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_VIEW);
		if (viewRidget != null) {
			viewRidget.setEnabled(false);
			viewRidget.addListener(new ViewContainerAction());
		}
	}

	protected List<ContainerListViewTableNode> getFilteredResult() {
		final List<ContainerListViewTableNode> results = new ArrayList<ContainerListViewTableNode>();
		if (selectedMember != null) {
			selectedMember = memberRepository.findByKey(selectedMember.getMemberId());
			if (farmCombo != null) {
				final String farmName = farmCombo.getText();
				if (!farmName.isEmpty()) {
					final List<Farm> farms = selectedMember.getMember().getFarms();
					for (final Farm farm : farms) {
						if (farmName.equals(ALL_FARM) || farmName.equals(farm.getName())) {
							final List<Container> containerList = farm.getCans();
							for (final Container container : containerList) {
								tableInput.add(new ContainerListViewTableNode(selectedMember, container));
							}
						}
					}
				}
			}
		}

		return results;

	}
}
