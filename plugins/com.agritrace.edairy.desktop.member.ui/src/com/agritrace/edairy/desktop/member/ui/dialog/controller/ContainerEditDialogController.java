package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;

public class ContainerEditDialogController extends RecordDialogController<Container> {

	//	 Label idLabelValue   			ViewWidgetId.VIEW_CONTAINER_ID
	//	 Text searchText   				ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT
	//	 ImageButton lookupButton   	ViewWidgetId.FARM_LIST_SEARCH_BUTTON
	//	 CCombo farmCombo   			ViewWidgetId.VIEW_CONTAINER_FARM
	//	 CCombo measureCombo   			ViewWidgetId.VIEW_CONTAINER_UNIT
	//	 Text capacityText   			ViewWidgetId.VIEW_CONTAINER_COMPACITY

	
	public ContainerEditDialogController(String entityName) {
		super(entityName);
	}

	/* (non-Javadoc)
	 * @see com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController#configureUserRidgets()
	 */
	@Override
	protected void configureUserRidgets() {
		Container selectedContainer = getWorkingCopy();
		if (selectedContainer == null) {
			throw new RuntimeException("This shouldn't happen");
		}
		
		Farm farm = selectedContainer.getOwner();
		Farmer farmer = farm.getOwner();
		Membership membership = farmer.getMembership();
	}

	
}
