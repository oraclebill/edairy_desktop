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

import com.agritrace.edairy.desktop.common.ui.controllers.SiteSettingsController;
import com.agritrace.edairy.desktop.common.ui.controllers.SystemSettingsController;
import com.google.inject.Inject;

/**
 * Preferences dialog invoked from the Preference menu, with two pages.
 *
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class PreferencesDialog extends PreferenceDialog {
	protected static final class SitePrefsPage extends FieldEditorPreferencePage {
		private final SiteSettingsController controller;

		@Inject
		public SitePrefsPage(SiteSettingsController controller) {
			super("Site preferences", GRID);
			setDescription("Settings that affect the client installation.");
			this.controller = controller;
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
					final MessageDialog dlg = new MessageDialog(this.getControl().getShell(), "Settings saved", null,
							"The user settings have been saved. The new database settings will not be used " +
							"until the application is restarted.", MessageDialog.INFORMATION,
							new String[] { "Continue", "Restart Application" }, 1);

					if (dlg.open() == 1) {
						PlatformUI.getWorkbench().restart();
					}
				}

				return true;
			} catch (final IOException e) {
				MessageDialog.openError(this.getControl().getShell(), "Error", e.getMessage());
				return false;
			}
		}

		@Override
		protected void createFieldEditors() {
			setPreferenceStore(controller.loadData());
			final Composite comp = getFieldEditorParent();

			addField(new StringFieldEditor(SiteSettingsController.DB_HOST, "Database host:", comp));
			addField(new StringFieldEditor(SiteSettingsController.DB_NAME, "Database name:", comp));
			addField(new StringFieldEditor("hibernate.connection.username", "Database user:", comp));		// TODO: replace with application specific key
			addField(new StringFieldEditor("hibernate.connection.password", "Database password:", comp));   // TODO: replace with application specific key
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

	protected static final class SystemPrefsPage extends FieldEditorPreferencePage {
		private final SystemSettingsController controller;

		@Inject
		public SystemPrefsPage(final SystemSettingsController controller) {
			super("System preferences", GRID);
			setDescription("Settings that affect the entire application system.");
			this.controller = controller;
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
			} catch (final IOException e) {
				return false;
			}
		}

		@Override
		protected void createFieldEditors() {
			setPreferenceStore(controller.loadData());
			final Composite comp = getFieldEditorParent();

			addField(new BooleanFieldEditor(SystemSettingsController.ENCRYPT_PASSWORDS,
					"Encrypt passwords for newly edited employees", comp));
		}
	}

	@Inject
	public PreferencesDialog(Shell parentShell, SitePrefsPage sitePrefsPage, SystemPrefsPage systemPrefsPage) {
		super(parentShell, createPreferenceManager(sitePrefsPage, systemPrefsPage));
	}

	@Override
	protected void handleSave() {
		// Do nothing, everything is saved in performOk events
	}

	private static PreferenceManager createPreferenceManager(SitePrefsPage sitePrefsPage, SystemPrefsPage systemPrefsPage) {
		final PreferenceManager manager = new PreferenceManager();
		manager.addToRoot(new PreferenceNode("site", sitePrefsPage));
		manager.addToRoot(new PreferenceNode("user", new UserPrefsPage()));
		manager.addToRoot(new PreferenceNode("system", systemPrefsPage));
		return manager;
	}
}
