package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.AddAnimalDialog;
import com.agritrace.edairy.desktop.member.ui.views.AddContainerDialog;
import com.agritrace.edairy.desktop.member.ui.views.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionListener;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.CollectionJournal;
import com.agritrace.edairy.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingPackage;

public class MemberSearchViewController extends SubModuleController implements MemberSearchSelectionListener,
	ISelectionListener {

    // private Membership workingCopy;
    private Membership selectedMember;

    // upper panel fields
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
    private IComboRidget provinceComo;
    private ITextRidget postalCodeTxt;

    // container tab
    private ITableRidget containerTable;
    private IActionRidget containerAddButton;
    private IActionRidget containerRemoveButton;
    private final String[] containerPropertyNames = { "containerId", "owner", "type", "measureType", "capacity" };
    private final String[] containerColumnHeaders = { "ID", "Farm", "Container Type", "Units Of Measure", "Capacity" };
    private final List<Container> containerInput = new ArrayList<Container>();
    private IComboRidget farmFilterCombo;
    private IActionRidget containerApplyRidget;
    public static final String containerRemoveTitle = "Remove Containers";
    public static final String containerRemoveMessage = "Do you want to remove selected containers?";
    public static final String ALL_FARM = "All Farms";

    // live stock tab
    private ITableRidget liveStockTable;
    private IActionRidget liveStockAddButton;

    public Membership getSelectedMember() {
	return selectedMember;
    }

    public void setSelectedMember(Membership selectedMember) {
	this.selectedMember = selectedMember;
    }

    private IActionRidget liveStockRemoveButton;
    private final String[] liveStockPropertyNames = { "animnalRegistrationId", "location", "purpose", "givenName",
	    "animalType", "animalType", "dateOfAcquisition", "acquisitionType" };
    private final String[] liveStockColumnHeaders = { "ID", "Farm", "Purpose", "Name", "Species", "Breed",
	    "Acquisition Date", "Acquisition Type" };
    public static final String liveStockRemoveTitle = "Remove Registered Animales";
    public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";
    private final List<RegisteredAnimal> animalInput = new ArrayList<RegisteredAnimal>();

    // farm tab
    private ITableRidget farmTable;
    private IActionRidget farmAddButton;
    private IActionRidget farmRemoveButton;
    private final String[] farmPropertyNames = { "farmId", "name", "location", "numberOfAnimals", "numberOfContainers" };
    private final String[] farmColumnHeaders = { "ID", "Name", "Location", "Number of Animals", "Number of Conatiners" };
    public static final String farmRemoveTitle = "Remove Farm";
    public static final String farmRemoveMessage = "Do you want to remove selected farms?";
    private final List<Farm> farms = new ArrayList<Farm>();

    // collection tab
    private ITableRidget collectionTable;
    private final String[] collectionPropertyNames = { "lineNumber", "collectionJournal", "dairyContainer", "quantity",
	    "notRecorded", "rejected", "flagged" };
    private final String[] collectionColumnHeaders = { "Line", "Date", "Container", "Quantity", "NPR Missing",
	    "Rejected", "Suspended" };
    private final List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();

    // transaction tab
    private ITableRidget transactionTable;
    private final String[] transactionPropertyNames = { "transactionId", "transactionDate", "transactionType",
	    "description", "amount" };
    private final String[] transactionColumnHeaders = { "ID", "Date", "Type", "Description", "Amount" };
    private final List<AccountTransaction> transactionRecords = new ArrayList<AccountTransaction>();

    public MemberSearchViewController() {
	MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
    }

    @Override
    public void configureRidgets() {
	getNavigationNode().addSimpleListener(new MemberSearchNodeListern());
	configureUpperPanel();
	configureFarmTab();
	configureCollectionTab();
	configureLiveStockTab();
	configureContainerTab();
	configureTransactionTab();
	if (selectedMember != null) {
	    updateBindings();
	}

	// search button
	((IActionRidget) getRidget(ViewWidgetId.memberInfo_searchButton)).addListener(new IActionListener() {

	    @Override
	    public void callback() {
		// saveMember();
		MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(true);
	    }
	});

	// save button
	((IActionRidget) getRidget(ViewWidgetId.memberInfo_saveButton)).addListener(new IActionListener() {

	    @Override
	    public void callback() {
		saveMember();
		// MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(false);
	    }
	});
	// cancel button
	((IActionRidget) getRidget(ViewWidgetId.memberInfo_cacelButton)).addListener(new IActionListener() {

	    @Override
	    public void callback() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Cacel modificatin ",
			"Do you want to cacel membership modification?")) {
		    MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
		}
	    }
	});
    }

    private void configureUpperPanel() {
	memberIdRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_id);
	appliedDate = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_applicationDate);
	effectiveDate = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_effectiveDate);
	comboStatus = getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
	comboStatus.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class,
		null, new WritableValue());
	comboStatus.updateFromModel();
	comboStatus.addSelectionListener(this);
	phoneRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_phone);
	nameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName);

	addressTxt = getRidget(ITextRidget.class, ViewWidgetId.ADDRESS_TXT);
	sectionTxt = getRidget(ITextRidget.class, ViewWidgetId.SECTION_TXT);
	estateTxt = getRidget(ITextRidget.class, ViewWidgetId.ESTATE_TXT);
	locationTxt = getRidget(ITextRidget.class, ViewWidgetId.LOCATION_TXT);
	subLocationTxt = getRidget(ITextRidget.class, ViewWidgetId.SUBLOCATION_TXT);
	villageTxt = getRidget(ITextRidget.class, ViewWidgetId.VILLAGE_TXT);
	divisionTxt = getRidget(ITextRidget.class, ViewWidgetId.DIVISION_TXT);
	districtTxt = getRidget(ITextRidget.class, ViewWidgetId.DISTRICT_TXT);
	// provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
	postalCodeTxt = getRidget(ITextRidget.class, ViewWidgetId.POSTAL_CODE_TXT);
	provinceComo = getRidget(IComboRidget.class, ViewWidgetId.PROVINCE_TXT);
	provinceComo.bindToModel(Observables.staticObservableList(Arrays.asList(ViewWidgetId.PROVINCES_LIST)),
		String.class, null, new WritableValue());
	provinceComo.updateFromModel();
	provinceComo.addSelectionListener(this);

    }

    private void configureLiveStockTab() {
	liveStockTable = getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
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

	liveStockAddButton = getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_ADD);
	liveStockAddButton.addListener(new IActionListener() {

	    @Override
	    public void callback() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
			| SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);
		final AddAnimalDialog dialog = new AddAnimalDialog(shell);
		dialog.setMemberShip(selectedMember);
		if (dialog.open() == Window.OK) {
		    final RegisteredAnimal newAnimal = dialog.getNewAnimal();
		    newAnimal.getLocation().getAnimals().add(newAnimal);
		    animalInput.add(newAnimal);
		    liveStockTable.updateFromModel();
		}
	    }
	});

	liveStockRemoveButton = getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_Remove);
	liveStockRemoveButton.setEnabled(false);
	liveStockRemoveButton.addListener(new IActionListener() {

	    @Override
	    public void callback() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), liveStockRemoveTitle,
			liveStockRemoveMessage)) {
		    final List<Object> selections = liveStockTable.getSelection();
		    if (selectedMember != null) {
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

    private void configureContainerTab() {
	containerTable = getRidget(ITableRidget.class, ViewWidgetId.CONTAINER_TABLE);
	containerTable.setColumnFormatter(1, new ColumnFormatter() {

	    @Override
	    public String getText(Object element) {
		if (element instanceof Container) {
		    return ((Container) element).getOwner().getName();
		}
		return null;
	    }
	});
	containerTable.bindToModel(new WritableList(containerInput, Container.class), Container.class,
		containerPropertyNames, containerColumnHeaders);
	containerAddButton = getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_ADD);
	containerAddButton.addListener(new IActionListener() {

	    @Override
	    public void callback() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
			| SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);
		final AddContainerDialog dialog = new AddContainerDialog(shell);
		dialog.setMemberShip(selectedMember);
		if (dialog.open() == Window.OK) {
		    final Container newContainer = dialog.getNewContainer();
		    newContainer.getOwner().getCans().add(newContainer);
		    containerInput.add(newContainer);
		    List<Container> containers;
		    try {
			containers = getContainerFilteredResult();
			containerTable.bindToModel(new WritableList(containers, Container.class), Container.class,
				containerPropertyNames, containerColumnHeaders);
			containerTable.updateFromModel();
		    } catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }

		}
	    }
	});

	containerRemoveButton = getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_Remove);
	containerRemoveButton.setEnabled(false);
	containerRemoveButton.addListener(new IActionListener() {

	    @Override
	    public void callback() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), containerRemoveTitle,
			containerRemoveMessage)) {
		    final List<Object> selections = containerTable.getSelection();
		    if (selectedMember != null) {
			for (final Object selObject : selections) {
			    ((Container) selObject).getOwner().getCans().remove(selObject);
			    containerInput.remove(selObject);
			}
			List<Container> containers;
			try {
			    containers = getContainerFilteredResult();
			    containerTable.bindToModel(new WritableList(containers, Container.class), Container.class,
				    containerPropertyNames, containerColumnHeaders);
			    containerTable.updateFromModel();
			} catch (final ParseException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    }
		}

	    }

	});
	containerApplyRidget = getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_FilterButton);
	containerApplyRidget.addListener(new IActionListener() {

	    @Override
	    public void callback() {
		try {
		    final List<Container> containers = getContainerFilteredResult();
		    containerTable.bindToModel(new WritableList(containers, Container.class), Container.class,
			    containerPropertyNames, containerColumnHeaders);
		    containerTable.updateFromModel();
		} catch (final ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    }

	});
    }

    private void configureFarmTab() {
	farmTable = getRidget(ITableRidget.class, ViewWidgetId.FARM_TABLE);

	farmAddButton = getRidget(IActionRidget.class, ViewWidgetId.FARM_ADD);

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
		    selectedMember.getFarms().add(newFarm);
		    DairyDemoResourceManager.INSTANCE.addFarm(newFarm);
		    farms.add(newFarm);
		    farmTable.updateFromModel();
		}
	    }
	});

	farmRemoveButton = getRidget(IActionRidget.class, ViewWidgetId.FARM_Remove);
	farmRemoveButton.setEnabled(false);
	farmRemoveButton.addListener(new IActionListener() {

	    @Override
	    public void callback() {
		if (MessageDialog
			.openConfirm(Display.getDefault().getActiveShell(), farmRemoveTitle, farmRemoveMessage)) {
		    final List<Object> selections = farmTable.getSelection();
		    if (selectedMember != null) {
			for (final Object selObject : selections) {
			    selectedMember.getFarms().remove(selObject);
			    ((Farm) selObject).getAnimals().clear();
			    ((Farm) selObject).setLocation(null);
			    selectedMember.getFarms().remove((selObject));
			    farms.remove(selObject);
			}

			farmTable.updateFromModel();
		    }
		}

	    }

	});
	farmTable.bindToModel(new WritableList(farms, Farm.class), Farm.class, farmPropertyNames, farmColumnHeaders);

    }

    private void configureCollectionTab() {
	collectionTable = getRidget(ITableRidget.class, ViewWidgetId.COLLECTION_TABLE);
	collectionTable.bindToModel(new WritableList(records, CollectionJournalLine.class),
		CollectionJournalLine.class, collectionPropertyNames, collectionColumnHeaders);

    }

    private void configureTransactionTab() {
	transactionTable = getRidget(ITableRidget.class, ViewWidgetId.TRANSACTION_TABLE);
	transactionTable.bindToModel(new WritableList(transactionRecords, AccountTransaction.class),
		AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);

    }

    private void updateBindings() {
	updateUpperPanelBinding();
	updateFarmBinding();
	updateCollectionBinding();
	updateLiveStockBinding();
	updateContainerBinding();
	updateTransactionBinding();
    }

    private void updateUpperPanelBinding() {
	memberIdRidget.bindToModel(EMFObservables.observeValue(selectedMember,
		DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
	memberIdRidget.updateFromModel();
	comboStatus = getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
	comboStatus.updateFromModel();
	comboStatus.setSelection(selectedMember.getStatus().getValue());
	phoneRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
		ModelPackage.Literals.PARTY__PHONE_NUMBER));
	phoneRidget.updateFromModel();
	nameRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
		ModelPackage.Literals.PARTY__NAME));
	nameRidget.updateFromModel();

	final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
	if (selectedMember.getApplicationDate() != null) {
	    bean.setDate(selectedMember.getApplicationDate());
	}
	appliedDate.setText(bean.getFormattedDate());

	if (selectedMember.getEffectiveDate() != null) {
	    bean.setDate(selectedMember.getEffectiveDate());
	} else {
	    bean.setFormattedDate("");
	}
	effectiveDate.setText(bean.getFormattedDate());

	if (selectedMember.getMember().getLocation() != null) {
	    final PostalLocation location = selectedMember.getMember().getLocation().getPostalLocation();

	    addressTxt.bindToModel(EMFObservables
		    .observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__ADDRESS));
	    addressTxt.updateFromModel();
	    sectionTxt.bindToModel(EMFObservables
		    .observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__SECTION));
	    sectionTxt.updateFromModel();
	    estateTxt.bindToModel(EMFObservables.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__ESTATE));
	    estateTxt.updateFromModel();
	    locationTxt.bindToModel(EMFObservables.observeValue(location,
		    ModelPackage.Literals.POSTAL_LOCATION__LOCATION));
	    locationTxt.updateFromModel();
	    subLocationTxt.bindToModel(EMFObservables.observeValue(location,
		    ModelPackage.Literals.POSTAL_LOCATION__SUB_LOCATION));
	    subLocationTxt.updateFromModel();
	    villageTxt.bindToModel(EMFObservables
		    .observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__VILLAGE));
	    villageTxt.updateFromModel();
	    divisionTxt.bindToModel(EMFObservables.observeValue(location,
		    ModelPackage.Literals.POSTAL_LOCATION__DIVISION));
	    divisionTxt.updateFromModel();
	    districtTxt.bindToModel(EMFObservables.observeValue(location,
		    ModelPackage.Literals.POSTAL_LOCATION__DISTRICT));
	    districtTxt.updateFromModel();
	    provinceComo.setSelection(location.getProvince());
	    postalCodeTxt.bindToModel(EMFObservables.observeValue(location,
		    ModelPackage.Literals.POSTAL_LOCATION__POSTAL_CODE));
	    postalCodeTxt.updateFromModel();
	}
    }

    @Override
    public void memberSelectionChanged(Membership selectedMember) {
	if (this.selectedMember != selectedMember) {
	    this.selectedMember = selectedMember;
	    copySelectedMember();
	}
	updateBindings();
    }

    @Override
    public void memberModified(Membership modifiedMember) {
	this.selectedMember = modifiedMember;
	updateBindings();
    }

    private void copySelectedMember() {
	// if(selectedMember != null){
	// workingCopy = EcoreUtil.copy(selectedMember);
	// }
    }

    protected void saveMember() {
	if (selectedMember != null) {
	    MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);
	    try {
		DairyDemoResourceManager.INSTANCE.saveFarmResource();
		DairyDemoResourceManager.INSTANCE.saveDairyResource();
		MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
	    } catch (final IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (final IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    private void updateLiveStockBinding() {
	animalInput.clear();
	final List<Farm> farms = selectedMember.getFarms();
	for (final Farm farm : farms) {
	    animalInput.addAll(farm.getAnimals());
	}
	liveStockTable.updateFromModel();
	liveStockTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
	liveStockTable.addSelectionListener(this);
    }

    private void updateContainerBinding() {

	containerInput.clear();
	final List<Farm> farms = selectedMember.getFarms();
	final List<String> farmFilterList = new ArrayList<String>();
	farmFilterList.add(ALL_FARM);
	for (final Farm farm : farms) {
	    containerInput.addAll(farm.getCans());
	    if (!farmFilterList.contains(farm.getName())) {
		farmFilterList.add(farm.getName());
	    }
	}
	containerTable.bindToModel(new WritableList(containerInput, Container.class), Container.class,
		containerPropertyNames, containerColumnHeaders);
	containerTable.updateFromModel();
	containerTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
	containerTable.addSelectionListener(this);

	farmFilterCombo = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_FarmCombo);
	farmFilterCombo.bindToModel(new WritableList(farmFilterList, String.class), String.class, null,
		new WritableValue());
	farmFilterCombo.updateFromModel();
    }

    private void updateFarmBinding() {
	farms.clear();
	farms.addAll(selectedMember.getFarms());
	farmTable.updateFromModel();
	farmTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
	farmTable.addSelectionListener(this);
    }

    private void updateCollectionBinding() {
	records.clear();
	records.addAll(getCollectionJournalLines());
	collectionTable.setColumnFormatter(1, new ColumnFormatter() {

	    @Override
	    public String getText(Object element) {
		if (element instanceof CollectionJournalLine) {
		    final Date entryDate = ((CollectionJournalLine) element).getCollectionJournal().getJournalDate();
		    final SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
		    dateFormatter.setDate(entryDate);
		    return dateFormatter.getFormattedDate();
		}
		return null;
	    }
	});
	collectionTable.setColumnFormatter(2, new ColumnFormatter() {

	    @Override
	    public String getText(Object element) {
		if (element instanceof CollectionJournalLine) {
		    if (((CollectionJournalLine) element).getDairyContainer() != null) {
			return ((CollectionJournalLine) element).getDairyContainer().getContainerId();
		    }
		}
		return null;
	    }
	});
	collectionTable.updateFromModel();

    }

    // todo: temporary util method, get a list of collection records
    private List<CollectionJournalLine> getCollectionJournalLines() {
	final List<CollectionJournalLine> collectionJournalRecords = new ArrayList<CollectionJournalLine>();
	if (selectedMember != null) {
	    final String selectedMemberId = selectedMember.getMemberId();
	    final EObject container = selectedMember.eContainer();
	    if (container != null && container instanceof Dairy) {
		final List<CollectionJournal> allRecords = ((Dairy) container).getCollectionJournals();
		for (final CollectionJournal j : allRecords) {
		    final List<CollectionJournalLine> jEntries = j.getJournalEntries();
		    for (final CollectionJournalLine e : jEntries) {
			if (selectedMemberId.equals(e.getRecordedMember())) {
			    collectionJournalRecords.add(e);
			}
		    }
		}
	    }
	}
	return collectionJournalRecords;
	// CollectionJournalLine record =
	// DairyFactory.eINSTANCE.createCollectionJournalLine();
	// record.setLineNumber(10001);
	// record.setRecordedMember(selectedMember.getMemberId());
	// record.setValidatedMember(selectedMember);
	// record.setFarmContainer(selectedMember.getFarms().get(0).getCans().get(0));
	// record.setQuantity(25.2);
	//
	// CollectionJournal journal =
	// DairyFactory.eINSTANCE.createCollectionJournal();
	// SimpleFormattedDateBean date = new
	// SimpleFormattedDateBean("02/20/2010");
	// journal.setJournalDate(date.getDate());
	// record.setCollectionJournal(journal);
	// collectionJournalRecords.add(record);

	// return collectionJournalRecords;

    }

    private void updateTransactionBinding() {
	transactionRecords.clear();
	transactionRecords.addAll(getAccountTransactions());
	transactionTable.setColumnFormatter(1, new ColumnFormatter() {
	    @Override
	    public String getText(Object element) {
		if (element instanceof AccountTransaction) {
		    final Date entryDate = ((AccountTransaction) element).getTransactionDate();
		    final SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
		    dateFormatter.setDate(entryDate);
		    return dateFormatter.getFormattedDate();
		}
		return null;
	    }
	});
	// transactionTable.updateFromModel();
    }

    private List<AccountTransaction> getAccountTransactions() {
	final List<AccountTransaction> transactions = new ArrayList<AccountTransaction>();
	return transactions;
    }

    @Override
    public void ridgetSelected(SelectionEvent event) {
	if (event.getSource() == comboStatus) {
	    if (selectedMember != null) {
		selectedMember.setStatus((MembershipStatus) event.getNewSelection().get(0));
	    }
	} else if (event.getSource() == containerTable) {
	    final List<Object> selection = event.getNewSelection();
	    if (selection.size() > 0) {
		containerRemoveButton.setEnabled(true);
	    } else {
		containerRemoveButton.setEnabled(false);
	    }
	} else if (event.getSource() == liveStockTable) {
	    final List<Object> selection = event.getNewSelection();
	    if (selection.size() > 0) {
		liveStockRemoveButton.setEnabled(true);
	    } else {
		liveStockRemoveButton.setEnabled(false);
	    }
	} else if (event.getSource() == farmTable) {
	    final List<Object> selection = event.getNewSelection();
	    if (selection.size() > 0) {
		farmRemoveButton.setEnabled(true);
	    } else {
		farmRemoveButton.setEnabled(false);
	    }
	} else if (event.getSource() == provinceComo) {
	    if (selectedMember != null && selectedMember.getMember() != null
		    && selectedMember.getMember().getLocation() != null) {
		final PostalLocation location = selectedMember.getMember().getLocation().getPostalLocation();
		if (location != null) {
		    location.setProvince((String) event.getNewSelection().get(0));
		}
	    }
	}

    }

    private List<Container> getContainerFilteredResult() throws ParseException {
	final List<Container> objs = new ArrayList<Container>();
	farmFilterCombo = getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_FarmCombo);

	SELECT select = null;

	final String selectedValue = (String) farmFilterCombo.getSelection();
	if (selectedValue == null || selectedValue.equals(ALL_FARM)) {
	    return containerInput;
	}
	final Condition farmName = new org.eclipse.emf.query.conditions.strings.StringValue(selectedValue);
	final EObjectCondition farmNameCondition = new EObjectAttributeValueCondition(
		TrackingPackage.Literals.FARM__NAME, farmName);
	final EObjectCondition farmCondidtion = new EObjectReferenceValueCondition(
		TrackingPackage.Literals.CONTAINER__OWNER, farmNameCondition);

	select = new SELECT(new FROM(containerInput), new WHERE(farmCondidtion));

	final IQueryResult result = select.execute();
	for (final EObject object : result.getEObjects()) {
	    objs.add((Container) object);
	}

	return objs;
    }

    @Override
    public void refreshView(String viewId) {
	// empty;

    }

    private class MemberSearchNodeListern extends SimpleNavigationNodeAdapter {

	@Override
	public void activated(INavigationNode<?> source) {
	    if (selectedMember != null) {
		updateBindings();
	    }

	}

	@Override
	public void deactivated(INavigationNode<?> source) {

	}

	@Override
	public void disposed(INavigationNode<?> source) {

	}
    }
}
