package com.agritrace.edairy.desktop.common.ui.ridgets;

import org.eclipse.riena.ui.ridgets.ITableRidget;

import com.agritrace.edairy.desktop.common.ui.editingsupport.IColumnEditingSupport;

/**
 *  Editable table viewer ridget
 * 
 * @author Hui(Spark) Wan
 *
 */
public interface IEditableTableRidget extends ITableRidget {

	/**
	 * Sets the column's editing support to let the editor get/set correctly
	 * 
	 * @param index Column Editor
	 * @param columnEditingSupport Support of editing
	 */
	public void setColumnEditingSupport(int index, IColumnEditingSupport columnEditingSupport);

}
