package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.internal.ui.ridgets.swt.NumericTextRidget;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.validators.StringNumberValidator;
import com.agritrace.edairy.desktop.operations.services.collections.CollectionRepository;
import com.agritrace.edairy.desktop.operations.services.collections.ICollectionRepository;

public class MilkCollectionJournalController extends SubModuleController {

	// journal book group ridgets
	private ITextRidget dateRidget;
	private IComboRidget routeRidget;
	private IComboRidget sessionRidget;
	private IComboRidget vehicleRidget;
	private IComboRidget driverRidget;

	// journal group ridgets
	private ITextRidget journalNumber;
	private IDecimalTextRidget journalTotlal;

	// milk Entry group
	private IComboRidget binCombo;
	private ITextRidget memberText;
	private ITextRidget canText;
	private ITextRidget quantityText;
	private ITableRidget table;
	private IToggleButtonRidget nprMissingButton;
	private IToggleButtonRidget rejectedButton;
	private ILabelRidget totalLabelRidget;

	public static final String LINE_COLUMN_HEADER = "Line";

	public static final String MEMBER_COLUMN_HEADER = "Member ID";

	public static final String CAN_COLUMN_HEADER = "CAN Number";

	public static final String QUANTITY_COLUMN_HEADER = "Quantity";

	public static final String NPR_COLUMN_HEADER = "NPR Missing";

	public static final String REJECTED_COLUMN_HEADER = "Rejected";

	public static final String TOTAL_LABEL = "Total : ";

	private final List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();

	private final TotalRecordsValue totalValue = new TotalRecordsValue();

	ICollectionRepository dairyRepo = new CollectionRepository();

	public MilkCollectionJournalController() {
		super();
	}

