package com.agritrace.edairy.desktop.milkops.ui.intake;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.TransactionException;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.internal.milkops.ui.Activator;
import com.agritrace.edairy.desktop.milkops.ui.intake.beans.MilkCollectionLogFilterBean;
import com.agritrace.edairy.desktop.milkops.ui.intake.collectionline.IMemberLookup;
import com.agritrace.edairy.desktop.milkops.ui.intake.util.JournalPersistenceDelegate;
import com.google.inject.Inject;

@PermissionRequired(UIPermission.VIEW_MILK_COLLECTIONS)
public class MilkCollectionLogController extends BasicDirectoryController<CollectionGroup>
{

	// TODO: convert to standard persistence delegate
	public class NullCollectionLogJournalPersister implements JournalPersistenceDelegate
	{

		@Override
		public void saveJournal(CollectionGroup journal)
		{

		}

	}

	public class CollectionsMemberLookup implements IMemberLookup
	{
		private final HashMap<String, Membership>	memberHash	= new HashMap<String, Membership>();

		public CollectionsMemberLookup(List<Membership> validMembers)
		{
			for (Membership member : validMembers) {
				memberHash.put(member.getMemberNumber(), member);
			}
		}

		@Override
		public Membership getMember(String memberNumber)
		{
			return memberHash.get(memberNumber);
		}

		@Override
		public Collection<String> findAllMemberNumbers(boolean b)
		{
			return memberHash.keySet();
		}

	}

	private final class CollectionLogJournalPersister implements JournalPersistenceDelegate
	{
		private CollectionLogJournalPersister(BulkCollectionsEntryDialogController controller)
		{
		}

		@Override
		public void saveJournal(CollectionGroup journal)
		{
			dairyRepo.getLocalDairy().getCollectionJournals().add(journal);
			dairyRepo.save(journal);
//			dairyRepo.save(dairyRepo.getLocalDairy());
			MilkCollectionLogController.this.refreshTableContents();
		}
	}

	private final class TotalColumnFormatter extends ColumnFormatter
	{
		@Override
		public String getText(Object element)
		{
			if (element instanceof CollectionGroup) {
				final CollectionGroup page = (CollectionGroup) element;
				final JournalStatus status = page.getStatus();
				switch (status) {
				case NEW:
				case PENDING:
					if (page.getRecordTotal() != null) {
						return String.valueOf(page.getRecordTotal());
					}
					return "ERR";
				case SUSPENDED:

					String result = "";
					if (page.getRecordTotal() != null) {
						result = String.valueOf(page.getRecordTotal());
					} else {
						result = "ERR";// means there was an error getting the proper result - see #273
					}
					return result;
				case COMPLETE:
				case ARCHIVED:
					return String.valueOf(page.getRecordTotal());
				}
			}

			return super.getText(element);
		}

// @Override
// public Color getBackground(Object element) {
// if (element instanceof CollectionGroup) {
// final CollectionGroup page = (CollectionGroup) element;
// if (page.getDriverTotal() != page.getRecordTotal()) {
// return TABLE_HIGHLIGHT_BACKGROUND;
// }
// }
// return super.getBackground(element);
// }
	}

	private IDateTimeRidget						startDate;
	private IDateTimeRidget						endDate;
	private IComboRidget						collectionCenter;
	private IComboRidget						status;
	private IComboRidget						session;
	private IToggleButtonRidget					suspended;
	private IToggleButtonRidget					mprMissing;
	private IToggleButtonRidget					rejected;

	private final MilkCollectionLogFilterBean	filterBean	= new MilkCollectionLogFilterBean();
	private final IDairyRepository				dairyRepo;
	private final ScaleImportAction				scaleImportAction;
// private final Color TABLE_HIGHLIGHT_BACKGROUND = PlatformUI.getWorkbench().getDisplay()
// .getSystemColor(SWT.COLOR_YELLOW);
	private final List<DairyLocation>			collectionCenters;
	private Dairy								referenceDairy;

	@Inject
	public MilkCollectionLogController(	final IMilkCollectionRepository journalRepo,
										final IDairyRepository dairyRepo,
										final ScaleImportAction scaleImportAction)
	{
		setEClass(DairyPackage.Literals.COLLECTION_GROUP);
		setRepository(journalRepo);
		this.dairyRepo = dairyRepo;
		this.scaleImportAction = scaleImportAction;
// allJournals = dairyRepo.allCollectionGroups();

		addTableColumn("Date", DairyPackage.Literals.COLLECTION_GROUP__COLLECTION_DATE);
		addTableColumn("Collection Center", "collectionCenter.code", String.class);
		addTableColumn("Session", "session.code", String.class);
		addTableColumn("Status", "status.name", String.class);
		addTableColumn("Calculated Total", DairyPackage.Literals.COLLECTION_GROUP__RECORD_TOTAL,
				new TotalColumnFormatter());
		addTableColumn("Initial Total", DairyPackage.Literals.COLLECTION_GROUP__DRIVER_TOTAL);
		addTableColumn("# Members", DairyPackage.Literals.COLLECTION_GROUP__ENTRY_COUNT);
		addTableColumn("# Suspended", DairyPackage.Literals.COLLECTION_GROUP__SUSPENDED_COUNT);
		addTableColumn("# Rejected", DairyPackage.Literals.COLLECTION_GROUP__REJECTED_COUNT);

		collectionCenters = new ArrayList<DairyLocation>();
		collectionCenters.add(null); // First, empty entry - means "show all"
		collectionCenters.addAll(dairyRepo.getLocalDairy().getBranchLocations());
	}

