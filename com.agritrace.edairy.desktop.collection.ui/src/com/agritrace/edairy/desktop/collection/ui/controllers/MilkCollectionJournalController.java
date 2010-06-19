package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.internal.ui.ridgets.swt.NumericTextRidget;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.collection.ui.Activator;
import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.validators.StringNumberValidator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkCollectionJournalController extends SubModuleController {

	public class MemberDeliversOncePerSessionValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			// TODO: implement
			return Status.OK_STATUS;
		}
	}

	public class MemberNumberExistsValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			IStatus ret = Status.CANCEL_STATUS;
			if ( value instanceof String ) {
				String memberID = (String) value;
				Membership member = dairyRepo.getMembershipById(memberID);
				if ( null != member) {
					workingJournalLine.setValidatedMember(member);
					Farmer farmer = member.getMember();
					memberNameRidget.setText(farmer.getFamilyName() + ", " + farmer.getGivenName());
					return Status.OK_STATUS;
				}
				else {
					ret = new Status(Status.ERROR, Activator.PLUGIN_ID, "Invalid membership number" ); 
				}
			}
			return ret;
		}

	}

	private static Logger LOG = Log4r.getLogger(Activator.getDefault(), MilkCollectionJournalController.class);

	private class GroupOneSelectionListener implements ISelectionListener {

		@Override
		public void ridgetSelected(SelectionEvent event) {
			if ((routeRidget.getSelection() != null) && (vehicleRidget.getSelection() != null)
					&& (vehicleRidget.getSelection() != null) && (driverRidget.getSelection() != null)) {
				setSubGroupsVisible(true);
			} else {
				setSubGroupsVisible(false);
			}
		}
	}

	public static final String CAN_COLUMN_HEADER = "CAN Number";
	public static final String LINE_COLUMN_HEADER = "Line";
	public static final String MEMBER_COLUMN_HEADER = "Member ID";
	public static final String NPR_COLUMN_HEADER = "NPR Missing";
	public static final String QUANTITY_COLUMN_HEADER = "Quantity";

	public static final String REJECTED_COLUMN_HEADER = "Rejected";
	public static final String TOTAL_LABEL = "Total : ";

	private static final String[] columnNames = { LINE_COLUMN_HEADER, MEMBER_COLUMN_HEADER, CAN_COLUMN_HEADER,
			QUANTITY_COLUMN_HEADER, NPR_COLUMN_HEADER, REJECTED_COLUMN_HEADER };
	private static final String[] propertyNames = {
			"lineNumber", "recordedMember", "farmContainer", "quantity", "notRecorded", "rejected" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	// journal book group ridgets
	private ITextRidget dateRidget;
	private IComboRidget driverRidget;

	// journal group ridgets
	private ITextRidget journalNumber;
	private IDecimalTextRidget driverTotalText;
	private IComboRidget routeRidget;
	private IComboRidget sessionRidget;
	private IComboRidget vehicleRidget;

	// milk Entry group
	private ITextRidget memberIDRidget;
	private IDecimalTextRidget quantityText;
	private IToggleButtonRidget rejectedButton;
	private IToggleButtonRidget nprMissingButton;
	private ILabelRidget totalLabelRidget;
	private IComboRidget binCombo;
	private ITextRidget canText;
	private ITableRidget table;
	private ILabelRidget memberNameRidget;

	private final IDairyRepository dairyRepo = new DairyRepository();
	// private final List<CollectionJournalLine> records = new
	// ArrayList<CollectionJournalLine>();
	// todo: all of these are unnecessary..
	private List<Employee> driverList = getDriverList();
	private List<Vehicle> vehicles = getVehiclesList();
	private List<DairyContainer> bins = getBins();
	private List<Route> routes = getRoutesList();
	// private final TotalRecordsValue totalValue = new TotalRecordsValue();

	private CollectionJournalPage workingJournalPage;
	private CollectionJournalLine workingJournalLine;
	private DairyContainer workingBin;

	private boolean errorDialogsEnabled = true; // todo: get from preferences

	public MilkCollectionJournalController() {
		super();
	}

	@Override
	public void afterBind() {
		super.afterBind();

		setSubGroupsVisible(false);

		workingJournalPage = getWorkingJournalPage();
		;

		bindHeaderRidgets();

		populateLookupLists();

		// conditionally editable
		journalNumber.bindToModel(EMFObservables.observeValue(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER));
		driverTotalText.bindToModel(BeansObservables.observeValue(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL.getName())); // fallback
																							// to
																							// bean
																							// properties
																							// because
																							// Riena
																							// databinding
																							// doesn't
																							// grok
																							// emf

		if (workingJournalPage.getReferenceNumber() != null && workingJournalPage.getDriverTotal() != null) {
			journalNumber.setOutputOnly(true);
			driverTotalText.setOutputOnly(true);
		}

		// editable widgets
		binCombo.bindToModel(new WritableList(bins, DairyContainer.class), DairyContainer.class, "getContainerId",
				new WritableValue());
		binCombo.updateFromModel();

		table.bindToModel(EMFObservables.observeList(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES), CollectionJournalLine.class,
				propertyNames, columnNames);

		totalLabelRidget.bindToModel(EMFObservables.observeValue(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL));
		// totalLabelRidget.updateFromModel();

		updateAllRidgetsFromModel();
	}

	private void populateLookupLists() {
	}
	

	protected CollectionJournalPage getWorkingJournalPage() {
		CollectionJournalPage workingJournalPage = null;
		Object contextObj = null;
		NavigationArgument navArg = getNavigationNode().getNavigationArgument();
		if (navArg != null) {
			contextObj = navArg.getParameter();
		}
		if (contextObj == null) {
			LOG.log(0, "failed to get page from navigation - falling back to context");
			contextObj = getNavigationNode().getContext("JOURNAL_PAGE");
		}
		if (contextObj instanceof CollectionJournalPage) {
			workingJournalPage = (CollectionJournalPage) contextObj;
		} else {
			LOG.log(0, "ERROR: unable to get journal page from context.");
			throw new IllegalStateException("ERROR: unable to get journal page from context.");
		}
		assert (workingJournalPage != null);
		return workingJournalPage;
	}

	protected void bindHeaderRidgets() {
		dateRidget.bindToModel(EMFObservables.observeValue(workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE));
		routeRidget.bindToModel(new WritableList(routes, Route.class), Route.class, "getName",
				EMFObservables.observeValue(workingJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE));
		sessionRidget
				.bindToModel(Observables.staticObservableList(Session.VALUES), Session.class, null, EMFObservables
						.observeValue(workingJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION));
		vehicleRidget
				.bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class, "getRegistrationNumber",
						EMFObservables.observeValue(workingJournalPage,
								DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__VEHICLE));
		driverRidget.bindToModel(new WritableList(driverList, Employee.class), Employee.class, "getFamilyName",
				EMFObservables.observeValue(workingJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER));

		for (IMarkableRidget ridget : Arrays.asList(new IMarkableRidget[] { dateRidget, routeRidget, sessionRidget,
				vehicleRidget, driverRidget })) {
			ridget.setOutputOnly(true);
		}
	}

	@Override
	public void configureRidgets() {

		// records.clear();
		// add a node listener to load dairy whenever it is active.
		addSimpleListener();

		configureHeaderRidgets();

		// milk entry group
		memberIDRidget = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberIDRidget.setMandatory(true);
		memberIDRidget.setInputToUIControlConverter(new Converter(String.class, String.class) {
			@Override
			public Object convert(Object fromObject) {
				if ((fromObject instanceof String) && !((String) fromObject).isEmpty()) {
					String text = (String) fromObject;
					final String firstChar = text.substring(0, 1);
					if (firstChar.equalsIgnoreCase("N")) {
						text = text.substring(1);
						nprMissingButton.setSelected(true);
						return text;
					} else if (firstChar.equalsIgnoreCase("R")) {
						text = text.substring(1);
						rejectedButton.setSelected(true);
						return text;
					}
				}
				return fromObject;
			}
		});

		memberIDRidget.addValidationRule(new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);
		memberIDRidget.addValidationRule(new MemberNumberExistsValidator(), ValidationTime.ON_UPDATE_TO_MODEL); // todo:
		memberIDRidget.addValidationRule(new MemberDeliversOncePerSessionValidator(), ValidationTime.ON_UPDATE_TO_MODEL); // todo:

		memberNameRidget = getRidget(ILabelRidget.class, "member-name");
		
		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		canText.addValidationRule(new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);
		// canText.addValidationRule(new MemberOwnsCanValidator(),
		// ValidationTime.ON_UPDATE_TO_MODEL); // todo:

		quantityText = getRidget(IDecimalTextRidget.class, ViewWidgetId.quantityText);
		quantityText.setMandatory(true);

		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);
		rejectedButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);

		table = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
		table.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof CollectionJournalLine) {
					if (((CollectionJournalLine) element).getFarmContainer() != null) {
						return "" + ((CollectionJournalLine) element).getFarmContainer().getContainerId();
					}

				}
				return null;
			}
		});

		table.setSelectionType(SelectionType.MULTI);
		table.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				if (table.getSelection().size() == 0) {
					updateBottomButtons(false);
				} else {
					updateBottomButtons(true);
				}
			}
		});

		// buttons
		((IActionRidget) getRidget(ViewWidgetId.addButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				addButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.entryInputClear)).addListener(new IActionListener() {
			@Override
			public void callback() {
				clearMilkJournalGroupButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.modifyButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				// MilkCollectionRecord aRecord = (MilkCollectionRecord)
				// table.getSelection().get(0);
				// ModifyMilkRecordDialog modifyDialog = new
				// ModifyMilkRecordDialog(Display.getDefault().getActiveShell());
				// aRecord.setLine("");
				// modifyDialog.setRecord(aRecord);
				// if(modifyDialog.open() == Window.OK){
				// table.updateFromModel();
				// totalLabelRidget.updateFromModel();
				// }
			}

		});

		((IActionRidget) getRidget(ViewWidgetId.deleteButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				deleteJournalEntryButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.clearButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				clearAllJournalEntiresButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.saveButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				createAndSaveCollectionJournalPage();
			}
		});

		updateBottomButtons(false);

		totalLabelRidget = getRidget(ILabelRidget.class, ViewWidgetId.totalLabel);

	}

	protected void configureHeaderRidgets() {
		// journal book group
		dateRidget = getRidget(ITextRidget.class, ViewWidgetId.calendarDate);
		dateRidget.setText(new SimpleFormattedDateBean().getFormattedDate());
		dateRidget.setMandatory(true);

		routeRidget = getRidget(IComboRidget.class, ViewWidgetId.routeCombo);
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(IComboRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(IComboRidget.class, ViewWidgetId.vehicleCombo);
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(IComboRidget.class, ViewWidgetId.driverCombo);
		driverRidget.setMandatory(true);

		final GroupOneSelectionListener selectionListener = new GroupOneSelectionListener();
		routeRidget.addSelectionListener(selectionListener);
		sessionRidget.addSelectionListener(selectionListener);
		vehicleRidget.addSelectionListener(selectionListener);
		driverRidget.addSelectionListener(selectionListener);

		// journal group
		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		journalNumber.setMandatory(true);
		journalNumber.addValidationRule(new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);

		driverTotalText = getRidget(IDecimalTextRidget.class, ViewWidgetId.journalTotalText);
		driverTotalText.setSigned(false);
		driverTotalText.setGrouping(true);
		driverTotalText.setMandatory(true);

		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		binCombo.setMandatory(true);
		// binCombo.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UI_CONTROL_EDIT);
	}

	private void addButtonClicked() {

		final CollectionJournalLine journalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();
		/**
		 * todo should get container based on the CAN ID, now I created manually
		 */
		final String quantityTextString = NumericTextRidget.ungroup(quantityText.getText());

		final String memberId = memberIDRidget.getText();
		final Membership mship = dairyRepo.getMembershipById(memberId);
		if (mship == null) {
			if (!handleInvalidMemberID(journalLine, memberId)) {
				return;
			}
		}
		else if (mship.getDefaultRoute() != null 
				&& !mship.getDefaultRoute().equals(workingJournalPage.getRoute()) ) {
			if (!handleMemberDefaultRouteMismatch(journalLine, memberId)) {
				return;
			}
		}

		Container can = null;
		final String canId = canText.getText();
		if (canId == null || canId.trim().length() == 0) {
			if (!handleNoCanSpecified(journalLine)) {
				return;
			}
		} else {
			can = dairyRepo.getFarmContainerById(canId);
			if (can == null) {
				if (!handleUnregisteredCan(journalLine, canId)) {
					return;
				}
			}
			if (mship != null && !mship.getMember().getFarms().contains(can.getOwner())) {
				if (!handleInvalidCanID(journalLine, canId)) {
					return;
				}
			}
		}
		// can.setContainerId(canText.getText());
		journalLine.setFarmContainer(can);
		journalLine.setRecordedMember(memberIDRidget.getText());
		journalLine.setDairyContainer((DairyContainer) binCombo.getSelection());
		journalLine.setQuantity(new BigDecimal(quantityTextString));
		journalLine.setNotRecorded(nprMissingButton.isSelected());
		journalLine.setRejected(rejectedButton.isSelected());
		journalLine.setValidatedMember(mship);
		if (mship == null) {
			journalLine.setFlagged(true);
		}
		// records.add(aRecord);
		workingJournalPage.getJournalEntries().add(journalLine);
		updateJournalTotals(); // TODO: test
		table.updateFromModel();
		totalLabelRidget.updateFromModel();
	}

	private boolean handleMemberDefaultRouteMismatch(CollectionJournalLine journalLine, String memberId) {
		// TODO Auto-generated method stub
		return true;
	}


	/**
	 * Called when there is no can id specified.
	 * 
	 * @param journalLine
	 * @return false to abort the current operation (usually the 'save' of a
	 *         journal line)
	 */
	protected boolean handleNoCanSpecified(final CollectionJournalLine journalLine) {
		// this is the normal case for now.. in the future, this may be an error
		// or warning.
		return true;
	}

	/**
	 * Called when a can id is not recognized.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return false to abort the current operation (usually the 'save' of a
	 *         journal line)
	 */
	protected boolean handleUnregisteredCan(final CollectionJournalLine journalLine, String canId) {

		return true;
	}

	/**
	 * Called when the ID specified is not valid.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return
	 */
	protected boolean handleInvalidCanID(final CollectionJournalLine journalLine, final String canId) {
		boolean ret = true;

		if (errorDialogsEnabled) {
			ret = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Error creating journal line",
					"Can't find container for " + canId + ". Do you want to continue create a new record? ");
		}

		// if we choose to continue;
		if (ret) {
			// suspend the record
			journalLine.setFlagged(true);
		}
		return ret;
	}

	protected boolean handleInvalidMemberID(final CollectionJournalLine journalLine, final String memberId) {
		boolean ret = true;
		if (errorDialogsEnabled) {
			ret = MessageDialog
					.openConfirm(
							Display.getDefault().getActiveShell(),
							"Error creating collection journal record!",
							"Can't find valid membership for "
									+ memberId
									+ ". The record will be marked as Suspended. Do you want to continue create a new record? ");
		}
		return ret;
	}

	private void addSimpleListener() {
		// getNavigationNode().addSimpleListener(new
		// MilkCollectionNodeListener());
	}

	private void clearAllJournalEntiresButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records",
				"Do you want to delete all milk collection records?")) {
			// records.clear();
			workingJournalPage.getJournalEntries().clear();
			updateJournalTotals();
			table.updateFromModel();
			totalLabelRidget.updateFromModel();
		}
	}

	private void clearMilkJournalGroupButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Clear Input",
				"Do you want to clear input fields?")) {
			clearMilkJournalInputs();
		}
	}

	private void clearMilkJournalInputs() {
		memberIDRidget.setText("");
		canText.setText("");
		quantityText.setText("");
		nprMissingButton.setSelected(false);
		rejectedButton.setSelected(false);
		memberIDRidget.setFocusable(true);
	}

	private void createAndSaveCollectionJournalPage() {
		// we can assume these were already set.
		// workingJournalPage.setDriver((Employee) driverRidget.getSelection());
		// workingJournalPage.setSession((Session)
		// sessionRidget.getSelection());
		// workingJournalPage.setRoute((Route) routeRidget.getSelection());
		// workingJournalPage.setVehicle((Vehicle)
		// vehicleRidget.getSelection());
		// final Date date = new
		// SimpleFormattedDateBean(dateRidget.getText()).getDate();
		// workingJournalPage.setJournalDate(date);
		//
		// final double driverTotal = new
		// Double(NumericTextRidget.ungroup(driverTotalText.getText())).doubleValue();

		if (workingJournalPage.getDriverTotal() != workingJournalPage.getRecordTotal()) {
			if (!handleTotalsNotEqualOnSave())
				return;
		}
		// workingJournalPage.setDriverTotal(new BigDecimal(driverTotal));
		// workingJournalPage.setRecordTotal(new BigDecimal(recordTotal));
		// for (final CollectionJournalLine record : records) {
		// record.setCollectionJournal(workingJournalPage);
		// }
		// workingJournalPage.getJournalEntries().addAll(records);

		dairyRepo.saveNewJournalPage(workingJournalPage); // should save all
															// lines as well..
		setSubGroupsVisible(false);
	}

	private boolean handleTotalsNotEqualOnSave() {
		MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Save Collection Journal",
				"Journal Total value doesn't match collection journal records total.");
		return false;
	}

	private void deleteJournalEntryButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records",
				"Do you want to delete the selected milk collection records?")) {
			final List<Object> selectedRecords = table.getSelection();
			if (selectedRecords != null) {
				// records.removeAll(selectedRecords);
				workingJournalPage.getJournalEntries().removeAll(selectedRecords);
			}
			updateJournalTotals(); // todo: test
			table.updateFromModel();
			totalLabelRidget.updateFromModel();
		}
	}

	private List<DairyContainer> getBins() {
		return dairyRepo.allDairyContainers();
	}

	private List<Employee> getDriverList() {
		return dairyRepo.employeesByPosition("Driver");
	}

	private List<Route> getRoutesList() {
		return dairyRepo.allRoutes();
	}

	private List<Vehicle> getVehiclesList() {
		return dairyRepo.allVehicles();
	}

	private void setSubGroupsVisible(boolean visble) {
		if (journalNumber != null) {
			((Control) journalNumber.getUIControl()).getParent().setVisible(visble);
		}
		if (memberIDRidget != null) {
			((Control) memberIDRidget.getUIControl()).getParent().getParent().setVisible(visble);
		}
		if (table != null) {
			((Control) table.getUIControl()).getParent().getParent().getParent().setVisible(visble);
		}
	}

	private void updateBottomButtons(boolean enable) {
		((IActionRidget) getRidget(ViewWidgetId.modifyButton)).setEnabled(enable);
		((IActionRidget) getRidget(ViewWidgetId.deleteButton)).setEnabled(enable);
	}

	private void updateJournalTotals() {
		int counter = 0;
		BigDecimal total = new BigDecimal(0);

		for (final CollectionJournalLine line : workingJournalPage.getJournalEntries()) {
			line.setLineNumber(++counter);
			total.add(line.getQuantity());
		}
		workingJournalPage.setRecordTotal(total);
	}

	// private class MilkCollectionNodeListener extends
	// SimpleNavigationNodeAdapter {
	//
	// @Override
	// public void activated(INavigationNode<?> source) {
	// System.out.println("load dairy ............!");
	// }
	//
	// @Override
	// public void deactivated(INavigationNode<?> source) {
	//
	// }
	//
	// @Override
	// public void disposed(INavigationNode<?> source) {
	//
	// }
	// }
}
