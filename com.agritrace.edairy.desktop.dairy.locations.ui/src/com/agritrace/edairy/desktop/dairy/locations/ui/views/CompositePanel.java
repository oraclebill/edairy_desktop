package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class CompositePanel extends Composite {
	
	public CompositePanel(Composite parent, int style) {
		super(parent, style);
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