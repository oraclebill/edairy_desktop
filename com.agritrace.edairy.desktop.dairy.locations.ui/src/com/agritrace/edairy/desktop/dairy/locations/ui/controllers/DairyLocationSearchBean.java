package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.Route;

public class DairyLocationSearchBean extends AbstractBean {
	private static final String PROP_FUNCTIONS = "functions";
	private static final String PROP_ROUTE = "route";

	private List<DairyFunction> functionSearchValues;
	private Route routeSearchValue;

	public DairyLocationSearchBean() {
		functionSearchValues = new ArrayList<DairyFunction>();
		routeSearchValue = null;
	}

	public List<DairyFunction> getFunctionSearchValues() {
		return functionSearchValues;
	}

	public Route getRouteSearchValue() {
		return routeSearchValue;
	}

	

	public void setFunctionSearchValue(List<DairyFunction> functionSearchValues) {
		final Object oldValue = this.functionSearchValues;
		this.functionSearchValues = functionSearchValues;
		firePropertyChanged(PROP_FUNCTIONS, oldValue, functionSearchValues);
	}

	public void setRouteSearchValue(Route routeSearchValue) {
		final Object oldValue = this.routeSearchValue;
		this.routeSearchValue = routeSearchValue;
		firePropertyChanged(PROP_ROUTE, oldValue, routeSearchValue);
	}

	
}
