package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

/**
 * An enum with Kenya's provinces..
 * 
 * I'm hoping these won't change anytime soon.
 * 
 * @author bjones
 */
public enum KenyaProvinceDistrict {

	CENTRAL("Central", new String[] { "Nyandarua District", "Nyeri District", "Kirinyaga District",
			"Murang'a District", "Kiambu District" }),

	COAST("North", new String[] { "Mombasa District", "Kwale District", "Kilifi District", "Tana River District",
			"Lamu District", "Taita/Taveta District" }),

	EASTERN("Eastern", new String[] { "Marsabit District", "Isiolo District", "Meru District",
			"Tharaka-Nithi District", "Embu District", "Kitui District", "Machakos District", "Makueni District" }),

	NORTH_EASTERN("North Eastern", new String[] { "Garissa District", "Wajir District", "Mandera District" }),

	NYANZA("Nyanza", new String[] { "Siaya District", "Kisumu District", "Homa Bay District", "Migori District",
			"Kisii District", "Nyamira District" }),

	RIFT_VALLEY("Rift Valley", new String[] { "Turkana District", "West Pokot District", "Samburu District",
			"Trans Nzoia District", "Uasin Gishu District", "Elgeyo/Marakwet District", "Nandi District",
			"Baringo District", "Laikipia District", "Nakuru District", "Narok District", "Kajiado District",
			"Kericho District", "Bomet District" }),

	WESTERN("Western", new String[] { "Kakamega District", "Vihiga District", "Bungoma District", "Busia District" });

	private final String displayName;
	private final String[] provinces;

	KenyaProvinceDistrict(String displayName, String[] provinces) {
		this.displayName = displayName;
		this.provinces = provinces;
	}

	public List<String> getProvinces() {
		return Arrays.asList(provinces);
	}

	@Override
	public String toString() {
		return displayName;
	}
}
