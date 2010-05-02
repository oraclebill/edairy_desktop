package com.agritrace.edairy.riena.ui.views;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class SplashLoginDialogView extends AbstractDialogView {

	protected SplashLoginDialogView(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView#buildView(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control buildView(Composite parent) {
		// TODO Auto-generated method stub
		return new Composite(parent, SWT.NONE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView#createController()
	 */
	@Override
	protected AbstractWindowController createController() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		Shell shell = new Shell();
		SplashLoginDialogView dlg  = new SplashLoginDialogView(shell);
		dlg.create();
	}
}
