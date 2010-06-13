package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class MilkCollectionLog extends AbstractRecordListView {
	
	public static final String ID = "milk-collection-log";

	public MilkCollectionLog() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		Composite comp = new MilkCollectionLogFilterPanel(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3,-1).applyTo(comp);
	}
	
	protected void createFilterButtons(Composite parent) {
//		// Reset Apply buttons
//		final Composite comp = UIControlsFactory.createComposite(parent);
//		final GridLayout layout = new GridLayout(1, false);
//		layout.horizontalSpacing = 40;
//		comp.setLayout(layout);
//		
//		final GridData data = new GridData(GridData.FILL_HORIZONTAL);
//		data.horizontalAlignment = GridData.CENTER;
//		data.horizontalSpan = 3;
//
//		comp.setLayoutData(data);
//
//		// Search Button
//		final Button searchBtn = UIControlsFactory.createButton(comp, "Search");
//		addUIControl(searchBtn, BIND_ID_FILTER_SEARCH);
//
//		// ResetButton
//		final Button resetBtn = UIControlsFactory.createButton(comp, "Reset");
//		addUIControl(resetBtn, BIND_ID_FILTER_RESET);
	}

//	private void createDateRange(Composite parent) {
//		// Creates Date Range control
//		UIControlsFactory.createLabel(parent, "Date Range");
//		Composite startDateComp = UIControlsFactory.createComposite(parent);
//		startDateComp.setLayout(new GridLayout(3, false));
//		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(startDateComp);
//
//		UIControlsFactory.createLabel(startDateComp, "Start");
//		final DatePickerComposite startDateLookup = UIControlsFactory.createDatePickerComposite(startDateComp);
//		startDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		addUIControl(startDateLookup, ViewConstants.START_DATE_TEXT);
//
//		Composite endDateComp = UIControlsFactory.createComposite(parent);
//		endDateComp.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).margins(0, 0).create());
//		endDateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		UIControlsFactory.createLabel(endDateComp, "End");
//		final DatePickerComposite endDateLookup = UIControlsFactory.createDatePickerComposite(endDateComp);
//		endDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		addUIControl(endDateLookup, ViewConstants.END_DATE_TEXT);
//
//	}

}
