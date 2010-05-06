package com.agritrace.edairy.ui.views;


import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.ui.EDairyActivator;
import com.agritrace.edairy.ui.ImageRegistry;
import com.agritrace.edairy.ui.views.data.Item;
import com.agritrace.edairy.ui.views.data.ItemsFactory;

public class DeliveryView extends ViewPart {
	
	public static final String ID = DeliveryView.class.getName();

	
	private Text dateField;
	private Button calendarButton;
	
	private List<Item> input = ItemsFactory.createItemList();


	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Label titleLabel = new Label(parent, SWT.NULL);
		titleLabel.setText("Delivery Information");
		Font labelFont = JFaceResources.getFontRegistry().getBold(
				JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);
		
		Composite upperPanel = new Composite(parent, SWT.NULL);
		upperPanel.setLayout(new GridLayout(5,false));
		upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
		
		Label dateLabel = new Label(upperPanel, SWT.NULL);
		dateLabel.setText("Date:");
		
        dateField = new Text(upperPanel,SWT.BORDER|SWT.SINGLE);
        dateField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
        dateField.setText("3/24/2010");
        
		calendarButton = new Button(upperPanel, SWT.PUSH);
		Image searchImage = EDairyActivator.getImage(ImageRegistry.search);
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
		
		Label driverLabel = new Label(upperPanel,SWT.NULL);
		driverLabel.setText("Driver:");
		
		Combo driverBox = new Combo(upperPanel, SWT.NULL);
		driverBox.setItems(new String[]{"Doe John","Jackson Janet"});
		driverBox.select(0);
		driverBox.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		
		Label vehicle = new Label(upperPanel,SWT.NULL);
		vehicle.setText("Vehicle:");
		
		Combo vehicleBox = new Combo(upperPanel, SWT.NULL);
		vehicleBox.setItems(new String[]{"NH46789","VI5678"});
		vehicleBox.select(0);
		vehicleBox.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,2,1));
		
		Label driveFrom = new Label(upperPanel,SWT.NULL);
		driveFrom.setText("Drive To:");
		
		Combo driveFromBox = new Combo(upperPanel, SWT.NULL);
		driveFromBox.setItems(new String[]{"Green Farm","Harvest Farm"});
		driveFromBox.select(0);
		driveFromBox.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Group itemsGroup = new Group(parent,SWT.BORDER);
		itemsGroup.setText("Items Details");
		itemsGroup.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		itemsGroup.setLayout(new GridLayout(2,false));
		
		Composite tableContainer = new Composite(itemsGroup, SWT.NULL);
		tableContainer.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,2));
		
		final TableViewer tableViewer = new TableViewer(tableContainer,SWT.MULTI|SWT.H_SCROLL|SWT.V_SCROLL|SWT.FULL_SELECTION|SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn id = new TableColumn(table, SWT.LEFT);
		id.setText("ID");
		
		TableColumn number = new TableColumn(table, SWT.LEFT);
		number.setText("Number");
		
		TableColumn description = new TableColumn(table, SWT.LEFT);
		description.setText("Description");
		
	
		TableColumnLayout layout = new TableColumnLayout();
		
		layout.setColumnData(id, new ColumnWeightData(20));
		layout.setColumnData(number, new ColumnWeightData(20));
		layout.setColumnData(description, new ColumnWeightData(60));
		tableContainer.setLayout(layout);
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new ItemLabelProivder());
		tableViewer.setInput(input);
		
		final Button addButton = new Button(itemsGroup,SWT.NULL);
		addButton.setText("Add...");
		addButton.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false));
		addButton.addSelectionListener(new SelectionListener() {
			
		
			public void widgetSelected(SelectionEvent e) {
				AddItemDialog addItem = new AddItemDialog(addButton.getShell());
				if(addItem.open() ==Window.OK){
					Item newItem = addItem.getNewItem();
					if(newItem != null){
						input.add(newItem);
						tableViewer.setInput(input);
					}
					
				}
			}
			
		
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
				
			}
		});
		
		final Button removeButton = new Button(itemsGroup,SWT.NULL);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionListener() {
			
		
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if(!selection.isEmpty()){
					if(MessageDialog.openConfirm(removeButton.getShell(), "Remove Items" , "Do you want to remove the selected items?")){
						Iterator i = selection.iterator();
						while(i.hasNext()){
							Item item = (Item)i.next();
							input.remove(item);
						}
						tableViewer.setInput(input);
					}
					
				}
				
			}
			
		
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
				
				
			}
		});
		removeButton.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false));
		
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


	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	private class ItemLabelProivder implements ITableLabelProvider{

		
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof Item){
				switch(columnIndex){
					case 0:
						return ((Item)element).getId();
					case 1:
						return ((Item)element).getNumber()+"";
					case 2:
						return ((Item)element).getDescription();
				}
			}
 			return null;
		}
		
	}

}
