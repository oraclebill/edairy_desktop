package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

import com.agritrace.edairy.desktop.collection.ui.components.MilkCollectionLogFilterPanel;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkCollectionLog extends AbstractDirectoryView {

	public static final String ID = "milk-collection-log";

	public MilkCollectionLog() {
	}

	@Override
	protected void createFilterPanel(Composite parent) {
		final Composite comp = new MilkCollectionLogFilterPanel(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3,-1).applyTo(comp);
	}

	@Override
	protected void createFilterButtons(Composite parent) {
		// prevent superclass from adding buttons..
	}

	@Override
	protected Composite createButtons(Composite parent) {
		Composite container = super.createButtons(parent);
		Layout containerLayout = container.getLayout();
		if (containerLayout instanceof GridLayout) {
			GridLayout gl = (GridLayout)containerLayout;
			gl.numColumns = gl.numColumns + 1;
		}
		Button fileButton = UIControlsFactory.createButton(container, "Import Scale Data", "import-file-button");
		return container;
	}


	
}
