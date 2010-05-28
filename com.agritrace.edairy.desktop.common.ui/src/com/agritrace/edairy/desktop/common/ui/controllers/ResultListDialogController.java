package com.agritrace.edairy.desktop.common.ui.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;

/**
 * Abstract result viewing/adding dialog controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class ResultListDialogController extends
		AbstractWindowController {
	private RecordDialog dialog;

	private List<IActionListener> listeners = new ArrayList<IActionListener>();
	private Map<String, EStructuralFeature> ridgetPropertyMap = new HashMap<String, EStructuralFeature>();

	private EObject workingCopy;

	/**
	 * @param dialog
	 *            Adding/Viewing/Editing Dialog
	 */
	public ResultListDialogController(RecordDialog dialog) {
		super();
		this.dialog = dialog;
		workingCopy = createWorkingCopy();
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 */
	public void addListener(IActionListener listener) {
		this.listeners.add(listener);
	}

	protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
		Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		ridgetPropertyMap.clear();
		ridgetPropertyMap.putAll(configureRidgetPropertyMap());

		for (Entry<String, EStructuralFeature> entry : ridgetPropertyMap
				.entrySet()) {

			IRidget ridget = getRidget(entry.getKey());
			if (ridget instanceof IValueRidget) {
				IValueRidget valueRidget = (IValueRidget) ridget;
				IConverter converter = RidgetsConfigFactory.getInstance()
						.getModel2UIConverter(entry.getValue(), valueRidget);
				if (converter != null) {
					valueRidget.setModelToUIControlConverter(converter);
				}
				valueRidget.bindToModel(this.getWorkingCopy(), entry.getValue()
						.getName());
				valueRidget.updateFromModel();
			}

		}

		IActionRidget okButton = getRidget(IActionRidget.class,
				RecordDialog.BIND_ID_BUTTON_OK); //$NON-NLS-1$
		okButton.addListener(new IActionListener() {

			@Override
			public void callback() {

				doOKPressed();

			}

		});
		IActionRidget cancelBtn = getRidget(IActionRidget.class,
				RecordDialog.BIND_ID_BUTTON_CANCEL); //$NON-NLS-1$
		cancelBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				doButtonPressed(CANCEL);

			}
		});
	}

	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	protected abstract EObject createWorkingCopy();

	private void doButtonPressed(int ok) {
		if (Window.OK == ok) {
			doOKPressed();
		} else {
			doCancelPressed();
		}

	}

	/**
	 * Do something when 'Cancel' button is pressed
	 */
	protected void doCancelPressed() {
		setReturnCode(CANCEL);
		getWindowRidget().dispose();

	}

	/**
	 * Create a new record when press 'OK' when adding a new record
	 */
	protected abstract void doCreation();

	/**
	 * Logic when 'OK' button is pressed
	 */
	protected void doOKPressed() {
		setReturnCode(OK);
		if (dialog.getDialogStyle() == RecordDialog.DIALOG_STYLE_NEW) {
			doCreation();
		} else {
			// Update all working copy to selected object
			EMFUtil.copy(this.getWorkingCopy(), dialog.getSelectedEObject());
			doUpdate();
		}
		notifierListeners();
		getWindowRidget().dispose();
	}

	/**
	 * Save the file to DB or file
	 */
	protected void doSave() {
		try {
			DairyDemoResourceManager.INSTANCE.saveFarmResource();
			DairyDemoResourceManager.INSTANCE.saveDairyResource();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Update a selected record when press 'Update' when adding a new record
	 */
	protected abstract void doUpdate();

	/**
	 * Gets the row data model in table
	 * 
	 * @return Row data model
	 */
	protected abstract EClass getEClass();

	/**
	 * Gets working copy
	 * 
	 * @return Working copy
	 */
	public EObject getWorkingCopy() {
		return workingCopy;

	}

	/**
	 * The hook when one row in table is selected
	 */
	public void itemSelected() {
		// Copy selected object to
		// Copy selected into working copy
		if (dialog.getSelectedEObject() != null
				&& dialog.getDialogStyle() != RecordDialog.DIALOG_STYLE_NEW) {
			EMFUtil.copy(dialog.getSelectedEObject(), getWorkingCopy());
		} else if (dialog.getDialogStyle() == RecordDialog.DIALOG_STYLE_NEW) {
			EMFUtil.copy(createWorkingCopy(), getWorkingCopy());
		}
	}

	private void notifierListeners() {
		for (IActionListener listener : this.listeners) {
			listener.callback();
		}
	}
}
