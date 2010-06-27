/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package com.agritrace.edairy.desktop.common.ui.ridgets;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.databinding.viewers.IViewerObservableList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.internal.ui.ridgets.swt.ColumnUtils;
import org.eclipse.riena.internal.ui.ridgets.swt.OutputAwareValidator;
import org.eclipse.riena.ui.common.ISortableByColumn;
import org.eclipse.riena.ui.core.marker.RowErrorMessageMarker;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IColumnFormatter;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.listener.ClickEvent;
import org.eclipse.riena.ui.ridgets.listener.IClickListener;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTWidgetRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSelectableIndexedRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.ridgets.swt.MarkerSupport;
import org.eclipse.riena.ui.ridgets.swt.SortableComparator;
import org.eclipse.riena.ui.swt.facades.GCFacade;
import org.eclipse.riena.ui.swt.facades.SWTFacade;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;

import com.agritrace.edairy.desktop.common.ui.editingsupport.IColumnEditingSupport;
import com.agritrace.edairy.desktop.common.ui.editingsupport.RidgetEditingSupport;


/**
 * Table ridget supports column editing
 * This class's major codes are from TableRidget
 * But we change the column creation by using creation of TableViewerColumn'
 * TableRidget class uses TableColumn creation directly and doesn't support editing
 * 
 * 
 * @author Hui(Spark) Wan
 *
 */
