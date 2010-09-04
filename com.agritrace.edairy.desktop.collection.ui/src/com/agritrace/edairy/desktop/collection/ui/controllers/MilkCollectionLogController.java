package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.collection.ui.beans.MilkCollectionLogFilterBean;
import com.agritrace.edairy.desktop.collection.ui.dialogs.BulkCollectionsEntryDialogController;
import com.agritrace.edairy.desktop.collection.ui.dialogs.BulkCollectionsEntryDialog;
import com.agritrace.edairy.desktop.collection.ui.dialogs.JournalPersistenceDelegate;
import com.agritrace.edairy.desktop.collection.ui.dialogs.NewMilkCollectionJournalDialog;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
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
//			MilkCollectionLogController.this.table.updateFromModel();			
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
					return String.valueOf(page.getDriverTotal());
				case SUSPENDED:
					if (page.getRecordTotal() != null)
						return String.valueOf(page.getRecordTotal());
					else
						return String.valueOf(page.getDriverTotal());
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
	private IToggleButtonRidget suspended;
	private IToggleButtonRidget mprMissing;
	private IToggleButtonRidget rejected;

	private final MilkCollectionLogFilterBean filterBean = new MilkCollectionLogFilterBean();
	private final List<CollectionJournalPage> allJournals = DairyRepository.getInstance().allCollectionJournalPages();;
	private final Color TABLE_HIGHLIGHT_BACKGROUND = PlatformUI.getWorkbench().getDisplay()
			.getSystemColor(SWT.COLOR_YELLOW);

	public MilkCollectionLogController() {
		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL_PAGE);
		
		ICollectionJournalRepository journalRepo = new  MilkCollectionJournalRepository();		
		setRepository(journalRepo);

		addTableColumn("Date", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE);
		// addTableColumn("Route",
		// DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE, new
		// RouteNameFormatter() );

		addTableColumn("Route", "route.name", String.class);
		addTableColumn("Session", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION);
		addTableColumn("Status", "status.name", String.class);
		addTableColumn("Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL, new TotalColumnFormatter());
		addTableColumn("Entry Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL);
		addTableColumn("# Members", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT);
		addTableColumn("# Suspended", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT);
		addTableColumn("# Rejected", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT);

		filterBean.setRoutes(DairyRepository.getInstance().allRoutes());
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
		mprMissing = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);
		suspended = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);
		rejected = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_REJECTED_CHK);

		startDate.bindToModel(filterBean, "startDate");

		endDate.bindToModel(filterBean, "endDate");

		route.bindToModel(new WritableList(DairyRepository.getInstance().allRoutes(), Route.class), Route.class,
				"getName", BeansObservables.observeValue(filterBean, "route"));

		status.bindToModel(new WritableList(JournalStatus.VALUES, JournalStatus.class), JournalStatus.class, "getName",
				BeansObservables.observeValue(filterBean, "status"));

		mprMissing.bindToModel(filterBean, "mprMissing");

		suspended.bindToModel(filterBean, "suspended");

		rejected.bindToModel(filterBean, "rejected");

		updateAllRidgetsFromModel();
	}

	// TODO: make this a query..
	@Override
	protected List<CollectionJournalPage> getFilteredResult() {
		final List<CollectionJournalPage> filteredJournals = new ArrayList<CollectionJournalPage>();

		for (final CollectionJournalPage cj : allJournals) {
			final boolean condition = true;
			// filter logic goes here...
			if (condition) {
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
		cal.roll(Calendar.MONTH, false);
		startDate.setDate(cal.getTime());
		endDate.setDate(new Date());
		route.setSelection(null);
		status.setSelection(null);
		mprMissing.setSelected(false);
		suspended.setSelected(false);
		rejected.setSelected(false);

		updateAllRidgetsFromModel();
	}

	void log(int level, String message, Throwable t) {
		org.eclipse.equinox.log.Logger logger = Log4r.getLogger(Activator.getDefault(), this.getClass().getName());
		logger.log(level, message, t);
	}

	void log(int level, String message) {
		log(level, message, null);
	}

}
