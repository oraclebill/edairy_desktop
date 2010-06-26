package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

public class MilkDeliveryFilterPanel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MilkDeliveryFilterPanel(Composite origParent, int style) {
		super(origParent, style);
		setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		setLayout(new FillLayout());
		
		Group group = UIControlsFactory.createGroup(this, "Delivery Log Filter");

		FieldUtil.addLabeledDateField(group, "Start Date", "filter-start-date");
		FieldUtil.addLabeledDateField(group, "End Date", "filter-end-date");
		FieldUtil.addLabeledComboField(group, "Route", "filter-route");
		FieldUtil.addLabeledComboField(group, "Customer", "filter-customer");
		
		Control filler = UIControlsFactory.createLabel(group, "");
		GridDataFactory.swtDefaults().grab(true, false).span(7,1).applyTo(filler);
		
		Control searchButton = UIControlsFactory.createButton(group, "Search", "filter-search-button");		
		GridDataFactory.swtDefaults().align(SWT.RIGHT,SWT.CENTER).applyTo(searchButton);
		
		GridLayoutFactory.swtDefaults().numColumns(8).margins(8, 8).spacing(5, 5).generateLayout(group);
		
		this.pack();
		
	}

	
}
