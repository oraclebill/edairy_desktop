package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockIdentificationWidget {

	private Composite composite;

	public static final int DEFAULT_LABEL_WIDTH = 150;
//	public static final int DEFAULT_FIELD_WIDTH = 150;

	public LiveStockIdentificationWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(3, false));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)	.indent(5, 0);
		GridDataFactory fieldFactory = GridDataFactory.fillDefaults().grab(true, false);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Acquision Date :"));
		Text dateTxt =  UIControlsFactory.createText(composite, SWT.BORDER|SWT.SINGLE,ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_DATE);
		fieldFactory.applyTo(dateTxt);
		
		ImageButton birthDayBtn =  UIControlsFactory.createImageButton(composite, SWT.NONE,ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_DATE_BTN);
		final Image calendar = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.CALENDAR_ICON);
		birthDayBtn.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(birthDayBtn);
		
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Acquision :"));
		Combo acquisionTypeCombo =  UIControlsFactory.createCombo(composite, ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_TYPE);
		fieldFactory.span(2,1).applyTo(acquisionTypeCombo);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "ID Type :"));
		Combo idTypeCombo =  UIControlsFactory.createCombo(composite, ViewWidgetId.LIVESTOCK_IDENTIFICATION_ID_TYPE);
		fieldFactory.span(2,1).applyTo(idTypeCombo);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "ID Number :"));
		Text idNumberTxt =  UIControlsFactory.createText(composite, SWT.SINGLE|SWT.BORDER,ViewWidgetId.LIVESTOCK_IDENTIFICATION_ID_NUMBER);
		fieldFactory.span(2,1).applyTo(idNumberTxt);
		
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Ministry of Livestock ID :"));         
		Text ministryId =  UIControlsFactory.createText(composite, SWT.SINGLE|SWT.BORDER,ViewWidgetId.LIVESTOCK_IDENTIFICATION_MINISTRY_ID);
		fieldFactory.span(2,1).applyTo(ministryId);


		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Insurance Company :"));
		Text insuranceTxt =  UIControlsFactory.createText(composite, SWT.SINGLE|SWT.BORDER,ViewWidgetId.LIVESTOCK_IDENTIFICATION_INSURANCE_COMPANY);
		fieldFactory.span(2,1).applyTo(insuranceTxt);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Insurance Number :"));         
		Text insuranceNumberTxt =  UIControlsFactory.createText(composite, SWT.SINGLE|SWT.BORDER,ViewWidgetId.LIVESTOCK_IDENTIFICATION_INSURANCE_NUMBER);
		fieldFactory.span(2,1).applyTo(insuranceNumberTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Unique Identifying Features :"));
		Text featureTxt =  UIControlsFactory.createText(composite, SWT.SINGLE|SWT.BORDER,ViewWidgetId.LIVESTOCK_IDENTIFICATION_UNIQUE_FEATURE);
		fieldFactory.span(2,1).applyTo(featureTxt);
		
		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Ownership History :"));
		List ownerList =  UIControlsFactory.createList(composite, true, true, ViewWidgetId.LIVESTOCK_IDENTIFICATION_OWNERSHIPS);
		fieldFactory.span(2,1).applyTo(ownerList);
		
	}
	
}
