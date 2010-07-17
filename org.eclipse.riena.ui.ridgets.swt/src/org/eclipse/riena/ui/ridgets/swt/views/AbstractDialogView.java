/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.swt.views;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.RienaWindowRenderer;
import org.eclipse.riena.ui.swt.lnf.LnFUpdater;
import org.eclipse.riena.ui.swt.utils.SWTControlFinder;

/**
 * Base class for Riena Dialogs. This class enchances JFace dialogs by adding:
 * (a) theming capabilities based on the current Look-and-Feel, (b) providing
 * View / Controller seperation, (c) binding the View's widgets to the
 * Controller's ridgets.
 * <p>
 * Implementors have to subclass this class and provide these methods:
 * <ol>
 * <li>createController() - returns the Controller for this dialog</li>
 * <li>buildView() - creates the UI for this dialog. This incldues creating the
 * appropriate buttons, such as Ok and Cancel.</li>
 * </ol>
 * This subclass can then be used as any other JFace dialog: create a new
 * instance and invoke dialog.open() to show the dialog. Open() blocks as long
 * as the dialog is open. It returns an integer code. By default this is
 * {@link Window#OK} ({@value Window#OK}). You can change the return code via
 * {@link AbstractWindowController}{@link #setReturnCode(int)}.
 * <p>
 * <b>How to migrate from DialogView</b>
 * <p>
 * If you have been using DialogView and want to use this class instead you
 * should:
 * <ol>
 * <li>createContentView() does not need to call super anymore</li>
 * <li>onClose() becomes close() - remember to invoke super.close() when
 * overriding</li>
 * <li>build() is deprecated - invoke open() in client code instead</li>
 * </ol>
 */
public abstract class AbstractDialogView extends Dialog {

	private static final LnFUpdater LNF_UPDATER = new LnFUpdater();

	private final RienaWindowRenderer dlgRenderer;
	private final ControlledView controlledView;

	private String title;
	private boolean isClosing;

	private static Shell getShellByGuessing() {
		Shell result = null;
		if (PlatformUI.isWorkbenchRunning()) {
			result = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		} else if (Display.getCurrent() != null) {
			result = Display.getCurrent().getActiveShell();
		}
		// may return null, but that is ok; Dialog does not req. a parent shell
		return result;
	}

	/**
	 * Create a new instance of this class.
	 * 
	 * @param parentShell
	 *            the parent Shell. It is recommended to supply one. If you use
	 *            {@code null}, this class will try to guess the most
	 *            appropriate parent shell.
	 * @throws RuntimeException
	 *             if no shell instance could be obtained - this can only happen
	 *             when parentShell the value {@code null} and the class failed
	 *             to obtain an appropriate shell.
	 */
	protected AbstractDialogView(Shell parentShell) {
		super(parentShell != null ? parentShell : getShellByGuessing());
		title = ""; //$NON-NLS-1$
		dlgRenderer = new RienaWindowRenderer(this);
		controlledView = new ControlledView();
		controlledView.setController(createController());
	}

	@Override
	public void create() {

		// compute the 'styled' shell style, before creating the shell
		setShellStyle(dlgRenderer.computeShellStyle());
		super.create();
		applyTitle(getShell());

		addUIControls(getShell());
		bindController();
		LNF_UPDATER.updateUIControls(getShell(), true);
		// after binding the controller it is necessary to calculate the bounds
		// of the dialog again
		// because the controller can add some data that influences the size of
		// some widgets (e.g. ChoiceComposite)
		initializeBounds();

		centerWindow(getShell());

		getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (!isClosing) {
					close();
				}
			}
		});

	}

	@Override
	public boolean close() {
		isClosing = true;
		AbstractWindowController controller = getController();
		try {
			setReturnCode(controller.getReturnCode());
		} catch (Exception e) {

		}
		controlledView.unbind(controller);
		return super.close();
	}

	/**
	 * Returns the controller instance for this dialog.
	 * 
	 * @return an AbstractWindowController; never null
	 */
	public final AbstractWindowController getController() {
		return controlledView.getController();
	}

	/**
	 * Sets the title of this dialog (convenience method).
	 * <p>
	 * Implementation note: if you set the title both from the view (here) and
	 * the controller (via windowRidget.setTitle(...)), the value used in the
	 * controller will prevail.
	 * 
	 * @param title
	 *            the title; never null.
	 */
	public final void setTitle(String title) {
		Assert.isNotNull(title);
		this.title = title;
	}

	/**
	 * @deprecated use {@link #open()}
	 */
	public final void build() {
		open();
	}

	// protected methods
	// //////////////////

	/**
	 * Add a control to the list of 'bound' controls. These controls will be
	 * bound to ridgets by the framework.
	 * 
	 * @param uiControl
	 *            the UI control to bind; never null
	 * @param bindingId
	 *            a non-empty non-null bindind id for the control. Must be
	 *            unique within this composite
	 */
	protected final void addUIControl(Object uiControl, String bindingId) {
		controlledView.addUIControl(uiControl, bindingId);
	}

	@Override
	protected final Control createButtonBar(Composite parent) {
		return dlgRenderer.createButtonBar(parent);
	}

	@Override
	protected final Control createContents(Composite parent) {
		Control result = dlgRenderer.createContents(parent);
		super.createContents(dlgRenderer.getCenterComposite());
		return result;
	}

	@Override
	protected final Control createDialogArea(Composite parent) {
		Control result = buildView(parent);
		addUIControl(getShell(), AbstractWindowController.RIDGET_ID_WINDOW);
		return result;
	}

	/**
	 * Creates the UI for this dialog. This includes creating the appropriate
	 * buttons, such as Ok and Cancel.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected abstract Control buildView(Composite parent);

	/**
	 * Create the controller for this dialog.
	 * 
	 * @return a subclass of AbstractWindowController; never null
	 */
	protected abstract AbstractWindowController createController();

	// helping methods
	// ////////////////

	private void applyTitle(Shell shell) {
		if (shell.getText().length() == 0) {
			shell.setText(title);
		}
	}

	private void addUIControls(Composite composite) {
		SWTControlFinder finder = new SWTControlFinder(composite) {
			@Override
			public void handleBoundControl(Control control, String bindingProperty) {
				addUIControl(control, bindingProperty);
			}
		};
		finder.run();
	}

	private void bindController() {
		controlledView.initialize(getController());
		controlledView.bind(getController());
	}

	private void centerWindow(Shell dialogShell) {
		if (dialogShell != null && dialogShell.getParent() != null) {
			Rectangle parentShellBounds = dialogShell.getParent().getBounds();
			Rectangle dialogShellBounds = dialogShell.getBounds();
			int leftMargin = parentShellBounds.x + (parentShellBounds.width - dialogShellBounds.width) / 2;
			int topMargin = parentShellBounds.y + (parentShellBounds.height - dialogShellBounds.height) / 2;
			dialogShell.setLocation(leftMargin, topMargin);
		}
	}

	// helping classes
	// ////////////////

	private static final class ControlledView extends AbstractControlledView<AbstractWindowController> {
		@Override
		protected void addUIControl(Object uiControl, String propertyName) {
			super.addUIControl(uiControl, propertyName);
		}

		@Override
		protected void setController(AbstractWindowController controller) {
			super.setController(controller);
		}
	}

}
