package com.agritrace.edairy.demo.riena.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.demo.riena.views.MilkCollectionRecordList;
import com.agritrace.edairy.demo.riena.views.ModifyMilkRecordDialog;
import com.agritrace.edairy.demo.riena.views.StringNumberValidator;
import com.agritrace.edairy.demo.riena.views.ViewWidgetId;
import com.agritrace.edairy.demo.riena.views.data.MilkCollectionRecord;
import com.agritrace.edairy.demo.riena.views.data.SimpleFormattedDateBean;

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

	private MilkCollectionRecordList records = new MilkCollectionRecordList();

	@Override
	public void configureRidgets() {
		//journal book group
		dateRidget = getRidget(ITextRidget.class, ViewWidgetId.calendarDate);
		dateRidget.setText(new SimpleFormattedDateBean().getFormattedDate());
		dateRidget.setMandatory(true);

		routeRidget = getRidget(IComboRidget.class,ViewWidgetId.routeCombo);
		List<String> someRoutes = Arrays.asList(new String[] { "route 1", "route 2", "route 3" });
		routeRidget.bindToModel(new WritableList(someRoutes, String.class), String.class, null, new WritableValue());
		routeRidget.updateFromModel();
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(IComboRidget.class,ViewWidgetId.sessionCombo);
		List<String> sessions = Arrays.asList(new String[] { "Morning", "Afternoon", "Night" });
		sessionRidget.bindToModel(new WritableList(sessions, String.class), String.class, null, new WritableValue());
		sessionRidget.updateFromModel();
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(IComboRidget.class,ViewWidgetId.vehicleCombo);
		List<String> vehicleList = Arrays.asList(new String[] { "456123 - 2008 Mitsubishi", "43332 - 2003 Mitsubishi", "23311 - 2010 Mitsubishi" });
		vehicleRidget.bindToModel(new WritableList(vehicleList, String.class), String.class, null, new WritableValue());
		vehicleRidget.updateFromModel();
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(IComboRidget.class,ViewWidgetId.driverCombo);
		List<String> driverList = Arrays.asList(new String[] { "23 - John Jones", "45 - Joseph Limuru", "66 - John Smith" });
		driverRidget.bindToModel(new WritableList(driverList, String.class), String.class, null, new WritableValue());
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
		String[] columnNames = {LINE_COLUMN_HEADER,MEMBER_COLUMN_HEADER,CAN_COLUMN_HEADER,QUANTITY_COLUMN_HEADER,NPR_COLUMN_HEADER,REJECTED_COLUMN_HEADER }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		String[] propertyNames = { "line", "memberId", "canId", "quantity", "nPRMissing", "rejected"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		table.bindToModel(records, "records", MilkCollectionRecord.class, propertyNames, columnNames); //$NON-NLS-
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

			public void callback() {
				MilkCollectionRecord aRecord = new MilkCollectionRecord();
				aRecord.setMemberId(memberText.getText());
				aRecord.setCanId(canText.getText());
				aRecord.setQuantity(new Double(quantityText.getText()).doubleValue());
				aRecord.setnPRMissing(nprMissingButton.isSelected());
				aRecord.setRejected(rejectedButton.isSelected());
				records.getRecords().add(aRecord);
				table.updateFromModel();
				totalLabelRidget.updateFromModel();
			}

		});


		((IActionRidget)getRidget(ViewWidgetId.entryInputClear)).addListener(new IActionListener() {

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

			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records", "Do you want to delete the selected milk collection records?")){
					List<Object> selectedRecords =table.getSelection();
					if(selectedRecords != null){
						records.getRecords().removeAll(selectedRecords);
					}
					table.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});
		
		((IActionRidget)getRidget(ViewWidgetId.clearButton)).addListener(new IActionListener() {

			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Milk Collection Records", "Do you want to delete all milk collection records?")){
					records.getRecords().clear();
					table.updateFromModel();
					totalLabelRidget.updateFromModel();
				}
			}
		});


		updateBottomButtons(false);
		totalLabelRidget = getRidget(ILabelRidget.class,ViewWidgetId.totalLabel);
		totalLabelRidget.bindToModel(PojoObservables.observeValue(records, "totalValue"));
		totalLabelRidget.updateFromModel();
	}

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
}
