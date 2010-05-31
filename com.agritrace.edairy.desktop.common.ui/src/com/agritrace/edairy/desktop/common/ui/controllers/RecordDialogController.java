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
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;

public abstract class RecordDialogController<T extends EObject> extends AbstractWindowController {

	// TODO: move these constants to a neutral API class... (was in dialog..)
	public static final String BIND_ID_BUTTON_OK = "bind.id.btn.ok";
	public static final String BIND_ID_BUTTON_CANCEL = "bind.id.btn.cancel";

	private final Map<String, EStructuralFeature> ridgetPropertyMap = new HashMap<String, EStructuralFeature>();

	private final List<IActionListener> listeners = new ArrayList<IActionListener>();

	private IRepository<T> myRepo;
	private T workingCopy;
	private int actionType;

	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	// protected abstract T createWorkingCopy();

	protected abstract EClass getEClass();

	public RecordDialogController() {
		super();
	}

	public RecordDialogController(T workingCopy) {
		super();
		this.workingCopy = workingCopy;
	}

	public IRepository<T> getRepository() {
		return myRepo;
	}

	public void setRepository(IRepository<T> myRepo) {
		this.myRepo = myRepo;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	public T getWorkingCopy() {
		return workingCopy;
	}

	public void setWorkingCopy(T obj) {
		workingCopy = obj;
	}

	// /**
	// * Gets the selected object in table list. If user doesn't select any row,
	// * this object will be null
	// *
	// * @return
	// */
	// public T getSelectedObject() {
	// return this.selectedObject;
	// }

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
		setWindowRidget(getRidget(IWindowRidget.class, RIDGET_ID_WINDOW));

		ridgetPropertyMap.clear();
		ridgetPropertyMap.putAll(configureRidgetPropertyMap());

		for (final Entry<String, EStructuralFeature> entry : ridgetPropertyMap.entrySet()) {

			final IRidget ridget = getRidget(entry.getKey());
			if (ridget instanceof IValueRidget) {
				final IValueRidget valueRidget = (IValueRidget) ridget;
				final IConverter converter = RidgetsConfigFactory.getInstance().getModel2UIConverter(entry.getValue(),
						valueRidget);
				if (converter != null) {
					valueRidget.setModelToUIControlConverter(converter);
				}
				valueRidget.bindToModel(this.getWorkingCopy(), entry.getValue().getName());
				valueRidget.updateFromModel();
			}

		}

		final IActionRidget okButton = getRidget(IActionRidget.class, BIND_ID_BUTTON_OK);
		okButton.addListener(new IActionListener() {

			@Override
			public void callback() {

				try {
					doOKPressed();
				} catch (final DairyPersistenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		final IActionRidget cancelBtn = getRidget(IActionRidget.class, BIND_ID_BUTTON_CANCEL);
		cancelBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				doCancelPressed();

			}
		});
	}

	protected void doOKPressed() throws DairyPersistenceException {
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

	protected int getActionType() {
		return this.actionType;
	}

	protected void saveNew() throws AlreadyExistsException {
		myRepo.saveNew(getWorkingCopy());

	}

	protected void saveUpdated() throws NonExistingEntityException {
		myRepo.update(getWorkingCopy());
	}

	protected void doCancelPressed() {
		setReturnCode(CANCEL);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}

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

	protected void doSave() {
		try {
			DairyDemoResourceManager.INSTANCE.saveFarmResource();
			DairyDemoResourceManager.INSTANCE.saveDairyResource();
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// /**
	// * Copy the model from selected object to working copy
	// */
	// public void copyModel() {
	// // Copy
	// if (getActionType() != AbstractRecordListController.ACTION_NEW) {
	// // EMFUtil.copy(this.getSelectedObject(), this.workingCopy, 2);
	// }
	//
	// }

	/**
	 * @since 2.0
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
		R ridget = (R) getRidget(id);

		if (ridget != null) {
			return ridget;
		}
		if (RienaStatus.isTest()) {
			try {
				if (ridgetClazz.isInterface() || Modifier.isAbstract(ridgetClazz.getModifiers())) {
					final Class<R> mappedRidgetClazz = (Class<R>) ClassRidgetMapper.getInstance().getRidgetClass(
							ridgetClazz);
					if (mappedRidgetClazz != null) {
						ridget = mappedRidgetClazz.newInstance();
					}
					Assert.isNotNull(
							ridget,
							"Could not find a corresponding implementation for " + ridgetClazz.getName() + " in " + ClassRidgetMapper.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$
				} else {
					ridget = ridgetClazz.newInstance();
				}
			} catch (final InstantiationException e) {
				throw new RuntimeException(e);
			} catch (final IllegalAccessException e) {
				throw new RuntimeException(e);
			}

			addRidget(id, ridget);
		}

		return ridget;
	}
}
