package com.agritrace.edairy.desktop.common.ui.editingsupport;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Column editing support
 * 
 * @author Hui(Spark) Wan
 *
 */
public class ColumnEditingSupport implements IColumnEditingSupport {

	public boolean canEdit(Object element) {
		return true;
	}

	@Override
	public IConverter getModelToUIControlConverter() {
		return null;
	}

	@Override
	public IConverter getUIControlToModelConverter() {
		return null;
	}

}
