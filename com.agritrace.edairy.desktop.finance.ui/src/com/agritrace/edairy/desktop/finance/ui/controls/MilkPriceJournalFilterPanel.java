package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.ui.controls.daterange.DateRange;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.swtdesigner.SWTResourceManager;

public class MilkPriceJournalFilterPanel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MilkPriceJournalFilterPanel(Composite parent, int style) {
		super(parent, style);		
		setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		setLayout(new FormLayout());
		
		Label lblMilkPriceFor = UIControlsFactory.createLabel(this, MilkPriceJournalConstants.CURRENT_PRICE_LABEL_FMT, SWT.NONE, MilkPriceJournalConstants.ID_LBL_CURRENT_MILK_PRICE);
		FormData fd_lblMilkPriceFor = new FormData();
		fd_lblMilkPriceFor.top = new FormAttachment(0);
		fd_lblMilkPriceFor.left = new FormAttachment(0, 10);
		lblMilkPriceFor.setLayoutData(fd_lblMilkPriceFor);
		lblMilkPriceFor.setFont(SWTResourceManager.getFont("Lucida Grande", 18, SWT.BOLD));
						
		DateRange dateRange = new DateRange(this, 75, SWT.NONE);
		FormData fd_dateRange = new FormData();
		fd_dateRange.top = new FormAttachment(lblMilkPriceFor, 12, SWT.BOTTOM);
		fd_dateRange.left = new FormAttachment(0, 18);
		dateRange.setLayoutData(fd_dateRange);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(dateRange, MilkPriceJournalConstants.ID_DATE_PRICEDATE);
		
//		pack();
	}
}
