package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

import com.swtdesigner.SWTResourceManager;

public class MilkPriceLogFilterPanel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MilkPriceLogFilterPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginBottom = 8;
		gl_composite.marginTop = 8;
		gl_composite.marginLeft = 8;
		composite.setLayout(gl_composite);
		
		Label lblMilkPriceFor = UIControlsFactory.createLabel(composite, MilkPriceLogConstants.CURRENT_PRICE_LABEL_FMT, SWT.NONE, MilkPriceLogConstants.ID_LBL_CURRENT_MILK_PRICE);
		lblMilkPriceFor.setFont(SWTResourceManager.getFont("Lucida Grande", 18, SWT.BOLD));
		lblMilkPriceFor.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 2));
		
		Label label = new Label(composite_2, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_1.setLayout(new FormLayout());
		
		Label lblDateRange = new Label(composite_1, SWT.NONE);
		FormData fd_lblDateRange = new FormData();
		fd_lblDateRange.top = new FormAttachment(0, 10);
		fd_lblDateRange.left = new FormAttachment(0, 10);
		lblDateRange.setLayoutData(fd_lblDateRange);
		lblDateRange.setText("Date Range -");
		
		Label lblStart = new Label(composite_1, SWT.NONE);
		FormData fd_lblStart = new FormData();
		fd_lblStart.left = new FormAttachment(lblDateRange, 16);
		fd_lblStart.bottom = new FormAttachment(lblDateRange, 14);
		fd_lblStart.top = new FormAttachment(lblDateRange, 0, SWT.TOP);
		lblStart.setLayoutData(fd_lblStart);
		lblStart.setText("Start");
		
		DateTime dateTime = UIControlsFactory.createDate(composite_1, SWT.BORDER, MilkPriceLogConstants.ID_DATE_START);
		FormData fd_dateTime = new FormData();
		fd_dateTime.bottom = new FormAttachment(lblDateRange, 8, SWT.BOTTOM);
		fd_dateTime.left = new FormAttachment(lblStart, 6);
		dateTime.setLayoutData(fd_dateTime);
		
		Label lblEnd = new Label(composite_1, SWT.NONE);
		FormData fd_lblEnd = new FormData();
		fd_lblEnd.left = new FormAttachment(dateTime, 16);
		fd_lblEnd.bottom = new FormAttachment(lblDateRange, 0, SWT.BOTTOM);
		fd_lblEnd.top = new FormAttachment(lblDateRange, 0, SWT.TOP);
		lblEnd.setLayoutData(fd_lblEnd);
		lblEnd.setText("End");
		
		DateTime dateTime_1 = UIControlsFactory.createDate(composite_1, SWT.BORDER, MilkPriceLogConstants.ID_DATE_END);
		fd_dateTime.top = new FormAttachment(dateTime_1, 0, SWT.TOP);
		FormData fd_dateTime_1 = new FormData();
		fd_dateTime_1.top = new FormAttachment(lblDateRange, -4, SWT.TOP);
		fd_dateTime_1.left = new FormAttachment(lblEnd, 6);
		fd_dateTime_1.bottom = new FormAttachment(100, -4);
		dateTime_1.setLayoutData(fd_dateTime_1);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
