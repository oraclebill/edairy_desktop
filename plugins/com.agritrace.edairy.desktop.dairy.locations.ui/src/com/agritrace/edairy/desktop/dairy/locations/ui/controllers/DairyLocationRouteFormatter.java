package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;

/**
 * Route formatter, display the route name
 * @author admin
 *
 */

public class DairyLocationRouteFormatter extends ColumnFormatter {
	@Override
	public String getText(Object element) {
		if (element instanceof DairyLocation) {
			final TransportRoute route = ((DairyLocation) element).getRoute();
			if(route != null){
				return route.getName();
			}
		}
		return null;
	}
}
