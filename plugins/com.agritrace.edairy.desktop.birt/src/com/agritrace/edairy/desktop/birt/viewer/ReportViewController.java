package com.agritrace.edairy.desktop.birt.viewer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLCompleteImageHandler;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IHTMLRenderOption;
import org.eclipse.birt.report.engine.api.IParameterDefn;
import org.eclipse.birt.report.engine.api.IParameterGroupDefn;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.model.api.ElementFactory;
import org.eclipse.birt.report.model.api.OdaDataSourceHandle;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.model.api.SlotHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.RienaLocations;
import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IBrowserRidget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.birt.Activator;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.HbDataStoreProvider;

public abstract class ReportViewController extends SubModuleController {
	private static final Logger LOGGER = Log4r.getLogger(ReportViewController.class);

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";

	private IReportRunnable report;
	private IReportEngine engine;

	private IActionRidget runReportAction;
	private IActionRidget printReportAction;
	private IActionRidget saveReportAction;
	private IBrowserRidget browser;

	private File reportDocFile;

	public ReportViewController() {
		engine = null;
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		//
		browser = getRidget(IBrowserRidget.class, "browser");
		browser.setUrl("about:blank");

		// configure run ridgets
		runReportAction = getRidget(IActionRidget.class, "report-run-action");
		runReportAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				doRunReport();
			}
		});

		// configure print ridgets
		printReportAction = getRidget(IActionRidget.class, "report-print-action");
		printReportAction.setEnabled(false);
		printReportAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				doPrintReport();
			}
		});

		// configure save ridgets
		saveReportAction = getRidget(IActionRidget.class, "report-save-action");
		saveReportAction.setEnabled(false);
		saveReportAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				doSaveReport();
			}
		});
		
		// configure close ridgets
		saveReportAction = getRidget(IActionRidget.class, "report-save-action");
		saveReportAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				doCloseReport();
			}
		});
	}

	@Override
	public void afterBind() {
		super.afterBind();
		initReport();
	}

	private void doRunReport() {
		runReport();

		printReportAction.setEnabled(true);
		saveReportAction.setEnabled(true);
//		runReportAction.setEnabled(false);
	}

	private void doSaveReport() {
		final Shell shell = Display.getCurrent().getActiveShell();
		final FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setFilterExtensions(new String[] { "*.pdf", });

		try {
			String fName = fileDialog.open();
			if (fName != null)
				saveReport(fName);
		} catch (EngineException e) {
			e.printStackTrace();
		}

	}

	private void doPrintReport() {
		browser.setUrl("javascript:print()");
	}


	private void doCloseReport() {
		getNavigationNode().dispose();
	}

	public void runReport() {

		IReportRunnable report = getReportRunnable();
		Map<String, Object> parameters = getReportParameters();

		try {
			applyStandardParams(parameters);
			updateDataSource(report);

			reportDocFile = File.createTempFile("report", ".rptdoc", RienaLocations.getDataArea());

			IRunTask runTask = getEngine().createRunTask(report);
			// validate report parameters
			runTask.setParameterValues(parameters);
			runTask.validateParameters();
			runTask.run(reportDocFile.getAbsolutePath());
			runTask.close();

			showReport();

		} catch (Exception e) {
			reportDocFile = null;
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error running report", e.getMessage());
		}
	}

	private void showReport() throws EngineException, IOException {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		IReportDocument rptDoc = engine.openReportDocument(reportDocFile.getAbsolutePath());

		// Create task to run and render the header report
		IRenderTask task = getEngine().createRenderTask(rptDoc);

		// HTMLRenderContext???

		// set report render options
		HTMLRenderOption options = new HTMLRenderOption();

		options.setOutputFormat("html");
		options.setUrlEncoding("utf-8");
		options.setHtmlPagination(true);

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
		task.render();

		//
		task.close();

		browser.setText(outputStream.toString());
	}

	private void saveReport(String fileName) throws EngineException {

		IReportDocument rptDoc = engine.openReportDocument(reportDocFile.getAbsolutePath());

		// Create task to run and render the header report
		IRenderTask task = getEngine().createRenderTask(rptDoc);

		// HTMLRenderContext???
		final PDFRenderOption options = new PDFRenderOption();

		options.setOutputFileName(fileName);
		options.setOption(IRenderOption.HTML_PAGINATION, new Boolean(false));
		options.setOutputFormat("pdf");

		// ImageHandlerTest
		options.setImageHandler(new HTMLServerImageHandler());
		task.setRenderOption(options);
		task.render();
		task.close();
	}

	private void applyStandardParams(Map<String, Object> params) {
		IApplicationNode applicationNode = getNavigationNode().getParentOfType(IApplicationNode.class);
		IDairyRepository dairyRepo = (IDairyRepository) applicationNode.getContext("application.dairy.dao");
		Dairy localDairy = dairyRepo.getLocalDairy();

		// dairyName
		params.put("dairyName", localDairy.getCompanyName());
		// dairyLogo
		params.put("dairyLogo", localDairy.getCompanyName());
		// dairyAddress1
		try {
			params.put("dairyAddress1", localDairy.getLocation().getFormattedLocation());
		} catch (NullPointerException npe) {
		}
		// dairyAddress2
		try {
			params.put("dairyAddress2", localDairy.getLocation().getDescriptiveLocation());
		} catch (NullPointerException npe) {
		}
		// dairyAddress3
		try {
			params.put("dairyAddress3", localDairy.getLocation().getPostalLocation().getProvince());
		} catch (NullPointerException npe) {
		}
		// dairyPhone
		params.put("dairyPhone", localDairy.getPhoneNumber());
		// // productLogo
		// params.put("dairyName", localDairy.getCompanyName());
		// // vendorLogo
		// params.put("dairyName", localDairy.getCompanyName());
	}

	private void updateDataSource(IReportRunnable report) throws SemanticException {
		// get the report datasource
		ReportDesignHandle designHandle = (ReportDesignHandle) report.getDesignHandle();
		ElementFactory elementFactory = designHandle.getElementFactory();
		SlotHandle datasources = designHandle.getDataSources();
		Assert.isLegal(datasources.getCount() == 1, "Report must have a single datasource");
		Object dsObj = datasources.get(0);
		OdaDataSourceHandle dsHandle = null;
		if (dsObj instanceof OdaDataSourceHandle) {
			dsHandle = (OdaDataSourceHandle) dsObj;
		}

		// override datasource properties with values used by hibernate...
		Map<String, String> connectionProps = getJdbcDriverProperties();
		if (connectionProps.containsKey("driver_class"))
			dsHandle.setProperty("odaDriverClass", connectionProps.get("driver_class"));
		if (connectionProps.containsKey("url"))
			dsHandle.setProperty("odaURL", connectionProps.get("url"));
		if (connectionProps.containsKey("username"))
			dsHandle.setProperty("odaUser", connectionProps.get("username"));
		if (connectionProps.containsKey("password"))
			dsHandle.setProperty("odaPassword", connectionProps.get("password"));
	}

	private Map<String, String> getJdbcDriverProperties() {
		Properties fullProps = HbDataStoreProvider.getDatastoreProperties();
		Map<String, String> props = new HashMap<String, String>();
		props.put("driver_class", fullProps.getProperty("hibernate.connection.driver_class"));
		props.put("username", fullProps.getProperty("hibernate.connection.username"));
		props.put("password", fullProps.getProperty("hibernate.connection.password"));
		props.put("url", fullProps.getProperty("hibernate.connection.url"));
		return props;
	}

	private IReportEngine getEngine() {
		if (engine == null) {
			engine = Activator.getDefault().getReportEngine();
		}
		return engine;
	}

	protected IReportRunnable getReportRunnable() {
		return report;
	}

	protected void initReport() {
		// get the report from the navigation node
		INavigationNode<ISubModuleNode> currentNode = getNavigationNode();
		NavigationArgument argument = currentNode.getNavigationArgument();

		Object argObj = argument.getParameter();
		if (argObj instanceof ReportsIndexViewController.ReportInfo) {
			report = ((ReportsIndexViewController.ReportInfo) argObj).getReport();
		} else {
			throw new RuntimeException("Unable to get report object from context");
		}
	}

	protected Collection<IParameterDefn> getReportParameterDefinitions() {
		return getReportParameterDefinitions(null);
	}

	/**
	 * Given a named parameter group, get the scalar parameters associated with the group.
	 * 
	 * If the named group is not found, return the ungrouped scalar parameters for the report.
	 * 
	 * @param name
	 * @return
	 */
	protected Collection<IParameterDefn> getReportParameterDefinitions(String name) {
		Collection<IParameterDefn> returnList = null;
		IReportRunnable report = getReportRunnable();
		IReportEngine engine = report.getReportEngine();
		IGetParameterDefinitionTask task = engine.createGetParameterDefinitionTask(report);

		Collection<?> sourceList;
		if (name == null) {
			sourceList = task.getParameterDefns(false);
		} else {
			Object groupObj = task.getParameterDefn(name);
			if (groupObj instanceof IParameterGroupDefn) {
				sourceList = ((IParameterGroupDefn) groupObj).getContents();
			} else {
				throw new IllegalArgumentException("named parameter list " + name + " does not exist");
			}
		}
		returnList = new LinkedList<IParameterDefn>();
		for (Object paramObj : sourceList) {
			if (paramObj instanceof IParameterDefn) {
				IParameterDefn paramDef = (IParameterDefn) paramObj;
				if (!paramDef.isHidden()) {
					returnList.add((IParameterDefn) paramDef);
				}
			}
			
		}
		return returnList;
	}

	abstract protected Map<String, Object> getReportParameters();

}
