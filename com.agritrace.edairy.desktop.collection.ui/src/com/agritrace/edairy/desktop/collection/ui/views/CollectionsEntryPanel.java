package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;

public class CollectionsEntryPanel extends Composite implements TraverseListener {

	private static final String MILK_ENTRY_GROUP_TITLE = "Add New Entry";
	private static final String BIN_LABEL = "Bin :";
	private static final String CAN_ID_LABEL = "CAN :";
	private static final String MEMBER_ID_LABEL = "Member # :";
	private static final String NPR_COLUMN_HEADER = "NPR Missing";

	private static final String QUANTITY_LABEL = "Quantity :";

	private static final String REJECTED_COLUMN_HEADER = "Rejected";

	private static final int MINIMUM_LABEL_WIDTH = 70;
	private static final int STD_FIELD_WIDTH = 70;

	private static final GridDataFactory gdf = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false);
	private static final GridDataFactory labelGDF = GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1);

	
	public CollectionsEntryPanel(Composite parent, int style) {
		
		super(parent, style);
		setLayout(new FillLayout());
		
		final Group group = UIControlsFactory.createGroup(this, MILK_ENTRY_GROUP_TITLE);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(2).applyTo(group);
		
		addPrimaryGroup(group);
		addButtons(group);
		addQualityGroup(group);
		
		for (Control control : this.getChildren()) {
			if (control.isListening(SWT.TRAVERSE_RETURN)) {
				control.addTraverseListener(this);
			}
		}
		
		pack();
	}
	
	private void addPrimaryGroup(Composite group) {
		GridDataFactory gdf = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false);
		GridDataFactory labelGDF = GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1);

		final Group panel = UIControlsFactory.createGroup(group, "Milk");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(1, 1).applyTo(panel);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(8).applyTo(panel);
		
		addLabeledComboField(panel, BIN_LABEL, ViewWidgetId.binCombo).addTraverseListener(this);
		addLabeledTextField(panel, CAN_ID_LABEL, ViewWidgetId.canIdText).addTraverseListener(this);
		addLabeledTextField(panel, MEMBER_ID_LABEL, ViewWidgetId.memberIdText).addTraverseListener(this);
		addLabeledDecimalTextField(panel, QUANTITY_LABEL, ViewWidgetId.quantityText).addTraverseListener(this);
		
		Label filler = UIControlsFactory.createLabel(panel, "");
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).span(2, 1).applyTo(filler);
		
		Label memberName = UIControlsFactory.createLabel(panel, "member name", "member-name");
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).span(2, 1).applyTo(memberName);

		final Composite buttonComposite = UIControlsFactory.createComposite(panel);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).span(4, 1).applyTo(buttonComposite);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(2).applyTo(buttonComposite);

		final Button nprMissingButton = UIControlsFactory.createButtonCheck(buttonComposite, NPR_COLUMN_HEADER,
				ViewWidgetId.nprMissingCombo);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(nprMissingButton);
		nprMissingButton.addTraverseListener(this);

		final Button rejectedButton = UIControlsFactory.createButtonCheck(buttonComposite, REJECTED_COLUMN_HEADER,
				ViewWidgetId.rejectedCombo);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(rejectedButton);
		rejectedButton.addTraverseListener(this);
	}

	private void addQualityGroup(Composite group) {

		final Composite checkPanel = UIControlsFactory.createComposite(group);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(checkPanel);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(3).applyTo(checkPanel);

		Label label = UIControlsFactory.createLabel(checkPanel, "Collect Milk Quality Data? ");
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.TOP).applyTo(label);
		
		Button control = UIControlsFactory.createButtonCheck(checkPanel, "", "display-quality-controls-button");
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.TOP).applyTo(control);

		final Group qualityPanel = UIControlsFactory.createGroup(checkPanel, "", "quality-group");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(1, 1).applyTo(qualityPanel);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(6).applyTo(qualityPanel);
				
		addLabeledTextField(qualityPanel, "Milk Fat % : ", "milk-fat-percent-text");
		addLabeledTextField(qualityPanel, "Alcohol % : ", "alcohol-percent-text");
		addLabeledBooleanField(qualityPanel, "Water Added? : ", "added-water-checkbox");
	}
	
	private void addButtons(Composite parent) {
		Composite group = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.swtDefaults().applyTo(group);
		GridDataFactory.fillDefaults().span(1,2).applyTo(group);
		
		final Button addButton = UIControlsFactory.createButton(group, "Add", ViewWidgetId.addButton);
		addButton.setToolTipText("Click here to add a new collection line.");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).hint(50, SWT.DEFAULT).applyTo(addButton);

		final Button clearButton = UIControlsFactory.createButton(group, "Clear", ViewWidgetId.entryInputClear);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).hint(50, SWT.DEFAULT).applyTo(clearButton);
		group.setTabList(new Control[]{addButton});
		
	}
	
	/**
	 * @wbp.factory
	 */
	private static Control addLabeledTextField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final Text text = UIControlsFactory.createText(parent, SWT.BORDER, widgetID);
		GridDataFactory.fillDefaults().minSize(STD_FIELD_WIDTH, -1).grab(true, false).align(SWT.END, SWT.FILL).applyTo(text);
		
		return text;
	}
	
	/**
	 * @wbp.factory
	 */
	private static Control addLabeledDecimalTextField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final Text text = UIControlsFactory.createTextDecimal(parent, widgetID);
		GridDataFactory.fillDefaults().minSize(STD_FIELD_WIDTH, -1).grab(true, false).align(SWT.END, SWT.FILL).applyTo(text);
		
		return text;
	}
	
	/**
	 * @wbp.factory
	 */
	private static Control addLabeledComboField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		final CCombo field = UIControlsFactory.createCCombo(parent, ViewWidgetId.binCombo);
		GridDataFactory.fillDefaults().minSize(60, -1).grab(true, false).applyTo(field);
		
		return field;
		
	}

	
	/**
	 * @wbp.factory
	 */
	private static Control addLabeledBooleanField(Composite parent, String labelTxt, String widgetID) {
		final Label label = UIControlsFactory.createLabel(parent, labelTxt);
		labelGDF.applyTo(label);

		Button control = UIControlsFactory.createButtonCheck(parent, "", widgetID);
		GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.BEGINNING).applyTo(control);

		return control;
	}

	@Override
	public void keyTraversed(TraverseEvent e) {
		if (e.detail == SWT.TRAVERSE_RETURN) {
			e.detail = SWT.TRAVERSE_TAB_NEXT;
			e.doit = true;
		}
	}
}
