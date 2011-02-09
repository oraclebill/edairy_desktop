package com.agritrace.edairy.desktop.birt.viewer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLCompleteImageHandler;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IHTMLRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IBrowserRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.birt.Activator;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
//import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.google.inject.Inject;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;

public class ReportViewController extends SubModuleController {

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";

	private static final String[] yearSelections = new String[20];
	static {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < 20; i++) {
			yearSelections[i] = "" + (year - i);
		}
	}

	private static final String[] monthSelections = new String[] { //
	"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
			"December" };

	private IBrowserRidget browser;
	// private Random random = new Random();

	private String reportName;

	private IComboRidget yearCombo;
	private IComboRidget monthCombo;

	private IActionRidget exportToPDF;
	private IActionRidget print;

	public ReportViewController() {
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
//		IDairyRepository dairyRepo = null;

		yearCombo = getRidget(IComboRidget.class, "year-combo");
		yearCombo.bindToModel(new WritableList(Arrays.asList(yearSelections), String.class), String.class, "toString",
				new WritableValue());
		yearCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(org.eclipse.riena.ui.ridgets.listener.SelectionEvent event) {
				updateReport();
			}
		});

		monthCombo = getRidget(IComboRidget.class, "month-combo");
		monthCombo.bindToModel(new WritableList(Arrays.asList(monthSelections), String.class), String.class,
				"toString", new WritableValue());
		monthCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(org.eclipse.riena.ui.ridgets.listener.SelectionEvent event) {
				updateReport();
			}
		});

		exportToPDF = getRidget(IActionRidget.class, "export-pdf-action");
		exportToPDF.addListener(new IActionListener() {
			@Override
			public void callback() {
				doPDFExport();
			}
		});

		print = getRidget(IActionRidget.class, "print-action");
		print.addListener(new IActionListener() {
			@Override
			public void callback() {
				doPrint();
			}
		});
	}

	@Override
	public void afterBind() {
		super.afterBind();
//		yearCombo.setSelection(0);
//		monthCombo.setSelection(
//				Calendar.getInstance().get(Calendar.MONTH));
	}

	private void doPrint() {
		browser.setUrl("javascript:print()");
	}

	private void doPDFExport() {
		exportToPDF.setEnabled(false);
		try {
			final String fileName = getFileNameToExport();
			exportToPDF(fileName);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			exportToPDF.setEnabled(true);
		}
	}

	private String getFileNameToExport() {
		final Shell shell = Display.getCurrent().getActiveShell();
		final FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setFilterExtensions(new String[] { "*.pdf", });
		final String importFileName = fileDialog.open();
		return importFileName;
	}

	private void exportToPDF(String pdfFile) throws Exception {

		final OutputStream output = new FileOutputStream(pdfFile);

		IReportEngine engine = null;
		EngineConfig config = null;

		try {
			// configure engine and platform; create factory object
			config = new EngineConfig();
			// config.setBIRTHome("C:\\birt\\birt-runtime-2_2_0\\birt-runtime-2_2_0\\ReportEngine");
			config.setLogConfig(null, Level.OFF);

			@SuppressWarnings("unchecked")
			final HashMap<String, Object> hm = config.getAppContext();
			hm.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, ReportView.class.getClassLoader());
			config.setAppContext(hm);

			Platform.startup(config);
			final IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = factory.createReportEngine(config);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		// will create html report from 3 independable parts:
		IReportRunnable designHead, designFoot, designBody = null;
		final URI reportHead = toURL("reports/header.rptdesign");
		final URI reportFoot = toURL("reports/footer.rptdesign");
		final URI reportBody = toURL(this.reportName);

		// acceptors for the rendered data:
		final InputStream reportHeadIS = URIConverter.INSTANCE.createInputStream(reportHead);
		final InputStream reportFootIS = URIConverter.INSTANCE.createInputStream(reportFoot);
		final InputStream reportBodyIS = URIConverter.INSTANCE.createInputStream(reportBody);

		// accessing the design files:
		designHead = engine.openReportDesign("" + reportHead, reportHeadIS);
		designFoot = engine.openReportDesign("" + reportFoot, reportFootIS);
		designBody = engine.openReportDesign("" + reportBody, reportBodyIS);

		// setting the parameters for each report:
		final String month = getMonthSelected();
		final String year = getYearSelected();

		// Create task to run and render the header report
		IRunAndRenderTask task = engine.createRunAndRenderTask(designHead);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", month);
		task.setParameterValue("Name", getReportName());

		setAddressParameters(task);

		task.validateParameters();

		final PDFRenderOption options = new PDFRenderOption();

		ByteArrayOutputStream fso = null, fso2 = null, fso3 = null;

		fso = new ByteArrayOutputStream();

		options.setOutputStream(fso);
		options.setOption(IRenderOption.HTML_PAGINATION, new Boolean(false));
		options.setOutputFormat("pdf");

		// ImageHandlerTest
		options.setImageHandler(new HTMLServerImageHandler());
		task.setRenderOption(options);
		task.run();

		// Create task to run and render the report, with the same set of
		// options:
		task = engine.createRunAndRenderTask(designBody);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", "" + getMonthIndex(month));
		task.validateParameters();

		try {
			fso.flush();
			fso.close();
			fso2 = new ByteArrayOutputStream();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		options.setOutputStream(fso2);
		task.setRenderOption(options);

		// run the task (it will render from here):
		task.run();

		// task to render a footer:
		task = engine.createRunAndRenderTask(designFoot);

		try {
			fso2.flush();
			fso2.close();
			fso3 = new ByteArrayOutputStream();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		options.setOutputStream(fso3);
		task.setRenderOption(options);

		task.run();

		try {
			fso3.flush();
			fso3.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// report is done, closing now the staff involved:
		engine.destroy();
		Platform.shutdown();

		// merge PDFs:

		concatPDFs(new ByteArrayInputStream(fso.toByteArray()), new ByteArrayInputStream(fso2.toByteArray()),
				new ByteArrayInputStream(fso3.toByteArray()), output, true);
	}

	private void concatPDFs(InputStream head, InputStream body, InputStream foot, OutputStream output, boolean paginate)
			throws Exception {

		final PdfReader reader1 = new PdfReader(head);
		final PdfReader reader2 = new PdfReader(body);
		final PdfReader reader3 = new PdfReader(foot);
		final PdfCopyFields copy = new PdfCopyFields(output);
		copy.addDocument(reader1);
		copy.addDocument(reader2);
		copy.addDocument(reader3);
		copy.close();

		output.flush();
		output.close();
	}

	private void updateReport() {
		browser.setText("");
		try {
			runReport();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void runReport() throws EngineException, IOException {

		IReportEngine engine = null;
		EngineConfig config = null;

		try {
			// configure engine and platform; create factory object
			config = new EngineConfig();
			// config.setBIRTHome("C:\\birt\\birt-runtime-2_2_0\\birt-runtime-2_2_0\\ReportEngine");
			config.setLogConfig(null, Level.OFF);

			@SuppressWarnings("unchecked")
			final HashMap<String, Object> hm = config.getAppContext();
			hm.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, ReportView.class.getClassLoader());
			config.setAppContext(hm);

			Platform.startup(config);
			final IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = factory.createReportEngine(config);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		// will create html report from 3 independable parts:
		IReportRunnable designHead, designFoot, designBody = null;
		final URI reportHead = toURL("reports/header.rptdesign");
		final URI reportFoot = toURL("reports/footer.rptdesign");
		final URI reportBody = toURL(this.reportName);

		// acceptors for the rendered data:
		final InputStream reportHeadIS = URIConverter.INSTANCE.createInputStream(reportHead);
		final InputStream reportFootIS = URIConverter.INSTANCE.createInputStream(reportFoot);
		final InputStream reportBodyIS = URIConverter.INSTANCE.createInputStream(reportBody);

		// accessing the design files:
		designHead = engine.openReportDesign("" + reportHead, reportHeadIS);
		designFoot = engine.openReportDesign("" + reportFoot, reportFootIS);
		designBody = engine.openReportDesign("" + reportBody, reportBodyIS);

		// setting the parameters for each report:
		final String month = getMonthSelected();
		final String year = getYearSelected();

		// Create task to run and render the header report
		IRunAndRenderTask task = engine.createRunAndRenderTask(designHead);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", month);
		task.setParameterValue("Name", getReportName());

		setAddressParameters(task);

		task.validateParameters();

		final HTMLRenderOption options = new HTMLRenderOption();
		new PDFRenderOption();

		ByteArrayOutputStream fso = null, fso2 = null, fso3 = null;

		fso = new ByteArrayOutputStream();

		options.setOutputStream(fso);
		options.setEmbeddable(true);
		options.setEnableInlineStyle(true);
		options.setLayoutPreference(IHTMLRenderOption.LAYOUT_PREFERENCE_AUTO);
		options.setOption(IRenderOption.HTML_PAGINATION, new Boolean(true));
		options.setOutputFormat("html");
		options.setImageDirectory("images");

		// ImageHandlerTest
		options.setImageHandler(new HTMLCompleteImageHandler());
		task.setRenderOption(options);
		task.run();

		// Create task to run and render the report, with the same set of
		// options:
		task = engine.createRunAndRenderTask(designBody);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", "" + getMonthIndex(month));
		task.validateParameters();

		try {
			fso.flush();
			fso.close();
			fso2 = new ByteArrayOutputStream();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		options.setOutputStream(fso2);
		task.setRenderOption(options);

		// run the task (it will render from here):
		task.run();

		// task to render a footer:
		task = engine.createRunAndRenderTask(designFoot);

		try {
			fso2.flush();
			fso2.close();
			fso3 = new ByteArrayOutputStream();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		options.setOutputStream(fso3);
		task.setRenderOption(options);

		task.run();

		try {
			fso3.flush();
			fso3.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// report is done, closing now the staff involved:
		engine.destroy();
		Platform.shutdown();

		// fill the browser object with this html:
		final StringBuffer html = new StringBuffer();
		html.append(fso.toString());
		html.append(fso2.toString());
		html.append(fso3.toString());

		browser.setText(html.toString());

	}

	private Integer getMonthIndex(String monthName) {
		for (int i = 0; i < this.monthSelections.length; i++) {
			if (monthName.equals(this.monthSelections[i])) {
				return i + 1;
			}
		}
		return 0;
	}

	private void setAddressParameters(IRunAndRenderTask task) {
//		final String name = localDairy.getLegalName();
//		final String phone = localDairy.getPhoneNumber();
//		final Location location = localDairy.getLocation();
//		final String address = location.getPostalLocation().getAddress();
//
//		task.setParameterValue("LegalName", name == null || name.isEmpty() ? "No-name" : name);
//		task.setParameterValue("Phone", phone == null || phone.isEmpty() ? "No-phone" : phone);
//		task.setParameterValue("Address", address == null || address.isEmpty() ? "No-address" : address);
	}

	private Object getReportName() {
		if (this.reportName.equals(MILK_COLLECTION_YEAR)) {
			return MILK_COLLECTION_YEAR_REPORT_NAME;
		}
		if (this.reportName.equals(MEMBER_PAYABLE_YEAR)) {
			return MEMBER_PAYABLE_YEAR_REPORT_NAME;
		}
		return "";
	}

	private String getMonthSelected() {
		return monthCombo.getText();
	}

	private String getYearSelected() {
		return yearCombo.getText();
	}

	public static URL getRCPRootURL() {
		final Activator a = Activator.getDefault();

		if (a != null) {
			final Bundle b = Activator.context.getBundle();
			if (b != null) {
				final URL rootURL = b.getEntry("/");
				return rootURL;
			}
		}
		return null;
	}

	public static URI toURL(String relativeResoursePath) {
		String BASE = "/com.agritrace.edairy.desktop.birt/resources/";
		URI uri = URI.createPlatformPluginURI(BASE + relativeResoursePath, true);
		uri = CommonPlugin.resolve(uri);
		return uri;
	}

}
