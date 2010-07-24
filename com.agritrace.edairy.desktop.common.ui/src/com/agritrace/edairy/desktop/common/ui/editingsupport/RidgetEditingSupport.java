package com.agritrace.edairy.desktop.common.ui.editingsupport;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.riena.beans.common.BeanPropertyUtils;
import org.eclipse.swt.widgets.Control;

import com.agritrace.edairy.desktop.common.ui.ridgets.EditableTable;

/**
 * Editing support for table ridget
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class RidgetEditingSupport extends EditingSupport {

	private final IColumnEditingSupport editor;
	private final int index;
	private final String propertyName;
	private final Class<?> rowClass;

	public RidgetEditingSupport(ColumnViewer viewer, IColumnEditingSupport editor, String propertyName, Class<?> rowClass,
			int index) {
		super(viewer);
		this.editor = editor;
		this.propertyName = propertyName;
		this.rowClass = rowClass;
		this.index = index;
	}

	@Override
	protected boolean canEdit(Object element) {
		return editor.canEdit(element);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		final Control control = this.getViewer().getControl();
		if (control instanceof EditableTable) {
			final EditableTable editTable = (EditableTable) control;
			return editTable.getCellEditor(index);
		}
		return null;
	}

	@Override
	protected Object getValue(Object element) {
		PropertyDescriptor descriptor;
		try {
			descriptor = new PropertyDescriptor(this.propertyName, this.rowClass);

			final Object value = BeanPropertyUtils.getPropertyValue(element, descriptor);
			Object convertedValue = value;
			final IConverter converter = editor.getModelToUIControlConverter();
			if (converter != null) {
				convertedValue = converter.convert(value);
			}
			return convertedValue;
		} catch (final IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {

		Object convertedValue = value;
		final IConverter converter = editor.getUIControlToModelConverter();
		if (converter != null) {
			convertedValue = converter.convert(value);
		}
		PropertyDescriptor descriptor;
		try {
			descriptor = new PropertyDescriptor(this.propertyName, this.rowClass);

			BeanPropertyUtils.setPropertyValue(element, descriptor, convertedValue);
			this.getViewer().refresh();
		} catch (final IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
