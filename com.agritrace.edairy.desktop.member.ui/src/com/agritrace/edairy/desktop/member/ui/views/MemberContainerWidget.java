package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberContainerWidget {
	
	private Composite composite;
	
	public static final String ADD_BUTTON = "Add &Container";
	public static final String REMOVE_BUTTON = "&Remove";
	
	public MemberContainerWidget(Composite parent){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1,true));
		initGUI();
	}
	
	public void initGUI(){
		
		final Combo farmCombo = UIControlsFactory.createCombo(composite, ViewWidgetId.CONTAINER_FarmCombo);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false).applyTo(farmCombo);

		final Composite containerPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(containerPanel);

		final Table table = UIControlsFactory.createTable(containerPanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.CONTAINER_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnID = new TableColumn(table, SWT.LEFT);
		// columnID.setText("ID");
		final TableColumn columnType = new TableColumn(table, SWT.LEFT);
		// columnType.setText("Type");

		final TableColumn columnMeasure = new TableColumn(table, SWT.LEFT);
		// columnMeasure.setText("Measure");

		final TableColumn columnCapacity = new TableColumn(table, SWT.LEFT);
		// columnCapacity.setText("Capacity");

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnID, new ColumnWeightData(25));
		layout.setColumnData(columnType, new ColumnWeightData(25));
		layout.setColumnData(columnMeasure, new ColumnWeightData(25));
		layout.setColumnData(columnCapacity, new ColumnWeightData(25));
		containerPanel.setLayout(layout);

		final Composite buttonsPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.BOTTOM).grab(false, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(2, false));

		final Button addButton = UIControlsFactory.createButton(buttonsPanel, ADD_BUTTON, ViewWidgetId.CONTAINER_ADD);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).grab(false, false).applyTo(addButton);

		final Button removeButton = UIControlsFactory.createButton(buttonsPanel, REMOVE_BUTTON,
				ViewWidgetId.CONTAINER_Remove);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).grab(false, false).applyTo(removeButton);

	
	}

	public Composite getComposite() {
		return composite;
	}
	

}
