package com.demo;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class Test extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Test(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		UIControlsFactory.createLabel(this, "Hello, world!");
		

	}


}
