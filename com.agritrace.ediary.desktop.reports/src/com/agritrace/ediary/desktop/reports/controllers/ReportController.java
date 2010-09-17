package com.agritrace.ediary.desktop.reports.controllers;

import java.net.URL;

import org.eclipse.birt.report.viewer.utilities.WebViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.Bundle;

import com.agritrace.ediary.desktop.reports.Activator;


public class ReportController {

	private Browser browser;

	public void createPartControl(Composite parent) {
		final Composite top = new Composite(parent, SWT.NONE);
		top.setSize(new Point(800, 800));
		//top.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		top.setLayout(new GridLayout(1, false));

		this.browser = new Browser(top, SWT.NONE);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		browser.setLayoutData(gd);

		previewReport();
	}

	private void previewReport() {


		try {
			String report = "reports/YearReport.rptdesign";
			URL url = toURL(report);
		
			WebViewer.display(""+url, WebViewer.HTML, browser, "frameset");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
    public static URL getRCPRootURL() {
    	Activator a = Activator.getDefault();
        
        if(a != null) {
        	Bundle b = a.getBundle();
        	if(b != null){
        		URL rootURL = b.getEntry("/");
        		return rootURL;
        	}
        }
        return null;
    }

    public static URL toURL(String relativeResoursePath) {
        if((relativeResoursePath == null) || "".equals(relativeResoursePath)) {
            return null;
        }
        try {
            return new URL(getRCPRootURL(), "resources/" + relativeResoursePath);
        } catch (Throwable e) {
            e.printStackTrace();           
            return null;
        }
    }
    
    
}
