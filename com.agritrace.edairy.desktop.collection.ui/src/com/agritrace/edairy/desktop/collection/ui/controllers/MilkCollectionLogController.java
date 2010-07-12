package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget.InfoFlyoutData;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.collection.ui.dialogs.NewMilkCollectionJournalDialog;
import com.agritrace.edairy.desktop.collection.ui.views.MilkCollectionJournalView;
import com.agritrace.edairy.desktop.collection.ui.views.ScaleDataImportView;
import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.agritrace.edairy.desktop.collections.scaledata.importer.ScaleImporter;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkCollectionLogController extends BasicDirectoryController<CollectionJournalPage> {

	private final class ScaleImportAction implements IActionListener {
		private IDairyRepository dairyRepo = DairyRepository.getInstance(); 
		private Map<String, CollectionJournalPage> pageMap = new HashMap<String, CollectionJournalPage>();

		@Override
		public void callback() {
			final FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM);
			final String retVal = fileDialog.open();
			File importFile = new File(retVal);
			if (importFile.isFile() && importFile.canRead()) {
				ScaleImporter scaleImporter = new ScaleImporter(importFile);
				try {
					List<ScaleRecord> scaleData = scaleImporter.readRecords().getResults();
					// generate one or more collection groups - one group per scale/date/route/session (driver, vehicle,...)
					for (ScaleRecord scaleRecord : scaleData) {
						ScaleImportRecord importRecord = DairyFactory.eINSTANCE.createScaleImportRecord();
						CollectionJournalPage journalPage = getJournalForScaleRecord(scaleRecord);
						boolean journalConsistent = validateJournalInfo(journalPage, scaleRecord);
						
						// primary data
						importRecord.setCollectionJournal(journalPage);
						importRecord.setRecordedMember(scaleRecord.getMemberNumber());
						importRecord.setQuantity(scaleRecord.getValidQuantity());
						importRecord.setCollectionTime(scaleRecord.getValidDate());
						importRecord.setScaleSerial(scaleRecord.getScaleSerial());
						importRecord.setTripNumber(scaleRecord.getTripNumber());
						importRecord.setValidatedMember(getMemberById(scaleRecord.getMemberNumber()));

						importRecord.setCenterNumber(scaleRecord.getCenterNumber());
						importRecord.setNumCans(scaleRecord.getNumCans());
						importRecord.setOffRoute(false);    	// TODO: calculate
						importRecord.setFrom(null);			// TODO: calculate
						importRecord.setDairyContainer(null);  	// don't seem to get one fromm the scale ??
						importRecord.setFarmContainer(null);	// don't seem to get one fromm the scale ??
						importRecord.setOperatorCode(scaleRecord.getOperatorCode());
						
						boolean dbConsistent = validateDbLookups(importRecord);
								
						importRecord.setFlagged(scaleRecord.isValid() && dbConsistent && journalConsistent );
					}
					for (CollectionJournalPage page : pageMap.values()) {
						
						final ISubModuleNode myNode = getNavigationNode();
						System.err.println("My Node:    " + myNode);
						final ISubModuleNode childNode = createCollectionDetailNode(page);
						System.err.println("Created New Child Node: " + childNode);
						myNode.addChild(childNode);
						// myNode.getNavigationProcessor().navigate(myNode,
						// childNode.getNodeId(), new NavigationArgument(journalPage));
//						try {
//							childNode.activate();
//						} catch (final Exception e) {
//							myNode.removeChild(childNode);
//							e.printStackTrace();
//						}

					}
				} catch (IOException e) {
					// TODO: error message
					getInfoFlyout().addInfo(
							new InfoFlyoutData(null,
									"Error importing scale data. Please contact support for assistance."));
					log(LogService.LOG_ERROR, e.getMessage(), e);
				}
			}
			else {
				Dialog dlg = new ErrorDialog(null, 
						"Error reading file", 
						"The file " + importFile + " can not be read.", 
						new Status(0, Activator.PLUGIN_ID,  
								"File Error"), 0);
				dlg.open();
			}
		}
		
		/**
		 * Validate that lookup fields (memberNumber -> member, routeCode -> route, etc) are not null, 
		 * and all codes and ids in the record exist in the database.
		 * 
		 * @param importRecord
		 * @return
		 */
		private boolean validateDbLookups(ScaleImportRecord importRecord) {
			boolean isConsistent = true;
			// TODO: implement
			return isConsistent;
		}

		/**
		 * Compare the information in a scale record to that of a Collection Journal Page (CollectionGroup). 
		 * Returns false if any of the redundant fields in the scale record are different than the corresponding fields
		 * in the journal page (collection group).
		 * 
		 * @param journalPage
		 * @param scaleRecord
		 * @return
		 */
		private boolean validateJournalInfo(CollectionJournalPage journalPage, ScaleRecord scaleRecord) {
			boolean isConsistent = true;
			// TODO: implement
			return isConsistent;
		}

		private CollectionJournalPage getJournalForScaleRecord(ScaleRecord record) {
			String key = createGroupKey(record);
			CollectionJournalPage page = pageMap.get(key);
			if (page == null) {
				page = DairyFactory.eINSTANCE.createCollectionJournalPage();
				page.setReferenceNumber(key);
				page.setDriver(getDriverByCode(record.getOperatorCode()));
				page.setJournalDate(record.getValidDate());
				page.setSession(getSessionForCode(record.getSessionCode()));
				page.setRoute(getRouteForRouteCode(record.getRouteNumber()));
				if (page.getDriver() == null 
						|| page.getJournalDate() == null 
						|| page.getSession() == null 
						|| page.getRoute() == null ) {
					// TODO: add suspension reason
					page.setSuspended(true);		
					log(LogService.LOG_INFO, "Suspending " + key + " for validation failure - null key item.");
				}
				pageMap.put(key, page);
			}
			return page;
		}
		
		
		private Route getRouteForRouteCode(String routeNumber) {
			// TODO Auto-generated method stub
			return null;
		}

		private Session getSessionForCode(String sessionCode) {
			// TODO Auto-generated method stub
			return null;
		}

		private Employee getDriverByCode(String operatorCode) {
			// TODO Auto-generated method stub
			return null;
		}

		private Membership getMemberById(String memberNumber) {
			// TODO Auto-generated method stub
			return null;
		}


		/**
		 * There should be only one date per scale file, but the key generate will accomodate multiples..
		 * 
		 * @param record
		 * @return
		 */
		private String createGroupKey(ScaleRecord record) {
			StringBuffer buffer = new StringBuffer();
			Formatter formatter = new Formatter(buffer);
			formatter.format("%s-%s-%s-%2s", record.getScaleSerial(), record.getRouteNumber(), record.getTransactionDate(), record.getSessionCode());
			return buffer.toString();
		}
		
		private ISubModuleNode createCollectionDetailNode(CollectionJournalPage journalPage) {
//			getNavigationNode().navigate(
//					new NavigationNodeId("milk-collection-entry-node", journalPage.getReferenceNumber()), //$NON-NLS-1$
//					new NavigationArgument(journalPage));

			final ISubModuleNode detailViewNode = new SubModuleNode(new NavigationNodeId("scale-data-review-node",
					journalPage.getReferenceNumber()), "Scale -" + journalPage.getReferenceNumber()); //$NON-NLS-1$
			detailViewNode.setIcon("scale_detail.gif"); //$NON-NLS-1$
			detailViewNode.setContext("IMPORTED_RECORDS", journalPage);  // backup.. 
			WorkareaManager
					.getInstance()
					.registerDefinition(detailViewNode, ScaleDataImportController.class, ScaleDataImportView.ID)
					.setRequiredPreparation(true);
			return detailViewNode;
		}

	}

	private IDateTimeRidget endDate;
	private final MilkCollectionLogFilterBean filterBean = new MilkCollectionLogFilterBean();
	private IToggleButtonRidget mprMissing;
	private IToggleButtonRidget rejected;
	private IComboRidget route;
	private IDateTimeRidget startDate;

	private IToggleButtonRidget suspended;

	public MilkCollectionLogController() {
		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL_PAGE);
		// setEntityClass(CollectionJournalPage.class);
		setRepository(new MilkCollectionJournalRepository());

		addTableColumn("Date", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE);
		// addTableColumn("Route",
		// DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE, new
		// RouteNameFormatter() );
		addTableColumn("Route", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof Route) {
					final Route route = (Route) element;
					return route.getName();
				} else if (element instanceof CollectionJournalPage) {
					final Route route = ((CollectionJournalPage) element).getRoute();
					if (route != null) {
						return route.getName();
					} else {
						return "(empty)";
					}
				}
				System.err.println("element->class: " + element.getClass());
				return super.getText(element);
			}
		});
		addTableColumn("Session", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION);
		addTableColumn("Driver Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL);
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

		getRidget(IActionRidget.class, "import-file-button").addListener(new ScaleImportAction());

		final ISubModuleNode myNode = getNavigationNode();
		if (myNode != null) {
			myNode.addSimpleListener(new org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter() {

				@Override
				public void activated(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterActivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterDeactivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void beforeActivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void beforeDeactivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void childAdded(INavigationNode<?> source, INavigationNode<?> childAdded) {
					// TODO Auto-generated method stub

				}

				@Override
				public void childRemoved(INavigationNode<?> source, INavigationNode<?> childRemoved) {
					// TODO Auto-generated method stub

				}

				@Override
				public void deactivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void disposed(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void prepared(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

				@Override
				public void selectedChanged(INavigationNode<?> source) {
					// TODO Auto-generated method stub

				}

			});
		}
	}

	private void activateDetailView(CollectionJournalPage journalPage) {
		final ISubModuleNode myNode = getNavigationNode();
		System.err.println("Node:    " + myNode);
		System.err.println("Actions: " + myNode.getActions());
		final ISubModuleNode childNode = createCollectionDetailNode(journalPage);
		System.err.println("Child Node: " + childNode);
		myNode.addChild(childNode);
		// myNode.getNavigationProcessor().navigate(myNode,
		// childNode.getNodeId(), new NavigationArgument(journalPage));
		try {
			childNode.activate();
		} catch (final Exception e) {
			myNode.removeChild(childNode);
			e.printStackTrace();
		}
	}

	private ISubModuleNode createCollectionDetailNode(CollectionJournalPage journalPage) {
		getNavigationNode().navigate(
				new NavigationNodeId("riena.demo.client.customermailfolders.module", journalPage.getReferenceNumber()), //$NON-NLS-1$
				new NavigationArgument(journalPage));

		final ISubModuleNode detailViewNode = new SubModuleNode(new NavigationNodeId("milk-collection-entry-node",
				journalPage.getReferenceNumber()), "Collections Entry for " + journalPage.getReferenceNumber()); //$NON-NLS-1$
		detailViewNode.setIcon("milk_detail.gif"); //$NON-NLS-1$
		detailViewNode.setContext("JOURNAL_PAGE", journalPage);  // backup.. 
		WorkareaManager
				.getInstance()
				.registerDefinition(detailViewNode, MilkCollectionJournalController.class, MilkCollectionJournalView.ID)
				.setRequiredPreparation(true);
		return detailViewNode;
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
		endDate.bindToModel(filterBean, "endDate");
		// route.bindToModel(filterBean, "routes", Route.class, "getName",
		// filterBean, "route");
		route.bindToModel(new WritableList(DairyRepository.getInstance().allRoutes(), Route.class), Route.class,
				"getName", BeansObservables.observeValue(filterBean, "route"));
		System.err.printf("%s, %s, %s, %s\n", new WritableList(DairyRepository.getInstance().allRoutes(), Route.class),
				Route.class, "getName", BeansObservables.observeValue(filterBean, "route"));
		mprMissing.bindToModel(filterBean, "mprMissing");
		suspended.bindToModel(filterBean, "suspended");
		rejected.bindToModel(filterBean, "rejected");

		updateAllRidgetsFromModel();
	}

	@Override
	protected List<CollectionJournalPage> getFilteredResult() {
		final List<CollectionJournalPage> allJournals = getRepository().all();
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
	protected RecordDialog<CollectionJournalPage, ?> getRecordDialog(Shell shell) {
		throw new UnsupportedOperationException("unsupported");
	}

	@Override
	protected void handleNewItemAction() {
		final NewMilkCollectionJournalDialog dialog = new NewMilkCollectionJournalDialog(new Shell());
		// dialog.getController().setContext(EDITED_OBJECT_ID,
		// createNewModel());
		// dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_NEW);

		final int returnCode = dialog.open();
		System.err.println("return code : " + returnCode);
		if (Window.OK == returnCode) {
			final CollectionJournalPage newPage = dialog.getNewJournalPage();
			activateDetailView(newPage);
		}
		refreshTableContents();
	}

	@Override
	protected void handleViewItemAction() {
		// FIXME: demo only!!! - use view page!!
		final CollectionJournalPage newPage = (CollectionJournalPage) table.getSelection().get(0);
		activateDetailView(newPage);
	}

	@Override
	protected void resetFilterConditions() {
		Calendar cal = Calendar.getInstance();
		cal.roll(Calendar.MONTH, false);
		startDate.setDate(cal.getTime());
		endDate.setDate(new Date());
		route.setSelection(null);
		mprMissing.setSelected(false);
		suspended.setSelected(false);
		rejected.setSelected(false);

		updateAllRidgetsFromModel();
	}

	private void log(int level, String message, Throwable t) {
		org.eclipse.equinox.log.Logger logger = Log4r.getLogger(Activator.getDefault(), this.getClass().getName());
		logger.log(level, message, t);
	}

	private void log(int level, String message) {
		log(level, message, null);
	}

}
