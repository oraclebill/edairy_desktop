package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddFarmDialogController;

public class AddFarmDialog extends ViewFarmDialog {

	public AddFarmDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	protected AbstractWindowController createController() {
		return new AddFarmDialogController();
	}

	protected void createHeader(Composite parent){

		Composite headerPanel = UIControlsFactory.createComposite(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(headerPanel);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(headerPanel);


		Label titleLabel =UIControlsFactory.createLabel(headerPanel,"Farm Name :");
		addUIControl(titleLabel, ViewWidgetId.VIEW_FARM_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).span(1, 1).applyTo(titleLabel);
		Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		Text farmText =UIControlsFactory.createText(headerPanel, SWT.SINGLE|SWT.BORDER, ViewWidgetId.VIEW_FARM_NAME_TXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).span(2, 1).applyTo(farmText);

		Label farmIdLabel = UIControlsFactory.createLabel(headerPanel, "Farm Id :");
		addUIControl(farmIdLabel, ViewWidgetId.VIEW_FARM_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(farmIdLabel);

		Label memberIdLabel = UIControlsFactory.createLabel(headerPanel, "Member Id :");
		addUIControl(memberIdLabel, ViewWidgetId.VIEW_FARM_MEMBER_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(memberIdLabel);

		Label memberNameLabel = UIControlsFactory.createLabel(headerPanel,"Member Name :");
		addUIControl(memberNameLabel, ViewWidgetId.VIEW_FARM_MEMBER_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(memberNameLabel);

	}
	
}
