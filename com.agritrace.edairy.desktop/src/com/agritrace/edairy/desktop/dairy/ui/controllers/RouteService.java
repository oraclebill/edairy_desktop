package com.agritrace.edairy.desktop.dairy.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Route;

public final class RouteService {
    private static RouteService instance = new RouteService();

    private RouteService() {

    }

    public static RouteService getInstance() {
	instance.refresh();
	return instance;
    }

    private List<Route> routes = null;

    public List<Route> getRoutes() {
	if (routes == null) {
	    try {
		routes = DairyLocationResourceManager.INSTANCE.getObjectsFromDairyModel(Route.class);
	    } catch (final Exception e) {
		e.printStackTrace();
		routes = new ArrayList<Route>();
	    }
	}
	return routes;
    }

    public void store() {
	DairyLocationResourceManager.INSTANCE.getRoutesResource().getContents().clear();
	DairyLocationResourceManager.INSTANCE.getRoutesResource().getContents().addAll(routes);
	try {
	    DairyLocationResourceManager.INSTANCE.saveResource(DairyLocationResourceManager.INSTANCE
		    .getRoutesResource());
	} catch (final Exception e) {
	    e.printStackTrace();
	}
    }

    public void refresh() {
	try {
	    routes = DairyLocationResourceManager.INSTANCE.getObjectsFromDairyModel(Route.class);
	} catch (final Exception e) {
	    e.printStackTrace();
	    routes = new ArrayList<Route>();
	}
    }

    public Route findByName(String name) {
	getRoutes();
	for (final Route r : routes) {
	    if (r.getName().equals(name)) {
		return r;
	    }
	}
	return null;
    }

    public List<String> getNames() {
	getRoutes();
	final List<String> ret = new ArrayList<String>();
	for (final Route r : routes) {
	    ret.add(r.getName());
	}
	return ret;
    }

}
