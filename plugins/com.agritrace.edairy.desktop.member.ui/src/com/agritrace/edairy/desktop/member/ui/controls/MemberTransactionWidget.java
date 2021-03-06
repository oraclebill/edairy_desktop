package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.common.ui.controls.daterange.DateRange;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberTransactionWidget {
	public static final String ADD_BUTTON = "&Add Transaction";

	public static final String View_BUTTON = "&View";
	private final Composite composite;

	public MemberTransactionWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1, false));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		// fitler panel
		Composite datePanel = UIControlsFactory.createComposite(composite);
		DateRange dateRange = new DateRange(datePanel, SWT.BORDER);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(dateRange, ViewWidgetId.TRANSACTION_DATERANGE);
		Button updateButton = UIControlsFactory.createButton(datePanel, "Update");
		SWTBindingPropertyLocator.getInstance().setBindingProperty(updateButton, ViewWidgetId.TRANSACTION_UPDATE_BTN);

		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(datePanel);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false).applyTo(datePanel);
		// final DateRangeSearchWidget dateRangeWidget = new
		// DateRangeSearchWidget(composite, "Transaction Date Range: ",
		// ViewWidgetId.TRANSACTION_FILTER_STARTDATE,
		// ViewWidgetId.TRANSACTION_FILTER_ENDDATE,
		// ViewWidgetId.TRANSACTION_FILTER_STARTDATE_BUTTON,
		// ViewWidgetId.TRANSACTION_FILTER_ENDDATE_BUTTON);
		// GridDataFactory.swtDefaults().align(SWT.BEGINNING,
		// SWT.FILL).grab(false, false)
		// .applyTo(dateRangeWidget.getComposite());

		final Composite tablePanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.TRANSACTION_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnID = new TableColumn(table, SWT.LEFT);
		columnID.setText("ID");
		final TableColumn columnDate = new TableColumn(table, SWT.LEFT);
		columnDate.setText("Date");
		final TableColumn columnType = new TableColumn(table, SWT.LEFT);
		columnType.setText("Type");

		final TableColumn columnDescription = new TableColumn(table, SWT.LEFT);
		columnDescription.setText("Description");

		final TableColumn columnAmount = new TableColumn(table, SWT.LEFT);
		columnAmount.setText("Amount");

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnID, new ColumnWeightData(10));
		layout.setColumnData(columnDate, new ColumnWeightData(20));
		layout.setColumnData(columnType, new ColumnWeightData(20));
		layout.setColumnData(columnAmount, new ColumnWeightData(20));
		layout.setColumnData(columnDescription, new ColumnWeightData(25));
		tablePanel.setLayout(layout);

		final Composite buttonPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		buttonPanel.setLayout(new GridLayout(2, false));
		buttonPanel.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));

		// final Button addButton = UIControlsFactory.createButton(buttonPanel,
		// ADD_BUTTON,
		// ViewWidgetId.TRANSACTION_ADD_BUTTON);
		// GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false,
		// false).applyTo(addButton);

		// final Button vButton = UIControlsFactory.createButton(buttonPanel,
		// View_BUTTON,
		// ViewWidgetId.TRANSACTION_VIEW_BUTTON);
		// GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false,
		// false).applyTo(vButton);

	}

}
