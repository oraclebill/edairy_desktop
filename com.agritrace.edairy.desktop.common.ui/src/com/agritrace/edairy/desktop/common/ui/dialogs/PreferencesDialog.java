package com.agritrace.edairy.desktop.common.ui.dialogs;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.controllers.SystemSettingsController;
import com.agritrace.edairy.desktop.common.ui.controllers.UserSettingsController;

/**
 * Preferences dialog invoked from the Preference menu, with two pages.
 * 
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class PreferencesDialog extends PreferenceDialog {
	private static final class UserPrefsPage extends PreferencePage {
		private UserSettingsController controller;
		
		public UserPrefsPage() {
			super("User preferences");
			setDescription("Settings that affect the client installation.");
			controller = new UserSettingsController();
		}
		
		@Override
		protected Control createContents(Composite parent) {
			final Composite area = new Composite(parent, SWT.NONE);
			GridDataFactory factory = GridDataFactory.swtDefaults().grab(true, false);
			area.setLayout(new GridLayout(2, false));
			factory.applyTo(area);
			
			controller.addControls(area);
			controller.loadData();
			
			return area;
		}
		
		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			getDefaultsButton().dispose();
		}
		
		@Override
		public boolean performOk() {
			try {
				if (controller.saveData()) {
					MessageDialog.openInformation(this.getControl().getShell(), "Settings saved", 
							"The user settings have been saved. The new database settings will not be used " +
							"until the application is restarted.");
				}
				
				return true;
			} catch (IOException e) {
				return false;
			}
		}
	}
	
	private static final class SystemPrefsPage extends PreferencePage {
		private SystemSettingsController controller;
		
		public SystemPrefsPage() {
			super("System preferences");
			setDescription("Settings that affect the entire application system.");
			controller = new SystemSettingsController();
		}
		
		@Override
		protected Control createContents(Composite parent) {
			final Composite area = new Composite(parent, SWT.NONE);
			area.setLayout(new GridLayout(2, false));
			controller.addControls(area);
			controller.loadData();
			return area;
		}
		
		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			getDefaultsButton().dispose();
		}
		
		@Override
		public boolean performOk() {
			controller.saveData();
			return true;
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
