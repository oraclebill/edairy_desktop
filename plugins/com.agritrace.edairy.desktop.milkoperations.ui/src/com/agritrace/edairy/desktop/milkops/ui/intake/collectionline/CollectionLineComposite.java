package com.agritrace.edairy.desktop.milkops.ui.intake.collectionline;

import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.milkops.ui.intake.ViewWidgetId;
import com.agritrace.edairy.desktop.milkops.ui.util.FieldUtil;

public class CollectionLineComposite extends Composite implements TraverseListener, IComplexComponent
{

	static {
		SwtControlRidgetMapper.getInstance().addMapping(CollectionLineComposite.class, CollectionLineRidget.class);
	}

	private static final String	BIN_LABEL				= "Bin No.";
	private static final String	CAN_ID_LABEL			= "CAN No.";
	private static final String	MEMBER_ID_LABEL			= "Member No.";
	private static final String	MILK_ENTRY_GROUP_TITLE	= "Add New Entry";
	private static final String	QUANTITY_LABEL			= "Quantity";
	private static final String	MPR_COLUMN_HEADER		= "MPR Present";
	private static final String	REJECTED_COLUMN_HEADER	= "Quality";


	private Control				memberIdWidget;
	private Control				canWidget;
	private Control				binWidget;
	private Control				qtyWidget;
	private Button				nprMissingButton;
	private Button				rejectedButton;
	private Button				addButton;
	private Button				clearButton;

