package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.collection.ui.beans.MilkCollectionLogFilterBean;
import com.agritrace.edairy.desktop.collection.ui.dialogs.BulkCollectionsEntryDialog;
import com.agritrace.edairy.desktop.collection.ui.dialogs.JournalPersistenceDelegate;
import com.agritrace.edairy.desktop.collection.ui.dialogs.NewMilkCollectionJournalDialog;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.security.AllPermissions;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(AllPermissions.VIEW_MILK_COLLECTIONS)
public class MilkCollectionLogController extends BasicDirectoryController<CollectionGroup> {

	private final class CollectionLogJournalPersister implements JournalPersistenceDelegate {
		private CollectionLogJournalPersister(BulkCollectionsEntryDialogController controller) {
		}

		@Override
		public void saveJournal(CollectionGroup journal) {
			dairyRepo.getLocalDairy().getCollectionJournals().add(journal);
			dairyRepo.save(dairyRepo.getLocalDairy());
			MilkCollectionLogController.this.refreshTableContents();
		}
	}

	private final class TotalColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionGroup) {
				final CollectionGroup page = (CollectionGroup) element;
				final JournalStatus status = page.getStatus();
				switch (status) {
				case NEW:
				case PENDING:
					if(page.getRecordTotal() != null){
						return String.valueOf(page.getRecordTotal());
					}
					return "ERR";
				case SUSPENDED:

					String result = "";
					if (page.getRecordTotal() != null) {
						result =  String.valueOf(page.getRecordTotal());
					}
					else {
						result =  "ERR";// means there was an error getting the proper result - see #273
					}
					return result;
				case COMPLETE:
				case ARCHIVED:
					return String.valueOf(page.getRecordTotal());
				}
			}

			return super.getText(element);
		}

//		@Override
//		public Color getBackground(Object element) {
//			if (element instanceof CollectionGroup) {
//				final CollectionGroup page = (CollectionGroup) element;
//				if (page.getDriverTotal() != page.getRecordTotal()) {
//					return TABLE_HIGHLIGHT_BACKGROUND;
//				}
//			}
//			return super.getBackground(element);
//		}
	}

	private IDateTimeRidget startDate;
	private IDateTimeRidget endDate;
	private IComboRidget collectionCenter;
	private IComboRidget status;
	private IComboRidget session;
	private IToggleButtonRidget suspended;
	private IToggleButtonRidget mprMissing;
	private IToggleButtonRidget rejected;

	private final MilkCollectionLogFilterBean filterBean = new MilkCollectionLogFilterBean();
	private final IDairyRepository dairyRepo;
	private final IRepository<CollectionSession> sessionRepo;
	private final ScaleImportAction scaleImportAction;
	private final Provider<NewMilkCollectionJournalDialog> newDialogProvider;
	private final Provider<BulkCollectionsEntryDialog> entryDialogProvider;
