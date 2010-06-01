package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
//import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

/**
 * Abstract class of RecordList controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class AbstractRecordListController<T extends EObject> extends SubModuleController {

	/**
	 * Dialog style which means the dialog is a dialog to create a new record
	 */
	public static final int ACTION_NEW = 1;

	/**
	 * Dialog style which means the dialog is a dialog to view a new record
	 */
	public static final int ACTION_VIEW = 2;

	/**
	 * Dialog style which means the dialog is a dialog to view a new record
	 * Currently, view/edit are same
	 */
	public static final int ACTIOn_EDIT = 3;

	/**
	 * Gets entity class
	 * 
	 * @return
	 */
	protected abstract Class<?> getEntityClass();

	/**
	 * Gets entity class
	 * 
	 * @return
	 */
	protected abstract EClass getEClass();

	/**
	 * Gets filter class
	 * 
	 * @return
	 */
	protected abstract List<T> getFilteredResult();

	/**
	 * Gets table column header
	 * 
	 * @return
	 */
	protected abstract String[] getTableColumnHeaders();

	/**
	 * Gets table column property name
	 * 
	 * @return
	 */
	protected abstract String[] getTableColumnPropertyNames();

	protected abstract RecordDialog<T,?> getEditDialog(int dialogStyle, T selectedObj);

	private T selectedEObject;
	// private T container;
	private ITableRidget table;
	private final List<T> tableContents = new ArrayList<T>();

//	private final ISelectionListener selectionListener = new ISelectionListener() {
//
//		@Override
//		public void ridgetSelected(SelectionEvent event) {
//
//			itemSelected(event);
//		}
//	};

	/**
	 * Default controller
	 */
	public AbstractRecordListController() {
		super();
	}

	/**
	 * Controller with submodel node
	 * 
	 * @param navigationNode
	 */
	public AbstractRecordListController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	// public AbstractRecordListController(T container) {
	// super();
	// // this.container = container;
	// }

	// /**
	// * Gets the container
	// *
	// * @return
	// */
	// public T getContainer() {
	// return this.container;
	// }

	/**
	 * Gets the selectedObject
	 * 
	 * @return
	 */
	public T getSelectedEObject() {
		return this.selectedEObject;
	}

	public void setSelectedEObject(T selectedEObject) {
		this.selectedEObject = selectedEObject;
	}

	public void refreshTableContents() {
		tableContents.clear();
		tableContents.addAll(getFilteredResult());
		table.updateFromModel();
	}

	private void configureButtonsRidget() {
		final IActionRidget newBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_NEW);
		if (newBtnRidget != null) {
			newBtnRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					popUpDialog(ACTION_NEW);
				}
			});
		}
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(false);
		if (viewBtnRidget != null) {
			viewBtnRidget.addListener(new IActionListener() {

				@Override
				public void callback() {

					popUpDialog(ACTION_VIEW);
				}
			});
		}

	}

	protected void configureFilterRidgets() {
		// Search Button
		final IActionRidget searchBtnRidget = getRidget(IActionRidget.class,
				AbstractRecordListView.BIND_ID_FILTER_SEARCH);
		if (searchBtnRidget != null) {
			searchBtnRidget.addListener(new IActionListener() {
				@Override
				public void callback() {
					// Rebind the updateFromModel to refresh the tables
					refreshTableContents();
				}
			});
		}
		final IActionRidget resetBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_FILTER_RESET);
		if (resetBtnRidget != null) {
			resetBtnRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					// Rebind the updateFromModel to refresh the tables
					resetFilterCondtions();
				}
			});
		}
		// Set the initial conditions
		resetFilterCondtions();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		// Configure filter ridgets
		configureFilterRidgets();
		// Configured Table ridgets
		configureTableRidget();
		configureButtonsRidget();

	}

	protected void configureTableRidget() {
		// Configure Table Widgets
		table = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
		// table.addSelectionListener(selectionListener);
		table.bindSingleSelectionToModel(this, "selectedEObject");
		table.addDoubleClickListener(new IActionListener() {
			@Override
			public void callback() {
				popUpDialog(ACTION_VIEW);
			}
		});
		table.bindToModel(new WritableList(tableContents, getEntityClass()), getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		table.updateFromModel();
	}

	@SuppressWarnings("unchecked")
	protected void itemSelected(SelectionEvent event) {
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(true);
		// Update working copy
		if ((event.getNewSelection().size() == 1) && (event.getNewSelection().get(0) instanceof EObject)) {
			setSelectedEObject((T) event.getNewSelection().get(0));

		}
	}

	@SuppressWarnings("unchecked")
	private void popUpDialog(int dialogStyle) {
		RecordDialog<T,?> dialog;

		if (dialogStyle == ACTION_NEW)
			dialog = getEditDialog(dialogStyle, (T) EMFUtil.createObject(getEClass()));
		else {
			final T selectedObj = getSelectedEObject();
			if (selectedObj == null)
				return;
			else
				dialog = getEditDialog(dialogStyle, selectedObj);
		}
		if (dialogStyle == ACTION_VIEW) {
			// dialog.setReadOnly(); // TODO:
		}
		dialog.open();
		// if (ret == Window.OK) {
		// table.updateFromModel();
		// }
		refreshTableContents();

	}

	/**
	 * Reset conditions
	 */
	protected void resetFilterCondtions() {
		// Subclass should override this to reset the filter conditions
	}
}
