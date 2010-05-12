package com.agritrace.edairy.dairy.ui.controllers;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;

import com.agritrace.edairy.model.dairy.DairyLocation;


public class DairyLocationService {
	private static DairyLocationService instance = new DairyLocationService();
	private List<DairyLocation> dairyLocations;
	private DairyLocationService() {
		
	}
	
	public static DairyLocationService getInstance()
	{
		return instance;
	}
	
	public void refresh() {
		//EObjectCondition condition = new EObjectCondition();
		//SELECT s = new SELECT(false, null, new FROM());
		DairyLocationResourceManager.INSTANCE.loadDairyLocationsResources();
		try {
			dairyLocations = DairyLocationResourceManager.INSTANCE.getObjectsFromDairyModel(DairyLocation.class);
		} catch (CoreException e) {
			// TODO 			
			e.printStackTrace();
		}
		
	}
	
	public List<DairyLocation> getDairyLocations() {
		if (dairyLocations == null) {
			refresh();
		}
		return dairyLocations;
	}
	
	public DairyLocation query(long id) {
		for (DairyLocation dl : dairyLocations) {
			if (dl.getId() == id)
				return dl;
		}
		return null;
	}
	
	public DairyLocation query(String name) {
		if (name == null || "".equals(name))
			return null;
		
		for (DairyLocation dl : dairyLocations) {
			if (dl.getName().equals(name))
				return dl;
		}
		return null;
	}
	
	public void store() {
		DairyLocationResourceManager.INSTANCE.getDairyLocationsResource().getContents().clear();
		for (int i = 0 ; i < dairyLocations.size(); i ++) {
			DairyLocation dl = dairyLocations.get(i);
			DairyLocationResourceManager.INSTANCE.getDairyLocationsResource().getContents().add(dl);
			if (dl.getRoute() != null) {
				dl.eResource().getContents().add(dl.getRoute());
			}
		}
		try {
			DairyLocationResourceManager.INSTANCE.saveResource(DairyLocationResourceManager.INSTANCE.getDairyLocationsResource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public long create(DairyLocation dl) {
		if (dl.getId() == 0) {
			refresh();
			long newId = 0;
			for (DairyLocation item : dairyLocations) {
				if (item.getId() > newId) {
					newId = item.getId();
				}
			}
			newId++;
			dl.setId(newId ++);
			store();
		}
		return dl.getId();
	}
}
