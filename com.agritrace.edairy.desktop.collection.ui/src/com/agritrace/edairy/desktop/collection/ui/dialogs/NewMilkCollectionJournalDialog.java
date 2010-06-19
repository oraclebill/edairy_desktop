package com.agritrace.edairy.desktop.collection.ui.dialogs;

import java.text.DateFormat;
import java.util.Formatter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;

public class NewMilkCollectionJournalDialog extends TitleAreaDialog {

	private DateTime datePicker;
	private CCombo routeCombo;
	private CCombo vehicleCombo;
	private CCombo sessionCombo;
	private CCombo driverCombo;

	private final IDairyRepository dairyRepository = new DairyRepository();
	private final CollectionJournalPage newJournalPage = DairyFactory.eINSTANCE.createCollectionJournalPage();
	private Text fileNumber;

	public NewMilkCollectionJournalDialog(Shell parentShell) {
		super(parentShell);
	}

	public CollectionJournalPage getNewJournalPage() {
		return newJournalPage;
	}

	@Override
	protected Control createContents(Composite parent) {
		final Control contents = super.createContents(parent);
		configureRidgets();
		setTitle("Create New Collections Journal File");
		setMessage("Please enter the date, session, route and file number for this set of collections records.");
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
			Composite panel = UIControlsFactory.createComposite(workArea);
			{
				final Label label = UIControlsFactory.createLabel(panel, "Date");
				GridDataFactory.swtDefaults().hint(80, -1).applyTo(label);
				datePicker = UIControlsFactory.createDate(panel, 0, "date-picker");
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(datePicker);
			}
			{
				final Label label = UIControlsFactory.createLabel(panel, "Session");
				sessionCombo = UIControlsFactory.createCCombo(panel, "sesison");
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(sessionCombo);
			}
			{
				final Label label = UIControlsFactory.createLabel(panel, "Route");
				routeCombo = UIControlsFactory.createCCombo(panel, "route");
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(routeCombo);
			}
			{
				Label lblFileNumber = UIControlsFactory.createLabel(panel, "File Number");
				fileNumber = UIControlsFactory.createText(panel, SWT.BORDER, "fileNumber");
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(fileNumber);
			}
			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(panel);
		}
		{
			Composite panel = UIControlsFactory.createComposite(workArea);
			{
				final Label label = UIControlsFactory.createLabel(panel, "Vehicle");
				GridDataFactory.swtDefaults().hint(80, -1).applyTo(label);
				vehicleCombo = UIControlsFactory.createCCombo(panel, "vehicle");
				GridDataFactory.swtDefaults().hint(100, -1).applyTo(vehicleCombo);
			}
			{
				final Label label = UIControlsFactory.createLabel(panel, "Driver");
				driverCombo = UIControlsFactory.createCCombo(panel, "driver");
			}
			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(panel);
		}
		GridLayoutFactory.swtDefaults().numColumns(1).spacing(8, 8).generateLayout(workArea);

		return buffer;
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
	protected Control createButtonBar(Composite parent) {
		// TODO Auto-generated method stub
		return super.createButtonBar(parent);
	}

