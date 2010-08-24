package com.agritrace.edairy.desktop.common.ui.controllers;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;

public class UserSettingsController {
	private Properties props;
	private Text dbHost;
	private Text dbName;
	private Text dbUser;
	private Text dbPass;
	
	public void addControls(Composite area) {
		GridDataFactory factory = GridDataFactory.swtDefaults().hint(200, SWT.DEFAULT);
		
		new Label(area, SWT.LEFT).setText("Database host:");
		dbHost = new Text(area, SWT.BORDER);
		factory.applyTo(dbHost);
		
		new Label(area, SWT.LEFT).setText("Database name:");
		dbName = new Text(area, SWT.BORDER);
		factory.applyTo(dbName);
		
		new Label(area, SWT.LEFT).setText("Database user:");
		dbUser = new Text(area, SWT.BORDER);
		factory.applyTo(dbUser);
		
		new Label(area, SWT.LEFT).setText("Database password:");
		dbPass = new Text(area, SWT.BORDER);
		factory.applyTo(dbPass);
	}
	
	public void loadData() {
		props = PersistenceManager.getDefault().getProperties();
		Matcher matcher = Pattern.compile("jdbc:mysql://(.*)/(.*)").matcher(props.getProperty(Environment.URL));
		matcher.matches();
		dbHost.setText(matcher.group(1));
		dbName.setText(matcher.group(2));
		dbUser.setText(props.getProperty(Environment.USER));
		dbPass.setText(props.getProperty(Environment.PASS));
	}
	
	/**
	 * Save the properties.
	 * 
	 * @return Whether the database properties have been modified since last change.
	 * @throws IOException
	 */
	public boolean saveData() throws IOException {
		String url = String.format("jdbc:mysql://%s/%s", dbHost.getText(), dbName.getText());
		String user = dbUser.getText();
		String pass = dbPass.getText();
		
		if (url.equals(props.getProperty(Environment.URL)) && user.equals(props.getProperty(Environment.USER)) &&
				pass.equals(props.getProperty(Environment.PASS))) {
			return false;
		}
		
		props.setProperty(Environment.URL, url);
		props.setProperty(Environment.USER, user);
		props.setProperty(Environment.PASS, pass);
		
		PersistenceManager.getDefault().saveProperties(props);
		return true;
	}
}
