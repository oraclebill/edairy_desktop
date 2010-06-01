package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberInfoGroup {

	public static final int DEFAULT_LABEL_WIDTH = 90;
	public static final int DEFAULT_FIELD_WIDTH = 150;

	public static final String MEMBERID = "Member ID:";
	public static final String HONORIFIC = "Hon.";
	public static final String FIRST_NAME = "Given";
	public static final String MIDDLE_NAME = "Middle :";
	public static final String ADDITIONAL_NAMES = "Additional";
	public static final String LAST_NAME = "Family:";
	public static final String SUFFIX = "Suffix";

	private Label photoLabel;
	private final Composite composite;
	private Label txtId;
	private CCombo cmbHonorable;
	private Text txtFirst;
	private Text txtMiddle;
	private Text txtLast;
	private CCombo cmbSuffix;
	private Text txtAdditional;
	private Link imageEditLink;

	public MemberInfoGroup(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		initGUI();
	}

	private Font bigAndBold(Font currentFont, boolean bold) {		
		FontData[] fontData = currentFont.getFontData();
		for (int i = 0; i < fontData.length; i++) {
			fontData[i].setHeight(22);
			if (bold) fontData[i].setStyle(SWT.BOLD);
		}
		return new Font(Display.getCurrent(), fontData);
	}
	
	public void initGUI() {

		final Composite leftColumn = UIControlsFactory.createComposite(composite);
		leftColumn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final GridLayout leftColumnLayout = new GridLayout();
		leftColumnLayout.numColumns = 2;
		leftColumnLayout.makeColumnsEqualWidth = false;
		leftColumnLayout.marginTop = 8;
		leftColumnLayout.marginLeft = 8;
		leftColumnLayout.marginRight = 8;
		leftColumnLayout.marginBottom = 8;
//		leftColumnLayout.horizontalSpacing = 8;	// default 5
//		leftColumnLayout.verticalSpacing = 8; 	// default 5
		
		leftColumn.setLayout(leftColumnLayout);
		leftColumn.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT).indent(5,0);
		GridDataFactory fieldFactory = GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT);

		// row 0: formatted member name 
		Label memberNameLabel = UIControlsFactory.createLabel(leftColumn, "(none)", ViewWidgetId.memberInfo_formattedName);
		memberNameLabel.setFont(bigAndBold(memberNameLabel.getFont(), true));
		labelFactory.copy().span(2,1).applyTo( memberNameLabel );
				
		// member Id 
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, MEMBERID));
		// member Id Text (Label)
		txtId = UIControlsFactory.createLabel(leftColumn, "<auto>", ViewWidgetId.memberInfo_id);
		fieldFactory.applyTo(txtId);

		// row 2: title label + id
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, "Title"));
		cmbHonorable = UIControlsFactory.createCCombo(leftColumn, ViewWidgetId.memberInfo_honorific);
		fieldFactory.applyTo(cmbHonorable);

		// row 3: given name
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, FIRST_NAME));
		txtFirst = UIControlsFactory.createText(leftColumn, SWT.BORDER, ViewWidgetId.memberInfo_firstName);
		fieldFactory.applyTo(txtFirst);

		// row 4: middle name
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, MIDDLE_NAME));
		txtMiddle = UIControlsFactory.createText(leftColumn, SWT.BORDER, ViewWidgetId.memberInfo_middleName);
		fieldFactory.applyTo(txtMiddle);

		// row 5: last name 
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, LAST_NAME));
		txtLast = UIControlsFactory.createText(leftColumn, SWT.BORDER, ViewWidgetId.memberInfo_lastName);
		fieldFactory.applyTo(txtLast);

		// row 6: extra names
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, ADDITIONAL_NAMES));
		txtAdditional = UIControlsFactory.createText(leftColumn, SWT.BORDER, ViewWidgetId.memberInfo_additionalNames);
		fieldFactory.applyTo(txtAdditional);

		//row 7: suffix
		labelFactory.applyTo(UIControlsFactory.createLabel(leftColumn, SUFFIX));
		cmbSuffix = UIControlsFactory.createCCombo(leftColumn, ViewWidgetId.memberInfo_suffix);
		fieldFactory.applyTo(cmbSuffix);
		
		// filler
		fieldFactory.grab(true, true).applyTo(UIControlsFactory.createLabel(leftColumn, "", SWT.NONE));

		
		// right column
		//		
		final Composite rightColumn = UIControlsFactory.createComposite(composite);
		rightColumn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final GridLayout rightColumnLayout = new GridLayout();
		rightColumnLayout.numColumns = 1;
		rightColumnLayout.makeColumnsEqualWidth = false;
		rightColumnLayout.marginTop = 8;
		rightColumnLayout.marginLeft = 8;
		rightColumnLayout.marginRight = 8;
		rightColumnLayout.marginBottom = 8;
//		rightColumnLayout.horizontalSpacing = 8;	// default 5
//		rightColumnLayout.verticalSpacing = 8; 	// default 5
		
		rightColumn.setLayout(rightColumnLayout);
		rightColumn.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		// row1-right: photo Label 
		photoLabel = UIControlsFactory.createLabel(rightColumn, "", SWT.SHADOW_IN, ViewWidgetId.memberPhoto); //$NON-NLS-1$
		fieldFactory.copy().applyTo(photoLabel);

		//row 2r:  
		imageEditLink = UIControlsFactory.createLink(rightColumn, SWT.CENTER, ViewWidgetId.memberPhotoEditLink);
		imageEditLink.setText("Click here to change member photo");
		fieldFactory.copy().grab(false, true).applyTo(imageEditLink);

		// filler
		//fieldFactory.grab(true, true).applyTo(UIControlsFactory.createLabel(rightColumn, "", SWT.NONE));

	}

	public Composite getComposite() {
		return composite;
	}
}
