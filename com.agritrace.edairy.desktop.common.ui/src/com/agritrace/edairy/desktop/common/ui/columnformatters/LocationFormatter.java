package com.agritrace.edairy.desktop.common.ui.columnformatters;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;

/**
 * Column formatter for Location {@link Location}
 * 
 * It shows address+","village"+,"postal code"
 */
public class LocationFormatter extends ColumnFormatter {
	@Override
	public String getText(Object element) {
		if (element instanceof Location) {
			Location location = (Location) element;
			final PostalLocation postalLocation = location.getPostalLocation();
//			StringBuffer sb = new StringBuffer();
			if (postalLocation != null) {
				return postalLocation.getAddress() + "," + postalLocation.getVillage() + ","
						+ postalLocation.getPostalCode();
			}
		}

		return null;
	}
}