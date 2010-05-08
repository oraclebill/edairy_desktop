package com.agritrace.edairy.milkCollection.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
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

import com.agritrace.edairy.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.ui.views.ModifyMilkRecordDialog;
import com.agritrace.edairy.ui.views.StringNumberValidator;
import com.agritrace.edairy.ui.views.ViewWidgetId;
import com.agritrace.edairy.ui.views.data.MilkCollectionRecord;
import com.agritrace.edairy.ui.views.data.SimpleFormattedDateBean;

public class MilkCollectionJournalController extends SubModuleController  {

	//journal book group ridgets
	private ITextRidget dateRidget;
	private IComboRidget routeRidget;
	private IComboRidget sessionRidget ;
	private IComboRidget vehicleRidget;
	private IComboRidget driverRidget;

	//journal group ridgets
	private ITextRidget journalNumber;
	private IDecimalTextRidget journalTotlal;
	private ITextRidget binText;


	//milk Entry group
	private ITextRidget memberText;
	private ITextRidget canText;
	private ITextRidget quantityText;
	private ITableRidget table;
	private IToggleButtonRidget nprMissingButton ;
	private IToggleButtonRidget rejectedButton; 
	private ILabelRidget totalLabelRidget;

	public static final String LINE_COLUMN_HEADER="Line";

	public static final String MEMBER_COLUMN_HEADER="Member ID";

	public static final String CAN_COLUMN_HEADER="CAN Number";

	public static final String QUANTITY_COLUMN_HEADER="Quantity";

	public static final String NPR_COLUMN_HEADER="NPR Missing";

	public static final String REJECTED_COLUMN_HEADER="Rejected";

	public static final String TOTAL_LABEL="Total : ";

	private  List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();
	
	private TotalRecordsValue totalValue = new TotalRecordsValue();

	@Override
	public void configureRidgets() {
		//journal book group
		dateRidget = getRidget(ITextRidget.class, ViewWidgetId.calendarDate);
		dateRidget.setText(new SimpleFormattedDateBean().getFormattedDate());
		dateRidget.setMandatory(true);

		routeRidget = getRidget(IComboRidget.class,ViewWidgetId.routeCombo);
		List<Route> someRoutes =getRoutesList();
		routeRidget.bindToModel(new WritableList(someRoutes, Route.class), Route.class, "getName", new WritableValue());
		routeRidget.updateFromModel();
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(IComboRidget.class,ViewWidgetId.sessionCombo);
		sessionRidget.bindToModel(Observables.staticObservableList(Session.VALUES), Session.class, null, new WritableValue()); 
		sessionRidget.updateFromModel();
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(IComboRidget.class,ViewWidgetId.vehicleCombo);
		List<Vehicle> vehicles = getVehiclesList();
		vehicleRidget.bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class, "getRegistrationNumber", new WritableValue());
		vehicleRidget.updateFromModel();
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(IComboRidget.class,ViewWidgetId.driverCombo);
//		List<String> driverList = Arrays.asList(new String[] { "23 - John Jones", "45 - Joseph Limuru", "66 - John Smith" });
		List<Employee> driverList = getDriverList();
		driverRidget.bindToModel(new WritableList(driverList, Employee.class), Employee.class, "getName", new WritableValue());
		driverRidget.updateFromModel();
		driverRidget.setMandatory(true);

		GroupOneSelectionListener selectionListener = new GroupOneSelectionListener();
		routeRidget.addSelectionListener(selectionListener);
		sessionRidget.addSelectionListener(selectionListener);
		vehicleRidget.addSelectionListener(selectionListener);
		driverRidget.addSelectionListener(selectionListener);

		//journal group
		journalNumber = getRidget(ITextRidget.class,ViewWidgetId.journalText);
		journalNumber.setMandatory(true);
		journalNumber.addValidationRule(new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);

		journalTotlal = getRidget(IDecimalTextRidget.class,ViewWidgetId.journalTotalText);
		journalTotlal.setSigned(false);
		journalTotlal.setGrouping(true);
		journalTotlal.setMandatory(true	);

		binText = getRidget(ITextRidget.class, ViewWidgetId.binText);
		binText.setMandatory(true);
		binText.addValidationRule(new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);

