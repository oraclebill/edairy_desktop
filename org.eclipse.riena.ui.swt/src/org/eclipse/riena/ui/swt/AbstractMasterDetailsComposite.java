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
package org.eclipse.riena.ui.swt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;

import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.swt.facades.GCFacade;
import org.eclipse.riena.ui.swt.facades.SWTFacade;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.nls.Messages;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.SWTControlFinder;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;

/**
 * This composite contains a table-like widget (the "master") of n columns, as
 * well as new, remove and update buttons. It also contains an arbitrary
 * composite (the "details"), which is updated automatically when the selected
 * row in the table changes.
 * <p>
 * Subclasses must override the {@link #createDetails(Composite)} method, to
 * populate the details composite with additional widgets. Widgets in the
 * details composite that should be bound to ridgets, must be registered by
 * invoking the {@link #addUIControl(Object, String)} method.
 * 
 * @see IMasterDetailsRidget
 * 
 * @since 1.2
 */
public abstract class AbstractMasterDetailsComposite extends Composite implements IComplexComponent {

	/**
	 * Binding id of the table control {@value} .
	 */
	public static final String BIND_ID_TABLE = "mdTable"; //$NON-NLS-1$
	/**
	 * Binding id of the new button {@value} .
	 */
	public static final String BIND_ID_NEW = "mdNewButton"; //$NON-NLS-1$
	/**
	 * Binding id of the remove button {@value} .
	 */
	public static final String BIND_ID_REMOVE = "mdRemoveButton"; //$NON-NLS-1$
	/**
	 * Binding id of the apply button {@value} .
	 */
	public static final String BIND_ID_APPLY = "mdApplyButton"; //$NON-NLS-1$

	private final List<Object> controls = new ArrayList<Object>();

	private Control table;
	private Composite details;
	private Composite master;

