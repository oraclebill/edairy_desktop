package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.collection.ui.views.MilkCollectionLogFilterBean;
import com.agritrace.edairy.desktop.collection.ui.views.ViewConstants;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class MilkCollectionLogController extends BasicDirectoryController<CollectionJournal> {
	
	private final MilkCollectionLogFilterBean filterBean = new MilkCollectionLogFilterBean();
	
	private IDateTimeRidget startDate;
	private IDateTimeRidget endDate;
	private IComboRidget route;
	private IToggleButtonRidget mprMissing;
	private IToggleButtonRidget suspended;
	private IToggleButtonRidget rejected;
	
	
	public MilkCollectionLogController() {
		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL);
		setEntityClass(CollectionJournal.class);
		setRepository(new MilkCollectionJournalRepository());
		
		addTableColumn("Date", DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_DATE);
//		addTableColumn("Route", DairyPackage.Literals.COLLECTION_JOURNAL__ROUTE, new RouteNameFormatter() );
		addTableColumn("Route", DairyPackage.Literals.COLLECTION_JOURNAL__ROUTE );
		addTableColumn("Session", DairyPackage.Literals.COLLECTION_JOURNAL__SESSION);
		addTableColumn("Total", DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_ENTRIES);
		addTableColumn("# Members", DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_ENTRIES);
		addTableColumn("# Suspended", DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_ENTRIES);
		addTableColumn("# Rejected", DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_ENTRIES);
		
		filterBean.setRoutes(new DairyRepository().getRoutes());
	}
	
	@Override
	protected void configureFilterRidgets() {
		startDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);
		endDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);
		route = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_ROUTE_COMBO);
		mprMissing = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);
		suspended = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);
		rejected = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_REJECTED_CHK);
		
		startDate.bindToModel(filterBean, "startDate");
		endDate.bindToModel(filterBean, "endDate" );
		route.bindToModel(filterBean, "routes", Route.class, null, filterBean, "route" );
		mprMissing.bindToModel(filterBean, "mprMissing" );
		suspended.bindToModel(filterBean, "suspended" );
		rejected.bindToModel(filterBean, "rejected" );
	}

	@Override
	protected void resetFilterConditions() {
		startDate.setDate(new Date());
		endDate.setDate(new Date());
		route.setSelection(-1);
		mprMissing.setSelected(false);
		suspended.setSelected(false);
		rejected.setSelected(false);
	}
	
	@Override
	protected List<CollectionJournal> getFilteredResult() {
		List<CollectionJournal> allJournals = getRepository().all();
		List<CollectionJournal> filteredJournals = new ArrayList<CollectionJournal>();
		
		for ( CollectionJournal cj : allJournals ) {
			boolean condition = true;
			// filter logic goes here...
			if (condition) {
				filteredJournals.add(cj);
			}
		}
		return filteredJournals;
	}

	@Override
	protected RecordDialog<CollectionJournal, ?> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}


}
