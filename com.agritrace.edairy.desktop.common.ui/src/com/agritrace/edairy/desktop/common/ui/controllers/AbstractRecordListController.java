package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

/**
 * Abstract class of RecordList controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class AbstractRecordListController extends SubModuleController {


	private EObject selectedEObject;
	private EObject container;
	private ISelectionListener selectionListener = new ISelectionListener() {

		@Override
		public void ridgetSelected(SelectionEvent event) {

			itemSelected(event);
		}
	};

	public AbstractRecordListController() {
		super();
	}

	public AbstractRecordListController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	public AbstractRecordListController(EObject container) {
		super();
		this.container = container;
	}

	public EObject getContainer() {
		return this.container;
	}

	public EObject getSelectedEObject() {
		return this.selectedEObject;
	}

	public void setSelectedEObject(EObject selectedEObject) {
		this.selectedEObject = selectedEObject;
	}

	private void configureButtonsRidget() {
		IActionRidget newBtnRidget = getRidget(IActionRidget.class,
				AbstractRecordListView.BIND_ID_NEW);
		if (newBtnRidget != null) {
			newBtnRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					popUpDialog(RecordDialog.DIALOG_STYLE_NEW);
				}
			});
		}
		IActionRidget viewBtnRidget = getRidget(IActionRidget.class,
				AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(false);
		if (viewBtnRidget != null) {
			viewBtnRidget.addListener(new IActionListener() {

				@Override
				public void callback() {

					popUpDialog(RecordDialog.DIALOG_STYLE_VIEW);
				}
			});
		}

	}

	protected void configureFilterRidgets() {
		// Search Button
		IActionRidget searchBtnRidget = getRidget(IActionRidget.class,
				AbstractRecordListView.BIND_ID_FILTER_SEARCH);
		if (searchBtnRidget != null) {
			searchBtnRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					// Rebind the updateFromModel to refresh the tables
					configureTableRidget();
				}
			});
		}
		IActionRidget resetBtnRidget = getRidget(IActionRidget.class,
				AbstractRecordListView.BIND_ID_FILTER_RESET);
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
		ITableRidget tableRidget = this.getRidget(ITableRidget.class,
				AbstractRecordListView.BIND_ID_TABLE);
		tableRidget.addSelectionListener(selectionListener);
		tableRidget.addDoubleClickListener(new IActionListener() {

			@Override
			public void callback() {
				popUpDialog(RecordDialog.DIALOG_STYLE_VIEW);

			}
		});
		WritableList input = new WritableList(getFilteredResult(),
				getEntityClass());
		tableRidget.bindToModel(input, getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		tableRidget.updateFromModel();

	}

	/**
	 * Gets entity class
	 * 
	 * @return
	 */
	protected abstract Class<?> getEntityClass();

	/**
	 * Gets filter class
	 * 
	 * @return
	 */
	protected abstract List<?> getFilteredResult();

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

	protected void itemSelected(SelectionEvent event) {
		IActionRidget viewBtnRidget = getRidget(IActionRidget.class,
				AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(true);
		// Update working copy
		if (event.getNewSelection().size() == 1
				&& event.getNewSelection().get(0) instanceof EObject) {
			setSelectedEObject((EObject) event.getNewSelection().get(0));

		}
	}


	private void popUpDialog(int dialogStyle) {
		RecordDialog dialog = getListDialog(dialogStyle);
		int ret = dialog.open();
		if (ret == Window.OK) {
			ITableRidget tableRidget = getRidget(ITableRidget.class,
					AbstractRecordListView.BIND_ID_TABLE);
			tableRidget.updateFromModel();
		}

	}

	protected abstract RecordDialog getListDialog(int dialogStyle);

	/**
	 * Reset conditions
	 */
	protected void resetFilterCondtions() {
		// Subclass should override this to reset the filter conditions
	}
}
