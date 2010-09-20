package com.agritrace.edairy.desktop.splashHandlers;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.ui.controllers.AuthController;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EdairySplashHandler extends EclipseSplashHandler {
	private static final int WAIT_MSEC = 5000;
	
	private boolean authenticated = false;
	private Label developerLabel;
	private Text username;
	private Text password;
	private Button buttonOK;
	private Button buttonCancel;
	private Font font;
	
	@Inject
	public EdairySplashHandler(Date date) {
		System.out.println("Date: " + date);
	}
	
	@Override
	public void init(Shell splash) {
		super.init(splash);
		final RuntimeMXBean mx = ManagementFactory.getRuntimeMXBean();
		
		// Wait until the VM has been up for 5 seconds
		while (mx.getUptime() < WAIT_MSEC) {
			if (splash.getDisplay().readAndDispatch() == false) {
				splash.getDisplay().sleep();
			}
		}

		getContent().setBackgroundImage(Activator.getImage("splash/splash.bmp"));
		long endTime = System.currentTimeMillis() + WAIT_MSEC;
		
		while (System.currentTimeMillis() < endTime) {
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
		final Composite content = getContent();
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
		username.setBounds(276, 178, 226, 33);
		
		password = new Text(content, SWT.PASSWORD);
		password.setBounds(276, 216, 226, 33);
		
		buttonCancel = new Button(content, SWT.PUSH);
		buttonCancel.setText("Cancel");
		buttonCancel.setBounds(20, 262, 115, 46);
		
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlatformUI.getWorkbench().close();
			}
			
		});
		
		buttonOK = new Button(content, SWT.PUSH);
		buttonOK.setText("Login");
		buttonOK.setBounds(387, 262, 115, 46);
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

		final FontDescriptor desc = JFaceResources.getDialogFontDescriptor().setHeight(14);
		font = desc.createFont(content.getDisplay());
		username.setFont(font);
		password.setFont(font);
		buttonOK.setFont(font);
		buttonCancel.setFont(font);
	}
	
	private void restoreProgressWindow() {
		final Composite content = getContent();
		content.setBackgroundImage(Activator.getImage("splash/splash.bmp"));
		
		developerLabel.dispose();
		username.dispose();
		password.dispose();
		buttonCancel.dispose();
		buttonOK.dispose();
		font.dispose();
		
		for (Control child: content.getChildren()) {
			child.setVisible(true);
		}
	}
}
