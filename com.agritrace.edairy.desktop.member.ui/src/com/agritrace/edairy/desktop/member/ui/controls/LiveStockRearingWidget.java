package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockRearingWidget {

	public static final int DEFAULT_FIELD_WIDTH = 250;

	public static final int DEFAULT_LABEL_WIDTH = 240;
	private final Composite composite;

	public LiveStockRearingWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
				.indent(5, 0);
		final GridDataFactory fieldFactory = GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT)
				.grab(true, false);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Feeding and Milking Habits (per day) :"));
		final CCombo habitsCombo = UIControlsFactory.createCCombo(composite, ViewWidgetId.LIVESTOCK_REARING_HABITS);
		fieldFactory.applyTo(habitsCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Farming Type :"));
		final CCombo typeCombo = UIControlsFactory.createCCombo(composite, ViewWidgetId.LIVESTOCK_REARING_FAMILY);
		fieldFactory.applyTo(typeCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Feed Type :"));
		final CCombo feedCombo = UIControlsFactory.createCCombo(composite, ViewWidgetId.LIVESTOCK_REARING_FEED);
		fieldFactory.applyTo(feedCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Feed Brand :"));
		final Text feedBrand = UIControlsFactory.createText(composite, SWT.BORDER | SWT.SINGLE,
				ViewWidgetId.LIVESTOCK_REARING_FEED_BRAND);
		fieldFactory.applyTo(feedBrand);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Supplements :"));
		final Text supplementsTxt = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_REARING_SUPPLIERS);
		fieldFactory.applyTo(supplementsTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Antibiotics :"));
		final Text antibioticsTxt = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_REARING_ANTIBIOTICS);
		fieldFactory.applyTo(antibioticsTxt);

	}

}
