package com.agritrace.edairy.riena.member.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
//import org.eclipse.swt.internal.win32.MEASUREITEMSTRUCT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.UnitOfMeasure;
import com.agritrace.edairy.model.dairy.CollectionJournal;
import com.agritrace.edairy.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.riena.member.ui.views.AddAnimalDialog;
import com.agritrace.edairy.riena.member.ui.views.AddContainerDialog;
import com.agritrace.edairy.riena.member.ui.views.MemberSearchSelectionListener;
import com.agritrace.edairy.riena.member.ui.views.MemberSearchSelectionManager;
import com.agritrace.edairy.riena.ui.views.ViewWidgetId;
import com.agritrace.edairy.riena.ui.views.data.SimpleFormattedDateBean;

public class MemberSearchViewController extends SubModuleController implements MemberSearchSelectionListener, ISelectionListener{

	private Membership workingCopy;
	private Membership selectedMember;

	//upper panel fields
	private ITextRidget memberIdRidget;
	private IComboRidget comboStatus;
	private ITextRidget phoneRidget;
	private ITextRidget nameRidget;
	private ITextRidget appliedDate;
	private ITextRidget effectiveDate;

	private ITextRidget addressTxt;
	private ITextRidget sectionTxt;
	private ITextRidget estateTxt;
	private ITextRidget locationTxt;
	private ITextRidget subLocationTxt;
	private ITextRidget villageTxt;
	private ITextRidget divisionTxt;
	private ITextRidget districtTxt;
	private ITextRidget provinceTxt;
	private ITextRidget postalCodeTxt;

	//container tab
	private IComboRidget columnCombo;
	private IComboRidget compareExpression;
	private ITextRidget numberRidget;
	private IComboRidget farmRidget;
	private IComboRidget containterTypeRidget;
	private IComboRidget unitMeasureRidget;
	private IActionRidget filterButton;
	private ITableRidget containerTable;
	private IActionRidget containerAddButton;
	private IActionRidget containerRemoveButton;
	private String[] containerPropertyNames = { "containerId", "owner","type", "units", "measureType","capacity"};
	private String[] containerColumnHeaders = { "ID", "Farm","Container Type", "Units","Units Of Measure","Capacity" }; 
	public static final String containerRemoveTitle="Remove Containers";
	public static final String containerRemoveMessage="Do you want to remove selected containers?";
	private List<Container>containerInput = new ArrayList<Container>();

	//live stock tab
	private ITableRidget liveStockTable;
	private IActionRidget liveStockAddButton;
	private IActionRidget liveStockRemoveButton;
	private String[] liveStockPropertyNames = { "animnalRegistrationId", "location","purpose","givenName","animalType", "dateOfAcquisition", "acquisitionType"};
	private String[] liveStockColumnHeaders = { "ID", "Farm","Purpose", "Name","Type","Acquisition Date","Acquisition Type" };
	public static final String liveStockRemoveTitle="Remove Registered Animales";
	public static final String liveStockRemoveMessage="Do you want to remove selected animals?";
	private List<RegisteredAnimal>animalInput = new ArrayList<RegisteredAnimal>();

	//farm tab
	private ITableRidget farmTable;
	private IActionRidget farmAddButton;
	private IActionRidget farmRemoveButton;
	private String[] farmPropertyNames = { "farmId", "name","location","numberOfAnimals","numberOfContainers"};
	private String[] farmColumnHeaders = { "ID", "Name","Location", "Number of Animals","Number of Conatiners" };
	public static final String farmRemoveTitle="Remove Farm";
	public static final String farmRemoveMessage="Do you want to remove selected farms?";

	//collection tab
	private ITableRidget collectionTable;
	private String[] collectionPropertyNames = { "lineNumber", "collectionJournal","dairyContainer","quantity","notRecorded","rejected","flagged"};
	private String[] collectionColumnHeaders = { "Line", "Date","Container", "Quantity","NPR Missing","Rejected","Suspended" };
	//transaction tab
	private ITableRidget transactionTable;
	private String[] transactionPropertyNames = { "transactionId", "transactionDate","transactionType","description","amount"};
	private String[] transactionColumnHeaders = { "ID", "Date","Type", "Description","Amount"};


	public MemberSearchViewController(){
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}

