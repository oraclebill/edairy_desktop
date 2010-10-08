package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.HashMap;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.log.Logger;
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
import com.agritrace.edairy.desktop.collection.ui.components.journalheader.IJournalHeaderRidget;
import com.agritrace.edairy.desktop.collection.ui.components.journalheader.JournalHeaderRidget;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

public class ScaleImportViewController extends SubModuleController {

	public static final String TIME_COLUMNN_HEADER 		= "Timestamp";
	public static final String MEMBER_COLUMN_HEADER 	= "Member";
	public static final String QUANTITY_COLUMN_HEADER 	= "Quantity";
	public static final String CAN_COLUMN_HEADER 		= "Num. Cans";
	public static final String CENTER_NUMBER_HEADER 	= "Center No.";
	public static final String SUSPENDED_COLUMN_HEADER 	= "Suspended";
	public static final String TOTAL_LABEL 				= "Total : ";

	private static Logger LOG = Log4r.getLogger(Activator.getDefault(), ScaleImportViewController.class);
	static IStatus ERROR_STATUS = new Status(Status.ERROR, Activator.PLUGIN_ID, "Invalid membership number");

	private static final String[] columnHeaders = {
		TIME_COLUMNN_HEADER, MEMBER_COLUMN_HEADER, CAN_COLUMN_HEADER, QUANTITY_COLUMN_HEADER, CENTER_NUMBER_HEADER, SUSPENDED_COLUMN_HEADER };

	private static final String[] columnPropertyNames = {
			"collectionTime", "recordedMember", "numCans", "quantity", "centerNumber", "flagged" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$


	static final HashMap<String, String> validatedMemberNames = new HashMap<String, String>();


	private final IDairyRepository dairyRepo;

	private CollectionGroup importedData;
	private IJournalHeaderRidget journalHeaderRidget;
	private ITableRidget table;
	private ILabelRidget calculatedTotalRidget;
	/**
	 *
	 */
	@Inject
	public ScaleImportViewController(final IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;
	}

	/**
	 *
	 */
	@Override
	public void configureRidgets() {

		importedData = getContextData();

		journalHeaderRidget = getRidget(JournalHeaderRidget.class, "journal-header");
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
		table.bindToModel(
				new WritableList(importedData.getJournalEntries(), ScaleImportRecord.class),
				ScaleImportRecord.class,
				columnPropertyNames, columnHeaders);

		calculatedTotalRidget = getRidget(ILabelRidget.class, ViewWidgetId.totalLabel);
		calculatedTotalRidget.bindToModel(importedData, "driverTotal");

		final IActionRidget cancelAction = getRidget(IActionRidget.class, ViewWidgetId.cancelButton);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				getNavigationNode().dispose();
			}
		});

		final IActionRidget saveActionRidget = getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_SAVE);
//		saveActionRidget.setText("Save Imported Data");
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
		final Dairy localDairy  = dairyRepo.getLocalDairy();

		getInfoFlyout().addInfo(new InfoFlyoutData("message", "Saving imported scale data..."));
		localDairy.getCollectionJournals().add(importedData);
		try {
			dairyRepo.save(localDairy);
			getInfoFlyout().addInfo(new InfoFlyoutData("message", "File saved."));
		}
		catch(final Exception e) {
			getInfoFlyout().addInfo(new InfoFlyoutData("error", "Save failed - " + e.getMessage() + "\nPlease contact support."));
			e.printStackTrace();
		}

	}

	/**
	 *
	 */
	protected CollectionGroup getContextData() {
		CollectionGroup  scaleRecords = null;
		Object contextObj = null;
		final NavigationArgument navArg = getNavigationNode().getNavigationArgument();
		if (navArg != null) {
			contextObj = navArg.getParameter();
		}
		if (contextObj == null) {
			LOG.log(LogService.LOG_WARNING, "Failed to get page from navigation - falling back to context");
			contextObj = getNavigationNode().getContext("IMPORTED_RECORDS");
		}
		if (contextObj instanceof CollectionGroup) {
			scaleRecords = (CollectionGroup) contextObj;
		} else {
			LOG.log(LogService.LOG_ERROR, "Failed to get imported data from context.");
			throw new IllegalStateException("ERROR: unable to get journal page from context.");
		}
		return scaleRecords;
	}


}
