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
 * Table ridget supports column editing This class's major codes are from
 * TableRidget But we change the column creation by using creation of
 * TableViewerColumn' TableRidget class uses TableColumn creation directly and
 * doesn't support editing
 * 
 * 
 * @author Hui(Spark) Wan
 * 
 */
@SuppressWarnings("restriction")
public class EditableTableRidget extends AbstractSelectableIndexedRidget implements IEditableTableRidget, IRidget {

	/**
	 * Notifies single- and double-click listeners when the bound widget is
	 * clicked.
	 */
	private final class ClickForwarder extends MouseAdapter {

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			if (doubleClickListeners != null) {
				for (final IActionListener listener : doubleClickListeners.getListeners()) {
					listener.callback();
				}
			}
		}

		@Override
		public void mouseDown(MouseEvent e) {
			if (clickListeners != null) {
				final ClickEvent event = createClickEvent(e);
				for (final IClickListener listener : clickListeners.getListeners()) {
					listener.callback(event);
				}
			}
		}

		// helping methods
		// ////////////////

		private ClickEvent createClickEvent(MouseEvent e) {
			final Table table = (Table) e.widget;
			final int colIndex = findColumn(table, new Point(e.x, e.y));
			// x = 0 gets us an item even not using SWT.FULL_SELECTION
			final TableItem item = table.getItem(new Point(0, e.y));
			final Object rowData = item != null ? item.getData() : null;
			final ClickEvent event = new ClickEvent(colIndex, e.button, rowData);
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
			final int[] colOrder = table.getColumnOrder();
			// compute the current column ordering
			final TableColumn[] columns = new TableColumn[colOrder.length];
			for (int i = 0; i < colOrder.length; i++) {
				final int idx = colOrder[i];
				columns[i] = table.getColumn(idx);
			}
			// find the column under Point pt\
			for (final TableColumn col : columns) {
				final int colWidth = col.getWidth();
				if ((width < pt.x) && (pt.x < width + colWidth)) {
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
			final TableColumn column = (TableColumn) e.widget;
			final int columnIndex = column.getParent().indexOf(column);
			final int direction = column.getParent().getSortDirection();
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
				final Table control = (Table) e.widget;
				if (control.getSelectionCount() > 1) {
					// ignore this event
					e.doit = false;
					// set selection to most recent item
					control.setSelection(control.getSelectionIndex());
					// fire event
					final Event event = new Event();
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
	 * @see '<a href=
	 *      "http://www.eclipse.org/articles/article.php?file=Article-CustomDrawingTableAndTreeItems/index.html"
	 *      >Custom Drawing Table and Tree Items</a>'
	 */
	private final class TableItemEraser implements Listener {

		private final Color borderColor;
		private final GCFacade gcFacade;

		public TableItemEraser() {
			gcFacade = GCFacade.getDefault();
			borderColor = LnfManager.getLnf().getColor(LnfKeyConstants.ERROR_MARKER_BORDER_COLOR);
		}

		/*
		 * Called EXTREMELY frequently. Must be as efficient as possible.
		 */
		@Override
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
		// ////////////////

		private void hideContent(Event event) {
			// we indicate custom fg drawing, but don't draw foreground => hide
			event.detail &= ~SWT.FOREGROUND;
		}

		private boolean isHidingWhenDisabled() {
			return !isEnabled() && MarkerSupport.isHideDisabledRidgetContent();
		}

		private boolean isMarked(Widget item) {
			final Object data = item.getData();
			final Collection<RowErrorMessageMarker> markers = getMarkersOfType(RowErrorMessageMarker.class);
			for (final RowErrorMessageMarker marker : markers) {
				if (marker.getRowValue() == data) {
					return true;
				}
			}
			return false;
		}

		private void markRow(Event event) {
			final GC gc = event.gc;
			final Color oldForeground = gc.getForeground();
			gc.setForeground(borderColor);
			try {
				final Table table = (Table) event.widget;
				final int colCount = table.getColumnCount();
				if (colCount > 0) {
					final TableItem item = (TableItem) event.item;
					int x = 0, y = 0, width = 0, height = 0;
					for (int i = 0; i < colCount; i++) {
						final Rectangle bounds = item.getBounds(i);
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
					final int width = Math.max(0, event.width - 1);
					final int height = Math.max(0, event.height - 1);
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
			final Table table = (Table) event.widget;
			restoreToolTip(table);
		}

		@Override
		public void mouseHover(MouseEvent event) {
			final Table table = (Table) event.widget;
			final TableItem item = table.getItem(new Point(event.x, event.y));
			final String errorToolTip = getErrorToolTip(item);
			if ((errorToolTip != null) && (errorToolTip.length() > 0)) {
				saveToolTip(table);
				table.setToolTipText(errorToolTip);
			} else {
				restoreToolTip(table);
			}
		}

		// helping methods
		// ////////////////

		private String getErrorToolTip(TableItem item) {
			if (item != null) {
				final Object data = item.getData();
				final Collection<RowErrorMessageMarker> markers = getMarkersOfType(RowErrorMessageMarker.class);
				for (final RowErrorMessageMarker marker : markers) {
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

	private final MouseListener clickForwarder;
	private ListenerList<IClickListener> clickListeners;

	private final Map<Integer, IColumnEditingSupport> columnEditors;
	private String[] columnHeaders;

	private ColumnLayoutData[] columnWidths;
	private final Map<Integer, Comparator<Object>> comparatorMap;
	private DataBindingContext dbc;
	private ListenerList<IActionListener> doubleClickListeners;
	private final Map<Integer, IColumnFormatter> formatterMap;

	private boolean isSortedAscending;
	private final Listener itemEraser;

	/*
	 * Data we received in bindToModel(...). May change without our doing.
	 */
	private IObservableList modelObservables;
	private boolean moveableColumns;
	private String[] renderingMethods;
	private Class<?> rowClass;
	private final SelectionListener selectionTypeEnforcer;
	private final Map<Integer, Boolean> sortableColumnsMap;
	private int sortedColumn;

	private final ColumnSortListener sortListener;

	private final MouseTrackListener tooltipManager;

	private TableViewer viewer;

	/*
	 * Binds the viewer's multiple selection to the multiple selection
	 * observable. This binding has to be disposed when the ridget is set to
	 * output-only, to avoid updating the model. It has to be recreated when the
	 * ridget is set to not-output-only.
	 */
	private Binding viewerMSB;

	/*
	 * Data the viewer is bound to. It is updated from modelObservables on
	 * updateFromModel().
	 */
	private IObservableList viewerObservables;

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

			@Override
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
	public void addClickListener(IClickListener listener) {
		Assert.isNotNull(listener, "listener is null"); //$NON-NLS-1$
		if (clickListeners == null) {
			clickListeners = new ListenerList<IClickListener>(IClickListener.class);
		}
		clickListeners.add(listener);
	}

	@Override
	public void addDoubleClickListener(IActionListener listener) {
		Assert.isNotNull(listener, "listener is null"); //$NON-NLS-1$
		if (doubleClickListeners == null) {
			doubleClickListeners = new ListenerList<IActionListener>(IActionListener.class);
		}
		doubleClickListeners.add(listener);
	}

	@Override
	public void bindToModel(IObservableList rowObservables, Class<? extends Object> aRowClass,
			String[] columnPropertyNames, String[] columnHeaders) {
		if (columnHeaders != null) {
			final String msg = "Mismatch between number of columnPropertyNames and columnHeaders"; //$NON-NLS-1$
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

	@Override
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

	@Override
	public IObservableList getObservableList() {
		return viewerObservables;
	}

	@Override
	public Object getOption(int index) {
		if ((getRowObservables() == null) || (index < 0) || (index >= getOptionCount())) {
			throw new IllegalArgumentException("index: " + index); //$NON-NLS-1$
		}
		if (viewer != null) {
			return viewer.getElementAt(index); // sorted
		}
		return getRowObservables().get(index); // unsorted
	}

	@Override
	public int getSelectionIndex() {
		final Table control = getUIControl();
		return control == null ? -1 : control.getSelectionIndex();
	}

	@Override
	public int[] getSelectionIndices() {
		final Table control = getUIControl();
		return control == null ? new int[0] : control.getSelectionIndices();
	}

	@Override
	public int getSortedColumn() {
		final boolean isSorted = (sortedColumn != -1) && isColumnSortable(sortedColumn);
		return isSorted ? sortedColumn : -1;
	}

	@Override
	public Table getUIControl() {
		return (Table) super.getUIControl();
	}

	@Override
	public boolean hasMoveableColumns() {
		return moveableColumns;
	}

	@Override
	public int indexOfOption(Object option) {
		final Table control = getUIControl();
		if (control != null) {
			// implies viewer != null
			final int optionCount = control.getItemCount();
			for (int i = 0; i < optionCount; i++) {
				if (viewer.getElementAt(i).equals(option)) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean isColumnSortable(int columnIndex) {
		checkColumnRange(columnIndex);
		boolean result = false;
		final Integer key = Integer.valueOf(columnIndex);
		final Boolean sortable = sortableColumnsMap.get(columnIndex);
		if ((sortable == null) || Boolean.TRUE.equals(sortable)) {
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

	@Override
	public boolean isSortedAscending() {
		return (getSortedColumn() != -1) && isSortedAscending;
	}

	@Override
	public void refresh(Object node) {
		if (viewer != null) {
			viewer.refresh(node, true);
		}
	}

	@Override
	public void removeClickListener(IClickListener listener) {
		if (clickListeners != null) {
			clickListeners.remove(listener);
		}
	}

	@Override
	public void removeDoubleClickListener(IActionListener listener) {
		if (doubleClickListeners != null) {
			doubleClickListeners.remove(listener);
		}
	}

	@Override
	public void setColumnEditingSupport(int columnIndex, IColumnEditingSupport columnEditor) {
		checkColumnRange(columnIndex);
		final Integer key = Integer.valueOf(columnIndex);
		columnEditors.put(key, columnEditor);

	}

	@Override
	public void setColumnFormatter(int columnIndex, IColumnFormatter formatter) {
		checkColumnRange(columnIndex);
		if (formatter != null) {
			Assert.isLegal(formatter instanceof ColumnFormatter, "formatter must sublass ColumnFormatter"); //$NON-NLS-1$
		}
		final Integer key = Integer.valueOf(columnIndex);
		formatterMap.put(key, formatter);
	}

	@Override
	public void setColumnSortable(int columnIndex, boolean sortable) {
		checkColumnRange(columnIndex);
		final Integer key = Integer.valueOf(columnIndex);
		final Boolean newValue = Boolean.valueOf(sortable);
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
	@Override
	public void setColumnWidths(Object[] widths) {
		columnWidths = ColumnUtils.copyWidths(widths);
		final Table control = getUIControl();
		if (control != null) {
			applyColumnWidths(control);
		}
	}

	@Override
	public void setComparator(int columnIndex, Comparator<Object> compi) {
		checkColumnRange(columnIndex);
		final Integer key = Integer.valueOf(columnIndex);
		if (compi != null) {
			comparatorMap.put(key, compi);
		} else {
			comparatorMap.remove(key);
		}
		if (columnIndex == sortedColumn) {
			applyComparator();
		}
	}

	@Override
	public void setMoveableColumns(boolean moveableColumns) {
		if (this.moveableColumns != moveableColumns) {
			this.moveableColumns = moveableColumns;
			final Table control = getUIControl();
			if (control != null) {
				applyColumnsMoveable(control);
			}
		}
	}

	@Override
	public void setSortedAscending(boolean ascending) {
		if (isSortedAscending != ascending) {
			final boolean oldSortedAscending = isSortedAscending;
			isSortedAscending = ascending;
			applyComparator();
			firePropertyChange(ISortableByColumn.PROPERTY_SORT_ASCENDING, oldSortedAscending, isSortedAscending);
		}
	}

	@Override
	public void setSortedColumn(int columnIndex) {
		if (columnIndex != -1) {
			checkColumnRange(columnIndex);
		}
		if (sortedColumn != columnIndex) {
			final int oldSortedColumn = sortedColumn;
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
			final List<Object> copy = new ArrayList<Object>(modelObservables);
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
			for (final TableColumn column : control.getColumns()) {
				column.dispose();
			}
			for (int i = 0; i < expectedCols; i++) {
				final TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
				if (this.columnEditors.get(i) != null) {
					column.setEditingSupport(new RidgetEditingSupport(this.viewer, this.columnEditors.get(i),
							renderingMethods[i], this.rowClass, i));
				}
			}

			applyColumnWidths(control);
		}
	}

	private void applyColumnsMoveable(Table control) {
		for (final TableColumn column : control.getColumns()) {
			column.setMoveable(moveableColumns);
		}
	}

	private void applyColumnWidths(Table control) {
		ColumnUtils.applyColumnWidths(control, columnWidths);
	}

	private void applyComparator() {
		if (viewer != null) {
			final Table table = viewer.getTable();
			Comparator<Object> compi = null;
			if (sortedColumn != -1) {
				final Integer key = Integer.valueOf(sortedColumn);
				compi = comparatorMap.get(key);
			}
			if (compi != null) {
				final TableColumn column = table.getColumn(sortedColumn);
				table.setSortColumn(column);
				final int direction = isSortedAscending ? SWT.UP : SWT.DOWN;
				table.setSortDirection(direction);
				final SortableComparator sortableComparator = new SortableComparator(this, compi);
				viewer.setComparator(new TableComparator(sortableComparator));
			} else {
				viewer.setComparator(null);
				table.setSortColumn(null);
				table.setSortDirection(SWT.NONE);
			}
		}
	}

	private void applyTableColumnHeaders(Table control) {
		final boolean headersVisible = columnHeaders != null;
		control.setHeaderVisible(headersVisible);
		if (headersVisible) {
			final TableColumn[] columns = control.getColumns();
			for (int i = 0; i < columns.length; i++) {
				String columnHeader = ""; //$NON-NLS-1$
				if ((i < columnHeaders.length) && (columnHeaders[i] != null)) {
					columnHeader = columnHeaders[i];
				}
				columns[i].setText(columnHeader);
			}
		}
	}

	private void checkColumnRange(int columnIndex) {
		final Table table = getUIControl();
		if (table != null) {
			final int range = table.getColumnCount();
			final String msg = "columnIndex out of range (0 - " + range + " ): " + columnIndex; //$NON-NLS-1$ //$NON-NLS-2$
			Assert.isLegal(-1 < columnIndex, msg);
			Assert.isLegal(columnIndex < range, msg);
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
		final ObservableListContentProvider viewerCP = new ObservableListContentProvider();
		IObservableMap[] attrMap;
		if (AbstractSWTWidgetRidget.isBean(rowClass)) {
			attrMap = BeansObservables.observeMaps(viewerCP.getKnownElements(), rowClass, renderingMethods);
		} else {
			attrMap = PojoObservables.observeMaps(viewerCP.getKnownElements(), rowClass, renderingMethods);
		}
		final IColumnFormatter[] formatters = getColumnFormatters(attrMap.length);
		viewer.setLabelProvider(new EditableTableRidgetLabelProvider(attrMap, formatters));
		viewer.setContentProvider(viewerCP);
		viewer.setInput(viewerObservables);
	}

	private void createMultipleSelectionBinding() {
		if ((viewerMSB == null) && (dbc != null) && (viewer != null)) {
			final StructuredSelection currentSelection = new StructuredSelection(getSelection());
			final IViewerObservableList viewerSelections = ViewersObservables.observeMultiSelection(viewer);
			viewerMSB = dbc.bindList(viewerSelections, getMultiSelectionObservable(), new UpdateListStrategy(
					UpdateListStrategy.POLICY_UPDATE), new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE));
			viewer.setSelection(currentSelection);
		}
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
		final IColumnFormatter[] result = new IColumnFormatter[numColumns];
		for (int i = 0; i < numColumns; i++) {
			final IColumnFormatter columnFormatter = formatterMap.get(Integer.valueOf(i));
			if (columnFormatter != null) {
				result[i] = columnFormatter;
			}
		}
		return result;
	}

	// helping classes
	// ////////////////

	private boolean isViewerConfigured() {
		return viewer.getLabelProvider() instanceof EditableTableRidgetLabelProvider;
	}

	private void refreshViewer(TableViewer viewer) {
		viewer.getControl().setRedraw(false); // prevent flicker during update
		final StructuredSelection currentSelection = new StructuredSelection(getSelection());
		try {
			final EditableTableRidgetLabelProvider labelProvider = (EditableTableRidgetLabelProvider) viewer
					.getLabelProvider();
			final IColumnFormatter[] formatters = getColumnFormatters(labelProvider.getColumnCount());
			labelProvider.setFormatters(formatters);
			viewer.setInput(viewerObservables);
		} finally {
			viewer.setSelection(currentSelection);
			viewer.getControl().setRedraw(true);
		}
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
			final IObservableValue viewerSelection = ViewersObservables.observeSingleSelection(viewer);
			dbc.bindValue(viewerSelection, getSingleSelectionObservable(), new UpdateValueStrategy(
					UpdateValueStrategy.POLICY_UPDATE).setAfterGetValidator(new OutputAwareValidator(this)),
					new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE));
			// viewer to to multi-selection binding
			viewerMSB = null;
			if (!isOutputOnly()) {
				createMultipleSelectionBinding();
			}

			for (final TableColumn column : control.getColumns()) {
				column.addSelectionListener(sortListener);
			}
			control.addSelectionListener(selectionTypeEnforcer);
			control.addMouseListener(clickForwarder);
			final SWTFacade facade = SWTFacade.getDefault();
			facade.addMouseTrackListener(control, tooltipManager);
			facade.addEraseItemListener(control, itemEraser);
		}
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Table.class);
	}

	@Override
	protected java.util.List<?> getRowObservables() {
		return viewerObservables;
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (dbc != null) {
			disposeMultipleSelectionBinding();
			dbc.dispose();
			dbc = null;
		}
		final Table control = getUIControl();
		if (control != null) {
			for (final TableColumn column : control.getColumns()) {
				column.removeSelectionListener(sortListener);
			}
			control.removeSelectionListener(selectionTypeEnforcer);
			control.removeMouseListener(clickForwarder);
			final SWTFacade facade = SWTFacade.getDefault();
			facade.removeMouseTrackListener(control, tooltipManager);
			facade.removeEraseItemListener(control, itemEraser);
		}
		viewer = null;
	}

}
