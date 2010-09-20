package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.agritrace.edairy.desktop.collections.scaledata.importer.ScaleImporter;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.services.dairylocation.IDairyLocationRepository;

final class ScaleImportAction implements IActionListener {

	private class ScaleImportProcess extends UIProcess {
		/**
		 * 4 hours in milliseconds
		 */
		private static final long MAX_COLLECTION_TIME_DIFFERENTIAL = 1000 * 60 * 4;

		File importFile;
		// int lineCount;

		private List<String> msgList;
		private Map<String, List<Object>> errMessages;

		public ScaleImportProcess(File importFile, Object context) {
			super("Scale Import", true, context);
			this.importFile = importFile;
			// this.lineCount = scaleData.size();

			msgList = new LinkedList<String>();
			errMessages = new HashMap<String, List<Object>>();
		}

		@Override
		public void initialUpdateUI(int totalWork) {
			super.initialUpdateUI(totalWork);
		}

		@Override
		public boolean runJob(IProgressMonitor monitor) {
			int fileSize = (int) importFile.length();
			double quantum = 1.0d;
			double multiple = 1.0d;

			monitor.beginTask("Importing...", fileSize * 2);

			setNote("Reading raw data...");

			final ScaleImporter scaleImporter = new ScaleImporter(importFile);
			final List<ScaleRecord> scaleData = new LinkedList<ScaleRecord>();
			try {
				scaleData.addAll(scaleImporter.readRecords().getResults());
				quantum = (double) fileSize / (double) scaleData.size();

				// we don't want to report status more than 100 times, since
				// synchronization with UI thread is costly..
				if (scaleData.size() > 100) {
					multiple = scaleData.size() / 100;
					quantum = quantum * multiple;
				}
			} catch (IOException ioe) {
				msgList.add("Error reading raw data: " + ioe.getMessage());
			}

			// account for time reading file into scaleRecords
			monitor.worked(fileSize);
			setNote("Processing...");

			// generate one or more collection groups - one group per
			// scale/date/route/session (driver, vehicle,...)

			int intQuantum = (int) quantum;
			int counter = 0;
			for (ScaleRecord scaleRecord : scaleData) {
				if (monitor.isCanceled()) {
					return false;
				}
				CollectionGroup journalPage = getJournalForScaleRecord(scaleRecord);
				/* boolean journalConsistent = */validateJournalInfo(journalPage, scaleRecord);
				ScaleImportRecord importRecord = DairyFactory.eINSTANCE.createScaleImportRecord();
				try {
					// primary data
					importRecord.setCollectionJournal(journalPage);
					importRecord.setRecordedMember(scaleRecord.getMemberNumber());
					importRecord.setQuantity(scaleRecord.getValidQuantity());
					importRecord.setCollectionTime(scaleRecord.getValidDate());
					importRecord.setScaleSerial(scaleRecord.getScaleSerial());
					importRecord.setTripNumber(scaleRecord.getTripNumber());
					importRecord.setCenterNumber(scaleRecord.getCenterNumber());
					importRecord.setNumCans(scaleRecord.getNumCans());
					importRecord.setOperatorCode(scaleRecord.getOperatorCode());

					Membership memberInfo = getMemberById(scaleRecord.getMemberNumber());
					if (memberInfo != null) {
						importRecord.setValidatedMember(memberInfo);
						//importRecord.setOffRoute(memberInfo.getDefaultRoute() != journalPage.getRoute()); // TODO:
						//																					// calculate
						importRecord.setFrom(null); // TODO: calculate (how?)
						importRecord.setFarmContainer(null); // don't seem to
						// get one fromm
						// the scale ??
					}
					importRecord.setDairyContainer(null); // don't seem to
															// get one fromm
															// the scale ??

					/* boolean dbConsistent = */validateDbLookups(importRecord);

					importRecord.setFlagged(importRecord.getValidatedMember() != null
							&& importRecord.getQuantity() != null);

				} catch (Exception e) {
					System.err.println(e.getMessage());
					addError(e.getMessage(), importRecord);
				}

				if (++counter % multiple == 0) {
					monitor.worked(intQuantum);
				}
			}

			setNote("Validating raw data...");

			for (CollectionGroup page : pageMap.values()) {
				page.setStatus(JournalStatus.PENDING);
				setPageJournalDate(page);
				updateRollupValues(page);
				setDriver(page);
			}

			return true;
		}

		@Override
		public void finalUpdateUI() {
			setNote("Preparing to save new data...");

			prepareMessageList();
			
			boolean importEnabled = pageMap.size() > 0;
			ImportResultsDialog irDialog = new ImportResultsDialog(AbstractDirectoryController.getShell(), msgList,
					importEnabled);
			if (irDialog.open() == Dialog.OK) {
				System.err.printf("Import completed with %d pages\n", pageMap.size());
				int i = 0;
				for (CollectionGroup page : pageMap.values()) {
					System.err.printf("  page %d: %s - %d entries\n", ++i, page, page.getJournalEntries().size());
					System.err.printf("  page %d: %s\n", i, page);
					// }
					try {
						IDairyRepository repo = RepositoryFactory.getDairyRepository();
						repo.getLocalDairy().getCollectionJournals().add(page);
						repo.save();
					} catch (Exception e) {
						e.getMessage();
					}
				}
			}
		}

