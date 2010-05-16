package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.agritrace.edairy.desktop.common.ui.managers.IDairyResourceManager;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;

/**
 * Service log view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceLogViewController extends CommonSubModuleViewController {

    private IDairyResourceManager resMgr = null;
    private List<AnimalHealthRequest> filtedResult;
    private List<AnimalHealthRequest> allRequests = new ArrayList<AnimalHealthRequest>();
    public static final String ID = ServiceLogViewController.class.getName();

    public static final int EVENT_TYPE_TABLE_INPUT_CHANGED = 1;

    public ServiceLogViewController() {
	super();
	initModel();
	this.setFilteredResult(this.allRequests);
    }

    public void setResourceManager(IDairyResourceManager resmgr) {
	this.resMgr = resmgr;
    }
    
    public IDairyResourceManager getResourceManager() {
	return this.resMgr;
    }
    
    
    /**
     * Currently we load EMF models from file In the future this code should be
     * replaced teneo/eclipselink framework to load DB objects to EMF models
     */
    private void initModel() {
//	ServiceRequestResourceManager.INSTANCE.loadResources();
	try {
//	    allRequests = ServiceRequestResourceManager.INSTANCE.getObjectsFromDairyModel(AnimalHealthRequest.class);
	    this.allRequests = this.resMgr.getLocalDairy().getAnimalHealthRequests();  // TODO: TEST 
	} catch (final Exception e) {
	    
	    // TODO
	    e.printStackTrace();
	}
    }

    public void setEMFModels(List<AnimalHealthRequest> eobjs) {
	this.allRequests = eobjs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.agritrace.edairy.service.ui.controllers.CommonSubModuleViewController
     * #addSubModuleControllers()
     */
    @Override
    protected void addSubModuleControllers() {

	addSubModuleControllerDelegate(new ServiceRequestLogFilterControllerDelegate(this));
	addSubModuleControllerDelegate(new ServiceRequestLogMasterDetailControllerDelegate(this));
    }

    public List<AnimalHealthRequest> getAllRequests() {

	return this.allRequests;
    }

    public List<AnimalHealthRequest> getFilteredResult() {
	return filtedResult;
    }

    public void setFilteredResult(List<AnimalHealthRequest> result) {
	filtedResult = result;
    }

}
