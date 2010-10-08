package com.agritrace.ediary.desktop.reports.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLCompleteImageHandler;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IHTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.viewer.utilities.WebViewer;
import org.eclipse.birt.report.viewer.utilities.WebappAccessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.ediary.desktop.reports.Activator;


public class ReportController {

	public static final String MILK_COLLECTION_YEAR = "reports/YearReport.rptdesign";
	public static final String MILK_COLLECTION_YEAR_REPORT_NAME = "MILK COLLECTION REPORT";
	public static final String MEMBER_PAYABLE_YEAR = "reports/YearMemberPayableReport.rptdesign";
	public static final String MEMBER_PAYABLE_YEAR_REPORT_NAME = "MEMBER PAYABLE REPORT";

	private Browser browser;
	private final Random random = new Random();

	private  IDairyRepository dairyRepo;

	private final String reportName;
	private Composite composite;
	private Label yearLabel;
	private CCombo yearCombo;
	private CCombo monthCombo;
	private Composite compositeBase;

	private final String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private Label monthLabel;

	public ReportController(String reportName){
		this.reportName = reportName;
	}

	public void createPartControl(Composite parent) {
		//createSimpleBrowser(parent);
		createComplexReportPage(parent);
	}

	/**
	 * complext report page contains from a set of controls that can be used to manage report like year selection, refresh button and
	 * page management buttons (if needed)
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

		IReportRunnable designHead, designFoot, designBody = null;
		final URL reportHead = toURL("reports/header.rptdesign");
		final URL reportFoot = toURL("reports/footer.rptdesign");
		final URL reportBody = toURL(this.reportName);

		final InputStream reportHeadIS = reportHead.openStream();
		final InputStream reportFootIS = reportFoot.openStream();
		final InputStream reportBodyIS = reportBody.openStream();

		designHead = engine.openReportDesign(""+reportHead, reportHeadIS);
		designFoot = engine.openReportDesign(""+reportFoot, reportFootIS);
		designBody = engine.openReportDesign(""+reportBody, reportBodyIS);

		final String month = getMonthSelected();
		final String year = getYearSelected();

		//Create task to run and render the report,
		IRunAndRenderTask task = engine.createRunAndRenderTask(designHead);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", month);
		task.setParameterValue("Name", getReportName());

		setAddressParameters(task);

		task.validateParameters();

		final HTMLRenderOption options = new HTMLRenderOption();

		ByteArrayOutputStream fso=null, fso2=null, fso3 = null;

		fso = new ByteArrayOutputStream();

		options.setOutputStream(fso);
		options.setEmbeddable(true);
		options.setEnableInlineStyle(true);
		options.setLayoutPreference(IHTMLRenderOption.LAYOUT_PREFERENCE_AUTO);
		options.setOutputFormat("html");
		options.setImageDirectory("images");

		//ImageHandlerTest
		//options.setImageHandler(new MyImageHandler());
		//options.setImageHandler(new HTMLServerImageHandler());
		options.setImageHandler(new HTMLCompleteImageHandler());
		task.setRenderOption(options);
		task.run();

		//Create task to run and render the report,
		task = engine.createRunAndRenderTask(designBody);
		task.setParameterValue("Year", year);
		task.setParameterValue("Month", month);
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


		task.run();

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


		engine.destroy();
		Platform.shutdown();
		System.out.println("Finished");


		//fill the browser with this html:

		final StringBuffer html = new StringBuffer();
		html.append(fso.toString());
		html.append(fso2.toString());
		html.append(fso3.toString());

		browser.setText(html.toString());

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
		gridLayout.numColumns = 4;
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
	}


	private void previewReport() {


		try {
			final String report = this.reportName;
			final URL url = toURL(report);
//			HashMap params = new HashMap();
//			params.put(WebViewer.SERVLET_NAME_KEY, WebViewer.VIEWER_FRAMESET);
//			params.put(WebViewer.FORMAT_KEY, WebViewer.HTML);
//
//
//			WebViewer.display(""+url, browser, params);

			WebViewer.startup();
			final String myurl = "http://" + WebappAccessor.getHost( ) + ":"
			+ WebappAccessor.getPort( "viewer" )+ "/viewer/"+
			"frameset"+
			"?__report="+url+
			"&__format=html&__svg=false&__locale=us_US&__masterpage=true&__rtl=false"+
			"&__cubememsize=10&__resourceFolder=&__dpi=96&__showtitle=false&__title=&"+random.nextInt();

			browser.setUrl(myurl);


		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

    public static URL getRCPRootURL() {
    	final Activator a = Activator.getDefault();

        if(a != null) {
        	final Bundle b = a.getBundle();
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


