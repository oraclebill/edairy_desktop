/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.swt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.BindingException;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;

import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.core.marker.ErrorMessageMarker;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.nls.Messages;

/**
 * Superclass of ComboRidget that does not depend on the Combo SWT control. May
 * be reused for custom Combo controls.
 */
public abstract class AbstractComboRidget extends AbstractSWTRidget implements IComboRidget {
	/** List of available options (ridget). */
	private final IObservableList rowObservables;
	/** The selected option (ridget). */
	private final IObservableValue selectionObservable;
	/** Selection validator that allows or cancels a selection request. */
	private final SelectionBindingValidator selectionValidator;
	/** IValueChangeListener that fires a selection event on change. */
	private final IValueChangeListener valueChangeNotifier;
	/** A list of selection listeners. */
	private ListenerList<ISelectionListener> selectionListeners;

	/** If this item is selected, treat it as if nothing is selected */
	private Object emptySelection;

	/** List of available options (model). */
	private IObservableList optionValues;
	/** Class of the optional values. */
	private Class<? extends Object> rowClass;
	/** The selected option (model). */
	private IObservableValue selectionValue;
	/** A string used for converting from Object to String */
	private String renderingMethod;
	/**
	 * Converts from objects (rowObsservables) to strings (Combo) using the
	 * renderingMethod.
	 */
	private IConverter objToStrConverter;
	/**
	 * Converts from strings (Combo) to objects (rowObservables).
	 */
	private IConverter strToObjConverter;
	/**
	 * The list of items to show in the combo. These entries are created from
	 * the optionValues by applying the current conversion stategy to them.
	 */
	private List<String> items;
	/**
	 * Binding between the rowObservables and the list of choices from the
	 * model. May be null, when there is no model.
	 */
	private Binding listBindingExternal;
	/**
	 * Binding between the selection in the combo and the selectionObservable.
	 * May be null, when there is no control or model.
	 */
	private Binding selectionBindingInternal;
	/**
	 * Binding between the selectionObservable and the selection in the model.
	 * May be null, when there is no model.
	 */
	private Binding selectionBindingExternal;
	/**
	 * If true, it will cause an error marker to be shown, once the selected
	 * value in the combo is no longer available in the list of selectable
	 * values. This can occur if the selection was removed from the bound model
	 * and {@link #updateFromModel()} is called.
	 * <p>
	 * The default setting is false.
	 * 
	 * @see Bug 304733
	 */
	private boolean markSelectionMismatch;
	/**
	 * The {@link ErrorMarker} used when a 'selection mismatch' occurs
	 */
	private ErrorMarker selectionMismatchMarker;
	/**
	 * The text value shown in the combo. Note: this is not necessarily a valid
	 * selection. Use {@link #getSelection()} to get the current selection.
	 */
	String text;

