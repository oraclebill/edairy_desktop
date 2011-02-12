package com.agritrace.edairy.desktop.common.ui.controls.fieldgroup;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

public class FieldGroup extends Composite {

	private boolean locked;
	final private List<Control> boundControls;
	final private List<Control> internalControls;

	public FieldGroup(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout());
		boundControls = new LinkedList<Control>();
		internalControls = new LinkedList<Control>();
		locked = false;

		System.err.println("FieldGroup() parent: " + parent);
	}

	public void setFields(Field<?>[] fieldList) {
		Assert.isLegal(!locked);

		reset();

		for (Field field : fieldList) {
			addField(field);
		}
		layout(true);
	}

	public void reset() {
		for (Control control : internalControls) {
			control.dispose();
		}
		internalControls.clear();
		boundControls.clear();
	}

	@SuppressWarnings("deprecation")
	public Control addField(Field<?> field) {
		Control control;

		if (locked)
			throw new IllegalStateException("Widget is locked!");

		System.err.println("Adding field: " + field.name);

		Composite parent = UIControlsFactory.createComposite(this);
		parent.setLayout(new GridLayout(2, false));
		internalControls.add(parent);

		// create label
		GridDataFactory.swtDefaults().applyTo(UIControlsFactory.createLabel(parent, field.label, "label" + field.name));

		switch (field.type) {
		case TEXT:
		case NUMBER:
			Text textControl = UIControlsFactory.createText(parent, SWT.NONE, field.name);
			if (field.value != null) {
				textControl.setText((String) field.value.toString());
			}
			control = textControl;
			break;

		case DATETIME:
		case DATE:
		case TIME:
			DateTime dateControl = UIControlsFactory.createDate(parent, SWT.NONE, field.name);
			if (field.value != null) {
				Date date = (Date) field.value;
				dateControl.setYear(date.getYear());
				dateControl.setMonth(date.getMonth());
				dateControl.setDay(date.getDay());
				dateControl.setHours(date.getHours());
				dateControl.setMinutes(date.getMinutes());
				dateControl.setSeconds(date.getSeconds());
			}
			control = dateControl;
			break;

		case COMBO:
			Combo ccontrol = UIControlsFactory.createCombo(parent, field.name);
			if (field.value != null) {
				ccontrol.setText((String) field.value);
			}
			control = ccontrol;
			break;

		case BOOLEAN:
			Button bcontrol = UIControlsFactory.createButtonCheck(parent, field.label, field.name);
			if (field.value != null) {
				bcontrol.setSelection((Boolean) field.value);
			}
			control = bcontrol;
			break;

		default:
			throw new IllegalArgumentException("Field type " + field.type + " not supported");
		}

		GridDataFactory.swtDefaults().applyTo(control);

		boundControls.add(control);

		return control;
	}

	HashMap<String, Object> getValue() {
		final HashMap<String, Object> values = new HashMap<String, Object>();
		for (Control ctrl : boundControls) {
			String id = (String) ctrl.getData(SWTBindingPropertyLocator.BINDING_PROPERTY);
			Object value = widgetValue(ctrl);
			Assert.isNotNull(value, "Widget type " + ctrl + " [" + id + "] not supported");
			values.put(id, value);
		}
		return values;
	}

	private Object widgetValue(Control ctrl) {
		Object value = null;
		if (ctrl instanceof Text) {
			value = ((Text) ctrl).getText();
		} else if (ctrl instanceof DateTime) {
			DateTime dateCtrl = (DateTime) ctrl;
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, dateCtrl.getYear());
			cal.set(Calendar.MONTH, dateCtrl.getMonth());
			cal.set(Calendar.DAY_OF_WEEK, dateCtrl.getDay());
			cal.set(Calendar.HOUR_OF_DAY, dateCtrl.getHours());
			cal.set(Calendar.MINUTE, dateCtrl.getMinutes());
			cal.set(Calendar.SECOND, dateCtrl.getSeconds());
			value = cal.getTime();
		} else if (ctrl instanceof Combo) {
			value = ((Combo) ctrl).getText();
		} else if (ctrl instanceof Button) {
			value = ((Button) ctrl).getSelection();
		}
		return value;
	}
}
