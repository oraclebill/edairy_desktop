package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;

public class MemberFarmWidgetController extends BasicDirectoryController<Farm> implements WidgetController<Object> {

	public static final String farmRemoveMessage = "Do you want to remove selected farms?";

	public static final String farmRemoveTitle = "Remove Farm";

	private final String[] farmColumnHeaders = { "ID", "Name", "Location", "Number of Animals", "Number of Conatiners" };
	private final String[] farmPropertyNames = { "farmId", "name", "location", "numberOfAnimals", "numberOfContainers" };

	private final IFarmRepository farmRepository;
	private final List<Farm> farms = new ArrayList<Farm>();
	private final IMemberRepository memberRepository;
	private Membership selectedMember;

	public MemberFarmWidgetController(IController controller) {
		memberRepository = RepositoryFactory.getMemberRepository();
		farmRepository = RepositoryFactory.getRegisteredRepository(IFarmRepository.class);
		this.controller = controller;
		setEClass(TrackingPackage.Literals.FARM);
		for (int i = 0; i < farmPropertyNames.length; i++) {
			addTableColumn(farmColumnHeaders[i], farmPropertyNames[i], String.class);
		}
		configure();
	}

	@Override
	public void configure() {
		configureRidgets();


		//		// farm table
		//		farmTable = container.getRidget(ITableRidget.class, ViewWidgetId.FARM_TABLE);
		//		farmTable.setColumnFormatter(2, new ColumnFormatter() {
		//
		//			@Override
		//			public String getText(Object element) {
		//				if (element instanceof Farm) {
		//					final Location location = ((Farm) element).getLocation();
		//					if (location != null) {
		//						final PostalLocation postalLocation = location.getPostalLocation();
		//						if (postalLocation != null) {
		//							return postalLocation.getAddress() + "," + postalLocation.getVillage() + ","
		//									+ postalLocation.getPostalCode();
		//						}
		//					}
		//				}
		//				return null;
		//			}
		//		});
		//		// add button
		//		farmAddButton = container.getRidget(IActionRidget.class, ViewWidgetId.FARM_ADD);
		//		farmAddButton.addListener(new IActionListener() {
		//
		//			@Override
		//			public void callback() {
		//				final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
		//						| SWT.APPLICATION_MODAL);
		//				shell.setSize(550, 450);
		//				final Location newFarmLocation = DairyUtil.createLocation(null, null, null);
		//				final Farm newFarm = DairyUtil.createFarm("", newFarmLocation);
		//				FarmListViewTableNode newNode = new FarmListViewTableNode(selectedMember, newFarm);
		//				final AddFarmDialog memberDialog = new AddFarmDialog(Display.getDefault().getActiveShell());
		//				memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
		//						newNode);
		//
		//				final int returnCode = memberDialog.open();
		//				if (returnCode == AbstractWindowController.OK) {
		//					newNode = (FarmListViewTableNode) memberDialog.getController().getContext(
		//							ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
		//					selectedMember.getMember().getFarms().add(newFarm);
		//					if (selectedMember.getMemberId() != null) {
		//						farmRepository.saveNew(newFarm);
		//						memberRepository.update(selectedMember);
		//					}
		//
		//					farms.add(newFarm);
		//					farmTable.updateFromModel();
		//				}
		//			}
		//		});
		//		// viewButton
		//		farmViewButton = container.getRidget(IActionRidget.class, ViewWidgetId.FARM_View);
		//		// by default disable view button
		//		farmViewButton.setEnabled(false);
		//		farmViewButton.addListener(new IActionListener() {
		//
		//			@Override
		//			public void callback() {
		//				final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
		//						| SWT.APPLICATION_MODAL);
		//				shell.setSize(550, 450);
		//
		//				final List<Object> selections = farmTable.getSelection();
		//				if (selections.size() > 0) {
		//					final Farm selectedFarm = (Farm) selections.get(0);
		//					FarmListViewTableNode newNode = new FarmListViewTableNode(selectedMember, selectedFarm);
		//					final ViewFarmDialog memberDialog = new ViewFarmDialog(Display.getDefault().getActiveShell());
		//					memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
		//							newNode);
		//
		//					final int returnCode = memberDialog.open();
		//					if (returnCode == AbstractWindowController.OK) {
		//						newNode = (FarmListViewTableNode) memberDialog.getController().getContext(
		//								ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
		//						farmRepository.update(selectedFarm);
		//						memberRepository.update(selectedMember);
		//						farmTable.updateFromModel();
		//					} else if (returnCode == 2) {
		//						deleteFarm();
		//
		//					}
		//				}
		//
		//			}
		//		});
		//		farmRemoveButton = container.getRidget(IActionRidget.class, ViewWidgetId.FARM_Remove);
		//		farmRemoveButton.setEnabled(false);
		//		farmRemoveButton.addListener(new IActionListener() {
		//
		//			@Override
		//			public void callback() {
		//				deleteFarm();
		//
		//			}
		//
		//		});
		//		farmTable.bindToModel(new WritableList(farms, Farm.class), Farm.class, farmPropertyNames, farmColumnHeaders);
		//		farmTable.addSelectionListener(this);
	}

