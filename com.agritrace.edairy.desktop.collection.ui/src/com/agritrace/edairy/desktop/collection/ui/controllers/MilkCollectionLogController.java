package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.collection.ui.beans.MilkCollectionLogFilterBean;
import com.agritrace.edairy.desktop.collection.ui.dialogs.BulkCollectionsEntryDialog;
import com.agritrace.edairy.desktop.collection.ui.dialogs.JournalPersistenceDelegate;
import com.agritrace.edairy.desktop.collection.ui.dialogs.NewMilkCollectionJournalDialog;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

@PermissionRequired(Permission.VIEW_MILK_COLLECTIONS)
public class MilkCollectionLogController extends BasicDirectoryController<CollectionJournalPage> {

	private final class CollectionLogJournalPersister implements JournalPersistenceDelegate {
		private CollectionLogJournalPersister(BulkCollectionsEntryDialogController controller) {
		}

		@Override
		public void saveJournal(CollectionJournalPage journal) {
			DairyRepository.getInstance().getLocalDairy().getCollectionJournals().add(journal);
			DairyRepository.getInstance().save(DairyRepository.getInstance().getLocalDairy());
			MilkCollectionLogController.this.refreshTableContents();
		}
	}

	private final class TotalColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalPage) {
				CollectionJournalPage page = (CollectionJournalPage) element;
				JournalStatus status = page.getStatus();
				switch (status) {
				case NEW:
				case PENDING:
					if(page.getRecordTotal() != null){
						return String.valueOf(page.getRecordTotal());
					}
					return "ERR";
				case SUSPENDED:
					
					String result = "";
					if (page.getRecordTotal() != null)
						result =  String.valueOf(page.getRecordTotal());
					else
						result =  "ERR";// means there was an error getting the proper result - see #273					
					return result;
				case COMPLETE:
				case ARCHIVED:
					return String.valueOf(page.getRecordTotal());
				}
			}

			return super.getText(element);
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof CollectionJournalPage) {
				CollectionJournalPage page = (CollectionJournalPage) element;
				if (page.getDriverTotal() != page.getRecordTotal())
					return TABLE_HIGHLIGHT_BACKGROUND;
			}
			return super.getBackground(element);
		}
	}

	private IDateTimeRidget startDate;
	private IDateTimeRidget endDate;
	private IComboRidget route;
	private IComboRidget status;
	private IComboRidget session;
	private IToggleButtonRidget suspended;
	private IToggleButtonRidget mprMissing;
	private IToggleButtonRidget rejected;

	private final MilkCollectionLogFilterBean filterBean = new MilkCollectionLogFilterBean();
	private final List<CollectionJournalPage> allJournals = DairyRepository.getInstance().allCollectionJournalPages();
	private final Color TABLE_HIGHLIGHT_BACKGROUND = PlatformUI.getWorkbench().getDisplay()
			.getSystemColor(SWT.COLOR_YELLOW);

	public MilkCollectionLogController() {
		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL_PAGE);
		
		ICollectionJournalRepository journalRepo = new  MilkCollectionJournalRepository();		
		setRepository(journalRepo);

		addTableColumn("Date", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE);
		addTableColumn("Route", "route.code", String.class);
		addTableColumn("Session", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION);
		addTableColumn("Status", "status.name", String.class);
		addTableColumn("Calculated Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL, new TotalColumnFormatter());
		addTableColumn("Initial Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL);
		addTableColumn("# Members", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT);
		addTableColumn("# Suspended", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT);
		addTableColumn("# Rejected", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT);

		List<Route> routes = new ArrayList<Route>();
		routes.add(null); // First, empty entry - means "show all"
		routes.addAll(DairyRepository.getInstance().allRoutes());
		filterBean.setRoutes(routes);
	}

	@Override
	public void afterBind() {
		super.afterBind();
		getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_NEW_BUTTON).setText("Enter Collection Journals");

		getRidget(IActionRidget.class, "import-file-button").addListener(new ScaleImportAction(this));
	}

	@Override
	protected void configureFilterRidgets() {
		startDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);
		endDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);
		route = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_ROUTE_COMBO);
		status = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_STATUS_COMBO);
		session = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_SESSION_COMBO);
		mprMissing = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);
		suspended = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);
		rejected = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_REJECTED_CHK);

		startDate.bindToModel(filterBean, "startDate");
		endDate.bindToModel(filterBean, "endDate");

		route.bindToModel(new WritableList(filterBean.getRoutes(), Route.class), Route.class,
				"getCode", BeansObservables.observeValue(filterBean, "route"));

		List<JournalStatus> statuses = new ArrayList<JournalStatus>();
		statuses.add(null); // Do not filter by status
		statuses.addAll(JournalStatus.VALUES);
		
		status.bindToModel(new WritableList(statuses, JournalStatus.class), JournalStatus.class, "getName",
				BeansObservables.observeValue(filterBean, "status"));

		
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(null); // Do not filter by status
		sessions.addAll(Observables.staticObservableList(Session.VALUES));
		session.bindToModel(
				new WritableList(sessions, Session.class),
				Session.class,
				"getName",
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
	private static final boolean matches(MilkCollectionLogFilterBean bean, CollectionJournalPage cj) {
		if (bean.getStartDate() != null && cj.getJournalDate().compareTo(bean.getStartDate()) < 0)
			return false;
		
		if (bean.getEndDate() != null) {
			// We need to compare it with the day after, to get records for today as well
			Calendar cld = Calendar.getInstance();
			cld.setTime(bean.getEndDate());
			cld = new GregorianCalendar(cld.get(Calendar.YEAR), cld.get(Calendar.MONTH), cld.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cld.add(Calendar.DAY_OF_MONTH, 1);
			
			if (cj.getJournalDate().compareTo(cld.getTime()) >= 0)
				return false;
		}
		
		if (bean.getRoute() != null && !cj.getRoute().getId().equals(bean.getRoute().getId()))
			return false;
		
		if (bean.getStatus() != null && cj.getStatus() != bean.getStatus())
			return false;
		
		if (bean.getSession() != null && cj.getSession() != bean.getSession())
			return false;
		
		if (bean.isSuspended() && cj.getSuspendedCount() == 0)
			return false;
		
		if (bean.isRejected() && cj.getRejectedCount() == 0)
			return false;
		
		if (bean.isMprMissing()) {
			boolean found = false;
			
			for (CollectionJournalLine line: cj.getJournalEntries()) {
				if (line.isNotRecorded()) {
					found = true;
					break;
				}
			}
			
			if (!found)
				return false;
		}
		
		return true;
	}

	// TODO: make this a query..
	@Override
	protected List<CollectionJournalPage> getFilteredResult() {
		final List<CollectionJournalPage> filteredJournals = new ArrayList<CollectionJournalPage>();

		for (final CollectionJournalPage cj : allJournals) {
			if (matches(filterBean, cj)) {
				filteredJournals.add(cj);
			}
		}
		
		return filteredJournals;
	}

	@Override
	protected RecordDialog<CollectionJournalPage> getRecordDialog(Shell shell) {
		throw new UnsupportedOperationException("unsupported");
	}

	@Override
	protected void handleNewItemAction() {
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		final NewMilkCollectionJournalDialog dialog = new NewMilkCollectionJournalDialog(getShell());
		final int returnCode = dialog.open();
		if (Window.OK == returnCode) {
			final CollectionJournalPage newPage = dialog.getNewJournalPage();			
			BulkCollectionsEntryDialog journalEntryDialog = new BulkCollectionsEntryDialog(shell);
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
			Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
			BulkCollectionsEntryDialog journalEntryDialog = new BulkCollectionsEntryDialog(shell);
			final BulkCollectionsEntryDialogController controller = (BulkCollectionsEntryDialogController)journalEntryDialog.getController(); 

			controller.setPersistenceDelegate(new CollectionLogJournalPersister(controller));
			controller.setContextJournalPage((CollectionJournalPage) table.getSelection().get(0));		
			journalEntryDialog.open();
		}
	
	}

	@Override
	protected void resetFilterConditions() {
		Calendar cal = Calendar.getInstance();
		cal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		startDate.setDate(cal.getTime());
		endDate.setDate(new Date());
		route.setSelection(null);
		status.setSelection(null);
		session.setSelection(null);
		mprMissing.setSelected(false);
		suspended.setSelected(false);
		rejected.setSelected(false);

		updateAllRidgetsFromModel();
		refreshTableContents();
	}

	void log(int level, String message, Throwable t) {
		org.eclipse.equinox.log.Logger logger = Log4r.getLogger(Activator.getDefault(), this.getClass().getName());
		logger.log(level, message, t);
	}

	void log(int level, String message) {
		log(level, message, null);
	}

}
