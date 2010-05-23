package com.agritrace.edairy.desktop.common.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Common pickup/lookup composite
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class LookupComposite {

	private List<Object> controls = new ArrayList<Object>();
	private String[] labels;
	private Image[] icons;
	private String[] textBindIds;
	private String[] buttonIds;

	/**
	 * @param parent
	 *            Parent composite
	 * @param style
	 *            Style
	 * @param label
	 *            Label of lookup
	 * @param iconImage
	 *            Icon which will pop up the dialog
	 */

	public LookupComposite(String[] labels, Image[] iconImages,
			String[] textBindIds, String[] buttonBindIds) {

		Assert.isTrue(labels.length == iconImages.length);
		this.labels = labels;
		this.icons = iconImages;
		this.textBindIds = textBindIds;
		this.buttonIds = buttonBindIds;

	}

	public void createSection(Composite parent) {
		for (int i = 0; i < labels.length; i++) {
			createControl(parent, labels[i], icons[i], textBindIds[i],
					buttonIds[i]);
		}
	}

	private void createControl(Composite parent, String label, Image icon,
			String textBindId, String buttonBindId) {

		UIControlsFactory.createLabel(parent, label);
		Text memberText = UIControlsFactory.createText(parent, SWT.None);
		memberText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.addUIControl(memberText, textBindId);
		// Search Button
		ImageButton memberSearchButton = UIControlsFactory.createImageButton(
				parent, SWT.None);
		memberSearchButton.setImage(icon);
		this.addUIControl(memberSearchButton, buttonBindId);
	}

	/**
	 * Add a control to the list of 'bound' controls. These controls will be
	 * bound to ridgets by the framework.
	 * 
	 * @param uiControl
	 *            the UI control to bind; never null
	 * @param bindingId
	 *            a non-empty non-null bindind id for the control. Must be
	 *            unique within this composite
	 * @see #getUIControls()
	 */
	public final void addUIControl(Object uiControl, String bindingId) {
		Assert.isNotNull(uiControl);
		Assert.isNotNull(bindingId);
		controls.add(uiControl);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl,
				bindingId);
	}

}
