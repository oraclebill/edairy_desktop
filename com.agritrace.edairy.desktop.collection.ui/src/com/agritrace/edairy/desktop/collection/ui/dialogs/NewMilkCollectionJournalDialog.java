package com.agritrace.edairy.desktop.collection.ui.dialogs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class NewMilkCollectionJournalDialog extends TitleAreaDialog {

	private final IDairyRepository dairyRepository = DairyRepository.getInstance();
	private DateTime datePicker;
	private CCombo driverCombo;
	private final CollectionJournalPage newJournalPage = DairyFactory.eINSTANCE.createCollectionJournalPage();

	private CCombo routeCombo;
	private CCombo sessionCombo;
	private CCombo vehicleCombo;

	public NewMilkCollectionJournalDialog(Shell parentShell) {
		super(parentShell);
	}

	public CollectionJournalPage getNewJournalPage() {
		final String refNum = newJournalPage.getReferenceNumber();
		if (refNum == null || refNum.trim().length() == 0) {
			newJournalPage.setReferenceNumber("REF-" + newJournalPage.hashCode()); // TODO:
																					// need
																					// something
																					// unique,
																					// but
																					// can
																					// do
																					// better...
		}
		return newJournalPage;
	}

	private void configureRidgets() {
		// create/configure ridgets
		final IDateTimeRidget dateTime = (IDateTimeRidget) SwtRidgetFactory.createRidget(datePicker);
		final IComboRidget route = (IComboRidget) SwtRidgetFactory.createRidget(routeCombo);
		final IComboRidget vehicle = (IComboRidget) SwtRidgetFactory.createRidget(vehicleCombo);
		final IComboRidget session = (IComboRidget) SwtRidgetFactory.createRidget(sessionCombo);
		final IComboRidget driver = (IComboRidget) SwtRidgetFactory.createRidget(driverCombo);
		// final ITextRidget file = (ITextRidget)
		// SwtRidgetFactory.createRidget(fileNumber);

		final PropertyChangeListener validationListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				final boolean isValid = true;

				// broken
				// isValid = isValid && route.isErrorMarked() ||
				// route.isMandatory() && route.getText().isEmpty();
				// isValid = isValid && vehicle.isErrorMarked() ||
				// vehicle.isMandatory() && vehicle.getText().isEmpty();
				// isValid = isValid && session.isErrorMarked() ||
				// session.isMandatory() && session.getText().isEmpty();
				// isValid = isValid && driver.isErrorMarked() ||
				// driver.isMandatory() && driver.getText().isEmpty();
				// isValid = isValid && file.isErrorMarked() ||
				// file.isMandatory() && file.getText().isEmpty();
				final Button okButton = getButton(IDialogConstants.OK_ID);
				if (null != okButton) {
					okButton.setEnabled(isValid); // TODO: npe
				}
			}
		};
		class UpdateListener implements PropertyChangeListener, FocusListener {

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// todo: remove
				debugPrintEvent(evt);

				// if (auto) {
				// if (!focus) {
				// assert (evt.getSource() != file);
				// updateFileNumber();
				// } else {
				// assert (evt.getSource() == file);
				// if (evt.getPropertyName().equals("text")) {
				// oldTxt = (String) evt.getNewValue();
				// } else if (evt.getPropertyName().equals("textAfter")) {
				// final String newTxt = (String) evt.getNewValue();
				// if ((null != oldTxt) && (null != newTxt) &&
				// !oldTxt.equals(newTxt)) {
				// auto = false;
				// }
				// }
				// }
				// }
			}

			private void debugPrintEvent(PropertyChangeEvent evt) {
				final StringBuilder sb = new StringBuilder();
				final Formatter f = new Formatter(sb, Locale.getDefault());
				System.err.println(f.format("[%s] %s: new=(%s) old=(%s)", evt.getSource(), evt.getPropertyName(),
						evt.getNewValue(), evt.getOldValue()));

			}

			private void updateFileNumber() {
				// StringBuilder sb = new StringBuilder();
				// Formatter f = new Formatter(sb, Locale.getDefault());
				// Date date = dateTime.getDate();
				// file.setText(f.format("%4s[%4s]-%04d%02d%02d",
				// route.getText(), session.getText(),
				// date.getYear(), date.getMonth(), date.getDate()).toString());
				// file.setText(f.format("%s[%s]-%s",
				// newJournalPage.getRoute().getCode(),
				// newJournalPage.getSession().getLiteral(),
				// newJournalPage.getJournalDate()).toString());
				// TODO:
				// file.setText("1");
			}
		}

		final UpdateListener fileNumberUpdateListener = new UpdateListener();

		// configure ridgets
		// dateTime.setMandatory(true);
		// dateTime.setDirectWriting(true); // not supported by datetime
		dateTime.addPropertyChangeListener(fileNumberUpdateListener);
		dateTime.addPropertyChangeListener(validationListener);

		route.setMandatory(true);
		// route.setModelToUIControlConverter(new ComboConverter("getName"));
		route.addPropertyChangeListener(fileNumberUpdateListener);
		route.addPropertyChangeListener(validationListener);
		// route.setOutputOnly(true);

		// file.setMandatory(true);
		// file.setDirectWriting(true);
		// file.addPropertyChangeListener(fileNumberUpdateListener);
		// file.addPropertyChangeListener(validationListener);

		vehicle.setMandatory(true);
		// vehicle.setModelToUIControlConverter(new
		// ComboConverter("getLogBookNumber"));
		vehicle.addPropertyChangeListener(validationListener);

		session.setMandatory(true);
		// session.setModelToUIControlConverter(new ComboConverter("getName"));
		session.addPropertyChangeListener(validationListener);

		driver.setMandatory(true);
		// driver.setModelToUIControlConverter(new
		// ComboConverter("getFamilyName"));
		driver.addPropertyChangeListener(validationListener);

		// bind ridgets

		dateTime.bindToModel(EMFObservables.observeValue(newJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE));

		Dairy localDairy = dairyRepository.getLocalDairy();

		try {
			route.bindToModel(localDairy, "routes", Route.class, "getName", newJournalPage,
					DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE.getName());
			route.setSelection(localDairy.getRoutes().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			vehicle.bindToModel(localDairy, "vehicles", Vehicle.class, "getRegistrationNumber", newJournalPage, 
					DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__VEHICLE.getName());
			vehicle.setSelection(localDairy.getVehicles().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			session.bindToModel(
					Observables.staticObservableList(Session.VALUES),
					Session.class,
					"getName",
					PojoObservables.observeValue(newJournalPage,
							DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION.getName()));
			session.setSelection(Session.VALUES.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			List<Employee> drivers = createEmployeeList(localDairy);
			driver.bindToModel(
					new WritableList(drivers, Employee.class),
					Employee.class,
					"getFamilyName",
					PojoObservables.observeValue(newJournalPage,
							DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER.getName()));
			driver.setSelection(drivers.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// update initial values

		newJournalPage.setJournalDate(new Date());
		dateTime.updateFromModel();
		route.updateFromModel();
		vehicle.updateFromModel();
		session.updateFromModel();
		driver.updateFromModel();

	}

	private List<Employee> createEmployeeList(Dairy dairy) {
		List<Employee> driverList = new LinkedList<Employee>();
		for (Employee emp : dairy.getEmployees()) {
			final String job = emp.getJobFunction();
			if (job != null && job.equals("Driver")) {
				driverList.add(emp);
			}
		}
		return driverList;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		// TODO Auto-generated method stub
		return super.createButtonBar(parent);
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent
	 *            the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);
		final Button okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setEnabled(false);

	}

	@Override
	protected Control createContents(Composite parent) {
		final Control contents = super.createContents(parent);
		configureRidgets();
		setTitle("Create New Collections Journal File");
		setMessage("Please enter the date, session, and route for this set of collections records.");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite buffer = (Composite) super.createDialogArea(parent);
		final Composite workArea = UIControlsFactory.createComposite(buffer);
		workArea.setLayout(new GridLayout(3, false));
		workArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		// workArea.setLayout(new GridLayout(3, true));
		{
			final Composite panel = UIControlsFactory.createComposite(workArea);
			{
				final Label label = UIControlsFactory.createLabel(panel, "Date");
				GridDataFactory.swtDefaults().hint(80, -1).applyTo(label);
				datePicker = UIControlsFactory.createDate(panel, 0, ViewConstants.DATE_PICKER);
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(datePicker);
			}
			{
				UIControlsFactory.createLabel(panel, "Session");
				sessionCombo = UIControlsFactory.createCCombo(panel, ViewConstants.SESSION);
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(sessionCombo);
			}
			{
				UIControlsFactory.createLabel(panel, "Route");
				routeCombo = UIControlsFactory.createCCombo(panel, ViewConstants.ROUTE);
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(routeCombo);
			}
			// {
			// UIControlsFactory.createLabel(panel, "Reference Number");
			// fileNumber = UIControlsFactory.createText(panel, SWT.BORDER,
			// ViewConstants.REFERENCE_NUMBER);
			// GridDataFactory.swtDefaults().hint(100, -1).applyTo(fileNumber);
			// }
			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(panel);
		}
		{
			final Composite panel = UIControlsFactory.createComposite(workArea);
			{
				UIControlsFactory.createLabel(panel, "Driver");
				driverCombo = UIControlsFactory.createCCombo(panel, ViewConstants.DRIVER);
			}
			{
				final Label label = UIControlsFactory.createLabel(panel, "Vehicle");
				GridDataFactory.swtDefaults().hint(80, -1).applyTo(label);
				vehicleCombo = UIControlsFactory.createCCombo(panel, ViewConstants.VEHICLE);
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(vehicleCombo);
			}
			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(panel);
		}
		GridLayoutFactory.swtDefaults().numColumns(1).spacing(8, 8).generateLayout(workArea);

		return buffer;
	}
}
