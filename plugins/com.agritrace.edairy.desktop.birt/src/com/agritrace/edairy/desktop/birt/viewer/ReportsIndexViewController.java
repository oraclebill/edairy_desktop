package com.agritrace.edairy.desktop.birt.viewer;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.osgi.framework.Bundle;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.birt.Activator;
import com.agritrace.edairy.desktop.birt.navigation.NavigationConstants;
import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;

public class ReportsIndexViewController extends SubModuleController {
	private static final Logger LOGGER = Log4r.getLogger(ReportsIndexViewController.class);
	
	class ReportInfo {

		private File file;
		private IReportRunnable report;
		private String name;
		private String area;
		private String description;
		private boolean isValid;

		public ReportInfo(File f) {
			setFile(f);
		}

		public String getArea() {
			return area;
		}

		private void setArea(String area) {
			this.area = area;
		}

		public String getName() {
			return name;
		}

		private void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		private void setDescription(String desc) {
			description = desc;
		}

		public File getFile() {
			return file;
		}

		private void setFile(File file) {
			this.file = file;
			isValid = false;
			try {
				report = getReportEngine().openReportDesign(file.getAbsolutePath());
				ReportDesignHandle reportDesign = (ReportDesignHandle) report.getDesignHandle();
				setName(reportDesign.getStringProperty("displayName"));
				setArea(file.getParentFile().getName());
				setDescription(reportDesign.getStringProperty("description"));

				isValid = true;
			} catch (EngineException e) {
				description = e.getMessage();
			}
		}

		public String toString() {
			return file == null ? "<null>" : file.toString();
		}

		public IReportRunnable getReport() {
			return report;
		}
	}

	private static class DirFilter implements FileFilter {
		@Override
		public boolean accept(File arg0) {
			return arg0.isDirectory() && !(arg0.getName().equals(".") || arg0.getName().equals(".."));
		}
	}

	private static class ReportFileFilter implements FileFilter {
		@Override
		public boolean accept(File arg0) {
			return arg0.isFile() && arg0.getName().endsWith(".rptdesign");
		}
	}

	private static final String[] properties = { "area", "name", "description" };
	private static final String[] headers = { "Area", "Name", "Description" };

	private static final String REPORT_BUNDLE_NAME = "com.agritrace.edairy.desktop.birt.reports"

	;
	private IReportEngine engine;

	public ReportsIndexViewController() {
	}

	private List<ReportInfo> getReports() throws IOException, URISyntaxException {
		List<ReportInfo> reports = new LinkedList<ReportInfo>();
		Bundle reportBundle = Platform.getBundle(REPORT_BUNDLE_NAME);
		URL reportRootURL = FileLocator.find(reportBundle, new Path("/reports"), null);
		LOGGER.log(LogService.LOG_INFO, "Report directory URL: " + reportRootURL);
		URL fileURL = FileLocator.toFileURL(reportRootURL);
		//URI fileURI = fileURL.toURI();
		//File reportRoot = URIUtil.toFile(fileURI);
		File reportRoot = new File(fileURL.getPath());
		LOGGER.log(LogService.LOG_INFO, "Scanning report directory: " + reportRoot);
		File[] reportEntries = reportRoot.listFiles(new ReportFileFilter());
		for (File file : reportEntries) {
			LOGGER.log(LogService.LOG_INFO, "Found Report: " + file);
			reports.add(new ReportInfo(file));
		}

		return reports;
	}

	protected IReportEngine getReportEngine() {
		if (engine == null)
			engine = Activator.getDefault().getReportEngine();
		return engine;
	}

	@Override
	public void configureRidgets() {
		List<ReportInfo> reportFileList;

		Object uiControl = getWindowRidget().getUIControl();

		try {
			reportFileList = getReports();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		final ITableRidget reportList = getRidget(ITableRidget.class, "report-list-table");
		reportList.bindToModel( //
				new WritableList(reportFileList, ReportInfo.class), ReportInfo.class, properties, headers);
		reportList.addDoubleClickListener(new IActionListener() {
			@Override
			public void callback() {
				Object selected = reportList.getSelection().get(0);
				Assert.isLegal(selected instanceof ReportInfo);
				activateSelectedReportNode((ReportInfo) selected);
			}

		});
		reportList.updateFromModel();
	}

	@Override
	public void afterBind() {
		super.afterBind();
	}

	protected void activateSelectedReportNode(ReportInfo selectedItem) {
		// create a report-view navigation node under current node
		// with file as parameter
		ISubModuleNode currentNode;
		INavigationNode<?> childNode;
		String reportName;
		NavigationNodeId childNodeId;
		ReportInfo reportInfo;

		currentNode = getNavigationNode();
		reportInfo = ((ReportInfo) selectedItem);
		reportName = reportInfo.getName();

		childNodeId = new NavigationNodeId(NavigationConstants.REPORTS_REPORTSUBMODULE_TYPEID, reportName);
		childNode = currentNode.findNode(childNodeId);
		if (childNode != null) {
			childNode.dispose();
		}
		NodeFactory.createSubModule(childNodeId, reportName, currentNode,
				NavigationConstants.REPORTS_VIEWERSUBMODULE_VIEWID, GenericReportViewController.class);

		// go to that node
		currentNode.navigate(childNodeId, new NavigationArgument(selectedItem));

	}

	protected String getViewIdForReport(ReportInfo reportInfo) {
		String viewId;

// IReportRunnable runnable = reportInfo.getReport();
// IReportEngine engine = runnable.getReportEngine();
// IGetParameterDefinitionTask task = engine.createGetParameterDefinitionTask(runnable);
// // Collection paramDefns = task.getParameterDefns(false);
//
// ReportInspector.inspectReport(runnable);
//
// if (task.getParameterDefn("month") != null) {
// viewId = NavigationConstants.REPORTS_MONTHLYVIEWERSUBMODULE_VIEWID;
// } else if (task.getParameterDefn("date") != null) {
// viewId = NavigationConstants.REPORTS_DAILYVIEWERSUBMODULE_VIEWID;
// } else {
// viewId = NavigationConstants.REPORTS_ANNUALVIEWERSUBMODULE_VIEWID;
// }
		viewId = NavigationConstants.REPORTS_VIEWERSUBMODULE_VIEWID;
		return viewId;
	}

}
