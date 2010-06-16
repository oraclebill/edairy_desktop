package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
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
public abstract class AbstractDirectoryController<T extends EObject> extends SubModuleController {


	/**
	 * Dialog style which means the dialog is a dialog to create a new record
	 */
	public static final int ACTION_NEW = 1;

	/**
	 * Dialog style which means the dialog is a dialog to view a new record
	 */
	public static final int ACTION_VIEW = 2;

	/**
	 * Context id for Action Type
	 */
	public static final String EDITED_ACTION_TYPE = "actionType";

	/**
	 * Context id for selected object
	 */
	public static final String EDITED_OBJECT_ID = "editObject";

	private IRepository<T> myRepo;

	private IActionRidget resetBtnRidget;

	private IActionRidget searchBtnRidget;

	private T selectedEObject;

	protected final ISelectionListener selectionListener = new ISelectionListener() {

		@Override
		public void ridgetSelected(SelectionEvent event) {

			itemSelected(event);
		}
	};
	protected ITableRidget table;
	protected final List<T> tableContents = new ArrayList<T>();

	/**
	 * Default controller
	 */
	public AbstractDirectoryController() {
		super();
	}

	/**
	 * Controller with sub model node
	 * 
	 * @param navigationNode
	 */
	public AbstractDirectoryController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	@Override
	final public void configureRidgets() {
		// super.configureRidgets();

		// Configure filter ridgets
		configureFilterRidgetsInternal();
		configureFilterRidgets();

		// Set the initial conditions
		resetFilterConditions();

		// Configured Table ridgets
		configureTableRidget();

		// buttons
		configureButtonsRidget();

		// Use default conditions to filter
		refreshTableContents();

	}

	public IRepository<T> getRepository() {
		return myRepo;
	}

	/**
	 * Gets the selectedObject
	 * 
	 * @return
	 */
	public T getSelectedEObject() {
		return this.selectedEObject;
	}

	public void refreshTableContents() {
		tableContents.clear();
		tableContents.addAll(getFilteredResult());
		table.updateFromModel();
	}

	public void setRepository(IRepository<T> myRepo) {
		this.myRepo = myRepo;
	}

	public void setSelectedEObject(T selectedEObject) {
		this.selectedEObject = selectedEObject;
	}

	private void configureFilterRidgetsInternal() {
		searchBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_FILTER_SEARCH);
		if (searchBtnRidget != null) {
			searchBtnRidget.addListener(new IActionListener() {
				@Override
				public void callback() {
					handleApplyFilterAction();					
				}
			});
		}

		resetBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_FILTER_RESET);
		if (resetBtnRidget != null) {
			resetBtnRidget.addListener(new IActionListener() {
				@Override
				public void callback() {
					handleResetFilterAction();					
				}
			});
		}
	}

	protected void configureButtonsRidget() {
		final IActionRidget newBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_NEW);
		newBtnRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleNewItemAction();					
			}
		});
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(false);
		viewBtnRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleViewItemAction();					
			}
		});
	}

	abstract protected void configureFilterRidgets();

	protected void configureTableRidget() {
		// Configure Table Widgets
		table = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
		table.addSelectionListener(selectionListener);
		table.bindSingleSelectionToModel(this, "selectedEObject");
		table.addDoubleClickListener(new IActionListener() {
			@Override
			public void callback() {
				handleViewItemAction();					
			}
		});
		table.bindToModel(new WritableList(tableContents, getEntityClass()), getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		table.updateFromModel();
	}

	/**
	 * Create new model while createing a new record
	 * 
	 * @return
	 */
	protected T createNewModel() {
		return (T) EMFUtil.createObject(getEClass());
	}

	/**
	 * Gets entity class
	 * 
	 * @return
	 */
	protected abstract EClass getEClass();

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
	protected abstract List<T> getFilteredResult();

	/**
	 * 
	 * @param shell
	 * @return
	 */
	protected abstract RecordDialog<T, ?> getRecordDialog(Shell shell);

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
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(true);
	}

	/**
	 * Reset conditions
	 */
	abstract protected void resetFilterConditions();

	protected void handleApplyFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		refreshTableContents();
		table.updateFromModel();
	}
	
	protected void handleResetFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		resetFilterConditions();
	}



	protected void handleNewItemAction() {
		final RecordDialog<T, ?> dialog = getRecordDialog(new Shell());
		dialog.getController().setContext(EDITED_OBJECT_ID, createNewModel());
		dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_NEW);
System.err.println( "opening new item: ");
		final int returnCode = dialog.open();
		if (Window.OK == returnCode) {
			System.err.println( "------ saving item: " + dialog.getController().getContext(EDITED_OBJECT_ID));
			getRepository().saveNew((T) dialog.getController().getContext(EDITED_OBJECT_ID));
		}
		refreshTableContents();
	}

	protected void handleViewItemAction() {
		final RecordDialog<T, ?> dialog = getRecordDialog(new Shell());
		dialog.getController().setContext(EDITED_OBJECT_ID, getSelectedEObject());
		dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_VIEW);
System.err.println( "opening view item: " + getSelectedEObject());

		final int returnCode = dialog.open();
		if (Window.OK == returnCode) {
			System.err.println( "------ updating item: " + dialog.getController().getContext(EDITED_OBJECT_ID));
			getRepository().update((T) dialog.getController().getContext(EDITED_OBJECT_ID));
		}
		refreshTableContents();
	}

}
