package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.LivestockEditDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MemberLiveStockWidgetController extends BasicDirectoryController<RegisteredAnimal>implements WidgetController<Object> {

	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";
	public static final String liveStockRemoveTitle = "Remove Registered Animales";
//	private final List<RegisteredAnimal> animalInput = new ArrayList<RegisteredAnimal>();
	private LiveStockFilterWidgetController filterController;
	private Object inputModel;
	private final String[] liveStockColumnHeaders = { "ID", "Farm", "Purpose", "Name", "Species", "Breed",
			"Acquisition Date", "Acquisition Type" };

	private final String[] liveStockPropertyNames = { "registrationId", "location", "purpose", "givenName",
			"animalType", "animalType", "dateOfAcquisition", "acquisitionType" };

	private final IFarmRepository farmRepository;
	private final Provider<LivestockEditDialog> viewLiveStockProvider;

	@Inject
	public MemberLiveStockWidgetController(final IController controller, IFarmRepository farmRepository,
			final Provider<LivestockEditDialog> viewLiveStockProvider) {
		this.controller = controller;
		this.farmRepository = farmRepository;
		this.viewLiveStockProvider = viewLiveStockProvider;

		setEClass(TrackingPackage.Literals.REGISTERED_ANIMAL);

		for (int i = 0; i < liveStockPropertyNames.length; i++) {
			addTableColumn(liveStockColumnHeaders[i], liveStockPropertyNames[i], String.class);
		}
		configure();
	}

	@Override
	public void configure() {
		configureRidgets();

	}

	@Override
	public IRidgetContainer getContainer() {
		return controller;
	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}


	@Override
	public void setController(IRidgetContainer container) {
		this.controller = container;
	}

	@Override
	public void setInputModel(Object model) {
		this.inputModel = model;
		filterController.setInputModel(model);
		updateBinding();
	}

	@Override
	public void updateBinding() {
		if (inputModel != null) {
			refreshTableContents();
		}

	}

	private List<RegisteredAnimal> filterDate(List<RegisteredAnimal> inputRecrods, Date startDate, Date endDate) {
		if (inputRecrods == null || inputRecrods.isEmpty()) {
			return new ArrayList<RegisteredAnimal>();
		}

		final DateFilterUtil<RegisteredAnimal> dateFilter = new DateFilterUtil<RegisteredAnimal>(
				RegisteredAnimal.class, TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION);

		return dateFilter.filterDate(inputRecrods, startDate, endDate);
	}

	@Override
	protected List<RegisteredAnimal> getFilteredResult() {
		List<RegisteredAnimal> resutls = new ArrayList<RegisteredAnimal>();
		final List<RegisteredAnimal> animals = new ArrayList<RegisteredAnimal>();
		final String speciesName = filterController.getSpeciesCombo().getText();
		filterController.getStatusCombo().getText();
		if (inputModel instanceof Farm) {
			final Farm farm = (Farm) inputModel;
			animals.addAll(farm.getAnimals());
		}
		if (!speciesName.equals("All Species")) {
			for (final RegisteredAnimal animal : animals) {
				if (animal.getAnimalType().getSpecies().equals(speciesName)) {
					resutls.add(animal);
				}
			}
		}
		resutls = filterDate(animals, filterController.getDateSearchController().getStartDate(),filterController.getDateSearchController().getEndDate() );
		return resutls;
	}

	@Override
	protected void configureFilterRidgets() {
		filterController = new LiveStockFilterWidgetController(controller);

	}

	@Override
	protected RecordDialog<RegisteredAnimal> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleNewItemAction() {
		RegisteredAnimal newAnimal = DairyUtil.createAnimal(null, null, "", Gender.FEMALE,
				DairyUtil.createReferenceAnimal("", ""), Purpose.get(0), RearingMode.get(0),
				DairyUtil.createReferenceAnimal("", ""), "", "", null, null, AcquisitionType.get(0), null);
		newAnimal.setDateOfAcquisition(new Date());
		newAnimal.setDateOfBirth(new Date());
		final LivestockEditDialog aniamlDialog = viewLiveStockProvider.get();
		aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
		aniamlDialog.getController().setContext(ControllerContextConstant.ENABLE_LOOKUP,"false");

		final List<Farm> farmList = new ArrayList<Farm>();
		if (inputModel instanceof Membership) {
			farmList.addAll(((Membership) inputModel).getMember().getFarms());
			aniamlDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, inputModel);

		} else if (inputModel instanceof Farm) {
			farmList.add((Farm) inputModel);
			aniamlDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, ((Farm) inputModel).getOwner());

		}
		aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
				farmList);

		final int returnCode = aniamlDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(
					ControllerContextConstant.DIALOG_CONTXT_SELECTED);
			newAnimal.getLocation().getAnimals().add(newAnimal);
			final Farm farmLocation = newAnimal.getLocation();
			if (farmLocation != null && farmLocation.getFarmId() != null) {
				farmRepository.save(newAnimal.getLocation());
			}
			refreshTableContents();
		}
	}

	@Override
	protected void handleViewItemAction() {
		if (table != null && !table.getSelection().isEmpty()) {
			final RegisteredAnimal selectedAnimal = (RegisteredAnimal) table.getSelection().get(0);
			final LivestockEditDialog aniamlDialog = viewLiveStockProvider.get();
			aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED,
					selectedAnimal);
			aniamlDialog.getController().setContext(ControllerContextConstant.ENABLE_LOOKUP,"false");

			final List<Farm> farmList = new ArrayList<Farm>();
			farmList.add(selectedAnimal.getLocation());
			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
					farmList);
			if (inputModel instanceof Membership) {
				aniamlDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, inputModel);
			} else if (inputModel instanceof Farm) {
				aniamlDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, ((Farm) inputModel).getOwner());
			}

			final int returnCode = aniamlDialog.open();
			final Farm farmLocation = selectedAnimal.getLocation();

			if (returnCode == AbstractWindowController.OK) {
				if (farmLocation != null && farmLocation.getFarmId() != null) {
					farmRepository.update(farmLocation);
				}
				refreshTableContents();
			} else if (returnCode == 2) {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), liveStockRemoveTitle,
						liveStockRemoveMessage)) {
					farmLocation.getAnimals().remove(selectedAnimal);
					if (farmLocation.getFarmId() != null) {
						farmRepository.update(farmLocation);
					}
					refreshTableContents();
				}
			}
		}

	}

	@Override
	protected void tableBindToModel(){
		setColumnFormatters();
		super.tableBindToModel();
	}


	private void setColumnFormatters() {
		table.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getLocation().getName();
				}
				return null;
			}
		});

		// species
		table.setColumnFormatter(4, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getSpecies();
				}
				return null;
			}
		});

		// breed
		table.setColumnFormatter(5, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getBreed();
				}
				return null;
			}
		});

		// acquisition
		table.setColumnFormatter(6, new ColumnFormatter() {

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
	}

	@Override
	public String getTableWidgetId() {
		return ViewWidgetId.LIVESTOCK_TABLE;
	}

	@Override
	public String getViewActionId() {
		// TODO Auto-generated method stub
		return ViewWidgetId.LIVESTOCK_VIEW;
	}

	@Override
	public String getAddActionId() {
		// TODO Auto-generated method stub
		return ViewWidgetId.LIVESTOCK_ADD;
	}


}
