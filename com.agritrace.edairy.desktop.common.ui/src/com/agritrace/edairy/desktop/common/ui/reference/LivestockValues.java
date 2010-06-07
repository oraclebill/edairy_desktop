package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

public class LivestockValues {
	
	public static String[] SPECIES = {"Cattle"};
	
	public static String[] BREEDS = {"Brown Swiss"};
	
	public static String[] FEEDHABITS={"Two Times","Three Times"};
	
	public static String[] FEEDTYPES={"Grass"};
	
	public static List<String> getSpecies(){
		return Arrays.asList(SPECIES);
	}

	public static List<String> getBreeds(){
		return Arrays.asList(BREEDS);
	}
	
	public static List<String> getFeedHabits(){
		return Arrays.asList(FEEDHABITS);
	}
	
	public static List<String> getFeedTypes(){
		return Arrays.asList(FEEDTYPES);
	}

}
