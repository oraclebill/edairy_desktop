package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.ICollectionLineEditRidget;
import com.agritrace.edairy.desktop.collection.ui.components.IJournalHeaderRidget;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkCollectionJournalController extends SubModuleController {

	private class MemberDeliversOncePerSessionValidator implements IValidator {

		private CollectionJournalPage page;
		private IDairyRepository dairyRepo;

		public MemberDeliversOncePerSessionValidator(CollectionJournalPage page) {
			this(null, page);
		}

		public MemberDeliversOncePerSessionValidator(IDairyRepository dairyRepo, CollectionJournalPage page) {
			this.page = page;
			this.dairyRepo = dairyRepo;
		}

		@Override
		public IStatus validate(Object value) {
			if (page != null) {
				if (page.getJournalEntries().contains(value)) {
					return ValidationStatus.error("Member number cannot appear twice in the same journal.");
				}
				List<CollectionJournalLine> collections = dairyRepo.getMemberCollectionsForSession(page.getSession(),
						(Membership) value);
				if (dairyRepo != null && collections != null && collections.size() > 0) {
					return ValidationStatus.error("Member number appears in a separate journal for this session.");
				}
			}
			return ValidationStatus.ok();
		}
	}

	private static class MemberNumberValidator implements IValidator {
		IDairyRepository dairyRepo;

		public MemberNumberValidator(IDairyRepository dairyRepo) {
			this.dairyRepo = dairyRepo;
		}

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				final String memberNumber = (String) value;
				if (dairyRepo.getMembershipById(memberNumber) != null)
					return ValidationStatus.OK_STATUS;
			}
			return ValidationStatus.error("Member number not found.");
		}
	}


	private static Logger LOG = Log4r.getLogger(Activator.getDefault(), MilkCollectionJournalController.class);

	public static final String TOTAL_LABEL = "Total : ";

	private static final String[] columnHeaderNames = { 
		"Line", "Member ID", "Member Name", "CAN Number", "Quantity", "MPR Missing", "Rejected" };

	private static final String[] columnPropertyNames = {
			"lineNumber", "recordedMember", "validatedMember.member.familyName", "farmContainer.containerId", 
			"quantity", "notRecorded", "rejected" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	
	static IStatus ERROR_STATUS = new Status(Status.ERROR, Activator.PLUGIN_ID, "Invalid membership number");

	static final HashMap<String, String> validatedMemberNames = new HashMap<String, String>();

	private final IDairyRepository dairyRepo;

	private final boolean errorDialogsEnabled = true; // todo: get from

	// milk Entry group
	private ITableRidget journalEntryTable;

	private CollectionJournalPage workingJournalPage;
	private IJournalHeaderRidget journalHeaderRidget;
	private ICollectionLineEditRidget collectionLineRidget;
	private ILabelRidget totalLabelRidget;

	/**
	 * 
	 */
	public MilkCollectionJournalController() {
		super();
		dairyRepo = DairyRepository.getInstance();
		// drivers = dairyRepo.employeesByPosition("Driver");
		// vehicles = dairyRepo.allVehicles();
		// routes = dairyRepo.allRoutes();
	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {
		System.out.println("configureRidgets : " + this);

		journalHeaderRidget = getRidget(IJournalHeaderRidget.class, "journal-header");
		journalHeaderRidget.setOutputOnly(true);

		collectionLineRidget = getRidget(ICollectionLineEditRidget.class, "journal-entry");
		collectionLineRidget.addPropertyChangeListener("validatedValue", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				workingJournalPage.getJournalEntries().add((CollectionJournalLine) evt.getNewValue());
				journalEntryTable.updateFromModel();
				collectionLineRidget.setData(DairyFactory.eINSTANCE.createCollectionJournalLine());
			}

		});

		journalEntryTable = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
		configureJournalEntryTable(journalEntryTable);

		totalLabelRidget = getRidget(ILabelRidget.class, ViewWidgetId.totalLabel);
		
		((IActionRidget) getRidget(ViewWidgetId.saveButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				handleSaveJournalAction();
			}
		});

		updateBottomButtons(false);
	}

	/**
	 * 
	 */
	@Override
	public void afterBind() {
		super.afterBind();
		
		System.out.println("afterBind : " + this);


		// setSubGroupsVisible(false);

		workingJournalPage = getJournalPageFromContext();
		journalHeaderRidget.bindToModel(workingJournalPage);

		collectionLineRidget.setData(DairyFactory.eINSTANCE.createCollectionJournalLine());

		journalEntryTable.bindToModel(workingJournalPage, "journalEntries", CollectionJournalLine.class, columnPropertyNames, columnHeaderNames);

		totalLabelRidget.bindToModel(PojoObservables.observeValue(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL.getName()));
		totalLabelRidget.setModelToUIControlConverter(NumberToStringConverter.fromBigDecimal());

		updateAllRidgetsFromModel();
	}

	/**
	 * 
	 */
	private void configureJournalEntryTable(final ITableRidget table) {
		table.setSelectionType(SelectionType.SINGLE);
		table.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				if (table.getSelection().size() == 0) {
					updateBottomButtons(false);
				} else {
					updateBottomButtons(true);
				}
			}
		});
	
		// buttons

		((IActionRidget) getRidget(ViewWidgetId.modifyButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				// MilkCollectionRecord aRecord = (MilkCollectionRecord)
				// table.getSelection().get(0);
				// ModifyMilkRecordDialog modifyDialog = new
				// ModifyMilkRecordDialog(Display.getDefault().getActiveShell());
				// aRecord.setLine("");
				// modifyDialog.setRecord(aRecord);
				// if(modifyDialog.open() == Window.OK){
				// table.updateFromModel();
				// totalLabelRidget.updateFromModel();
				// }
			}

		});

		((IActionRidget) getRidget(ViewWidgetId.deleteButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records",
						"Do you want to delete the selected milk collection records?")) {
					final List<Object> selectedRecords = journalEntryTable.getSelection();
					if (selectedRecords != null) {
						// records.removeAll(selectedRecords);
						workingJournalPage.getJournalEntries().removeAll(selectedRecords);
					}
					updateJournalTotals(); // todo: test
					journalEntryTable.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.clearButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records",
						"Do you want to delete all milk collection records?")) {
					// records.clear();
					workingJournalPage.getJournalEntries().clear();
					updateJournalTotals();
					journalEntryTable.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});

	}

	/**
	 * Called when 'Save Page' is clicked.
	 */
	private void handleSaveJournalAction() {

		if (!workingJournalPage.getDriverTotal().equals(workingJournalPage.getRecordTotal())) {
			if (!handleTotalsNotEqualOnSave()) {
				return;
			}
		}

		dairyRepo.saveNewJournalPage(workingJournalPage);

		collectionLineRidget.setData(DairyFactory.eINSTANCE.createCollectionJournalLine());
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	private String formatPersonName(Person person) {
		final StringBuffer sb = new StringBuffer();
		if (person != null) {
			new Formatter(sb).format("%s, %s", person.getFamilyName(), person.getGivenName());
		}
		return sb.toString();
	}

	/**
	 * 
	 */
	private CollectionJournalPage getJournalPageFromContext() {
		CollectionJournalPage workingJournalPage = null;
		Object contextObj = null;
		final NavigationArgument navArg = getNavigationNode().getNavigationArgument();
		if (navArg != null) {
			contextObj = navArg.getParameter();
		}
		if (contextObj == null) {
			LOG.log(0, "failed to get page from navigation - falling back to context");
			contextObj = getNavigationNode().getContext("JOURNAL_PAGE");
		}
		if (contextObj instanceof CollectionJournalPage) {
			workingJournalPage = (CollectionJournalPage) contextObj;
		} else {
			LOG.log(0, "ERROR: unable to get journal page from context.");
			throw new IllegalStateException("ERROR: unable to get journal page from context.");
		}
		assert (workingJournalPage != null);
		return workingJournalPage;
	}

	/**
	 * Called when the ID specified is not valid.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return
	 */
	private boolean handleInvalidCanID(final CollectionJournalLine journalLine, final String canId) {
		boolean ret = true;

		if (errorDialogsEnabled) {
			ret = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Error creating journal line",
					"Can't find container for " + canId + ". Do you want to continue create a new record? ");
		}

		// if we choose to continue;
		if (ret) {
			// suspend the record
			journalLine.setFlagged(true);
		}
		return ret;
	}

	/**
	 * 
	 */
	private boolean handleInvalidMemberID(final CollectionJournalLine journalLine, final String memberId) {
		boolean ret = true;
		if (errorDialogsEnabled) {
			ret = MessageDialog
					.openConfirm(
							Display.getDefault().getActiveShell(),
							"Error creating collection journal record!",
							"Can't find valid membership for "
									+ memberId
									+ ". The record will be marked as Suspended. Do you want to continue create a new record? ");
		}
		return ret;
	}

	/**
	 * Called when there is no can id specified.
	 * 
	 * @param journalLine
	 * @return false to abort the current operation (usually the 'save' of a
	 *         journal line)
	 */
	private boolean handleNoCanSpecified(final CollectionJournalLine journalLine) {
		// this is the normal case for now.. in the future, this may be an error
		// or warning.
		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean handleTotalsNotEqualOnSave() {
		MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Save Collection Journal",
				"Journal Total value (" + workingJournalPage.getRecordTotal()
						+ ") doesn't match collection journal records total (" + workingJournalPage.getDriverTotal()
						+ ").");
		return false;
	}

	/**
	 * Called when a can id is not recognized.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return false to abort the current operation (usually the 'save' of a
	 *         journal line)
	 */
	private boolean handleUnregisteredCan(final CollectionJournalLine journalLine, String canId) {

		return true;
	}

	/**
	 * 
	 * @param enable
	 */
	private void updateBottomButtons(boolean enable) {
		((IActionRidget) getRidget(ViewWidgetId.modifyButton)).setEnabled(enable);
		((IActionRidget) getRidget(ViewWidgetId.deleteButton)).setEnabled(enable);
	}

	/**
	 * 
	 */
	private void updateJournalTotals() {
		int counter = 0;
		final BigDecimal total = new BigDecimal(0);

		for (final CollectionJournalLine line : workingJournalPage.getJournalEntries()) {
			line.setLineNumber(++counter);
			total.add(line.getQuantity());
		}
		workingJournalPage.setRecordTotal(total);
	}

}
