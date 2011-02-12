package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.beans.common.TypedComparator;
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
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.activator.Activator;
import com.agritrace.edairy.desktop.common.ui.columnformatters.DatePropertyColumnFormatter;
import com.agritrace.edairy.desktop.common.ui.columnformatters.MemberIDAndNameFormatter;
import com.agritrace.edairy.desktop.common.ui.columnformatters.PersonToFormattedName;
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
public abstract class ViewController<T extends EObject> extends SubModuleController {

	public static class ColumnDescriptor {
		String columnHeader;
		String propertyName;
		boolean sortable;
		boolean movable;
		int columnWidth;
		ColumnFormatter formatter;
		Comparator<?> comparator;
	}

	public interface ViewDataProvider<C> {
		int getColumnCount();

		List<ColumnDescriptor> getColumnDescriptors();

		Class<C> getRowClass();

		List<C> getRowData();
	}

	public static abstract class AbstractViewDataProvider<C> implements ViewDataProvider<C> {

		private Class<C> clazz;
		private List<ColumnDescriptor> columns;
		
		private ColumnFormatter[] colFormatter;
		private Comparator<Object>[] comparators;
		private String[] colHeaders;
		private String[] colProps;
		

		public AbstractViewDataProvider(Class<C> clazz) {
			this.clazz = clazz;
			this.columns = new LinkedList<ColumnDescriptor>();
		}

		@Override
		public Class<C> getRowClass() {
			return clazz;
		}

		@Override
		public int getColumnCount() {
			return columns.size();
		}

		@Override
		public List<ColumnDescriptor> getColumnDescriptors() {
			return Collections.unmodifiableList(columns);
		}

		public ColumnFormatter[] getTableColumnFormatters() {
			checkArrays();
			return colFormatter;
		}
		
		public Comparator<Object>[] getTableColumnComparators() {
			checkArrays();
			return comparators;
		}


		public String[] getTableColumnHeaders() {
			checkArrays();
			return colHeaders;
		}

		public String[] getTableColumnPropertyNames() {
			checkArrays();
			return colProps;
		}

		private void checkArrays() {
			if (colFormatter != null) {
				return;
			}
			
			final int numCols = columns.size();
			colFormatter = new ColumnFormatter[numCols];
			colHeaders = new String[numCols];
			colProps = new String[numCols];
			for (int i = 0; i < numCols; i++) {
				colFormatter[i] = columns.get(i).formatter;
				colHeaders[i] = columns.get(i).columnHeader;
				colProps[i] = columns.get(i).propertyName;
			}
		}
	}

	public interface ViewPersistenceDelegate {

	}

	public static class MemberComparator implements Comparator<Membership> {
		@Override
		public int compare(Membership o1, Membership o2) {
			return o1.getMemberNumber().compareTo(o2.getMemberNumber());
		}
	}

