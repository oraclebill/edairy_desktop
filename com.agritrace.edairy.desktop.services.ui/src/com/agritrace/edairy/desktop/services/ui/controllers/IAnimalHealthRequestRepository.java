package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;

public interface IAnimalHealthRequestRepository {

	List<AnimalHealthRequest> allRequests();

}
