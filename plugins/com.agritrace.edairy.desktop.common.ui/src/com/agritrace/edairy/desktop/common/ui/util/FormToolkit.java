package com.agritrace.edairy.desktop.common.ui.util;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class FormToolkit {

	public final static int COLUMN_MARGIN = 20;
	public final static int FORM_MARGIN = 10;
	public final static int ROW_MARGIN = 10;
	public final static int WIDTH_UNIT = 60;

	final private GridDataFactory labelFactory;
	final private GridDataFactory fieldFactory;

	public FormToolkit() {
		this(WIDTH_UNIT * 2, WIDTH_UNIT * 3);
	}

	public FormToolkit(int labelWidth, int fieldWidth) {
		this(GridDataFactory.swtDefaults().hint(labelWidth, SWT.DEFAULT), GridDataFactory.swtDefaults().hint(
				fieldWidth, SWT.DEFAULT));
	}

	public FormToolkit(GridDataFactory labelFactory, GridDataFactory fieldFactory) {
		this.labelFactory = labelFactory;
		this.fieldFactory = fieldFactory;
	}

	public void setLabelWidth(int width) {

	}

	public void setFieldWidth(int width) {

	}

	public void setWidth(int width) {

	}

	/**
	 * 
	 * @param parent
	 * @param label
	 * @param bindingId
	 * @return
	 * @wbp.factory
	 */
	public DateTime createDateField(Composite parent, String labelText, String bindingId) {
		createLabel(parent, labelText, (parent instanceof Group));		
		return createDate(parent, bindingId);
	}
	public Text createDateTextField(Composite parent, String labelText, String bindingId) {
		createLabel(parent, labelText, (parent instanceof Group));		
		return createDateText(parent, bindingId);
	}

	

	/**
	 * 
	 * @param parent
	 * @param label
	 * @param bindingId
	 * @return
	 * @wbp.factory
	 */
	public Composite createWrappedDateField(Composite parent, String label, String bindingId) {
		Composite wrapper = UIControlsFactory.createComposite(parent);
		createLabel(wrapper, label, (parent instanceof Group));		
		createDate(wrapper, bindingId);
		GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(wrapper);
		return wrapper;
	}

	/**
	 * 
	 * @param parent
	 * @param label
	 * @param bindingId
	 * @return
	 * @wbp.factory
	 */
	public Text createTextField(Composite parent, String label, String bindingId) {
		createLabel(parent, label, (parent instanceof Group));		
		return createText(parent, bindingId);		
	}

	/**
	 * 
	 * @param parent
	 * @param label
	 * @param bindingId
	 * @return
	 * @wbp.factory
	 */
	public Composite createWrappedTextField(Composite parent, String label, String bindingId) {
		Composite wrapper = UIControlsFactory.createComposite(parent);
		createLabel(wrapper, label, (parent instanceof Group));		
		createText(wrapper, bindingId);
		wrapper.setBackground(parent.getBackground());
		return wrapper;
	}


	/**
	 * 
	 * @param parent
	 * @param label
	 * @param bindingId
	 * @return
	 * @wbp.factory
	 */
	public CCombo createComboField(Composite parent, String label, String bindingId) {
		createLabel(parent, label, (parent instanceof Group));		
		return createCombo(parent, bindingId);		
	}

	/**
	 * 
	 * @param parent
	 * @param label
	 * @param bindingId
	 * @return
	 * @wbp.factory
	 */
	public Composite createWrappedComboField(Composite parent, String label, String bindingId) {
		Composite wrapper = UIControlsFactory.createComposite(parent);
		createLabel(wrapper, label, (parent instanceof Group));		
		createCombo(wrapper, bindingId);
		wrapper.setBackground(parent.getBackground());
		return wrapper;
	}


	private void createLabel(Composite parent, String labelText, boolean parentIsGroup) {
		Label label;
		
		if (parentIsGroup) {
			label = new Label(parent, SWT.NONE);
			label.setText(labelText);
			label.setBackground(parent.getBackground());
		} else {
			label = UIControlsFactory.createLabel(parent, labelText);
		}
		label.setLayoutData(labelFactory.create());
	}
	private DateTime createDate(Composite parent, String bindingId) {
		DateTime field;
		field = UIControlsFactory.createDate(parent, SWT.MEDIUM | SWT.BORDER, bindingId);
		field.setLayoutData(fieldFactory.create());
		return field;
	}
	private Text createDateText(Composite parent, String bindingId) {
		Text field;
		field = UIControlsFactory.createTextDate(parent, bindingId);
		field.setLayoutData(fieldFactory.create());
		return field;
	}
	private Text createText(Composite parent, String bindingId) {
		Text field;
		field = UIControlsFactory.createText(parent, SWT.MEDIUM | SWT.BORDER, bindingId);
		field.setLayoutData(fieldFactory.create());
		return field;
	}
	private CCombo createCombo(Composite parent, String bindingId) {
		CCombo field;
		field = UIControlsFactory.createCCombo(parent, bindingId);
		field.setLayoutData(fieldFactory.create());
		return field;
	}


}