	public static class PersonComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			int cmp = o1.getFamilyName().compareTo(o2.getFamilyName());
			if (cmp == 0) {
				cmp = o1.getGivenName().compareTo(o2.getGivenName());
			}
			return cmp;
		}
	}

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
	 * Context name for selected object
	 */
	public static final String EDITED_OBJECT_ID = "editObject";

	/**
	 * String to use when selection is empty
	 */
	public static final String EMPTY_SELECTION_TEXT = "ANY";

	/******************************************************************/

	private EClass eClass;

	// private IRepository<T> myRepo;

	private IActionRidget resetBtnRidget;

	private IActionRidget searchBtnRidget;

	private T selectedEObject;

	private ITableRidget table;

	private final List<T> tableContents = new ArrayList<T>();
	private final List<Comparator<?>> columnComparators = new ArrayList<Comparator<?>>();
	private final List<ColumnFormatter> columnFormatters = new ArrayList<ColumnFormatter>();
	private final List<String> columnHeaders = new ArrayList<String>();
	private final List<String> columnProperties = new ArrayList<String>();

	private final ISelectionListener selectionListener = new ISelectionListener() {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			itemSelected(event);
		}
	};

	/******************************************************************/

	/**
	 * Default controller
	 */
	public ViewController() {
		super();
	}

	/**
	 * Controller with sub model node
	 * 
	 * @param navigationNode
	 */
	public ViewController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	protected void configureTableRidget() {
		if (getEClass() == null) {
			throw new IllegalStateException("EClass must be set in constructor");
		}
		if (getEntityClass() == null) {
			throw new IllegalStateException("Entity class must be set in constructor");
		}
		table = this.getRidget(ITableRidget.class, AbstractDirectoryView.BIND_ID_TABLE);
		table.addSelectionListener(selectionListener);
		table.bindSingleSelectionToModel(this, "selectedEObject");
		table.addDoubleClickListener(new IActionListener() {
			@Override
			public void callback() {
				handleViewItemAction();
			}
		});

		final ColumnFormatter[] formatters = getTableColumnFormatters();
		final Comparator<Object>[] comparators = getTableColumnComparators();
		for (int i = 0; i < formatters.length; i++) {
			if (formatters[i] != null) {
				table.setColumnFormatter(i, formatters[i]);
			}
			if (comparators[i] != null) {
				table.setComparator(i, comparators[i]);
				table.setColumnSortable(i, true);
			} else {
				table.setColumnSortable(i, false);
			}
		}

		final String[] tableColumnProperties = getTableColumnPropertyNames();
		final String[] tableColumnHeaders = getTableColumnHeaders();
		table.bindToModel(new WritableList(getTableContents(), getEntityClass()), getEntityClass(),
				tableColumnProperties, tableColumnHeaders);

		table.updateFromModel();
	}

	private ColumnFormatter getDefaultFormatter(Class<?> colType, final String propName) {
		ColumnFormatter formatter = null;
		if (colType.isAssignableFrom(Date.class)) {
			formatter = new DatePropertyColumnFormatter(propName);
		} else if (colType.isAssignableFrom(Membership.class)) {
			formatter = new MemberIDAndNameFormatter(propName);
		} else if (colType.isAssignableFrom(Person.class)) {
			formatter = new PersonToFormattedName(propName);
		}
		return formatter;
	}

	protected Comparator<Object>[] getTableColumnComparators() {
		return columnComparators.toArray(new Comparator[columnComparators.size()]);
	}

	final protected ColumnFormatter[] getTableColumnFormatters() {
		final int numCols = columnFormatters.size();
		final ColumnFormatter colFormatter[] = new ColumnFormatter[numCols];
		for (int i = 0; i < numCols; i++) {
			colFormatter[i] = columnFormatters.get(i);
		}
		return colFormatter;
	}

	final protected String[] getTableColumnHeaders() {
		final int numCols = columnHeaders.size();
		final String[] colHeaders = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colHeaders[i] = columnHeaders.get(i);
		}
		return colHeaders;
	}

	final protected String[] getTableColumnPropertyNames() {
		final int numCols = columnProperties.size();
		final String colProps[] = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colProps[i] = columnProperties.get(i);
		}
		return colProps;
	}

	protected void addTableColumn(String colHeader, EStructuralFeature featurePath) {
		addTableColumn(colHeader, featurePath, null);
	}

	protected void addTableColumn(String colHeader, EStructuralFeature feature, ColumnFormatter formatter) {
		addTableColumn(colHeader, feature.getName(), feature.getEType().getInstanceClass(), formatter);
	}

	protected void addTableColumn(String colHeader, String colPropertyName, Class<?> colType) {
		addTableColumn(colHeader, colPropertyName, colType, null);
	}

	protected void addTableColumn(String colHeader, final String colPropertyName, Class<?> colType,
			ColumnFormatter formatter) {
		columnHeaders.add(colHeader);
		columnProperties.add(colPropertyName);
		if (formatter == null) {
			formatter = getDefaultFormatter(colType, colPropertyName);
		}
		columnFormatters.add(formatter);
		if (String.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<String>());
		} else if (Integer.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<Integer>());
		} else if (Date.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<Date>());
		} else if (Person.class.isAssignableFrom(colType)) {
			columnComparators.add(new PersonComparator());
		} else if (Membership.class.isAssignableFrom(colType)) {
			columnComparators.add(new MemberComparator());
		} else {
			columnComparators.add(null);
		}
	}

	protected List<T> getTableContents() {
		return tableContents;
	}

	protected void configureViewActions() {
		IActionRidget actionRidget;

		actionRidget = getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_NEW_BUTTON);
		actionRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleNewItemAction();
			}
		});

		actionRidget = getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_VIEW_BUTTON);
		actionRidget.setEnabled(false);
		actionRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleViewItemAction();
			}
		});

	}

	abstract protected void configureFilter();

	private void configureFilterInternal() {
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

	@Override
	final public void configureRidgets() {
		// super.configureRidgets();

		// Configure filter ridgets
		configureFilterInternal();
		configureFilter();

		// Configured Table ridgets
		configureTableRidget();

		// buttons
		configureViewActions();

		// Set the initial conditions
		resetFilterConditions();

		// Use default conditions to filter
		refreshTableContents();

		getNavigationNode().addSimpleListener(new SimpleNavigationNodeAdapter() {
			@Override
			public void activated(INavigationNode<?> source) {
				refreshTableContents();
			}

			@Override
			public void deactivated(INavigationNode<?> source) {
				System.err.println("Simple Listener - deactivated:" + source);
			}
		});

		addDefaultAction(getWindowRidget(), searchBtnRidget);

	}

	protected void createEntity(T newEntity) {
// TODO: support create new item
// getRepository().saveNew(newEntity);
	}

	protected void deleteEntity(T deletableEntity) {
// TODO: support delete item
// getRepository().delete(deletableEntity);
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

	final protected EClass getEClass() {
		return eClass;
	}

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
	 * Gets the selectedObject
	 * 
	 * @return
	 */
	public T getSelectedEObject() {
		return this.selectedEObject;
	}

	/*
	 * protected void configureTableRidget() { // Configure Table Widgets table = this.getRidget(ITableRidget.class,
	 * AbstractDirectoryView.BIND_ID_TABLE); table.addSelectionListener(selectionListener);
	 * table.bindSingleSelectionToModel(this, "selectedEObject"); table.addDoubleClickListener(new IActionListener() {
	 * 
	 * @Override public void callback() { handleViewItemAction(); } }); table.bindToModel( new
	 * WritableList(getTableContents(), getEntityClass()), getEntityClass(), getTableColumnPropertyNames(),
	 * getTableColumnHeaders());
	 * 
	 * table.updateFromModel(); }
	 */

	protected void handleApplyFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		refreshTableContents();
		table.updateFromModel();
	}

	protected ViewPersistenceDelegate getPersistenceDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void handleResetFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		resetFilterConditions();
	}

	protected void handleNewItemAction() {
		/**
		 * Shell parentShell = PlatformUI.getWorkbench().getDisplay().getActiveShell(); ViewPersistenceDelegate delegate
		 * = getPersistenceDelegate(); EditDialog editor = getEditDialog(parentShell, delegate); if (editor.open() ==
		 * Dialog.OK) { refreshTableContents(); }
		 **/
		final RecordDialog<T> dialog = getRecordDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
		dialog.getController().setContext(EDITED_OBJECT_ID, createNewModel());
		dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_NEW);
		final int returnCode = dialog.open();
		if (DialogConstants.ACTION_SAVE == returnCode) {
			log(LogService.LOG_INFO, "------ saving item: " + dialog.getController().getContext(EDITED_OBJECT_ID));
			createEntity((T) dialog.getController().getContext(EDITED_OBJECT_ID));
		} else if (DialogConstants.ACTION_CANCEL == returnCode) {
			;
		} else {
			throw new IllegalStateException("Invalid response from dialog: " + returnCode);
		}
		refreshTableContents();
	}

	protected void handleViewItemAction() {
		/**
		 * Shell parentShell = PlatformUI.getWorkbench().getDisplay().getActiveShell(); ViewPersistenceDelegate delegate
		 * = getPersistenceDelegate(); delegate.loadEntity(getEClass(), getSelectedItemKey()); delegate.setReadOnly();
		 * EditDialog editor = getEditDialog(parentShell, delegate); if (editor.open() == Dialog.OK &&
		 * delegate.isEntityModified()) { refreshTableContents(); }
		 **/

		final RecordDialog<T> dialog = getRecordDialog(AbstractDirectoryController.getShell());
		final T selectedObject = getSelectedEObject();
		try {
// TODO: support view/edit objects
// getRepository().load(selectedObject);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		dialog.getController().setContext(EDITED_OBJECT_ID, selectedObject);
		dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_VIEW);
		System.err.println("opening view item: " + getSelectedEObject());

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
		refreshTableContents();
	}

	protected void itemSelected(SelectionEvent event) {
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_VIEW_BUTTON);
		if (event.getNewSelection().isEmpty()) {
			viewBtnRidget.setEnabled(false);

		} else {
			viewBtnRidget.setEnabled(true);
		}
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

	public void refreshTableContents() {
		getTableContents().clear();
		getTableContents().addAll(getFilteredResult());
		table.updateFromModel();
	}

	/**
	 * Reset conditions
	 */
	abstract protected void resetFilterConditions();

	protected void setEClass(EClass eClass) {
		this.eClass = eClass;
	}

	public void setSelectedEObject(T selectedEObject) {
		this.selectedEObject = selectedEObject;
	}

	protected void updateEntity(T updateableEntity) {
// TODO: support update
// getRepository().update(updateableEntity);
	}
}
