package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;

public class SupplierCategory {

	public static final SupplierCategory[] CATEGORIES = { new SupplierCategory("Feed"),
			new SupplierCategory("Office Supplies"), new SupplierCategory("Office Equipment"),
			new SupplierCategory("Milk Processing Equipment"), new SupplierCategory("Veterinary Services"),
			new SupplierCategory("Transportation Services"), new SupplierCategory("Vehicle Repair"),
			new SupplierCategory("Vehicle Sales"), new SupplierCategory("Other") };

	public static List<SupplierCategory> getCategoriesList() {
		return Arrays.asList(CATEGORIES);
	}

	public SupplierCategory(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static SupplierCategory getByName(String name) {
		
		for (SupplierCategory cate:CATEGORIES)
		{
			if (cate!=null && cate.getName()!=null && cate.getName().equals(name))
			{
				return cate;
			}
		}
		return null;
	}

}
