package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.services.IRepository;

public abstract class LookupDialogController extends AbstractWindowController {

	private ITableRidget listTable;
	private IRepository repo;

	public LookupDialogController() {
		super();
		repo = createRepository();
	}

	protected abstract IRepository createRepository();

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		// Set window riget
		this.getWindowRidget().setTitle(getEntityName() + " Lookup");
		// Search Button
		IActionRidget searchAction = getRidget(IActionRidget.class,
				FarmSearchDialog.SEARCH_BUTTON);
		searchAction.addListener(new IActionListener() {

			@Override
			public void callback() {
				listTable.updateFromModel();
			}
		});

		//
		listTable = getRidget(ITableRidget.class, FarmSearchDialog.RESULT_LIST);

		//listTable.bindToModel(rowObservables, rowClass, columnPropertyNames, columnHeaders)
	}

	/**
	 * Gets entity name
	 * 
	 * @return
	 */
	protected abstract String getEntityName();


	/**
	 * Gets Eclass of row
	 * 
	 * @return
	 */
	protected abstract EClass getEClass();

	protected abstract String[] getColumnProperties();

}
