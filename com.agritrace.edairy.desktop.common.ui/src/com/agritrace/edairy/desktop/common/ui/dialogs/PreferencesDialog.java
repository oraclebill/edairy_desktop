package com.agritrace.edairy.desktop.common.ui.dialogs;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.ui.controllers.SiteSettingsController;
import com.agritrace.edairy.desktop.common.ui.controllers.SystemSettingsController;

/**
 * Preferences dialog invoked from the Preference menu, with two pages.
 * 
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class PreferencesDialog extends PreferenceDialog {
	private static final class SitePrefsPage extends FieldEditorPreferencePage {
		private SiteSettingsController controller;
		
		public SitePrefsPage() {
			super("Site preferences", GRID);
			setDescription("Settings that affect the client installation.");
			controller = new SiteSettingsController();
		}
		
		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			getDefaultsButton().dispose();
		}
		
		@Override
		public boolean performOk() {
			try {
				// Update preference store before saving
				super.performOk();
				
				if (controller.saveData()) {
					MessageDialog dlg = new MessageDialog(this.getControl().getShell(), "Settings saved", null,
							"The user settings have been saved. The new database settings will not be used " +
							"until the application is restarted.", MessageDialog.INFORMATION,
							new String[] { "Continue", "Restart Application" }, 1);
					
					if (dlg.open() == 1) {
						PlatformUI.getWorkbench().restart();
					}
				}
				
				return true;
			} catch (IOException e) {
				MessageDialog.openError(this.getControl().getShell(), "Error", e.getMessage());
				return false;
			}
		}
		
		@Override
		protected void createFieldEditors() {
			setPreferenceStore(controller.loadData());
			Composite comp = getFieldEditorParent();
			
			addField(new StringFieldEditor(SiteSettingsController.DB_HOST, "Database host:", comp));
			addField(new StringFieldEditor(SiteSettingsController.DB_NAME, "Database name:", comp));
			addField(new StringFieldEditor(Environment.USER, "Database user:", comp));
			addField(new StringFieldEditor(Environment.PASS, "Database password:", comp));
		}
	}
	
	private static class UserPrefsPage extends PreferencePage {
		public UserPrefsPage() {
			super("User preferences");
			setDescription("Users are not yet implemented.");
			noDefaultAndApplyButton();
		}
		
		@Override
		protected Control createContents(Composite parent) {
			return null;
		}
	}
	
	private static final class SystemPrefsPage extends FieldEditorPreferencePage {
		private SystemSettingsController controller;
		
		public SystemPrefsPage() {
			super("System preferences", GRID);
			setDescription("Settings that affect the entire application system.");
			controller = new SystemSettingsController();
		}
		
		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);
			getDefaultsButton().dispose();
		}
		
		@Override
		public boolean performOk() {
			super.performOk();
			
			try {
				controller.saveData();
				return true;
			} catch (IOException e) {
				return false;
			}
		}

		@Override
		protected void createFieldEditors() {
			setPreferenceStore(controller.loadData());
			Composite comp = getFieldEditorParent();
			
			addField(new BooleanFieldEditor(SystemSettingsController.ENCRYPT_PASSWORDS,
					"Encrypt passwords for newly edited employees", comp));
		}
	}
	
	public PreferencesDialog(Shell parentShell) {
		super(parentShell, createPreferenceManager());
	}
	
	@Override
	protected void handleSave() {
		// Do nothing, everything is saved in performOk events
	}
	
	private static PreferenceManager createPreferenceManager() {
		PreferenceManager manager = new PreferenceManager();
		manager.addToRoot(new PreferenceNode("site", new SitePrefsPage()));
		manager.addToRoot(new PreferenceNode("user", new UserPrefsPage()));
		manager.addToRoot(new PreferenceNode("system", new SystemPrefsPage()));
		return manager;
	}
}
