package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewMemberDialogController;

public class ViewMemberDialog extends BaseDialogView {

	MembershipTabFolder tabFolder;

	public ViewMemberDialog() {
		super(null);
	}

	@Override
	protected AbstractWindowController createController() {
		return new ViewMemberDialogController();
	}
	
	@Override
	protected void buildWorkArea(Composite parent) {
		createMemberSelectorGroup(parent);
		tabFolder = new MembershipTabFolder(parent);
		tabFolder.getTabComposite().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	void createMemberSelectorGroup(Composite composite) {
		Composite infoPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(infoPanel);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false)
				.applyTo(infoPanel);

		Label titleLabel = UIControlsFactory.createLabel(infoPanel,
				"Member Name :");
		addUIControl(titleLabel, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(titleLabel);
		Font labelFont = JFaceResources.getFontRegistry().getBold(
				JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		Label photoLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(photoLabel, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(1, 3)
				.grab(false, false).applyTo(photoLabel);

		Label idLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(idLabel, ViewWidgetId.VIEW_MEMBER_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(idLabel);

		Label balanceLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(balanceLabel, ViewWidgetId.VIEW_MEMBER_BALANCE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(balanceLabel);

	}

}
