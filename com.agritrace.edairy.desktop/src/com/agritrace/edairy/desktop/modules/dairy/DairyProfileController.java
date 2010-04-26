package com.agritrace.edairy.desktop.modules.dairy;

import java.awt.image.ImageObserver;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.*;
import org.eclipse.riena.ui.ridgets.swt.ImageButtonRidget;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

import com.agritrace.edairy.common.datamodel.dairy.Dairy;

public class DairyProfileController extends SubModuleController {
	
	private ITextRidget txtDairyName;
	private ILabelRidget lblDairyImage;
	private ITextRidget txtId;
	private ITextRidget txtLicense;
	private ITextRidget txtDairyDescription;
	private ITextRidget txtManager;
	private ITextRidget txtMemberCount;
	private ITextRidget txtAddress;
	private ITextRidget txtSection;
	private ITextRidget txtEstate;
	private ITextRidget txtTown;
	private ITextRidget txtSubLocation;
	private IComboRidget txtLocation;
	private ITextRidget txtPostalCode;
	private IComboRidget divisionCombo;
	private IComboRidget districtCombo;
	private IComboRidget provinceCombo;
	private IActionRidget btnSave;
	private IActionRidget btnCancel;
	
	public DairyProfileController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDefaultAction(IRidget focusRidget, IActionRidget action) {
		// TODO Auto-generated method stub
		super.addDefaultAction(focusRidget, action);
	}

	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
	}

	@Override
	public void configureRidgets() {
		// TODO Auto-generated method stub
		super.configureRidgets();
		
		txtDairyName = (ITextRidget) getRidget("dairy.profile.dairyname");
		lblDairyImage = (ILabelRidget) getRidget("dairy.profile.dairyimage");
		txtId = (ITextRidget) getRidget("dairy.profile.dairyid");
		txtLicense = (ITextRidget) getRidget("dairy.profile.licence");
		txtDairyDescription = (ITextRidget) getRidget("dairy.profile.description");
		txtManager = (ITextRidget) getRidget("dairy.profile.manager.name");
		txtMemberCount = (ITextRidget) getRidget("dairy.profile.memberCount");
		txtAddress = (ITextRidget) getRidget("dairy.profile.address.address");
		txtSection = (ITextRidget) getRidget("dairy.profile.address.section");
		txtEstate = (ITextRidget) getRidget("dairy.profile.address.estate");
		txtTown = (ITextRidget) getRidget("dairy.profile.address.town");
		txtSubLocation = (ITextRidget) getRidget("dairy.profile.address.sublocation");
		txtLocation = (IComboRidget) getRidget("dairy.profile.address.location");
		txtPostalCode = (ITextRidget) getRidget("dairy.profile.address.postalcode");
		divisionCombo = (IComboRidget) getRidget("dairy.profile.address.division");
		districtCombo = (IComboRidget) getRidget("dairy.profile.address.district");
		provinceCombo = (IComboRidget) getRidget("dairy.profile.address.province");
		btnSave = (IActionRidget) getRidget("dairy.profile.button.save");
		btnCancel = (IActionRidget) getRidget("dairy.profile.button.cancel");
		
		Collection ridgets = getRidgets();
		
//		Dairy dairy = new Dairy();
				
		// sample data
		List<String> locationDomain = Arrays.asList("Gatamaiyu\t", "Gitithia\t", "Kamae\t", "Kamburu\t", "Kijabe\t", "Kinale\t", "Kirenga\t", "Lari\t", "Nyanduma\t");
		txtLocation.bindToModel(
				new WritableList(locationDomain, String.class), String.class, null, new WritableValue());
		
		divisionCombo.bindToModel(
				Observables.staticObservableList(
						Arrays.asList("", "Githunguri", "Kiambaa", "Kikuyu", "Lari\t", "Limuru")),
				String.class,
				null,
				new WritableValue());
		
		districtCombo.bindToModel(
				Observables.staticObservableList(
						Arrays.asList("", "Baringo District (Kabarnet)", "Bomet District (Bomet)", "Bondo District (Bondo)", "Bungoma District (Bungoma)", "Buret District (Litein)", "Busia (Busia)", "Butere/Mumias District (Butere)", "Embu District (Embu)", "Garissa District (Garissa)", "Gucha District (Ogembo)", "Homa Bay District (Homa Bay)", "Ijara District (Ijara)", "Isiolo District (Isiolo)", "Kajiado District (Kajiado)", "Kakamega District (Kakamega)", "Keiyo District (Iten/Tambach)", "Kericho District (Kericho)", "Kiambu District (Kiambu)", "Kilifi District (Kilifi)", "Kirinyaga District (Kerugoya/Kutus)", "Kisii Central (Kisii)", "Kisumu District (Kisumu)", "Kitui District (Kitui)", "Koibatek District (Eldama Ravine)", "Kuria District (Kehancha)", "Kwale District (Kwale)", "Laikipia District (Nanyuki)", "Lamu District (Lamu)", "Lugari District (Lugari)", "Machakos District (Machakos)", "Makueni District (Makueni)", "Malindi District (Malindi)", "Mandera District (Mandera)", "Maragua District (Maragua)", "Marakwet District (Kapsowar)", "Marsabit District (Marsabit)", "Mbeere District (Mbeere)", "Meru Central District (Meru)", "Meru North District (Maua)", "Meru South District (Chuka)", "Migori District (Migori)", "Mombasa District (Mombasa)", "Mount Elgon District (Mount Elgon)", "Moyale District (Moyale)", "Murang'a District (Murang'a)", "Mwingi District (Mwingi)", "Nairobi District (Nairobi)", "Nakuru District (Nakuru)", "Nandi (Kapsabet)", "Narok District (Narok)", "Nyamira District (Nyamira)", "Nyandarua District (Ol Kalou)", "Nyando District (Awasi)", "Nyeri District (Nyeri)", "Rachuonyo District (Oyugis)", "Samburu District (Maralal)", "Siaya District (Siaya)", "Suba District (Mbita)", "Taita-Taveta District (Wundanyi)", "Tana River District (Tana River)", "Teso District (Malaba)", "Tharaka District (Tharaka)", "Thika District (Thika)", "Trans Mara District (Kilgoris)", "Trans Nzoia District (Kitale)", "Turkana District (Lodwar)", "Uasin Gishu District (Eldoret)", "Vihiga District (Vihiga)", "Wajir District (Wajir)", "West Pokot District (Kapenguria)")),
				String.class,
				null,
				new WritableValue());
		
		provinceCombo.bindToModel(
				Observables.staticObservableList(
						Arrays.asList("Central", "Coast", "Eastern", "Nairobi", "North Eastern", "Nyanza", "Rift Valley", "Western")),
				String.class,
				null,
				new WritableValue());
		
//		txtPostalCode.setText("112345");

        updateAllRidgetsFromModel();

	}
	
}
