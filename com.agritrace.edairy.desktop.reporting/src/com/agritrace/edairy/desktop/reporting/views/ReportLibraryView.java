package com.agritrace.edairy.desktop.reporting.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.ui.views.ScrolledSubModuleView;

public class ReportLibraryView extends ScrolledSubModuleView {

	public static final String ID = "com.agritrace.edairy.desktop.reporting.views.ReportLibraryView"; //$NON-NLS-1$

	public ReportLibraryView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void basicCreatePartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		{
			Composite reportParameterPanel = new Composite(container, SWT.NONE);
			reportParameterPanel.setLayout(new GridLayout(2, false));
			reportParameterPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Group parameterPanel = new Group(reportParameterPanel, SWT.NONE);
			parameterPanel.setText("Report Parameters");
			parameterPanel.setLayout(new GridLayout(4, false));
			parameterPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			Label paramOneLabel = new Label(parameterPanel, SWT.NONE);
			paramOneLabel.setText("Parameter 1");
			addUIControl(paramOneLabel, ReportLibraryBindingConstants.PARAM_ONE_LABEL);
			
			Label paramTwoLabel = new Label(parameterPanel, SWT.NONE);
			paramTwoLabel.setText("Parameter 2");
			addUIControl(paramTwoLabel, ReportLibraryBindingConstants.PARAM_TWO_LABEL);
			
			Label paramThreeLabel = new Label(parameterPanel, SWT.NONE);
			paramThreeLabel.setText("Parameter 3");
			addUIControl(paramThreeLabel, ReportLibraryBindingConstants.PARAM_THREE_LABEL);

			
			Label label_2 = new Label(parameterPanel, SWT.NONE);
			label_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
			
			Combo paramOneCombo = new Combo(parameterPanel, SWT.NONE);
			paramOneCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			addUIControl(paramOneCombo, ReportLibraryBindingConstants.PARAM_THREE_COMBO);

			Combo paramTwoCombo = new Combo(parameterPanel, SWT.NONE);
			paramTwoCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			addUIControl(paramTwoCombo, ReportLibraryBindingConstants.PARAM_THREE_COMBO);

			Combo paramThreeCombo = new Combo(parameterPanel, SWT.NONE);
			paramThreeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			addUIControl(paramThreeCombo, ReportLibraryBindingConstants.PARAM_THREE_COMBO);
			
			new Label(parameterPanel, SWT.NONE);
			
			Button btnRunReport = new Button(reportParameterPanel, SWT.NONE);
			btnRunReport.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM, false, false, 1, 1));
			btnRunReport.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				}
			});
			btnRunReport.setText("Run Report");
			addUIControl(btnRunReport, ReportLibraryBindingConstants.RUN_REPORT_BUTTON);
		}
		{
			Browser reportBrowser = new Browser(container, SWT.NONE);
			reportBrowser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			addUIControl(reportBrowser, ReportLibraryBindingConstants.REPORT_BROWSER);
		}
		
		Composite reportControlPanel = new Composite(container, SWT.NONE);
		reportControlPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		Button btnPrint = new Button(reportControlPanel, SWT.NONE);
		btnPrint.setBounds(480, 10, 94, 30);
		btnPrint.setText("Print");
		addUIControl(btnPrint, ReportLibraryBindingConstants.PRINT_REPORT_BUTTON);

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
