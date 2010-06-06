package com.agritrace.edairy.desktop.common.ui.editingsupport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;

import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;

public class ContactMethodTypeEditingSupport extends EditingSupport {

	public ContactMethodTypeEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		ComboBoxCellEditor editor = new ComboBoxCellEditor();
		List<String> items = new ArrayList<String>();
		for (ContactMethodType type : ContactMethodType.VALUES) {
			items.add(type.toString());
		}
		editor.setItems((String[]) items.toArray());
		return editor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub

	}

}
