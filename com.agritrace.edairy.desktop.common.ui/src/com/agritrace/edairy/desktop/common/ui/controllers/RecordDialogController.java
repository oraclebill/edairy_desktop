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
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.ui.ridgets.ClassRidgetMapper;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.DairyPersistenceException;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class RecordDialogController<T extends EObject> extends AbstractWindowController {

	private final Map<String, EStructuralFeature> ridgetPropertyMap = new HashMap<String, EStructuralFeature>();

	private final List<IActionListener> listeners = new ArrayList<IActionListener>();

	private int actionType;


	protected abstract EClass getEClass();
	protected abstract IRepository<T> getRepository();
	protected abstract T getWorkingCopy();
	protected abstract void setWorkingCopy(T t);
	
	/** 
	 * Null constructor 
	 */
	public RecordDialogController() {
		super();
	}

	public RecordDialogController(T workingCopy) {
		super();
		setWorkingCopy(workingCopy);
	}


	public void setActionType(int actionType) {
		this.actionType = actionType;
	}


	@Override
	public void configureRidgets() {
		setWindowRidget(getRidget(IWindowRidget.class, RIDGET_ID_WINDOW));

		ridgetPropertyMap.clear();
		ridgetPropertyMap.putAll(configureRidgetPropertyMap());

		for (final Entry<String, EStructuralFeature> binding : ridgetPropertyMap.entrySet()) {

			final IRidget ridget = getRidget(binding.getKey());
			if (ridget instanceof IValueRidget) {
				final IValueRidget valueRidget = (IValueRidget) ridget;
				final IConverter converter = RidgetsConfigFactory.getInstance().getModel2UIConverter(binding.getValue(),
						valueRidget);
				if (converter != null) {
					valueRidget.setModelToUIControlConverter(converter);
				}
				valueRidget.bindToModel(this.getWorkingCopy(), binding.getValue().getName());
				valueRidget.updateFromModel();
			}

		}

		final IActionRidget okButton = getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_SAVE);
		okButton.addListener(new IActionListener() {

			@Override
			public void callback() {

				try {
					handleSaveAction();
				} catch (final DairyPersistenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		final IActionRidget cancelBtn = getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				handleCancelAction();

			}
		});
	}

	protected void handleSaveAction()  {
		setReturnCode(OK);
		if (getActionType() == AbstractRecordListController.ACTION_NEW) {
			saveNew();
		} else {
			// Update all working copy to selected object
			// EMFUtil.copy(this.getWorkingCopy(), getSelectedObject(), 2);
			saveUpdated();
		}
		notifierListeners();
		if (!RienaStatus.isTest()) {

			getWindowRidget().dispose();
		}
	}
	
	protected void handleCancelAction() {
		setReturnCode(CANCEL);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}
	}



	protected int getActionType() {
		return this.actionType;
	}

	protected void saveNew() throws AlreadyExistsException {
		getRepository().saveNew(getWorkingCopy());

	}

	protected void saveUpdated() throws NonExistingEntityException {
		getRepository().update(getWorkingCopy());
	}

	protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
		final Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}

	public void addListener(IActionListener listener) {
		this.listeners.add(listener);
	}

	private void notifierListeners() {
		for (final IActionListener listener : this.listeners) {
			listener.callback();
		}
	}


	/**
	 * @since 2.0
	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
//		R ridget = (R) getRidget(id);
//
//		if (ridget != null) {
//			return ridget;
//		}
//		if (RienaStatus.isTest()) {
//			try {
//				if (ridgetClazz.isInterface() || Modifier.isAbstract(ridgetClazz.getModifiers())) {
//					final Class<R> mappedRidgetClazz = (Class<R>) ClassRidgetMapper.getInstance().getRidgetClass(
//							ridgetClazz);
//					if (mappedRidgetClazz != null) {
//						ridget = mappedRidgetClazz.newInstance();
//					}
//					Assert.isNotNull(
//							ridget,
//							"Could not find a corresponding implementation for " + ridgetClazz.getName() + " in " + ClassRidgetMapper.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$
//				} else {
//					ridget = ridgetClazz.newInstance();
//				}
//			} catch (final InstantiationException e) {
//				throw new RuntimeException(e);
//			} catch (final IllegalAccessException e) {
//				throw new RuntimeException(e);
//			}
//
//			addRidget(id, ridget);
//		}
//
//		return ridget;
//	}

}
