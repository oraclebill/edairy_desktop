package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.MemberRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;

public class MemberFarmWidgetController implements WidgetController, ISelectionListener {

	public static final String farmRemoveMessage = "Do you want to remove selected farms?";

	public static final String farmRemoveTitle = "Remove Farm";

	private IRidgetContainer container;
	private IActionRidget farmAddButton;
	private final String[] farmColumnHeaders = { "ID", "Name", "Location", "Number of Animals", "Number of Conatiners" };

	private final String[] farmPropertyNames = { "farmId", "name", "location", "numberOfAnimals", "numberOfContainers" };

	private IActionRidget farmRemoveButton;
	private final IFarmRepository farmRepository;
	private final List<Farm> farms = new ArrayList<Farm>();
	private ITableRidget farmTable;

	private IActionRidget farmViewButton;
	private final IMemberRepository memberRepository;
	private Membership selectedMember;

	public MemberFarmWidgetController(IController controller) {
		memberRepository = new MemberRepository();
		farmRepository = new FarmRepository();
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {

		if (container == null) {
			return;

		}
		// farm table
		farmTable = container.getRidget(ITableRidget.class, ViewWidgetId.FARM_TABLE);
		farmTable.setColumnFormatter(2, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof Farm) {
					final Location location = ((Farm) element).getLocation();
					if (location != null) {
						final PostalLocation postalLocation = location.getPostalLocation();
						if (postalLocation != null) {
							return postalLocation.getAddress() + "," + postalLocation.getVillage() + ","
									+ postalLocation.getPostalCode();
						}
					}
				}
				return null;
			}
		});
		// add button
		farmAddButton = container.getRidget(IActionRidget.class, ViewWidgetId.FARM_ADD);
		farmAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
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
					farmTable.updateFromModel();
				}
			}
		});
		// viewButton
		farmViewButton = container.getRidget(IActionRidget.class, ViewWidgetId.FARM_View);
		// by default disable view button
		farmViewButton.setEnabled(false);
		farmViewButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
						| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);

				final List<Object> selections = farmTable.getSelection();
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
						farmTable.updateFromModel();
					} else if (returnCode == 2) {
						deleteFarm();

					}
				}

			}
		});
		farmRemoveButton = container.getRidget(IActionRidget.class, ViewWidgetId.FARM_Remove);
		farmRemoveButton.setEnabled(false);
		farmRemoveButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				deleteFarm();

			}

		});
		farmTable.bindToModel(new WritableList(farms, Farm.class), Farm.class, farmPropertyNames, farmColumnHeaders);
		farmTable.addSelectionListener(this);
	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Object getInputModel() {
		// TODO Auto-generated method stub
		return selectedMember;
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == farmTable) {
			final List<Object> selection = event.getNewSelection();
			if (selection.size() > 0) {
				farmViewButton.setEnabled(true);
				farmRemoveButton.setEnabled(true);
			} else {
				farmViewButton.setEnabled(false);
				farmRemoveButton.setEnabled(false);
			}
		}
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;
	}

	@Override
	public void setInputModel(Object model) {
		selectedMember = (Membership) model;
		if (farmTable != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (selectedMember != null) {
			farms.clear();
			farms.addAll(selectedMember.getMember().getFarms());
			farmTable.updateFromModel();
			farmTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
		}
	}

	private void deleteFarm() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), farmRemoveTitle, farmRemoveMessage)) {
			final List<Object> selections = farmTable.getSelection();
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

				farmTable.updateFromModel();
			}
		}
	}
}
