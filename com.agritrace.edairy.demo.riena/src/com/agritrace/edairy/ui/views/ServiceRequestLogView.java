package com.agritrace.edairy.ui.views;



import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

public class ServiceRequestLogView extends ViewPart {

	public static final String ID = ServiceRequestLogView.class.getName();

	@Override
	public void createPartControl(Composite parent) {
		Composite panel = new Composite(parent, SWT.NULL);
		panel.setLayout(new GridLayout(1,false));
		
		Label titleLabel = new Label(panel, SWT.NULL);
		titleLabel.setText("Service Request Logs");
		Font labelFont = JFaceResources.getFontRegistry().getBold(
				JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);
		
		Composite tablePanel = new Composite(panel, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		//tablePanel.setLayout(new GridLayout(1,false));
		
		Table logTable = new Table(tablePanel, SWT.SINGLE|SWT.BORDER|SWT.FULL_SELECTION);
		logTable.setLinesVisible(true);
		logTable.setHeaderVisible(true);
		
		
		TableColumn columnDate = new TableColumn(logTable, SWT.LEFT);
		columnDate.setText("Date");
		TableColumn columnMember = new TableColumn(logTable, SWT.LEFT);
		columnMember.setText("Member");
		
		TableColumn columnFarm = new TableColumn(logTable, SWT.LEFT);
		columnFarm.setText("Farm");

		TableColumn columnRequestType = new TableColumn(logTable, SWT.LEFT);
		columnRequestType.setText("Request Type");
		
		TableColumn columnStatus = new TableColumn(logTable, SWT.LEFT);
		columnStatus.setText("Status");

		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnDate, new ColumnWeightData(20));
		layout.setColumnData(columnMember, new ColumnWeightData(20));
		layout.setColumnData(columnRequestType, new ColumnWeightData(20));
		layout.setColumnData(columnFarm, new ColumnWeightData(20));
		layout.setColumnData(columnStatus, new ColumnWeightData(20));
		
		TableItem item1 = new TableItem(logTable, SWT.NONE);
		item1.setText(new String[] { "01/04/2009", "John Smith", "Golden Star","Veterinary","" });
		TableItem item2 = new TableItem(logTable, SWT.NONE);
		item2.setText(new String[] { "08/23/2009", "Reese Miiler ", "Golden Star","Insemination" ,""});
		TableItem item3 = new TableItem(logTable, SWT.NONE);
		item3.setText(new String[] { "12/03/2009", "John Smith", "Golden Star","Veterinary","" });
		
		
		tablePanel.setLayout(layout);
		
		
		Composite savePanel = new Composite(panel, SWT.NULL);
		savePanel.setLayoutData(new GridData(SWT.END,SWT.FILL,false,false));
		savePanel.setLayout(new GridLayout(2,false));
		
		Button saveButton = new Button(savePanel,SWT.PUSH);
		saveButton.setText("Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Button cancelButton = new Button(savePanel,SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
