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
package org.eclipse.riena.internal.ui.ridgets.swt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.DateAndTimeObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;

import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractEditableRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTWidgetRidget;

/**
 * Ridget for {@link DateTime} widgets.
 */
public class DateTimeRidget extends AbstractEditableRidget implements IDateTimeRidget {

	/**
	 * Holds the date value for this ridget.
	 * <p>
	 * Do not access directly. Use {@link #getRidgetObservable()}.
	 */
	private IObservableValue ridgetObservable;
	private DataBindingContext dbc;
	private Binding controlBinding;

	public DateTimeRidget() {
		addPropertyChangeListener(IMarkableRidget.PROPERTY_OUTPUT_ONLY, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				updateEditable();
			}
		});
		addPropertyChangeListener(IRidget.PROPERTY_ENABLED, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				updateEditable();
			}
		});
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTWidgetRidget.assertType(uiControl, DateTime.class);
	}

	@Override
	protected void bindUIControl() {
		final DateTime control = getUIControl();
		if (control != null) {
			updateEditable();

			dbc = new DataBindingContext();
			final IObservableValue timeObservable;
			final IObservableValue dateObservable;
			final Date nonNullDate = getNonNullDate(getDate());
			if (isTimeControl(control)) {
				// it is a time widget
				timeObservable = WidgetProperties.selection().observe(control);
				timeObservable.setValue(nonNullDate);
				dateObservable = new WritableValue(timeObservable.getRealm(), nonNullDate, Date.class);
			} else {
				// it is  date/calendar widget
				dateObservable = WidgetProperties.selection().observe(control);
				dateObservable.setValue(nonNullDate);
				timeObservable = new WritableValue(dateObservable.getRealm(), nonNullDate, Date.class);
			}
			controlBinding = dbc.bindValue(new DateAndTimeObservableWithNullConversion(dateObservable, timeObservable),
					getRidgetObservable(), new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
							.setAfterGetValidator(new EditRulesValidator()), new UpdateValueStrategy(
							UpdateValueStrategy.POLICY_ON_REQUEST));
		}
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (dbc != null) {
			dbc.dispose();
			dbc = null;
		}
	}

	@Override
	protected final IObservableValue getRidgetObservable() {
		if (ridgetObservable == null) {
			ridgetObservable = new WritableValue(null, Date.class);
			ridgetObservable.addValueChangeListener(new IValueChangeListener() {
				public void handleValueChange(ValueChangeEvent event) {
					Object oldValue = event.diff.getOldValue();
					Object newValue = event.diff.getNewValue();
					firePropertyChange(IDateTimeRidget.PROPERTY_DATE, oldValue, newValue);
				}
			});
		}
		return ridgetObservable;
	}

	@Override
	public DateTime getUIControl() {
		return (DateTime) super.getUIControl();
	}

	@Override
	public void bindToModel(IObservableValue observableValue) {
		unbindUIControl();

		Assert.isNotNull(observableValue);
		super.bindToModel(observableValue);

		bindUIControl();
	}

	@Override
	public void bindToModel(Object valueHolder, String valuePropertyName) {
		if (AbstractSWTRidget.isBean(valueHolder.getClass())) {
			bindToModel(BeansObservables.observeValue(valueHolder, valuePropertyName));
		} else {
			bindToModel(PojoObservables.observeValue(valueHolder, valuePropertyName));
		}
	}

	public Date getDate() {
		return (Date) getRidgetObservable().getValue();
	}

	public String getText() {
		Date date = getDate();
		return date != null ? SimpleDateFormat.getInstance().format(date) : ""; //$NON-NLS-1$
	}

	public boolean isDirectWriting() {
		return true;
	}

	@Override
	public boolean isDisableMandatoryMarker() {
		return true;
	}

	public boolean revalidate() {
		Date date = getDate();
		IStatus onUpdate = checkOnUpdateRules(date, new ValidationCallback(false));
		if (onUpdate.isOK()) {
			getValueBindingSupport().updateFromTarget();
		}
		return !isErrorMarked();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Implementation note: since the underlying DateTime widget cannot be
	 * empty, a {@code null} date value will cause the widget to show the
	 * 'empty' date, but getDate() will correctly return null.
	 * <p>
	 * Invoking this method will copy the given date into the ridget and the
	 * widget regardless of the validation outcome. If the date does not pass
	 * validation the error marker will be set and the date will <b>not</b> be
	 * copied into the model. If validation passes the date will be copied into
	 * the model as well.
	 * <p>
	 * Because of limitations of the underlying SWT {@link DateTime} widget, the
	 * timestamp will be formatted according to the date/time format of the
	 * operating system. See <a href="http://bugs.eclipse.org/248075">Bug
	 * #248075</a>.
	 */
	public void setDate(Date date) {
		getRidgetObservable().setValue(date);
		if (controlBinding != null) {
			controlBinding.updateModelToTarget(); // update widget
		}
		IStatus status = checkAllRules(date, new ValidationCallback(false));
		if (status.isOK()) {
			getValueBindingSupport().updateFromTarget();
		}
	}

	/** Not supported. */
	public void setDirectWriting(boolean directWriting) {
		throw new UnsupportedOperationException();
	}

	/** Not supported. */
	public void setInputToUIControlConverter(IConverter converter) {
		throw new UnsupportedOperationException();
	}

	/** Not supported. */
	public void setText(String text) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateFromModel() {
		super.updateFromModel();
		if (controlBinding != null) {
			controlBinding.updateModelToTarget(); // updateWidget
		}
		checkAllRules(getDate(), new ValidationCallback(false));
	}

	// helping methods
	//////////////////

	/**
	 * Return {@code date} if non-null, otherwise return the 'empty' date value.
	 * 
	 * @return {@code date} or new Date instance
	 */
	private Date getNonNullDate(Date date) {
		return date != null ? date : new Date(0);
	}

	private boolean isTimeControl(DateTime control) {
		return (control.getStyle() & SWT.TIME) != 0;
	}

	private void updateEditable() {
		DateTime control = getUIControl();
		if (control != null && !control.isDisposed()) {
			control.setEnabled(isOutputOnly() || !isEnabled() ? false : true);
		}
	}

	// helping classes
	//////////////////

	/**
	 * DateAndTimeObservable that handles doSetValue(null) gracefully.
	 */
	private final class DateAndTimeObservableWithNullConversion extends DateAndTimeObservableValue {
		public DateAndTimeObservableWithNullConversion(IObservableValue dateObservable, IObservableValue timeObservable) {
			super(dateObservable, timeObservable);
		}

		@Override
		protected void doSetValue(Object value) {
			super.doSetValue(getNonNullDate((Date) value));
		}
	}

	/**
	 * Validator that delegates to the 'on edit' validators for this ridget.
	 */
	private final class EditRulesValidator implements IValidator {
		public IStatus validate(Object value) {
			return checkOnEditRules(value, new ValidationCallback(true));
		}
	}

}
