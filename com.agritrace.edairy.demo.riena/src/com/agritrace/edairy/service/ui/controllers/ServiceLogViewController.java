package com.agritrace.edairy.service.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.service.core.ServiceRequestResourceManager;

/**
 * Service log view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceLogViewController extends CommonSubModuleViewController {

    private List<AnimalHealthRequest> filtedResult;
    private List<AnimalHealthRequest> allRequests = new ArrayList<AnimalHealthRequest>();
    public static final String ID = ServiceLogViewController.class.getName();

    public static final int EVENT_TYPE_TABLE_INPUT_CHANGED = 1;

    public ServiceLogViewController() {
	super();
	initModel();
	this.setFilteredResult(this.allRequests);
    }

    /**
     * Currently we load EMF models from file In the future this code should be
     * replaced teneo/eclipselink framework to load DB objects to EMF models
     */
    private void initModel() {
	ServiceRequestResourceManager.INSTANCE.loadResources();
	try {
	    allRequests = ServiceRequestResourceManager.INSTANCE.getObjectsFromDairyModel(AnimalHealthRequest.class);
	} catch (final CoreException e) {
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
