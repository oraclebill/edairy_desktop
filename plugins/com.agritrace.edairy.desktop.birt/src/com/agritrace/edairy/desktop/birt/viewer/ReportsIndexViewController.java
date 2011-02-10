package com.agritrace.edairy.desktop.birt.viewer;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.birt.Activator;
import com.agritrace.edairy.desktop.birt.navigation.NavigationConstants;
import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;

public class ReportsIndexViewController extends SubModuleController {

	static class ReportInfo {

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
				report = Activator.getDefault().getReportEngine().openReportDesign(file.getAbsolutePath());		
				DesignElementHandle reportDesign = report.getDesignHandle();
				setName(reportDesign.getStringProperty("displayName"));
//				setArea(reportDesign.getStringProperty("title"));
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

	private static final String REPORT_BUNDLE_NAME = "com.agritrace.edairy.desktop.birt.reports";

	public ReportsIndexViewController() {
	}

	private List<ReportInfo> getReports() throws IOException, URISyntaxException {
		IReportEngine engine = Activator.getDefault().getReportEngine();

		List<ReportInfo> reports = new LinkedList<ReportInfo>();
		Bundle reportBundle = Platform.getBundle(REPORT_BUNDLE_NAME);
		URL reportRootURL = FileLocator.find(reportBundle, new Path("/reports"), null);
		File reportRoot = URIUtil.toFile(FileLocator.toFileURL(reportRootURL).toURI());
		File[] reportEntries = reportRoot.listFiles(new ReportFileFilter());
		for (File file : reportEntries) {
			reports.add(new ReportInfo(file));
		}

		return reports;
	}

	@Override
	public void configureRidgets() {
		List<ReportInfo> reportFileList;

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
				// create a report-view navigation node under current node
				// with file as parameter
				ISubModuleNode currentNode = getNavigationNode();

				Object selectedItem = reportList.getSelection().get(0);
				if (selectedItem instanceof ReportInfo) {
					String reportName = ((ReportInfo) selectedItem).getName();
					NavigationNodeId childNodeId = new NavigationNodeId(
							NavigationConstants.REPORTS_REPORTSUBMODULE_TYPEID, reportName);

					ISubModuleNode childNode = NodeFactory.createSubModule(childNodeId, reportName, currentNode,
							NavigationConstants.REPORTS_VIEWERSUBMODULE_VIEWID, ReportViewController.class);
					// go to that node
					currentNode.navigate(childNodeId, new NavigationArgument(selectedItem));
				}
			}
		});
		reportList.updateFromModel();
	}

	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
	}

}
