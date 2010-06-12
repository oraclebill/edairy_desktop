package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.internal.ui.ridgets.swt.ShellRidget;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
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
	public static final int ACTION_EDIT = 3;
	
	
	/**
	 * Context id for selected object
	 */
	public static final String EDITED_OBJECT_ID = "editObject";
	
	/**
	 * Context id for Action Type
	 */
	public static final String EDITED_ACTION_TYPE = "actionType";

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

	protected abstract RecordDialog<T,?> getRecordDialog(Shell shell);

	private T selectedEObject;
	private ITableRidget table;
	private final List<T> tableContents = new ArrayList<T>();

	private IRepository<T> myRepo;
	
	private final ISelectionListener selectionListener = new ISelectionListener() {

		@Override
		public void ridgetSelected(SelectionEvent event) {

			itemSelected(event);
		}
	};
	
	private ViewItemAction viewAction = new ViewItemAction();

	/**
	 * Default controller
	 */
	public AbstractRecordListController() {
		super();
	}

	/**
	 * Controller with sub model node
	 * 
	 * @param navigationNode
	 */
	public AbstractRecordListController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

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
		
	}
	
	protected void configureButtonsRidget() {
		final IActionRidget newBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_NEW);
		newBtnRidget.addListener(new NewItemAction());
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(false);
		viewBtnRidget.addListener(viewAction);
	}
	
	private final class ViewItemAction implements IActionListener {
		@Override
		public void callback() {
			ShellRidget shell = getRidget(ShellRidget.class, AbstractRecordListView.BIND_ID_SHELL);
			RecordDialog<T,?> dialog = getRecordDialog(new Shell());
			dialog.getController().setContext(EDITED_OBJECT_ID, getSelectedEObject());
			dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_VIEW);

			int returnCode = dialog.open();
			if (Window.OK == returnCode) {
				getRepository().update((T)dialog.getController().getContext(EDITED_OBJECT_ID));
			}
			refreshTableContents();
			table.updateFromModel();
		}
	}

	private final class NewItemAction implements IActionListener {
		@Override
		public void callback() {
			//ShellRidget shell = getRidget(ShellRidget.class, AbstractRecordListView.BIND_ID_SHELL);
			RecordDialog<T, ?> dialog = getRecordDialog(Display.getCurrent().getActiveShell());
			dialog.getController().setContext(EDITED_OBJECT_ID,
					createNewModel());
			dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_NEW);

			int returnCode = dialog.open();
			if (Window.OK == returnCode) {
				getRepository().saveNew((T)dialog.getController().getContext(EDITED_OBJECT_ID));
			}
			refreshTableContents();
			table.updateFromModel();
		}
	}

	public IRepository<T> getRepository() {
		return myRepo;
	}
	
	public void setRepository(IRepository<T> myRepo) {
		this.myRepo = myRepo;
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
					table.updateFromModel();
				}
			});
		}
		final IActionRidget resetBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_FILTER_RESET);
//		if (resetBtnRidget != null) {
//			resetBtnRidget.addListener(new IActionListener() {
//
//				@Override
//				public void callback() {
//					// Rebind the updateFromModel to refresh the tables
//					resetFilterCondtions();
//				}
//			});
//		}
		// Set the initial conditions
		resetFilterCondtions();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		
		// Configured Table ridgets
		configureTableRidget();
		
		// Configure filter ridgets
		configureFilterRidgets();
		
		// Use default conditions to filter
		refreshTableContents();
		
		// buttons
		configureButtonsRidget();

	}

	//abstract protected void configureTableRidget();
	
	protected void configureTableRidget() {
		// Configure Table Widgets
		table = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
		table.addSelectionListener(selectionListener);
		table.bindSingleSelectionToModel(this, "selectedEObject");
		table.addDoubleClickListener(viewAction);
		table.bindToModel(new WritableList(tableContents, getEntityClass()), getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		table.updateFromModel();
	}

	protected void itemSelected(SelectionEvent event) {
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(true);
	}
		
	/**
	 * Create new model while createing a new record
	 * @return
	 */
	protected T createNewModel() {
		return (T) EMFUtil.createObject(getEClass());
	}

	/**
	 * Reset conditions
	 */
	protected void resetFilterCondtions() {
		// Subclass should override this to reset the filter conditions
	}
}
