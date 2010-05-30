package com.agritrace.edairy.desktop.common.ui.controllers;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.ui.ridgets.ClassRidgetMapper;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;

public abstract class RecordDialogController<T extends EObject> extends AbstractWindowController {
	private Map<String, EStructuralFeature> ridgetPropertyMap = new HashMap<String, EStructuralFeature>();

	private T workingCopy;
	private List<IActionListener> listeners = new ArrayList<IActionListener>();

	// private RecordDialog dialog;

	private T selectedObject;

	private int actionType;

	public RecordDialogController() {
		super();
		workingCopy = createWorkingCopy();
	}

	public void setSelectedObject(T selectedObject) {
		this.selectedObject = selectedObject;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	protected abstract T createWorkingCopy();

	protected abstract EClass getEClass();

	public T getWorkingCopy() {
		return workingCopy;

	}

	/**
	 * Gets the selected object in table list. If user doesn't select any row,
	 * this object will be null
	 * 
	 * @return
	 */
	public T getSelectedObject() {
		return this.selectedObject;
	}

	// public void itemSelected() {
	// // Copy selected object to
	// // Copy selected into working copy
	// if (getSelectedObject() != null
	// && getDialogStyle() != RecordDialog.DIALOG_STYLE_NEW) {
	// EMFUtil.copy(dialog.getSelectedEObject(), getWorkingCopy(), 2);
	// } else if (dialog.getDialogStyle() == RecordDialog.DIALOG_STYLE_NEW) {
	// EMFUtil.copy(createWorkingCopy(), getWorkingCopy(), 2);
	// }
	// }

	@Override
	public void configureRidgets() {
		setWindowRidget((IWindowRidget) getRidget(IWindowRidget.class,
				RIDGET_ID_WINDOW));

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

	private void doButtonPressed(int ok) {
		if (Window.OK == ok) {
			doOKPressed();
		} else {
			doCancelPressed();
		}

	}

	protected void doOKPressed() {
		setReturnCode(OK);
		if (getActionType() == AbstractRecordListController.ACTION_NEW) {
			saveNew();
		} else {
			// Update all working copy to selected object
			EMFUtil.copy(this.getWorkingCopy(), getSelectedObject(), 2);
			saveUpdated();
		}
		notifierListeners();
		if (!RienaStatus.isTest()) {

			getWindowRidget().dispose();
		}
	}

	private int getActionType() {
		return this.actionType;
	}

	protected abstract void saveNew();

	protected abstract void saveUpdated();

	protected void doCancelPressed() {
		setReturnCode(CANCEL);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}

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
	 * Copy the model from selected object to working copy
	 */
	public void copyModel() {
		// Copy
		if (getActionType() != AbstractRecordListController.ACTION_NEW) {
			EMFUtil.copy(this.getSelectedObject(), this.workingCopy, 2);
		}

	}

	/**
	 * @since 2.0
	 */
	@SuppressWarnings("unchecked")
	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
		R ridget = (R) getRidget(id);

		if (ridget != null) {
			return ridget;
		}
		if (RienaStatus.isTest()) {
			try {
				if (ridgetClazz.isInterface()
						|| Modifier.isAbstract(ridgetClazz.getModifiers())) {
					Class<R> mappedRidgetClazz = (Class<R>) ClassRidgetMapper
							.getInstance().getRidgetClass(ridgetClazz);
					if (mappedRidgetClazz != null) {
						ridget = mappedRidgetClazz.newInstance();
					}
					Assert.isNotNull(
							ridget,
							"Could not find a corresponding implementation for " + ridgetClazz.getName() + " in " + ClassRidgetMapper.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$
				} else {
					ridget = ridgetClazz.newInstance();
				}
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}

			addRidget(id, ridget);
		}

		return ridget;
	}
}
