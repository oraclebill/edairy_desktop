package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
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
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddLiveStockDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewLiveStockDialog;

public class MemberLiveStockWidgetController implements WidgetController<Object>, ISelectionListener {

	private class AddAction implements IActionListener {

		@Override
		public void callback() {
			RegisteredAnimal newAnimal = DairyUtil.createAnimal(null, null, "", Gender.MALE,
					DairyUtil.createReferenceAnimal("", ""), Purpose.get(0), RearingMode.get(0),
					DairyUtil.createReferenceAnimal("", ""), "", "", null, null, AcquisitionType.get(0), null);
			final AddLiveStockDialog aniamlDialog = new AddLiveStockDialog(Display.getDefault().getActiveShell());
			aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
			final List<Farm> farmList = new ArrayList<Farm>();
			if (inputModel instanceof Membership) {
				farmList.addAll(((Membership) inputModel).getMember().getFarms());
			} else if (inputModel instanceof Farm) {
				farmList.add((Farm) inputModel);
			}
			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
					farmList);

			final int returnCode = aniamlDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(
						ControllerContextConstant.DIALOG_CONTXT_SELECTED);
				newAnimal.getLocation().getAnimals().add(newAnimal);
				final Farm farmLocation = newAnimal.getLocation();
				if ((farmLocation != null) && (farmLocation.getFarmId() != null)) {
					farmRepository.save(newAnimal.getLocation());
				}
				refreshList();
			}
		}

	}

	private class FilterAction implements IActionListener {

		@Override
		public void callback() {
			refreshList();
		}

	}

	private class ViewAction implements IActionListener {

		@Override
		public void callback() {
			if (!liveStockTable.getSelection().isEmpty()) {
				final RegisteredAnimal selectedAnimal = (RegisteredAnimal) liveStockTable.getSelection().get(0);
				final ViewLiveStockDialog aniamlDialog = new ViewLiveStockDialog(Display.getDefault().getActiveShell());
				aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED,
						selectedAnimal);
				final List<Farm> farmList = new ArrayList<Farm>();
				farmList.add(selectedAnimal.getLocation());
				aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
						farmList);

				final int returnCode = aniamlDialog.open();
				final Farm farmLocation = selectedAnimal.getLocation();

				if (returnCode == AbstractWindowController.OK) {
					if ((farmLocation != null) && (farmLocation.getFarmId() != null)) {
						farmRepository.update(farmLocation);
					}
					refreshList();
				} else if (returnCode == 2) {
					if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), liveStockRemoveTitle,
							liveStockRemoveMessage)) {
						farmLocation.getAnimals().remove(selectedAnimal);
						if (farmLocation.getFarmId() != null) {
							farmRepository.update(farmLocation);
						}
						refreshList();
					}
				}
			}

		}

	}

	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";
	public static final String liveStockRemoveTitle = "Remove Registered Animales";
	private final List<RegisteredAnimal> animalInput = new ArrayList<RegisteredAnimal>();
	private IRidgetContainer container;
	private final IFarmRepository farmRepository;
	private LiveStockFilterWidgetController filterController;
	private Object inputModel;
	private IActionRidget liveStockAddButton;
	private final String[] liveStockColumnHeaders = { "ID", "Farm", "Purpose", "Name", "Species", "Breed",
			"Acquisition Date", "Acquisition Type" };

	private final String[] liveStockPropertyNames = { "registrationId", "location", "purpose", "givenName",
			"animalType", "animalType", "dateOfAcquisition", "acquisitionType" };

	private ITableRidget liveStockTable;

	private IActionRidget liveStockViewButton;

	public MemberLiveStockWidgetController(IController controller) {
		this.container = controller;
		farmRepository = new FarmRepository();
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}

		filterController = new LiveStockFilterWidgetController(container);
		liveStockTable = container.getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		// farm name
		liveStockTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getLocation().getName();
				}
				return null;
			}
		});

		// species
		liveStockTable.setColumnFormatter(4, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getSpecies();
				}
				return null;
			}
		});

		// breed
		liveStockTable.setColumnFormatter(5, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getBreed();
				}
				return null;
			}
		});

		// acquisition
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
		liveStockTable.addSelectionListener(this);

		liveStockAddButton = container.getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_ADD);
		liveStockAddButton.addListener(new AddAction());

		liveStockViewButton = container.getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_VIEW);
		liveStockViewButton.addListener(new ViewAction());
		liveStockViewButton.setEnabled(false);
		filterController.getSearch().addListener(new FilterAction());

	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}

	public void refreshList() {
		animalInput.clear();
		animalInput.addAll(getFilteredResult());
		liveStockTable.updateFromModel();
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == liveStockTable) {
			final List<Object> selection = liveStockTable.getSelection();
			if (selection.size() > 0) {
				liveStockViewButton.setEnabled(true);
			} else {
				liveStockViewButton.setEnabled(false);
			}
		}
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;
	}

	@Override
	public void setInputModel(Object model) {
		this.inputModel = model;
		if (inputModel instanceof Membership) {
			Membership member = (Membership)inputModel;
			boolean enableLivestockAdd = member.getMember().getFarms().size() > 0 ;
			liveStockAddButton.setEnabled(enableLivestockAdd);
			if (!enableLivestockAdd) {
				liveStockAddButton.setToolTipText("Livestock addition disabled - member has no farms.");
			}
		}
		filterController.setInputModel(model);
		updateBinding();
	}

	@Override
	public void updateBinding() {
		if (inputModel != null) {
			refreshList();
		}

	}

	private List<RegisteredAnimal> filterDate(List<RegisteredAnimal> inputRecrods, Date startDate, Date endDate) {
		if ((inputRecrods == null) || inputRecrods.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		DateFilterUtil<RegisteredAnimal> dateFilter = new DateFilterUtil<RegisteredAnimal>(
				RegisteredAnimal.class, TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION);
		return dateFilter.filterDate(inputRecrods, startDate, endDate);
	}

	private List<RegisteredAnimal> getFilteredResult() {
		List<RegisteredAnimal> resutls = new ArrayList<RegisteredAnimal>();
		final List<RegisteredAnimal> animals = new ArrayList<RegisteredAnimal>();
		final String farmName = filterController.getFarmCombo().getText();
		final String speciesName = filterController.getSpeciesCombo().getText();
		filterController.getStatusCombo().getText();
		final List<Farm> farms = new ArrayList<Farm>();
		if (inputModel instanceof Membership) {
			farms.addAll(((Membership) inputModel).getMember().getFarms());
			for (final Farm farm : farms) {
				if (farmName.equals("All Farms") || farmName.equals(farm.getName())) {
					animals.addAll(farm.getAnimals());
				}
			}
		} else if (inputModel instanceof Farm) {
			final Farm farm = (Farm) inputModel;
			if (farmName.equals("All Farms") || farmName.equals(farm.getName())) {
				animals.addAll(farm.getAnimals());
			}
		}
		if (!speciesName.equals("All Species")) {
			for (final RegisteredAnimal animal : animals) {
				if (animal.getAnimalType().getSpecies().equals(speciesName)) {
					resutls.add(animal);
				}
			}
		}
		resutls = filterDate(animals, filterController.getDateSearchController().getStartDate(), filterController
				.getDateSearchController().getEndDate());
		return resutls;
	}
}
