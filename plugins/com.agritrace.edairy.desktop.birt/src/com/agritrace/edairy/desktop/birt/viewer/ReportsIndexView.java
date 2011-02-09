package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

public class ReportsIndexView extends SubModuleView {
	private Table table;

	public ReportsIndexView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void basicCreatePartControl(Composite parent) {
		
		parent.setLayout(new GridLayout(1, false));
		
		table = UIControlsFactory.createTable(parent, SWT.BORDER | SWT.SINGLE, "report-list-table");
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnArea = new TableColumn(table, SWT.NONE);
		tblclmnArea.setWidth(100);
		tblclmnArea.setText("Area");
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(172);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnDescription = new TableColumn(table, SWT.NONE);
		tblclmnDescription.setWidth(313);
		tblclmnDescription.setText("Description");
		// TODO Auto-generated method stub

	}
}
