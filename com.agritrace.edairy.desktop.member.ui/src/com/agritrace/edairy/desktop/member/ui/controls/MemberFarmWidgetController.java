package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
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
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.AddFarmDialog;

public class MemberFarmWidgetController implements WidgetController,ISelectionListener{

	private IController controller;

	private ITableRidget farmTable;

	private IActionRidget farmAddButton;

	private IActionRidget farmRemoveButton;

	private Membership selectedMember;

	private final String[] farmPropertyNames = { "farmId", "name", "location", "numberOfAnimals", "numberOfContainers" };
	private final String[] farmColumnHeaders = { "ID", "Name", "Location", "Number of Animals", "Number of Conatiners" };
	public static final String farmRemoveTitle = "Remove Farm";
	public static final String farmRemoveMessage = "Do you want to remove selected farms?";

	private final List<Farm> farms = new ArrayList<Farm>();

	public MemberFarmWidgetController(IController controller){
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {

		if(controller == null){
			return;

		}
		farmTable = controller.getRidget(ITableRidget.class, ViewWidgetId.FARM_TABLE);

		farmAddButton =controller.getRidget(IActionRidget.class, ViewWidgetId.FARM_ADD);

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
		farmAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
						| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);
				final AddFarmDialog dialog = new AddFarmDialog(shell);
				dialog.setMemberShip(selectedMember);
				if (dialog.open() == Window.OK) {
					final Farm newFarm = dialog.getNewFarm();
					selectedMember.getMember().getFarms().add(newFarm);
					DairyDemoResourceManager.INSTANCE.addFarm(newFarm);
					farms.add(newFarm);
					farmTable.updateFromModel();
				}
			}
		});

		farmRemoveButton = controller.getRidget(IActionRidget.class, ViewWidgetId.FARM_Remove);
		farmRemoveButton.setEnabled(false);
		farmRemoveButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (MessageDialog
						.openConfirm(Display.getDefault().getActiveShell(), farmRemoveTitle, farmRemoveMessage)) {
					final List<Object> selections = farmTable.getSelection();
					if (selectedMember != null) {
						for (final Object selObject : selections) {
							selectedMember.getMember().getFarms().remove(selObject);
							((Farm) selObject).getAnimals().clear();
							((Farm) selObject).setLocation(null);
							selectedMember.getMember().getFarms().remove((selObject));
							farms.remove(selObject);
						}

						farmTable.updateFromModel();
					}
				}

			}

		});
		farmTable.bindToModel(new WritableList(farms, Farm.class), Farm.class, farmPropertyNames, farmColumnHeaders);
		farmTable.addSelectionListener(this);
	}


	@Override
	public Object getInputModel() {
		// TODO Auto-generated method stub
		return selectedMember;
	}

	@Override
	public void setInputModel(Object model) {
		selectedMember = (Membership)model;
		if(farmTable != null){
			updateBinding();
		}

	}

	@Override
	public IController getController() {
		return controller ;
	}


	@Override
	public void setController(IController controller) {
		this.controller = controller;
	}


	@Override
	public void updateBinding() {
		if(selectedMember != null){
			farms.clear();
			farms.addAll(selectedMember.getMember().getFarms());
			farmTable.updateFromModel();
			farmTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
		}
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == farmTable) {
			final List<Object> selection = event.getNewSelection();
			if (selection.size() > 0) {
				farmRemoveButton.setEnabled(true);
			} else {
				farmRemoveButton.setEnabled(false);
			}
		}
	}
}