	@Override
	public IRidgetContainer getContainer() {
		return controller;
	}

	@Override
	public Object getInputModel() {
		return selectedMember;
	}



	@Override
	public void setController(IRidgetContainer container) {
		this.controller = container;
	}

	@Override
	public void setInputModel(Object model) {
		selectedMember = (Membership) model;
		if (table != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (selectedMember != null) {
			farms.clear();
			farms.addAll(selectedMember.getMember().getFarms());
			table.updateFromModel();
		}
	}

	private void deleteFarm() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), farmRemoveTitle, farmRemoveMessage)) {
			final List<Object> selections = table.getSelection();
			if (selectedMember != null) {
				for (final Object selObject : selections) {
					selectedMember.getMember().getFarms().remove(selObject);
					((Farm) selObject).getAnimals().clear();
					((Farm) selObject).setLocation(null);
					selectedMember.getMember().getFarms().remove((selObject));
					farms.remove(selObject);
					farmRepository.delete((Farm) selObject);
					memberRepository.update(selectedMember);
				}

				table.updateFromModel();
			}
		}
	}

	@Override
	protected void configureFilterRidgets() {
		// TODO Auto-generated method stub

	}

	@Override
	protected List getFilteredResult() {
		updateBinding();
		return farms;
	}

	@Override
	protected RecordDialog getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void tableBindToModel() {
		if (table != null) {
			// location formatter
			table.setColumnFormatter(2, new ColumnFormatter() {
				public String getText(Object element) {
					if (element instanceof Farm) {
						Location location = ((Farm) element).getLocation();
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
			super.tableBindToModel();
		}

	}

	@Override
	protected void handleNewItemAction() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
				| SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);
		final Location newFarmLocation = DairyUtil.createLocation(null, null, null);
		final Farm newFarm = DairyUtil.createFarm("", newFarmLocation);
		FarmListViewTableNode newNode = new FarmListViewTableNode(selectedMember, newFarm);
		final AddFarmDialog memberDialog = new AddFarmDialog(Display.getDefault().getActiveShell());
		memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
				newNode);

		final int returnCode = memberDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			newNode = (FarmListViewTableNode) memberDialog.getController().getContext(
					ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
			selectedMember.getMember().getFarms().add(newFarm);
			if (selectedMember.getMemberId() != null) {
				farmRepository.saveNew(newFarm);
				memberRepository.update(selectedMember);
			}

			farms.add(newFarm);
			table.updateFromModel();
		}
	}


	@Override
	protected void handleViewItemAction() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
				| SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);

		final List<Object> selections = table.getSelection();
		if (selections.size() > 0) {
			final Farm selectedFarm = (Farm) selections.get(0);
			FarmListViewTableNode newNode = new FarmListViewTableNode(selectedMember, selectedFarm);
			final ViewFarmDialog memberDialog = new ViewFarmDialog(Display.getDefault().getActiveShell());
			memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
					newNode);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				newNode = (FarmListViewTableNode) memberDialog.getController().getContext(
						ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
				farmRepository.update(selectedFarm);
				memberRepository.update(selectedMember);
				table.updateFromModel();
			} else if (returnCode == 2) {
				deleteFarm();

			}
		}
	}
	protected List<Farm> getTableContents() {
		return farms;
	}

	@Override
	public String getTableWidgetId() {
		return ViewWidgetId.FARM_TABLE;
	}

	@Override
	public String getViewActionId() {
		return ViewWidgetId.FARM_View;
	}

	@Override
	public String getAddActionId() {
		return ViewWidgetId.FARM_ADD;
	}

}
