package com.agritrace.edairy.desktop.splashHandlers;

import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.ui.internal.StartupThreading.StartupRunnable;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.ui.controllers.AuthController;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class EdairySplashHandler extends EclipseSplashHandler {
	@Inject
	private static Provider<AuthController> PROVIDER;

	private static final int WAIT_MSEC = 5000;

	private AuthController authController = null;
	private boolean okPressed = false;
	private boolean authenticated = false;
	private boolean authFailed = false;
	private boolean developerMode = false;

	private Label developerLabel;
	private Text username;
	private Text password;
	private Button buttonOK;
	private Button buttonCancel;
	private Font font;

	@Override
	public void init(Shell splash) {
		super.init(splash);

		String testval = System.getenv("EDAIRY_DEVELOPER_MODE");
		if (null != testval && testval.equalsIgnoreCase("true")) {
			developerMode = true;
		}

		do {
			createLoginControls();

			while (!okPressed) {
				if (splash.getDisplay().readAndDispatch() == false) {
					splash.getDisplay().sleep();
				}
			}

			String usernameText = username.getText();
			String passwordText = password.getText();

			restoreProgressWindow();
			runLoginProgress(splash, usernameText, passwordText);

			final long endTime = System.currentTimeMillis() + WAIT_MSEC;
			while (!authFailed && !authenticated) {
				if (splash.getDisplay().readAndDispatch() == false) {
					splash.getDisplay().sleep();
				}
				System.out.println("0: authfailed? " + authFailed + ", authenticated? " + authenticated);
			}
			System.out.println("1: authfailed? " + authFailed + ", authenticated? " + authenticated);
		} while (authFailed);
		System.out.println("2: authfailed? " + authFailed + ", authenticated? " + authenticated);
	}

	private void createLoginControls() {
		okPressed = false;

		final Composite content = getContent();
		content.setBackgroundImage(Activator.getImage("splash/loginSplash.bmp"));

		for (final Control child : content.getChildren()) {
			child.setVisible(false);
		}

		if (developerMode) {
			// TODO: Remove this in the final version
			developerLabel = new Label(content, SWT.NONE);
			developerLabel.setText("Developer version; empty login and password give administrator access");
			developerLabel.setForeground(new Color(developerLabel.getDisplay(), 240, 240, 240));
			developerLabel.setBounds(0, 153, content.getBounds().width, 20);
			developerLabel.setAlignment(SWT.CENTER);
		}

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
				okPressed = true;
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

		if (null != developerLabel)
			developerLabel.dispose();
		username.dispose();
		password.dispose();
		buttonCancel.dispose();
		buttonOK.dispose();
		font.dispose();

		for (final Control child : content.getChildren()) {
			child.setVisible(true);
		}
	}

	private void runLoginProgress(final Shell splash, final String username, final String password) {
		authFailed = false;
		final IProgressMonitor monitor = getBundleProgressMonitor();
		monitor.beginTask("Logging in", 2);

		StartupRunnable loginRunner = new StartupRunnable() {
			@Override
			public void runWithException() throws Throwable {
				monitor.subTask("Initializing database connection");

				if (authController == null) {
					authController = PROVIDER.get();
				}

				monitor.worked(1);
				monitor.subTask("Authenticating");
				authenticated = authController.authenticate(username, password);
				monitor.worked(1);

				if (!authenticated) {
					MessageDialog.openWarning(getSplash(), "Authentication Failure",
							"You have entered an invalid username or password");

					authFailed = true;
				}
			}
		};
		splash.getDisplay().syncExec(loginRunner);

		// fail on error
		final Throwable failureException = loginRunner.getThrowable();
		if (failureException != null) {
			MessageDialog.openError(getSplash(), "System Error", failureException.getMessage());
			System.exit(-1); // TODO: not the right way to close...
		}
	}
}
