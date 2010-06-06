package com.agritrace.edairy.desktop.common.ui.ridgets;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class EditableTable extends Table {
	private final Map<Integer, CellEditor> cellEditors = new HashMap<Integer, CellEditor>();

	public EditableTable(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void checkSubclass() {
		// do nothing
	}

	/**
	 * Sets the cell editor
	 * 
	 * @param index
	 * @param editor
	 */
	public void setCellEditor(int index, CellEditor editor) {
		cellEditors.put(index, editor);
	}

	/**
	 * Gets the cell editor
	 * 
	 * @param index
	 * @return
	 */
	public CellEditor getCellEditor(int index) {
		return cellEditors.get(index);
	}

}
