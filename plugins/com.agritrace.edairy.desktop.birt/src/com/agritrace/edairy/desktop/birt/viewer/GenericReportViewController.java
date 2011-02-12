package com.agritrace.edairy.desktop.birt.viewer;

import java.util.List;
import java.util.Map;

import org.eclipse.birt.report.engine.api.IParameterDefnBase;

import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.IFieldGroupRidget;

public class GenericReportViewController extends ReportViewController {

	@Override
	protected Map<String, Object> getReportParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void configureRidgets() {
		IFieldGroupRidget fieldGroup = getRidget(IFieldGroupRidget.class, "field-group");
		for (IParameterDefnBase paramDef : getReportParameterDefinitions()) {
//			fieldGroup.addField
			paramDef.getDisplayName();
			paramDef.getName();
			paramDef.getParameterType();
			paramDef.getTypeName();		
		}
		super.configureRidgets();		
	}

	private List<IParameterDefnBase> getReportParameterDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
