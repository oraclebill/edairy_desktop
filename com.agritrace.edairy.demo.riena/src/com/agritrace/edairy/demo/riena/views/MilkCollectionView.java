package com.agritrace.edairy.demo.riena.views;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.ole.win32.COMObject;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.demo.riena.Activator;
import com.agritrace.edairy.demo.riena.ImageRegistry;
import com.agritrace.edairy.demo.riena.views.data.CreditRecord;
import com.agritrace.edairy.demo.riena.views.data.MilkRecord;
import com.agritrace.edairy.demo.riena.views.data.MilkRecord.TestResult;
import com.agritrace.edairy.demo.riena.views.data.MilkRecordsFactory;

public class MilkCollectionView extends ViewPart implements SelectionListener {

	public static final String ID = MilkCollectionView.class.getName();

	private Text dateField;

	private Button calendarButton;

	private Button addResultsButton;

	private Button importResultsButton;
	
	private Button removeButton;
	
	private Combo scaleList;
	
	private Combo centerName;
	
	private Combo clerkName;

	private TableViewer tableViewer;

	private Table table;

	private String[] columnNames = {"Date","Center","Clerk","Scale","Member","Farm","Can","Bin","Amount","Test Result"};

	private List<MilkRecord> input = MilkRecordsFactory.createMilkRecords();


	@Override
	public void createPartControl(Composite parent) {
		// parent.setBackground(LnfManager.getLnf().getColor(
		// LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		Composite upperPanel = new Composite(parent, SWT.BORDER);
		upperPanel.setLayout(new GridLayout());
		upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Label titleLabel = new Label(upperPanel, SWT.NULL);
		titleLabel.setText("Milk Collection Entry");

		Font labelFont = JFaceResources.getFontRegistry().getBold(
				JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		Group collectionGroup = new Group(upperPanel, SWT.NULL);
		collectionGroup.setLayout(new GridLayout(5, false));
		collectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));

		Label collectionCenter = new Label(collectionGroup, SWT.NULL);
		collectionCenter.setText("Collection Center:");

