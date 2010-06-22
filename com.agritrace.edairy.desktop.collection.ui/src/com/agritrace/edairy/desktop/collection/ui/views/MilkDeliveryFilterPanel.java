package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class MilkDeliveryFilterPanel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MilkDeliveryFilterPanel(Composite parent, int style) {
		super(parent, style);
//		setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));

		FieldUtil.addLabeledDateField(this, "Start Date", "filter-start-date");
		FieldUtil.addLabeledDateField(this, "End Date", "filter-end-date");
		FieldUtil.addLabeledComboField(this, "Route", "filter-route");
		FieldUtil.addLabeledComboField(this, "Customer", "filter-customer");
		
		Control filler = UIControlsFactory.createLabel(this, "");
		GridDataFactory.swtDefaults().grab(true, false).span(5,1).applyTo(filler);
		Control searchButton = UIControlsFactory.createButton(this, "Search", "filter-search-button");		
		GridDataFactory.swtDefaults().align(SWT.RIGHT,SWT.CENTER).applyTo(searchButton);
		
		GridLayoutFactory.swtDefaults().numColumns(8).margins(8, 8).spacing(5, 5).generateLayout(this);
		
		this.pack();
		
	}

	
}
