package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockOtherWidget {

	private Composite composite;

	public static final int DEFAULT_LABEL_WIDTH = 78;
	public static final int DEFAULT_FIELD_HEIGHT = 50;

	public LiveStockOtherWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
		.indent(5, 0);
		GridDataFactory fieldFactory = GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT,DEFAULT_FIELD_HEIGHT);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Verterinary :"));
		Text verterinaryTxt =  UIControlsFactory.createText(composite,SWT.MULTI|SWT.BORDER|SWT.V_SCROLL, ViewWidgetId.LIVESTOCK_OTHER_VERTERINARY);
		fieldFactory.applyTo(verterinaryTxt);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Awards :"));
		Text awardText =  UIControlsFactory.createText(composite,SWT.MULTI|SWT.BORDER|SWT.V_SCROLL, ViewWidgetId.LIVESTOCK_OTHER_AWARDS);
		fieldFactory.applyTo(awardText);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Notes :"));
		Text notesText =  UIControlsFactory.createText(composite,SWT.MULTI|SWT.BORDER|SWT.V_SCROLL, ViewWidgetId.LIVESTOCK_OTHER_NOTES);
		fieldFactory.applyTo(notesText);
		
		
	}




}
