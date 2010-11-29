package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LivestockGeneralInfoPanel extends Composite {

	public static final int DEFAULT_FIELD_WIDTH = 150;

	public static final int DEFAULT_LABEL_WIDTH = 120;

	public LivestockGeneralInfoPanel(Composite parent, int style) {
		super(parent, style);

		setBackground(parent.getBackground());
		setLayout(GridLayoutFactory.fillDefaults().numColumns(3).create());

		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
				.indent(5, 0);
		final GridDataFactory fieldFactory = GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Gender :"));
		final Composite genderPanel = UIControlsFactory.createComposite(this);
		fieldFactory.span(2, 1).applyTo(genderPanel);
		genderPanel.setLayout(new GridLayout(2, true));

		final Button maleButton = UIControlsFactory.createButtonRadio(genderPanel, "Male",
				ViewWidgetId.LIVESTOCK_GENERAL_MALE);
		GridDataFactory.fillDefaults().applyTo(maleButton);

		final Button femaleButton = UIControlsFactory.createButtonRadio(genderPanel, "Female",
				ViewWidgetId.LIVESTOCK_GENERAL_FEMALE);
		GridDataFactory.fillDefaults().applyTo(femaleButton);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Date of Birth :"));
		final DateTime birthDayTxt = UIControlsFactory.createDate(this, SWT.BORDER,
				ViewWidgetId.LIVESTOCK_GENERAL_BIRTHDAY);
		GridDataFactory.fillDefaults().grab(true, false).span(2,1).applyTo(birthDayTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Type/Species :"));
		final CCombo typeCombo = UIControlsFactory.createCCombo(this, ViewWidgetId.LIVESTOCK_GENERAL_TYPE_COBMO);
		fieldFactory.span(2, 1).applyTo(typeCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Primary Breed :"));
		final CCombo breedCombo = UIControlsFactory.createCCombo(this, ViewWidgetId.LIVESTOCK_GENERAL_BREED_COBMO);
		fieldFactory.span(2, 1).applyTo(breedCombo);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Sire Species :"));
		final CCombo sireSpecies = UIControlsFactory
				.createCCombo(this, ViewWidgetId.LIVESTOCK_GENERAL_SIRE_SPECIES);
		fieldFactory.span(2, 1).applyTo(sireSpecies);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Sire Breed :"));
		final CCombo sireBreed = UIControlsFactory.createCCombo(this, ViewWidgetId.LIVESTOCK_GENERAL_SIRE_BREED);
		fieldFactory.span(2, 1).applyTo(sireBreed);

		//		final ImageButton birthDayBtn = UIControlsFactory.createImageButton(this, SWT.NONE,
//				ViewWidgetId.LIVESTOCK_GENERAL_BIRTHDAY_BUTTON);
//		final Image calendar = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.CALENDAR_ICON);
//		birthDayBtn.setImage(calendar);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(birthDayBtn);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Birth Cert. No. :"));
		final Text certificateTxt = UIControlsFactory.createText(this, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_GENERAL_BIRTH_CERTIFICATE);
		fieldFactory.span(2, 1).applyTo(certificateTxt);

		labelFactory.applyTo(UIControlsFactory.createLabel(this, "Vet. Conf. No. :"));
		final Text veterinaryTxt = UIControlsFactory.createText(this, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.LIVESTOCK_GENERAL_VERTERINARY);
		fieldFactory.span(2, 1).applyTo(veterinaryTxt);

//		final Composite rightPanel = UIControlsFactory.createComposite(this);
//		GridDataFactory.fillDefaults().grab(true, true).applyTo(rightPanel);
//		rightPanel.setLayout(new GridLayout(3, false));


	}

}
