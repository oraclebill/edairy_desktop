package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;

public abstract class ResultListDialogController extends
		AbstractWindowController {
	private Map<String, EStructuralFeature> ridgetPropertyMap = new HashMap<String, EStructuralFeature>();

	private EObject workingCopy;
	private List<IActionListener> listeners = new ArrayList<IActionListener>();

	public ResultListDialogController() {
		super();
		workingCopy = createWorkingCopy();
	}

	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	public abstract EObject createWorkingCopy();

	public EObject getWorkingCopy() {
		return workingCopy;

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
				setReturnCode(OK);
				notifierListeners();
				getWindowRidget().dispose();
			}

		});
		IActionRidget cancelBtn = getRidget(IActionRidget.class,
				RecordDialog.BIND_ID_BUTTON_CANCEL); //$NON-NLS-1$
		cancelBtn.addListener(new IActionListener() {

			@Override
			public void callback() {

				setReturnCode(CANCEL);
				getWindowRidget().dispose();

			}
		});
	}

	protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
		Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}

	public void addListener(IActionListener listener) {
		this.listeners.add(listener);
	}

	private void notifierListeners() {
		for (IActionListener listener : this.listeners) {
			listener.callback();
		}
	}

}
