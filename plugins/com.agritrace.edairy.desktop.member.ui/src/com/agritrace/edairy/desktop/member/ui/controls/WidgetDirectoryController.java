package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.beans.common.TypedComparator;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

public abstract class WidgetDirectoryController<T extends EObject> extends AbstractDirectoryController<T> {

	public static final String EMPTY_SELECTION_TEXT = "ANY";

	final private List<ColumnFormatter> columnFormatters = new ArrayList<ColumnFormatter>();
	final private List<String> columnHeaders = new ArrayList<String>();
	final private List<String> columnProperties = new ArrayList<String>();
	final private ArrayList<Comparator<?>> columnComparators = new ArrayList<Comparator<?>>();

	private EClass eClass;

	public WidgetDirectoryController(){
		super();
	}
	public WidgetDirectoryController(IController controller) {
		super(controller);

	}


	protected void addTableColumn(String colHeader, EStructuralFeature featurePath) {
		addTableColumn(colHeader, featurePath, null);
	}

	//
	// protected void addTableColumn(String colHeader, FeaturePath feature) {
	// addTableColumn(colHeader, feature, null);
	// }

	protected void addTableColumn(String colHeader, EStructuralFeature feature, ColumnFormatter formatter) {
		addTableColumn(colHeader, feature.getName(), feature.getEType().getInstanceClass(), formatter);
	}

	protected void addTableColumn(String colHeader, String colPropertyName, Class<?> colType) {
		addTableColumn(colHeader, colPropertyName, colType, null);
	}

	protected void addTableColumn(String colHeader, String colPropertyName, Class<?> colType, ColumnFormatter formatter) {
		columnHeaders.add(colHeader);
		columnProperties.add(colPropertyName);
		columnFormatters.add(formatter);
		if (String.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<String>());
		} else if (Integer.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<Integer>());
		} else {
			columnComparators.add(null);
		}
	}

	@Override
	protected void configureTableRidget() {
		if (getEClass() == null) {
			throw new IllegalStateException("EClass must be set in constructor");
		}
		if (getEntityClass() == null) {
			throw new IllegalStateException("Entity class must be set in constructor");
		}
		if(controller != null){
			table = controller.getRidget(ITableRidget.class, getTableWidgetId());
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
				}
				else {
					table.setColumnSortable(i, false);
				}
			}

			tableBindToModel();
		}

	}

	protected void tableBindToModel(){
		if(table != null){
			final String[] tableColumnProperties = getTableColumnPropertyNames();
			final String[] tableColumnHeaders = getTableColumnHeaders();
			table.bindToModel(new WritableList(getTableContents(), getEntityClass()), getEntityClass(),
					tableColumnProperties, tableColumnHeaders);

			table.updateFromModel();
		}
	}

	@SuppressWarnings("unchecked")
	protected Comparator<Object>[] getTableColumnComparators() {
		Comparator<Object>[] comparatorArray;
		comparatorArray = new Comparator[ columnComparators.size() ];
		return columnComparators.toArray( comparatorArray );
	}

	@Override
	final protected EClass getEClass() {
		return eClass;
	}

	final protected ColumnFormatter[] getTableColumnFormatters() {
		final int numCols = columnFormatters.size();
		final ColumnFormatter colFormatter[] = new ColumnFormatter[numCols];
		for (int i = 0; i < numCols; i++) {
			colFormatter[i] = columnFormatters.get(i);
		}
		return colFormatter;
	}

	@Override
	final protected String[] getTableColumnHeaders() {
		final int numCols = columnHeaders.size();
		final String[] colHeaders = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colHeaders[i] = columnHeaders.get(i);
		}
		return colHeaders;
	}

	@Override
	final protected String[] getTableColumnPropertyNames() {
		final int numCols = columnProperties.size();
		final String colProps[] = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colProps[i] = columnProperties.get(i);
		}
		return colProps;
	}

	protected void setEClass(EClass eClass) {
		this.eClass = eClass;
	}

}