package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

@PermissionRequired(Permission.VIEW_FARMS)
public class FarmListViewController extends BasicDirectoryController<Farm> {

	public static final String ALL_FARM = "All Farms";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to remove selected farms?";
	public static final String DELETE_DIALOG_TITLE = "Remove Farm";

	private final String[] farmColumnHeaders = { "Member ID", "Member Given Name", "Family Name", "Farm Name", "Location", "Number of LiveStocks", "Number of Container" };

	private final String[] farmPropertyNames = { "membership.memberNumber", "membership.member.givenName", "membership.member.familyName", "farm.name", "farm.location", "farm.numberOfAnimals",
	"farm.numberOfContainers" };

	private IComboRidget farmCombo;

	private final List<FarmListViewTableNode> farmListTableInput = new ArrayList<FarmListViewTableNode>();
	private final List<String> farmNames;

	private final IFarmRepository farmRepository;
	private IActionRidget memberLookupBtn;
	// filter group ridgets
	private ITextRidget memberNameFilter;
	private final IMemberRepository memberRepository;

	private IActionRidget searchButton;

	private Membership selectedMember;

	public FarmListViewController() {
		memberRepository = DairyRepository.getInstance();
		farmRepository = new FarmRepository();
		farmNames = new ArrayList<String>();

		setEClass(TrackingPackage.Literals.FARM);
		for (int i = 0; i < farmPropertyNames.length; i++) {
			addTableColumn(farmColumnHeaders[i], farmPropertyNames[i], String.class);
		}
	}

	public void refreshTableContents() {
		farmListTableInput.clear();
		farmListTableInput.addAll(getFilteredFarmResult());
		table.updateFromModel();
	}

	private void updateFarmCombo() {
		if (selectedMember != null) {
			// selectedMember =
			// memberRepository.findByKey(selectedMember.getMemberId());
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
	protected void configureFilterRidgets() {

		// search text
		memberNameFilter = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberLookupBtn = getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		memberLookupBtn.addListener(new MemberLookupAction());
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.FARM_LIST_ROUTE_COMBO);
		farmCombo.bindToModel(new WritableList(farmNames, String.class), String.class, null, new WritableValue());
	}

	protected void tableBindToModel() {
		if (table != null) {
			// location formatter
			table.setColumnFormatter(4, new ColumnFormatter() {
				public String getText(Object element) {
					if (element instanceof FarmListViewTableNode) {
						Location location = ((FarmListViewTableNode) element).getFarm().getLocation();
						if (location != null) {
							final PostalLocation postalLocation = location.getPostalLocation();
							// StringBuffer sb = new StringBuffer();
							if (postalLocation != null) {
								return postalLocation.getAddress() + "," + postalLocation.getVillage() + "," + postalLocation.getPostalCode();
							}
						} else {
							return "<Empty>";
						}

					}

					return null;
				}
			});
			table.bindToModel(new WritableList(farmListTableInput, FarmListViewTableNode.class), FarmListViewTableNode.class, farmPropertyNames, farmColumnHeaders);
			table.updateFromModel();
		}

	}

	protected List<FarmListViewTableNode> getFilteredFarmResult() {
		List<Farm> allFarms = new ArrayList<Farm>();
		if (selectedMember != null) {
			allFarms.addAll(selectedMember.getMember().getFarms());
		} else {
			allFarms.addAll(farmRepository.all());
		}

		final List<FarmListViewTableNode> results = new ArrayList<FarmListViewTableNode>();
		if (farmCombo != null) {
			final String farmName = farmCombo.getText();
			for (final Farm farm : allFarms) {
				if (farmName == null || farmName.isEmpty() || farmName.equals(ALL_FARM) || farmName.equals(farm.getName())) {
					results.add(new FarmListViewTableNode((Membership) farm.getOwner().eContainer(), farm));
				}
			}

		}
		return results;

	}

	protected void handleApplyFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		refreshTableContents();
		table.updateFromModel();
	}

	@Override
	protected void handleNewItemAction() {
		if (selectedMember == null) {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Add Farm", "Can not add a farm. You must select a Member first");
		} else {
			final Location newFarmLocation = DairyUtil.createLocation(null, null, null);
			final Farm newFarm = DairyUtil.createFarm("", newFarmLocation);
			FarmListViewTableNode selectedNode = new FarmListViewTableNode(selectedMember, newFarm);
			final AddFarmDialog memberDialog = new AddFarmDialog(AbstractDirectoryController.getShell());
			memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedNode = (FarmListViewTableNode) memberDialog.getController().getContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
				selectedMember.getMember().getFarms().add(newFarm);
				if (selectedMember.getMemberId() != 0) {
					farmRepository.saveNew(newFarm);
					memberRepository.update(selectedMember);
				}
				updateFarmCombo();
				farmListTableInput.add(selectedNode);
				table.updateFromModel();
			}
		}
	}

	/**
	 * Open member search dialog, IActionListener for search button
	 * 
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = new MemberSearchDialog(AbstractDirectoryController.getShell());
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				selectedMember = memberDialog.getSelectedMember();
				if (selectedMember == null) {
					Log4r.getLogger(getClass()).log(LogService.LOG_WARNING, "Null member selected from dialog");
					return;
				}
				final String memberName = MemberUtil.formattedMemberName(selectedMember.getMember());
				memberNameFilter.setText(memberName);
				updateFarmCombo();
				if (searchButton != null) {
					searchButton.setEnabled(true);
				}
			}
		}
	}

	@Override
	protected void handleViewItemAction() {
		if (!table.getSelection().isEmpty()) {
			FarmListViewTableNode selectedNode = (FarmListViewTableNode) table.getSelection().get(0);
			final ViewFarmDialog memberDialog = new ViewFarmDialog(AbstractDirectoryController.getShell());
			memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedNode = (FarmListViewTableNode) memberDialog.getController().getContext("selectedFarm");
				farmRepository.update(selectedNode.getFarm());
				// memberRepository.update(selectedNode.getMembership());
				refreshTableContents();

			} else if (returnCode == 2) {
				// confirm for delete
				if (selectedNode != null) {
					String message = "";
					if (selectedNode.getFarm() != null) {
						message = "\"" + selectedNode.getFarm().getName() + "\"";
					}
					message = String.format(DELETE_DIALOG_MESSAGE, message);
					if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), DELETE_DIALOG_TITLE, message)) {
						selectedNode.getMembership().getMember().getFarms().remove(selectedNode.getFarm());
						(selectedNode.getFarm()).getAnimals().clear();
						(selectedNode.getFarm()).setLocation(null);
						farmRepository.delete(selectedNode.getFarm());
						// memberRepository.update(selectedMember);
						updateFarmCombo();
						refreshTableContents();
					}
				}
			}
		}
	}

	@Override
	protected RecordDialog<Farm> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		selectedMember = null;
		memberNameFilter.setText("");
		farmNames.clear();
		if (farmCombo != null) {
			farmCombo.setSelection(farmCombo.getEmptySelectionItem());
		}

	}

	@Override
	protected List<Farm> getFilteredResult() {
		return null;
	}

	protected void handleResetFilterAction() {
		super.handleResetFilterAction();
		refreshTableContents();

	}

}