	@Override
	public void afterBind()
	{
		super.afterBind();
		getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_NEW_BUTTON).setText("Enter Collection Journals");
		getRidget(IActionRidget.class, "import-file-button").addListener(scaleImportAction);
		getWindowRidget().setTitle(getNavigationNode().getLabel());
	}

	@Override
	protected void configureFilterRidgets()
	{
		referenceDairy = (Dairy) getNavigationNode().getParentOfType(ISubApplicationNode.class).getContext("DAIRY");

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
		Dairy contextDairy = (Dairy) getNavigationNode().getParentOfType(ISubApplicationNode.class).getContext("DAIRY");
		sessions.addAll(contextDairy.getCollectionSessions());
		session.bindToModel(new WritableList(sessions, CollectionSession.class), CollectionSession.class, "getCode",
				BeansObservables.observeValue(filterBean, "session"));

		mprMissing.bindToModel(filterBean, "mprMissing");
		suspended.bindToModel(filterBean, "suspended");
		rejected.bindToModel(filterBean, "rejected");

		updateAllRidgetsFromModel();
	}

	/**
	 * Checks whether the given journal page matches the given filter conditions.
	 * 
	 * @param bean
	 *            Filter conditions
	 * @param cj
	 *            Journal page
	 * @return Whether the page matches the conditions
	 */

	// TODO: make this a query..
	@Override
	protected List<CollectionGroup> getFilteredResult()
	{
		IMilkCollectionRepository groupRepo = (IMilkCollectionRepository) getRepository();
		return groupRepo.findCollectionGroups(filterBean.getCollectionCenter(), filterBean.getSession(),
				filterBean.getStartDate(), filterBean.getEndDate(), filterBean.getStatus(), filterBean.isRejected(),
				filterBean.isMprMissing(), filterBean.isSuspended());
	}

	@Override
	protected RecordDialog<CollectionGroup> getRecordDialog(Shell shell)
	{
		throw new UnsupportedOperationException("unsupported");
	}

	@Override
	protected void handleNewItemAction()
	{
		final NewMilkCollectionJournalDialog dialog = new NewMilkCollectionJournalDialog(getShell(), referenceDairy);
		final int returnCode = dialog.open();
		if (Window.OK == returnCode) {
			final CollectionGroup newPage = dialog.getGroupInfo();
			IMemberLookup memberLookup = new CollectionsMemberLookup(dairyRepo.getMembersForRoute(newPage
					.getCollectionCenter()));
			final BulkCollectionsEntryDialogController controller = new BulkCollectionsEntryDialogController(
					referenceDairy, memberLookup);
			controller.setPersistenceDelegate(new CollectionLogJournalPersister(controller));
			controller.setContextJournalPage(newPage);
			controller.setContext("DAIRY", getContext("DAIRY"));
			final BulkCollectionsEntryDialog journalEntryDialog = new BulkCollectionsEntryDialog(getShell(), controller);

			if (Window.OK != journalEntryDialog.open()) {
				throw new TransactionException("Dialog Rollback");
			}
		}
		refreshTableContents();
	}

	@Override
	protected void handleViewItemAction()
	{
		if (table != null && table.getSelection().size() > 0) {

			CollectionGroup selected = (CollectionGroup) table.getSelection().get(0);
			IMemberLookup memberLookup = new CollectionsMemberLookup(dairyRepo.getMembersForRoute(selected
					.getCollectionCenter()));
			final BulkCollectionsEntryDialogController controller = new BulkCollectionsEntryDialogController(
					referenceDairy, memberLookup);
			controller.setPersistenceDelegate(new NullCollectionLogJournalPersister());
			controller.setContextJournalPage((CollectionGroup) table.getSelection().get(0));
			final BulkCollectionsEntryDialog journalEntryDialog = new BulkCollectionsEntryDialog(getShell(), controller);
			journalEntryDialog.open();
		}

	}

	@Override
	protected void resetFilterConditions()
	{
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

	void log(	int level,
				String message,
				Throwable t)
	{
		final org.eclipse.equinox.log.Logger logger = Log4r
				.getLogger(Activator.getDefault(), this.getClass().getName());
		logger.log(level, message, t);
	}

	void log(	int level,
				String message)
	{
		log(level, message, null);
	}

}
