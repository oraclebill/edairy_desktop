package com.agritrace.edairy.desktop.splashHandlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.StartupThreading.StartupRunnable;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.ui.controllers.AuthController;

@SuppressWarnings("restriction")
public class EdairySplashHandler extends EclipseSplashHandler {
	private volatile boolean initialized = false;
	private boolean authenticated = false;
	private Label developerLabel;
	private Text username;
	private Text password;
	private Button buttonOK;
	private Button buttonCancel;
	
	@Override
	public void init(Shell splash) {
		super.init(splash);
		getContent().setBackgroundImage(Activator.getImage("splash/splash.bmp"));
		
		final IProgressMonitor monitor = getBundleProgressMonitor();
		monitor.beginTask("Initializing database", 2);
		
		getSplash().getDisplay().asyncExec(new StartupRunnable() {
			@Override
			public void runWithException() throws Throwable {
				PersistenceManager pm = PersistenceManager.getDefault();
				monitor.worked(1);
				// Force Hibernate to initialize - how should we do this elegantly?
				pm.getSession().close();
				monitor.worked(1);
				
				initialized = true;
			}
		});
		
		doEventLoop();
	}
	
	private void doEventLoop() {
		Shell splash = getSplash();
		while (!initialized) {
			if (splash.getDisplay().readAndDispatch() == false) {
				splash.getDisplay().sleep();
			}
		}
		
		createLoginControls();

		while (!authenticated) {
			if (splash.getDisplay().readAndDispatch() == false) {
				splash.getDisplay().sleep();
			}
		}
		
		restoreProgressWindow();
	}
	
	private void createLoginControls() {
		Composite content = getContent();
		content.setBackgroundImage(Activator.getImage("splash/loginSplash.bmp"));
		
		for (Control child: content.getChildren()) {
			child.setVisible(false);
		}
		
		// TODO: Remove this in the final version
		developerLabel = new Label(content, SWT.NONE);
		developerLabel.setText("Developer version; empty login and password give administrator access");
		developerLabel.setForeground(new Color(developerLabel.getDisplay(), 240, 240, 240));
		developerLabel.setBounds(0, 153, content.getBounds().width, 20);
		developerLabel.setAlignment(SWT.CENTER);
		
		username = new Text(content, SWT.NONE);
		username.setBounds(266, 178, 226, 33);
		
		password = new Text(content, SWT.PASSWORD);
		password.setBounds(266, 216, 226, 33);
		
		buttonCancel = new Button(content, SWT.PUSH);
		buttonCancel.setText("Cancel");
		buttonCancel.setBounds(30, 272, 105, 36);
		
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlatformUI.getWorkbench().close();
			}
			
		});
		
		buttonOK = new Button(content, SWT.PUSH);
		buttonOK.setText("Login");
		buttonOK.setBounds(387, 272, 105, 36);
		getSplash().setDefaultButton(buttonOK);
		
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				authenticated = AuthController.authenticate(username.getText(), password.getText());
				
				if (!authenticated) {
					MessageDialog.openWarning(getSplash(), "Authentication Failure",
							"You have entered an invalid username or password");
				}
			}
			
		});
	}
	
	private void restoreProgressWindow() {
		Composite content = getContent();
		content.setBackgroundImage(Activator.getImage("splash/splash.bmp"));
		
		developerLabel.dispose();
		username.dispose();
		password.dispose();
		buttonCancel.dispose();
		buttonOK.dispose();
		
		for (Control child: content.getChildren()) {
			child.setVisible(true);
		}
	}
}