	@Override
	public void configureRidgets(){
		configureUpperPanel();
		configureFarmTab();
		configureCollectionTab();
		configureLiveStockTab();
		configureContainerTab();
		configureTransactionTab();
		if(selectedMember != null){
			updateBindings();
		}
		
		//search button
		/*((IActionRidget)getRidget(ViewWidgetId.memberInfo_searchButton)).addListener(new IActionListener() {

			public void callback() {
//				saveMember();
				MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(true);
			}
		});*/

		//save button
		((IActionRidget)getRidget(ViewWidgetId.memberInfo_saveButton)).addListener(new IActionListener() {

			public void callback() {
//				saveMember();
				MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(false);
			}
		});
	}

	private void configureUpperPanel(){
		memberIdRidget = getRidget(ITextRidget.class,ViewWidgetId.memberInfo_id);
		appliedDate=getRidget(ITextRidget.class,ViewWidgetId.memberInfo_applicationDate);
		effectiveDate=getRidget(ITextRidget.class,ViewWidgetId.memberInfo_effectiveDate);
		comboStatus = (IComboRidget) getRidget(IComboRidget.class,ViewWidgetId.memberInfo_status);
		comboStatus.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class, null, new WritableValue()); //$NON-NLS-1$ //$NON-NLS-2$
		comboStatus.updateFromModel();
		comboStatus.addSelectionListener(this);
		phoneRidget = getRidget(ITextRidget.class,ViewWidgetId.memberInfo_phone); 
		nameRidget = getRidget(ITextRidget.class,ViewWidgetId.memberInfo_firstName);