	@Override
	public void configureRidgets() {
		records.clear();
		// add a node listener to load dairy whenever it is active.
		addSimpleListener();

		// journal book group
		dateRidget = getRidget(ITextRidget.class, ViewWidgetId.calendarDate);
		dateRidget.setText(new SimpleFormattedDateBean().getFormattedDate());
		dateRidget.setMandatory(true);

		routeRidget = getRidget(IComboRidget.class, ViewWidgetId.routeCombo);
		final List<Route> someRoutes = getRoutesList();
		routeRidget.bindToModel(new WritableList(someRoutes, Route.class),
				Route.class, "getName", new WritableValue());
		routeRidget.updateFromModel();
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(IComboRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.bindToModel(
				Observables.staticObservableList(Session.VALUES),
				Session.class, null, new WritableValue());
		sessionRidget.updateFromModel();
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(IComboRidget.class, ViewWidgetId.vehicleCombo);
		final List<Vehicle> vehicles = getVehiclesList();
		vehicleRidget.bindToModel(new WritableList(vehicles, Vehicle.class),
				Vehicle.class, "getRegistrationNumber", new WritableValue());
		vehicleRidget.updateFromModel();
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(IComboRidget.class, ViewWidgetId.driverCombo);
		// List<String> driverList = Arrays.asList(new String[] {
		// "23 - John Jones", "45 - Joseph Limuru", "66 - John Smith" });
		final List<Employee> driverList = getDriverList();
		driverRidget.bindToModel(new WritableList(driverList, Employee.class),
				Employee.class, "getGivenName", new WritableValue());
		driverRidget.updateFromModel();
		driverRidget.setMandatory(true);

		final GroupOneSelectionListener selectionListener = new GroupOneSelectionListener();
		routeRidget.addSelectionListener(selectionListener);
		sessionRidget.addSelectionListener(selectionListener);
		vehicleRidget.addSelectionListener(selectionListener);
		driverRidget.addSelectionListener(selectionListener);

		// journal group
		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		journalNumber.setMandatory(true);
		journalNumber.addValidationRule(new StringNumberValidator(),
				ValidationTime.ON_UI_CONTROL_EDIT);

		journalTotlal = getRidget(IDecimalTextRidget.class,
				ViewWidgetId.journalTotalText);
		journalTotlal.setSigned(false);
		journalTotlal.setGrouping(true);
		journalTotlal.setMandatory(true);

		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		binCombo.setMandatory(true);
		final List<DairyContainer> bins = getBins();
		binCombo.bindToModel(new WritableList(bins, DairyContainer.class),
				DairyContainer.class, "getContainerId", new WritableValue());
		binCombo.updateFromModel();
		// binCombo.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UI_CONTROL_EDIT);

		// milk entry group
		memberText = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberText.setMandatory(true);
		memberText.setInputToUIControlConverter(new Converter(String.class,
				String.class) {

			@Override
			public Object convert(Object fromObject) {
				if ((fromObject instanceof String)
						&& !((String) fromObject).isEmpty()) {
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

		memberText.addValidationRule(new StringNumberValidator(),
				ValidationTime.ON_UI_CONTROL_EDIT);

		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		// canText.setMandatory(true);
		canText.addValidationRule(new StringNumberValidator(),
				ValidationTime.ON_UI_CONTROL_EDIT);

		quantityText = getRidget(IDecimalTextRidget.class,
				ViewWidgetId.quantityText);
		quantityText.setMandatory(true);

		nprMissingButton = getRidget(IToggleButtonRidget.class,
				ViewWidgetId.nprMissingCombo);

		rejectedButton = getRidget(IToggleButtonRidget.class,
				ViewWidgetId.rejectedCombo);

		table = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
		final String[] columnNames = { LINE_COLUMN_HEADER,
				MEMBER_COLUMN_HEADER, CAN_COLUMN_HEADER,
				QUANTITY_COLUMN_HEADER, NPR_COLUMN_HEADER,
				REJECTED_COLUMN_HEADER };
		final String[] propertyNames = {
				"lineNumber", "recordedMember", "farmContainer", "quantity", "notRecorded", "rejected" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		table.setColumnFormatter(2, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof CollectionJournalLine) {
					if (((CollectionJournalLine) element).getFarmContainer() != null) {
						return ""
						+ ((CollectionJournalLine) element)
						.getFarmContainer().getContainerId();
					}

				}
				return null;
			}
		});

		table.bindToModel(
				new WritableList(records, CollectionJournalLine.class),
				CollectionJournalLine.class, propertyNames, columnNames); //$NON-NLS-
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
		((IActionRidget) getRidget(ViewWidgetId.addButton))
		.addListener(new IActionListener() {

			@Override
			public void callback() {
				addButtonClicked();
			}

		});

		((IActionRidget) getRidget(ViewWidgetId.entryInputClear))
		.addListener(new IActionListener() {

			@Override
			public void callback() {
				clearMilkJournalGroupButtonClicked();
			}

		});

		((IActionRidget) getRidget(ViewWidgetId.modifyButton))
		.addListener(new IActionListener() {

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

		((IActionRidget) getRidget(ViewWidgetId.deleteButton))
		.addListener(new IActionListener() {

			@Override
			public void callback() {
				deleteJournalEntryButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.clearButton))
		.addListener(new IActionListener() {

			@Override
			public void callback() {
				clearAllJournalEntiresButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.saveButton))
		.addListener(new IActionListener() {

			@Override
			public void callback() {
				createAndSaveCollectionJournalPage();
			}
		});

		updateBottomButtons(false);
		totalLabelRidget = getRidget(ILabelRidget.class,
				ViewWidgetId.totalLabel);
		totalLabelRidget.bindToModel(PojoObservables.observeValue(totalValue,
		"total"));
		totalLabelRidget.updateFromModel();

	}

	@Override
	public void afterBind() {
		super.afterBind();
		setSubGroupsVisible(false);
	}

	private void setSubGroupsVisible(boolean visble) {
		if (journalNumber != null) {
			((Control) journalNumber.getUIControl()).getParent().setVisible(
					visble);
		}
		if (memberText != null) {
			((Control) memberText.getUIControl()).getParent().getParent()
			.setVisible(visble);
		}
		if (table != null) {
			((Control) table.getUIControl()).getParent().getParent()
			.getParent().setVisible(visble);
		}
	}

	private class GroupOneSelectionListener implements ISelectionListener {

		@Override
		public void ridgetSelected(SelectionEvent event) {
			if ((routeRidget.getSelection() != null)
					&& (vehicleRidget.getSelection() != null)
					&& (vehicleRidget.getSelection() != null)
					&& (driverRidget.getSelection() != null)) {
				setSubGroupsVisible(true);
			} else {
				setSubGroupsVisible(false);
			}
		}
	}

	private void updateBottomButtons(boolean enable) {
		((IActionRidget) getRidget(ViewWidgetId.modifyButton))
		.setEnabled(enable);
		((IActionRidget) getRidget(ViewWidgetId.deleteButton))
		.setEnabled(enable);
	}

	private List<Route> getRoutesList() {
		return dairyRepo.allRoutes();
	}

	private List<DairyContainer> getBins() {
		return dairyRepo.getDairyBins();
	}

	private List<Vehicle> getVehiclesList() {
		return dairyRepo.getVehicles();
	}

	private List<Employee> getDriverList() {
		return dairyRepo.getEmployees("Driver");
	}

	private void updateRecordLineNumbers() {
		int counter = 0;
		double total = 0;

		for (final CollectionJournalLine line : records) {
			line.setLineNumber(counter++);
			total += line.getQuantity();
		}
		totalValue.setTotal(total);
	}

	private class TotalRecordsValue {
		/**
		 * 
		 */
		private double total;

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}
	}

	private void createAndSaveCollectionJournalPage() {
		final CollectionJournalPage newJournal = DairyFactory.eINSTANCE
		.createCollectionJournalPage();
		newJournal.setDriver((Employee) driverRidget.getSelection());
		newJournal.setSession((Session) sessionRidget.getSelection());
		newJournal.setRoute((Route) routeRidget.getSelection());
		newJournal.setVehicle((Vehicle) vehicleRidget.getSelection());
		final Date date = new SimpleFormattedDateBean(dateRidget.getText())
		.getDate();
		newJournal.setJournalDate(date);

		final double driverTotal = new Double(
				NumericTextRidget.ungroup(journalTotlal.getText()))
		.doubleValue();

		final double recordTotal = totalValue.getTotal();
		if (driverTotal != recordTotal) {
			MessageDialog
			.openError(Display.getDefault().getActiveShell(),
					"Error Save Collection Journal",
			"Journal Total value doesn't match collection journal records total.");
			return;
		}
		newJournal.setDriverTotal(new BigDecimal(driverTotal));
		newJournal.setRecordTotal(new BigDecimal(recordTotal));
		for (final CollectionJournalLine record : records) {
			record.setCollectionJournal(newJournal);
		}
		newJournal.getJournalEntries().addAll(records);

		dairyRepo.addJournalPage(newJournal);
		setSubGroupsVisible(false);
	}

	private void clearMilkJournalInputs() {
		memberText.setText("");
		canText.setText("");
		quantityText.setText("");
		nprMissingButton.setSelected(false);
		rejectedButton.setSelected(false);
		memberText.setFocusable(true);
	}

	private void addSimpleListener() {
		// getNavigationNode().addSimpleListener(new
		// MilkCollectionNodeListener());
	}

	private void addButtonClicked() {

		final CollectionJournalLine aRecord = DairyFactory.eINSTANCE
		.createCollectionJournalLine();
		/**
		 * todo should get container based on the CAN ID, now I created manually
		 */
		final String quaitityTextStr = NumericTextRidget.ungroup(quantityText
				.getText());

		final String memberId = memberText.getText();
		final Membership mship = dairyRepo.getMembershipById(memberId);
		if (mship == null) {
			if (mship == null) {
				if (!MessageDialog
						.openConfirm(
								Display.getDefault().getActiveShell(),
								"Error Create Collection Journal Record",
								"Can't find valid membership for "
								+ memberId
								+ ". The record will be marked as Flagged. Do you want to continue create a new record? ")) {
					return;
				}
			}
		}

		final String canId = canText.getText();
		final Container can = dairyRepo.getContainerById(canId);
		if (can == null) {
			if (!MessageDialog
					.openConfirm(
							Display.getDefault().getActiveShell(),
							"Error Create Collection Journal Record",
							"Can't find container for "
							+ canId
							+ ". Do you want to continue create a new record? ")) {
				return;
			}
		}
		// can.setContainerId(canText.getText());
		aRecord.setFarmContainer(can);
		aRecord.setRecordedMember(memberText.getText());
		aRecord.setDairyContainer((DairyContainer) binCombo.getSelection());
		aRecord.setQuantity(new Double(quaitityTextStr).doubleValue());
		aRecord.setNotRecorded(nprMissingButton.isSelected());
		aRecord.setRejected(rejectedButton.isSelected());
		aRecord.setValidatedMember(mship);
		if (mship == null) {
			aRecord.setFlagged(true);
		}
		records.add(aRecord);
		updateRecordLineNumbers();
		table.updateFromModel();
		totalLabelRidget.updateFromModel();
	}

	private void clearMilkJournalGroupButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Clear Input", "Do you want to clear input fields?")) {
			clearMilkJournalInputs();
		}
	}

	private void deleteJournalEntryButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Delete Milk Collection Records",
		"Do you want to delete the selected milk collection records?")) {
			final List<Object> selectedRecords = table.getSelection();
			if (selectedRecords != null) {
				records.removeAll(selectedRecords);
			}
			updateRecordLineNumbers();
			table.updateFromModel();
			totalLabelRidget.updateFromModel();
		}
	}

	private void clearAllJournalEntiresButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Delete Milk Collection Records",
		"Do you want to delete all milk collection records?")) {
			records.clear();
			updateRecordLineNumbers();
			table.updateFromModel();
			totalLabelRidget.updateFromModel();
		}
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
