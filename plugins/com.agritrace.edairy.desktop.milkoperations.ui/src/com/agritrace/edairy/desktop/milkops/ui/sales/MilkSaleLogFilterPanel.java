package com.agritrace.edairy.desktop.milkops.ui.sales;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.milkops.ui.util.FieldUtil;

public class MilkSaleLogFilterPanel extends Composite {

	public static final String FILTER_START_DATE = "filter-min-date";
	public static final String FILTER_END_DATE = "filter-min-date";
	public static final String FILTER_STORE = "filter-store";
	public static final String FILTER_CUSTOMER = "filter-customer";

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public MilkSaleLogFilterPanel(Composite origParent, int style) {
		super(origParent, style);
		setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		setLayout(new FillLayout());

		final Group group = UIControlsFactory.createGroup(this, "Delivery Log Filter");
		final FieldUtil fieldUtil = new FieldUtil();
		fieldUtil.addLabeledDateField(group, "Start Date", FILTER_START_DATE);
		fieldUtil.addLabeledDateField(group, "End Date", FILTER_END_DATE);
		fieldUtil.addLabeledComboField(group, "Store", FILTER_STORE);
		fieldUtil.addLabeledComboField(group, "Customer", FILTER_CUSTOMER);

		final Control filler = UIControlsFactory.createLabel(group, "");
		GridDataFactory.swtDefaults().grab(true, false).span(7, 1).applyTo(filler);

		GridLayoutFactory.swtDefaults().numColumns(8).margins(8, 8).spacing(5, 5).generateLayout(group);

		this.pack();

	}

}