public class EditableTableRidget extends AbstractSelectableIndexedRidget
		implements IEditableTableRidget, IRidget {

	
	private final Listener itemEraser;
	private final SelectionListener selectionTypeEnforcer;
	private final MouseListener clickForwarder;
	private final MouseTrackListener tooltipManager;
	private final ColumnSortListener sortListener;
	private ListenerList<IClickListener> clickListeners;
	private ListenerList<IActionListener> doubleClickListeners;

	private DataBindingContext dbc;
	/*
	 * Binds the viewer's multiple selection to the multiple selection
	 * observable. This binding has to be disposed when the ridget is set to
	 * output-only, to avoid updating the model. It has to be recreated when the
	 * ridget is set to not-output-only.
	 */
	private Binding viewerMSB;

	private TableViewer viewer;
	private String[] columnHeaders;
	private ColumnLayoutData[] columnWidths;
	/*
	 * Data we received in bindToModel(...). May change without our doing.
	 */
	private IObservableList modelObservables;
	/*
	 * Data the viewer is bound to. It is updated from modelObservables on
	 * updateFromModel().
	 */
	private IObservableList viewerObservables;

	private Class<?> rowClass;
	private String[] renderingMethods;

	private boolean isSortedAscending;
	private int sortedColumn;
	private final Map<Integer, Boolean> sortableColumnsMap;
	private final Map<Integer, Comparator<Object>> comparatorMap;
	private final Map<Integer, IColumnFormatter> formatterMap;
	private final Map<Integer, IColumnEditingSupport> columnEditors;
	private boolean moveableColumns;

	public EditableTableRidget() {
		itemEraser = new TableItemEraser();
		selectionTypeEnforcer = new SelectionTypeEnforcer();
		clickForwarder = new ClickForwarder();
		tooltipManager = new TableTooltipManager();
		sortListener = new ColumnSortListener();
		isSortedAscending = true;
		sortedColumn = -1;
		sortableColumnsMap = new HashMap<Integer, Boolean>();
		comparatorMap = new HashMap<Integer, Comparator<Object>>();
		formatterMap = new HashMap<Integer, IColumnFormatter>();
		columnEditors = new HashMap<Integer, IColumnEditingSupport>();
		addPropertyChangeListener(IMarkableRidget.PROPERTY_OUTPUT_ONLY, new PropertyChangeListener() {
			
			public void propertyChange(PropertyChangeEvent evt) {
				if (isOutputOnly()) {
					disposeMultipleSelectionBinding();
				} else {
					createMultipleSelectionBinding();
				}
			}
		});
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Table.class);
	}

	@Override
	protected void bindUIControl() {
		final Table control = getUIControl();
		if (control != null) {
			viewer = new TableViewer(control);
			configureControl(control);
			if (viewerObservables != null) {
				configureViewer(viewer);
			}

			dbc = new DataBindingContext();
			// viewer to single selection binding
			IObservableValue viewerSelection = ViewersObservables.observeSingleSelection(viewer);
			dbc.bindValue(viewerSelection, getSingleSelectionObservable(), new UpdateValueStrategy(
					UpdateValueStrategy.POLICY_UPDATE).setAfterGetValidator(new OutputAwareValidator(this)),
					new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE));
			// viewer to to multi-selection binding
			viewerMSB = null;
			if (!isOutputOnly()) {
				createMultipleSelectionBinding();
			}

			for (TableColumn column : control.getColumns()) {
				column.addSelectionListener(sortListener);
			}
			control.addSelectionListener(selectionTypeEnforcer);
			control.addMouseListener(clickForwarder);
			SWTFacade facade = SWTFacade.getDefault();
			facade.addMouseTrackListener(control, tooltipManager);
			facade.addEraseItemListener(control, itemEraser);
		}
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (dbc != null) {
			disposeMultipleSelectionBinding();
			dbc.dispose();
			dbc = null;
		}
		Table control = getUIControl();
		if (control != null) {
			for (TableColumn column : control.getColumns()) {
				column.removeSelectionListener(sortListener);
			}
			control.removeSelectionListener(selectionTypeEnforcer);
			control.removeMouseListener(clickForwarder);
			SWTFacade facade = SWTFacade.getDefault();
			facade.removeMouseTrackListener(control, tooltipManager);
			facade.removeEraseItemListener(control, itemEraser);
		}
		viewer = null;
	}

	@Override
	protected java.util.List<?> getRowObservables() {
		return viewerObservables;
	}

	public void addClickListener(IClickListener listener) {
		Assert.isNotNull(listener, "listener is null"); //$NON-NLS-1$
		if (clickListeners == null) {
			clickListeners = new ListenerList<IClickListener>(IClickListener.class);
		}
		clickListeners.add(listener);
	}

	public void addDoubleClickListener(IActionListener listener) {
		Assert.isNotNull(listener, "listener is null"); //$NON-NLS-1$
		if (doubleClickListeners == null) {
			doubleClickListeners = new ListenerList<IActionListener>(IActionListener.class);
		}
		doubleClickListeners.add(listener);
	}

	public void bindToModel(IObservableList rowObservables, Class<? extends Object> aRowClass,
			String[] columnPropertyNames, String[] columnHeaders) {
		if (columnHeaders != null) {
			String msg = "Mismatch between number of columnPropertyNames and columnHeaders"; //$NON-NLS-1$
			Assert.isLegal(columnPropertyNames.length == columnHeaders.length, msg);
		}
		unbindUIControl();

		rowClass = aRowClass;
		modelObservables = rowObservables;
		viewerObservables = null;
		renderingMethods = new String[columnPropertyNames.length];
		System.arraycopy(columnPropertyNames, 0, renderingMethods, 0, renderingMethods.length);

		if (columnHeaders != null) {
			this.columnHeaders = new String[columnHeaders.length];
			System.arraycopy(columnHeaders, 0, this.columnHeaders, 0, this.columnHeaders.length);
		} else {
			this.columnHeaders = null;
		}

		bindUIControl();
	}

	public void bindToModel(Object listHolder, String listPropertyName, Class<? extends Object> rowClass,
			String[] columnPropertyNames, String[] columnHeaders) {
		IObservableList rowValues;
		if (AbstractSWTWidgetRidget.isBean(rowClass)) {
			rowValues = BeansObservables.observeList(listHolder, listPropertyName);
		} else {
			rowValues = PojoObservables.observeList(listHolder, listPropertyName);
		}
		bindToModel(rowValues, rowClass, columnPropertyNames, columnHeaders);
	}

	public IObservableList getObservableList() {
		return viewerObservables;
	}

	public Object getOption(int index) {
		if (getRowObservables() == null || index < 0 || index >= getOptionCount()) {
			throw new IllegalArgumentException("index: " + index); //$NON-NLS-1$
		}
		if (viewer != null) {
			return viewer.getElementAt(index); // sorted
		}
		return getRowObservables().get(index); // unsorted
	}

	public int getSelectionIndex() {
		Table control = getUIControl();
		return control == null ? -1 : control.getSelectionIndex();
	}

	public int[] getSelectionIndices() {
		Table control = getUIControl();
		return control == null ? new int[0] : control.getSelectionIndices();
	}

	public int getSortedColumn() {
		boolean isSorted = sortedColumn != -1 && isColumnSortable(sortedColumn);
		return isSorted ? sortedColumn : -1;
	}

	@Override
	public Table getUIControl() {
		return (Table) super.getUIControl();
	}

	public boolean hasMoveableColumns() {
		return moveableColumns;
	}

	@Override
	public int indexOfOption(Object option) {
		Table control = getUIControl();
		if (control != null) {
			// implies viewer != null
			int optionCount = control.getItemCount();
			for (int i = 0; i < optionCount; i++) {
				if (viewer.getElementAt(i).equals(option)) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean isColumnSortable(int columnIndex) {
		checkColumnRange(columnIndex);
		boolean result = false;
		Integer key = Integer.valueOf(columnIndex);
		Boolean sortable = sortableColumnsMap.get(columnIndex);
		if (sortable == null || Boolean.TRUE.equals(sortable)) {
			result = comparatorMap.get(key) != null;
		}
		return result;
	}

	/**
	 * Always returns true because mandatory markers do not make sense for this
	 * ridget.
	 */
	@Override
	public boolean isDisableMandatoryMarker() {
		return true;
	}

	public boolean isSortedAscending() {
		return getSortedColumn() != -1 && isSortedAscending;
	}

	public void refresh(Object node) {
		if (viewer != null) {
			viewer.refresh(node, true);
		}
	}

	public void removeDoubleClickListener(IActionListener listener) {
		if (doubleClickListeners != null) {
			doubleClickListeners.remove(listener);
		}
	}

	public void removeClickListener(IClickListener listener) {
		if (clickListeners != null) {
			clickListeners.remove(listener);
		}
	}

	public void setColumnFormatter(int columnIndex, IColumnFormatter formatter) {
		checkColumnRange(columnIndex);
		if (formatter != null) {
			Assert.isLegal(formatter instanceof ColumnFormatter, "formatter must sublass ColumnFormatter"); //$NON-NLS-1$
		}
		Integer key = Integer.valueOf(columnIndex);
		formatterMap.put(key, formatter);
	}

	public void setColumnSortable(int columnIndex, boolean sortable) {
		checkColumnRange(columnIndex);
		Integer key = Integer.valueOf(columnIndex);
		Boolean newValue = Boolean.valueOf(sortable);
		Boolean oldValue = sortableColumnsMap.put(key, newValue);
		if (oldValue == null) {
			oldValue = Boolean.TRUE;
		}
		if (!newValue.equals(oldValue)) {
			firePropertyChange(ISortableByColumn.PROPERTY_COLUMN_SORTABILITY, null, columnIndex);
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Implementation note: if the array is non-null, its elements must be
	 * {@link ColumnPixelData} or {@link ColumnWeightData} instances.
	 * 
	 * @throws RuntimeException
	 *             if an unsupported array element is encountered
	 */
	public void setColumnWidths(Object[] widths) {
		columnWidths = ColumnUtils.copyWidths(widths);
		Table control = getUIControl();
		if (control != null) {
			applyColumnWidths(control);
		}
	}

	public void setComparator(int columnIndex, Comparator<Object> compi) {
		checkColumnRange(columnIndex);
		Integer key = Integer.valueOf(columnIndex);
		if (compi != null) {
			comparatorMap.put(key, compi);
		} else {
			comparatorMap.remove(key);
		}
		if (columnIndex == sortedColumn) {
			applyComparator();
		}
	}

	public void setMoveableColumns(boolean moveableColumns) {
		if (this.moveableColumns != moveableColumns) {
			this.moveableColumns = moveableColumns;
			Table control = getUIControl();
			if (control != null) {
				applyColumnsMoveable(control);
			}
		}
	}

	public void setSortedAscending(boolean ascending) {
		if (isSortedAscending != ascending) {
			boolean oldSortedAscending = isSortedAscending;
			isSortedAscending = ascending;
			applyComparator();
			firePropertyChange(ISortableByColumn.PROPERTY_SORT_ASCENDING, oldSortedAscending, isSortedAscending);
		}
	}

	public void setSortedColumn(int columnIndex) {
		if (columnIndex != -1) {
			checkColumnRange(columnIndex);
		}
		if (sortedColumn != columnIndex) {
			int oldSortedColumn = sortedColumn;
			sortedColumn = columnIndex;
			applyComparator();
			firePropertyChange(ISortableByColumn.PROPERTY_SORTED_COLUMN, oldSortedColumn, sortedColumn);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateFromModel() {
		super.updateFromModel();
		if (modelObservables != null) {
			List<Object> copy = new ArrayList<Object>(modelObservables);
			viewerObservables = new WritableList(copy, rowClass);
		}
		if (viewer != null) {
			if (!isViewerConfigured()) {
				configureControl(viewer.getTable());
				configureViewer(viewer);
				refreshViewer(viewer);
				this.viewer.refresh();
			} else {
				refreshViewer(viewer);
				this.viewer.refresh();
			}
		} else {
			refreshSelection();
		}
	}
	
	private void applyColumns(Table control) {
		final int expectedCols = renderingMethods.length;
		if (control.getColumnCount() != expectedCols) {
			for (TableColumn column : control.getColumns()) {
				column.dispose();
			}
			for (int i = 0; i < expectedCols; i++) {
				TableViewerColumn column = new TableViewerColumn(viewer,
						SWT.NONE);
				if (this.columnEditors.get(i) != null) {
					column.setEditingSupport(new RidgetEditingSupport(this.viewer, this.columnEditors.get(i),
							renderingMethods[i], this.rowClass, i));
				}
			}
			
			
			applyColumnWidths(control);
		}
	}

	private void applyColumnWidths(Table control) {
		ColumnUtils.applyColumnWidths(control, columnWidths);
	}

	private void applyColumnsMoveable(Table control) {
		for (TableColumn column : control.getColumns()) {
			column.setMoveable(moveableColumns);
		}
	}

	private void applyComparator() {
		if (viewer != null) {
			Table table = viewer.getTable();
			Comparator<Object> compi = null;
			if (sortedColumn != -1) {
				Integer key = Integer.valueOf(sortedColumn);
				compi = comparatorMap.get(key);
			}
			if (compi != null) {
				TableColumn column = table.getColumn(sortedColumn);
				table.setSortColumn(column);
				int direction = isSortedAscending ? SWT.UP : SWT.DOWN;
				table.setSortDirection(direction);
				SortableComparator sortableComparator = new SortableComparator(this, compi);
				viewer.setComparator(new TableComparator(sortableComparator));
			} else {
				viewer.setComparator(null);
				table.setSortColumn(null);
				table.setSortDirection(SWT.NONE);
			}
		}
	}

	private void applyTableColumnHeaders(Table control) {
		boolean headersVisible = columnHeaders != null;
		control.setHeaderVisible(headersVisible);
		if (headersVisible) {
			TableColumn[] columns = control.getColumns();
			for (int i = 0; i < columns.length; i++) {
				String columnHeader = ""; //$NON-NLS-1$
				if (i < columnHeaders.length && columnHeaders[i] != null) {
					columnHeader = columnHeaders[i];
				}
				columns[i].setText(columnHeader);
			}
		}
	}

	private void checkColumnRange(int columnIndex) {
		Table table = getUIControl();
		if (table != null) {
			int range = table.getColumnCount();
			String msg = "columnIndex out of range (0 - " + range + " ): " + columnIndex; //$NON-NLS-1$ //$NON-NLS-2$
			Assert.isLegal(-1 < columnIndex, msg);
			Assert.isLegal(columnIndex < range, msg);
		}
	}

	private void createMultipleSelectionBinding() {
		if (viewerMSB == null && dbc != null && viewer != null) {
			StructuredSelection currentSelection = new StructuredSelection(getSelection());
			IViewerObservableList viewerSelections = ViewersObservables.observeMultiSelection(viewer);
			viewerMSB = dbc.bindList(viewerSelections, getMultiSelectionObservable(), new UpdateListStrategy(
					UpdateListStrategy.POLICY_UPDATE), new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE));
			viewer.setSelection(currentSelection);
		}
	}

	private void configureControl(Table control) {
		if (renderingMethods != null) {
			applyColumns(control);
		}
		applyColumnsMoveable(control);
		applyTableColumnHeaders(control);
		applyComparator();
	}
	
	private void configureViewer(TableViewer viewer) {
		ObservableListContentProvider viewerCP = new ObservableListContentProvider();
		IObservableMap[] attrMap;
		if (AbstractSWTWidgetRidget.isBean(rowClass)) {
			attrMap = BeansObservables.observeMaps(viewerCP.getKnownElements(), rowClass, renderingMethods);
		} else {
			attrMap = PojoObservables.observeMaps(viewerCP.getKnownElements(), rowClass, renderingMethods);
		}
		IColumnFormatter[] formatters = getColumnFormatters(attrMap.length);
		viewer.setLabelProvider(new EditableTableRidgetLabelProvider(attrMap, formatters));
		viewer.setContentProvider(viewerCP);
		viewer.setInput(viewerObservables);
	}

	private void disposeMultipleSelectionBinding() {
		if (viewerMSB != null) { // implies dbc != null
			viewerMSB.dispose();
			dbc.removeBinding(viewerMSB);
			viewerMSB = null;
		}
	}

	private IColumnFormatter[] getColumnFormatters(int numColumns) {
		Assert.isLegal(numColumns >= 0);
		IColumnFormatter[] result = new IColumnFormatter[numColumns];
		for (int i = 0; i < numColumns; i++) {
			IColumnFormatter columnFormatter = formatterMap.get(Integer.valueOf(i));
			if (columnFormatter != null) {
				result[i] = columnFormatter;
			}
		}
		return result;
	}

	private boolean isViewerConfigured() {
		return viewer.getLabelProvider() instanceof EditableTableRidgetLabelProvider;
	}

	private void refreshViewer(TableViewer viewer) {
		viewer.getControl().setRedraw(false); // prevent flicker during update
		StructuredSelection currentSelection = new StructuredSelection(getSelection());
		try {
			EditableTableRidgetLabelProvider labelProvider = (EditableTableRidgetLabelProvider) viewer.getLabelProvider();
			IColumnFormatter[] formatters = getColumnFormatters(labelProvider.getColumnCount());
			labelProvider.setFormatters(formatters);
			viewer.setInput(viewerObservables);
		} finally {
			viewer.setSelection(currentSelection);
			viewer.getControl().setRedraw(true);
		}
	}

	// helping classes
	// ////////////////

	/**
	 * Enforces selection in the control:
	 * <ul>
	 * <li>disallows selection changes when the ridget is "output only"</li>
	 * <li>disallows multiple selection is the selection type of the ridget is
	 * {@link ISelectableRidget.SelectionType#SINGLE}</li>
	 * </ul>
	 */
	private final class SelectionTypeEnforcer extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (isOutputOnly()) {
				// undo user selection when "output only"
				viewer.setSelection(new StructuredSelection(getSelection()));
			} else if (SelectionType.SINGLE.equals(getSelectionType())) {
				Table control = (Table) e.widget;
				if (control.getSelectionCount() > 1) {
					// ignore this event
					e.doit = false;
					// set selection to most recent item
					control.setSelection(control.getSelectionIndex());
					// fire event
					Event event = new Event();
					event.type = SWT.Selection;
					event.doit = true;
					control.notifyListeners(SWT.Selection, event);
				}
			}
		}
	}

	/**
	 * Erase listener for custom painting of table cells. It is responsible
	 * for:[
	 * <ul>
	 * <li>erasing (emptying) all cells when this ridget is disabled and
	 * {@link LnfKeyConstants#DISABLED_MARKER_HIDE_CONTENT} is true</li>
	 * <li>drawing a red border around cells that have been marked with a
	 * {@link RowErrorMessageMarker} (unless disabled)</li>
	 * </ul>
	 * 
	 * @see '<a href="http://www.eclipse.org/articles/article.php?file=Article-CustomDrawingTableAndTreeItems/index.html"
	 *      >Custom Drawing Table and Tree Items</a>'
	 */
	private final class TableItemEraser implements Listener {

		private final GCFacade gcFacade;
		private final Color borderColor;

		public TableItemEraser() {
			gcFacade = GCFacade.getDefault();
			borderColor = LnfManager.getLnf().getColor(LnfKeyConstants.ERROR_MARKER_BORDER_COLOR);
		}

		/*
		 * Called EXTREMELY frequently. Must be as efficient as possible.
		 */
		public void handleEvent(Event event) {
			if (isHidingWhenDisabled()) {
				hideContent(event);
			} else {
				if (isMarked(event.item)) {
					markRow(event);
				}
			}
		}

		// helping methods
		//////////////////

		private void hideContent(Event event) {
			// we indicate custom fg drawing, but don't draw foreground => hide
			event.detail &= ~SWT.FOREGROUND;
		}

		private boolean isHidingWhenDisabled() {
			return !isEnabled() && MarkerSupport.isHideDisabledRidgetContent();
		}

		private boolean isMarked(Widget item) {
			Object data = item.getData();
			Collection<RowErrorMessageMarker> markers = getMarkersOfType(RowErrorMessageMarker.class);
			for (RowErrorMessageMarker marker : markers) {
				if (marker.getRowValue() == data) {
					return true;
				}
			}
			return false;
		}

		private void markRow(Event event) {
			GC gc = event.gc;
			Color oldForeground = gc.getForeground();
			gc.setForeground(borderColor);
			try {
				Table table = (Table) event.widget;
				int colCount = table.getColumnCount();
				if (colCount > 0) {
					TableItem item = (TableItem) event.item;
					int x = 0, y = 0, width = 0, height = 0;
					for (int i = 0; i < colCount; i++) {
						Rectangle bounds = item.getBounds(i);
						if (i == 0) {
							// start 3px to the left of first column
							x = bounds.x - 3;
							y = bounds.y;
							width += 3;
						}
						width += bounds.width;
						height = Math.max(height, bounds.height);
					}
					width = Math.max(0, width - 1);
					height = Math.max(0, height - 1);
					gcFacade.drawRoundRectangle(gc, x, y, width, height, 3, 3);
				} else {
					int width = Math.max(0, event.width - 1);
					int height = Math.max(0, event.height - 1);
					gcFacade.drawRoundRectangle(gc, event.x, event.y, width, height, 3, 3);
				}
			} finally {
				gc.setForeground(oldForeground);
			}
		}
	}

	/**
	 * Shows the appropriate tooltip (error tooltip / regular tooltip / no
	 * tooltip) for the current hovered row.
	 */
	private final class TableTooltipManager extends MouseTrackAdapter {

		private boolean restore;
		private String savedToolTip;

		@Override
		public void mouseExit(MouseEvent event) {
			Table table = (Table) event.widget;
			restoreToolTip(table);
		}

		@Override
		public void mouseHover(MouseEvent event) {
			Table table = (Table) event.widget;
			TableItem item = table.getItem(new Point(event.x, event.y));
			String errorToolTip = getErrorToolTip(item);
			if (errorToolTip != null && errorToolTip.length() > 0) {
				saveToolTip(table);
				table.setToolTipText(errorToolTip);
			} else {
				restoreToolTip(table);
			}
		}

		// helping methods
		//////////////////

		private String getErrorToolTip(TableItem item) {
			if (item != null) {
				Object data = item.getData();
				Collection<RowErrorMessageMarker> markers = getMarkersOfType(RowErrorMessageMarker.class);
				for (RowErrorMessageMarker marker : markers) {
					if (marker.getRowValue() == data) {
						return marker.getMessage();
					}
				}
			}
			return null;
		}

		private void restoreToolTip(Table table) {
			if (restore) {
				table.setToolTipText(savedToolTip);
				savedToolTip = null;
				restore = false;
			}
		}

		private void saveToolTip(Table table) {
			if (!restore) {
				restore = true;
				savedToolTip = table.getToolTipText();
			}
		}
	}

	/**
	 * Notifies single- and double-click listeners when the bound widget is
	 * clicked.
	 */
	private final class ClickForwarder extends MouseAdapter {

		@Override
		public void mouseDown(MouseEvent e) {
			if (clickListeners != null) {
				ClickEvent event = createClickEvent(e);
				for (IClickListener listener : clickListeners.getListeners()) {
					listener.callback(event);
				}
			}
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			if (doubleClickListeners != null) {
				for (IActionListener listener : doubleClickListeners.getListeners()) {
					listener.callback();
				}
			}
		}

		// helping methods
		//////////////////

		private ClickEvent createClickEvent(MouseEvent e) {
			Table table = (Table) e.widget;
			int colIndex = findColumn(table, new Point(e.x, e.y));
			// x = 0 gets us an item even not using SWT.FULL_SELECTION
			TableItem item = table.getItem(new Point(0, e.y));
			Object rowData = item != null ? item.getData() : null;
			ClickEvent event = new ClickEvent(colIndex, e.button, rowData);
			return event;
		}

		/**
		 * Returns the 0 based index of the column at {@code pt}. The code can
		 * handle re-ordered columns. The index refers to the original ordering
		 * (as used by SWT API).
		 * <p>
		 * Will return -1 if no column could be computed -- this is the case
		 * when all columns are resized to have width 0.
		 */
		private int findColumn(Table table, Point pt) {
			int width = 0;
			int[] colOrder = table.getColumnOrder();
			// compute the current column ordering
			TableColumn[] columns = new TableColumn[colOrder.length];
			for (int i = 0; i < colOrder.length; i++) {
				int idx = colOrder[i];
				columns[i] = table.getColumn(idx);
			}
			// find the column under Point pt\
			for (TableColumn col : columns) {
				int colWidth = col.getWidth();
				if (width < pt.x && pt.x < width + colWidth) {
					return table.indexOf(col);
				}
				width += colWidth;
			}
			return -1;
		}
	}

	/**
	 * Selection listener for table headers that changes the sort order of a
	 * column according to the information stored in the ridget.
	 */
	private final class ColumnSortListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			TableColumn column = (TableColumn) e.widget;
			int columnIndex = column.getParent().indexOf(column);
			int direction = column.getParent().getSortDirection();
			if (columnIndex == sortedColumn) {
				if (direction == SWT.UP) {
					setSortedAscending(false);
				} else if (direction == SWT.DOWN) {
					setSortedColumn(-1);
				}
			} else if (isColumnSortable(columnIndex)) {
				setSortedColumn(columnIndex);
				if (direction == SWT.NONE) {
					setSortedAscending(true);
				}
			}
			column.getParent().showSelection();
		}
	}

	


	@Override
	public void setColumnEditingSupport(int columnIndex, IColumnEditingSupport columnEditor) {
		checkColumnRange(columnIndex);
		Integer key = Integer.valueOf(columnIndex);
		columnEditors.put(key, columnEditor);
		
	}

}