	public CollectionLineComposite(Composite parent, int style)
	{
		super(parent, style | SWT.NONE);
		setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		
		final Group group = UIControlsFactory.createGroup(this, MILK_ENTRY_GROUP_TITLE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(group);

		final Composite primaryGroup = addPrimaryGroup(group);
		final Composite buttonsGroup = addButtons(group);
		final Composite qualityGroup = addQualityGroup(group);

		group.setTabList(new Control[] { primaryGroup, buttonsGroup, qualityGroup });

		for (final Control control : this.getChildren()) {
			if (control.isListening(SWT.TRAVERSE_RETURN)) {
				control.addTraverseListener(this);
			}
		}

 		group.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

//		addPhotoPanel(this);
//		pack();
	}

	@Override
	public void keyTraversed(TraverseEvent e)
	{
// log(LogService.LOG_DEBUG, "event in : " + e);
		if (e.detail == SWT.TRAVERSE_RETURN) {
			if (e.widget == qtyWidget && addButton.setFocus()) {
				e.detail = SWT.TRAVERSE_NONE;
				e.doit = true;
			} else {
				e.detail = SWT.TRAVERSE_TAB_NEXT;
				e.doit = true;
			}
		}
// log(LogService.LOG_DEBUG, "event out: " + e);
	}

	private Composite addButtons(Composite parent)
	{
		final Composite group = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(group);
		GridDataFactory.fillDefaults().span(1, 2).applyTo(group);

		addButton = UIControlsFactory.createButton(group, "Add", ViewWidgetId.addButton);
		addButton.setToolTipText("Click here to add a new collection line.");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BOTTOM).hint(50, SWT.DEFAULT).applyTo(addButton);

		clearButton = UIControlsFactory.createButton(group, "Clear", ViewWidgetId.entryInputClear);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BOTTOM).hint(50, SWT.DEFAULT).applyTo(clearButton);
		group.setTabList(new Control[] { addButton });
		return group;
	}

	private Control addPhotoPanel(Composite parent)
	{
//		final Label imageLabel = UIControlsFactory.createLabel(parent, "", SWT.BORDER, ViewWidgetId.photoLabel);
//		final Label imageLabel = new Label(parent, SWT.NONE);
//		imageLabel.setVisible(false);
//		SWTBindingPropertyLocator.getInstance().setBindingProperty(imageLabel, ViewWidgetId.photoLabel);
//		GridDataFactory.fillDefaults().hint(60, 80).applyTo(imageLabel);
//		if (!Beans.isDesignTime()) {
//			imageLabel.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.demo.riena",
//					"resources/farmerheadshot.png"));
//		}
//		return imageLabel;
		return null;
	}

	private Composite addPrimaryGroup(Composite group)
	{
		final FieldUtil fu = new FieldUtil();
		final Group panel = new Group(group, SWT.NONE);
		panel.setText("Milk");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(1, 1).applyTo(panel);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(8).applyTo(panel);

		binWidget = fu.addLabeledCompletionComboField(panel, BIN_LABEL, ViewWidgetId.binCombo);
		binWidget.addTraverseListener(this);

		memberIdWidget = fu.addLabeledCompletionComboField(panel, MEMBER_ID_LABEL, ViewWidgetId.memberIdText, true);
		// memberIdWidget.setSize(70, 19);
		memberIdWidget.addTraverseListener(this);

		canWidget = fu.addLabeledTextField(panel, CAN_ID_LABEL, ViewWidgetId.canIdText);
		canWidget.addTraverseListener(this);

		qtyWidget = fu.addLabeledDecimalTextField(panel, QUANTITY_LABEL, ViewWidgetId.quantityText);
		qtyWidget.addTraverseListener(this);

		panel.setTabList(new Control[] { binWidget, memberIdWidget, canWidget, qtyWidget });

		final Composite buttonComposite = new Composite(panel, SWT.NONE);
		// buttonComposite.setSize(162, 18);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).grab(true, false).span(4, 1).applyTo(buttonComposite);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(2).applyTo(buttonComposite);

		nprMissingButton = new Button(buttonComposite, SWT.CHECK);
		nprMissingButton.setText(MPR_COLUMN_HEADER);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(nprMissingButton, ViewWidgetId.nprMissingCombo);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(nprMissingButton);
		nprMissingButton.addTraverseListener(this);

		rejectedButton = new Button(buttonComposite, SWT.CHECK);
		rejectedButton.setText(REJECTED_COLUMN_HEADER);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(rejectedButton, ViewWidgetId.rejectedCombo);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(rejectedButton);
		rejectedButton.addTraverseListener(this);

		final Label filler = new Label(panel, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).grab(true, false).span(1, 1).applyTo(filler);

		final Label memberName = new Label(panel, SWT.BORDER);
		memberName.setText("<member name>");
		SWTBindingPropertyLocator.getInstance().setBindingProperty(memberName, ViewWidgetId.memberNameText);
		memberName.setAlignment(SWT.RIGHT);
		memberName.setSize(175, 18);
		memberName.setLocation(427, 28);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(3, 1).applyTo(memberName);

		return panel;
	}

	private static Composite addQualityGroup(Composite group)
	{

		final Composite checkPanel = new Composite(group, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(checkPanel);
		checkPanel.setLayout(new FormLayout());
		// GridLayoutFactory.fillDefaults().margins(2,
		// 2).numColumns(3).applyTo(checkPanel);

		final Label label = new Label(checkPanel, SWT.NONE);
		label.setText("Collect Milk Quality Data? ");
		final FormData fd_label = new FormData();
		// fd_label.bottom = new FormAttachment(0);
		// fd_label.right = new FormAttachment(0);
		fd_label.top = new FormAttachment(0, 10);
		fd_label.left = new FormAttachment(0, 15);
		label.setLayoutData(fd_label);
		// GridDataFactory.fillDefaults().align(SWT.LEFT,
		// SWT.TOP).applyTo(label);

		final Button control = new Button(checkPanel, SWT.CHECK);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, "display-quality-controls-button");
		
		final FormData fd_control = new FormData();
		// fd_control.top = new FormAttachment(0);
		// fd_control.right = new FormAttachment(0);
		fd_control.bottom = new FormAttachment(label, 2, SWT.BOTTOM);
		fd_control.left = new FormAttachment(label, 5, SWT.RIGHT);
		control.setLayoutData(fd_control);
		// GridDataFactory.fillDefaults().align(SWT.LEFT,
		// SWT.TOP).applyTo(control);

		final Group qualityPanel = new Group(checkPanel, SWT.NONE);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(qualityPanel, "quality-group");
		final FormData fd_qualityPanel = new FormData();
		// fd_qualityPanel.bottom = new FormAttachment(0);
		// fd_qualityPanel.right = new FormAttachment(0);
		// fd_qualityPanel.top = new FormAttachment(0);
		fd_qualityPanel.left = new FormAttachment(control, 18, SWT.RIGHT);
		qualityPanel.setLayoutData(fd_qualityPanel);
		// GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
		// true).span(1, 1).applyTo(qualityPanel);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(6).applyTo(qualityPanel);

		final FieldUtil fu = new FieldUtil(10, SWT.DEFAULT);
		fu.addLabeledDecimalTextField(qualityPanel, "Milk Fat % : ", "milk-fat-percent-text");
		fu.addLabeledDecimalTextField(qualityPanel, "Alcohol % : ", "alcohol-percent-text");
		fu.addLabeledBooleanField(qualityPanel, "Water Added? : ", "added-water-checkbox");

		return checkPanel;

	}

	@Override
	public List<Object> getUIControls()
	{
		return SWTBindingPropertyLocator.getControlsWithBindingProperty(this);
	}

}