		addressTxt=getRidget(ITextRidget.class,ViewWidgetId.ADDRESS_TXT);
		sectionTxt=getRidget(ITextRidget.class,ViewWidgetId.SECTION_TXT);
		estateTxt=getRidget(ITextRidget.class,ViewWidgetId.ESTATE_TXT);
		locationTxt=getRidget(ITextRidget.class,ViewWidgetId.LOCATION_TXT);
		subLocationTxt=getRidget(ITextRidget.class,ViewWidgetId.SUBLOCATION_TXT);
		villageTxt=getRidget(ITextRidget.class,ViewWidgetId.VILLAGE_TXT);
		divisionTxt=getRidget(ITextRidget.class,ViewWidgetId.DIVISION_TXT);
		districtTxt=getRidget(ITextRidget.class,ViewWidgetId.DISTRICT_TXT);
		//		provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
		postalCodeTxt=getRidget(ITextRidget.class,ViewWidgetId.POSTAL_CODE_TXT);
	}

	private void configureLiveStockTab(){
		liveStockTable = getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		liveStockTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof RegisteredAnimal){
					return ((RegisteredAnimal)element).getLocation().getName();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(4, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof RegisteredAnimal){
					return ((RegisteredAnimal)element).getAnimalType().getSpecies();
				}
				return null;
			}
		});

		liveStockTable.setColumnFormatter(5, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof RegisteredAnimal){
					Date acquisitionDate = ((RegisteredAnimal)element).getDateOfAcquisition();
					SimpleFormattedDateBean formatter = new SimpleFormattedDateBean();
					formatter.setDate(acquisitionDate);
					return formatter.getFormattedDate();
				}
				return null;
			}
		});


		liveStockAddButton = getRidget(IActionRidget.class,ViewWidgetId.LIVESTOCK_ADD);
		liveStockAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				Shell shell = new Shell(Display.getDefault(),SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);
				AddAnimalDialog dialog = new AddAnimalDialog(shell);
				dialog.setMemberShip(selectedMember);
				if(dialog.open()==Window.OK){
					RegisteredAnimal newAnimal = dialog.getNewAnimal();
					newAnimal.getLocation().getAnimals().add(newAnimal);
					animalInput.add(newAnimal);
					liveStockTable.updateFromModel();
				}
			}
		});

		liveStockRemoveButton = getRidget(IActionRidget.class,ViewWidgetId.LIVESTOCK_Remove);
		liveStockRemoveButton.setEnabled(false);
		liveStockRemoveButton.addListener(new IActionListener(){

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), liveStockRemoveTitle , liveStockRemoveMessage)){
					List<Object> selections = liveStockTable.getSelection();
					if(selectedMember != null){
						for(Object selObject : selections ){
							((RegisteredAnimal)selObject).getLocation().getAnimals().remove(selObject);
							animalInput.remove(selObject);
						}
						liveStockTable.updateFromModel();
					}
				}
			}
		});
	}
	private void configureContainerTab(){
		/*columnCombo = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_ColumnFilterCombo);
		List<String> comboColumList =  Arrays.asList(new String[] {"ID","Capacity"}); 
		columnCombo.bindToModel(new WritableList(comboColumList, String.class), String.class, null, new WritableValue());
		columnCombo.updateFromModel();
		columnCombo.setSelection(0);
		
		compareExpression = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_CompareExpressionCombo);
		List<String> compareList =  Arrays.asList(new String[] {"=",">","<"}); 
		compareExpression.bindToModel(new WritableList(compareList, String.class), String.class, null, new WritableValue());
		compareExpression.updateFromModel();
    	compareExpression.setSelection(0);
    	
		numberRidget = getRidget(ITextRidget.class,ViewWidgetId.CONTAINER_CompareText);
		numberRidget.setText("*");
		
		farmRidget = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_FarmCombo);
		List<String> farmList =  Arrays.asList(new String[] {"All Farms"}); 
		farmRidget.bindToModel(new WritableList(farmList, String.class), String.class, null, new WritableValue());
		farmRidget.updateFromModel();
		farmRidget.setSelection(0);

		//container search combo
		containterTypeRidget = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_ContainerTypeCombo);
		List<String> typeOfContainerList = new ArrayList<String>();
		typeOfContainerList.add("All Types of Container");

		List<ContainerType> cValues = ContainerType.VALUES;
		for(ContainerType cValue : cValues){
			typeOfContainerList.add(cValue.toString());
		}
		
		containterTypeRidget.bindToModel(new WritableList(typeOfContainerList, String.class), String.class, null, new WritableValue());
		containterTypeRidget.updateFromModel();
		containterTypeRidget.setEmptySelectionItem("All Types of Container");
		containterTypeRidget.setSelection(0);
		//unit search combo
		unitMeasureRidget = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_UnitOfMeasureCombo);
		List<String> unitOfMeasureList = new ArrayList<String>(); 
		unitOfMeasureList.add("All Unit of Measure");

		List<UnitOfMeasure> values = UnitOfMeasure.VALUES;
		for(UnitOfMeasure value : values){
			unitOfMeasureList.add(value.toString());
		}
		unitMeasureRidget.bindToModel(new WritableList(unitOfMeasureList, String.class), String.class, null, new WritableValue());
		unitMeasureRidget.updateFromModel();
		unitMeasureRidget.setEmptySelectionItem("All Units of Measure");
		unitMeasureRidget.setSelection(0);
		
		filterButton = getRidget(IActionRidget.class,ViewWidgetId.CONTAINER_FilterButton);
		
		containerTable = getRidget(ITableRidget.class, ViewWidgetId.CONTAINER_TABLE);
		containerTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof Container){
					return ((Container)element).getOwner().getName();
				}
				return null;
			}
		});*/
		containerAddButton = getRidget(IActionRidget.class,ViewWidgetId.CONTAINER_ADD);
		containerAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				Shell shell = new Shell(Display.getDefault(),SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);
				AddContainerDialog dialog = new AddContainerDialog(shell);
				dialog.setMemberShip(selectedMember);
				if(dialog.open()==Window.OK){
					Container newContainer = dialog.getNewContainer();
					newContainer.getOwner().getCans().add(newContainer);
					containerInput.add(newContainer);
					containerTable.updateFromModel();
				}
			}
		});

		containerRemoveButton = getRidget(IActionRidget.class,ViewWidgetId.CONTAINER_Remove);
		containerRemoveButton.setEnabled(false);
		containerRemoveButton.addListener(new IActionListener(){

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), containerRemoveTitle , containerRemoveMessage)){
					List<Object> selections = containerTable.getSelection();
					if(selectedMember != null){
						for(Object selObject : selections ){
							((Container)selObject).getOwner().getCans().remove(selObject);
							containerInput.remove(selObject);
						}
						containerTable.updateFromModel();
					}
				}


			}

		});
	}

	private void configureFarmTab(){
		farmTable = getRidget(ITableRidget.class, ViewWidgetId.FARM_TABLE);
		farmAddButton = getRidget(IActionRidget.class,ViewWidgetId.FARM_ADD);
		farmAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				//				Shell shell = new Shell(Display.getDefault(),SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX| SWT.APPLICATION_MODAL);
				//				shell.setSize(550, 450);
				//				AddContainerDialog dialog = new AddContainerDialog(shell);
				//				dialog.setMemberShip(selectedMember);
				//				if(dialog.open()==Window.OK){
				//					Container newContainer = dialog.getNewContainer();
				//					newContainer.getOwner().getCans().add(newContainer);
				//					containerInput.add(newContainer);
				//					containerTable.updateFromModel();
				//				}
			}
		});

		farmRemoveButton = getRidget(IActionRidget.class,ViewWidgetId.FARM_Remove);
		farmRemoveButton.setEnabled(false);
		farmRemoveButton.addListener(new IActionListener(){

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), farmRemoveTitle , farmRemoveMessage)){
					List<Object> selections = farmTable.getSelection();
					if(selectedMember != null){
						for(Object selObject : selections ){
							selectedMember.getFarms().remove((Farm)selObject);
						}
						farmTable.updateFromModel();
					}
				}


			}

		});
	}

	private void configureCollectionTab(){
		collectionTable = getRidget(ITableRidget.class, ViewWidgetId.COLLECTION_TABLE);
	}

	private void configureTransactionTab(){
		transactionTable = getRidget(ITableRidget.class, ViewWidgetId.TRANSACTION_TABLE);
	}

	private void updateBindings(){
		updateUpperPanelBinding();
		updateFarmBinding();
		updateCollectionBinding();
		updateLiveStockBinding();
		updateContainerBinding();
		updateTransactionBinding();
	}

	private void updateUpperPanelBinding(){
		memberIdRidget.bindToModel(EMFObservables.observeValue(selectedMember,DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdRidget.updateFromModel();
		comboStatus = (IComboRidget) getRidget(IComboRidget.class,ViewWidgetId.memberInfo_status); //$NON-NLS-1$
		comboStatus.updateFromModel();
		comboStatus.setSelection(selectedMember.getStatus().getValue());
		phoneRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),ModelPackage.Literals.PARTY__PHONE_NUMBER));
		phoneRidget.updateFromModel();
