package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ISpinnerRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.collection.ui.views.ViewConstants;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.operations.services.collections.CollectionRepository;
import com.agritrace.edairy.desktop.operations.services.collections.ICollectionRepository;

public class MilkCollectionDetailLogController extends BasicDirectoryController<CollectionJournalLine> {

	//	private final MilkCollectionDetailLogFilterBean filterBean = new MilkCollectionDetailLogFilterBean();

	private ITextRidget book;
	private ITextRidget date;
	private ITextRidget session;
	private ITextRidget route;
	private ITextRidget driver;
	private ITextRidget vehicle;

	private ISpinnerRidget currentPage;
	private IActionRidget  backButton;
	private IActionRidget  editButton;
	private IActionRidget  setPageButton;
	private IActionRidget  addPageButton;

	private CollectionJournalPage currentJournalPage;
	private final WritableValue pageValue = new WritableValue(null, Integer.class);
	private final ICollectionRepository journalRepository = new CollectionRepository();


	public MilkCollectionDetailLogController() {
		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL_LINE);
		setEntityClass(CollectionJournalLine.class);
		setRepository(new MilkCollectionJournalLineRepository());

		addTableColumn("Page", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL); //, new CJLPageFormatter() );
		addTableColumn("Line", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__LINE_NUMBER);
		addTableColumn("MemberID", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FROM);
		addTableColumn("CAN", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER);
		addTableColumn("Quantity", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY);
		addTableColumn("Suspended", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FLAGGED);
		addTableColumn("MPR Missing", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED);
		addTableColumn("Rejected", DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED);
	}

	@Override
	protected void configureFilterRidgets() {

		// header text fields
		book = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_BOOK_TXT);
		date = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_DATE_TXT);
		session = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_SESSION_TXT);
		route = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_ROUTE_TXT);
		driver = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_DRIVER_TXT);
		vehicle = getRidget(ITextRidget.class, ViewConstants.COLLECTION_DETAIL_HEADER_VEHICLE_TXT);

		// selection spinner
		currentPage = getRidget(ISpinnerRidget.class, ViewConstants.COLLECTION_DETAIL_FILTER_PAGE_SPIN);

		// buttons
		backButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_BACK_BTN);
		editButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_EDIT_BTN);
		setPageButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_FILTER_BTN);
		addPageButton = getRidget(IActionRidget.class, ViewConstants.COLLECTION_DETAIL_NEW_BTN);
	}

	@Override
	public void afterBind() {
		final INavigationNode<?> node = getNavigationNode();
		final Object journalPage = node.getContext("JOURNAL_PAGE_ID");
		if ((journalPage != null) && (journalPage instanceof String) ) {
			final String pageId = (String) journalPage;
			currentJournalPage = journalRepository.getJournalPage(pageId);
		}

		assert(currentJournalPage != null);

		book.setText(currentJournalPage.getRoute().getName());
		date.setText(DateTimeUtils.DATE_FORMAT.format(currentJournalPage.getJournalDate()));
		session.setText(currentJournalPage.getSession().getName());
		route.setText(currentJournalPage.getRoute().getName());
		driver.setText(currentJournalPage.getDriver().getFamilyName());
		vehicle.setText(currentJournalPage.getVehicle().getLogBookNumber());

		currentPage.bindToModel(pageValue);
		//		currentPage.getValue()
		setPageButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				refreshTableContents();
			}
		});
		backButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				throw new UnsupportedOperationException("Unimplemnented.");
			}
		});
		editButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				throw new UnsupportedOperationException("Unimplemnented.");
			}
		});
		addPageButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				throw new UnsupportedOperationException("Unimplemnented.");
			}
		});
	}


	@Override
	protected void resetFilterConditions() {
		if (currentPage != null) {
			currentPage.setValue(1);
		}
	}

	@Override
	protected List<CollectionJournalLine> getFilteredResult() {
		if (currentJournalPage == null ) {
			return Collections.EMPTY_LIST;
		}
		final List<CollectionJournalLine> allJournalLines = currentJournalPage.getJournalEntries();
		final List<CollectionJournalLine> filteredJournals = new ArrayList<CollectionJournalLine>();

		for ( final CollectionJournalLine cj : allJournalLines ) {
			final boolean condition = true;
			// filter logic goes here...
			if (condition) {
				filteredJournals.add(cj);
			}
		}
		return filteredJournals;
	}

	@Override
	protected RecordDialog<CollectionJournalLine, ?> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}


}