	/**
	 * Create an instance of MasterDetailsComposite with the details area at the
	 * top or bottom.
	 * 
	 * @param parent
	 *            the parent Composite; not null
	 * @param style
	 *            the style bits; values are restricted to those supported by
	 *            {@link Composite}
	 * @param orientation
	 *            SWT.TOP or SWT.BOTTOM, to create the details area at the top
	 *            or bottom part of the composite
	 */
	public AbstractMasterDetailsComposite(Composite parent, int style, int orientation) {
		super(parent, style);
		checkOrientation(orientation);

		setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).spacing(0, 5).create());
		if (orientation == SWT.TOP) {
			details = createComposite(getDetailsStyle());
			createDetails(details);
		}
		master = createComposite(getMasterStyle());
		createMaster(master);
		if (orientation == SWT.BOTTOM) {
			details = createComposite(getDetailsStyle());
			createDetails(details);
		}
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		// master.setBackground(master.getDisplay().getSystemColor(SWT.COLOR_CYAN));
		// details.setBackground(details.getDisplay().getSystemColor(SWT.COLOR_RED));
	}

	/**
	 * Add a control to the list of 'bound' controls. These controls will be
	 * bound to ridgets by the framework.
	 * 
	 * @param uiControl
	 *            the UI control to bind; never null
	 * @param bindingId
	 *            a non-empty non-null bindind id for the control. Must be
	 *            unique within this composite
	 * @see #getUIControls()
	 */
	public final void addUIControl(Object uiControl, String bindingId) {
		Assert.isNotNull(uiControl);
		Assert.isNotNull(bindingId);
		controls.add(uiControl);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, bindingId);
	}

	/**
	 * Asks the user to confirm discarding a dirty "details" area.
	 * <p>
	 * This implementation will show a blocking dialog. Subclasses may overwrite
	 * this method without calling super, to change the standard behavior.
	 * Examples: (a) opening a customized dialog, (b) returning true without
	 * asking the user.
	 * 
	 * @return true to discard changes, false to keep changes
	 * @since 1.2
	 */
	public boolean confirmDiscardChanges() {
		String title = Messages.MasterDetailsComposite_dialogMessage_confirmDiscard;
		String message = Messages.MasterDetailsComposite_dialogTitle_confirmDiscard;
		boolean result = MessageDialog.openQuestion(getShell(), title, message);
		return result;
	}

	/**
	 * Ask the user to confirm removal of the selected entry.
	 * <p>
	 * The default implementation always returns true. Subclasses may override.
	 * 
	 * @param item
	 *            the item to be removed. Can never be null.
	 * @return true to remove the selected entry, false otherwise.
	 * @since 2.0
	 */
	public boolean confirmRemove(Object item) {
		return true;
	}

	/**
	 * Return the 'Apply' control.
	 * 
	 * @return a Button or ImageButton instance; may be null if 'Apply' is
	 *         unsupported.
	 */
	public final Control getButtonApply() {
		Control result = getUIControl(BIND_ID_APPLY);
		checkButton(result, false);
		return result;
	}

	/**
	 * Return the 'New' control.
	 * 
	 * @return a Button or ImageButton instance; may be null if 'New' is
	 *         unsupported.
	 */
	public final Control getButtonNew() {
		Control result = getUIControl(BIND_ID_NEW);
		checkButton(result, true);
		return result;
	}

	/**
	 * Return the 'Remove' control.
	 * 
	 * @return a Button or ImageButton instance; may be null if 'Remove' is
	 *         unsupported.
	 */
	public final Control getButtonRemove() {
		Control result = getUIControl(BIND_ID_REMOVE);
		checkButton(result, true);
		return result;
	}

	/**
	 * Returns the 'details' composite.
	 * 
	 * @return a Composite; never null
	 */
	public final Composite getDetails() {
		return details;
	}

	/**
	 * Return the margins, in pixels, for the top/bottom, left/right edges of
	 * the widget.
	 * 
	 * @return a Point; never null. The x value corresponds to the top/bottom
	 *         margin. The y value corresponds to the left/right margin.
	 * @since 2.0
	 */
	public Point getMargins() {
		GridLayout layout = (GridLayout) getLayout();
		Point result = new Point(layout.marginHeight, layout.marginWidth);
		return result;
	}

	/**
	 * Return the spacing, in pixels, for the right/left and top/bottom edgets
	 * of the cells within the widget.
	 * 
	 * @return a Point; never null. The x value corresponds to the right/left
	 *         spacing. The y value corresponds to the top/bottom spacing.
	 * @since 2.0
	 */
	public Point getSpacing() {
		GridLayout layout = (GridLayout) getLayout();
		GridLayout mLayout = (GridLayout) master.getLayout();
		Point result = new Point(mLayout.horizontalSpacing, layout.verticalSpacing);
		return result;
	}

	/**
	 * Returns the Table control of the 'master' area.
	 * 
	 * @return a Table; never null
	 */
	public Control getTable() {
		return table;
	}

	public final List<Object> getUIControls() {
		SWTControlFinder finder = new SWTControlFinder(details) {
			@Override
			public boolean skip(Control control) {
				return controls.contains(control);
			}

			@Override
			public void handleBoundControl(Control control, String bindingProperty) {
				controls.add(control);
			}
		};
		finder.run();
		return Collections.unmodifiableList(controls);
	}

	/**
	 * @since 1.2
	 */
	@Override
	public void setBackground(Color color) {
		master.setBackground(color);
		details.setBackground(color);
		super.setBackground(color);
	}

	/**
	 * Sets the margin for the top/bottom, left/right edges of the widget.
	 * 
	 * @param marginHeight
	 *            the margin, in pixels, that will be placed along the top and
	 *            bottom edges of the widget. The default value is 0.
	 * @param marginWidth
	 *            the margin, in pixels, that will be placed along the left and
	 *            right edges of the widget. The default value is 0.
	 * @since 2.0
	 */
	public void setMargins(int marginHeight, int marginWidth) {
		GridLayout layout = (GridLayout) getLayout();
		layout.marginHeight = marginHeight;
		layout.marginWidth = marginWidth;
		layout(false);
	}

	/**
	 * Sets the spacing for the right/left and top/bottom edges of the cells
	 * within the widget.
	 * 
	 * @param hSpacing
	 *            the space, in pixels, between the right edge of a cell and the
	 *            left edge of the cell to the left. The default value is 0.
	 * @param vSpacing
	 *            the space, in pixels, between the bottom edge of a cell and
	 *            the top edge of the cell underneath. The default value is 5.
	 * @since 2.0
	 */
	public void setSpacing(int hSpacing, int vSpacing) {
		GridLayout layout = (GridLayout) getLayout();
		layout.verticalSpacing = vSpacing;
		GridLayout mLayout = (GridLayout) master.getLayout();
		mLayout.horizontalSpacing = hSpacing;
		layout(false);
	}

	/**
	 * Informs the user that apply failed for the given {@code reason}.
	 * <p>
	 * This implementation will show a blocking dialog. Subclasses may overwrite
	 * this method without calling super, to change the standard behavior.
	 * 
	 * @param reason
	 *            A string describing why apply failed; never null
	 * 
	 * @since 1.2
	 */
	public void warnApplyFailed(String reason) {
		Assert.isNotNull(reason);
		String title = Messages.MasterDetailsComposite_dialogTitle_applyFailed;
		MessageDialog.openWarning(getShell(), title, reason);
	}

	/**
	 * Informs the user that removal failed for the given {@code reason}.
	 * <p>
	 * This implementation will show a blocking dialog. Subclasses may overwrite
	 * this method without calling super, to change the standard behavior.
	 * 
	 * @param reason
	 *            A string describing why removal is not possible; never null
	 * @since 2.0
	 */
	public void warnRemoveFailed(String reason) {
		Assert.isNotNull(reason);
		String title = Messages.MasterDetailsComposite_dialogTitle_removeFailed;
		MessageDialog.openWarning(getShell(), title, reason);
	}

	// protected methods
	////////////////////

	/**
	 * Creates the 'Apply' Control. Subclasses may override.
	 * 
	 * @param compButton
	 *            the parent composite; never null
	 * 
	 * @return a Control or null. If this returns null you are responsible for
	 *         adding a button with the binding id {@link #BIND_ID_APPLY} to
	 *         this control elsewhere.
	 */
	protected Control createButtonApply(Composite compButton) {
		return UIControlsFactory.createButton(compButton, Messages.MasterDetailsComposite_buttonApply);
	}

	/**
	 * Creates the 'New' Control. Subclasses may override.
	 * 
	 * @param compButton
	 *            the parent composite; never null
	 * 
	 * @return a Control or null. If this returns null you are responsible for
	 *         adding a button with the binding id {@link #BIND_ID_NEW} to this
	 *         composite elsewhere &ndash; otherwise 'New' will not be
	 *         available.
	 */
	protected Control createButtonNew(Composite compButton) {
		return UIControlsFactory.createButton(compButton, Messages.MasterDetailsComposite_buttonNew);
	}

	/**
	 * Creates the 'Remove' Control. Subclasses may override.
	 * 
	 * @param compButton
	 *            the parent composite; never null
	 * 
	 * @return a Control or null. If this returns null you are responsible for
	 *         adding a button with the binding id {@link #BIND_ID_REMOVE} to
	 *         this composite elsewhere &ndash; otherwise 'Remove' will not be
	 *         available.
	 */
	protected Control createButtonRemove(Composite compButton) {
		return UIControlsFactory.createButton(compButton, Messages.MasterDetailsComposite_buttonRemove);
	}

	/**
	 * Create the composite containing the buttons. Subclasses may override.
	 * <p>
	 * Implementation note: it is appropriate to return null and create the
	 * Buttons somewhere else. In that case the methods createButtonNew,
	 * createButtonRemove, createButtonApply will not be called (unless you call
	 * them) and you are responsible to add three buttons widgets with the ids:
	 * BIND_ID_NEW, BIND_ID_REMOVE, BIND_ID_APPLY, by invoking
	 * {@link #addUIControl(Object, String)}.
	 * 
	 * @param parent
	 * @return a Composite or null
	 */
	protected Composite createButtons(Composite parent) {
		Composite result = UIControlsFactory.createComposite(parent);
		// result.setBackground(getDisplay().getSystemColor(SWT.COLOR_GREEN));
		RowLayout buttonLayout = new RowLayout(SWT.VERTICAL);
		buttonLayout.marginTop = 0;
		buttonLayout.marginLeft = 3;
		buttonLayout.marginRight = 2;
		buttonLayout.fill = true;
		result.setLayout(buttonLayout);

		Control btnNew = createButtonNew(result);
		if (btnNew != null) {
			addUIControl(btnNew, BIND_ID_NEW);
		}

		Control btnRemove = createButtonRemove(result);
		if (btnRemove != null) {
			addUIControl(btnRemove, BIND_ID_REMOVE);
		}

		Control btnApply = createButtonApply(result);
		if (btnApply != null) {
			addUIControl(btnApply, BIND_ID_APPLY);
		}

		return result;
	}

	/**
	 * Subclasses must override this method to populate the details area.
	 * 
	 * @param details
	 *            the Composite for the details area; never null.
	 */
	protected void createDetails(Composite details) {
		// Sublasses should override.
	}

	/**
	 * Creates a widget for displaying the available rows. This is a table- /
	 * grid- / matrix-like Control.
	 * <p>
	 * Subclasses should override and return an appropriate Control.
	 * 
	 * @param tableComposite
	 *            a parent Composite; never null. It already has a
	 *            TableColumnLayout, which should be used if you are creating a
	 *            Table. If you are creating another type of widget you should
	 *            set an appropriate layout to the {@code tableComposite}.
	 * @param layout
	 *            the TableColumnLayout for the widget; never null. Add
	 *            information about the columns as necessary. Can be ignored, if
	 *            you are creating a widget of a different type (i.e. other than
	 *            Table).
	 * @return a Table-like control; never null; must have the SWT.SINGLE
	 *         style-bit (i.e. single selection only). If the returned widget is
	 *         a Table and has too few or too many columns, the columns will be
	 *         re-created. If you care about the specific configuration/layout
	 *         of the Table columns, make sure the Table has as many columns a
	 *         needed by the ridget.
	 * @see {@code IMasterDetailsRidget#bindToModel(...)}
	 */
	abstract protected Control createTable(Composite tableComposite, TableColumnLayout layout);

	/**
	 * Returns the style bits for the 'details' composite. Subclasses may
	 * override, but has to return a value that is supported by
	 * {@link Composite}.
	 * 
	 * @return {@code SWT.NONE}
	 */
	protected int getDetailsStyle() {
		return SWT.NONE;
	}

	/**
	 * Returns the style bits for the 'master' composite. Subclasses may
	 * override, but has to return a value that is supported by
	 * {@link Composite}.
	 * 
	 * @return {@code SWT.BORDER} (since 2.0)
	 */
	protected int getMasterStyle() {
		return SWT.BORDER;
	}

	// helping methods
	//////////////////

	private void checkButton(Control control, boolean allowNull) {
		if (allowNull && control == null) {
			return;
		}
		boolean ok = control instanceof Button || control instanceof ImageButton;
		Assert.isLegal(ok, "Control must be a Button or ImageButton: " + String.valueOf(control)); //$NON-NLS-1$
	}

	private void checkOrientation(int orientation) {
		int[] allowedValues = { SWT.TOP, SWT.BOTTOM };
		for (int value : allowedValues) {
			if (orientation == value) {
				return;
			}
		}
		throw new IllegalArgumentException("unsupported orientation: " + orientation); //$NON-NLS-1$
	}

	private Composite createComposite(int style) {
		Composite result = UIControlsFactory.createComposite(this, style);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(result);
		return result;
	}

	private void createMaster(Composite parent) {
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).spacing(0, 0).applyTo(parent);
		Composite compTable = createTableComposite(parent);
		Composite compButton = createButtons(parent);
		if (compButton != null) {
			if (compButton.getLayoutData() == null) {
				GridDataFactory.fillDefaults().applyTo(compButton);
			}
			if ((compButton.getStyle() & SWT.BORDER) == 0) {
				SWTFacade.getDefault().addPaintListener(compButton, new LinePaintListener());
			}
		} else {
			((GridData) compTable.getLayoutData()).horizontalSpan = 2;
		}
	}

	private Composite createTableComposite(Composite parent) {
		Composite result = UIControlsFactory.createComposite(parent);
		TableColumnLayout layout = new TableColumnLayout();
		table = createTable(result, layout);
		if (table instanceof Table && result.getLayout() == null) {
			// this is specific to the MasterDetailsComposite, but is done here
			// for backwards compatibility
			result.setLayout(layout);
			int wHint = 200;
			int hHint = (((Table) table).getItemHeight() * 8) + ((Table) table).getHeaderHeight();
			GridDataFactory.fillDefaults().grab(true, false).hint(wHint, hHint).applyTo(result);
		}
		addUIControl(table, BIND_ID_TABLE);
		return result;
	}

	private Control getUIControl(String id) {
		Control result = null;
		SWTBindingPropertyLocator bpLocator = SWTBindingPropertyLocator.getInstance();
		Iterator<Object> iter = controls.iterator();
		while (result == null && iter.hasNext()) {
			Control control = (Control) iter.next();
			if (id.equals(bpLocator.locateBindingProperty(control))) {
				result = control;
			}
		}
		Assert.isNotNull(result);
		return result;
	}

	// helping classes
	//////////////////

	private static final class LinePaintListener implements PaintListener {
		private Color fgColor;

		public void paintControl(PaintEvent e) {
			GC gc = e.gc;
			Color oldFg = gc.getForeground();
			if (fgColor == null) {
				fgColor = LnfManager.getLnf().getColor(LnfKeyConstants.MASTER_DETAILS_WIDGET_SEPARATOR_FOREGROUND);
			}
			gc.setForeground(fgColor);
			Rectangle bounds = ((Control) e.widget).getBounds();
			GCFacade.getDefault().drawLine(gc, 0, 0, 0, bounds.height);
			gc.setForeground(oldFg);
		}
	}

}