	private void configureRidgets() {
		// create/configure ridgets
		final IDateTimeRidget dateTime = (IDateTimeRidget) SwtRidgetFactory.createRidget(datePicker);
		final IComboRidget route = (IComboRidget) SwtRidgetFactory.createRidget(routeCombo);
		final IComboRidget vehicle = (IComboRidget) SwtRidgetFactory.createRidget(vehicleCombo);
		final IComboRidget session = (IComboRidget) SwtRidgetFactory.createRidget(sessionCombo);
		final IComboRidget driver = (IComboRidget) SwtRidgetFactory.createRidget(driverCombo);
		final ITextRidget file = (ITextRidget) SwtRidgetFactory.createRidget(fileNumber);

		final PropertyChangeListener validationListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				boolean isValid = true;

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
				Button okButton = getButton(IDialogConstants.OK_ID);
				if (null != okButton)
					okButton.setEnabled(isValid); // TODO: npe
			}
		};
		class UpdateListener implements PropertyChangeListener, FocusListener {

			private boolean auto = true;
			private boolean focus = false;
			private String oldTxt = null;

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// todo: remove
				debugPrintEvent(evt);

				if (auto) {
					if (!focus) {
						assert(evt.getSource() != file);
						updateFileNumber();
					} else {
						assert(evt.getSource() == file);
						if (evt.getPropertyName().equals("text")) {
							oldTxt = (String) evt.getNewValue();
						} else if (evt.getPropertyName().equals("textAfter")) {
							String newTxt = (String) evt.getNewValue();
							if (null != oldTxt && null != newTxt && !oldTxt.equals(newTxt)) {
								auto = false;
							}
						}
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				focus = true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				focus = false;
			}

			private void updateFileNumber() {
				StringBuilder sb = new StringBuilder();
				Formatter f = new Formatter(sb, Locale.getDefault());
				Date date = dateTime.getDate();
				file.setText(f.format("%4s[%4s]-%04d%02d%02d", route.getText(), session.getText(),
						date.getYear(), date.getMonth(), date.getDate()).toString());
//				file.setText(f.format("%s[%s]-%s", 
//						newJournalPage.getRoute().getCode(),
//						newJournalPage.getSession().getLiteral(), 
//						newJournalPage.getJournalDate()).toString());
			}

			private void debugPrintEvent(PropertyChangeEvent evt) {
				StringBuilder sb = new StringBuilder();
				Formatter f = new Formatter(sb, Locale.getDefault());
				System.err.println(f.format("[%s] %s: %s (%s)", evt.getSource(), evt.getPropertyName(),
						evt.getNewValue(), evt.getOldValue()));

			}
		}
		
		final UpdateListener fileNumberUpdateListener = new UpdateListener();

		// configure ridgets
		// dateTime.setMandatory(true);
		// dateTime.setDirectWriting(true);  // not supported by datetime
		dateTime.addPropertyChangeListener(fileNumberUpdateListener);
		dateTime.addPropertyChangeListener(validationListener);

		route.setMandatory(true);
		route.addPropertyChangeListener(fileNumberUpdateListener);
		route.addPropertyChangeListener(validationListener);
		// route.setOutputOnly(true);

		file.setMandatory(true);
		file.setDirectWriting(true);
		file.addPropertyChangeListener(fileNumberUpdateListener);
		file.addPropertyChangeListener(validationListener);

		vehicle.setMandatory(true);
		vehicle.addPropertyChangeListener(validationListener);

		session.setMandatory(true);
		session.addPropertyChangeListener(validationListener);

		driver.setMandatory(true);
		driver.addPropertyChangeListener(validationListener);

		// bind ridgets

		dateTime.bindToModel(EMFObservables.observeValue(newJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE));

		final List<Route> routes = dairyRepository.allRoutes();
		route.bindToModel(new WritableList(routes, Route.class), Route.class, "getName",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE));
//		if (routes.size() > 0) route.setSelection(0);
		
		file.bindToModel(EMFObservables.observeValue(newJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER));

		final List<Vehicle> vehicles =dairyRepository.allVehicles(); 
		vehicle.bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class,
				"getLogBookNumber",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__VEHICLE));
//		if (vehicles.size() > 0) vehicle.setSelection(0);

		final List<Session> sessions = Arrays.asList(Session.values());
		session.bindToModel(new WritableList(sessions, Session.class), Session.class, null,
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION));
//		if (sessions.size() > 0) session.setSelection(0);
		
		List<Employee> employees = dairyRepository.employeesByPosition("Driver");
		driver.bindToModel(new WritableList(employees, Employee.class),
				Employee.class, "getFamilyName",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER));
//		if (employees.size() > 0) driver.setSelection(0);
		
		// update initial values

		newJournalPage.setJournalDate(new Date());
		dateTime.updateFromModel();
		route.updateFromModel();
		vehicle.updateFromModel();
		session.updateFromModel();
		driver.updateFromModel();

	}
}
