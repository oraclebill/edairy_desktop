package com.agritrace.edairy.desktop.birt.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.birt.Activator;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;

public class ReportController {

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";

	private Browser browser;
	// private Random random = new Random();

	private final String reportName;
	private Composite composite;
	private Label yearLabel;
	private CCombo yearCombo;
	private CCombo monthCombo;
	private Composite compositeBase;

	private final String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private Label monthLabel;
	private Button exportToPDF;
	private Button print;

	@Inject private static IDairyRepository dairyRepo;
	public ReportController(String reportName){
		this.reportName = reportName;

	}

	public void createPartControl(Composite parent) {
		//createSimpleBrowser(parent);
		createComplexReportPage(parent);
	}

	/**
	 * complext report page contains from a set of controls that can be used to
	 * manage report like year selection, refresh button and page management
	 * buttons (if needed)
	 *
	 * @param parent
	 */
	private void createComplexReportPage(Composite parent) {
		createComposite(parent);
		createBrowser();
		fillControls();
		runComplexReport();
	}

	private void fillControls() {
		final Calendar c = Calendar.getInstance();

		final int year = c.get(Calendar.YEAR);
		for(int i = year-10; i<year+20; i++){
			yearCombo.add(""+i);
		}
		yearCombo.setText(year+"");

		yearCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateReport();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateReport();
			}
		});

		final int monthIndex = c.get(Calendar.MONTH);
		for( int i = 0; i<this.months.length; i++){
			monthCombo.add(this.months[i]);
			if(i == monthIndex){
				monthCombo.setText(this.months[i]);
			}
		}

		monthCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateReport();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateReport();
			}
		});

		exportToPDF.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				doPDFExport();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				doPDFExport();

			}
		});

		exportToPDF.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				doPDFExport();
			}

			@Override
			public void mouseDown(MouseEvent e) {

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		print.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				doPrint();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				doPrint();

			}
		});

		print.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				doPrint();
			}

			@Override
			public void mouseDown(MouseEvent e) {

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

	}

	private void doPrint(){
		browser.setUrl("javascript:print()");
	}

	private void doPDFExport(){
		exportToPDF.setEnabled(false);
		try{
			final String fileName = getFileNameToExport();
			exportToPDF(fileName);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			exportToPDF.setEnabled(true);
		}
	}

	private String getFileNameToExport(){
		final Shell shell = Display.getCurrent().getActiveShell();
		final FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setFilterExtensions(new String[] { "*.pdf", });
		final String importFileName = fileDialog.open();
		return importFileName;
	}

	private void exportToPDF(String pdfFile) throws Exception{

		final OutputStream output = new FileOutputStream(pdfFile);

		IReportEngine engine=null;
		EngineConfig config = null;

		try{
			//configure engine and platform; create factory object
			config = new EngineConfig( );
			//config.setBIRTHome("C:\\birt\\birt-runtime-2_2_0\\birt-runtime-2_2_0\\ReportEngine");
			config.setLogConfig(null, Level.OFF);
			final HashMap hm = config.getAppContext();
	        hm.put( EngineConstants.APPCONTEXT_CLASSLOADER_KEY, ReportController.class.getClassLoader());
	        config.setAppContext(hm);

			Platform.startup( config );
			final IReportEngineFactory factory = (IReportEngineFactory) Platform
			.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
			engine = factory.createReportEngine( config );
		}catch( final Exception ex){
			ex.printStackTrace();
		}

		//will create html report from 3 independable parts:
		IReportRunnable designHead, designFoot, designBody = null;
		final URL reportHead = toURL("reports/header.rptdesign");
		final URL reportFoot = toURL("reports/footer.rptdesign");
		final URL reportBody = toURL(this.reportName);

		//acceptors for the rendered data:
		final InputStream reportHeadIS = reportHead.openStream();
		final InputStream reportFootIS = reportFoot.openStream();
		final InputStream reportBodyIS = reportBody.openStream();

		//accessing the design files:
		designHead = engine.openReportDesign(""+reportHead, reportHeadIS);
		designFoot = engine.openReportDesign(""+reportFoot, reportFootIS);
		designBody = engine.openReportDesign(""+reportBody, reportBodyIS);

		//setting the parameters for each report:
		final String month = getMonthSelected();
		final String year = getYearSelected();

		//Create task to run and render the header report
		IRunAndRenderTask task = engine.createRunAndRenderTask(designHead);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", month);
		task.setParameterValue("Name", getReportName());

		setAddressParameters(task);

		task.validateParameters();

		final PDFRenderOption options = new PDFRenderOption();

		ByteArrayOutputStream fso=null, fso2=null, fso3 = null;

		fso = new ByteArrayOutputStream();

		options.setOutputStream(fso);
		options.setOption(IRenderOption.HTML_PAGINATION, new Boolean(false));
		options.setOutputFormat("pdf");

		//ImageHandlerTest
		options.setImageHandler(new HTMLServerImageHandler());
		task.setRenderOption(options);
		task.run();

		// Create task to run and render the report, with the same set of
		// options:
		task = engine.createRunAndRenderTask(designBody);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", ""+getMonthIndex(month));
		task.validateParameters();

		try{
			fso.flush();
			fso.close();
			fso2 = new ByteArrayOutputStream();
		}catch (final Exception e){
			e.printStackTrace();
		}
		options.setOutputStream(fso2);
		task.setRenderOption(options);

		//run the task (it will render from here):
		task.run();

		//task to render a footer:
		task = engine.createRunAndRenderTask(designFoot);

		try{
			fso2.flush();
			fso2.close();
			fso3 = new ByteArrayOutputStream();
		}catch(final Exception e){
			e.printStackTrace();
		}
		options.setOutputStream(fso3);
		task.setRenderOption(options);

		task.run();

		try{
			fso3.flush();
			fso3.close();
		}catch(final Exception e){
			e.printStackTrace();
		}

		//report is done, closing now the staff involved:
		engine.destroy();
		Platform.shutdown();

		//merge PDFs:

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

	private void updateReport(){
		browser.setText("");
		try{
			runReport();
		}
		catch(final Exception e){
			e.printStackTrace();
		}
	}

	private void runComplexReport() {
		updateReport();
	}

	public void runReport() throws EngineException, IOException 	{

		IReportEngine engine=null;
		EngineConfig config = null;

		try{
			//configure engine and platform; create factory object
			config = new EngineConfig( );
			//config.setBIRTHome("C:\\birt\\birt-runtime-2_2_0\\birt-runtime-2_2_0\\ReportEngine");
			config.setLogConfig(null, Level.OFF);
			final HashMap hm = config.getAppContext();
	        hm.put( EngineConstants.APPCONTEXT_CLASSLOADER_KEY, ReportController.class.getClassLoader());
	        config.setAppContext(hm);

			Platform.startup( config );
			final IReportEngineFactory factory = (IReportEngineFactory) Platform
			.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
			engine = factory.createReportEngine( config );
		}catch( final Exception ex){
			ex.printStackTrace();
		}

		//will create html report from 3 independable parts:
		IReportRunnable designHead, designFoot, designBody = null;
		final URL reportHead = toURL("reports/header.rptdesign");
		final URL reportFoot = toURL("reports/footer.rptdesign");
		final URL reportBody = toURL(this.reportName);

		//acceptors for the rendered data:
		final InputStream reportHeadIS = reportHead.openStream();
		final InputStream reportFootIS = reportFoot.openStream();
		final InputStream reportBodyIS = reportBody.openStream();

		//accessing the design files:
		designHead = engine.openReportDesign(""+reportHead, reportHeadIS);
		designFoot = engine.openReportDesign(""+reportFoot, reportFootIS);
		designBody = engine.openReportDesign(""+reportBody, reportBodyIS);

		//setting the parameters for each report:
		final String month = getMonthSelected();
		final String year = getYearSelected();

		//Create task to run and render the header report
		IRunAndRenderTask task = engine.createRunAndRenderTask(designHead);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", month);
		task.setParameterValue("Name", getReportName());

		setAddressParameters(task);

		task.validateParameters();

		final HTMLRenderOption options = new HTMLRenderOption();
		new PDFRenderOption();

		ByteArrayOutputStream fso=null, fso2=null, fso3 = null;

		fso = new ByteArrayOutputStream();

		options.setOutputStream(fso);
		options.setEmbeddable(true);
		options.setEnableInlineStyle(true);
		options.setLayoutPreference(IHTMLRenderOption.LAYOUT_PREFERENCE_AUTO);
		options.setOption(IRenderOption.HTML_PAGINATION, new Boolean(true));
		options.setOutputFormat("html");
		options.setImageDirectory("images");

		//ImageHandlerTest
		options.setImageHandler(new HTMLCompleteImageHandler());
		task.setRenderOption(options);
		task.run();

		// Create task to run and render the report, with the same set of
		// options:
		task = engine.createRunAndRenderTask(designBody);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", ""+getMonthIndex(month));
		task.validateParameters();

		try{
			fso.flush();
			fso.close();
			fso2 = new ByteArrayOutputStream();
		}catch (final Exception e){
			e.printStackTrace();
		}
		options.setOutputStream(fso2);
		task.setRenderOption(options);

		//run the task (it will render from here):
		task.run();

		//task to render a footer:
		task = engine.createRunAndRenderTask(designFoot);

		try{
			fso2.flush();
			fso2.close();
			fso3 = new ByteArrayOutputStream();
		}catch(final Exception e){
			e.printStackTrace();
		}
		options.setOutputStream(fso3);
		task.setRenderOption(options);

		task.run();

		try{
			fso3.flush();
			fso3.close();
		}catch(final Exception e){
			e.printStackTrace();
		}

		//report is done, closing now the staff involved:
		engine.destroy();
		Platform.shutdown();

		//fill the browser object with this html:
		final StringBuffer html = new StringBuffer();
		html.append(fso.toString());
		html.append(fso2.toString());
		html.append(fso3.toString());

		browser.setText(html.toString());

	}

	private Integer getMonthIndex(String monthName){
		for(int i = 0; i<this.months.length; i++){
			if(monthName.equals(this.months[i])){
				return i+1;
			}
		}
		return 0;
	}

	private void setAddressParameters(IRunAndRenderTask task) {
		final Dairy localDairy = dairyRepo.getLocalDairy();
		final String name = localDairy.getLegalName();
		final String phone = localDairy.getPhoneNumber();
		final Location location = localDairy.getLocation();
		final String address = location.getPostalLocation().getAddress();

		task.setParameterValue("LegalName", name == null || name.isEmpty()?"No-name":name);
		task.setParameterValue("Phone", phone == null || phone.isEmpty()?"No-phone":phone);
		task.setParameterValue("Address", address == null || address.isEmpty()?"No-address":address);

	}

	private Object getReportName() {
		if(this.reportName.equals(MILK_COLLECTION_YEAR)){
			return MILK_COLLECTION_YEAR_REPORT_NAME;
		}
		if(this.reportName.equals(MEMBER_PAYABLE_YEAR)){
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

	private void createBrowser() {
			final org.eclipse.swt.layout.GridData gridData3 = new org.eclipse.swt.layout.GridData();
			browser = new Browser(compositeBase, SWT.BORDER);
			gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData3.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData3.grabExcessVerticalSpace = true;
			gridData3.grabExcessHorizontalSpace = true;
			browser.setLayoutData(gridData3);
	}

	private void createComposite(Composite parent) {
		compositeBase = new Composite(parent, SWT.NONE);
		final GridLayout gridLayout0 = new GridLayout(1, false);

//		GridData gridData0 = new GridData();
//		gridData0.grabExcessHorizontalSpace = true;
//		gridData0.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
//		gridData0.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
//		gridData0.grabExcessVerticalSpace = true;

		//compositeBase.setLayoutData(gridData0);
		compositeBase.setLayout(gridLayout0);
		compositeBase.setSize(800, 800);

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		final GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData.grabExcessVerticalSpace = false;
		composite = new Composite(compositeBase, SWT.NONE);
		composite.setLayoutData(gridData);
		composite.setLayout(gridLayout);
		yearLabel = new Label(composite, SWT.NONE);
		yearLabel.setText("Year:");
		yearCombo = new CCombo(composite, SWT.NONE);
		monthLabel = new Label(composite, SWT.NONE);
		monthLabel.setText("Month:");
		monthCombo = new CCombo(composite, SWT.NONE);

		exportToPDF = new Button(composite, SWT.NONE);
		exportToPDF.setText("Export to PDF");

		print = new Button(composite, SWT.NONE);
		print.setText("Print");

	}

	/*
	 * private void createSimpleBrowser(Composite parent) { final Composite top
	 * = new Composite(parent, SWT.NONE); top.setSize(new Point(800, 800));
	 * //top.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	 * top.setLayout(new GridLayout(1, false));
	 * 
	 * this.browser = new Browser(top, SWT.NONE); GridData gd = new
	 * GridData(SWT.FILL, SWT.FILL, true, true); browser.setLayoutData(gd);
	 * 
	 * previewReport();
	 * 
	 * }
	 * 
	 * private void previewReport() {
	 * 
	 * 
	 * try { String report = this.reportName; URL url = toURL(report); //
	 * HashMap params = new HashMap(); // params.put(WebViewer.SERVLET_NAME_KEY,
	 * WebViewer.VIEWER_FRAMESET); // params.put(WebViewer.FORMAT_KEY,
	 * WebViewer.HTML); // // // WebViewer.display(""+url, browser, params);
	 * 
	 * // WebViewer.startup(); // String myurl = "http://" +
	 * WebappAccessor.getHost( ) + ":" // + WebappAccessor.getPort( "viewer" )+
	 * "/viewer/"+ // "frameset"+ // "?__report="+url+ //
	 * "&__format=html&__svg=false&__locale=us_US&__masterpage=true&__rtl=false"
	 * + //
	 * "&__cubememsize=10&__resourceFolder=&__dpi=96&__showtitle=false&__title=&"
	 * +random.nextInt(); // // browser.setUrl(myurl);
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

    public static URL getRCPRootURL() {
    	final Activator a = Activator.getDefault();

        if(a != null) {
        	final Bundle b = Activator.context.getBundle();
        	if(b != null){
        		final URL rootURL = b.getEntry("/");
        		return rootURL;
        	}
        }
        return null;
    }

    public static URL toURL(String relativeResoursePath) {
        if(relativeResoursePath == null || "".equals(relativeResoursePath)) {
            return null;
        }
        try {
            return new URL(getRCPRootURL(), "resources/" + relativeResoursePath);
        } catch (final Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
