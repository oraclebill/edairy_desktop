package com.agritrace.edairy.desktop.milkops.ui.controllers;
//package com.agritrace.edairy.desktop.milkops.ui.controllers;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.eclipse.core.databinding.observable.value.WritableValue;
//import org.eclipse.riena.navigation.INavigationNode;
//import org.eclipse.riena.navigation.NavigationArgument;
//import org.eclipse.riena.ui.ridgets.IActionListener;
//import org.eclipse.riena.ui.ridgets.IActionRidget;
//import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
//import org.eclipse.riena.ui.ridgets.ISpinnerRidget;
//import org.eclipse.riena.ui.ridgets.ITextRidget;
//import org.eclipse.swt.widgets.Shell;
//
//import com.agritrace.edairy.desktop.milkops.ui.ViewConstants;
//import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
//import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
//import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
//import com.agritrace.edairy.desktop.common.persistence.ICollectionJournalLineRepository;
//import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
//import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
//import com.google.inject.Inject;
//
//public class MilkCollectionDetailLogController extends BasicDirectoryController<CollectionJournalLine> {
//
//	// navigation & control
//	private IActionRidget backButton;
//
//	// private final MilkCollectionDetailLogFilterBean filterBean = new
//	// MilkCollectionDetailLogFilterBean();
//
//	// header group ridgets
//	private ITextRidget book;
//	// working journal page
//	private CollectionGroup currentJournalPage;
//	// journal page
//	private ISpinnerRidget currentPage;
//	private IDateTimeRidget date;
//	private ITextRidget driver;
//	private IActionRidget editButton;
//
//
//	// UI infrastructure
//	private final WritableValue pageValue = new WritableValue(1, Integer.class);
//	private ITextRidget route;
//	private ITextRidget session;
//
//	private IActionRidget setPageButton;
//
//	private ITextRidget vehicle;
//
//	@Inject
//	public MilkCollectionDetailLogController(ICollectionJournalLineRepository repository) {
//		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL_LINE);
//		// setEntityClass(CollectionJournalLine.class);
//		setRepository(repository);
//
//		addTableColumn("Page", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL);
//		addTableColumn("Line", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__LINE_NUMBER);
//		addTableColumn("MemberID", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FROM);
//		addTableColumn("CAN", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER);
//		addTableColumn("Quantity", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY);
//		addTableColumn("Suspended", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FLAGGED);
//		addTableColumn("MPR Missing", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED);
//		addTableColumn("Rejected", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED);
//	}
//
//	@Override
//	public void afterBind() {
//		// important?
//		super.afterBind();
//		//
//		CollectionGroup currentJournalPage;
//		final INavigationNode<?> node = getNavigationNode();
//		final NavigationArgument argument = node.getNavigationArgument();
//		Object journalPage = argument.getParameter();
//		if (journalPage == null) {
//
//			journalPage = node.getContext("JOURNAL_PAGE");
//		}
//		if (journalPage != null && journalPage instanceof CollectionGroup) {
//			currentJournalPage = (CollectionGroup) journalPage;
//		} else {
//			throw new IllegalStateException("Journal editor requires context setting 'JOURNAL_PAGE' with current page");
//		}
//
//		// book.setText(currentJournalPage.getRoute().getName());
//		book.setOutputOnly(true);
//
//		date.setDate(currentJournalPage.getJournalDate());
//		date.setOutputOnly(true);
//
//		session.setText(currentJournalPage.getSession().getCode());
//		session.setOutputOnly(true);
//
//		// route.setText(currentJournalPage.getRoute().getName());
//		route.setOutputOnly(true);
//
//		driver.setText(currentJournalPage.getDriver().getFamilyName());
//		driver.setOutputOnly(true);
//
//		vehicle.setText(currentJournalPage.getVehicle().getLogBookNumber());
//		vehicle.setOutputOnly(true);
//
//		currentPage.bindToModel(pageValue);
//
//		// updateAllRidgetsFromModel();
//
//		// currentPage.getValue()
//		setPageButton.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				refreshTableContents();
//			}
//		});
//		backButton.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				getNavigationNode().getParent().activate();
//			}
//		});
//		editButton.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				throw new UnsupportedOperationException("Unimplemnented.");
//			}
//		});
//	}
//
//	@Override
//	protected void configureFilterRidgets() {
//
//		// header text fields
//		book = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_BOOK_TXT);
//		date = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_DATE_TXT);
//		session = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_SESSION_TXT);
//		route = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_ROUTE_TXT);
//		driver = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_DRIVER_TXT);
//		vehicle = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_VEHICLE_TXT);
//
//		// selection spinner
//		currentPage = getRidget(ISpinnerRidget.class, ViewConstants.COLLECTION_DETAIL_FILTER_PAGE_SPIN);
//
//		// buttons
//		backButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_BACK_BTN);
//		editButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_EDIT_BTN);
//		setPageButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_FILTER_BTN);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	protected List<CollectionJournalLine> getFilteredResult() {
//		if (currentJournalPage == null) {
//			return Collections.EMPTY_LIST;
//		}
//		final List<CollectionJournalLine> allJournalLines = currentJournalPage.getJournalEntries();
//		final List<CollectionJournalLine> filteredJournals = new ArrayList<CollectionJournalLine>();
//
//		for (final CollectionJournalLine cj : allJournalLines) {
//			final boolean condition = true;
//			// filter logic goes here...
//			if (condition) {
//				filteredJournals.add(cj);
//			}
//		}
//		return filteredJournals;
//	}
//
//	@Override
//	protected RecordDialog<CollectionJournalLine> getRecordDialog(Shell shell) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected void resetFilterConditions() {
//		if (currentPage != null) {
//			currentPage.setValue(1);
//		}
//	}
//
//}
