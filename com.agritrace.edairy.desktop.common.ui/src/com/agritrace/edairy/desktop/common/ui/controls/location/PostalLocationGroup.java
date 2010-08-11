package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PostalLocationGroup extends Group {
	
	public static final String[] DISTRICTS = new String[] { "Baringo District (Kabarnet)", "Bomet District (Bomet)",
			"Bondo District (Bondo)", "Bungoma District (Bungoma)", "Buret District (Litein)", "Busia (Busia)",
			"Butere/Mumias District (Butere)", "Embu District (Embu)", "Garissa District (Garissa)",
			"Gucha District (Ogembo)", "Homa Bay District (Homa Bay)", "Ijara District (Ijara)",
			"Isiolo District (Isiolo)", "Kajiado District (Kajiado)", "Kakamega District (Kakamega)",
			"Keiyo District (Iten/Tambach)", "Kericho District (Kericho)", "Kiambu District (Kiambu)",
			"Kilifi District (Kilifi)", "Kirinyaga District (Kerugoya/Kutus)", "Kisii Central (Kisii)",
			"Kisumu District (Kisumu)", "Kitui District (Kitui)", "Koibatek District (Eldama Ravine)",
			"Kuria District (Kehancha)", "Kwale District (Kwale)", "Laikipia District (Nanyuki)",
			"Lamu District (Lamu)", "Lugari District (Lugari)", "Machakos District (Machakos)",
			"Makueni District (Makueni)", "Malindi District (Malindi)", "Mandera District (Mandera)",
			"Maragua District (Maragua)", "Marakwet District (Kapsowar)", "Marsabit District (Marsabit)",
			"Mbeere District (Mbeere)", "Meru Central District (Meru)", "Meru North District (Maua)",
			"Meru South District (Chuka)", "Migori District (Migori)", "Mombasa District (Mombasa)",
			"Mount Elgon District (Mount Elgon)", "Moyale District (Moyale)", "Murang'a District (Murang'a)",
			"Mwingi District (Mwingi)", "Nairobi District (Nairobi)", "Nakuru District (Nakuru)", "Nandi (Kapsabet)",
			"Narok District (Narok)", "Nyamira District (Nyamira)", "Nyandarua District (Ol Kalou)",
			"Nyando District (Awasi)", "Nyeri District (Nyeri)", "Rachuonyo District (Oyugis)",
			"Samburu District (Maralal)", "Siaya District (Siaya)", "Suba District (Mbita)",
			"Taita-Taveta District (Wundanyi)", "Tana River District (Tana River)", "Teso District (Malaba)",
			"Tharaka District (Tharaka)", "Thika District (Thika)", "Trans Mara District (Kilgoris)",
			"Trans Nzoia District (Kitale)", "Turkana District (Lodwar)", "Uasin Gishu District (Eldoret)",
			"Vihiga District (Vihiga)", "Wajir District (Wajir)", "West Pokot District (Kapenguria)" };

	private CCombo districtCombo;
	private CCombo divisionCombo;
	private CCombo provinceCombo;
	private Text txtAddress;
	private Text txtEstate;
	private CCombo txtLocation;
	private Text txtPostalCode;
	private Text txtSection;
	private Text txtSubLocation;
	private Text txtTown;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public PostalLocationGroup(Composite parent, int style) {
		super(parent, style);
		setText("Location");
		setLayout(new FillLayout());

		// create address and map areas
		createAddressArea(this);
	}

	private Composite createAddressArea(Composite parent) {
		final Composite addressArea = new Composite(parent, SWT.NO_BACKGROUND);
		final GridLayout gl_addressArea = new GridLayout(2, false);
		gl_addressArea.marginTop = 5;
		gl_addressArea.marginRight = 5;
		gl_addressArea.marginBottom = 5;
		gl_addressArea.marginLeft = 5;
		addressArea.setLayout(gl_addressArea);

		final Label label = new Label(addressArea, SWT.NONE);
		label.setText("Address");
		txtAddress = new Text(addressArea, SWT.BORDER);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label label_1 = new Label(addressArea, SWT.NONE);
		label_1.setText("Section/Homestead");
		txtSection = new Text(addressArea, SWT.BORDER);
		txtSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label label_2 = new Label(addressArea, SWT.NONE);
		label_2.setText("Estate/Nearest Centre");
		txtEstate = new Text(addressArea, SWT.BORDER);
		txtEstate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label label_3 = new Label(addressArea, SWT.NONE);
		label_3.setText("Town/Village");
		txtTown = new Text(addressArea, SWT.BORDER);
		txtTown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label label_4 = new Label(addressArea, SWT.NONE);
		label_4.setText("Sub Location");
		txtSubLocation = new Text(addressArea, SWT.BORDER);
		txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label label_5 = new Label(addressArea, SWT.NONE);
		label_5.setText("Location");
		txtLocation = new CCombo(addressArea, SWT.READ_ONLY);
		txtLocation.setItems(new String[] { "Gatamaiyu\t", "Gitithia\t", "Kamae\t", "Kamburu\t", "Kijabe\t",
				"Kinale\t", "Kirenga\t", "Lari\t", "Nyanduma\t" });
		txtLocation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		txtLocation.select(0);

		final Label label_6 = new Label(addressArea, SWT.NONE);
		label_6.setText("Division");
		divisionCombo = new CCombo(addressArea, SWT.READ_ONLY);
		divisionCombo.setItems(new String[] { "Githunguri", "Kiambaa", "Kikuyu", "Lari\t", "Limuru" });
		divisionCombo.select(1);
		// divisionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false, 1, 1));

		final Label label_7 = new Label(addressArea, SWT.NONE);
		label_7.setText("District");
		districtCombo = new CCombo(addressArea, SWT.READ_ONLY);
		districtCombo.setItems(DISTRICTS);
		districtCombo.select(1);
		// districtCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false, 1, 1));

		final Label label_8 = new Label(addressArea, SWT.NONE);
		label_8.setText("Province");
		provinceCombo = new CCombo(addressArea, SWT.READ_ONLY);
		provinceCombo.setItems(new String[] { "Central", "Coast", "Eastern", "Nairobi", "North Eastern", "Nyanza",
				"Rift Valley", "Western" });
		provinceCombo.select(1);
		// provinceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false, 1, 1));

		final Label label_9 = new Label(addressArea, SWT.NONE);
		label_9.setText("Postal Code");
		txtPostalCode = new Text(addressArea, SWT.BORDER);
		txtPostalCode.setText("112345");
		final GridData gd_txtPostalCode = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtPostalCode.minimumWidth = 50;
		txtPostalCode.setLayoutData(gd_txtPostalCode);

		return addressArea;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
