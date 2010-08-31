package com.agritrace.edairy.desktop.reporting.views;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IParameterDefn;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public abstract class SimpleReportView extends ViewPart {
	
	public SimpleReportView() {
	}

//	public static final String ID = "com.agritrace.edairy.desktop.reporting.views";

	private Browser browser;

	abstract protected String getReportURL() ;

	/**
	 * 
	 * 
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());
		GridData gd = new GridData(GridData.FILL_BOTH);

		browser = new Browser(parent, SWT.NONE);

		browser.setLayoutData(gd);
		try {
			previewReport( getReportURL() );
		}
		catch(EngineException ee) {
			ee.printStackTrace();
		}

	}

	/**
	 * 
	 * @param rpt
	 * @throws EngineException
	 */
	private void previewReport(String rpt) throws EngineException {

		EngineConfig config = new EngineConfig();

		try {

			// use this to set the resource path
			// Bundle bundle =
			// org.eclipse.core.runtime.Platform.getBundle("org.eclipse.birt.examples.rcpengine");
			// URL url = FileLocator.find(bundle, new Path("/resources"), null);
			// String myresourcepath = FileLocator.toFileURL(url).getPath();
			// config.setResourcePath(myresourcepath);

			// Create the report engine
			IReportEngineFactory factory = (IReportEngineFactory) org.eclipse.birt.core.framework.Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			IReportEngine engine = factory.createReportEngine(config);

			IReportRunnable design = null;
			// String rpt = reportLocation.getText();

			// use this if the report is in the bundle
			// Bundle bundle =
			// org.eclipse.core.runtime.Platform.getBundle("org.eclipse.birt.examples.rcpengine");
			// URL url = FileLocator.find(bundle, new
			// Path("/reports/TopNPercent.rptdesign"), null);
			// String rpt = FileLocator.toFileURL(url).getPath();

			// add to the classpath
			// System.setProperty( EngineConstants.WEBAPP_CLASSPATH_KEY,
			// "c:/myclasses" );
			// config.setProperty(EngineConstants.WEBAPP_CLASSPATH_KEY,
			// "c:/myclasses");

			design = engine.openReportDesign(rpt);
			
			processReportParameters(engine, design);

			IRunAndRenderTask task = engine.createRunAndRenderTask(design);

			HTMLRenderOption options = new HTMLRenderOption();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			options.setOutputStream(bos);
			options.setOutputFormat("html");

			task.setRenderOption(options);
			task.run();
			task.close();

			browser.setText(bos.toString());
			System.out.println("finished");
			// engine.destroy();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void processReportParameters(IReportEngine engine,
			IReportRunnable design) {
		IGetParameterDefinitionTask parameterTask = engine
				.createGetParameterDefinitionTask(design);
		Collection<IParameterDefn> parameters = parameterTask
				.getParameterDefns(false);

		if (parameters.size() == 0) return;
		
		Composite panel = new Composite(null, SWT.NULL);
		final Map<String, Object> params = new HashMap<String, Object>();

		for (final IParameterDefn param : parameters) {

			if (param.isHidden())
				continue;

			if (!param.isRequired())
				continue;

			String paramLabelString = param.getDisplayName();
			final String paramName = param.getName();
			int paramType = param.getParameterType();
			
			switch (paramType) {
			case IParameterDefn.SCALAR_PARAMETER:
			
				Composite row = new Composite(panel, SWT.NULL);
				row.setLayout(new GridLayout(2, false));
				Label label = new Label(row, SWT.NULL);
				label.setText(param.getDisplayName());
				label.setLayoutData(GridDataFactory.defaultsFor(label).create());

				final Text data = new Text(panel, SWT.NULL);
//				data.setData("parameter-name", param.getName());
				data.setLayoutData(GridDataFactory.defaultsFor(data).create());
				data.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent e) {
						params.put(paramName, data.getText());
					}					
				});
				
				continue;
				
			case IParameterDefn.LIST_PARAMETER:
				continue;
				
			case IParameterDefn.FILTER_PARAMETER:
				continue;
				
			case IParameterDefn.TABLE_PARAMETER:
				continue;
				
			case IParameterDefn.CASCADING_PARAMETER_GROUP:
				continue;
				
			default:
				continue;
				
			}
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {

	}
}