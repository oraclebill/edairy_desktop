package com.agritrace.edairy.desktop.birt.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IParameterDefn;
import org.eclipse.birt.report.engine.api.IParameterDefnBase;
import org.eclipse.birt.report.engine.api.IParameterGroupDefn;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;

import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.Field;
import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.FieldType;
import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.IFieldGroupRidget;

public class GenericReportViewController extends ReportViewController {

	final private List<Field<?>> fieldModel;

	public GenericReportViewController() {
		fieldModel = new ArrayList<Field<?>>();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
	}

	@Override
	public void afterBind() {
		INavigationNode<ISubModuleNode> currentNode = getNavigationNode();
		String fieldGroupName = (String) currentNode.getContext("field-group-name");
		IFieldGroupRidget fieldGroup = getRidget(IFieldGroupRidget.class, "parameter-field-group");
		for (IParameterDefnBase paramDef : getReportParameterDefinitions(fieldGroupName)) {
			Field<String> fieldGroupField = new Field<String>(paramDef.getName(), FieldType.TEXT,
					paramDef.getDisplayName());
			// todo: if field def has value list, set type to combo and add options..
			fieldModel.add(fieldGroupField);
		}
		fieldGroup.bindToModel(fieldModel);
		fieldGroup.updateFromModel();
	}

	/**
	 * 
	 */
	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		for (Field<?> f : fieldModel) {
			parameters.put(f.getName(), f.getValue());
		}
		return parameters;
	}

	/**
	 * Given a named parameter group, get the scalar parameters associated with the group.
	 * 
	 * If the named group is not found, return the ungrouped scalar parameters for the report.
	 * 
	 * @param name
	 * @return
	 */
	private Collection<IParameterDefn> getReportParameterDefinitions(String name) {
		Collection<IParameterDefn> parameterList = null;
		IReportRunnable report = getReportRunnable();
		IReportEngine engine = report.getReportEngine();
		IGetParameterDefinitionTask task = engine.createGetParameterDefinitionTask(report);
		Object groupObj = task.getParameterDefn(name);
		if (groupObj instanceof IParameterGroupDefn) {
			parameterList = ((IParameterGroupDefn) groupObj).getContents();
		} else if (fallback) {
			parameterList = new ArrayList<IParameterDefn>();
			for (Object paramDef : task.getParameterDefns(true)) {
				if (paramDef instanceof IParameterDefn) {
					parameterList.add((IParameterDefn) paramDef);
				}
			}
		}
		return parameterList;
	}

	boolean fallback = false;
}
