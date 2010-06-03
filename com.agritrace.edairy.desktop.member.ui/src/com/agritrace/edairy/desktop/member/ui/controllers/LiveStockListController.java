package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.LiveStockListViewTableNode;

public class LiveStockListController extends BaseListViewController{

	private ITableRidget liveStockListTable;
	private IActionRidget viewRidget;
	private final String[] propertyNames = { "membership", "membership", "animal", "animal", "animal", "animal","animal", "animal", "animal" };
	private final String[] columnHeaders = { "Member ID", "Member Name", "Farm Name", "Purpose","LiveStock Name", "Species", "Breed","Acquisition Date", "Status" };
	private List<Membership> membershipList = new ArrayList<Membership>();
	private List<LiveStockListViewTableNode> listTableInput = new ArrayList<LiveStockListViewTableNode>();

	public static final String DELETE_DIALOG_TITLE = "Delete Membership";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected member %s ?";

	private void configueFilterGroup() {
		//		LiveStockListViewTableNode selectedNode = (LiveStockListViewTableNode) farmListTable.getSelection().get(0);
		//		int index = farmListTableInput.indexOf(selectedNode);
		//		final ViewFarmDialog memberDialog = new ViewFarmDialog(Display.getDefault().getActiveShell());
		//		memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
		//				selectedNode);
		//
		//		int returnCode = memberDialog.open();
		//		if (returnCode == AbstractWindowController.OK) {
		//			selectedNode = (LiveStockListViewTableNode) (LiveStockListViewTableNode) memberDialog.getController().getContext(
		//					"selectedFarm");
		//			farmListTableInput.set(index, selectedNode);
		//			farmListTable.updateFromModel();
		//		} else if (returnCode == 2) {
		//			// confirm for delete
		//			if (selectedNode != null) {
		//				String message = "";
		//				if (selectedNode.getFarm() != null) {
		//					message = "\"" + selectedNode.getFarm().getName() + "\"";
		//				}
		//				message = String.format(DELETE_DIALOG_MESSAGE, message);
		//				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), DELETE_DIALOG_TITLE, message)) {
		//					farmListTableInput.remove(selectedNode);
		//					farmListTable.updateFromModel();
		//				}
		//			}
		//		}
	}


	private void buildInputList() {
		listTableInput.clear();
		membershipList.clear();
		membershipList.addAll(getMemberships());
		
		for (Membership membership : membershipList) {
			List<Farm> farms = membership.getMember().getFarms();
			for (Farm farm : farms) {
				List<RegisteredAnimal> animals = farm.getAnimals();
				for(RegisteredAnimal animal : animals){
					listTableInput.add(new LiveStockListViewTableNode(membership, animal));

				}
			}
		}
	}