//		nameRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),ModelPackage.Literals.PARTY__NAME));
//		nameRidget.updateFromModel();

		SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		if(workingCopy.getApplicationDate() != null){
			bean.setDate(selectedMember.getApplicationDate());
		}
		appliedDate.setText(bean.getFormattedDate());

		if(workingCopy.getEffectiveDate() != null){
			bean.setDate(selectedMember.getEffectiveDate());
		}else{
			bean.setFormattedDate("");
		}
		effectiveDate.setText(bean.getFormattedDate());

		if(selectedMember.getMember().getLocation() != null){
			PostalLocation location = selectedMember.getMember().getLocation().getPostalLocation();
			
			addressTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__ADDRESS));
			addressTxt.updateFromModel();
			sectionTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__SECTION));
			sectionTxt.updateFromModel();
			estateTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__ESTATE));
			estateTxt.updateFromModel();
			locationTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__LOCATION));
			locationTxt.updateFromModel();
			subLocationTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__SUB_LOCATION));
			subLocationTxt.updateFromModel();
			villageTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__VILLAGE));
			villageTxt.updateFromModel();
			divisionTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__DIVISION));
			divisionTxt.updateFromModel();
			districtTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__DISTRICT));
			districtTxt.updateFromModel();
			//			provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
			postalCodeTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.POSTAL_LOCATION__POSTAL_CODE));
			postalCodeTxt.updateFromModel();
		}
	}

	@Override
	public void memberSelectionChanged(Membership selectedMember) {
		if(this.selectedMember != selectedMember){
			this.selectedMember = selectedMember;
			copySelectedMember();
		}
		updateBindings();
	}

	@Override
	public void memberModified(Membership modifiedMember) {
		// TODO Auto-generated method stub

	}

	private void copySelectedMember(){
		if(selectedMember != null){
			workingCopy = (Membership)EcoreUtil.copy(selectedMember);	
		}



	}
	private void saveMember(){
		if(selectedMember != null){
			MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);	
		}
	}

	private void updateLiveStockBinding(){
		List<Farm> farms = selectedMember.getFarms();
		for(Farm farm :farms){
			animalInput.addAll( farm.getAnimals());	
		}
		liveStockTable.bindToModel(new WritableList(animalInput, RegisteredAnimal.class), RegisteredAnimal.class, liveStockPropertyNames, liveStockColumnHeaders);
		liveStockTable.updateFromModel();
		liveStockTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
		liveStockTable.addSelectionListener(this);
	}

	private void updateContainerBinding(){
		List<Farm> farms = selectedMember.getFarms();
		for(Farm farm :farms){
			containerInput.addAll( farm.getCans());	
		}
		containerTable.bindToModel(new WritableList(containerInput, Container.class), Container.class, containerPropertyNames, containerColumnHeaders);
		containerTable.updateFromModel();
		containerTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
		containerTable.addSelectionListener(this);
	}

	private void updateFarmBinding(){
		List<Farm> farms = selectedMember.getFarms();
		farmTable.bindToModel(new WritableList(farms, Farm.class), Farm.class, farmPropertyNames, farmColumnHeaders);
		farmTable.updateFromModel();
		farmTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
		farmTable.addSelectionListener(this);
	}

	private void updateCollectionBinding(){
		List<CollectionJournalLine> records = getCollectionJournalLines();
		collectionTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof CollectionJournalLine){
					Date entryDate = ((CollectionJournalLine)element).getCollectionJournal().getJournalDate();
					SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
					dateFormatter.setDate(entryDate);
					return dateFormatter.getFormattedDate();
				}
				return null;
			}
		});
		collectionTable.setColumnFormatter(2, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof CollectionJournalLine){
					if(((CollectionJournalLine)element).getDairyContainer() != null){
						return ((CollectionJournalLine)element).getDairyContainer().getContainerId();
					}
				}
				return null;
			}
		});
		collectionTable.bindToModel(new WritableList(records, CollectionJournalLine.class), CollectionJournalLine.class, collectionPropertyNames, collectionColumnHeaders);
		collectionTable.updateFromModel();

	}
	//todo: temporary util method, get a list of collection records
	private List<CollectionJournalLine> getCollectionJournalLines(){
		List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();
		CollectionJournalLine record = DairyFactory.eINSTANCE.createCollectionJournalLine();
		record.setLineNumber(10001);
		record.setRecordedMember(selectedMember.getMemberId());
		record.setValidatedMember(selectedMember);
		record.setFarmContainer(selectedMember.getFarms().get(0).getCans().get(0));
		record.setQuantity(25.2);

		CollectionJournal journal = DairyFactory.eINSTANCE.createCollectionJournal();
		SimpleFormattedDateBean date = new SimpleFormattedDateBean("02/20/2010");
		journal.setJournalDate(date.getDate());
		record.setCollectionJournal(journal);
		records.add(record);

		return records;

	}
	
	private void updateTransactionBinding(){
		List<AccountTransaction> records = getAccountTransactions();
		transactionTable.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if(element instanceof AccountTransaction){
					Date entryDate = ((AccountTransaction)element).getTransactionDate();
					SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
					dateFormatter.setDate(entryDate);
					return dateFormatter.getFormattedDate();
				}
				return null;
			}
		});
		transactionTable.bindToModel(new WritableList(records, AccountTransaction.class), AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);
		transactionTable.updateFromModel();
	}
	
	private List<AccountTransaction> getAccountTransactions(){
		List<AccountTransaction> transactions = new ArrayList<AccountTransaction>();
		return transactions;
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if(event.getSource() == comboStatus){
			if(selectedMember != null){
				selectedMember.setStatus((MembershipStatus)event.getNewSelection().get(0));
			}
		}else if(event.getSource() == containerTable){
			List<Object> selection =  event.getNewSelection();
			if(selection.size() > 0){
				containerRemoveButton.setEnabled(true);
			}else{
				containerRemoveButton.setEnabled(false);
			}
		}else if(event.getSource() == liveStockTable){
			List<Object> selection =  event.getNewSelection();
			if(selection.size() > 0){
				liveStockRemoveButton.setEnabled(true);
			}else{
				liveStockRemoveButton.setEnabled(false);
			}
		}else if(event.getSource() == farmTable){
			List<Object> selection =  event.getNewSelection();
			if(selection.size() > 0){
				farmRemoveButton.setEnabled(true);
			}else{
				farmRemoveButton.setEnabled(false);
			}
		}

	}

}