	public AbstractComboRidget() {
		super();
		rowClass = null;
		rowObservables = new WritableList();
		selectionObservable = new WritableValue();
		objToStrConverter = new ObjectToStringConverter();
		strToObjConverter = new StringToObjectConverter();
		selectionValidator = new SelectionBindingValidator();
		valueChangeNotifier = new ValueChangeNotifier();
		addPropertyChangeListener(IRidget.PROPERTY_ENABLED, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				applyEnabled();
			}
		});
		this.text = ""; //$NON-NLS-1$
	}

	@Override
	protected void bindUIControl() {
		if (getUIControl() != null) {
			applyText();
			addTextModifyListener();
		}
		if (optionValues != null) {
			// These bindings are only necessary when we have a model
			DataBindingContext dbc = new DataBindingContext();
			if (getUIControl() != null) {
				applyEnabled();
			}
			listBindingExternal = dbc
					.bindList(rowObservables, optionValues,
							new UpdateListStrategy(UpdateListStrategy.POLICY_ON_REQUEST), new UpdateListStrategy(
									UpdateListStrategy.POLICY_ON_REQUEST));
			selectionBindingExternal = dbc.bindValue(selectionObservable, selectionValue, new UpdateValueStrategy(
					UpdateValueStrategy.POLICY_UPDATE).setAfterGetValidator(selectionValidator),
					new UpdateValueStrategy(UpdateValueStrategy.POLICY_ON_REQUEST));
			// Ensure valueChangeNotifier is not added more that once. 
			selectionObservable.removeValueChangeListener(valueChangeNotifier);
			// We have to add the notifier after installing selectionBindingExternal,   
			// to guarantee that the binding updates the selection value before 
			// the valueChangeNotifier sends the selection changed event (bug 287740)
			selectionObservable.addValueChangeListener(valueChangeNotifier);
		}
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (getUIControl() != null) {
			removeTextModifyListener();
		}
		disposeBinding(listBindingExternal);
		listBindingExternal = null;
		disposeBinding(selectionBindingInternal);
		selectionBindingInternal = null;
		disposeBinding(selectionBindingExternal);
		selectionBindingExternal = null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Implementation note: the {@link ISelectionListener} will receive a list
	 * with the selected values. Since the combo only supports a single
	 * selection, the value will be the one element in the list. If there is no
	 * selection or the 'empty' selection entry is selected, the list will be
	 * empty.
	 */
	public void addSelectionListener(ISelectionListener selectionListener) {
		Assert.isNotNull(selectionListener, "selectionListener is null"); //$NON-NLS-1$
		if (selectionListeners == null) {
			selectionListeners = new ListenerList<ISelectionListener>(ISelectionListener.class);
			addPropertyChangeListener(IComboRidget.PROPERTY_SELECTION, new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					notifySelectionListeners(evt.getOldValue(), evt.getNewValue());
				}
			});
		}
		selectionListeners.add(selectionListener);
	}

	public void removeSelectionListener(ISelectionListener selectionListener) {
		if (selectionListeners != null) {
			selectionListeners.remove(selectionListener);
		}
	}

	public void bindToModel(IObservableList optionValues, Class<? extends Object> rowClass, String renderingMethod,
			IObservableValue selectionValue) {
		unbindUIControl();

		this.optionValues = optionValues;
		this.rowClass = rowClass;
		this.renderingMethod = renderingMethod;
		this.selectionValue = selectionValue;

		bindUIControl();
	}

	public void bindToModel(Object listHolder, String listPropertyName, Class<? extends Object> rowClass,
			String renderingMethod, Object selectionHolder, String selectionPropertyName) {
		IObservableList listObservableValue;
		if (AbstractSWTWidgetRidget.isBean(rowClass)) {
			listObservableValue = BeansObservables.observeList(listHolder, listPropertyName);
		} else {
			listObservableValue = PojoObservables.observeList(listHolder, listPropertyName);
		}
		IObservableValue selectionObservableValue;
		if (AbstractSWTWidgetRidget.isBean(selectionHolder.getClass())) {
			selectionObservableValue = BeansObservables.observeValue(selectionHolder, selectionPropertyName);
		} else {
			selectionObservableValue = PojoObservables.observeValue(selectionHolder, selectionPropertyName);
		}
		bindToModel(listObservableValue, rowClass, renderingMethod, selectionObservableValue);
	}

	public Object getEmptySelectionItem() {
		return emptySelection;
	}

	// TODO [ev] should method return null when not bound? See ListRidget#getObservableList()
	public IObservableList getObservableList() {
		return rowObservables;
	}

	public String getText() {
		return text;
	}

	public Object getSelection() {
		Object selection = selectionObservable.getValue();
		return selection == emptySelection ? null : selection;
	}

	public int getSelectionIndex() {
		int result = -1;
		Object selection = selectionObservable.getValue();
		if (emptySelection != selection) {
			result = rowObservables.indexOf(selection);
		}
		return result;
	}

	@Override
	public boolean isDisableMandatoryMarker() {
		return hasInput();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled() && !isOutputOnly();
	}

	public boolean isMarkSelectionMismatch() {
		return markSelectionMismatch;
	}

	public void setEmptySelectionItem(Object emptySelection) {
		this.emptySelection = emptySelection;
	}

	public void setMarkSelectionMismatch(boolean mark) {
		if (mark != markSelectionMismatch) {
			if (mark == true && selectionMismatchMarker == null) {
				selectionMismatchMarker = new ErrorMessageMarker(
						Messages.AbstractComboRidget_markerMessage_selectionMismatch);
			}
			markSelectionMismatch = mark;
			applyMarkSelectionMismatch();
		}
	}

	public void setSelection(Object newSelection) {
		assertIsBoundToModel();
		Object oldSelection = selectionObservable.getValue();
		if (oldSelection != newSelection) {
			if (newSelection == null || !rowObservables.contains(newSelection)) {
				if (getUIControl() != null) {
					clearUIControlListSelection();
				}
				selectionObservable.setValue(null);
			} else {
				selectionObservable.setValue(newSelection);
			}
		}
	}

	public void setSelection(int index) {
		if (index == -1) {
			setSelection(null);
		} else {
			Object newSelection = rowObservables.get(index);
			setSelection(newSelection);
		}
	}

	public void setText(String text) {
		Assert.isNotNull(text);
		if (!StringUtils.equals(text, this.text)) {
			String oldText = this.text;
			this.text = text;
			firePropertyChange(PROPERTY_TEXT, oldText, this.text);
			applyText();
		}
	}

	public void setModelToUIControlConverter(IConverter converter) {
		objToStrConverter = (converter != null) ? converter : new ObjectToStringConverter();
	}

	public void setUIControlToModelConverter(IConverter converter) {
		strToObjConverter = (converter != null) ? converter : new StringToObjectConverter();
	}

	@Override
	public void updateFromModel() {
		assertIsBoundToModel();
		super.updateFromModel();
		// disable the selection binding, because updating the combo items
		// causes the selection to change temporarily
		selectionValidator.enableBinding(false);
		try {
			listBindingExternal.updateModelToTarget();
			items = new ArrayList<String>();
			updateValueToItem();
		} finally {
			selectionValidator.enableBinding(true);
		}
		selectionBindingExternal.updateModelToTarget();
		if (selectionBindingInternal != null) {
			selectionBindingInternal.updateModelToTarget();
		}
		// Bug 304733: clear selection if not in rowObservables
		applyMarkSelectionMismatch();
	}

	// abstract methods
	///////////////////

	/**
	 * Attach a text modify listener to the combo. The listener must invoke
	 * {@code ridget.setText(...)} if the control's text is modified.
	 */
	protected abstract void addTextModifyListener();

	/**
	 * Deselects all selected items in the controls list.
	 */
	protected abstract void clearUIControlListSelection();

	/**
	 * @return The items of the controls list. May be an empty array.
	 */
	protected abstract String[] getUIControlItems();

	/**
	 * @return an observable observing the items attribute of the control.
	 */
	protected abstract IObservableList getUIControlItemsObservable();

	/**
	 * @return an observable observing the selection attribute of the control.
	 */
	protected abstract ISWTObservableValue getUIControlSelectionObservable();

	/**
	 * Return the current text in the combo.
	 * 
	 * @return a String; never null; may be empty
	 * @since 2.0
	 */
	protected abstract String getUIControlText();

	/**
	 * Selects the item in the controls list.
	 */
	protected abstract void selectInUIControl(int index);

	/**
	 * @return The index of the item in the controls list or -1 if no such item
	 *         is found.
	 */
	protected abstract int indexOfInUIControl(String item);

	/**
	 * Removes all of the items from the controls list and clears the controls
	 * text field.
	 */
	protected abstract void removeAllFromUIControl();

	/**
	 * Remove the text modify listener from the combo.
	 * 
	 * @see #addTextModifyListener()
	 * @since 2.0
	 */
	protected abstract void removeTextModifyListener();

	/**
	 * Make the given array the list of selectable items in the combo.
	 * 
	 * @param arrItems
	 *            an array; never null.
	 * @since 1.2
	 */
	protected abstract void setItemsToControl(String[] arrItems);

	/**
	 * Set the given {@code text} to the combo.
	 * 
	 * @param text
	 *            a String; never null; may be empty
	 * @since 2.0
	 */
	protected abstract void setTextToControl(String text);

	// helping methods
	//////////////////

	private void applyEnabled() {
		if (super.isEnabled()) {
			bindControlToSelectionAndUpdate();
		} else {
			unbindControlFromSelectionAndClear();
		}
	}

	private void applyText() {
		if (getUIControl() != null) {
			if (!StringUtils.equals(text, getUIControlText())) {
				setTextToControl(text);
			}
		}
	}

	private void applyMarkSelectionMismatch() {
		Object selection = selectionObservable.getValue();
		if (markSelectionMismatch && selection != null && !rowObservables.contains(selection)) {
			Assert.isNotNull(markSelectionMismatch);
			addMarker(selectionMismatchMarker);
		} else {
			if (selectionMismatchMarker != null) {
				removeMarker(selectionMismatchMarker);
			}
		}
	}

	private void assertIsBoundToModel() {
		if (optionValues == null) {
			throw new BindingException("ridget not bound to model"); //$NON-NLS-1$
		}
	}

	/**
	 * Restores the list of items / selection in the combo, when the ridget is
	 * enabled.
	 */
	private void bindControlToSelectionAndUpdate() {
		if (getUIControl() != null) {
			/* update list of items in combo */
			updateValueToItem();
			/* re-create selectionBinding */
			ISWTObservableValue controlSelection = getUIControlSelectionObservable();
			DataBindingContext dbc = new DataBindingContext();
			selectionBindingInternal = dbc.bindValue(controlSelection, selectionObservable,
					new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE).setConverter(strToObjConverter)
							.setAfterGetValidator(selectionValidator), new UpdateValueStrategy(
							UpdateValueStrategy.POLICY_UPDATE).setConverter(objToStrConverter));
			/* update selection in combo */
			selectionBindingInternal.updateModelToTarget();
		}
	}

	private void disposeBinding(Binding binding) {
		if (binding != null && !binding.isDisposed()) {
			binding.dispose();
		}
	}

	private String getItemFromValue(Object value) {
		Object valueObject = value;
		if (value != null && renderingMethod != null) {
			valueObject = ReflectionUtils.invoke(value, renderingMethod, (Object[]) null);
		}
		if (valueObject == null || valueObject.toString() == null) {
			throw new NullPointerException("The item value for a model element is null"); //$NON-NLS-1$
		}
		return valueObject.toString();
	}

	/**
	 * Returns the value of the given item.
	 * 
	 * @param item
	 *            item of combo box
	 * @return value relevant object; {@code null} or empty string if no
	 *         relevant object exists
	 */
	private Object getValueFromItem(String item) {

		String[] uiItems = getUIControlItems();
		for (int i = 0; i < uiItems.length; i++) {
			if (uiItems[i].equals(item)) {
				return rowObservables.get(i);
			}
		}

		if (rowClass == String.class) {
			return ""; //$NON-NLS-1$
		} else {
			return null;
		}

	}

	private boolean hasInput() {
		Object selection = selectionObservable.getValue();
		return selection != null && selection != emptySelection;
	}

	private void notifySelectionListeners(Object oldValue, Object newValue) {
		if (selectionListeners != null) {
			List<Object> oldSelectionList = new ArrayList<Object>();
			if (oldValue != null) {
				oldSelectionList.add(oldValue);
			}
			List<Object> newSelectionList = new ArrayList<Object>();
			if (newValue != null) {
				newSelectionList.add(newValue);
			}
			SelectionEvent event = new SelectionEvent(this, oldSelectionList, newSelectionList);
			for (ISelectionListener listener : selectionListeners.getListeners()) {
				listener.ridgetSelected(event);
			}
		}
	}

	/**
	 * Clears the list of items in the combo, when the ridget is disabled.
	 */
	private void unbindControlFromSelectionAndClear() {
		if (getUIControl() != null && !super.isEnabled()) {
			/* dispose selectionBinding to avoid sync */
			disposeBinding(selectionBindingInternal);
			selectionBindingInternal = null;
			/* clear combo */
			if (MarkerSupport.isHideDisabledRidgetContent()) {
				removeAllFromUIControl();
			}
		}
	}

	private void updateValueToItem() {
		if (items != null) {
			items.clear();
			try {
				for (Object value : optionValues) {
					String item = (String) objToStrConverter.convert(value);
					items.add(item);
				}
			} finally {
				if (getUIControl() != null) {
					String[] arrItems = items.toArray(new String[items.size()]);
					setItemsToControl(arrItems);
				}
			}
		}
	}

	// helping classes
	//////////////////

	/**
	 * Convert from model object to combo box items (strings).
	 */
	private final class ObjectToStringConverter extends Converter {
		public ObjectToStringConverter() {
			super(Object.class, String.class);
		}

		public Object convert(Object fromObject) {
			return getItemFromValue(fromObject);
		}
	}

	/**
	 * Convert from combo box items (strings) to model objects.
	 */
	private final class StringToObjectConverter extends Converter {
		public StringToObjectConverter() {
			super(String.class, Object.class);
		}

		public Object convert(Object fromObject) {
			return getValueFromItem((String) fromObject);
		}
	}

	/**
	 * This validator can be used to interrupt an update request
	 */
	private final class SelectionBindingValidator implements IValidator {

		private boolean isEnabled = true;

		public IStatus validate(Object value) {
			IStatus result = Status.OK_STATUS;
			// disallow control to ridget update, isEnabled == false || output
			if (!isEnabled) {
				result = Status.CANCEL_STATUS;
			}
			return result;
		}

		void enableBinding(final boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
	}

	/**
	 * Upon a selection change:
	 * <ul>
	 * <li>fire a PROPERTY_SELECTION event and</li>
	 * <li>update the mandatory marker state</li>
	 * </ul>
	 */
	private final class ValueChangeNotifier implements IValueChangeListener {
		public void handleValueChange(ValueChangeEvent event) {
			Object oldValue = event.diff.getOldValue();
			Object newValue = event.diff.getNewValue();
			try {
				firePropertyChange(IComboRidget.PROPERTY_SELECTION, oldValue, newValue);
			} finally {
				disableMandatoryMarkers(hasInput());
				applyMarkSelectionMismatch();
			}
		}
	}

}
