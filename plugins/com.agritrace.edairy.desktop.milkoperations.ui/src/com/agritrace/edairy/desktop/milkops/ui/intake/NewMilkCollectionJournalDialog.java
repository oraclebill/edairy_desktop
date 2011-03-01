package com.agritrace.edairy.desktop.milkops.ui.intake;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
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

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyLocationRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class NewMilkCollectionJournalDialog extends TitleAreaDialog {

	private final IDairyRepository dairyRepository;
//	private final IDairyLocationRepository dairyLocationRepo;
	private final IRepository<CollectionSession> sessionRepo;
	private DateTime datePicker;
	private CCombo driverCombo;
	private final CollectionGroup newJournalPage;

	private CCombo centerCombo;
	private CCombo sessionCombo;
	private CCombo vehicleCombo;
	private List<Employee> drivers;
	private List<Vehicle> vehicles;

	@Inject
	public NewMilkCollectionJournalDialog(@Named("current") final Shell parentShell,
			final IDairyRepository dairyRepository, final IDairyLocationRepository dairyLocationRepo,
			final IRepository<CollectionSession> sessionRepo) {
		super(parentShell);
		this.dairyRepository = dairyRepository;
//		this.dairyLocationRepo = dairyLocationRepo;
		this.sessionRepo = sessionRepo;
		newJournalPage = DairyFactory.eINSTANCE.createCollectionGroup();
		newJournalPage.setType(CollectionGroupType.JOURNAL_GROUP);
	}

	public CollectionGroup getNewJournalPage() {
		final String refNum = newJournalPage.getReferenceNumber();

		if (refNum == null || refNum.trim().length() == 0) {
			newJournalPage.setReferenceNumber("REF-" + newJournalPage.hashCode());
		}

		return newJournalPage;
	}

	private void configureRidgets() {

		// create/configure ridgets
		final IDateTimeRidget dateTime = (IDateTimeRidget) SwtRidgetFactory.createRidget(datePicker);
		final IComboRidget center = (IComboRidget) SwtRidgetFactory.createRidget(centerCombo);
		final IComboRidget vehicle = (IComboRidget) SwtRidgetFactory.createRidget(vehicleCombo);
		final IComboRidget session = (IComboRidget) SwtRidgetFactory.createRidget(sessionCombo);
		final IComboRidget driver = (IComboRidget) SwtRidgetFactory.createRidget(driverCombo);
		// final ITextRidget file = (ITextRidget)
		// SwtRidgetFactory.createRidget(fileNumber);

		final PropertyChangeListener validationListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				final boolean isValid =
					/* newJournalPage.getRoute() != null
					&& */ newJournalPage.getSession() != null
					&& newJournalPage.getDriver() != null
					&& newJournalPage.getJournalDate() != null
					&& newJournalPage.getVehicle() != null;

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

			}

			private void debugPrintEvent(PropertyChangeEvent evt) {
				final StringBuilder sb = new StringBuilder();
				final Formatter f = new Formatter(sb, Locale.getDefault());
				System.err.println(f.format("[%s] %s: new=(%s) old=(%s)", evt.getSource(), evt.getPropertyName(),
						evt.getNewValue(), evt.getOldValue()));

			}
		}

		final UpdateListener fileNumberUpdateListener = new UpdateListener();

		// configure ridgets
		dateTime.addPropertyChangeListener(fileNumberUpdateListener);
		dateTime.addPropertyChangeListener(validationListener);

		center.setMandatory(true);
		center.addPropertyChangeListener(fileNumberUpdateListener);
		center.addPropertyChangeListener(validationListener);


		vehicle.setMandatory(true);
		vehicle.addPropertyChangeListener(validationListener);

		session.setMandatory(true);
		session.addPropertyChangeListener(validationListener);

		driver.setMandatory(true);
		driver.addPropertyChangeListener(validationListener);

		// bind ridgets

		dateTime.bindToModel(EMFObservables.observeValue(newJournalPage,
				DairyPackage.Literals.COLLECTION_GROUP__JOURNAL_DATE));

		final Dairy localDairy = dairyRepository.getLocalDairy();

		try {
			final List<DairyLocation> centers = localDairy.getBranchLocations();
			center.bindToModel(new WritableList(centers, DairyLocation.class), DairyLocation.class, "getCode",
					PojoObservables.observeValue( newJournalPage,
							DairyPackage.Literals.COLLECTION_GROUP__COLLECTION_CENTER.getName()));
			center.setSelection(localDairy.getRoutes().get(0));
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try {
			vehicles = new ArrayList<Vehicle>(localDairy.getVehicles());

			vehicle.bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class, "getRegistrationNumber",
					PojoObservables.observeValue(newJournalPage,
							DairyPackage.Literals.COLLECTION_GROUP__VEHICLE.getName()));

			vehicle.setSelection(localDairy.getVehicles().get(0));
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try {
			final List<CollectionSession> sessions = sessionRepo.all();

			session.bindToModel(new WritableList(sessions, CollectionSession.class),
					CollectionSession.class, "getCode",
					PojoObservables.observeValue(newJournalPage,
							DairyPackage.Literals.COLLECTION_GROUP__SESSION.getName()));
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try {
			drivers = createEmployeeList(localDairy);
			driver.bindToModel(
					new WritableList(drivers, Employee.class),
					Employee.class,
					"getFamilyName",
					PojoObservables.observeValue(newJournalPage,
							DairyPackage.Literals.COLLECTION_GROUP__DRIVER.getName()));
			driver.setSelection(drivers.get(0));
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// update initial values

		newJournalPage.setJournalDate(new Date());

		dateTime.updateFromModel();
		center.updateFromModel();
		vehicle.updateFromModel();
		session.updateFromModel();
		driver.updateFromModel();

		center.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				final DairyLocation loc = newJournalPage.getCollectionCenter();
				final TransportRoute route = loc.getRoute();

				if (route != null && route.getVehicle() != null) {
					newJournalPage.setVehicle(route.getVehicle());
					vehicle.updateFromModel();
				}
			}
		});

		vehicle.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				final Vehicle vehicle = newJournalPage.getVehicle();

				if (vehicle != null && vehicle.getDriver() != null) {
					newJournalPage.setDriver(vehicle.getDriver());
					driver.updateFromModel();
				}
			}
		});
	}

	private List<Employee> createEmployeeList(Dairy dairy) {
		final List<Employee> driverList = new LinkedList<Employee>();
		for (final Employee emp : dairy.getEmployees()) {
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
		setMessage("Please enter the date, session, and transport route for this set of collections records.");
		return contents;
	}

	@Override
	protected void initializeBounds() {
		super.initializeBounds();
		getShell().setSize(370, getShell().getSize().y);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite buffer = (Composite) super.createDialogArea(parent);
		final Composite workArea = UIControlsFactory.createComposite(buffer);
		GridLayoutFactory.swtDefaults().numColumns(2).spacing(8, 8).margins(6, 6).generateLayout(workArea);
		workArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final int widgetWidth = 250;

		{
			final Composite panel = workArea;
			{
				final Label label = UIControlsFactory.createLabel(panel, "Date");
				GridDataFactory.swtDefaults().hint(80, -1).applyTo(label);
				datePicker = UIControlsFactory.createDate(panel, SWT.BORDER, ViewConstants.DATE_PICKER);
				GridDataFactory.swtDefaults().hint(widgetWidth, -1).applyTo(datePicker);
			}
			{
				UIControlsFactory.createLabel(panel, "Session");
				sessionCombo = UIControlsFactory.createCCombo(panel, ViewConstants.SESSION);
				GridDataFactory.swtDefaults().hint(widgetWidth, -1).applyTo(sessionCombo);
			}
			{
				UIControlsFactory.createLabel(panel, "Collection Center");
				centerCombo = UIControlsFactory.createCCombo(panel, ViewConstants.COLLECTION_CENTER);
				GridDataFactory.swtDefaults().hint(widgetWidth, -1).applyTo(centerCombo);
			}
			// {
			// UIControlsFactory.createLabel(panel, "Reference Number");
			// fileNumber = UIControlsFactory.createText(panel, SWT.BORDER,
			// ViewConstants.REFERENCE_NUMBER);
			// GridDataFactory.swtDefaults().hint(100, -1).applyTo(fileNumber);
			// }
			// GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(panel);
		}
		{
			final Composite panel = workArea;
			{
				UIControlsFactory.createLabel(panel, "Driver");
				driverCombo = UIControlsFactory.createCCombo(panel, ViewConstants.DRIVER);
				GridDataFactory.swtDefaults().hint(widgetWidth, -1).applyTo(driverCombo);
			}
			{
				final Label label = UIControlsFactory.createLabel(panel, "Vehicle");
				GridDataFactory.swtDefaults().hint(80, -1).applyTo(label);
				vehicleCombo = UIControlsFactory.createCCombo(panel, ViewConstants.VEHICLE);
				GridDataFactory.swtDefaults().hint(widgetWidth, -1).applyTo(vehicleCombo);
			}
			// GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(panel);
		}

		return buffer;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Milk Collection Journal");
	}

}
