package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SessionBindingConstants;

public class SessionEditDialogController extends RecordDialogController<CollectionSession> {
	@Override
	protected void configureUserRidgets() {
		getWindowRidget().setTitle("Edit Session");
		
		addTextMap(SessionBindingConstants.SESSION_BIND_CODE.name(), DairyPackage.Literals.COLLECTION_SESSION__CODE);
		addTextMap(SessionBindingConstants.SESSION_BIND_DESCRIPTION.name(), DairyPackage.Literals.COLLECTION_SESSION__DESCRIPTION);
		addTextMap(SessionBindingConstants.SESSION_BIND_TIME.name(), DairyPackage.Literals.COLLECTION_SESSION__TIME_OF_DAY);
		
		getRidget(ITextRidget.class, SessionBindingConstants.SESSION_BIND_CODE.name()).setMandatory(true);
	}
}
