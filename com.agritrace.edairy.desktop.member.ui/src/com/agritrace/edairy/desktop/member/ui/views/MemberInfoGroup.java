package com.agritrace.edairy.desktop.member.ui.views;

import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;

public class MemberInfoGroup {

    public static final String memberId = "Member ID:";
    public static final String firstName = "Name:";
    public static final String lastName = "Last Name:";

    public static final String applicationDate = "Application Date:";
    public static final String effectiveDate = "Effective Date:";
    public static final String status = "Status:";

    public static final String phoneNumber = "Phone Number:";
    public static final String route = "Route:";
    public static final String stops = "Stops:";
    // address group
    public static final String ADDRESS_TAB = "Address";
    public static final String ADDRESS_LABEL = "Address:";
    public static final String SECTION_LABEL = "Section/Homestead:";
    public static final String ESTATE_LABEL = "Estate/Nearest Center:";
    public static final String LOCATION_LABEL = "Location:";
    public static final String SUBLOCATION_LABEL = "Sublocation";
    public static final String VILLAGE_LABEL = "Village:";
    public static final String DIVISION_LABEL = "Division";
    public static final String DISTRICT_LABEL = "District:";
    public static final String PROVINCE_LABEL = "Province:";
    public static final String POSTAL_CODE_LABEL = "Postal Code:";

    private final Composite composite;
    private Text txtId;
    private Text txtFirst;
//    private Text txtLast;
    private Label photoLabel;
    private Text dateText;
    private Text effectDateText;
    private ComboViewer comboStatus;
    private Text txtPhone;
//    private List listStops;
//    private Text txtRoute;
    private Membership memberShip;
//    private ListViewer stopsViewer;

    private final DataBindingContext bindingContext;

//    private ArrayList<Binding> bindingList;

    public MemberInfoGroup(Composite parent) {
	composite = UIControlsFactory.createComposite(parent);
	composite.setLayout(new GridLayout(1, false));
	memberShip = DairyFactory.eINSTANCE.createMembership();
	bindingContext = new DataBindingContext();
	initGUI();
    }

    public void initGUI() {

	final Composite upperPanel = UIControlsFactory.createComposite(composite);
	upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	final GridLayout upperPanelLayout = new GridLayout();
	upperPanelLayout.numColumns = 7;
	upperPanelLayout.makeColumnsEqualWidth = false;
	upperPanel.setLayout(upperPanelLayout);
	upperPanel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	// member Id
	UIControlsFactory.createLabel(upperPanel, memberId);

	txtId = UIControlsFactory.createText(upperPanel, SWT.BORDER | SWT.READ_ONLY, ViewWidgetId.memberInfo_id);
	final GridData gd_txtId = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
	// gd_txtId.minimumWidth = 50;
	txtId.setLayoutData(gd_txtId);

	UIControlsFactory.createLabel(upperPanel, firstName);
	txtFirst = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_firstName);
	final GridData gd_txtFirst = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
	// gd_txtFirst.minimumWidth = 100;
	txtFirst.setLayoutData(gd_txtFirst);

	//		UIControlsFactory.createLabel(upperPanel, lastName); //$NON-NLS-1$
	// txtLast = UIControlsFactory.createText(upperPanel, SWT.BORDER,
	// ViewWidgetId.memberInfo_lastName);
	// txtLast.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,
	// 1));

