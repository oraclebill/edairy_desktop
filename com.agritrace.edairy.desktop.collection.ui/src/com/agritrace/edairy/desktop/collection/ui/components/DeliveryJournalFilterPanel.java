package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.collection.ui.util.FieldUtil;

public class DeliveryJournalFilterPanel extends Composite {

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public DeliveryJournalFilterPanel(Composite origParent, int style) {
		super(origParent, style);
		setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		setLayout(new FillLayout());

		final Group group = UIControlsFactory.createGroup(this, "Delivery Log Filter");
		final FieldUtil fieldUtil = new FieldUtil();
		fieldUtil.addLabeledDateField(group, "Start Date", "filter-min-date");
		fieldUtil.addLabeledDateField(group, "End Date", "filter-max-date");
		fieldUtil.addLabeledComboField(group, "Transport Route", "filter-route");
		fieldUtil.addLabeledComboField(group, "Customer", "filter-customer");

		final Control filler = UIControlsFactory.createLabel(group, "");
		GridDataFactory.swtDefaults().grab(true, false).span(7, 1).applyTo(filler);

		GridLayoutFactory.swtDefaults().numColumns(8).margins(8, 8).spacing(5, 5).generateLayout(group);

		this.pack();

	}

}