		/**
		 * 
		 */
		protected void prepareMessageList() {
			for (String err : errMessages.keySet()) {
				msgList.add(String.format("%-4d records failed with a '%s' error.", errMessages.get(err).size(), err));
			}
			
			int allEntries = 0;
			
			for (CollectionGroup page : pageMap.values()) {
				allEntries += page.getEntryCount();
			}
			
			msgList.add(0, String.format("Import completed with %d sessions, %d total collections, and %d messages",
					pageMap.keySet().size(), allEntries, errMessages.values().size()));

			int i = 0;
			
			for (CollectionGroup page : pageMap.values()) {
				allEntries += page.getEntryCount();
				msgList.add(++i, String.format("- Driver name: %s, journal date: %tF",
						MemberUtil.formattedMemberName(page.getDriver()), page.getJournalDate()));
			}
		}

		protected void addError(String message, Object detail) {
			List<Object> errList = errMessages.get(message);
			
			if (errList == null) {
				errList = new LinkedList<Object>();
				errMessages.put(message, errList);
			}
			
			errList.add(detail);
		}

		private void setPageJournalDate(CollectionGroup page) {
			if (page.getJournalDate() == null) {
				Date lowest = null, highest = null, journalDate = null;
				
				for (CollectionJournalLine line : page.getJournalEntries()) {
					ScaleImportRecord record = (ScaleImportRecord) line;
					Date collectionTime = record.getCollectionTime();
					
					if (collectionTime == null) {
						addError("Record is missing collection time.", record);
					} else {
						if (lowest == null || collectionTime.compareTo(lowest) < 0) {
							lowest = collectionTime;
						}
						if (highest == null || collectionTime.compareTo(highest) > 0) {
							highest = collectionTime;
						}
					}
				}
				
				if (lowest != null && highest != null) {
					Calendar lowCal = Calendar.getInstance(), highCal = Calendar.getInstance();
					lowCal.setTime(lowest);
					highCal.setTime(highest);
					long milliDiff = (highCal.getTimeInMillis() - lowCal.getTimeInMillis());
					
					if (milliDiff > MAX_COLLECTION_TIME_DIFFERENTIAL) {
						addError("Difference between collection times exceeds threshold: " + milliDiff, page);
					} else {
						lowCal.add(Calendar.MILLISECOND, (int) (milliDiff / 2));
						journalDate = lowCal.getTime();
					}
				} else if (lowest == null && highest == null) {
					throw new IllegalStateException("Unable to find any dates in imported scale records.");
				} else {
					throw new IllegalStateException("Unable to find any dates in imported scale records.");
				}
				page.setJournalDate(journalDate);
			}
		}

		private void updateRollupValues(CollectionGroup page) {
			BigDecimal quantity = new BigDecimal(0);

			int numSuspended = 0, numRejected = 0;
			for (CollectionJournalLine line : page.getJournalEntries()) {
				quantity = quantity.add(line.getQuantity());

				line.setFlagged(line.getValidatedMember() == null);

				if (line.isFlagged())
					numSuspended++;
				if (line.isRejected())
					numRejected++;
			}
			page.setDriverTotal(quantity);
			page.setRecordTotal(quantity);
			page.setEntryCount(page.getJournalEntries().size());
			page.setRejectedCount(numRejected);
			page.setSuspendedCount(numSuspended);
		}

		private void setDriver(CollectionGroup page) {
			if (page.getDriver() == null) {
				LinkedList<String> codes = new LinkedList<String>();
				for (CollectionJournalLine line : page.getJournalEntries()) {
					ScaleImportRecord rec = (ScaleImportRecord) line;
					String operatorCode = rec.getOperatorCode();
					if (operatorCode != null) {
						codes.add(operatorCode);
					}
				}
				for (String code : codes) {
					for (Employee emp : dairyRepo.getLocalDairy().getEmployees()) {
						if (code.equals(emp.getOperatorCode())) {
							page.setDriver(emp);
							return;
						}
					}
				}
				// fallback to employee #1
				System.err.println("WARNING: Unable to assign driver based on codes. Falling back to first Employee");
				Log4r.getLogger(getClass()).log(LogService.LOG_WARNING,
						"WARNING: Unable to assign driver based on codes. Falling back to first Employee");

				page.setDriver(dairyRepo.getLocalDairy().getEmployees().get(0));
			}
		}

	}

