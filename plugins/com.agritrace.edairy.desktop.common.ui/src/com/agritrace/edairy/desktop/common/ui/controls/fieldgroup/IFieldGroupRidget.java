package com.agritrace.edairy.desktop.common.ui.controls.fieldgroup;

import java.util.List;
import java.util.Map;

import org.eclipse.riena.ui.ridgets.IRidget;

public interface IFieldGroupRidget extends IRidget {
	
	public Map<String, ?> getValues();
	public void bindToModel(List<Field> model);
	
}
