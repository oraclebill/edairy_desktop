package com.agritrace.edairy.desktop.birt.viewer;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.core.RienaLocations;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.ITableRidget;

public class ReportsIndexViewController extends SubModuleController {

	private static class ReportInfo {

		private String description;
		private File file;

		public String getArea() {
			return file == null ? "" : file.getParentFile().getName();
		}

		public String getName() {
			return file == null ? "" : file.getName();
		}

		public String getDescription() {
			return description == null ? "" : description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public String toString() {
			return file == null ? "<null>" : file.toString();
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
			return arg0.isFile() && arg0.getName().endsWith(".rpt");
		}
	}

	private static final String[] properties = { "area", "name", "description" };
	private static final String[] headers = { "Area", "Name", "Description" };

	public ReportsIndexViewController() {
	}

	@Override
	public void configureRidgets() {
		List<ReportInfo> reportFileList;
		
		reportFileList = new LinkedList<ReportInfo>();
		File reportDir = new File(RienaLocations.getDataArea(), "reports");
		for (File area : reportDir.listFiles(new DirFilter())) {
			for (File reportFile : area.listFiles(new ReportFileFilter())) {
				ReportInfo reportInfo = new ReportInfo();
				reportInfo.setFile(reportFile);
				reportFileList.add(reportInfo);
				System.err.println("Adding report: " + reportInfo);
			}
		}
		ITableRidget reportList = getRidget(ITableRidget.class, "report-list-table");
		reportList.bindToModel( //
				new WritableList(reportFileList, ReportInfo.class), ReportInfo.class, properties, headers);
		reportList.updateFromModel();
	}

	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
	}

}
