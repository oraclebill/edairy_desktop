package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockGeneralWidget {

	public static final int DEFAULT_FIELD_WIDTH = 150;

	public static final int DEFAULT_LABEL_WIDTH = 120;
	private final Composite composite;

	public LiveStockGeneralWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, true));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		final Composite leftPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(leftPanel);
		leftPanel.setLayout(new GridLayout(3, false));

		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
				.indent(5, 0);
		final GridDataFactory fieldFactory = GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT);

		labelFactory.applyTo(UIControlsFactory.createLabel(leftPanel, "Type/Species :"));
		final CCombo typeCombo = UIControlsFactory.createCCombo(leftPanel, ViewWidgetId.LIVESTOCK_GENERAL_TYPE_COBMO);
		fieldFactory.span(2, 1).applyTo(typeCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(leftPanel, "Primary Breed :"));
		final CCombo breedCombo = UIControlsFactory.createCCombo(leftPanel, ViewWidgetId.LIVESTOCK_GENERAL_BREED_COBMO);
		fieldFactory.span(2, 1).applyTo(breedCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(leftPanel, "Gender :"));
		final Composite genderPanel = UIControlsFactory.createComposite(leftPanel);
		fieldFactory.span(2, 1).applyTo(genderPanel);
		genderPanel.setLayout(new GridLayout(2, true));

		final Button maleButton = UIControlsFactory.createButtonRadio(genderPanel, "Male",
				ViewWidgetId.LIVESTOCK_GENERAL_MALE);
		GridDataFactory.fillDefaults().applyTo(maleButton);

		final Button femaleButton = UIControlsFactory.createButtonRadio(genderPanel, "Female",
				ViewWidgetId.LIVESTOCK_GENERAL_FEMALE);
		GridDataFactory.fillDefaults().applyTo(femaleButton);

		labelFactory.applyTo(UIControlsFactory.createLabel(leftPanel, "Date of Birth :"));
		final DateTime birthDayTxt = UIControlsFactory.createDate(leftPanel, SWT.BORDER,
				ViewWidgetId.LIVESTOCK_GENERAL_BIRTHDAY);
		GridDataFactory.fillDefaults().grab(true, false).span(2,1).applyTo(birthDayTxt);

//		final ImageButton birthDayBtn = UIControlsFactory.createImageButton(leftPanel, SWT.NONE,
//				ViewWidgetId.LIVESTOCK_GENERAL_BIRTHDAY_BUTTON);
//		final Image calendar = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.CALENDAR_ICON);
//		birthDayBtn.setImage(calendar);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(birthDayBtn);

		labelFactory.applyTo(UIControlsFactory.createLabel(leftPanel, "Birth Certificate Number :"));
		final Text certificateTxt = UIControlsFactory.createText(leftPanel, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_GENERAL_BIRTH_CERTIFICATE);
		fieldFactory.span(2, 1).applyTo(certificateTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(leftPanel, "Veterinary Confirmation :"));
		final Text veterinaryTxt = UIControlsFactory.createText(leftPanel, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_GENERAL_VERTERINARY);
		fieldFactory.span(2, 1).applyTo(veterinaryTxt);

		final Composite rightPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(rightPanel);
		rightPanel.setLayout(new GridLayout(3, false));

		labelFactory.applyTo(UIControlsFactory.createLabel(rightPanel, "Sire Species :"));
		final CCombo sireSpecies = UIControlsFactory
				.createCCombo(rightPanel, ViewWidgetId.LIVESTOCK_GENERAL_SIRE_SPECIES);
		fieldFactory.span(2, 1).applyTo(sireSpecies);

		labelFactory.applyTo(UIControlsFactory.createLabel(rightPanel, "Sire Breed :"));
		final CCombo sireBreed = UIControlsFactory.createCCombo(rightPanel, ViewWidgetId.LIVESTOCK_GENERAL_SIRE_BREED);
		fieldFactory.span(2, 1).applyTo(sireBreed);

	}

}