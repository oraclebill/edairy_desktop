package com.agritrace.edairy.desktop.common.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

public class DateRangeSearchWidget {

	public static final int DEFAULT_LABEL_WIDTH = 130;

	private final Composite composite;

	private final String labelText;

	private final String startId;
	private final String endId;

	public DateRangeSearchWidget(Composite parent, String rangeLabelTxt, String startTxtId, String endTxtId,
			String startCalendar, String endCalendar) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(7, false));
		labelText = rangeLabelTxt;
		startId = startTxtId;
		endId = endTxtId;
		createDataRangeSearch();
	}

	public Composite getComposite() {
		return composite;
	}

	private void createDataRangeSearch() {

		final Label label = UIControlsFactory.createLabel(composite, labelText);

		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, -1);
		labelFactory.applyTo(label);

		final Label startLabel = UIControlsFactory.createLabel(composite, "Start");
		GridDataFactory.defaultsFor(startLabel).applyTo(startLabel);
		
		final DateTime startDateText = UIControlsFactory.createDate(composite, SWT.READ_ONLY | SWT.BORDER, startId);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(startDateText);

		final Label endLabel = UIControlsFactory.createLabel(composite, "End");
		GridDataFactory.defaultsFor(endLabel).applyTo(endLabel);
		
		final DateTime endDateText = UIControlsFactory.createDate(composite, SWT.READ_ONLY | SWT.BORDER, endId);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(endDateText);
	}

}
