package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;

public class AddressPanel extends CompositePanel {

		public AddressPanel(Composite parent, int style) {
			super(parent, style);

			final GridLayout layout = new GridLayout(4, false);
			layout.marginWidth = layout.marginHeight = DairyLocationView.FORM_MARGIN;
			layout.horizontalSpacing = DairyLocationView.COLUMN_MARGIN;
			this.setLayout(layout);

			final Label addressLabel = UIControlsFactory.createLabel(this, "Address");
			GridData gd = new GridData();
			addressLabel.setLayoutData(gd);

			final Text addressText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_ADDRESS);
			gd = new GridData();
			gd.horizontalSpan = 3;
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 3;
			addressText.setLayoutData(gd);

			final Label sectionLabel = UIControlsFactory.createLabel(this, "Section/Homestead");
			gd = new GridData();
			sectionLabel.setLayoutData(gd);

			final Text sectionText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_SECTION);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			sectionText.setLayoutData(gd);

			final Label townLabel = UIControlsFactory.createLabel(this, "Town/Village");
			gd = new GridData();
			townLabel.setLayoutData(gd);

			final Text townText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_TOWN);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			townText.setLayoutData(gd);

			// #TODO: Should this UI component be removed or update the
			// dairy.escore
			// file?
			final Label estateLabel = UIControlsFactory.createLabel(this, "Estate/Nearest Centre");
			gd = new GridData();
			estateLabel.setLayoutData(gd);

			final Text estateText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_ESTATE);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			estateText.setLayoutData(gd);

			final Label locationLabel = UIControlsFactory.createLabel(this, "Location");
			gd = new GridData();
			locationLabel.setLayoutData(gd);

			final Text locationText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_LOCATION);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			locationText.setLayoutData(gd);

			final Label subLocationLabel = UIControlsFactory.createLabel(this, "Sub");
			gd = new GridData();
			subLocationLabel.setLayoutData(gd);

			final Text subLocationText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_SUB);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			subLocationText.setLayoutData(gd);

			final Label districtLabel = UIControlsFactory.createLabel(this, "District");
			gd = new GridData();
			districtLabel.setLayoutData(gd);

			final Text districtText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_DISTRICT);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			districtText.setLayoutData(gd);

			final Label divisionLabel = UIControlsFactory.createLabel(this, "Division");
			gd = new GridData();
			divisionLabel.setLayoutData(gd);

			final Text divisionText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_DIVISION);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			divisionText.setLayoutData(gd);

			final Label postalCodeLabel = UIControlsFactory.createLabel(this, "Postal Code");
			gd = new GridData();
			postalCodeLabel.setLayoutData(gd);

			final Text postalCodeText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
					DairyLocationController.RIDGET_ID_PL_POSTALCODE);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			postalCodeText.setLayoutData(gd);

			final Label provinceLabel = UIControlsFactory.createLabel(this, "Province");
			gd = new GridData();
			provinceLabel.setLayoutData(gd);

//			final Text provinceText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
//					DairyLocationController.RIDGET_ID_PL_PROVINCE);
			final CCombo provinceText = UIControlsFactory.createCCombo(this, 
					DairyLocationController.RIDGET_ID_PL_PROVINCE);
			gd = new GridData();
			gd.widthHint = DairyLocationView.WIDTH_UNIT * 2;
			provinceText.setLayoutData(gd);
		}
	}