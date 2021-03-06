package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.OwnershipGroup;

public class LiveStockIdentificationWidget {

	public static final int DEFAULT_LABEL_WIDTH = 150;
	// public static final int DEFAULT_FIELD_WIDTH = 150;

	private final Composite composite;

	public LiveStockIdentificationWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(3, false));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
				.indent(5, 0);
		final GridDataFactory fieldFactory = GridDataFactory.fillDefaults().grab(true, false);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Acquision Date :"));
		final DateTime dateTxt = UIControlsFactory.createDate(composite, SWT.BORDER ,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_DATE);
		fieldFactory.copy().span(2,1).applyTo(dateTxt);


//		final ImageButton birthDayBtn = UIControlsFactory.createImageButton(composite, SWT.NONE,
//				ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_DATE_BTN);
//		final Image calendar = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.CALENDAR_ICON);
//		birthDayBtn.setImage(calendar);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(birthDayBtn);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Acquision :"));
		final CCombo acquisionTypeCombo = UIControlsFactory.createCCombo(composite,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_TYPE);
		fieldFactory.span(2, 1).applyTo(acquisionTypeCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Ministry of Livestock ID :"));
		final Text ministryId = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_MINISTRY_ID);
		fieldFactory.span(2, 1).applyTo(ministryId);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Insurance Company :"));
		final Text insuranceTxt = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_INSURANCE_COMPANY);
		fieldFactory.span(2, 1).applyTo(insuranceTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Insurance Number :"));
		final Text insuranceNumberTxt = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_INSURANCE_NUMBER);
		fieldFactory.span(2, 1).applyTo(insuranceNumberTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Unique Identifying Features :"));
		final Text featureTxt = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_UNIQUE_FEATURE);
		fieldFactory.span(2, 1).applyTo(featureTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(composite, "Ownership History :"));
		final OwnershipGroup owners = new OwnershipGroup(composite, SWT.NONE);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(owners,ViewWidgetId.LIVESTOCK_IDENTIFICATION_OWNERSHIPS);

//		final List ownerList = UIControlsFactory.createList(composite, true, true,
//				ViewWidgetId.LIVESTOCK_IDENTIFICATION_OWNERSHIPS);
		fieldFactory.span(2, 1).applyTo(owners);

	}

}
