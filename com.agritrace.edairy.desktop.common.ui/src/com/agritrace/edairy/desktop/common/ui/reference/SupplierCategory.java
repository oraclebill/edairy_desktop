package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

public class SupplierCategory {

	public static final SupplierCategory[] CATEGORIES = { new SupplierCategory("Feed"),
			new SupplierCategory("Office Supplies"), new SupplierCategory("Office Equipment"),
			new SupplierCategory("Milk Processing Equipment"), new SupplierCategory("Veterinary Services"),
			new SupplierCategory("Transportation Services"), new SupplierCategory("Vehicle Repair"),
			new SupplierCategory("Vehicle Sales"), new SupplierCategory("Other") };

	public static SupplierCategory getByName(String name) {

		for (final SupplierCategory cate : CATEGORIES) {
			if ((cate != null) && (cate.getName() != null) && cate.getName().equals(name)) {
				return cate;
			}
		}
		return null;
	}

	public static List<SupplierCategory> getCategoriesList() {
		return Arrays.asList(CATEGORIES);
	}

	private String name;

	public SupplierCategory(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
