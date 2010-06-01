package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;

public class FarmListViewController extends SubModuleController{

	private ITableRidget farmListTable;
	private Dairy dairy;
	private IActionRidget viewRidget;
	private final String[] farmPropertyNames = { "membership", "membership",
			"farm", "farm", "farm", "farm"};
	private final String[] farmColumnHeaders = { "Member ID", "Member Name", "Farm Name",
			"Location", "Number of LiveStocks", "Number of Container"};
	private List<Membership> membershipList = new ArrayList<Membership>();
	private List<FarmListViewTableNode>farmListTableInput = new ArrayList<FarmListViewTableNode>();

	public static final String DELETE_DIALOG_TITLE = "Delete Membership";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected member %s ?";

	private Map<Farm, Membership> farmToMembershipMap = new HashMap<Farm, Membership>();

	@Override
	public void configureRidgets() {
		loadDairy();
		configueMemberTable();

	}

	private void configueFilterGroup(){
		FarmListViewTableNode selectedNode = (FarmListViewTableNode) farmListTable.getSelection().get(0);
		int index = farmListTableInput.indexOf(selectedNode);
		final ViewFarmDialog memberDialog = new ViewFarmDialog(Display.getDefault().getActiveShell());
		memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);

		int returnCode = memberDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			selectedNode = (FarmListViewTableNode) (FarmListViewTableNode) memberDialog.getController().getContext("selectedFarm");
			farmListTableInput.set(index, selectedNode);
			farmListTable.updateFromModel();
		} else if (returnCode == 2) {
			// confirm for delete
			if (selectedNode != null) {
				String message = "";
				if (selectedNode.getFarm() != null) {
					message = "\""+ selectedNode.getFarm().getName()+"\"";
				}
				message = String.format(DELETE_DIALOG_MESSAGE,message);
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),DELETE_DIALOG_TITLE, message)) {
					farmListTableInput.remove(selectedNode);
					farmListTable.updateFromModel();
				}
			}
		}
	}

	private void configueMemberTable() {

		farmListTable = getRidget(ITableRidget.class,ViewWidgetId.FARM_LIST_TABLE);

		if (dairy == null) {
			loadDairy();
		}
		if (dairy != null) {
			buildFarmInputList();
			farmListTable.bindToModel(new WritableList(farmListTableInput,
					FarmListViewTableNode.class), FarmListViewTableNode.class, farmPropertyNames,
					farmColumnHeaders);
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
			getRidget(IActionRidget.class, ViewWidgetId.MEMBERLIST_ADD)
			.addListener(new IActionListener() {

				@Override
				public void callback() {
					Membership membership = ((FarmListViewTableNode) farmListTable.getSelection().get(0)).getMembership();
					Farm farm = DairyUtil.createFarm("", DairyUtil.createLocation("","","","", "", "", "", "","", ""));
					FarmListViewTableNode newNode = new FarmListViewTableNode(membership, farm);
				
					final AddFarmDialog memberDialog = new AddFarmDialog(Display.getDefault().getActiveShell());
					memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, newNode);

					int returnCode = memberDialog.open();
					if (returnCode == AbstractWindowController.OK) {
						newNode = (FarmListViewTableNode) (FarmListViewTableNode) memberDialog.getController().getContext("selectedFarm");
						farmListTableInput.add(newNode);
						farmListTable.updateFromModel();
					} 
				}
			});
			viewRidget = getRidget(IActionRidget.class,
					ViewWidgetId.MEMBERLIST_VIEW);
			if (viewRidget != null) {
				viewRidget.setEnabled(false);
				viewRidget.addListener(new IActionListener() {

					@Override
					public void callback() {
						FarmListViewTableNode selectedNode = (FarmListViewTableNode) farmListTable.getSelection().get(0);
						int index = farmListTableInput.indexOf(selectedNode);
						final ViewFarmDialog memberDialog = new ViewFarmDialog(Display.getDefault().getActiveShell());
						memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);

						int returnCode = memberDialog.open();
						if (returnCode == AbstractWindowController.OK) {
							selectedNode = (FarmListViewTableNode) (FarmListViewTableNode) memberDialog.getController().getContext("selectedFarm");
							farmListTableInput.set(index, selectedNode);
							farmListTable.updateFromModel();
						} else if (returnCode == 2) {
							// confirm for delete
							if (selectedNode != null) {
								String message = "";
								if (selectedNode.getFarm() != null) {
									message = "\""+ selectedNode.getFarm().getName()+"\"";
								}
								message = String.format(DELETE_DIALOG_MESSAGE,message);
								if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),DELETE_DIALOG_TITLE, message)) {
									farmListTableInput.remove(selectedNode);
									farmListTable.updateFromModel();
								}
							}
						}
					}
				});
			}
		}
	}

	private void loadDairy() {
		dairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();

	}

	private void buildFarmInputList(){
		farmToMembershipMap.clear();
		farmListTableInput.clear();
		membershipList.clear();

		membershipList = dairy.getMemberships();
		for(Membership membership : membershipList){
			List<Farm> farms = membership.getMember().getFarms();
			for(Farm farm : farms){
				farmListTableInput.add(new FarmListViewTableNode(membership, farm));
			}
		}
	}

	private void setColumnFormatters(){
		//MEMBERID
		farmListTable.setColumnFormatter(0, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					Membership membership = ((FarmListViewTableNode) element).getMembership();
					if (membership != null) {
						return membership.getMemberId()+"";
					}
				}
				return null;
			}
		});
		//memberName
		farmListTable.setColumnFormatter(1, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					Membership membership = ((FarmListViewTableNode) element).getMembership();
					if (membership != null) {
						Person member = ((Membership) membership).getMember();
						if (member != null) {
							return member.getFamilyName() + ","
							+ member.getGivenName();
						}					
					}
				}
				return null;
			}
		});
		farmListTable.setColumnFormatter(2, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						return farm.getName();				
					}
				}
				return null;
			}
		});
		farmListTable.setColumnFormatter(3, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					Farm farm = ((FarmListViewTableNode) element).getFarm();
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
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						return String.valueOf(farm.getNumberOfAnimals());				
					}
				}
				return null;
			}
		});
		farmListTable.setColumnFormatter(5, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof FarmListViewTableNode) {
					Farm farm = ((FarmListViewTableNode) element).getFarm();
					if (farm != null) {
						return String.valueOf(farm.getNumberOfContainers());				
					}
				}
				return null;
			}
		});
	}


}
