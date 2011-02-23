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
package org.eclipse.riena.internal.ui.ridgets.swt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.riena.internal.ui.swt.test.UITestHelper;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

/**
 * Superclass to test a Ridget which is bound to an SWT-Widget.
 */
public abstract class AbstractSWTRidgetTest extends AbstractRidgetTestCase {

	// protected methods
	// //////////////////

	@Override
	protected abstract Widget createWidget(final Composite parent);

	@Override
	protected Widget getWidget() {
		return (Widget) super.getWidget();
	}

	// test methods
	// /////////////

	public void testGetToolTip() {

		if (!isWidgetControl()) {
			// only Control supports tool tips
			return;
		}

		getRidget().setUIControl(null);

		assertEquals("Fails for " + getRidget(), null, getRidget().getToolTipText());

		getRidget().setToolTipText("foo");

		assertEquals("Fails for " + getRidget(), "foo", getRidget().getToolTipText());

		Control aControl = (Control) getWidget();
		aControl.setToolTipText(null);
		getRidget().setUIControl(aControl);

		assertEquals("Fails for " + getRidget(), "foo", getRidget().getToolTipText());
		assertEquals("Fails for " + getRidget(), "foo", ((Control) getRidget().getUIControl()).getToolTipText());
	}

	public void testGetFocusable() {

		if (!isWidgetControl()) {
			// only Control supports focus
			return;
		}

		IRidget aRidget = getRidget();

		assertTrue("Fails for " + aRidget, aRidget.isFocusable());

		aRidget.setFocusable(false);

		assertFalse("Fails for " + aRidget, aRidget.isFocusable());

		aRidget.setFocusable(true);

		assertTrue("Fails for " + aRidget, aRidget.isFocusable());
	}

	public void testSetFocusable() {

		if (!isWidgetControl()) {
			// only Control supports focus
			return;
		}

		IRidget aRidget = getRidget();
		Control aControl = (Control) getWidget();
		getOtherControl().moveAbove(aControl);

		aControl.setFocus();
		if (aControl.isFocusControl()) { // skip if control cannot receive focus

			aRidget.setFocusable(false);
			getOtherControl().setFocus();

			assertTrue("Fails for " + getOtherControl(), getOtherControl().isFocusControl());

			UITestHelper.sendString(getOtherControl().getDisplay(), "\t");
			assertFalse("Fails for " + aControl, aControl.isFocusControl());

			aRidget.setFocusable(true);

			getOtherControl().setFocus();
			UITestHelper.sendString(getOtherControl().getDisplay(), "\t");

			assertTrue("Fails for " + aControl, aControl.isFocusControl());
		}
	}

	public void testRequestFocus() throws Exception {

		if (!isWidgetControl()) {
			// only Control supports focus
			return;
		}

		Control aControl = (Control) getWidget();
		aControl.setFocus();
		if (aControl.isFocusControl()) { // skip if control cannot receive focus
			assertTrue("Fails for " + getOtherControl(), getOtherControl().setFocus());

			assertFalse("Fails for " + aControl, aControl.isFocusControl());
			assertFalse("Fails for " + getRidget(), getRidget().hasFocus());

			final List<FocusEvent> focusGainedEvents = new ArrayList<FocusEvent>();
			final List<FocusEvent> focusLostEvents = new ArrayList<FocusEvent>();
			IFocusListener focusListener = new IFocusListener() {
				public void focusGained(FocusEvent event) {
					focusGainedEvents.add(event);
				}

				public void focusLost(FocusEvent event) {
					focusLostEvents.add(event);
				}
			};
			getRidget().addFocusListener(focusListener);

			getRidget().requestFocus();

			assertTrue("Fails for " + aControl, aControl.isFocusControl());
			assertTrue("Fails for " + getRidget(), getRidget().hasFocus());
			assertEquals("Fails for " + getRidget(), 1, focusGainedEvents.size());
			assertEquals("Fails for " + getRidget(), getRidget(), focusGainedEvents.get(0).getNewFocusOwner());
			assertEquals("Fails for " + getRidget(), 0, focusLostEvents.size());

			assertTrue("Fails for " + getOtherControl(), getOtherControl().setFocus());

			assertFalse("Fails for " + aControl, aControl.isFocusControl());
			assertFalse("Fails for " + getRidget(), getRidget().hasFocus());
			assertEquals("Fails for " + getRidget(), 1, focusGainedEvents.size());
			assertEquals("Fails for " + getRidget(), 1, focusLostEvents.size());
			assertEquals("Fails for " + getRidget(), getRidget(), focusLostEvents.get(0).getOldFocusOwner());

			getRidget().removeFocusListener(focusListener);

			getRidget().requestFocus();
			assertTrue("Fails for " + getOtherControl(), getOtherControl().setFocus());

			assertEquals("Fails for " + getRidget(), 1, focusGainedEvents.size());
			assertEquals("Fails for " + getRidget(), 1, focusLostEvents.size());
		}
	}

	/**
	 * Tests that a control becomes visible after toggling ridget.setVisible().
	 */
	public void testBug257484() {
		Widget theWidget = getWidget();
		if (!(theWidget instanceof Control)) {
			// skip if not a control - only controls can be hidden / visible
			return;
		}
		IRidget theRidget = getRidget();
		Control control = (Control) theWidget;

		assertTrue("Fails for " + theRidget, theRidget.isVisible());
		assertTrue("Fails for " + control, control.isVisible());

		theRidget.setVisible(false);

		assertFalse("Fails for " + theRidget, theRidget.isVisible());
		assertFalse("Fails for " + control, control.isVisible());

		theRidget.setVisible(true);

		assertTrue("Fails for " + theRidget, theRidget.isVisible());
		assertTrue("Fails for " + control, control.isVisible());

		control.setVisible(false);
		assertFalse("Fails for " + theRidget, theRidget.isVisible());

		//unbind
		theRidget.setUIControl(null);
		// check saved state
		assertFalse("Fails for " + theRidget, theRidget.isVisible());

		theRidget.setUIControl(control);
		control.setVisible(true);
		assertTrue("Fails for " + theRidget, theRidget.isVisible());
		theRidget.setUIControl(null);
		assertTrue("Fails for " + theRidget, theRidget.isVisible());

		theRidget.setUIControl(control);

		// check implicit visibility
		Composite parent = control.getParent();
		if (parent != null) {
			parent.setVisible(false);
			assertFalse("Fails for " + theRidget, theRidget.isVisible());
			theRidget.setUIControl(null);
			parent.setVisible(true);
			assertFalse("Fails for " + theRidget, theRidget.isVisible());
		}

	}

}