	private void setColumnFormatters() {
		// MEMBERID
		liveStockListTable.setColumnFormatter(0, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					Membership membership = ((LiveStockListViewTableNode) element).getMembership();
					if (membership != null) {
						return membership.getMemberId() + "";
					}
				}
				return null;
			}
		});
		// memberName
		liveStockListTable.setColumnFormatter(1, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					Membership membership = ((LiveStockListViewTableNode) element).getMembership();
					if (membership != null) {
						Person member = ((Membership) membership).getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
				}
				return null;
			}
		});
		//farm name
		liveStockListTable.setColumnFormatter(2, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					Farm farm = ((LiveStockListViewTableNode) element).getAnimal().getLocation();
					if (farm != null) {
						return farm.getName();
					}
				}
				return null;
			}
		});
		//purose
		liveStockListTable.setColumnFormatter(3, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						animal.getPurpose().getLiteral();
					}
				}
				return null;
			}
		});
		//live stock name
		liveStockListTable.setColumnFormatter(4, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						animal.getGivenName();
					}
				}
				return null;
			}
		});
		//Species
		liveStockListTable.setColumnFormatter(5, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						return animal.getAnimalType().getSpecies();
					}
				}
				return null;
			}
		});



		//breed
		liveStockListTable.setColumnFormatter(6, new ColumnFormatter() {
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						return animal.getAnimalType().getBreed();
					}
				}
				return null;
			}
		});

		//acquisition
		liveStockListTable.setColumnFormatter(7, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						final Date acquisitionDate = animal.getDateOfAcquisition();
						final SimpleFormattedDateBean formatter = new SimpleFormattedDateBean();
						formatter.setDate(acquisitionDate);
						return formatter.getFormattedDate();
					}
				}
				return null;
			}
		});
		//status
		liveStockListTable.setColumnFormatter(8, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					return "N/A";
				}
				return null;
			}
		});
	}

	@Override
	protected void configureFilterGroup() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configureListGroup() {

		liveStockListTable = getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		if (true) {
			buildInputList();
			liveStockListTable.bindToModel(new WritableList(listTableInput, LiveStockListViewTableNode.class),
					LiveStockListViewTableNode.class, propertyNames, columnHeaders);
			setColumnFormatters();

			liveStockListTable.addSelectionListener(new ISelectionListener() {

				@Override
				public void ridgetSelected(SelectionEvent event) {
					if (event.getSource() == liveStockListTable) {
						viewRidget.setEnabled(liveStockListTable.getSelection().size() > 0);
					}
				}

			});
			liveStockListTable.updateFromModel();
			getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_ADD).addListener(new IActionListener() {

				@Override
				public void callback() {
					//					Membership membership = ((LiveStockListViewTableNode) farmListTable.getSelection().get(0))
					//							.getMembership();
					//					Farm farm = DairyUtil.createFarm("",
					//							DairyUtil.createLocation("", "", "", "", "", "", "", "", "", ""));
					//					LiveStockListViewTableNode newNode = new LiveStockListViewTableNode(membership, farm);
					//
					//					final AddFarmDialog memberDialog = new AddFarmDialog(Display.getDefault().getActiveShell());
					//					memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
					//							newNode);
					//
					//					int returnCode = memberDialog.open();
					//					if (returnCode == AbstractWindowController.OK) {
					//						newNode = (LiveStockListViewTableNode) (LiveStockListViewTableNode) memberDialog.getController()
					//								.getContext("selectedFarm");
					//						farmListTableInput.add(newNode);
					//						farmListTable.updateFromModel();
					//					}
				}
			});
			viewRidget = getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_VIEW);
			if (viewRidget != null) {
				viewRidget.setEnabled(false);
				viewRidget.addListener(new IActionListener() {

					@Override
					public void callback() {
						//						LiveStockListViewTableNode selectedNode = (LiveStockListViewTableNode) farmListTable.getSelection()
						//								.get(0);
						//						int index = farmListTableInput.indexOf(selectedNode);
						//						final ViewFarmDialog memberDialog = new ViewFarmDialog(Display.getDefault().getActiveShell());
						//						memberDialog.getController().setContext(
						//								ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);
						//
						//						int returnCode = memberDialog.open();
						//						if (returnCode == AbstractWindowController.OK) {
						//							selectedNode = (LiveStockListViewTableNode) (LiveStockListViewTableNode) memberDialog.getController()
						//									.getContext("selectedFarm");
						//							farmListTableInput.set(index, selectedNode);
						//							farmListTable.updateFromModel();
						//						} else if (returnCode == 2) {
						//							// confirm for delete
						//							if (selectedNode != null) {
						//								String message = "";
						//								if (selectedNode.getFarm() != null) {
						//									message = "\"" + selectedNode.getFarm().getName() + "\"";
						//								}
						//								message = String.format(DELETE_DIALOG_MESSAGE, message);
						//								if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
						//										DELETE_DIALOG_TITLE, message)) {
						//									farmListTableInput.remove(selectedNode);
						//									farmListTable.updateFromModel();
						//								}
						//							}
						//						}
					}
				});
			}
		}


	}



}
