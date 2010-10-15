package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class LocationProfileWidget {

	private final Composite composite;

	public LocationProfileWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(1).applyTo(composite);
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		final Group addressGroup = new AddressGroupWidget(composite).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(addressGroup);

		final Composite mapPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(mapPanel);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(3).applyTo(mapPanel);

		final Group directionGroup = new DirectionsGroupWidget(mapPanel).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(directionGroup);

		final Group mapGroup = new MapGroupWidget(mapPanel).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(mapGroup);

	}

}
