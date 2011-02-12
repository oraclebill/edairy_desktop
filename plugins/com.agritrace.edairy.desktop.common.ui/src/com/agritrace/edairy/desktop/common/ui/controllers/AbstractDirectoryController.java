package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.activator.Activator;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;

/**
 * Extension of SubModuleController which provides some utility methods for standard EDairyDesktop views. The controller
 * expects it will be used with the AbstractDirectoryView component.
 * 
 * @author
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
	 * Context name for Action Type
	 */
	public static final String EDITED_ACTION_TYPE = "actionType";

	/**
	 * Context name for persistence.
	 */
	public static final String PERSISTENCE_DELEGATE = "PERSISTENCE_DELEGATE";

	/**
	 * Context name for selected object
	 */
	public static final String EDITED_OBJECT_ID = "editObject";

	private IRepository<T> myRepo;

	private IActionRidget resetBtnRidget;

	private IActionRidget searchBtnRidget;

	private T selectedEObject;

	private final List<T> tableContents = new ArrayList<T>();
	protected final ISelectionListener selectionListener = new ISelectionListener() {

		@Override
		public void ridgetSelected(SelectionEvent event) {

			itemSelected(event);
		}
	};

	protected ITableRidget table;

	private PersistenceDelegate<T> persistenceDelegate;

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

		// Configured Table ridgets
		configureTableRidget();

		// buttons
		configureButtonsRidget();

		// Set the initial conditions
		resetFilterConditions();

		// Use default conditions to filter
		refreshTableContents();

		getNavigationNode().addSimpleListener(new SimpleNavigationNodeAdapter() {
			@Override
			public void activated(INavigationNode<?> source) {
				refreshTableContents();
			}
		});

		addDefaultAction(getWindowRidget(), searchBtnRidget);
	}

	public IRepository<T> getRepository() {
		return myRepo;
	}

	protected final void setPersistenceDelegate(PersistenceDelegate<T> delegate) {
		persistenceDelegate = delegate;
	}

	protected final PersistenceDelegate<T> getPersistenceDelegate() {
		if (persistenceDelegate == null) {
			persistenceDelegate = new DirectoryPersistenceDelegate<T>(this);
		}
		return persistenceDelegate;
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
		getTableContents().clear();
		getTableContents().addAll(getFilteredResult());
		table.updateFromModel();
	}

	public void setRepository(IRepository<T> myRepo) {
		this.myRepo = myRepo;
	}

	public void setSelectedEObject(T selectedEObject) {
		this.selectedEObject = selectedEObject;
	}

	private void configureFilterRidgetsInternal() {
		searchBtnRidget = getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_SEARCH);
		if (searchBtnRidget != null) {
			searchBtnRidget.addListener(new IActionListener() {
				@Override
				public void callback() {
					handleApplyFilterAction();
				}
			});
		}

		resetBtnRidget = getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_RESET);
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
		configureNewItemButton(getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_NEW_BUTTON));
		configureViewItemButton(getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_VIEW_BUTTON));
	}

	protected void configureViewItemButton(final IActionRidget viewBtnRidget) {
		viewBtnRidget.setEnabled(false);
		viewBtnRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleViewItemAction();
			}
		});
	}

	protected void configureNewItemButton(final IActionRidget newBtnRidget) {
		newBtnRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleNewItemAction();
			}
		});
	}

	abstract protected void configureFilterRidgets();

	protected void configureTableRidget() {
		// Configure Table Widgets
		table = this.getRidget(ITableRidget.class, AbstractDirectoryView.BIND_ID_TABLE);
		table.addSelectionListener(selectionListener);
		table.bindSingleSelectionToModel(this, "selectedEObject");
		table.addDoubleClickListener(new IActionListener() {
			@Override
			public void callback() {
				handleViewItemAction();
			}
		});
		table.bindToModel(new WritableList(getTableContents(), getEntityClass()), getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		table.updateFromModel();
	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
	final protected Class<?> getEntityClass() {
		final EClass eClass = getEClass();
		if (eClass != null) {
			return eClass.getInstanceClass();
		} else {
			return null;
		}
	}

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
	protected abstract RecordDialog<T> getRecordDialog(Shell shell);

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

	protected List<T> getTableContents() {
		return tableContents;
	}

	protected void handleApplyFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		refreshTableContents();
		table.updateFromModel();
	}

	@SuppressWarnings("unchecked")
	protected void handleNewItemAction() {
		final RecordDialog<T> dialog = getRecordDialog(getShell());
		dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_NEW);
		PersistenceDelegate<T> delegate = getPersistenceDelegate();
		if (delegate != null) {
//			delegate.setItem(delegate.createItem());
			delegate.setItem(null);
			dialog.getController().setContext(PERSISTENCE_DELEGATE, delegate);
			int ret = dialog.open();
			if (ret == Dialog.OK) {
				MessageDialog.openInformation(getShell(), "Success", entityDescription(delegate.getItem())
						+ " created successfully!");
			}
		} else {
			dialog.getController().setContext(EDITED_OBJECT_ID, createNewModel());
			final int returnCode = dialog.open();
			if (DialogConstants.ACTION_SAVE == returnCode) {
				log(LogService.LOG_INFO, "------ saving item: " + dialog.getController().getContext(EDITED_OBJECT_ID));
				createEntity((T) dialog.getController().getContext(EDITED_OBJECT_ID));
			} else if (DialogConstants.ACTION_CANCEL == returnCode) {
				;
			} else {
				throw new IllegalStateException("Invalid response from dialog: " + returnCode);
			}
		}
		refreshTableContents();
	}

	@SuppressWarnings("unchecked")
	protected void handleViewItemAction() {
		final RecordDialog<T> dialog = getRecordDialog(getShell());
		final T selectedObject = getSelectedEObject();
		if (selectedObject == null)
			return;

		// TODO: verify this is still necessary
		try {
			getRepository().load(selectedObject);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// use the persistence delegate if it exists, otherwise fallback.
		PersistenceDelegate<T> delegate = getPersistenceDelegate();
		if (delegate != null) {
			delegate.setItem(selectedObject);
			dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_VIEW);
			dialog.getController().setContext(PERSISTENCE_DELEGATE, delegate);
			int ret = dialog.open();
			if (ret == Dialog.OK) {
				MessageDialog.openInformation(getShell(), "Success", entityDescription(delegate.getItem())
						+ " updated successfully!");
			}
		} else {
			dialog.getController().setContext(EDITED_OBJECT_ID, selectedObject);
			final int returnCode = dialog.open();
			if (DialogConstants.ACTION_SAVE == returnCode) {
				final Object contextObj = dialog.getController().getContext(EDITED_OBJECT_ID);
				log(LogService.LOG_DEBUG, "------ handleViewItemAction: updating item: " + contextObj);
				updateEntity((T) contextObj);
			} else if (DialogConstants.ACTION_CANCEL == returnCode) {
				// todo: ensure data sent to dialog is not modified...
				// getRepository().load((T)
				// dialog.getController().getContext(EDITED_OBJECT_ID));
			} else if (DialogConstants.ACTION_DELETE == returnCode) {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Delete Confirmation",
						"Do you want to delete the selected entity ?")) {
					deleteEntity(selectedObject);
				}
			} else {
				throw new IllegalStateException("Invalid response from dialog: " + returnCode);
			}
		}
		refreshTableContents();
	}

	private String entityDescription(EObject entity) {
		String entClassName = entity.eClass().getName();
		String keyName = "";
		for (EAttribute attr : entity.eClass().getEAllAttributes()) {
			EList<EAnnotation> annotations = attr.getEAnnotations();
			if (annotations != null && annotations.size() > 0) {
				for (EAnnotation notation : annotations) {
					if (notation.getSource().equals("teneo.jpa")
							&& notation.getDetails().get("appinfo").equals("@NaturalId")) {
						keyName = (String) entity.eGet(attr);
					}
				}
			}
		}
		return String.format("%s %s", entClassName, keyName);
	}

	protected void updateEntity(T updateableEntity) {
		getRepository().update(updateableEntity);
	}

	protected void deleteEntity(T deletableEntity) {
		getRepository().delete(deletableEntity);
	}

	protected void itemSelected(SelectionEvent event) {
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_VIEW_BUTTON);
		if (event.getNewSelection().isEmpty()) {
			viewBtnRidget.setEnabled(false);

		} else {
			viewBtnRidget.setEnabled(true);
		}
	}

	protected void createEntity(T newEntity) {
		getRepository().saveNew(newEntity);
	}

	protected void handleResetFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		resetFilterConditions();
	}

	/**
	 * Reset conditions
	 */
	abstract protected void resetFilterConditions();

	/**
	 * A utility to get the current display.
	 * 
	 * @return the current display, safe for rcp or non-rcp.
	 */
	public static final Display getDisplay() {
		Display display;
		try {
			display = PlatformUI.getWorkbench().getDisplay();
		} catch (final Exception e) {
			display = Display.getCurrent();
			if (display == null) {
				display = Display.getDefault();
			}
		}
		return display;
	}

	/**
	 * A utility to get the current active shell.
	 * 
	 * @return the current shell, safe for rcp or non-rcp.
	 */
	public static final Shell getShell() {
		return getDisplay().getActiveShell();
	}

	/**
	 * 
	 * @param level
	 * @param message
	 */
	private void log(int level, String message) {
		final org.eclipse.equinox.log.Logger logger = Log4r
				.getLogger(Activator.getDefault(), this.getClass().getName());
		logger.log(level, message);
	}
}
