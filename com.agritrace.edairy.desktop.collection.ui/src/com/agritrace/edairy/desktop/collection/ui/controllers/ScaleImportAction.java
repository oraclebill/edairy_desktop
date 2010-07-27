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

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget.InfoFlyoutData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.agritrace.edairy.desktop.collections.scaledata.importer.ScaleImporter;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

final class ScaleImportAction implements IActionListener {
	/**
		 * 
		 */
	private final MilkCollectionLogController milkCollectionLogController;
	private IDairyRepository dairyRepo = DairyRepository.getInstance();
	private Map<String, CollectionJournalPage> pageMap = new HashMap<String, CollectionJournalPage>();
	Dairy localDairy;

	public ScaleImportAction(MilkCollectionLogController milkCollectionLogController) {
		this.milkCollectionLogController = milkCollectionLogController;

	}

	@Override
	public void callback() {
		final FileDialog fileDialog = new FileDialog(AbstractDirectoryController.getShell(), SWT.DIALOG_TRIM);
		final String retVal = fileDialog.open();
		File importFile = new File(retVal);
		if (importFile.isFile() && importFile.canRead()) {
			ScaleImporter scaleImporter = new ScaleImporter(importFile);
			try {
				List<ScaleRecord> scaleData = scaleImporter.readRecords().getResults();
				// generate one or more collection groups - one group per
				// scale/date/route/session (driver, vehicle,...)
				for (ScaleRecord scaleRecord : scaleData) {
					CollectionJournalPage journalPage = getJournalForScaleRecord(scaleRecord);
					boolean journalConsistent = validateJournalInfo(journalPage, scaleRecord);
					try {
						ScaleImportRecord importRecord = DairyFactory.eINSTANCE.createScaleImportRecord();
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
						importRecord.setOffRoute(false); // TODO: calculate
						importRecord.setFrom(null); // TODO: calculate
						importRecord.setDairyContainer(null); // don't seem to
																// get one fromm
																// the scale ??
						importRecord.setFarmContainer(null); // don't seem to
																// get one fromm
																// the scale ??
						importRecord.setOperatorCode(scaleRecord.getOperatorCode());

						boolean dbConsistent = validateDbLookups(importRecord);

						if (journalPage.getJournalDate() == null) {
							System.err.printf("date: %s, truncDate: %s\n", importRecord.getCollectionTime(),
									truncateTime(importRecord.getCollectionTime()));
							journalPage.setJournalDate(truncateTime(importRecord.getCollectionTime()));
						}
						importRecord.setFlagged(importRecord.getValidatedMember() != null && importRecord.getQuantity() != null );
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}

				System.err.printf("Import completed with %d pages\n", pageMap.size());
				int i = 0;
				for (CollectionJournalPage page : pageMap.values()) {
					System.err.printf("  page %d: %s - %d entries\n", ++i, page, page.getJournalEntries().size());
					page.setStatus(JournalStatus.PENDING);
					setPageJournalDate(page);
					setPageTotals(page);
					setDriver(page);
					System.err.printf("  page %d: %s\n", i, page);
					// }
					try {
						DairyRepository.getInstance().getLocalDairy().getCollectionJournals().add(page);
						DairyRepository.getInstance().save();
					} catch (Exception e) {
						e.getMessage();
					}
				}
				milkCollectionLogController.refreshTableContents();
			} catch (IOException e) {
				// TODO: error message
				this.milkCollectionLogController.getInfoFlyout().addInfo(
						new InfoFlyoutData(null, "Error importing scale data. Please contact support for assistance."));
				this.milkCollectionLogController.log(LogService.LOG_ERROR, e.getMessage(), e);
			}
		} else {
			Dialog dlg = new ErrorDialog(null, "Error reading file", "The file " + importFile + " can not be read.",
					new Status(0, Activator.PLUGIN_ID, "File Error"), 0);
			dlg.open();
		}

	}

	private void setPageJournalDate(CollectionJournalPage page) {
		if (page.getJournalDate() == null) {
			for (CollectionJournalLine line : page.getJournalEntries()) {
				ScaleImportRecord importRec = (ScaleImportRecord) line;
				if (importRec.getCollectionTime() != null) {
					page.setJournalDate(importRec.getCollectionTime());
					break;
				}
			}
			if (page.getJournalDate() == null) {
				System.err.println("------ ERR: no date");
				page.setJournalDate(new Date());
			}
		}
	}

	private void setPageTotals(CollectionJournalPage page) {
		BigDecimal quantity = new BigDecimal(0);
		int numSuspended = 0, numRejected = 0;
		for (CollectionJournalLine line : page.getJournalEntries()) {
			quantity = quantity.add(line.getQuantity());
			if (line.isFlagged()) numSuspended++;
			if (line.isRejected()) numRejected++;
		}
		page.setRecordTotal(quantity);
		page.setEntryCount(page.getJournalEntries().size());
		page.setDriverTotal(quantity);
		page.setRejectedCount(numRejected);
		page.setSuspendedCount(numSuspended);
	}

	private void setDriver(CollectionJournalPage page) {
		if(page.getDriver()== null) {
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
			page.setDriver(dairyRepo.getLocalDairy().getEmployees().get(0));
		}
	}
	
	private Date truncateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
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
			if (page.getDriver() == null || page.getJournalDate() == null || page.getSession() == null
					|| page.getRoute() == null) {
				// TODO: add suspension reason
				page.setSuspended(true);
				this.milkCollectionLogController.log(LogService.LOG_INFO, "Suspending " + key
						+ " for validation failure - null key item.");
			}
			pageMap.put(key, page);
		}
		return page;
	}

	private Route getRouteForRouteCode(String routeNumber) {
		if (routeNumber != null) {
			if (localDairy == null)
				localDairy = dairyRepo.getLocalDairy();
			for (Route route : localDairy.getRoutes()) {
				if (route.getCode().equalsIgnoreCase(routeNumber.trim()))
					return route;
			}
		}
		return null;
	}

	private Session getSessionForCode(String sessionCode) {
		if (sessionCode != null) {
			if (sessionCode.equals("AM")) {
				return Session.MORNING;
			} else if (sessionCode.equals("PM")) {
				return Session.EVENING1;
			}
		}
		return null;
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

		Membership member = dairyRepo.getMemberByMemberId(memberNumber);
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

	private void createCollectionDetailNode(INavigationNode<?> currentNode, CollectionJournalPage journalPage) {
		currentNode.navigate(new NavigationNodeId("milk-collection-entry-node", journalPage.getReferenceNumber()), //$NON-NLS-1$
				new NavigationArgument(journalPage));

		// final ISubModuleNode detailViewNode = new SubModuleNode(new
		// NavigationNodeId("scale-data-review-node",
		//				journalPage.getReferenceNumber()), "Scale -" + journalPage.getReferenceNumber()); //$NON-NLS-1$
		//		detailViewNode.setIcon("scale_detail.gif"); //$NON-NLS-1$
		// detailViewNode.setContext("IMPORTED_RECORDS", journalPage); //
		// backup..
		// WorkareaManager.getInstance()
		// .registerDefinition(detailViewNode, ScaleImportViewController.class,
		// ScaleDataImportView.ID)
		// .setRequiredPreparation(true);
		// return detailViewNode;
	}

}