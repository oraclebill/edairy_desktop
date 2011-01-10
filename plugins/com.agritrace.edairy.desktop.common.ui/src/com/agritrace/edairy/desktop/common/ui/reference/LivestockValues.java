package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

public class LivestockValues {

	public static String[] BREEDS = { "Friesian", "Ayrshire", "Guernsey",
			"Jersey", "Zebu", "Boran", "Sahiwal", "Hereford" };

	public static String[] FEEDHABITS = { "2x Daily", "3x Daily" };

	public static String[] FEEDTYPES = { "Napier grass", "Bana grass ",
			"Sudan grass", "Tree legumes", "Green maize", "Forage sorghum",
			"Pigeon peas", "Cassava tops", "Banana leaves", "Sugarcane tops",
			"Sweet-potato vines", "Other" };

	public static String[] SPECIES = { "Cattle", "Goat", "Sheep", "Camel" };

	public static List<String> getBreeds() {
		return Arrays.asList(BREEDS);
	}

	public static List<String> getFeedHabits() {
		return Arrays.asList(FEEDHABITS);
	}

	public static List<String> getFeedTypes() {
		return Arrays.asList(FEEDTYPES);
	}

	public static List<String> getSpecies() {
		return Arrays.asList(SPECIES);
	}

}
