package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;

public abstract class PWPage extends WizardPage {

	public PWPage(String pageName) {
		super(pageName);
	}

	public PWPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	protected int getInt(String key) {
		int ret = 0;
		try {
			ret = getWizard().getDialogSettings().getInt(key);
		} catch( final NumberFormatException nfe) {
			;
		}
		return ret;
	}

	protected String get(String key) {
		String ret = null;
		try {
			ret = getWizard().getDialogSettings().get(key);
		} catch( final NumberFormatException nfe) {
			;
		}
		return ret;
	}

	protected void put(String key, String value) {
		getWizard().getDialogSettings().put(key, value);
	}

	protected void put(String key, int value) {
		getWizard().getDialogSettings().put(key, value);
	}

	protected void put(String key, String[] value) {
		getWizard().getDialogSettings().put(key, value);
	}
}