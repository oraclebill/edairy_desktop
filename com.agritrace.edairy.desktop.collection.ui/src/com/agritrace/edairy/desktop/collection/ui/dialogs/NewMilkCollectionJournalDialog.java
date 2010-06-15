package com.agritrace.edairy.desktop.collection.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.beans.common.TypedBean;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class NewMilkCollectionJournalDialog extends TitleAreaDialog {

	private DatePickerComposite datePicker;
	private CCombo routeCombo;
	private CCombo vehicleCombo;
	private CCombo sessionCombo;
	private CCombo driverCombo;

	private final DairyRepository dairyRepository = new DairyRepository();
	private final CollectionJournalPage newJournalPage = DairyFactory.eINSTANCE.createCollectionJournalPage();	
	
	public NewMilkCollectionJournalDialog(Shell parentShell) {
		super(parentShell);
	}

	public CollectionJournalPage getNewJournalPage() {
		return newJournalPage;
	}

	@Override
	protected Control createContents(Composite parent) {
		final Control contents = super.createContents(parent);
		setTitle("Create New Journal Book");
		setMessage("Please enter the details for the new Journal Book.");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite buffer = (Composite) super.createDialogArea(parent);
		final Composite workArea = UIControlsFactory.createComposite(buffer);
		workArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		// workArea.setLayout(new GridLayout(3, true));
		{
			final Label label = UIControlsFactory.createLabel(workArea, "Date");
			datePicker = UIControlsFactory.createDatePickerComposite(workArea, "date-picker");
			((GridData) datePicker.getTextfield().getLayoutData()).grabExcessVerticalSpace = false;
			final Label filler = UIControlsFactory.createLabel(workArea, "");
		}
		{
			final Label label = UIControlsFactory.createLabel(workArea, "Route");
			routeCombo = UIControlsFactory.createCCombo(workArea, "route");
			final Label filler = UIControlsFactory.createLabel(workArea, "");
		}
		{
			final Label label = UIControlsFactory.createLabel(workArea, "Vehicle");
			vehicleCombo = UIControlsFactory.createCCombo(workArea, "vehicle");
			final Label filler = UIControlsFactory.createLabel(workArea, "");
		}
		{
			final Label label = UIControlsFactory.createLabel(workArea, "Session");
			sessionCombo = UIControlsFactory.createCCombo(workArea, "sesison");
			final Label filler = UIControlsFactory.createLabel(workArea, "");
		}
		{
			final Label label = UIControlsFactory.createLabel(workArea, "Driver");
			driverCombo = UIControlsFactory.createCCombo(workArea, "driver");
			final Label filler = UIControlsFactory.createLabel(workArea, "");
		}
		GridLayoutFactory.swtDefaults().numColumns(3).equalWidth(true).generateLayout(workArea);
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL);

		configureRidgets();

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
		final Button okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);

	}

	@Override
	protected Control createButtonBar(Composite parent) {
		// TODO Auto-generated method stub
		return super.createButtonBar(parent);
	}

	private void configureRidgets() {
		// create/configure ridgets
		final IDateTextRidget dateTime = (IDateTextRidget)SwtRidgetFactory.createRidget(datePicker);
		final IComboRidget route = (IComboRidget)SwtRidgetFactory.createRidget(routeCombo);
		final IComboRidget vehicle = (IComboRidget)SwtRidgetFactory.createRidget(vehicleCombo);
		final IComboRidget session = (IComboRidget)SwtRidgetFactory.createRidget(sessionCombo);
		final IComboRidget driver = (IComboRidget)SwtRidgetFactory.createRidget(driverCombo);

		// configure ridgets
		dateTime.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		dateTime.setMandatory(true);
		route.setMandatory(true);
//		route.setOutputOnly(true);
		vehicle.setMandatory(true);
		session.setMandatory(true);
		driver.setMandatory(true);

		// bind ridgets
		// bind date
		dateTime.bindToModel(EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE));
		dateTime.setText(DateTimeUtils.DATE_FORMAT.format(new Date()));

		route.bindToModel(new WritableList(dairyRepository.allRoutes(), Route.class),
				Route.class, "getName",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE));
		vehicle.bindToModel(new WritableList(dairyRepository.getVehicles(), Vehicle.class),
				Vehicle.class, "getLogBookNumber",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__VEHICLE));
		session.bindToModel(Observables.staticObservableList(Arrays.asList(Session.values(), Session.class)),
				Session.class, "getName",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION));
		driver.bindToModel(new WritableList(dairyRepository.getEmployees("Driver"), Employee.class),
				Employee.class, "getFamilyName",
				EMFObservables.observeValue(newJournalPage, DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER));
		
		
		//dateTime.updateFromModel();
		route.updateFromModel();
		vehicle.updateFromModel();
		session.updateFromModel();
		driver.updateFromModel();
		
	}

}
