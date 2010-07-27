package com.agritrace.edairy.desktop.common.ui.controls;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class CompositePanel extends Composite {
	
	public CompositePanel(Composite parent, int style) {
		super(parent, style);
		this.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

	}

	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		for (Control child : getChildren()) {
			if (child instanceof Label)
				child.setBackground(color);
		}
	}
}