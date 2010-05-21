package com.agritrace.edairy.desktop.member.ui.views;

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

public class MemberCollectionRecordsWidget {
	
	private Composite composite;
	
	public MemberCollectionRecordsWidget(Composite parent){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1,false));
		initGUI();
	}
	
	public void initGUI(){

		// fitler panel
		final Composite filterPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterPanel);
		filterPanel.setLayout(new GridLayout(2, false));
		
		DateRangeSearchWidget dateRangeWidget = new DateRangeSearchWidget(filterPanel, "Collection Date Range: ", ViewWidgetId.TRANSACTION_FILTER_STARTDATE,
				ViewWidgetId.TRANSACTION_FILTER_ENDDATE);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false).applyTo(dateRangeWidget.getComposite());

		Composite filterButtonPanel = UIControlsFactory.createComposite(filterPanel);
		filterButtonPanel.setLayout(new GridLayout(3,false));
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(true, false).applyTo(filterButtonPanel);

		final Button nprMissing = UIControlsFactory.createButtonCheck(filterButtonPanel, "NPR Missing",
				ViewWidgetId.COLLECTION_FILTER_NPRMISSING);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(nprMissing);

		final Button rejected = UIControlsFactory.createButtonCheck(filterButtonPanel, "Rejected",
				ViewWidgetId.COLLECTION_FILTER_REJECTED);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(rejected);

		final Button flaged = UIControlsFactory.createButtonCheck(filterButtonPanel, "Suspended",
				ViewWidgetId.COLLECTION_FILTER_FLAG);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(flaged);
	

		final Composite tablePanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.COLLECTION_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnId = new TableColumn(table, SWT.LEFT);
		final TableColumn columnDate = new TableColumn(table, SWT.LEFT);
		final TableColumn columnCan = new TableColumn(table, SWT.LEFT);
		final TableColumn columnQuantity = new TableColumn(table, SWT.LEFT);
		final TableColumn columnNPRMissing = new TableColumn(table, SWT.LEFT);
		final TableColumn columnRejected = new TableColumn(table, SWT.LEFT);
		final TableColumn columnSuspected = new TableColumn(table, SWT.LEFT);

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(10));
		layout.setColumnData(columnDate, new ColumnWeightData(15));
		layout.setColumnData(columnCan, new ColumnWeightData(15));
		layout.setColumnData(columnQuantity, new ColumnWeightData(15));
		layout.setColumnData(columnNPRMissing, new ColumnWeightData(15));
		layout.setColumnData(columnRejected, new ColumnWeightData(15));
		layout.setColumnData(columnSuspected, new ColumnWeightData(15));

		tablePanel.setLayout(layout);

	
		
	}

	public Composite getComposite() {
		return composite;
	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}

}
