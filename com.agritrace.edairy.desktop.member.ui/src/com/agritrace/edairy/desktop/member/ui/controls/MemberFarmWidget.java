package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
public class MemberFarmWidget {
	
	private Composite composite;
	
	public static String ADD_BUTTON="Add &Farm";
	public static String REMOVE_BUTTON="Remo&ve";
	
	public MemberFarmWidget(Composite parent){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1,true));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}
	
	public void initGUI(){
		final Composite tablePanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.FARM_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnId = new TableColumn(table, SWT.LEFT);
		columnId.setText("Id");
		final TableColumn columnName = new TableColumn(table, SWT.LEFT);
		columnName.setText("Name");
		final TableColumn columnLocation = new TableColumn(table, SWT.LEFT);
		columnLocation.setText("Location");
		final TableColumn columnAnimal = new TableColumn(table, SWT.LEFT);
		columnAnimal.setText("Number of Animals");
		final TableColumn columnCan = new TableColumn(table, SWT.LEFT);
		columnLocation.setText("Number of Containers");

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(20));
		layout.setColumnData(columnName, new ColumnWeightData(20));
		layout.setColumnData(columnLocation, new ColumnWeightData(20));
		layout.setColumnData(columnAnimal, new ColumnWeightData(20));
		layout.setColumnData(columnCan, new ColumnWeightData(20));
		tablePanel.setLayout(layout);

		final Composite buttonsPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(2, false));

		final Button addButton = UIControlsFactory.createButton(buttonsPanel, ADD_BUTTON, ViewWidgetId.FARM_ADD);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(addButton);

		final Button removeButton = UIControlsFactory.createButton(buttonsPanel, REMOVE_BUTTON,
				ViewWidgetId.FARM_Remove);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(removeButton);

		
	}

}
