package com.agritrace.edairy.desktop.common.ui.editingsupport;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Column editor to support table column editing
 * 
 * @author Hui(Spark) Wan
 * 
 */
public interface IColumnEditingSupport {

	/**
	 * Is the cell editable
	 * 
	 * @param element
	 *            the model element
	 * @return true if editable
	 */
	public boolean canEdit(Object element);

	/**
	 * Gets the converter used when updating from the model to the UI-control.
	 * 
	 * @param converter
	 *            new converter model to UI-control
	 */
	public IConverter getModelToUIControlConverter();

	/**
	 * Gets the converter used when updating from the UI-control to the model.
	 * 
	 * @return
	 */
	public IConverter getUIControlToModelConverter();

}
