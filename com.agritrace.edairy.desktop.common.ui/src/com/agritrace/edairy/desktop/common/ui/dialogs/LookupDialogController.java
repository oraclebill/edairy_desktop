package com.agritrace.edairy.desktop.common.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

public abstract class LookupDialogController<T extends EObject> extends
		AbstractWindowController {

	private final List<T> tableContents = new ArrayList<T>();
	private ITableRidget listTable;
	private T selectedObject;

	public LookupDialogController() {
		super();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		// Search Button
		IActionRidget searchAction = null;
//			getRidget(IActionRidget.class,
//				FarmSearchDialog.SEARCH_BUTTON);
		searchAction.addListener(new IActionListener() {

			@Override
			public void callback() {
				refreshTableContents();
				listTable.updateFromModel();
			}
		});

		//
		listTable = getRidget(ITableRidget.class,
				CommonLookupDialog.RESULT_LIST);

	}

	public void refreshTableContents() {
		tableContents.clear();
		tableContents.addAll(getFilteredResult());

	}

	/**
	 * Gets Eclass of row
	 * 
	 * @return
	 */
	protected abstract EClass getEClass();

	protected abstract List<T> getFilteredResult();

	public List<T> getTableContents() {
		return tableContents;
	}

	public void setSelectedObject(T selectedObject) {
		this.selectedObject = selectedObject;
	}

	public T getSelectedObject() {
		return selectedObject;
	}

}
