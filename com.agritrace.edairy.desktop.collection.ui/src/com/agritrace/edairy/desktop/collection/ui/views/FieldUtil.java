package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;

public class FieldUtil {
	
	public static final int MINIMUM_LABEL_WIDTH = 70;
	public static final int STD_FIELD_WIDTH = 70;

	public static final GridDataFactory gdf = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false);
	public static final GridDataFactory labelGDF = GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1);

	/**
	 * @wbp.factory
	 */
	public static Control addLabeledDateField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final DateTime text = UIControlsFactory.createDate(parent, SWT.BORDER, widgetID);
		GridDataFactory.fillDefaults().minSize(STD_FIELD_WIDTH, -1).grab(true, false).align(SWT.END, SWT.FILL).applyTo(text);
//		GridDataFactory.fillDefaults().minSize(60, -1).grab(true, false).applyTo(field);

		return text;
	}
	
	/**
	 * @wbp.factory
	 */
	public static Control addLabeledTextField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final Text text = UIControlsFactory.createText(parent, SWT.BORDER, widgetID);
		GridDataFactory.fillDefaults().minSize(STD_FIELD_WIDTH, -1).grab(true, false).align(SWT.END, SWT.FILL).applyTo(text);
		
		return text;
	}
	
	/**
	 * @wbp.factory
	 */
	public static Control addLabeledDecimalTextField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final Text text = UIControlsFactory.createTextDecimal(parent, widgetID);
		GridDataFactory.fillDefaults().minSize(STD_FIELD_WIDTH, -1).grab(true, false).align(SWT.END, SWT.FILL).applyTo(text);
		
		return text;
	}
	
	/**
	 * @wbp.factory
	 */
	public static Control addLabeledComboField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final CCombo field = UIControlsFactory.createCCombo(parent, ViewWidgetId.binCombo);
		GridDataFactory.fillDefaults().minSize(STD_FIELD_WIDTH, -1).grab(true, false).applyTo(field);
		
		return field;
		
	}

	
	/**
	 * @wbp.factory
	 */
	public static Control addLabeledBooleanField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		Button control = UIControlsFactory.createButtonCheck(parent, "", widgetID);
		GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.BEGINNING).applyTo(control);

		return control;
	}
}