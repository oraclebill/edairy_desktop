package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Preferences dialog invoked from the Preference menu, with two pages.
 * 
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class PreferencesDialog extends PreferenceDialog {
	private static final class UserPrefsPage extends PreferencePage {
		public UserPrefsPage() {
			super("User preferences");
			setDescription("Settings that affect the client installation.");
		}
		
		@Override
		protected Control createContents(Composite parent) {
			final Composite area = new Composite(parent, SWT.NONE);
			GridDataFactory factory = GridDataFactory.swtDefaults().grab(true, false);
			area.setLayout(new GridLayout(2, false));
			factory.applyTo(area);
			
			factory = factory.grab(false, false).hint(200, SWT.DEFAULT);
			
			new Label(area, SWT.LEFT).setText("Database host");
			factory.applyTo(new Text(area, SWT.BORDER));
			new Label(area, SWT.LEFT).setText("Database name");
			factory.applyTo(new Text(area, SWT.BORDER));
			new Label(area, SWT.LEFT).setText("Database user");
			factory.applyTo(new Text(area, SWT.BORDER));
			new Label(area, SWT.LEFT).setText("Database password");
			factory.applyTo(new Text(area, SWT.BORDER));
			
			return area;
		}
		
		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			getDefaultsButton().dispose();
		}
	}
	
	private static final class SystemPrefsPage extends PreferencePage {
		public SystemPrefsPage() {
			super("System preferences");
			setDescription("Settings that affect the entire application system.");
		}
		
		@Override
		protected Control createContents(Composite parent) {
			final Composite area = new Composite(parent, SWT.NONE);
			area.setLayout(new GridLayout(2, false));
			
			final Button checkbox = new Button(area, SWT.CHECK);
			checkbox.setText("Encrypt user passwords");
			GridDataFactory.swtDefaults().span(2, 1).applyTo(checkbox);
			return area;
		}
		
		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			getDefaultsButton().dispose();
		}
	}
	
	public PreferencesDialog(Shell parentShell) {
		super(parentShell, createPreferenceManager());
	}
	
	private static PreferenceManager createPreferenceManager() {
		PreferenceManager manager = new PreferenceManager();
		manager.addToRoot(new PreferenceNode("user", new UserPrefsPage()));
		manager.addToRoot(new PreferenceNode("system", new SystemPrefsPage()));
		return manager;
	}
}
