package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.beans.common.TypedComparator;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.columnformatters.DirectoryDateColumnFormatter;
import com.agritrace.edairy.desktop.common.ui.columnformatters.MemberIDAndNameFormatter;
import com.agritrace.edairy.desktop.common.ui.columnformatters.PersonToFormattedName;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public abstract class BasicDirectoryController<T extends EObject> extends AbstractDirectoryController<T> {

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

	public static final String EMPTY_SELECTION_TEXT = "ANY";

	final private List<ColumnFormatter> columnFormatters = new ArrayList<ColumnFormatter>();
	final private List<String> columnHeaders = new ArrayList<String>();
	final private List<String> columnProperties = new ArrayList<String>();
	final private ArrayList<Comparator<?>> columnComparators = new ArrayList<Comparator<?>>();

	private EClass eClass;

	public BasicDirectoryController() {
		super();
	}

	public BasicDirectoryController(ISubModuleNode navigationNode) {
		super(navigationNode);
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
		} 
		else if (Integer.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<Integer>());
		} 
		else if (Date.class.isAssignableFrom(colType)) {
			columnComparators.add(new TypedComparator<Date>());
		} 
		else if (Person.class.isAssignableFrom(colType)) {
			columnComparators.add(new PersonComparator());
		} 
		else if (Membership.class.isAssignableFrom(colType)) {
			columnComparators.add(new MemberComparator());
		} 
		else {
			columnComparators.add(null);
		}
	}

	private ColumnFormatter getDefaultFormatter(Class<?> colType, final String propName) {
		ColumnFormatter formatter = null;
		if (colType.isAssignableFrom(Date.class)) {
			formatter = new DirectoryDateColumnFormatter(propName);
		} else if (colType.isAssignableFrom(Membership.class)) {
			formatter = new MemberIDAndNameFormatter(propName);
		} else if (colType.isAssignableFrom(Person.class)) {
			formatter = new PersonToFormattedName(propName);
		}
		return formatter;
	}

	@Override
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

		tableBindToModel();
	}

	protected void tableBindToModel() {
		if (table != null) {
			final String[] tableColumnProperties = getTableColumnPropertyNames();
			final String[] tableColumnHeaders = getTableColumnHeaders();
			table.bindToModel(new WritableList(getTableContents(), getEntityClass()), getEntityClass(),
					tableColumnProperties, tableColumnHeaders);

			table.updateFromModel();
		}
	}

	protected Comparator[] getTableColumnComparators() {
		return columnComparators.toArray(new Comparator[columnComparators.size()]);
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