	/**
		 * 
		 */
	private final MilkCollectionLogController milkCollectionLogController;
	private IDairyRepository dairyRepo = RepositoryFactory.getDairyRepository();
	private Map<String, CollectionGroup> pageMap = new HashMap<String, CollectionGroup>();
	private Map<String, CollectionSession> sessionMap = new HashMap<String, CollectionSession>();
	private Map<String, DairyLocation> centerMap = new HashMap<String, DairyLocation>();
	Dairy localDairy;

	public ScaleImportAction(MilkCollectionLogController milkCollectionLogController) {
		this.milkCollectionLogController = milkCollectionLogController;
		
	}

	@Override
	public void callback() {
		Object navigationContext = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		SubModuleView rienaView = (SubModuleView) Platform.getAdapterManager().getAdapter(navigationContext,
				SubModuleView.class);
		
		if (rienaView != null) {
			navigationContext = rienaView.getController().getNavigationNode();
		}
		
		final FileDialog fileDialog = new FileDialog(AbstractDirectoryController.getShell(), SWT.DIALOG_TRIM);
		final String retVal = fileDialog.open();
		
		if (retVal == null) {
			// user pressed Cancel
			return;
		}
		
		File importFile = new File(retVal);
		pageMap.clear();
		sessionMap.clear();
		centerMap.clear();
		
		for (CollectionSession session: RepositoryFactory.getRepository(CollectionSession.class).all()) {
			sessionMap.put(session.getCode(), session);
		}
		
		for (DairyLocation loc: RepositoryFactory.getRegisteredRepository(IDairyLocationRepository.class).all()) {
			if (loc.getCode() != null) {
				centerMap.put(loc.getCode().toLowerCase(), loc);
			}
		}

		UIProcess process = new ScaleImportProcess(importFile, navigationContext);
		// job.setProperty(UIProcess.PROPERTY_CONTEXT, navigationContext);
		// job.setUser(true);// to be visualized the job has to be user
		// job.schedule();
		process.setTitle("Upload Scale Records");
		process.setNote("Importing...");
		process.start();
	}

	/**
	 * Validate that lookup fields (memberNumber -> member, routeCode -> route,
	 * etc) are not null, and all codes and ids in the record exist in the
	 * database.
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
	 * Compare the information in a scale record to that of a Collection Journal
	 * Page (CollectionGroup). Returns false if any of the redundant fields in
	 * the scale record are different than the corresponding fields in the
	 * journal page (collection group).
	 * 
	 * @param journalPage
	 * @param scaleRecord
	 * @return
	 */
	private boolean validateJournalInfo(CollectionGroup journalPage, ScaleRecord scaleRecord) {
		boolean isConsistent = true;
		// TODO: implement
		return isConsistent;
	}

	private CollectionGroup getJournalForScaleRecord(ScaleRecord record) {
		String key = createGroupKey(record);
		String centerCode = record.getRouteNumber() == null ? null : record.getRouteNumber().toLowerCase();
		CollectionGroup page = pageMap.get(key);
		
		if (page == null) {
			page = DairyFactory.eINSTANCE.createCollectionGroup();
			page.setReferenceNumber(key);
			page.setDriver(getDriverByCode(record.getOperatorCode()));
			page.setJournalDate(record.getValidDate());
			page.setSession(sessionMap.get(record.getSessionCode()));
			page.setCollectionCenter(centerMap.get(centerCode));
			
			if (page.getDriver() == null || page.getJournalDate() == null || page.getSession() == null
					/* || page.getRoute() == null */) {
				// TODO: add suspension reason
				page.setSuspended(true);
				this.milkCollectionLogController.log(LogService.LOG_INFO, "Suspending " + key
						+ " for validation failure - null key item.");
			}
			
			pageMap.put(key, page);
		}
		
		return page;
	}

	private Employee getDriverByCode(String operatorCode) {
		Employee retval = null;
		if (operatorCode != null) {
			if (localDairy == null) {
				localDairy = dairyRepo.getLocalDairy();
			}
			for (Employee employee : localDairy.getEmployees()) {
				String operCode = employee.getOperatorCode();
				if (operCode != null && operCode.equals(operatorCode)) {
					retval = employee;
					break;
				}
			}
		}
		return retval;
	}

	private Membership getMemberById(String memberNumber) {
		// TODO: we are creating members for testing
		// -- FIXME

		Membership member = dairyRepo.findMemberByMemberNo(memberNumber);
		if (member == null) {
			throw new RuntimeException("invalid member id " + memberNumber);
		}
		return member;
	}

	/**
	 * There should be only one date per scale file, but the key generate will
	 * accomodate multiples..
	 * 
	 * @param record
	 * @return
	 */
	private String createGroupKey(ScaleRecord record) {
		StringBuffer buffer = new StringBuffer();
		Formatter formatter = new Formatter(buffer);
		formatter.format("%s-%s-%s-%2s", record.getScaleSerial(), record.getRouteNumber(), record.getTransactionDate(),
				record.getSessionCode());
		return buffer.toString();
	}

}