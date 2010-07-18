package com.agritrace.edairy.desktop.collection.ui.dialogs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.validation.ValidatorCollection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.IJournalHeaderRidget;
import com.agritrace.edairy.desktop.collection.ui.components.collectionline.ICollectionLineEditRidget;
import com.agritrace.edairy.desktop.collection.ui.components.validators.DuplicateDeliveryValidator;
import com.agritrace.edairy.desktop.collection.ui.controllers.BasicJournalValidator;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class BulkCollectionEntryDialogController extends AbstractWindowController {

	public static final String CONTEXT_JOURNAL_PAGE = "CONTEXT_JOURNAL_PAGE";
	public static final String CONTEXT_PERSISTENCE_DELEGATE = "CONTEXT_PERSISTENCE_DELEGATE";

	private static final String[] columnHeaderNames = { "Line", "Member ID", "Member Name", "CAN Number", "Quantity",
			"MPR Missing", "Rejected" };

	private static final String[] columnPropertyNames = { "lineNumber", "recordedMember",
		 "validatedMember.member.familyName", "farmContainer.containerId", "quantity", "notRecorded", "rejected" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	static IStatus ERROR_STATUS = new Status(Status.ERROR, Activator.PLUGIN_ID, "Invalid membership number");

	static final HashMap<String, String> validatedMemberNames = new HashMap<String, String>();


	private final IDairyRepository dairyRepo;

	// milk Entry group
	private ITableRidget journalEntryTable;
//	private CollectionJournalPage workingJournalPage;
	private IJournalHeaderRidget journalHeaderRidget;
	private ICollectionLineEditRidget collectionLineRidget;
	private ILabelRidget totalLabelRidget;

	private IActionRidget saveAndNewRidget;

	private IActionRidget saveAndCloseRidget;
	private IActionRidget modifyButton;
	private IActionRidget deleteButton;
	private IActionRidget clearButton;

	private final ValidatorCollection journalPageValidators;

	private IActionRidget cancelRidget;

	/**
	 * 
	 */
	public BulkCollectionEntryDialogController() {
		super();
		dairyRepo = DairyRepository.getInstance();
		journalPageValidators = new ValidatorCollection();
		addJournalValidator(new BasicJournalValidator());
		// drivers = dairyRepo.employeesByPosition("Driver");
		// vehicles = dairyRepo.allVehicles();
		// routes = dairyRepo.allRoutes();
	}

	/**
	 * 
	 */
	public void setPersistenceDelegate(JournalPersistenceDelegate persister) {
		setContext(CONTEXT_PERSISTENCE_DELEGATE, persister);
	}

	/**
	 * 
	 */
	public JournalPersistenceDelegate getPersistenceDelegate() {
		return (JournalPersistenceDelegate) getContext(CONTEXT_PERSISTENCE_DELEGATE);
	}

	/**
	 * 
	 */
	public void setContextJournalPage(CollectionJournalPage newPage) {
		setContext(CONTEXT_JOURNAL_PAGE, newPage);
	}

	/**
	 * 
	 */
	public CollectionJournalPage getContextJournalPage() {
		return (CollectionJournalPage) getContext(CONTEXT_JOURNAL_PAGE);
	}

	/**
	 * 
	 */
	public void addJournalValidator(IValidator validator) {
		journalPageValidators.add(validator);
	}

	/**
	 * 
	 */
	public void removeJournalValidator(IValidator validator) {
		journalPageValidators.remove(validator);
	}

	/**
	 * 
	 */
	public IStatus validateJournal(CollectionJournalPage journal) {
		return journalPageValidators.validate(journal);
	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {
		super.configureRidgets();
		System.out.println("configureRidgets : " + this);

		journalHeaderRidget = getRidget(IJournalHeaderRidget.class, "journal-header");
		collectionLineRidget = getRidget(ICollectionLineEditRidget.class, "journal-entry");
		journalEntryTable = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
		modifyButton = getRidget(IActionRidget.class, ViewWidgetId.modifyButton);
		deleteButton = getRidget(IActionRidget.class, ViewWidgetId.deleteButton);
		clearButton = getRidget(IActionRidget.class, ViewWidgetId.clearButton);
		totalLabelRidget = getRidget(ILabelRidget.class, ViewWidgetId.totalLabel);
		
		//
		saveAndNewRidget = getRidget(IActionRidget.class, 	DialogConstants.BIND_ID_BUTTON_SAVE);
		saveAndCloseRidget = getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelRidget = getRidget(IActionRidget.class, 		DialogConstants.BIND_ID_BUTTON_DELETE);

		// config stuff..

		PropertyChangeListener headerValidityListener = new PropertyChangeListener() {			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				boolean isValid = journalHeaderRidget.isHeaderValid();
				log(LogService.LOG_DEBUG, String.format(" --. got header valid event: %s", evt));
				collectionLineRidget.setEnabled(isValid);
				journalHeaderRidget.setEnabled(!isValid);
				if (isValid) {
					collectionLineRidget.requestFocus();
				}
			}
		};
		journalHeaderRidget.addPropertyChangeListener(IJournalHeaderRidget.HEADER_VALID, headerValidityListener);
			log(LogService.LOG_DEBUG, String.format("Header validity listener '%s' added to %s.", headerValidityListener, journalHeaderRidget));

		collectionLineRidget.addValidator(new DuplicateDeliveryValidator(dairyRepo));
		collectionLineRidget.addPropertyChangeListener(ICollectionLineEditRidget.VALIDATED_VALUE,
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						log(LogService.LOG_DEBUG, "CollectionLineRidget event: " + evt);
						CollectionJournalPage workingJournalPage = getContextJournalPage();
						updateJournal(workingJournalPage, (CollectionJournalLine) evt.getNewValue());
						journalEntryTable.updateFromModel();
						totalLabelRidget.updateFromModel();
						resetJournalEntryLine();
					}
				});

		configureJournalEntryTable(journalEntryTable);

		saveAndNewRidget.setText("Save and enter new journal");
		saveAndNewRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleSaveAndNewJournalAction();
			}
		});

		saveAndCloseRidget.setText("Save and quit");
		saveAndCloseRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleSaveAndCloseWindowAction();
			}
		});

		cancelRidget.setText("Cancel");

		initValidators();		
		enableBottomButtons(false);
		
	}

	/**
	 * 
	 */
	protected void configureJournalEntryTable(final ITableRidget table) {
		table.setFocusable(false);
//		table.setColumnFormatter(2, new PersonToFormattedName());

		table.setSelectionType(SelectionType.SINGLE);
		table.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				if (table.getSelection().size() == 0) {
					enableBottomButtons(false);
				} else {
					enableBottomButtons(true);
				}
			}
		});

		// buttons
		modifyButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				// MilkCollectionRecord aRecord = (MilkCollectionRecord)
				// table.getSelection().get(0);
				// ModifyMilkRecordDialog modifyDialog = new
				// ModifyMilkRecordDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
				// aRecord.setLine("");
				// modifyDialog.setRecord(aRecord);
				// if(modifyDialog.open() == Window.OK){
				// table.updateFromModel();
				// totalLabelRidget.updateFromModel();
				// }
			}

		});

		deleteButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (MessageDialog
						.openConfirm(getShell(),
								"Delete Milk Collection Records",
								"Do you want to delete the selected milk collection records?")) {
					final List<Object> selectedRecords = journalEntryTable.getSelection();
					if (selectedRecords != null) {
						// records.removeAll(selectedRecords);
						getContextJournalPage().getJournalEntries().removeAll(selectedRecords);
					}
					updateJournalTotals(); // todo: test
					journalEntryTable.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});

		clearButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (MessageDialog.openConfirm(getShell(),
						"Delete Milk Collection Records", "Do you want to delete all milk collection records?")) {
					// records.clear();
					getContextJournalPage().getJournalEntries().clear();
					updateJournalTotals();
					journalEntryTable.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});

	}
	/**
	 * 
	 */
	@Override
	public void afterBind() {
		super.afterBind();

		System.out.println("afterBind : " + this);

		bindPageRidgets();
		resetJournalEntryLine();
		updateAllRidgetsFromModel();
		setInitialFocus();
	}

	/**
	 * 
	 */
	protected void bindPageRidgets() {
		CollectionJournalPage workingJournalPage = getContextJournalPage();
		journalHeaderRidget.bindToModel(workingJournalPage);

		journalEntryTable.bindToModel(workingJournalPage, "journalEntries", CollectionJournalLine.class,
				columnPropertyNames, columnHeaderNames);

		totalLabelRidget.bindToModel(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL.getName());
		totalLabelRidget.setModelToUIControlConverter(NumberToStringConverter.fromBigDecimal());
	}

	/**
	 * Create a new journal line and set it on the collection line edit control
	 */
	private void resetJournalEntryLine() {
		// todo: binList of route
//		Route currentRoute = workingJournalPage.getRoute();
//		if (currentRoute != null) {
//			collectionLineRidget.setBinList(currentRoute.getBins());
//		}		
		if (collectionLineRidget.getBinList() == null) {
			collectionLineRidget.setBinList(dairyRepo.getLocalDairy().getDairyBins());
		}
		collectionLineRidget.createCollectionLine();
	}

	/**
	 * Set focus to the appropriate widget based on journal state
	 */
	private void setInitialFocus() {
		CollectionJournalPage workingJournalPage = getContextJournalPage();
		if (workingJournalPage != null) {
			final String refNum = workingJournalPage.getReferenceNumber();
			if (refNum == null 
					|| refNum.trim().length() == 0 
					|| !workingJournalPage.eIsSet(DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL)) {
				collectionLineRidget.setEnabled(false);
				journalHeaderRidget.setEnabled(true);
				journalHeaderRidget.requestFocus();
			} else {
				collectionLineRidget.setEnabled(true);
				journalHeaderRidget.setEnabled(false);
				collectionLineRidget.requestFocus();
			}
		}
	}



	/**
	 * Updates the journal with a new journal line (and any calculated attributes).
	 * 
	 * @param journal
	 * @param line
	 */
	protected void updateJournal(CollectionJournalPage journal, CollectionJournalLine line) {
		log(LogService.LOG_DEBUG, "updateJournal: " + journal);
		journal.getJournalEntries().add(line);
		BigDecimal sum = new BigDecimal(0);
		int hasSuspendedLine = 0, hasRejectedLine = 0, hasMPRLine = 0, hasOffRoute = 0;
		for (CollectionJournalLine journalLine : journal.getJournalEntries()) {
			BigDecimal currentTotal = journalLine.getQuantity();
			if(currentTotal!=null)sum =  sum.add(currentTotal);

			if (journalLine.isFlagged())
				hasSuspendedLine++;
			if (journalLine.isRejected())
				hasRejectedLine++;
			if (journalLine.isNotRecorded())
				hasMPRLine++;
			if (journalLine.isOffRoute())
				hasOffRoute++;
		}

		journal.setEntryCount(journal.getJournalEntries().size());
		journal.setRecordTotal(sum);
		journal.setRejectedCount(hasRejectedLine);
		journal.setSuspendedCount(hasSuspendedLine);
		log(LogService.LOG_DEBUG, "updateJournal (after): " + journal);

	}

	/**
	 * Called when 'Save and New' is clicked.
	 */
	protected void handleSaveAndNewJournalAction() {
		if(doSave())
			refreshWorkingJournal();
	}

	/**
	 * Called when 'Save and Close' is clicked.
	 */
	protected void handleSaveAndCloseWindowAction() {
		if(doSave())
			getWindowRidget().dispose();
	}
	
	/**
	 * 
	 */
	private boolean doSave() {
		boolean doSave = true;
		
		CollectionJournalPage workingJournal = getContextJournalPage();
		IStatus validationResult = validateJournal(workingJournal);
		if (!validationResult.isOK()) {
			displayMessage(validationResult);
			return false;
		}
		// Todo: set status in response to events during edit.. 
		if (workingJournal.getEntryCount() > 0) {
			if (workingJournal.getSuspendedCount() > 0 || workingJournal.isSuspended()) {
				workingJournal.setStatus(JournalStatus.SUSPENDED);				
			} else {
				workingJournal.setStatus(JournalStatus.COMPLETE);
			}
		}
		else if (workingJournal.getDriverTotal() != null && workingJournal.getDriverTotal().compareTo(BigDecimal.ZERO) > 0) {
				workingJournal.setStatus(JournalStatus.PENDING);								
		}
		else {
			log(LogService.LOG_WARNING, "doSave: saving questionable journal: " + workingJournal.getReferenceNumber());
		}
		
		if( doSave )
			getPersistenceDelegate().saveJournal(workingJournal);
		
		return doSave;
	}

	/**
	 * 
	 * @param validationResult
	 */
	protected void displayMessage(final IStatus validationResult) {
		StringBuffer message = new StringBuffer();
		Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (IStatus status : statusList) {
			formatter.format("[%s] %s: %s\n", status.getCode(), status.getSeverity(), status.getMessage());
		}
		MessageDialog.openError(getShell(), "Validation Error(s)",
				message.toString());
	}

	/**
	 * 
	 */
	private void refreshWorkingJournal() {
		CollectionJournalPage oldPage = getContextJournalPage();
		CollectionJournalPage newPage = DairyFactory.eINSTANCE.createCollectionJournalPage();
		
		// copy some of the old stuff to the new guy
		EStructuralFeature[] transferFeatures = new EStructuralFeature[] {
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__VEHICLE,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER, };
		for (EStructuralFeature feature : transferFeatures) {
			newPage.eSet(feature, oldPage.eGet(feature));
		}

		// refresh view
		setContextJournalPage(newPage);
		afterBind();
	}

	/**
	 * 
	 */
	protected void initValidators() {
		// todo:
	}


	/**
	 * 
	 * @param enable
	 */
	private void enableBottomButtons(boolean enable) {
		modifyButton.setEnabled(enable);
		deleteButton.setEnabled(enable);
	}

	/**
	 * 
	 */
	private void updateJournalTotals() {
		int counter = 0;
		final BigDecimal total = new BigDecimal(0);

		CollectionJournalPage workingJournalPage = getContextJournalPage();
		for (final CollectionJournalLine line : workingJournalPage.getJournalEntries()) {
			line.setLineNumber(++counter);
			total.add(line.getQuantity());
		}
		workingJournalPage.setRecordTotal(total);
	}

	/**
	 * 
	 */
	protected void updateAllRidgetsFromModel() {

		for (IRidget ridget : getRidgets()) {
			try {
				ridget.updateFromModel();
			} catch (Exception be) {
				System.err.println(be.getMessage() + ": " + ridget);
				be.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	private void dbg(String message) {
		log(LogService.LOG_DEBUG, message);
	}

	/**
	 * 
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
	}
	
	private Shell getShell() {
		Shell shell = null;
		try {
			PlatformUI.getWorkbench().getDisplay().getActiveShell();
		}
		catch(Exception e) {
			shell = Display.getCurrent().getActiveShell();
		}
		return shell;
	}

}
