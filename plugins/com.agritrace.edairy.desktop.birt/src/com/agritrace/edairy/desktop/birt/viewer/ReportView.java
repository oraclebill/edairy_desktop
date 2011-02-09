package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class ReportView extends SubModuleView {

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";

	private Browser browser;
	// private Random random = new Random();

// private final String reportName;
	private Composite composite;
	private Composite compositeBase;


	public ReportView() {
	}

	/**
	 * complext report page contains from a set of controls that can be used to manage report like year selection,
	 * refresh button and page management buttons (if needed)
	 * 
	 * @param parent
	 */
	@Override
	protected void basicCreatePartControl(Composite parent) {
		createComposite(parent);
		createBrowser();
	}

	private void createComposite(Composite parent) {
		compositeBase = UIControlsFactory.createComposite(parent, SWT.NONE);
		final GridLayout gridLayout0 = new GridLayout(1, false);

		compositeBase.setLayout(gridLayout0);
		compositeBase.setSize(800, 800);

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		final GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.BEGINNING;
		gridData.grabExcessVerticalSpace = false;
		
		composite = UIControlsFactory.createComposite(compositeBase, SWT.NONE);
		composite.setLayoutData(gridData);
		composite.setLayout(gridLayout);
		
		UIControlsFactory.createLabel(composite, "Year:");
		UIControlsFactory.createCCombo(composite, "year-combo");
		
		UIControlsFactory.createLabel(composite, "Month:");
		UIControlsFactory.createCCombo(composite, "month-combo");

		UIControlsFactory.createButton(composite, "Export to PDF", "export-pdf-action");
		UIControlsFactory.createButton(composite, "Print", "print-action");

	}

	private void createBrowser() {
		final GridData gridData3 = new GridData();
		browser = UIControlsFactory.createBrowser(compositeBase, SWT.BORDER, "browser");
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.FILL;
		gridData3.grabExcessVerticalSpace = true;
		gridData3.grabExcessHorizontalSpace = true;
		browser.setLayoutData(gridData3);
	}

}