		centerName = new Combo(collectionGroup, SWT.READ_ONLY | SWT.BORDER);
		centerName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
				false, 2, 1));
		centerName.setItems(new String[]{"Limuru Store","Famous Store"});
		centerName.select(0);

		Label clerk = new Label(collectionGroup, SWT.NULL);
		clerk.setText("Clerk:");

		//
		clerkName = new Combo(collectionGroup, SWT.READ_ONLY | SWT.BORDER);
		clerkName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
				false));
		clerkName.setItems(new String[]{"John Jones","John Smith"});
		clerkName.select(0);
		//
		Label dateLabel = new Label(collectionGroup, SWT.NULL);
		dateLabel.setText("Date:");

		dateField = new Text(collectionGroup, SWT.SINGLE | SWT.BORDER
				| SWT.READ_ONLY);
		dateField.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
				false));
		dateField.setText("3/22/2010");

		calendarButton = new Button(collectionGroup, SWT.PUSH);
		Image searchImage = Activator.getImage(ImageRegistry.search);
		calendarButton.setImage(searchImage);

		calendarButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false));
		calendarButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				final Shell dialog = new Shell(Display.getDefault()
						.getActiveShell(), SWT.DIALOG_TRIM);
				dialog.setLayout(new GridLayout(3, false));

				final DateTime calendar = new DateTime(dialog, SWT.CALENDAR
						| SWT.BORDER);
				if (dateField.getText() != null
						&& !dateField.getText().equals("")) {
					String[] textDate = dateField.getText().split("/");
					if (textDate != null && textDate.length == 3) {
						int month = new Integer(textDate[0]).intValue() - 1;
						int day = new Integer(textDate[1]).intValue();
						int year = new Integer(textDate[2]).intValue();
						calendar.setMonth(month);
						calendar.setDay(day);
						calendar.setYear(year);

					}
				}

				new Label(dialog, SWT.NONE);
				new Label(dialog, SWT.NONE);
				Button ok = new Button(dialog, SWT.PUSH);
				ok.setText("OK");
				ok.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
						false));
				ok.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						String textDate = (calendar.getMonth() + 1) + "/"
						+ calendar.getDay() + "/" + calendar.getYear();
						dateField.setText(textDate);
						dialog.close();
					}
				});
				dialog.setDefaultButton(ok);
				dialog.pack();
				dialog.open();
			}
		});

		Label scale = new Label(collectionGroup, SWT.NULL);
		scale.setText("Scale:");

		scaleList = new Combo(collectionGroup, SWT.NULL | SWT.READ_ONLY);
		scaleList
		.setItems(new String[] { "#23-Electonic", "#42-Electonic" });
		scaleList.select(0);
		scaleList.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
				false));

		Composite buttonsPanel = new Composite(upperPanel, SWT.NULL);
		buttonsPanel.setLayout(new GridLayout(3, false));
		buttonsPanel
		.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));

		addResultsButton = new Button(buttonsPanel, SWT.PUSH);
		addResultsButton.setText("Add Record");
		addResultsButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_END, GridData.FILL, false, false));
		addResultsButton.addSelectionListener(this);

		importResultsButton = new Button(buttonsPanel, SWT.PUSH);
		importResultsButton.setText("Import Records ...");
		importResultsButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_END, GridData.FILL, false, false));
		importResultsButton.addSelectionListener(this);
		
		removeButton= new Button(buttonsPanel, SWT.PUSH);
		removeButton.setText("Remove");
		removeButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_END, GridData.FILL, false, false));
		removeButton.addSelectionListener(this);

		// Composite bottomPanel = new Composite(parent, SWT.NULL);
		// bottomPanel.setLayout(new GridLayout(1,false));
		// bottomPanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		createRecords(parent);
		Composite savePanel = new Composite(parent, SWT.NULL);
		savePanel.setLayoutData(new GridData(SWT.END,SWT.FILL,false,false));
		savePanel.setLayout(new GridLayout(2,false));
		
		Button saveButton = new Button(savePanel,SWT.PUSH);
		saveButton.setText("Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Button cancelButton = new Button(savePanel,SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
	}


	/**
	 * Create the TableViewer 
	 */
	private void createTableViewer() {

		tableViewer.setUseHashlookup(true);

		tableViewer.setColumnProperties(columnNames);



		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 1 : Completed (Checkbox)
		//first 4 columns not editable
		editors[0] = null;
		editors[1] = null;
		editors[2] = null;
		editors[3] = null;

		//colum 4-8 text editor
		for(int i=4; i<9; i++){
			TextCellEditor textEditor = new TextCellEditor(table);
			((Text) textEditor.getControl()).setTextLimit(20);
			//the amount column need to do verify only digital value is allowed
			if(i == 8){
//				((Text) textEditor.getControl()).addVerifyListener(
//
//						new VerifyListener() {
//							public void verifyText(VerifyEvent e) {
//								// Here, we could use a RegExp such as the following 
//								// if using JRE1.4 such as  e.doit = e.text.matches("[\\-0-9]*");
//								e.doit = e.text.matches("[\\-0-9].*");
//							}
//						});
			}
			
			editors[i] = textEditor;
		}



		// Column 9 : Test result is Combo Box 
		editors[9] = new ComboBoxCellEditor(table, new String[]{TestResult.PASS.toString(),TestResult.FAIL.toString()}, SWT.READ_ONLY);

		// Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new CellModifier());

	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void createRecords(Composite parent) {
		Group buttomGroup = new Group(parent, SWT.BORDER);
		buttomGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		buttomGroup.setText("Record Collections");
		buttomGroup.setLayout(new GridLayout());

		Composite treePanel = new Composite(buttomGroup, SWT.NULL);
		treePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tableViewer = new TableViewer(treePanel, SWT.FULL_SELECTION
				| SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Create 10 columns and show
		TableColumn date = new TableColumn(table, SWT.LEFT);
		date.setText("Date");

		TableColumn center = new TableColumn(table, SWT.LEFT);
		center.setText("Center");

		TableColumn clerk = new TableColumn(table, SWT.LEFT);
		clerk.setText("Clerk");

		TableColumn scale = new TableColumn(table, SWT.LEFT);
		scale.setText("Scale");

		TableColumn member = new TableColumn(table, SWT.LEFT);
		member.setText("Member");

		TableColumn farm = new TableColumn(table, SWT.LEFT);
		farm.setText("Farm");

		TableColumn can = new TableColumn(table, SWT.LEFT);
		can.setText("Can");

		TableColumn bin = new TableColumn(table, SWT.LEFT);
		bin.setText("Bin");

		TableColumn amount = new TableColumn(table, SWT.LEFT);
		amount.setText("Amount");

		TableColumn testResult = new TableColumn(table, SWT.LEFT);
		testResult.setText("Test Result");

		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(date, new ColumnWeightData(10));
		layout.setColumnData(center, new ColumnWeightData(10));
		layout.setColumnData(clerk, new ColumnWeightData(10));
		layout.setColumnData(scale, new ColumnWeightData(10));
		layout.setColumnData(member, new ColumnWeightData(10));
		layout.setColumnData(farm, new ColumnWeightData(10));
		layout.setColumnData(can, new ColumnWeightData(10));
		layout.setColumnData(bin, new ColumnWeightData(10));
		layout.setColumnData(amount, new ColumnWeightData(10));
		layout.setColumnData(testResult, new ColumnWeightData(10));

		createTableViewer();
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new MilkRecordLabelProvider());
		tableViewer.setInput(input);
		

		treePanel.setLayout(layout);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == addResultsButton) {
			MilkRecord newRecord = new MilkRecord();
			newRecord.setDate(dateField.getText());
			newRecord.setClerkName(clerkName.getText());
			newRecord.setCenterName(centerName.getText());
			newRecord.setScale(scaleList.getText());
			newRecord.setResult(TestResult.PASS);
			newRecord.setAmount(0.0);
			input.add(newRecord);
			tableViewer.setInput(input);
			
//			AddMilkRecordDialog dialog = new AddMilkRecordDialog(
//					addResultsButton.getShell());
//			dialog.open();
		} else if (e.getSource() == importResultsButton) {
			FileDialog dialog = new FileDialog(importResultsButton.getShell());
			dialog.setText("Please select the collection record file");
			dialog.setFilterExtensions(new String[] { "*.csv" });
			dialog.open();
			// dialog.getFilterPath()
		}else if(e.getSource() == removeButton){
			IStructuredSelection selection = (IStructuredSelection) tableViewer
			.getSelection();
	if (!selection.isEmpty()) {
		if (MessageDialog.openConfirm(removeButton.getShell(),
				"Remove Items",
				"Do you want to remove the selected records?")) {
			Iterator i = selection.iterator();
			while (i.hasNext()) {
				MilkRecord item = (MilkRecord) i.next();
				input.remove(item);
			}
			tableViewer.setInput(input);
		}

	}
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);

	}

	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}

	public class CellModifier implements ICellModifier {

		private String[] columnNames;
		//		
		//		/**
		//		 * Constructor 
		//		 * @param TableViewerExample an instance of a TableViewerExample 
		//		 */
		//		public ExampleCellModifier(TableViewerExample tableViewerExample) {
		//			super();
		//			this.tableViewerExample = tableViewerExample;
		//		}

		/**
		 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
		 */
		public boolean canModify(Object element, String property) {
			return true;
		}

		/**
		 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
		 */
		public Object getValue(Object element, String property) {

			// Find the index of the column
			int columnIndex = getColumnNames().indexOf(property);

			Object result = null;
			MilkRecord record = (MilkRecord) element;

			switch (columnIndex) {
			case 0:
				return record.getDate();
			case 1:
				return record.getCenterName();
			case 2:
				return record.getClerkName();
			case 3:
				return record.getScale();
				
			case 4 : // Member 
				result = record.getMemberName();
				break;
			case 5 : // farm
				result = record.getFarmName();
				break;
			case 6 : // can
				result = record.getCanNumber();			
				break;
			case 7 : // bin 
				result = record.getBinNumber();
				break;
			case 8 : // amount 
				result = record.getAmount()+"";
				break;
			case 9 : // result 
				if(record.getResult() == TestResult.PASS){
					result = 0;
				}else{
					result = 1;
				}
				break;
			default :
				result = "";
			}
			System.out.println("result =  "+result);
			return result;	
		}

		/**
		 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
		 */
		public void modify(Object element, String property, Object value) {	

			// Find the index of the column 
			int columnIndex	= getColumnNames().indexOf(property);

			TableItem item = (TableItem) element;
			MilkRecord record = (MilkRecord) item.getData();
			String valueString;

			switch (columnIndex) {
			case 0:
			case 1:
			case 2:
			case 3:
				break;
			case 4 : 
				valueString = ((String) value).trim();
				record.setMemberName(valueString);
				tableViewer.update(record, null);
				break;
			case 5 : // farm
				valueString = ((String) value).trim();
				record.setFarmName(valueString);
				tableViewer.update(record, null);
				break;
			case 6 : // can
				valueString = ((String) value).trim();
				System.out.println("can "+valueString);
				record.setCanNumber(valueString);
				tableViewer.update(record, null);
				break;
			case 7 : // BIN
				valueString = ((String) value).trim();
				record.setBinNumber(valueString);
				tableViewer.update(record, null);
				break;
			case 8:
				valueString = ((String) value).trim();
				Double number ;
				if(valueString==null || valueString.isEmpty()){
					valueString="0";
				}
				number = new Double(valueString);
				record.setAmount(number.doubleValue());
				tableViewer.update(record, null);
				break;
			case 9:
				int selectedIndex = ((Integer) value).intValue();
				if(selectedIndex == 0){
					record.setResult(TestResult.PASS);
				}else{
					record.setResult(TestResult.FAIL);

				}
				tableViewer.update(record, null);
				break;
			default :
			}
			
		}
	}


	public class MilkRecordLabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof MilkRecord){
				MilkRecord record = (MilkRecord)element;
				switch (columnIndex){
				case 0:
					return record.getDate();
				case 1:
					return record.getCenterName();
				case 2:
					return record.getClerkName();
				case 3:
					return record.getScale();
				case 4:
					return record.getMemberName();
				case 5:
					return record.getFarmName();
				case 6:
					return record.getCanNumber();
				case 7:
					return record.getBinNumber();
				case 8:
					return record.getAmount()+"";
				case 9:
					return record.getResult().toString();
					
				}
			}
			return null;
		}

	}
	
	


}
