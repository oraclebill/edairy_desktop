package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
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
import org.eclipse.riena.ui.ridgets.listener.ClickEvent;
import org.eclipse.riena.ui.ridgets.listener.IClickListener;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.ridgets.validation.ValidatorCollection;
import org.eclipse.riena.ui.swt.RienaMessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.collectionline.ICollectionLineRidget;
import com.agritrace.edairy.desktop.collection.ui.components.collectionline.IMemberInfoProvider;
import com.agritrace.edairy.desktop.collection.ui.components.journalheader.IJournalHeaderRidget;
import com.agritrace.edairy.desktop.collection.ui.components.validators.DuplicateDeliveryValidator;
import com.agritrace.edairy.desktop.collection.ui.components.validators.MandatoryFieldsCheck;
import com.agritrace.edairy.desktop.collection.ui.components.validators.MemberLookupValidator;
import com.agritrace.edairy.desktop.collection.ui.dialogs.JournalPersistenceDelegate;
import com.agritrace.edairy.desktop.collection.ui.dialogs.MemberCacheProvider;
import com.agritrace.edairy.desktop.collection.ui.dialogs.MemberLookupProvider;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.ContainerValidator;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class BulkCollectionsEntryDialogController extends
		BaseDialogController<CollectionJournalPage> {

	private final class GenericMemberInfo implements IMemberInfoProvider {
		// private final Route currentRoute;
		private final IMemberInfoProvider lookupProvider;
//		private final LRUCache<String, Integer> failed = new LRUCache<String, Integer>();
		private final MemberCacheProvider routeCache;

		private GenericMemberInfo(Route currentRoute,
				IMemberInfoProvider lookupProvider) {
			// this.currentRoute = currentRoute;
			this.lookupProvider = lookupProvider;
			routeCache = new MemberCacheProvider(dairyRepo.getMembersForRoute(currentRoute));
//			failed.setMinimumSize(50);
		}

		@Override
		public Membership getMember(String memberNumber) {
			// fail fast
//			Integer count = failed.get(memberNumber);
//			if (count != null) {
//				count = count + 1;
//				failed.put(memberNumber, count);
//				return null;
//			}
			// lookup in route
			Membership member = routeCache.getMember(memberNumber);
			if (member == null) {
				// lookup in db
				member = lookupProvider.getMember(memberNumber);				
			}
			// fill fail cache
//			if (member == null) {				
//				failed.put(memberNumber, new Integer(1));
//			}
			return member;
		}
	}

	public class RouteMatchValidator implements IValidator {
		Route route;

		RouteMatchValidator(Route route) {
			this.route = route;
		}

		@Override
		public IStatus validate(Object value) {
			boolean pass = false;
			if (value instanceof Membership) {
				Membership member = (Membership) value;
				pass = route.equals(member.getDefaultRoute());
			}
			return pass ? 
					ValidationStatus.ok() : 
						ValidationStatus.error("routes not equal");

		}

	}

	public static final String CONTEXT_JOURNAL_PAGE = "CONTEXT_JOURNAL_PAGE";
	public static final String CONTEXT_PERSISTENCE_DELEGATE = "CONTEXT_PERSISTENCE_DELEGATE";

	private static final String[] columnHeaderNames = { "Line", "Member ID",
			"Member Name", "CAN Number", "Quantity", "MPR Missing", "Rejected",
			"Flagged" };

	private static final String[] columnPropertyNames = {
			"lineNumber",
			"recordedMember",
			"validatedMember.member.familyName", "farmContainer.containerId", "quantity", "notRecorded", "rejected", "flagged" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	static IStatus ERROR_STATUS = new Status(Status.ERROR, Activator.PLUGIN_ID,
			"Invalid membership number");

	static final HashMap<String, String> validatedMemberNames = new HashMap<String, String>();
	private static final Color RED = PlatformUI.getWorkbench().getDisplay()
			.getSystemColor(SWT.COLOR_RED);

	private final IDairyRepository dairyRepo;

	// milk Entry group
	private ITableRidget journalEntryTable;
	// private CollectionJournalPage workingJournalPage;
	private IJournalHeaderRidget journalHeaderRidget;
	private ICollectionLineRidget collectionLineRidget;
	private ILabelRidget totalLabelRidget;

	private IActionRidget saveAndNewRidget;

	private IActionRidget saveAndCloseRidget;
	private IActionRidget modifyButton;
	private IActionRidget deleteButton;
	private IActionRidget clearButton;

	private final ValidatorCollection journalPageValidators;

	private IActionRidget tableDeleteAction;

	/**
	 * 
	 */
	public BulkCollectionsEntryDialogController() {
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
		collectionLineRidget = getRidget(ICollectionLineRidget.class,
				"journal-entry");
		journalEntryTable = getRidget(ITableRidget.class,
				ViewWidgetId.milkEntryTable);
		modifyButton = getRidget(IActionRidget.class, ViewWidgetId.modifyButton);
		deleteButton = getRidget(IActionRidget.class, ViewWidgetId.deleteButton);
		clearButton = getRidget(IActionRidget.class, ViewWidgetId.clearButton);
		totalLabelRidget = getRidget(ILabelRidget.class,
				ViewWidgetId.totalLabel);

		//
		saveAndNewRidget = getRidget(IActionRidget.class,
				DialogConstants.BIND_ID_BUTTON_SAVE);
		saveAndCloseRidget = getRidget(IActionRidget.class,
				DialogConstants.BIND_ID_BUTTON_CANCEL);
		tableDeleteAction = getRidget(IActionRidget.class,
				DialogConstants.BIND_ID_BUTTON_DELETE);

		// config stuff..

		PropertyChangeListener headerValidityListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				boolean isValid = journalHeaderRidget.isHeaderValid();
				log(LogService.LOG_DEBUG,
						String.format(" --. got header valid event: %s", evt));
				collectionLineRidget.setEnabled(isValid);
				journalHeaderRidget.setEnabled(!isValid);
				if (isValid) {
					collectionLineRidget.requestFocus();
				}
			}
		};
		journalHeaderRidget.addPropertyChangeListener(
				IJournalHeaderRidget.HEADER_VALID, headerValidityListener);
		log(LogService.LOG_DEBUG, String.format(
				"Header validity listener '%s' added to %s.",
				headerValidityListener, journalHeaderRidget));

		collectionLineRidget.addPropertyChangeListener(
				ICollectionLineRidget.VALIDATED_VALUE,
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						log(LogService.LOG_DEBUG,
								"CollectionLineRidget event: " + evt);
						CollectionJournalPage workingJournalPage = getContextJournalPage();
						updateJournal(workingJournalPage,
								(CollectionJournalLine) evt.getNewValue());
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

		tableDeleteAction.setEnabled(true);
		enableBottomButtons(false);
		
		if (PrincipalManager.getInstance().hasPermission(Permission.EDIT_DRIVER_TOTAL)) {
			System.out.println("Forcing driver total editable");
			journalHeaderRidget.forceDriverTotalEditable();
		}
	}

	/**
	 * 
	 */
	protected void configureJournalEntryTable(final ITableRidget table) {
		table.setFocusable(false);
		// table.setColumnFormatter(2, new PersonToFormattedName());

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
		table.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "<missing>";
				} else
					return super.getText(element);
			}

			@Override
			public Color getForeground(Object element) {
				if (element == null) {
					return RED;
				} else
					return super.getForeground(element);
			}

		});

		table.setColumnFormatter(5, new BooleanColumnFormatter());
		table.setColumnFormatter(6, new BooleanColumnFormatter());
		table.setColumnFormatter(7, new BooleanColumnFormatter());
		
		table.addClickListener(new IClickListener() {
			@Override
			public void callback(ClickEvent event) {
				if (event.getColumnIndex() == 6) {
					CollectionJournalLine line = (CollectionJournalLine) event.getRow();
					
					if (line != null) {
						line.setRejected(!line.isRejected());
						updateJournalTotals();
						table.updateFromModel();
					}
				}
			}
		});
		
		// buttons
		modifyButton.setVisible(false); // hack.
		modifyButton.setEnabled(false);
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
				if (RienaMessageDialog
						.openConfirm(getShell(),
								"Delete Milk Collection Records",
								"Do you want to delete the selected milk collection records?")) {
					final List<Object> selectedRecords = journalEntryTable
							.getSelection();
					if (selectedRecords != null) {
						final CollectionJournalPage page = getContextJournalPage();
						page.getJournalEntries().removeAll(selectedRecords);
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
				if (RienaMessageDialog.openConfirm(getShell(),
						"Delete Milk Collection Records",
						"Do you want to delete all milk collection records?")) {
					// records.clear();
					getContextJournalPage().getJournalEntries().clear();
					updateJournalTotals();
					journalEntryTable.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});

	}

	class BooleanColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			
				return "";
		}

	}

	
	/**
	 * 
	 */
	@Override
	public void afterBind() {
		super.afterBind();

		System.out.println("afterBind : " + this);

		bindPageRidgets();
		initValidators();
		resetJournalEntryLine();
		
		CollectionJournalPage page = getContextJournalPage();
		int lineCount = page.getJournalEntries().size();
		if (lineCount > 0) {
			CollectionJournalLine lastLine, workingLine;
			lastLine = page.getJournalEntries().get(lineCount-1);
			workingLine = collectionLineRidget.getWorkingCollectionLine();
			if (workingLine != null ) {
				workingLine.setDairyContainer(lastLine.getDairyContainer());
			}
		}
		collectionLineRidget.updateFromModel();
		
		updateAllRidgetsFromModel();
		setInitialFocus();
	}

	private void initValidators() {
		// page relative config
		//
		CollectionJournalPage workingJournalPage = getContextJournalPage();
		// final Route currentRoute = workingJournalPage.getRoute();
		final IMemberInfoProvider lookupProvider = new MemberLookupProvider(dairyRepo);

		collectionLineRidget.clearValidators();
		collectionLineRidget.addValidator(new MandatoryFieldsCheck(
				collectionLineRidget));
		// TODO: RouteMatchValidator
		// collectionLineRidget.setRouteValidator(new RouteMatchValidator(
		//		workingJournalPage.getRoute()));

		// too slow??
		collectionLineRidget.addValidator(new MemberLookupValidator(
				lookupProvider));

		/*
		if (currentRoute != null) {
			// collectionLineRidget.setBinList(dairyRepo.getBinsForRoute(currentRoute));
			// // todo;
//			collectionLineRidget.setMemberInfoProvider(
//					new MemberCacheProvider(dairyRepo.getMembersForRoute(currentRoute)));
			collectionLineRidget.setMemberInfoProvider( new GenericMemberInfo(currentRoute, lookupProvider));
					
		} else { */
			collectionLineRidget.setMemberInfoProvider(lookupProvider);
		// }
		
		collectionLineRidget.setBinList(dairyRepo.getLocalDairy()
				.getDairyBins());

		collectionLineRidget.addValidator(new DuplicateDeliveryValidator(
				workingJournalPage.getJournalEntries(), "Collection Journal"));
		
		final MilkCollectionJournalLineRepository repository = new MilkCollectionJournalLineRepository();
		
		collectionLineRidget.addValidator(new IValidator() {
			@Override
			public IStatus validate(Object value) {
				final CollectionJournalLine line = (CollectionJournalLine) value;
				final Membership member = line.getValidatedMember();
				final DairyLocation center = getContextJournalPage().getCollectionCenter();
				final Date date = getContextJournalPage().getJournalDate();
				
				if (repository.countByMemberCenterDate(member, center, date) > 0) {
					return ValidationStatus.error("Another entry for this member, center and date already exists");
				} else {
					return ValidationStatus.ok();
				}
			}
		});

	}

	/**
	 * 
	 */
	protected void bindPageRidgets() {
		CollectionJournalPage workingJournalPage = getContextJournalPage();
		journalHeaderRidget.bindToModel(workingJournalPage);

		journalEntryTable.bindToModel(workingJournalPage, "journalEntries",
				CollectionJournalLine.class, columnPropertyNames,
				columnHeaderNames);

		totalLabelRidget.bindToModel(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL
						.getName());
		totalLabelRidget.setModelToUIControlConverter(NumberToStringConverter
				.fromBigDecimal());
	}

	/**
	 * Create a new journal line and set it on the collection line edit control
	 */
	private void resetJournalEntryLine() {
		
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
					|| !workingJournalPage
							.eIsSet(DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL)) {
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
	 * Updates the journal with a new journal line (and any calculated
	 * attributes).
	 * 
	 * @param journal
	 * @param line
	 */
	protected void updateJournal(CollectionJournalPage journal,
			CollectionJournalLine line) {
		log(LogService.LOG_DEBUG, "updateJournal: " + journal);
		journal.getJournalEntries().add(line);
		BigDecimal sum = new BigDecimal(0);
		int hasSuspendedLine = 0, hasRejectedLine = 0, hasMPRLine = 0, hasOffRoute = 0;
		for (CollectionJournalLine journalLine : journal.getJournalEntries()) {
			BigDecimal currentTotal = journalLine.getQuantity();
			if (currentTotal != null)
				sum = sum.add(currentTotal);

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
		if (doSave())
			refreshWorkingJournal();
	}

	/**
	 * Called when 'Save and Close' is clicked.
	 */
	protected void handleSaveAndCloseWindowAction() {
		if (isClean(getContextJournalPage())) {
			getWindowRidget().dispose();
		} else if (doSave()) {
			getWindowRidget().dispose();
		}
		// else {
		// suspendCurrentJournal();
		// }
	}

	/**
	 * @return
	 * 
	 */
	protected boolean handleCancelAction() {
		CollectionJournalPage workingJournal = getContextJournalPage();
		if (workingJournal.getJournalEntries().size() > 0
				|| workingJournal.getDriverTotal() != null) {
			boolean ret = RienaMessageDialog
					.openConfirm(getShell(), "Confirm Cancel",
							"The current page has unsaved updates. Are you sure you want to cancel?");
			if (!ret) {
				return false;
			}
		}
		super.handleCancelAction();
		return true;
	}

	private boolean displaySuspendMessage(final IStatus validationResult) {
		boolean ret = false;
		StringBuffer message = new StringBuffer();
		Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (IStatus status : statusList) {
			if (status.matches(IStatus.WARNING | IStatus.INFO)) {
				System.err.printf("[%s] %s: %s\n", status.getClass().getName(),
						status.getSeverity(), status.getMessage());
				formatter.format("%s\n", status.getMessage());
			}
		}
		try {
			formatter
					.format("\n\nSelect 'Yes' to suspend this record, or 'No' to correct the error(s)");
			ret = MessageDialog.openQuestion(getShell(),
					"Suspend Confirmation", message.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(message.toString());
		}
		return ret;
	}
	
	
	
	private void displayActuallyPendingNote() {
		StringBuffer message = new StringBuffer();
		Formatter formatter = new Formatter(message);
		try {
			formatter
					.format("\n\n NOTE the journal will be set to status PENDING, not SUSPENDED, due to empty list of entries");
			MessageDialog.openInformation(getShell(),
					"Pending Confirmation", message.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(message.toString());
		}
	}

	/**
	 * 
	 */
	private boolean doSave() {
		boolean doSave = true;
		
		if (!ContainerValidator.validateContainer(this.journalHeaderRidget).isEmpty())
			return false;

		CollectionJournalPage workingJournal = getContextJournalPage();
		IStatus validationResult = validateJournal(workingJournal);
		if (validationResult.matches(IStatus.CANCEL | IStatus.ERROR)) {
			displayMessage(validationResult);
			return false;
		} else if (validationResult.matches(IStatus.WARNING | IStatus.INFO)) {
			if (!displaySuspendMessage(validationResult)) {
				return false;
			}
			workingJournal.setSuspended(true);
		} else { // Validation passed
			workingJournal.setSuspended(false);
		}
		
		// Todo: set status in response to events during edit..
		if (workingJournal.getEntryCount() > 0) {
			if (workingJournal.getSuspendedCount() > 0
					|| workingJournal.isSuspended()) {
				workingJournal.setStatus(JournalStatus.SUSPENDED);
			} else {
				workingJournal.setStatus(JournalStatus.COMPLETE);
			}
		} else if (workingJournal.getDriverTotal() != null
				&& workingJournal.getDriverTotal().compareTo(BigDecimal.ZERO) > 0) {
			displayActuallyPendingNote();
			workingJournal.setStatus(JournalStatus.PENDING);
		} else {
			log(LogService.LOG_WARNING, "doSave: saving questionable journal: "
					+ workingJournal.getReferenceNumber());
		}

		if (doSave)
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
			formatter.format("[%s] %s: %s\n", status.getCode(),
					status.getSeverity(), status.getMessage());
		}
		RienaMessageDialog.openError(getShell(), "Validation Error(s)",
				message.toString());
	}

	/**
	 * 
	 */
	private void refreshWorkingJournal() {
		CollectionJournalPage oldPage = getContextJournalPage();
		CollectionJournalPage newPage = DairyFactory.eINSTANCE
				.createCollectionJournalPage();

		// copy some of the old stuff to the new guy
		EStructuralFeature[] transferFeatures = new EStructuralFeature[] {
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__COLLECTION_CENTER,
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
		int suspendedCount = 0;
		int rejectedCount = 0;
		BigDecimal total = BigDecimal.ZERO;

		CollectionJournalPage workingJournalPage = getContextJournalPage();
		for (final CollectionJournalLine line : workingJournalPage
				.getJournalEntries()) {
			line.setLineNumber(++counter);
			total = total.add(line.getQuantity());
			if (line.isFlagged()) {
				suspendedCount += 1;
			}
			if (line.isRejected()) {
				rejectedCount += 1;
			}
		}
		workingJournalPage.setRecordTotal(total);
		workingJournalPage.setSuspendedCount(suspendedCount);
		workingJournalPage.setRejectedCount(rejectedCount);
		workingJournalPage.setEntryCount(workingJournalPage.getJournalEntries()
				.size());
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

	private boolean isClean(CollectionJournalPage page) {
		return page != null
				&& page.getJournalEntries().size() == 0
				&& (page.getDriverTotal() == BigDecimal.ZERO || page
						.getDriverTotal() == null);
	}

	/**
	 * 
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
	}

	private Shell getShell() {
		return AbstractDirectoryController.getShell();
	}

}
