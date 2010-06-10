package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddMemberDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewLiveStockDialog;


public class MemberLiveStockWidgetController implements WidgetController, ISelectionListener, DateRangeFilter {

	private IController controller;
	private Object inputModel;

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
	private final IFarmRepository farmRepository;


	public MemberLiveStockWidgetController(IController controller) {
		this.controller = controller;
		farmRepository = new FarmRepository();
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON, this);
		liveStockTable = controller.getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		//farm name
		liveStockTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getLocation().getName();
				}
				return null;
			}
		});

		//species
		liveStockTable.setColumnFormatter(4, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getSpecies();
				}
				return null;
			}
		});

		//breed
		liveStockTable.setColumnFormatter(5, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getBreed();
				}
				return null;
			}
		});

		//acquisition
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
				//tesing for now, use ViewLiveStockDialog for adding
				RegisteredAnimal newAnimal = DairyUtil.createAnimal(null, null, "", Gender.MALE, DairyUtil.createReferenceAnimal("",""), Purpose.get(0), RearingMode.get(0), DairyUtil.createReferenceAnimal("",""), "", "", null, null, AcquisitionType.get(0), null);
				final ViewLiveStockDialog aniamlDialog = new ViewLiveStockDialog(Display.getDefault().getActiveShell());
				aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
				List<Farm> farmList = new ArrayList<Farm>();
				if(inputModel instanceof Membership){
					farmList.addAll(((Membership)inputModel).getMember().getFarms());
				}else if(inputModel instanceof Farm){
					farmList.add((Farm)inputModel);
				}
				aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,farmList);

				int returnCode = aniamlDialog.open();
				if (returnCode == AbstractWindowController.OK) {
					newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED);
					newAnimal.getLocation().getAnimals().add(newAnimal);
					animalInput.add(newAnimal);
					farmRepository.save(newAnimal.getLocation());
					liveStockTable.updateFromModel();
					// membershipList.set(index, selectedMember);
					// memberListRidget.updateFromModel();
				} else {
					// System.out.println("return code "+returnCode);
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

					for (final Object selObject : selections) {
						((RegisteredAnimal) selObject).getLocation().getAnimals().remove(selObject);
						animalInput.remove(selObject);
					}

					liveStockTable.updateFromModel();
				}

			}
		});

	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}

	@Override
	public void setInputModel(Object model) {
		this.inputModel = model;
		updateBinding();
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
		if (inputModel != null) {
			animalInput.clear();
			if (inputModel instanceof Membership) {
				Membership member = (Membership) inputModel;
				final List<Farm> farms = member.getMember().getFarms();
				for (final Farm farm : farms) {
					if(farm != null){
						animalInput.addAll(farm.getAnimals());	
					}

				}
			} else if (inputModel instanceof Farm) {
				Farm farm = (Farm) inputModel;
				if(farm != null){
					animalInput.addAll(farm.getAnimals());
				}
			}

			liveStockTable.updateFromModel();
			liveStockTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
			// liveStockTable.addSelectionListener(this);
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
