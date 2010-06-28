package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFProperty;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public abstract class BasicDirectoryController<T extends EObject> extends AbstractDirectoryController<T> {
	
	public static final String EMPTY_SELECTION_TEXT = "ANY";

	final private List<String> columnHeaders = new ArrayList<String>();
	final private List<String> columnProperties = new ArrayList<String>();
	final private List<ColumnFormatter> columnFormatters = new ArrayList<ColumnFormatter>();

	private EClass eClass;
	private Class<? extends EObject> entityClass;	

	public BasicDirectoryController() {
		super();
	}

	public BasicDirectoryController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	final protected void setEntityClass(Class<? extends EObject> entityClass) {
		throw new UnsupportedOperationException();
	}
	
	protected void setEClass(EClass eClass) { 
		this.eClass = eClass;
	}
	
	final protected EClass getEClass() {
		return eClass;
	}

	protected void addTableColumn(String colHeader, EStructuralFeature feature) { 
		addTableColumn(colHeader, feature, null);
	}

	protected void addTableColumn(String colHeader, EStructuralFeature feature, ColumnFormatter formatter) { 
		columnHeaders.add(colHeader);
		columnProperties.add(feature.getName());
		columnFormatters.add(formatter);
	}

	@Override
	final protected String[] getTableColumnHeaders() {
		int numCols = columnHeaders.size();
		String[] colHeaders = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colHeaders[i] = columnHeaders.get(i);			
		}
		return colHeaders;
	}

	final protected ColumnFormatter[] getTableColumnFormatters() {
		int numCols = columnFormatters.size();
		ColumnFormatter colFormatter[] = new ColumnFormatter[numCols];
		for (int i = 0; i < numCols; i++) {
			colFormatter[i] = columnFormatters.get(i);			
		}
		return colFormatter;
	}

	@Override
	final protected String[] getTableColumnPropertyNames() {
		int numCols = columnProperties.size();
		String colProps[] = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colProps[i] = columnProperties.get(i);			
		}
		return colProps;
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
				
		ColumnFormatter[] formatters = getTableColumnFormatters();
		for ( int i = 0; i < formatters.length; i++ ) {
			if (formatters[i] != null ) {
				table.setColumnFormatter(i, formatters[i]);
			}
		}
		
		table.bindToModel(new WritableList(getTableContents(), getEntityClass()), getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		table.updateFromModel();

		
	}

}