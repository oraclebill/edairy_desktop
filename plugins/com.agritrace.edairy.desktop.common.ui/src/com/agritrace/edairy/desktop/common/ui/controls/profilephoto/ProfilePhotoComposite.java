package com.agritrace.edairy.desktop.common.ui.controls.profilephoto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

import com.swtdesigner.SWTResourceManager;

public class ProfilePhotoComposite extends Composite implements IComplexComponent {


	public static final String LINK_BIND_ID = "updateImageLink";
	public static final String LABEL_BIND_ID = "profileImageLabel";

	private static final String DEFAULT_LINK_TEXT = "<a>update photo</a>";
	private static final int DEFAULT_PHOTO_HEIGHT = 200;
	private static final int DEFAULT_PHOTO_WIDTH = 150;

	private final List<Object> uiControls = new LinkedList<Object>();

	private Label imageLabel;
	private Link updateLink;

	public ProfilePhotoComposite(Composite parent, int style) {
		super(parent, style);

		this.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		final GridLayout gl_photoPanel = new GridLayout(1, false);
		gl_photoPanel.marginBottom = 5;
		gl_photoPanel.marginTop = 5;
		gl_photoPanel.marginRight = 5;
		gl_photoPanel.marginLeft = 5;
		this.setLayout(gl_photoPanel);

		addUIControl(imageLabel = new Label(this, SWT.CENTER | SWT.BORDER), LABEL_BIND_ID);
		imageLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		final GridData gd_label = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_label.heightHint = DEFAULT_PHOTO_HEIGHT;
		gd_label.widthHint = DEFAULT_PHOTO_WIDTH;
		imageLabel.setLayoutData(gd_label);

		addUIControl(updateLink = new Link(this, SWT.NONE), LINK_BIND_ID);
		updateLink.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		updateLink.setText(DEFAULT_LINK_TEXT);
	}

	public void setImage(Image image) {
		imageLabel.setImage(image);
	}

	public Image getImage() {
		return imageLabel.getImage();
	}

	public void setText(String text) {
		updateLink.setText(text);
	}

	public String getText() {
		return updateLink.getText();
	}

	final private void addUIControl(final Object uiControl, final String bindingId) {
		uiControls.add(uiControl);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, bindingId);
	}

	@Override
	public List<Object> getUIControls() {
		return Collections.unmodifiableList(uiControls);
	}

}