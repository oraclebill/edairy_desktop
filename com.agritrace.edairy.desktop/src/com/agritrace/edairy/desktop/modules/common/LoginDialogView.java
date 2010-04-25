package com.agritrace.edairy.desktop.modules.common;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LoginDialogView extends AbstractDialogView {
	
	protected LoginDialogView(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	private Text txtUsername;
	private Text txtPassword;
	

	@Override
	protected Control buildView(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new FillLayout());
		Composite panel = createLoginPanel(parent);
		return panel;
	}

	@Override
	protected AbstractWindowController createController() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Composite createLoginPanel(Composite parent) {
		
		Composite panel = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false).applyTo(panel);
		
		UIControlsFactory.createLabel(panel, "Username");
		txtUsername = UIControlsFactory.createText(panel, SWT.SINGLE, "login.username");
		
		UIControlsFactory.createLabel(panel, "Password");
		txtPassword = UIControlsFactory.createText(panel, SWT.SINGLE | SWT.PASSWORD, "login.password");
		
		return parent;
	}

}
