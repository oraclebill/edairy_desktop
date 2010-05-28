package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
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

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.AddAnimalDialog;

public class MemberLiveStockController implements WidgetController, ISelectionListener, DateRangeFilter {

	private IController controller;
	private Membership member;

	private DateRangeSearchController dateSearchController;
	
	private ITableRidget liveStockTable;
	private IActionRidget liveStockAddButton;
	private IActionRidget liveStockRemoveButton;
	private final String[] liveStockPropertyNames = { "registrationId", "location", "purpose", "givenName",
			"animalType", "animalType", "dateOfAcquisition", "acquisitionType" };
	private final String[] liveStockColumnHeaders = { "ID", "Farm", "Purpose", "Name", "Species", "Breed",
			"Acquisition Date", "Acquisition Type" };
	public static final String liveStockRemoveTitle = "Remove Registered Animales";
	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";
	private final List<RegisteredAnimal> animalInput = new ArrayList<RegisteredAnimal>();

	public MemberLiveStockController(IController controller){
		this.controller = controller;
		configue();
	}

	@Override
	public void configue() {
		if(controller == null){
			return;
		}
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON, this);
		liveStockTable = controller.getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		liveStockTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getLocation().getName();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(4, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getSpecies();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(5, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getBreed();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(6, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					final Date acquisitionDate = ((RegisteredAnimal) element).getDateOfAcquisition();
					final SimpleFormattedDateBean formatter = new SimpleFormattedDateBean();
					formatter.setDate(acquisitionDate);
					return formatter.getFormattedDate();
				}
				return null;
			}
		});
		liveStockTable.bindToModel(new WritableList(animalInput, RegisteredAnimal.class), RegisteredAnimal.class,
				liveStockPropertyNames, liveStockColumnHeaders);

		liveStockAddButton = controller.getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_ADD);
		liveStockAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
						| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);
				final AddAnimalDialog dialog = new AddAnimalDialog(shell);
				dialog.setMemberShip(member);
				if (dialog.open() == Window.OK) {
					final RegisteredAnimal newAnimal = dialog.getNewAnimal();
					newAnimal.getLocation().getAnimals().add(newAnimal);
					animalInput.add(newAnimal);
					liveStockTable.updateFromModel();
				}
			}
		});

		liveStockRemoveButton = controller.getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_Remove);
		liveStockRemoveButton.setEnabled(false);
		liveStockRemoveButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), liveStockRemoveTitle,
						liveStockRemoveMessage)) {
					final List<Object> selections = liveStockTable.getSelection();
					if (member != null) {
						for (final Object selObject : selections) {
							((RegisteredAnimal) selObject).getLocation().getAnimals().remove(selObject);
							animalInput.remove(selObject);
						}

						liveStockTable.updateFromModel();
					}
				}
			}
		});


	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setInputModel(Object model) {
		this.member = (Membership)model; 
		if(liveStockTable != null){
			updateBinding();
		}
	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;
	}

	@Override
	public void updateBinding() {
		if(member != null){
			animalInput.clear();
			final List<Farm> farms = member.getMember().getFarms();
			for (final Farm farm : farms) {
				animalInput.addAll(farm.getAnimals());
			}
			liveStockTable.updateFromModel();
			liveStockTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
			//			liveStockTable.addSelectionListener(this);
		}

	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == liveStockTable) {
			final List<Object> selection = event.getNewSelection();
			if (selection.size() > 0) {
				liveStockRemoveButton.setEnabled(true);
			} else {
				liveStockRemoveButton.setEnabled(false);
			}
		}
	}

	@Override
	public List<Object> filter(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