//	private final Color TABLE_HIGHLIGHT_BACKGROUND = PlatformUI.getWorkbench().getDisplay()
//			.getSystemColor(SWT.COLOR_YELLOW);
	private final List<DairyLocation> collectionCenters;

	@Inject
	public MilkCollectionLogController(final IMilkCollectionRepository journalRepo,
			final IDairyRepository dairyRepo,
			final IRepository<CollectionSession> sessionRepo,
			final ScaleImportAction scaleImportAction,
			final Provider<NewMilkCollectionJournalDialog> newDialogProvider,
			final Provider<BulkCollectionsEntryDialog> entryDialogProvider) {
		setEClass(DairyPackage.Literals.COLLECTION_GROUP);
		setRepository(journalRepo);
		this.dairyRepo = dairyRepo;
		this.scaleImportAction = scaleImportAction;
		this.sessionRepo = sessionRepo;
		this.newDialogProvider = newDialogProvider;
		this.entryDialogProvider = entryDialogProvider;
//		allJournals = dairyRepo.allCollectionGroups();

		addTableColumn("Date", DairyPackage.Literals.COLLECTION_GROUP__JOURNAL_DATE);
		addTableColumn("Collection Center", "collectionCenter.code", String.class);
		addTableColumn("Session", "session.code", String.class);
		addTableColumn("Status", "status.name", String.class);
		addTableColumn("Calculated Total", DairyPackage.Literals.COLLECTION_GROUP__RECORD_TOTAL, new TotalColumnFormatter());
		addTableColumn("Initial Total", DairyPackage.Literals.COLLECTION_GROUP__DRIVER_TOTAL);
		addTableColumn("# Members", DairyPackage.Literals.COLLECTION_GROUP__ENTRY_COUNT);
		addTableColumn("# Suspended", DairyPackage.Literals.COLLECTION_GROUP__SUSPENDED_COUNT);
		addTableColumn("# Rejected", DairyPackage.Literals.COLLECTION_GROUP__REJECTED_COUNT);

		collectionCenters = new ArrayList<DairyLocation>();
		collectionCenters.add(null); // First, empty entry - means "show all"
		collectionCenters.addAll(dairyRepo.getLocalDairy().getBranchLocations());
	}

	@Override
	public void afterBind() {
		super.afterBind();
		getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_NEW_BUTTON).setText("Enter Collection Journals");
		getRidget(IActionRidget.class, "import-file-button").addListener(scaleImportAction);
		getWindowRidget().setTitle(getNavigationNode().getLabel());
	}

	@Override
	protected void configureFilterRidgets() {
		startDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);
		endDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);
		collectionCenter = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_CENTER_COMBO);
		status = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_STATUS_COMBO);
		session = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_SESSION_COMBO);
		mprMissing = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);
		suspended = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);
		rejected = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_REJECTED_CHK);

		startDate.bindToModel(filterBean, "startDate");
		endDate.bindToModel(filterBean, "endDate");

		collectionCenter.bindToModel(new WritableList(collectionCenters, DairyLocation.class), DairyLocation.class,
				"getCode", BeansObservables.observeValue(filterBean, "collectionCenter"));

		final List<JournalStatus> statuses = new ArrayList<JournalStatus>();
		statuses.add(null); // Do not filter by status
		statuses.addAll(JournalStatus.VALUES);

		status.bindToModel(new WritableList(statuses, JournalStatus.class), JournalStatus.class, "getName",
				BeansObservables.observeValue(filterBean, "status"));


		final List<CollectionSession> sessions = new ArrayList<CollectionSession>();
		sessions.add(null); // Do not filter by status
		sessions.addAll(sessionRepo.all());
		session.bindToModel(
				new WritableList(sessions, CollectionSession.class),
				CollectionSession.class,
				"getCode",
				BeansObservables.observeValue(filterBean, "session"));

		mprMissing.bindToModel(filterBean, "mprMissing");
		suspended.bindToModel(filterBean, "suspended");
		rejected.bindToModel(filterBean, "rejected");

		updateAllRidgetsFromModel();
	}

	/**
	 * Checks whether the given journal page matches the given filter conditions.
	 *
	 * @param bean Filter conditions
	 * @param cj Journal page
	 * @return Whether the page matches the conditions
	 */


	// TODO: make this a query..
	@Override
	protected List<CollectionGroup> getFilteredResult() {
		IMilkCollectionRepository groupRepo = (IMilkCollectionRepository) getRepository();
		return groupRepo.findCollectionGroups(
				filterBean.getCollectionCenter(), 
				filterBean.getSession(),
				filterBean.getStartDate(),
				filterBean.getEndDate(),
				filterBean.getStatus(),
				filterBean.isRejected(),
				filterBean.isMprMissing(),
				filterBean.isSuspended()
				);
	}

	@Override
	protected RecordDialog<CollectionGroup> getRecordDialog(Shell shell) {
		throw new UnsupportedOperationException("unsupported");
	}

	@Override
	protected void handleNewItemAction() {
		final NewMilkCollectionJournalDialog dialog = newDialogProvider.get();
		final int returnCode = dialog.open();
		if (Window.OK == returnCode) {
			final CollectionGroup newPage = dialog.getNewJournalPage();
			final BulkCollectionsEntryDialog journalEntryDialog = entryDialogProvider.get();
			final BulkCollectionsEntryDialogController controller = ( BulkCollectionsEntryDialogController)journalEntryDialog.getController();

			controller.setPersistenceDelegate(new CollectionLogJournalPersister(controller));
			controller.setContextJournalPage(newPage);

			journalEntryDialog.open();
		}
		refreshTableContents();
	}

	@Override
	protected void handleViewItemAction() {
		if(table != null && table.getSelection().size()>0){
			final BulkCollectionsEntryDialog journalEntryDialog = entryDialogProvider.get();
			final BulkCollectionsEntryDialogController controller = (BulkCollectionsEntryDialogController)journalEntryDialog.getController();

			controller.setPersistenceDelegate(new CollectionLogJournalPersister(controller));
			controller.setContextJournalPage((CollectionGroup) table.getSelection().get(0));
			journalEntryDialog.open();
		}

	}

	@Override
	protected void resetFilterConditions() {
		Calendar cal = Calendar.getInstance();
		cal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		startDate.setDate(cal.getTime());
		endDate.setDate(new Date());
		collectionCenter.setSelection(null);
		status.setSelection(null);
		session.setSelection(null);
		mprMissing.setSelected(false);
		suspended.setSelected(false);
		rejected.setSelected(false);

		updateAllRidgetsFromModel();
		refreshTableContents();
	}

	void log(int level, String message, Throwable t) {
		final org.eclipse.equinox.log.Logger logger = Log4r.getLogger(Activator.getDefault(), this.getClass().getName());
		logger.log(level, message, t);
	}

	void log(int level, String message) {
		log(level, message, null);
	}

}