	photoLabel = UIControlsFactory.createLabel(upperPanel, ""); //$NON-NLS-1$
//	photoLabel.setImage(Activator.getImage(ImageRegistry.sample_memberphoto));
	photoLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, true, 1, 4));

	// Composite datePanel = UIControlsFactory.createComposite(upperPanel);
	// GridDataFactory.swtDefaults().align(SWT.FILL,
	// SWT.FILL).grab(true,false).span(6, 1).applyTo(datePanel);
	// datePanel.setLayout(new GridLayout(8,false));

	UIControlsFactory.createLabel(upperPanel, applicationDate);
	dateText = UIControlsFactory.createText(upperPanel, SWT.READ_ONLY | SWT.BORDER,
		ViewWidgetId.memberInfo_applicationDate);
	GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateText);
	// addUIControl(dateText,ViewWidgetId.calendarDate);

	final Button calendarButton = new Button(upperPanel, SWT.PUSH);
	final Image calendar = Activator.getImage(ImageRegistry.calendar);
	calendarButton.setImage(calendar);
	GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);
	// addUIControl(calendarButton,ViewWidgetId.calendarButton);

	calendarButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
		calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
			dateText.getText());

		if (calDialog.open() == AbstractWindowController.OK) {
		    final Date selectedDate = (Date) calDialog.getController().getContext(
			    SimpleFormattedDateBean.DATE_PROR);
		    final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		    bean.setDate(selectedDate);
		    dateText.setText(bean.getFormattedDate());
		}
	    }
	});

	// effective date
	UIControlsFactory.createLabel(upperPanel, effectiveDate);
	effectDateText = UIControlsFactory.createText(upperPanel, SWT.READ_ONLY | SWT.BORDER,
		ViewWidgetId.memberInfo_effectiveDate);
	GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(effectDateText);
	// addUIControl(dateText,ViewWidgetId.calendarDate);

	final Button calendarButton2 = new Button(upperPanel, SWT.PUSH);
	calendarButton2.setImage(calendar);
	GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton2);
	// addUIControl(calendarButton,ViewWidgetId.calendarButton);

	calendarButton2.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
		calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
			dateText.getText());

		if (calDialog.open() == AbstractWindowController.OK) {
		    final Date selectedDate = (Date) calDialog.getController().getContext(
			    SimpleFormattedDateBean.DATE_PROR);
		    final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		    bean.setDate(selectedDate);
		    effectDateText.setText(bean.getFormattedDate());
		}
	    }
	});

	// status
	UIControlsFactory.createLabel(upperPanel, status);
	comboStatus = new ComboViewer(UIControlsFactory.createCombo(upperPanel, ViewWidgetId.memberInfo_status));
	// comboStatus.setItems(new String[] {"Active", "Inactive", "Dormant"});
	final GridData gd_comboStatus = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
	comboStatus.getControl().setLayoutData(gd_comboStatus);

	UIControlsFactory.createLabel(upperPanel, phoneNumber);
	txtPhone = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_phone);
	txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

	final Group addressGroup = UIControlsFactory.createGroup(upperPanel, "Address Information");
	addressGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 7, 3));
	addressGroup.setLayout(new GridLayout(1, false));
	createAddresscontrol(addressGroup);

	//		Label routLabel = UIControlsFactory.createLabel(upperPanel, route); //$NON-NLS-1$
	// routLabel.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false));
	//
	//		txtRoute = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_route); //$NON-NLS-1$
	// txtRoute.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false,
	// false,2, 1));
	//
	//		Label stopsLabel= UIControlsFactory.createLabel(upperPanel, stops); //$NON-NLS-1$
	// stopsLabel.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false));
	//
	// listStops = UIControlsFactory.createList(upperPanel, true, true);
	// stopsViewer = new ListViewer(listStops);
	// stopsViewer.setContentProvider(new ObservableListContentProvider());
	//
	// stopsViewer.setLabelProvider(new LabelProvider(){
	// public String getText(Object element) {
	// if(element instanceof CollectionCentre){
	// return ((CollectionCentre)element).getName();
	// }
	// return super.getText(element);
	// }
	// });
	// GridDataFactory.fillDefaults().grab(true, true).span(2,
	// 2).applyTo(listStops);

    }

    private void createAddresscontrol(Composite parent) {

	// address composite
	final Composite addressPanel = UIControlsFactory.createComposite(parent);
	final GridLayout layout2 = new GridLayout(6, false);
	addressPanel.setLayout(layout2);
	addressPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	// address
	final Label label = UIControlsFactory.createLabel(addressPanel, ADDRESS_LABEL);
	final GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	gd_label.minimumWidth = 100;
	label.setLayoutData(gd_label);
	final Text txtAddress = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.ADDRESS_TXT);
	txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));
	// section
	UIControlsFactory.createLabel(addressPanel, SECTION_LABEL);
	final Text txtAddress2 = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.SECTION_TXT);
	txtAddress2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));

	// estate
	UIControlsFactory.createLabel(addressPanel, ESTATE_LABEL);
	final Text estateAddress = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.ESTATE_TXT);
	estateAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// town
	UIControlsFactory.createLabel(addressPanel, VILLAGE_LABEL);
	final Text txtVillage = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.VILLAGE_TXT);
	txtVillage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// sublocation
	UIControlsFactory.createLabel(addressPanel, SUBLOCATION_LABEL);
	final Text txtSubLocation = UIControlsFactory
		.createText(addressPanel, SWT.BORDER, ViewWidgetId.SUBLOCATION_TXT);
	txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// location
	UIControlsFactory.createLabel(addressPanel, LOCATION_LABEL);
	final Text txtLocation = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.LOCATION_TXT);
	txtLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// division
	UIControlsFactory.createLabel(addressPanel, DIVISION_LABEL);
	final Text txtDivision = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.DIVISION_TXT);
	txtDivision.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// District
	UIControlsFactory.createLabel(addressPanel, DISTRICT_LABEL);
	final Text txtDistrict = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.DISTRICT_TXT);
	txtDistrict.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// province
	UIControlsFactory.createLabel(addressPanel, PROVINCE_LABEL);
	final Combo comboProvince = UIControlsFactory.createCombo(addressPanel, ViewWidgetId.PROVINCE_TXT);
	comboProvince.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

	// PostalCode
	UIControlsFactory.createLabel(addressPanel, POSTAL_CODE_LABEL);
	final Text txtPostal = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.POSTAL_CODE_TXT);
	txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
    }

    private void initDataBinding() {
	bindingContext.bindValue(SWTObservables.observeText(txtId, SWT.FocusOut),
		EMFObservables.observeValue(memberShip, DairyPackage.Literals.MEMBERSHIP__MEMBER_ID), null, null);
	final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
	if (memberShip.getApplicationDate() != null) {
	    bean.setDate(memberShip.getApplicationDate());
	}
	dateText.setText(bean.getFormattedDate());

	if (memberShip.getEffectiveDate() != null) {
	    bean.setDate(memberShip.getEffectiveDate());
	} else {
	    bean.setFormattedDate("");
	}
	effectDateText.setText(bean.getFormattedDate());

	comboStatus.setContentProvider(ArrayContentProvider.getInstance());
	comboStatus.setInput(MembershipStatus.values());

	// WritableList input = new
	// WritableList(memberShip.getDefaultRoute().getStops(),CollectionCentre.class);
	// stopsViewer.setInput(input);

	bindingContext.bindValue(ViewersObservables.observeSingleSelection(comboStatus),
		EMFObservables.observeValue(memberShip, DairyPackage.Literals.MEMBERSHIP__STATUS), null, null);
	bindingContext.bindValue(SWTObservables.observeText(txtPhone, SWT.Modify),
		EMFObservables.observeValue(memberShip.getMember(), ModelPackage.Literals.PARTY__PHONE_NUMBER));
	bindingContext.bindValue(SWTObservables.observeText(txtFirst, SWT.Modify),
		EMFObservables.observeValue(memberShip.getMember(), ModelPackage.Literals.PARTY__NAME), null, null);
	// bindingContext.bindValue(SWTObservables.observeText(txtRoute,SWT.Modify),
	// EMFObservables.observeValue(memberShip.getDefaultRoute(),
	// DairyPackage.Literals.ROUTE_DEFINITION__NAME));

    }

    public Composite getComposite() {
	return composite;
    }

    public Membership getMemberShip() {
	return memberShip;
    }

    public void setMemberShip(Membership memberShip) {
	this.memberShip = memberShip;
	initDataBinding();
    }

}
