package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.AllPermissions;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.ContainerListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(AllPermissions.VIEW_CONTAINERS)
public class ContainerListViewController extends BasicDirectoryController<Container> {

	public static final String ALL_FARM = "All Farms";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected container?";
	public static final String DELETE_DIALOG_TITLE = "Delete Container";

	//table columns
	private final String[] containerColumnHeaders = { "Member ID", "Member Name", "Farm Name", "Container ID", "Unit of Measure", "Capacity" };
	private final String[] containerPropertyNames = { "membership", "membership", "container", "container", "container", "container" };
	// filter
	private IComboRidget farmCombo;
	private final List<Farm> farmCombofarms = new ArrayList<Farm>();
	private final List<String> farmNames = new ArrayList<String>();
	private final IFarmRepository farmRepository;
	private IActionRidget memberLookupBtn;
	private ITextRidget memberNameFilter;
	private IActionRidget searchButton;

	//repository
	private Membership selectedMember;

	private final List<ContainerListViewTableNode> tableInput = new ArrayList<ContainerListViewTableNode>();
	private final Provider<MemberSearchDialog> memberSearchProvider;
	private final Provider<AddContainerDialog> addContainerProvider;
	private final Provider<ViewContainerDialog> viewContainerProvider;

	@Inject
	public ContainerListViewController(final IFarmRepository farmRepository,
			final Provider<MemberSearchDialog> memberSearchProvider,
			final Provider<AddContainerDialog> addContainerProvider,
			final Provider<ViewContainerDialog> viewContainerProvider) {
		this.farmRepository = farmRepository;
		this.memberSearchProvider = memberSearchProvider;
		this.addContainerProvider = addContainerProvider;
		this.viewContainerProvider = viewContainerProvider;

		setEClass(TrackingPackage.Literals.CONTAINER);

		for (int i = 0; i < containerPropertyNames.length; i++) {
			addTableColumn(containerColumnHeaders[i], containerPropertyNames[i], String.class);
		}
	}

	@Override
	public void refreshTableContents() {
		tableInput.clear();
		tableInput.addAll(getFilteredTableResult());
		table.updateFromModel();
	}

