package com.agritrace.edairy.desktop.operations.ui.controllers;

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
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDirectoryView.ContactNameColumnFormatter;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDirectoryView.ContactPhoneColumnFormatter;

public abstract class BasicDirectoryController<T extends EObject> extends AbstractDirectoryController<T> {

//	public static String[] MASTER_PROPTIES = { ModelPackage.Literals.COMPANY__COMPANY_ID.getName(),
//				ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(),
//				DairyPackage.Literals.SUPPLIER__CATEGORIES.getName(), ModelPackage.Literals.COMPANY__CONTACTS.getName(),
//				ModelPackage.Literals.COMPANY__PHONE_NUMBER.getName(), DairyPackage.Literals.SUPPLIER__STATUS.getName() };
//	public static String[] MASTER_HEADERS = { "ID", "Company Name", "Category", "Contact", "Contact #", "Status" };

	
	final private List<String> columnHeaders = new ArrayList<String>();
	final private List<String> columnProperties = new ArrayList<String>();
	final private List<ColumnFormatter> columnFormatters = new ArrayList<ColumnFormatter>();

	private EClass eClass;
	private Class<?> entityClass;
//	private String[] cachedColumnHeaders;
	

	public BasicDirectoryController() {
		super();
	}

	public BasicDirectoryController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	protected void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}
	protected Class<?> getEntityClass() {
		return entityClass;
	}

	protected void setEClass(EClass eClass) { 
		this.eClass = eClass;
	}
	
	protected EClass getEClass() {
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

//	protected void addTableColumn(String colHeader, FeaturePath modelProperty) { 
//		addTableColumn(colHeader, modelProperty, null);
//	}

//	protected void addTableColumn(String colHeader, FeaturePath modelPath, ColumnFormatter formatter) {
//		columnHeaders.add(colHeader);
//		columnProperties.add(modelPath);
//		columnFormatters.add(formatter);
//	}

	@Override
	protected String[] getTableColumnHeaders() {
		int numCols = columnHeaders.size();
		String[] colHeaders = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colHeaders[i] = columnHeaders.get(i);			
		}
		return colHeaders;
	}

//	protected IEMFProperty[] getTableColumnProperties() {
//		int numCols = columnProperties.size();
//		IEMFProperty colProps[] = new IEMFProperty[numCols];
//		for (int i = 0; i < numCols; i++) {
//			colProps[i] = columnProperties.get(i);			
//		}
//		return colProps;
//	}
//	
	protected ColumnFormatter[] getTableColumnFormatters() {
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
		// fallback if using older api
		if (getTableColumnPropertyNames() != null) {
			super.configureTableRidget();
			return;
		}
		table = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
		table.addSelectionListener(selectionListener);
		table.bindSingleSelectionToModel(this, "selectedEObject");
		table.addDoubleClickListener(viewAction);
		
//		IEMFListProperty obList = EMFProperties.list(DairyPackage.Literals.DAIRY__EMPLOYEES);
//		table.bindToModel(rowObservables, rowClass, columnPropertyNames, columnHeaders);
		
		table.bindToModel(new WritableList(tableContents, getEntityClass()), getEntityClass(),
				getTableColumnPropertyNames(), getTableColumnHeaders());

		table.updateFromModel();

		
	}

}