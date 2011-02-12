package com.agritrace.edairy.desktop.common.ui.controls.fieldgroup;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FieldGroupRidget extends AbstractCompositeRidget implements IFieldGroupRidget, ICompositeRidget {

	private List<Field<?>> fieldList;
	private Map<String, IRidget> ridgets = new HashMap<String, IRidget>();;

	@Override
	protected void checkUIControl(Object uiControl) {
		if (uiControl == null) {
			return;
		}
		if (!(uiControl instanceof FieldGroup)) {
			throw new AssertionError("Widget " + uiControl + " not proper type!");
		}
	}

	@Override
	public FieldGroup getUIControl() {
		return (FieldGroup) super.getUIControl();
	}

	@Override
	public void bindToModel(List<Field<?>> observableList) {
		if (observableList == fieldList)
			return;

		unbindUIControl();
		fieldList = observableList;
// fieldList.clear();
// fieldList.addAll(observableList);
//		ridgets.clear();
		bindUIControl();
	}

	@Override
	protected void bindUIControl() {
	}

	private void bindRidget(IRidget ridget, Field<?> field) {
		if (ridget instanceof IValueRidget) {
			IValueRidget valueRidget = (IValueRidget) ridget;
			valueRidget.bindToModel(field, "value");
		} else if (ridget instanceof IComboRidget) {
			IComboRidget valueRidget = (IComboRidget) ridget;
			valueRidget.setText((String) field.value);
			valueRidget.bindToModel(field, "options", String.class, null, field, "value");
			valueRidget.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent arg0) {
					System.err.println(arg0);
				}
			});
		}
	}

	@Override
	public void updateFromModel() {
		FieldGroup uiControl = getUIControl();
		System.err.println("FieldGroupRidget: bindUIControl: " + uiControl);
		if (uiControl != null) {
			ridgets.clear();
			uiControl.reset();
			if (fieldList != null) {
				for (Field<?> field : fieldList) {
					Control control = uiControl.addField(field);
					IRidget ridget = SwtRidgetFactory.createRidget(control);
					ridgets.put(field.name, ridget);
					bindRidget(ridget, field);
				}
			}
		}
		for (IRidget ridget : ridgets.values()) {
			ridget.updateFromModel();
		}
	}

	/**
	 * Updates the enabled state of the complex UI control (and of the UI controls it contains). This default
	 * implementation does nothing and should be overridden by subclasses.
	 */
	protected void updateEnabled() {
		FieldGroup control = getUIControl();
		if (control != null) {
			Collection<? extends IRidget> ridgets = getRidgets();
			for (IRidget ridget : ridgets) {
				ridget.setEnabled(isEnabled());
			}
			control.setEnabled(isEnabled());
		}
	}

	@Override
	protected void updateToolTipText() {
		Composite control = getUIControl();
		if (control != null) {
			control.setToolTipText(getToolTipText());
		}
	}

	@Override
	protected void updateVisible() {
		Composite control = getUIControl();
		if (control != null) {
			control.setVisible(!isMarkedHidden());
		}
	}

	@Override
	protected boolean isUIControlVisible() {
		return getUIControl().isVisible();
	}

	@Override
	public void layout() {
		FieldGroup uiControl = (FieldGroup) getUIControl();
		if (uiControl != null) {
			uiControl.layout(true);
			uiControl.redraw();
		}
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Display display = Display.getDefault();
		SwtControlRidgetMapper.getInstance().addMapping(FieldGroup.class, FieldGroupRidget.class);
		try {
			final Shell shell = UIControlsFactory.createShell(display);
			shell.setText("Just Testing");
			GridLayoutFactory.fillDefaults().margins(10, 10).spacing(20, 10).applyTo(shell);

			// Widgets
			final FieldGroup fieldGroup = new FieldGroup(shell, SWT.NONE);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(fieldGroup);

			final Button addButton = new Button(shell, SWT.PUSH | SWT.FLAT);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(addButton);

			final Button showButton = new Button(shell, SWT.PUSH | SWT.FLAT);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(showButton);

			final Text valuesLabel = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.READ_ONLY);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(valuesLabel);

			// Ridgets
			final IActionRidget addButtonRidget = (IActionRidget) SwtRidgetFactory.createRidget(addButton);
			final IActionRidget showButtonRidget = (IActionRidget) SwtRidgetFactory.createRidget(showButton);
			final IFieldGroupRidget fieldGroupRidget = (IFieldGroupRidget) SwtRidgetFactory.createRidget(fieldGroup);

			// configure
			final List<Field<?>> model = new ArrayList<Field<?>>();

			int count = 100;
			model.add(new Field<String>("id" + ++count, FieldType.TEXT, "Test " + count, "A string"));
			model.add(new Field<Date>("id" + ++count, FieldType.DATE, "Test " + count, new Date()));
			model.add(new Field<Integer>("id" + ++count, FieldType.NUMBER, "Test " + count, 112358));

			fieldGroupRidget.bindToModel(model);
			fieldGroupRidget.updateFromModel();

			addButtonRidget.setText("Add Field");
			addButtonRidget.addListener(new IActionListener() {
				int count = 0;

				@Override
				public void callback() {
					model.add(new Field("id" + count, FieldType.TEXT, "Test " + count++));
					fieldGroupRidget.updateFromModel();
					shell.layout();
				}
			});

			showButtonRidget.setText("Show Form");
			showButtonRidget.addListener(new IActionListener() {
				@Override
				public void callback() {
					String s = "";
					for (Field<?> f : model) {
						s += f.name;
						s += " : ";
						s += f.value == null ? "(null)" : f.value.toString();
						s += " ::::\n";
					}
					valuesLabel.setText(s);
					System.out.println(s);

					shell.pack();
				}
			});

			shell.setSize(200, 500);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} finally {
			display.dispose();
		}
	}

	@Override
	public Map<String, ?> getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}
