package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.ScrolledSubModuleView;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

abstract public class ReportView extends ScrolledSubModuleView {

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";

	private Browser browser;
	// private Random random = new Random();

// private final String reportName;
	private Composite parameterBar;
	private Composite paramArea;
	private Composite controlArea;
	private Composite reportArea;

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
		parent.setLayout(new GridLayout(1, false));

		// param bar above report area contains parameters and control areas
		parameterBar = UIControlsFactory.createComposite(parent, SWT.NONE);
		parameterBar.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

		// param area contents will be determined based on the selected report
		paramArea = UIControlsFactory.createGroup(parameterBar, "Report Parameters", "report-parameter-area");
		paramArea.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		setupParameterArea(paramArea);
// GridLayoutFactory.fillDefaults().generateLayout(controlArea);

		// control area contains the 'Run' button (maybe print/export later)
		controlArea = UIControlsFactory.createComposite(parameterBar);
		controlArea.setLayout(new FormLayout());
		Button runButton = UIControlsFactory.createButton(controlArea, "Run", "report-run-action");
		FormData fd_runbutton = new FormData();
		fd_runbutton.bottom = new FormAttachment(100, -5);
		runButton.setLayoutData(fd_runbutton);
		GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(parameterBar);

		// report area contains the browser used to display RI
		reportArea = UIControlsFactory.createComposite(parent, SWT.NONE);
		reportArea.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		browser = UIControlsFactory.createBrowser(reportArea, SWT.BORDER, "browser");
		browser.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		GridLayoutFactory.fillDefaults().generateLayout(reportArea);
		// export area contains the 'Print' and 'Save' buttons
		Composite exportArea = UIControlsFactory.createComposite(parent);
		exportArea.setLayout(new FormLayout());
		exportArea.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

		Button closeButton = UIControlsFactory.createButton(exportArea, "Close", "report-close-action");
		FormData fd_closebutton = new FormData();
		fd_closebutton.left = new FormAttachment(0, 5);
		closeButton.setLayoutData(fd_closebutton);

		Button printButton = UIControlsFactory.createButton(exportArea, "Print", "report-print-action");
		FormData fd_printbutton = new FormData();
		fd_printbutton.right = new FormAttachment(100, -5);
		printButton.setLayoutData(fd_printbutton);

		Button saveAsButton = UIControlsFactory.createButton(exportArea, "Save As..", "report-save-action");
		FormData fd_saveasbutton = new FormData();
		fd_saveasbutton.right = new FormAttachment(printButton, -5);
		saveAsButton.setLayoutData(fd_saveasbutton);

	}

	/**
	 * Called within 'createBasicPartControl' to add parameter UI. parent has no layout.
	 * 
	 * @param paramArea2
	 */
	abstract protected void setupParameterArea(Composite parent);
}