		//milk entry group
		memberText = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberText.setMandatory(true);
		memberText.setInputToUIControlConverter(new Converter(String.class,String.class){

			
			@Override
			public Object convert(Object fromObject) {
				if(fromObject instanceof String && !((String)fromObject).isEmpty()){
					String text = (String) fromObject;
					String firstChar = text.substring(0,1);
					if(firstChar.equalsIgnoreCase("N")){
						text = text.substring(1);
						nprMissingButton.setSelected(true);
						return text;
					}else if(firstChar.equalsIgnoreCase("R")){
						text = text.substring(1);
						rejectedButton.setSelected(true);
						return text;


					}	
				}
				return fromObject;
			}
			
		});
		
		memberText.addValidationRule( new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);

		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		canText.setMandatory(true);
		canText.addValidationRule( new StringNumberValidator(), ValidationTime.ON_UI_CONTROL_EDIT);

		quantityText = getRidget(IDecimalTextRidget.class, ViewWidgetId.quantityText);
		quantityText.setMandatory(true);

		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);
		
		rejectedButton =  getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);


		table = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
		String[] columnNames = {LINE_COLUMN_HEADER,MEMBER_COLUMN_HEADER,CAN_COLUMN_HEADER,QUANTITY_COLUMN_HEADER,NPR_COLUMN_HEADER,REJECTED_COLUMN_HEADER }; 
		String[] propertyNames = { "lineNumber", "recordedMember", "farmContainer", "quantity", "notRecorded", "rejected"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		table.setColumnFormatter(2, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if(element instanceof CollectionJournalLine){
					if(((CollectionJournalLine)element).getFarmContainer() != null){
						return ((CollectionJournalLine)element).getFarmContainer().getContainerId();	
					}
					
				}
				return null;
			}
		});
		
		table.bindToModel(new WritableList(records, CollectionJournalLine.class),  CollectionJournalLine.class, propertyNames, columnNames); //$NON-NLS-
		table.setSelectionType(SelectionType.MULTI);
		table.addSelectionListener(new ISelectionListener(){

		
			@Override
			public void ridgetSelected(SelectionEvent event) {
				if(table.getSelection().size()==0){
					updateBottomButtons(false);
				}else{
					updateBottomButtons(true);
				}

			}
		});
		//buttons
		((IActionRidget)getRidget(ViewWidgetId.addButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				CollectionJournalLine aRecord = DairyFactory.eINSTANCE.createCollectionJournalLine();
				/**
				 * todo should get container based on the CAN ID, now I created manually
				 */
				String quaitityTextStr = NumericTextRidget.ungroup(quantityText.getText());

				Container can = TrackingFactory.eINSTANCE.createContainer();
				can.setContainerId(canText.getText());
				aRecord.setFarmContainer(can);
				aRecord.setRecordedMember(memberText.getText());
				aRecord.setQuantity(new Double(quaitityTextStr).doubleValue());
				aRecord.setNotRecorded(nprMissingButton.isSelected());
				aRecord.setRejected(rejectedButton.isSelected());
				records.add(aRecord);
				updateRecordLineNumbers();
				table.updateFromModel();
				totalLabelRidget.updateFromModel();
			}

		});


		((IActionRidget)getRidget(ViewWidgetId.entryInputClear)).addListener(new IActionListener() {

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Clear Input", "Do you want to clear input fields?")){
					memberText.setText("");
					canText.setText("");
					quantityText.setText("");
					nprMissingButton.setSelected(false);
					rejectedButton.setSelected(false);
				}

			}

		});

		((IActionRidget)getRidget(ViewWidgetId.modifyButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				MilkCollectionRecord aRecord = (MilkCollectionRecord) table.getSelection().get(0);
				ModifyMilkRecordDialog modifyDialog = new ModifyMilkRecordDialog(Display.getDefault().getActiveShell());
				aRecord.setLine("");
				modifyDialog.setRecord(aRecord);
				if(modifyDialog.open() == Window.OK){
					table.updateFromModel();
					totalLabelRidget.updateFromModel();	
				}
			}

		});

		((IActionRidget)getRidget(ViewWidgetId.deleteButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records", "Do you want to delete the selected milk collection records?")){
					List<Object> selectedRecords =table.getSelection();
					if(selectedRecords != null){
						records.removeAll(selectedRecords);
					}
					updateRecordLineNumbers();
					table.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});
		
		((IActionRidget)getRidget(ViewWidgetId.clearButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records", "Do you want to delete all milk collection records?")){
					records.clear();
					updateRecordLineNumbers();
					table.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});


		updateBottomButtons(false);
		totalLabelRidget = getRidget(ILabelRidget.class,ViewWidgetId.totalLabel);
		totalLabelRidget.bindToModel(PojoObservables.observeValue(totalValue, "total"));
		totalLabelRidget.updateFromModel();
		
	}

	@Override
	public void afterBind() {
		super.afterBind();
		setSubGroupsVisible(false);
	}

	private void setSubGroupsVisible(boolean visble){
		if(journalNumber != null){
			((Control)journalNumber.getUIControl()).getParent().setVisible(visble);	
		}
		if(memberText != null){
			((Control)memberText.getUIControl()).getParent().getParent().setVisible(visble);	
		}
		if(table != null){
			((Control)table.getUIControl()).getParent().getParent().getParent().setVisible(visble);	
		}
	}
	private class GroupOneSelectionListener implements ISelectionListener{

		@Override
		public void ridgetSelected(SelectionEvent event) {
			if(routeRidget.getSelection() != null && vehicleRidget.getSelection() != null && vehicleRidget.getSelection() != null && driverRidget.getSelection() != null){
				setSubGroupsVisible(true);
			}else{
				setSubGroupsVisible(false);
			}
		}
	}

	private void updateBottomButtons(boolean enable){
		((IActionRidget)getRidget(ViewWidgetId.modifyButton)).setEnabled(enable);
		((IActionRidget)getRidget(ViewWidgetId.deleteButton)).setEnabled(enable);
	}
	
	private List<Route> getRoutesList(){
		List<Route> routes = new ArrayList<Route>();
		Route route1 = DairyFactory.eINSTANCE.createRoute();
		route1.setName("route 1");
		route1.setCode("10001");
		
		Route route2 = DairyFactory.eINSTANCE.createRoute();
		route2.setName("route 2");
		route2.setCode("10002");
		
		Route route3 = DairyFactory.eINSTANCE.createRoute();
		route3.setName("route 3");
		route3.setCode("10003");
		
		routes.add(route1);
		routes.add(route2);
		routes.add(route3);
		return routes;
	}
	
	private List<Vehicle> getVehiclesList(){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle v1=  DairyFactory.eINSTANCE.createVehicle();
		v1.setAssetId(new Long(10001).longValue());
		v1.setRegistrationNumber("456123 - 2008 Mitsubishi");
		vehicles.add(v1);
		
		Vehicle v2=  DairyFactory.eINSTANCE.createVehicle();
		v2.setAssetId(new Long(10001).longValue());
		v2.setRegistrationNumber("43332 - 2003 Mitsubishi");
		vehicles.add(v2);
		
		Vehicle v3=  DairyFactory.eINSTANCE.createVehicle();
		v3.setAssetId(new Long(10001).longValue());
		v3.setRegistrationNumber("23311 - 2010 Mitsubishi");
		vehicles.add(v3);
		
		return vehicles;

	}
	
	private List<Employee> getDriverList(){
		List<Employee> drivers = new ArrayList<Employee>();
		Employee d1 = DairyFactory.eINSTANCE.createEmployee();
		d1.setId("22");
		//"23 - John Jones", "45 - Joseph Limuru", "66 - John Smith"
		d1.setGivenName("John");
		d1.setFamilyName("Jones");
		d1.setName("23 -John Jones");
		drivers.add(d1);
		
		Employee d2 = DairyFactory.eINSTANCE.createEmployee();
		d2.setId("45");
		//"23 - John Jones", "45 - Joseph Limuru", "66 - John Smith"
		d2.setGivenName("Joseph");
		d2.setFamilyName("Limuru");
		d2.setName("45 - Joseph Limuru");
		drivers.add(d2);
		
		Employee d3 = DairyFactory.eINSTANCE.createEmployee();
		d3.setId("66");
		//"23 - John Jones", "45 - Joseph Limuru", "66 - John Smith"
		d3.setGivenName("John");
		d3.setFamilyName("Smith");
		d3.setName("66 - John Smith");
		drivers.add(d3);
		
		return drivers;
	}
	
	private void updateRecordLineNumbers(){
		int counter = 0;
		double total = 0;
		
		for(CollectionJournalLine line: records){
			line.setLineNumber(counter++);
			total += line.getQuantity();
		}
		totalValue.setTotal(total);
	}
	
	private class TotalRecordsValue{
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
}
