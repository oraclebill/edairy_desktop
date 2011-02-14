package com.agritrace.edairy.desktop.birt.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IParameterDefn;
import org.eclipse.birt.report.engine.api.IParameterGroupDefn;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;

import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.Field;
import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.FieldType;
import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.IFieldGroupRidget;

public class GenericReportViewController extends ReportViewController {

	final private List<Field> fieldModel;

	public GenericReportViewController() {
		fieldModel = new ArrayList<Field>();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
	}

	@Override
	public void afterBind() {
		super.afterBind();
		fieldModel.clear();
		fieldModel.addAll(generateFieldList(getReportParameterDefinitions()));

		IFieldGroupRidget fieldGroup = getRidget(IFieldGroupRidget.class, "parameter-field-group");
		fieldGroup.bindToModel(fieldModel);
		fieldGroup.updateFromModel();
	}

	/**
	 * 
	 */
	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		for (Field f : fieldModel) {
			parameters.put(f.getName(), f.getValue());
		}
		return parameters;
	}


	private List<Field> generateFieldList(Collection<IParameterDefn> paramDefs) {
		List<Field> fieldList = new ArrayList<Field>();
		for (IParameterDefn paramDef : paramDefs) {

			String paramName = paramDef.getName();
			int paramType = paramDef.getParameterType();
			int dataType = paramDef.getDataType();
			String displayName = paramDef.getPromptText();
			String helpText = paramDef.getHelpText();

			Field fieldGroupField;
			if (paramType == paramDef.LIST_PARAMETER) {
				// todo: if field def has value list, set type to combo and add options..
				throw new UnsupportedOperationException();
			}
			FieldType fieldType = translateToFieldType(dataType);

			fieldGroupField = new Field(paramName, fieldType, displayName);
			fieldGroupField.setHelpText(helpText);

			fieldList.add(fieldGroupField);
		}
		return fieldList;
	}

	private FieldType translateToFieldType(int dataType) {
		FieldType fieldType = null;
		switch (dataType) {
		case IParameterDefn.TYPE_BOOLEAN:
			fieldType = FieldType.BOOLEAN;
			break;
		case IParameterDefn.TYPE_DATE:
			fieldType = FieldType.DATE;
			break;
		case IParameterDefn.TYPE_DATE_TIME:
			fieldType = FieldType.DATETIME;
			break;
		case IParameterDefn.TYPE_TIME:
			fieldType = FieldType.TIME;
			break;
		case IParameterDefn.TYPE_DECIMAL:
		case IParameterDefn.TYPE_INTEGER:
		case IParameterDefn.TYPE_FLOAT:
			fieldType = FieldType.NUMBER;
			break;
		case IParameterDefn.TYPE_STRING:
		case IParameterDefn.TYPE_ANY:
		default:
			fieldType = FieldType.TEXT;
			break;
		}
		return fieldType;
	}
}
