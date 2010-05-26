package com.agritrace.edairy.desktop.member.ui.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberAdapter;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition.RelationalOperator;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
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
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.AddAnimalDialog;

public class MemberLiveStockController implements WidgetController, ISelectionListener, DateRangeFilter {

	private IController controller;
	private Membership member;

	private DateRangeSearchController dateSearchController;
	
	private IComboRidget speciesCombo;
	private IComboRidget statusCombo;
	private ITableRidget liveStockTable;
	private IActionRidget liveStockAddButton;
	private IActionRidget liveStockRemoveButton;
	private final String[] liveStockPropertyNames = { "location", "purpose", "givenName",
			"animalType", "animalType", "dateOfAcquisition", "acquisitionType" };
	private final String[] liveStockColumnHeaders = { "Farm", "Purpose", "Name", "Species", "Breed",
			"Acquisition", "Status" };
	public static final String liveStockRemoveTitle = "Remove Registered Animales";
	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";
	private final List<RegisteredAnimal> animalInput = new ArrayList<RegisteredAnimal>();
	private List<String> speciesFilterList =  new ArrayList<String>();
	private List<String> statusFilterList = new ArrayList<String>();
	public static final String ALL_SPECIES="All Species";
	public static final String ALL_STATUS="All Status";

	public MemberLiveStockController(IController controller){
		this.controller = controller;
		configue();
	}

	@Override
	public void configue() {
		if(controller == null){
			return;
		}
		speciesCombo = controller.getRidget(IComboRidget.class,ViewWidgetId.LIVESTOCK_ContainerSpeciesFilter);
		statusCombo = controller.getRidget(IComboRidget.class,ViewWidgetId.LIVESTOCK_ContainerStatusFilter);
		
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON, this);
		liveStockTable = controller.getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		liveStockTable.setColumnFormatter(0, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getLocation().getName();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(3, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getSpecies();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(4, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					return ((RegisteredAnimal) element).getAnimalType().getBreed();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(5, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					final Date acquisitionDate = ((RegisteredAnimal) element).getDateOfAcquisition();
					final SimpleFormattedDateBean formatter = new SimpleFormattedDateBean();
					formatter.setDate(acquisitionDate);
					String acqusionText = formatter.getFormattedDate()+" ("+((RegisteredAnimal) element).getAcquisitionType().toString()+")";
					return acqusionText;
				}
				return null;
			}
		});
		liveStockTable.setColumnFormatter(6, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof RegisteredAnimal) {
					//todo: return empty for now, need to decide what to show in status
					return "";
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
					if(dateSearchController != null){
						filter(dateSearchController.getStartDate(), dateSearchController.getEndDate());	
					}else{
						liveStockTable.updateFromModel();	
					}
					
					
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
						if(dateSearchController != null){
							filter(dateSearchController.getStartDate(), dateSearchController.getEndDate());	
						}else{
							liveStockTable.updateFromModel();	
						}
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
			
			//todo: species filter list, don't know what to put yet, only put "All Species"
			speciesFilterList.clear();
			speciesFilterList.add(ALL_SPECIES);
			
			speciesCombo.bindToModel(new WritableList(speciesFilterList, String.class), String.class, null,
					new WritableValue());
			speciesCombo.updateFromModel();
			speciesCombo.setSelection(0);
			
			//todo: status filter list, put "All Status" for now
			statusFilterList.clear();
			statusFilterList.add(ALL_STATUS);
			statusCombo.bindToModel(new WritableList(statusFilterList, String.class), String.class, null,
					new WritableValue());
			statusCombo.updateFromModel();
			statusCombo.setSelection(0);
			
			
			final List<Farm> farms = member.getFarms();
			for (final Farm farm : farms) {
				animalInput.addAll(farm.getAnimals());
			}
			liveStockTable.updateFromModel();
			liveStockTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
			if(dateSearchController != null){
				filter(dateSearchController.getStartDate(), dateSearchController.getEndDate());
			}
			liveStockTable.addSelectionListener(this);
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
	public List<RegisteredAnimal> filter(String startDate, String endDate) {

		List<RegisteredAnimal> objs = new ArrayList<RegisteredAnimal>();
		if(animalInput == null || animalInput.isEmpty()){
			return objs;
		}
		try {
			final NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
				@Override
				public long longValue(Object object) {
					return ((Date) object).getTime();
				}

				@Override
				public Long adapt(Object value) {
					return longValue(value);
				}
			};


			final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

			SELECT select = null;
			if (startDate != null) {
				// StartDate
				if (!"".equals(startDate)) {
					final Condition startDateCondition = new NumberCondition<Long>(
							ServiceUtils.DATE_FORMAT.parse(startDate).getTime(),
							RelationalOperator.GREATER_THAN_OR_EQUAL_TO,
							dateAdapter);

					final EObjectAttributeValueCondition startDateAttributeCondition = new EObjectAttributeValueCondition(
							TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION,
							startDateCondition);
					condtions.add(startDateAttributeCondition);
				}

			}
			// End Date
			if (endDate != null) {
				if (!"".equals(endDate)) {
					final Condition endDateCondition = new NumberCondition<Long>(
							ServiceUtils.DATE_FORMAT.parse(endDate)
							.getTime() + 86400000l,
							RelationalOperator.LESS_THAN_OR_EQUAL_TO,
							dateAdapter);

					final EObjectAttributeValueCondition endDateAttributeCondition = new EObjectAttributeValueCondition(
							TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION,
							endDateCondition);
					condtions.add(endDateAttributeCondition);
				}
			}
			
			// AND all conditions
			if (condtions.size() > 0) {
				final EObjectCondition first = condtions.get(0);
				EObjectCondition ret = first;
				for (int i = 1; i < condtions.size(); i++) {
					ret = ret.AND(condtions.get(i));
				}
				select = new SELECT(new FROM(animalInput), new WHERE(ret));

			} else {
				select = new SELECT(new FROM(animalInput), new WHERE(
						EObjectCondition.E_TRUE));
			}
			final IQueryResult result = select.execute();
			for (final EObject object : result.getEObjects()) {
				objs.add((RegisteredAnimal) object);
			}
			
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Activator.getDefault().logError(e,e.getMessage());
		}finally{
			liveStockTable.bindToModel(new WritableList(objs, RegisteredAnimal.class), RegisteredAnimal.class,
					liveStockPropertyNames, liveStockColumnHeaders);
			liveStockTable.updateFromModel();

		}
		return objs;
	
	}

}
