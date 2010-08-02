package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.internal.ui.ridgets.swt.CompositeRidget;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.DateRange;
import com.agritrace.edairy.desktop.common.ui.controls.location.ViewWidgetId;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.internal.finance.ui.Activator;

public class TransactionJournalFilterPanel extends Composite {
	static {
		SwtControlRidgetMapper.getInstance().addMapping(TransactionSourceComposite.class, CompositeRidget.class);
	}

	public TransactionJournalFilterPanel(Composite parent) {
		this(parent, SWT.NONE);
	}

	public TransactionJournalFilterPanel(Composite parent, int style) {
		super(parent, style);
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		// setBackground(getDisplay().getSystemColor(SWT.COLOR_CYAN));

		// filter is a stack of composite rows.. each row uses formlayout..
		setLayout(new GridLayout(1, false));
		setLayoutData(GridDataFactory.swtDefaults().create());

		addDateRangeFilter();
		addMemberFilterLookup();
		addRefNumFilterLookup();
		addSourceFilter();
		pack();
	}

	// first row: date range
	//
	public void addDateRangeFilter() {
		final Composite row = UIControlsFactory.createComposite(this);
		final FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 10;
		row.setLayout(layout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);

		final DateRange dateRange = new DateRange(row, 140, SWT.NONE);
		final FormData fd_1 = new FormData();
		// fd_1.width = 140;
		fd_1.top = new FormAttachment(0, 0);
		fd_1.left = new FormAttachment(0, 0);

		dateRange.setLayoutData(fd_1);
		SWTBindingPropertyLocator.getInstance()
				.setBindingProperty(dateRange, FinanceBindingConstants.FILTER_DATE_RANGE);
		// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,
		// false).indent(10, 10).applyTo(dateRange);
	}

	// second row: member lookup
	//
	public void addMemberFilterLookup() {
		final Composite row = UIControlsFactory.createComposite(this);
		final FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 10;
		row.setLayout(layout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);

		final Label memberLookupLabel = UIControlsFactory.createLabel(row, "Member Lookup");
		final FormData fd_1 = new FormData();
		fd_1.width = 140;
		fd_1.top = new FormAttachment(0, 0);
		fd_1.left = new FormAttachment(0, 0);
		memberLookupLabel.setLayoutData(fd_1);

		// final Text memberIdText = UIControlsFactory.createText(row,
		// SWT.SEARCH | SWT.ICON_CANCEL | SWT.ICON_SEARCH,
		// FinanceBindingConstants.FILTER_TXT_MEMBER_LOOKUP);
		// final FormData fd_3 = new FormData();
		// fd_3.width = 300;
		// fd_3.top = new FormAttachment(memberLookupLabel, 0, SWT.CENTER);
		// fd_3.left = new FormAttachment(memberLookupLabel, 5, SWT.RIGHT);
		// memberIdText.setLayoutData(fd_3);

		final Text memberIdText = UIControlsFactory.createText(row, SWT.SINGLE | SWT.BORDER,
				FinanceBindingConstants.FILTER_MEMBER_LOOKUP_TXT);
		final FormData fd_3 = new FormData();
		fd_3.width = 265;
		fd_3.top = new FormAttachment(memberLookupLabel, 0, SWT.CENTER);
		fd_3.left = new FormAttachment(memberLookupLabel, 5, SWT.RIGHT);
		memberIdText.setLayoutData(fd_3);

		final ImageButton lookupButton = UIControlsFactory.createImageButton(row, SWT.BORDER,
				FinanceBindingConstants.FILTER_MEMBER_LOOKUP_BTN);
		final Image lookupIcon = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON);
		lookupButton.setImage(lookupIcon);
		final FormData fd_4 = new FormData();
		// fd_4.width = 280;
		fd_4.top = new FormAttachment(memberIdText, 0, SWT.CENTER);
		fd_4.left = new FormAttachment(memberIdText, 5, SWT.RIGHT);
		lookupButton.setLayoutData(fd_4);

	}

	// third row: reference number lookup
	//
	public void addRefNumFilterLookup() {
		final Composite rowComposite = UIControlsFactory.createComposite(this);
		final FormLayout rowLayout = new FormLayout();
		rowLayout.marginWidth = rowLayout.marginHeight = 10;
		rowComposite.setLayout(rowLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(rowComposite);

		final Label label = UIControlsFactory.createLabel(rowComposite, "Reference Number");
		final FormData labelFormData = new FormData();
		labelFormData.width = 140;
		labelFormData.top = new FormAttachment(0, 0);
		labelFormData.left = new FormAttachment(0, 0);
		label.setLayoutData(labelFormData);

		final Text refNumberLookup = UIControlsFactory.createText(rowComposite, SWT.NONE,
				FinanceBindingConstants.FILTER_TXT_REF_NO);
		final FormData fieldFormData = new FormData();
		fieldFormData.left = new FormAttachment(label);
		fieldFormData.width = 300;
		fieldFormData.top = new FormAttachment(label, 0, SWT.CENTER);
		refNumberLookup.setLayoutData(fieldFormData);
	}

	// alternate fourth row: source choices
	//
	public void addSourceFilter() {
		final Composite rowComposite = new TransactionSourceComposite(this, true, "Transaction Source");
		// SWTBindingPropertyLocator.getInstance().setBindingProperty(rowComposite,
		// FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(rowComposite);
	}

	/**
	 * 
	 * // alternate fourth row: type choices // { final Composite rowComposite =
	 * UIControlsFactory.createComposite(this); SWTBindingPropertyLocator
	 * .getInstance().setBindingProperty(rowComposite,
	 * FinanceBindingConstants.FILTER_TYPE_ROW);
	 * 
	 * final FormLayout rowLayout = new FormLayout(); rowLayout.marginWidth =
	 * rowLayout.marginHeight = 10; rowComposite.setLayout(rowLayout);
	 * 
	 * final String labelString = "Type:"; final Label lblType =
	 * UIControlsFactory.createLabel(rowComposite, "Type"); final FormData
	 * fd_lblType = new FormData(); fd_lblType.width = 140 ; fd_lblType.top =
	 * new FormAttachment(0, 0); fd_lblType.left = new FormAttachment(0, 0);
	 * lblType.setLayoutData(fd_lblType);
	 * 
	 * Composite typeCodeChoice =
	 * UIControlsFactory.createChoiceComposite(rowComposite, SWT.BORDER, true,
	 * FinanceBindingConstants.FILTER_CHOICE_TX_TYPE); FillLayout fillLayout =
	 * (FillLayout) typeCodeChoice.getLayout(); fillLayout.type =
	 * SWT.HORIZONTAL;
	 * 
	 * final FormData fieldLayoutData = new FormData(); fieldLayoutData.right =
	 * new FormAttachment(100, -8); fieldLayoutData.width = 300;
	 * fieldLayoutData.left = new FormAttachment(lblType, 6);
	 * fieldLayoutData.top = new FormAttachment(0, 0);
	 * typeCodeChoice.setLayoutData(fieldLayoutData); }
	 **/

}