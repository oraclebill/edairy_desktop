package com.agritrace.edairy.desktop.birt.viewer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLCompleteImageHandler;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IHTMLRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IBrowserRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.birt.Activator;

public abstract class ReportViewController extends SubModuleController {
	private static final Logger LOGGER = Log4r.getLogger(ReportViewController.class);

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";


	private IBrowserRidget browser;
	// private Random random = new Random();

	private String reportName;


	private IActionRidget runReportAction;
	private IActionRidget print;

	private IReportEngine engine;

	public ReportViewController() {
		engine = Activator.getDefault().getReportEngine();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		//
		browser = getRidget(IBrowserRidget.class, "browser");
		
		// configure action ridgets
		runReportAction = getRidget(IActionRidget.class, "report-run-action");
		runReportAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				try {
					runReport();
				} catch (EngineException e) {
					LOGGER.log(LogService.LOG_ERROR, e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					LOGGER.log(LogService.LOG_ERROR, e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void afterBind() {
		super.afterBind();
		updateAllRidgetsFromModel();
	}

	private void doPrint() {
		browser.setUrl("javascript:print()");
	}

//	private void updateReport() {
//		browser.setText("");
//		try {
//			runReport();
//		} catch (final Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void runReport() throws EngineException, IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();		

		// Create task to run and render the header report
		IRunAndRenderTask task = engine.createRunAndRenderTask( getReportRunnable() );
		
		//  validate report parameters
		task.setParameterValues( getReportParameters() );
		task.validateParameters();
		
		// set report render options
		HTMLRenderOption options = new HTMLRenderOption();

		options.setOutputFormat( "html" );		
		options.setUrlEncoding( "utf-8" );
		options.setHtmlPagination( true );
				
		// set output options - direct to buffer for local html view
		options.setOutputStream(outputStream);
		options.setEmbeddable(true);
		options.setEnableInlineStyle(true);
		options.setLayoutPreference(IHTMLRenderOption.LAYOUT_PREFERENCE_AUTO);
		options.setOption(IRenderOption.HTML_PAGINATION, new Boolean(true));
		options.setImageDirectory("images");

		// ImageHandlerTest
		options.setImageHandler(new HTMLCompleteImageHandler());
		
		// set options
		task.setRenderOption(options);
		
		// run task
		task.run();
		
		// 
		task.close();
		
		browser.setText(outputStream.toString());
	}

	private IReportRunnable getReportRunnable() {
		// get the report from the navigation node
		INavigationNode<ISubModuleNode> currentNode = getNavigationNode();
		NavigationArgument argument = currentNode.getNavigationArgument();

		Object argObj = argument.getParameter();
		IReportRunnable report = null;
		if (argObj instanceof ReportsIndexViewController.ReportInfo) {
			report = ((ReportsIndexViewController.ReportInfo) argObj).getReport();
		} else {
			throw new RuntimeException("Unable to get report object from context");
		}
		return report;
	}

	abstract protected Map<String, Object> getReportParameters();
//	{
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("year", yearCombo.getText());
//		map.put("month", monthCombo.getText());
//		
//		return map;
//	}


}
