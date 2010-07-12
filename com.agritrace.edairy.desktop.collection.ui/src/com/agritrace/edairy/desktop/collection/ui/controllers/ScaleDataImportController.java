package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.Formatter;
import java.util.HashMap;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget.InfoFlyoutData;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.CollectionsEntryRidget;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class ScaleDataImportController extends SubModuleController {

	public static final String TIME_COLUMNN_HEADER 		= "Timestamp";
	public static final String MEMBER_COLUMN_HEADER 	= "Member";
	public static final String QUANTITY_COLUMN_HEADER 	= "Quantity";
	public static final String CAN_COLUMN_HEADER 		= "CAN Number";
	public static final String NPR_COLUMN_HEADER 		= "NPR Missing";
	public static final String REJECTED_COLUMN_HEADER 	= "Rejected";
	public static final String TOTAL_LABEL 				= "Total : ";

	private static Logger LOG = Log4r.getLogger(Activator.getDefault(), ScaleDataImportController.class);
	static IStatus ERROR_STATUS = new Status(Status.ERROR, Activator.PLUGIN_ID, "Invalid membership number");

	private static final String[] columnHeaders = { 
		TIME_COLUMNN_HEADER, MEMBER_COLUMN_HEADER, CAN_COLUMN_HEADER, QUANTITY_COLUMN_HEADER, NPR_COLUMN_HEADER, REJECTED_COLUMN_HEADER };
	
	private static final ColumnLayoutData[] columnWidths = { 
		new ColumnWeightData(15), new ColumnWeightData(75), new ColumnWeightData(10), new ColumnWeightData(15), new ColumnWeightData(5), new ColumnWeightData(5) };
	
	private static final String[] columnPropertyNames = {
			"collectionTime", "recordedMember", "numCans", "quantity", "centerNumber", "flagged" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	

	static final HashMap<String, String> validatedMemberNames = new HashMap<String, String>();

	
	private final IDairyRepository dairyRepo;

	private CollectionJournalPage importedData; 
	private JournalHeaderRidget journalHeaderRidget;
	private ITableRidget table;
	private ILabelRidget calculatedTotalRidget;
	private CollectionsEntryRidget collectionsEntryRidget;


	/**
	 * 
	 */
	public ScaleDataImportController() {
		super();
		dairyRepo = DairyRepository.getInstance();
//		bins = dairyRepo.allDairyContainers();
		// drivers = dairyRepo.employeesByPosition("Driver");
		// vehicles = dairyRepo.allVehicles();
		// routes = dairyRepo.allRoutes();
	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {

		importedData = getContextData();

		journalHeaderRidget = getRidget(JournalHeaderRidget.class, "journal-header");
		journalHeaderRidget.setOutputOnly(true);
		journalHeaderRidget.bindToModel(importedData);
		journalHeaderRidget.updateFromModel();
				
		table = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
//		table.setColumnFormatter(2, new ColumnFormatter() {
//			@Override
//			public String getText(Object element) {
//				if (element instanceof ScaleImportRecord) {
//					if (((ScaleImportRecord) element).getFarmContainer() != null) {
//						return "" + ((ScaleImportRecord) element).getFarmContainer().getContainerId();
//					}
//				}
//				return null;
//			}
//		});
		table.setColumnWidths(columnWidths);
		table.bindToModel(
				new WritableList(importedData.getJournalEntries(), ScaleImportRecord.class), 
				ScaleImportRecord.class, 
				columnPropertyNames, columnHeaders);
		
		calculatedTotalRidget = getRidget(ILabelRidget.class, ViewWidgetId.totalLabel);
		calculatedTotalRidget.bindToModel(importedData, "driverTotal");

		IActionRidget saveActionRidget = getRidget(IActionRidget.class, ViewWidgetId.saveButton);
		saveActionRidget.setText("Save Imported Data");
		saveActionRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				saveImportedScaleData();
			}
		});
		updateAllRidgetsFromModel();
	}


	/**
	 * 
	 */
	@Override
	public void afterBind() {
		super.afterBind();
	}



	/**
	 * Called when 'Save Page' is clicked.
	 */
	private void saveImportedScaleData() {
		Dairy localDairy  = dairyRepo.getLocalDairy();
		
		getInfoFlyout().addInfo(new InfoFlyoutData("message", "Saving imported scale data..."));
		localDairy.getCollectionJournals().add(importedData);
		dairyRepo.save(localDairy);
		getInfoFlyout().addInfo(new InfoFlyoutData("message", "File saved."));

	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected CollectionJournalPage getContextData() {
		CollectionJournalPage  scaleRecords = null;
		Object contextObj = null;
		final NavigationArgument navArg = getNavigationNode().getNavigationArgument();
		if (navArg != null) {
			contextObj = navArg.getParameter();
		}
		if (contextObj == null) {
			LOG.log(LogService.LOG_WARNING, "Failed to get page from navigation - falling back to context");
			contextObj = getNavigationNode().getContext("IMPORTED_RECORDS");
		}
		if (contextObj instanceof CollectionJournalPage) {
			scaleRecords = (CollectionJournalPage) contextObj;
		} else {
			LOG.log(LogService.LOG_ERROR, "Failed to get imported data from context.");
			throw new IllegalStateException("ERROR: unable to get journal page from context.");
		}
		return scaleRecords;
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


}
