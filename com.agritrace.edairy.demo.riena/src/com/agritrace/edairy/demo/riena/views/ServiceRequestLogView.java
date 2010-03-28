package com.agritrace.edairy.demo.riena.views;



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
import org.eclipse.jface.viewers.ColumnPixelData;

public class ServiceRequestLogView extends ViewPart {
	public ServiceRequestLogView() {
	}

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
				
		TableColumn columnId = new TableColumn(logTable, SWT.NONE);
		columnId.setText("Req. #");
		
		TableColumn columnRequestType = new TableColumn(logTable, SWT.LEFT);
		columnRequestType.setText("Request Type");

		TableColumn columnDate = new TableColumn(logTable, SWT.LEFT);
		columnDate.setText("Date");
		
		
		TableColumn columnMember = new TableColumn(logTable, SWT.LEFT);
		columnMember.setText("Member");
		
		TableColumn columnFarm = new TableColumn(logTable, SWT.LEFT);
		columnFarm.setText("Farm");
		
//		TableColumn columnStatus = new TableColumn(logTable, SWT.LEFT);
//		columnStatus.setText("Status");

		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(50,50));
		layout.setColumnData(columnRequestType, new ColumnWeightData(100,100));
		layout.setColumnData(columnDate, new ColumnWeightData(100,100));
		layout.setColumnData(columnMember, new ColumnWeightData(400));
		layout.setColumnData(columnFarm, new ColumnWeightData(300));
		
		TableItem item;
		for ( int i=0; i < 25; i++) {
			item = new TableItem(logTable, SWT.NONE);
			item.setText(new String[] { new Integer(2423+i).toString(), "Veterinary", "01/04/2009", "Cosby Njoya", "Chuma route #2"});
			item = new TableItem(logTable, SWT.NONE);
			item.setText(new String[] { new Integer(2423+i).toString(), "Insemination", "08/23/2009", "Pryor Thuku", "Ngeche #56" });
			item = new TableItem(logTable, SWT.NONE);
			item.setText(new String[] { new Integer(2423+i).toString(), "Veterinary", "12/03/2009", "Murphy Njeru", "Gathara Route #6" });
		}
		
		tablePanel.setLayout(layout);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