	private void setColumnFormatters() {
		int idx = 0;
		// memberId
		table.setColumnFormatter(idx++, new ColumnFormatter() {
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
		table.setColumnSortable(0,true);
		table.setComparator(0,new ContainerListTableComparator(0));
		// memberName
		table.setColumnFormatter(idx++, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					final Membership membership = ((ContainerListViewTableNode) element).getMembership();
					if (membership != null) {
						final Person member = membership.getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
				}
				return null;
			}
		});
		table.setColumnSortable(1,true);
		table.setComparator(1,new ContainerListTableComparator(1));
		table.setColumnFormatter(idx++, new ColumnFormatter() {
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
		table.setColumnSortable(2,true);
		table.setComparator(2,new ContainerListTableComparator(2));
		table.setColumnFormatter(idx++, new ColumnFormatter() {
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
		table.setColumnSortable(3,true);
		table.setComparator(3,new ContainerListTableComparator(3));
		// containerListTable.setColumnFormatter(4, new ColumnFormatter() {
		// @Override
		// public String getText(Object element) {
		// if (element instanceof ContainerListViewTableNode) {
		// final Container container = ((ContainerListViewTableNode)
		// element).getContainer();
		// if (container != null) {
		// return container.getType().toString();
		// }
		// }
		// return null;
		// }
		// });
		table.setColumnFormatter(idx++, new ColumnFormatter() {
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
		table.setColumnFormatter(idx++, new ColumnFormatter() {
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
		farmNames.clear();
		farmNames.add(ALL_FARM);
		if (selectedMember != null) {
			// selectedMember =
			// memberRepository.findByKey(selectedMember.getMemberId());
			farmCombofarms.clear();
			if (farmCombo != null) {
				final String currentSelection = farmCombo.getText();
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

			}
			// select the "All Farm" by default
			farmCombo.setSelection(0);
		}
	}

	@Override
	protected void configureFilterRidgets() {
		// search text
		memberNameFilter = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberLookupBtn = getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		memberLookupBtn.addListener(new MemberLookupAction());
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.FARM_LIST_ROUTE_COMBO);
		farmCombo.bindToModel(new WritableList(farmNames, String.class), String.class, null, new WritableValue());

	}

	@Override
	protected void tableBindToModel() {
		if (table != null) {
			setColumnFormatters();
			table.bindToModel(new WritableList(tableInput, ContainerListViewTableNode.class), ContainerListViewTableNode.class, containerPropertyNames, containerColumnHeaders);
			table.updateFromModel();
		}
	}

	protected List<ContainerListViewTableNode> getFilteredTableResult() {
		final List<ContainerListViewTableNode> results = new ArrayList<ContainerListViewTableNode>();
		final List<Farm> farms = new ArrayList<Farm>();
		if (selectedMember != null) {
			farms .addAll(selectedMember.getMember().getFarms());
		}else{
			farms.addAll(farmRepository.all());
		}
		if (farmCombo != null) {
			final String farmName = farmCombo.getText();
			for (final Farm farm : farms) {
				if (farmName.isEmpty()||farmName.equals(ALL_FARM) || farmName.equals(farm.getName())) {
					final List<Container> containerList = farm.getCans();
					for (final Container container : containerList) {
						if(selectedMember != null){
							results.add(new ContainerListViewTableNode(selectedMember, container));
						}else if( container.getOwner().getOwner().eContainer() instanceof Membership){
							final Membership member = (Membership) container.getOwner().getOwner().eContainer();
							results.add(new ContainerListViewTableNode(member, container));
						}

					}
				}
			}

		}

		return results;

	}

	/**
	 * Open member search dialog, IActionListener for search button
	 *
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = memberSearchProvider.get();
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				selectedMember = memberDialog.getSelectedMember();
				if(selectedMember != null){
					final String memberName = MemberUtil.formattedMemberName(selectedMember.getMember());
					memberNameFilter.setText(memberName);
					updateFarmCombo();
					if (searchButton != null) {
						searchButton.setEnabled(true);
					}
				}

			}
		}
	}

	@Override
	protected void handleNewItemAction() {

		Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.LITRE, null, 0.0);
		final AddContainerDialog memberDialog = addContainerProvider.get();
		final List<Farm> inputFarms = new ArrayList<Farm>();
		final int index = farmCombo.getSelectionIndex();
		if (index == 0 || index == -1) {
			inputFarms.addAll(farmCombofarms);
		} else {
			inputFarms.add(farmCombofarms.get(index - 1));
		}
		memberDialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, container);
		memberDialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, inputFarms);
		if (selectedMember != null) {
			memberDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, selectedMember);
		}

		final int returnCode = memberDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			container = (Container) memberDialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
			container.getOwner().getCans().add(container);
			farmRepository.save(container.getOwner());
			//				memberRepository.update(selectedMember);
			refreshTableContents();
		}


	}

	@Override
	protected void handleViewItemAction() {

		final ContainerListViewTableNode selectedNode = (ContainerListViewTableNode) table.getSelection().get(0);
		final ViewContainerDialog dialog = viewContainerProvider.get();
		final List<Farm> inputFarms = new ArrayList<Farm>();
		inputFarms.add(selectedNode.getContainer().getOwner());

		dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, selectedNode.getContainer());
		dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, inputFarms);
		dialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, selectedNode.getMembership());

		final int returnCode = dialog.open();
		if (returnCode == AbstractWindowController.OK) {
			final Container container = (Container) dialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
			farmRepository.update(container.getOwner());
			refreshTableContents();
		} else if (returnCode == 2) {
			// confirm for delete
			if (selectedNode != null) {
				if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), DELETE_DIALOG_TITLE, DELETE_DIALOG_MESSAGE)) {
					final Farm farm = selectedNode.getContainer().getOwner();
					farm.getCans().remove(selectedNode.getContainer());
					farmRepository.update(farm);
					refreshTableContents();
				}
			}
		}

	}

	@Override
	protected RecordDialog<Container> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		selectedMember = null;
		memberNameFilter.setText("");
		farmNames.clear();
		farmNames.add(ALL_FARM);
		if (farmCombo != null) {
			farmCombo.setSelection(farmCombo.getEmptySelectionItem());
		}

	}

	@Override
	protected List<Container> getFilteredResult() {
		// TODO Auto-generated method stub
		return null;
	}

	private class ContainerListTableComparator implements Comparator<Object> {
		int columnIndex;

		ContainerListTableComparator(int index) {
			this.columnIndex = index;
		}

		@Override
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Membership && o2 instanceof Membership || o1 instanceof Container && o2 instanceof Container) {
				switch (columnIndex) {
				case 0:
					return ((Membership) o1).getMemberId().compareTo(((Membership) o2).getMemberId());
				case 1:
					final Membership node1 = (Membership) o1;
					final Membership node2 = (Membership) o2;
					final Person member1 = node1.getMember();
					final Person member2 = node2.getMember();
					if (member1 != null && member2 != null) {
						final String name1 = member1.getFamilyName() + "," + member1.getGivenName();
						final String name2 = member2.getFamilyName() + "," + member2.getGivenName();
						return name1.compareTo(name2);
					}

					return 0;
				case 2:
					final Farm farm1 = ((Container) o1).getOwner();
					final Farm farm2 = ((Container) o2).getOwner();
					if (farm1 != null && farm2 != null) {
						final String name1 = farm1.getName();
						final String name2 = farm2.getName();
						if (name1 != null && name2 != null) {
							return name1.compareTo(name2);
						}
					}

					return 0;
				case 3:
					final String number1 = ((Container) o1).getTrackingNumber();
					final String number2 = ((Container) o2).getTrackingNumber();
					if (number1 != null && number2 != null) {
						return number1.compareTo(number2);
					}
				default:
					return 0;
				}
			}
			return 0;
		}

	}
}
