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

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class FarmListViewController extends BaseListViewController {
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

	private final class AddFarmAction implements IActionListener {
		@Override
		public void callback() {
			final Location newFarmLocation = DairyUtil.createLocation(null, null, null);
			final Farm newFarm = DairyUtil.createFarm("", newFarmLocation);
			FarmListViewTableNode selectedNode = new FarmListViewTableNode(selectedMember, newFarm);
			final AddFarmDialog memberDialog = new AddFarmDialog(AbstractDirectoryController.getShell());
			memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
					selectedNode);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedNode = (FarmListViewTableNode) memberDialog.getController().getContext(
						ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
				selectedMember.getMember().getFarms().add(newFarm);
				if (selectedMember.getMemberId() != 0) {
					farmRepository.saveNew(newFarm);
					memberRepository.update(selectedMember);
				}
				updateFarmCombo();
				farmListTableInput.add(selectedNode);
				farmListTable.updateFromModel();
			}
		}
	}

	/**
	 * Open View farm dialog,
	 * 
	 */
	private class ViewAction implements IActionListener {

		@Override
		public void callback() {
			if (!farmListTable.getSelection().isEmpty()) {
				FarmListViewTableNode selectedNode = (FarmListViewTableNode) farmListTable.getSelection().get(0);
				final ViewFarmDialog memberDialog = new ViewFarmDialog(AbstractDirectoryController.getShell());
				memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
						selectedNode);

				final int returnCode = memberDialog.open();
				if (returnCode == AbstractWindowController.OK) {
					selectedNode = (FarmListViewTableNode) memberDialog.getController().getContext("selectedFarm");
					farmRepository.update(selectedNode.getFarm());
					memberRepository.update(selectedMember);
					refreshInputList();

				} else if (returnCode == 2) {
					// confirm for delete
					if (selectedNode != null) {
						String message = "";
						if (selectedNode.getFarm() != null) {
							message = "\"" + selectedNode.getFarm().getName() + "\"";
						}
						message = String.format(DELETE_DIALOG_MESSAGE, message);
						if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), DELETE_DIALOG_TITLE,
								message)) {
							selectedMember.getMember().getFarms().remove(selectedNode.getFarm());
							(selectedNode.getFarm()).getAnimals().clear();
							(selectedNode.getFarm()).setLocation(null);
							farmRepository.delete(selectedNode.getFarm());
							memberRepository.update(selectedMember);
							updateFarmCombo();
							refreshInputList();
						}
					}
				}
			}
		}

	}

	public static final String ALL_FARM = "All Farms";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to remove selected farms?";
	public static final String DELETE_DIALOG_TITLE = "Remove Farm";
	private IActionRidget clearButton;
	private final String[] farmColumnHeaders = { "Member ID", "Member Name", "Farm Name", "Location",
			"Number of LiveStocks", "Number of Container" };

	private IComboRidget farmCombo;
	private ITableRidget farmListTable;

	private final List<FarmListViewTableNode> farmListTableInput = new ArrayList<FarmListViewTableNode>();
	private final List<String> farmNames;
	private final String[] farmPropertyNames = { "membership", "membership", "farm", "farm", "farm", "farm" };
	private final IFarmRepository farmRepository;
	private IActionRidget memberLookupBtn;
	// filter group ridgets
	private ITextRidget memberNameFilter;
	private final IMemberRepository memberRepository;

	private IActionRidget searchButton;

	private Membership selectedMember;

	private IActionRidget viewRidget;

	public FarmListViewController() {
		memberRepository = DairyRepository.getInstance();
		farmRepository = new FarmRepository();
		farmNames = new ArrayList<String>();
	}

	public void refreshInputList() {
		farmListTableInput.clear();
		farmListTableInput.addAll(getFilteredResult());
		farmListTable.updateFromModel();
	}

	private void clearInputs() {
		farmListTableInput.clear();
		farmListTable.updateFromModel();
	}

	private void setColumnFormatters() {
		// MEMBERID
		farmListTable.setColumnFormatter(0, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					final Membership membership = ((FarmListViewTableNode) element).getMembership();
					if (membership != null) {
						return membership.getMemberId() + "";
					}
				}
				return null;
			}
		});
		// memberName
		farmListTable.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					final Membership membership = ((FarmListViewTableNode) element).getMembership();
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
		farmListTable.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					final Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						return farm.getName();
					}
				}
				return null;
			}
		});
		farmListTable.setColumnFormatter(3, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					final Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						final Location location = farm.getLocation();
						if (location != null) {
							final PostalLocation postalLocation = location.getPostalLocation();
							if (postalLocation != null) {
								return postalLocation.getAddress() + "," + postalLocation.getVillage() + ","
										+ postalLocation.getPostalCode();
							}
						}
					}
				}
				return null;
			}
		});
		farmListTable.setColumnFormatter(4, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					final Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						return String.valueOf(farm.getNumberOfAnimals());
					}
				}
				return null;
			}
		});
		farmListTable.setColumnFormatter(5, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					final Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						return String.valueOf(farm.getNumberOfContainers());
					}
				}
				return null;
			}
		});
	}

	private void updateFarmCombo() {
		if (selectedMember != null) {
//			selectedMember = memberRepository.findByKey(selectedMember.getMemberId());
			if (farmCombo != null) {
				final String currentSelection = farmCombo.getText();
				farmNames.clear();
				farmNames.add(ALL_FARM);
				final List<Farm> farms = selectedMember.getMember().getFarms();
				for (final Farm farm : farms) {
					farmNames.add(farm.getName());
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
			}
		});

	}

	@Override
	protected void configureListGroup() {
		farmListTable = getRidget(ITableRidget.class, ViewWidgetId.FARM_LIST_TABLE);
		if (true) {
			farmListTable.bindToModel(new WritableList(farmListTableInput, FarmListViewTableNode.class),
					FarmListViewTableNode.class, farmPropertyNames, farmColumnHeaders);
			setColumnFormatters();
			farmListTable.addSelectionListener(new ISelectionListener() {

				@Override
				public void ridgetSelected(SelectionEvent event) {
					if (event.getSource() == farmListTable) {
						viewRidget.setEnabled(farmListTable.getSelection().size() > 0);
					}
				}

			});
			farmListTable.updateFromModel();
			getRidget(IActionRidget.class, ViewWidgetId.FARM_ADD).addListener(new AddFarmAction());
			viewRidget = getRidget(IActionRidget.class, ViewWidgetId.FARM_View);
			if (viewRidget != null) {
				viewRidget.setEnabled(false);
				viewRidget.addListener(new ViewAction());
			}
		}
	}

	protected List<FarmListViewTableNode> getFilteredResult() {
		final List<FarmListViewTableNode> results = new ArrayList<FarmListViewTableNode>();
		if (selectedMember != null) {
//			selectedMember = memberRepository.findByKey(selectedMember.getMemberId());
			if (farmCombo != null) {
				final String farmName = farmCombo.getText();
				if (!farmName.isEmpty()) {
					final List<Farm> farms = selectedMember.getMember().getFarms();
					for (final Farm farm : farms) {
						if (farmName.equals(ALL_FARM) || farmName.equals(farm.getName())) {
							results.add(new FarmListViewTableNode(selectedMember, farm));
						}
					}
				}
			}
		}

		return results;

	}
}
