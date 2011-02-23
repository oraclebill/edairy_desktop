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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;

import org.easymock.EasyMock;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.internal.core.test.RienaTestCase;
import org.eclipse.riena.internal.core.test.collect.UITestCase;
import org.eclipse.riena.ui.core.marker.DisabledMarker;
import org.eclipse.riena.ui.core.marker.MandatoryMarker;
import org.eclipse.riena.ui.core.marker.OutputMarker;
import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTWidgetRidget;
import org.eclipse.riena.ui.tests.base.PropertyChangeEventEquals;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Superclass to test a Ridget.
 */
@UITestCase
public abstract class AbstractRidgetTestCase extends RienaTestCase {

	private Shell shell;
	private Object widget;
	private IRidget ridget;
	private Text otherControl;
	protected PropertyChangeListener propertyChangeListenerMock;

	protected abstract Object createWidget(final Composite parent);

	protected abstract IRidget createRidget();

	protected Object getWidget() {
		return widget;
	}

	protected IRidget getRidget() {
		return ridget;
	}

	protected Shell getShell() {
		return shell;
	}

	protected Control getOtherControl() {
		return otherControl;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		Display display = Display.getDefault();

		Realm realm = SWTObservables.getRealm(display);
		assertNotNull(realm);
		ReflectionUtils.invokeHidden(realm, "setDefault", realm);

		shell = new Shell(SWT.SYSTEM_MODAL | SWT.ON_TOP);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		widget = createWidget(shell);

		ridget = createRidget();
		ridget.setUIControl(widget);
		propertyChangeListenerMock = EasyMock.createMock(PropertyChangeListener.class);
		ridget.addPropertyChangeListener(propertyChangeListenerMock);

		otherControl = new Text(shell, SWT.SINGLE);
		otherControl.setText("other focusable widget");

		shell.setSize(130, 100);
		shell.setLocation(0, 0);
		shell.open();
	}

	@Override
	protected void tearDown() throws Exception {
		ridget = null;
		widget = null;
		otherControl = null;
		shell.dispose();
		shell = null;

		super.tearDown();
	}

	// easy mock helper methods
	// /////////////////////////

	/**
	 * Clear all expectations with regard to property change events.
	 */
	protected final void resetPropertyChangeEvents() {
		EasyMock.reset(propertyChangeListenerMock);
	}

	/**
	 * Check expectations with regard to property change events. This must be
	 * called after invoking the code under test.
	 * 
	 * @see #expectNoPropertyChangeEvent()
	 * @see #expectPropertyChangeEvent(String, Object, Object)
	 * @see #expectPropertyChangeEvents(PropertyChangeEvent...)
	 */
	protected final void verifyPropertyChangeEvents() {
		EasyMock.verify(propertyChangeListenerMock);
	}

	/**
	 * Expect that no property change event will be fired.
	 * 
	 * @see #verifyPropertyChangeEvents()
	 */
	protected final void expectNoPropertyChangeEvent() {
		EasyMock.reset(propertyChangeListenerMock);
		EasyMock.replay(propertyChangeListenerMock);
	}

	/**
	 * Expect that all given property change events will be fired.
	 * 
	 * @param propertyChangeEvents
	 *            one or more property change events
	 * @see #verifyPropertyChangeEvents()
	 */
	protected final void expectPropertyChangeEvents(PropertyChangeEvent... propertyChangeEvents) {
		EasyMock.reset(propertyChangeListenerMock);
		for (PropertyChangeEvent propertyChangeEvent : propertyChangeEvents) {
			propertyChangeListenerMock.propertyChange(createArgumentMatcher(propertyChangeEvent));
		}
		EasyMock.replay(propertyChangeListenerMock);
	}

	/**
	 * Expect that the given property change event will be fired.
	 * 
	 * @param propertyName
	 *            the name of the property change event
	 * @param oldValue
	 *            the old value of the property change event
	 * @param newValue
	 *            the new value of the property change event
	 * @see #verifyPropertyChangeEvents()
	 */
	protected final void expectPropertyChangeEvent(String propertyName, Object oldValue, Object newValue) {
		expectPropertyChangeEvents(new PropertyChangeEvent(getRidget(), propertyName, oldValue, newValue));
	}

	// test methods
	// /////////////

	public void testIsVisible() {
		getShell().open();

		assertTrue("Fails for " + getRidget(), getRidget().isVisible());
		if (isWidgetControl()) {
			assertTrue("Fails for " + getRidget(), ((Control) getWidget()).isVisible());
		}

		getRidget().setVisible(false);

		assertFalse("Fails for " + getRidget(), getRidget().isVisible());
		if (isWidgetControl()) {
			assertFalse("Fails for " + getRidget(), ((Control) getWidget()).isVisible());
		}

		getRidget().setVisible(true);

		assertTrue("Fails for " + getRidget(), getRidget().isVisible());
		if (isWidgetControl()) {
			assertTrue("Fails for " + getRidget(), ((Control) getWidget()).isVisible());
		}

		getRidget().setUIControl(null);
		getRidget().setVisible(false);

		assertFalse("Fails for " + getRidget(), getRidget().isVisible());
		if (isWidgetControl()) {
			assertTrue("Fails for " + getRidget(), ((Control) getWidget()).isVisible());
		}

		getRidget().setUIControl(getWidget());

		assertFalse("Fails for " + getRidget(), getRidget().isVisible());
		if (isWidgetControl()) {
			assertFalse("Fails for " + getRidget(), ((Control) getWidget()).isVisible());
		}
	}

	public void testIsEnabled() throws Exception {
		assertTrue("Fails for " + getRidget(), getRidget().isEnabled());
		if (isWidgetControl()) {
			assertTrue("Fails for " + getRidget(), ((Control) getWidget()).isEnabled());
		}

		getRidget().setEnabled(false);

		assertFalse("Fails for " + getRidget(), getRidget().isEnabled());
		if (isWidgetControl()) {
			assertFalse("Fails for " + getRidget(), ((Control) getWidget()).isEnabled());
		}

		getRidget().setEnabled(false);

		assertFalse("Fails for " + getRidget(), getRidget().isEnabled());
		if (isWidgetControl()) {
			assertFalse("Fails for " + getRidget(), ((Control) getWidget()).isEnabled());
		}

		getRidget().setEnabled(true);

		assertTrue("Fails for " + getRidget(), getRidget().isEnabled());
		if (isWidgetControl()) {
			assertTrue("Fails for " + getRidget(), ((Control) getWidget()).isEnabled());
		}

		getRidget().setUIControl(null);
		getRidget().setEnabled(false);

		assertFalse("Fails for " + getRidget(), getRidget().isEnabled());
		if (isWidgetControl()) {
			assertTrue("Fails for " + getRidget(), ((Control) getWidget()).isEnabled());
		}

		getRidget().setUIControl(getWidget());

		assertFalse("Fails for " + getRidget(), getRidget().isEnabled());
		if (isWidgetControl()) {
			assertFalse("Fails for " + getRidget(), ((Control) getWidget()).isEnabled());
		}
	}

	public void testFiresTooltipProperty() {
		expectPropertyChangeEvent(IRidget.PROPERTY_TOOLTIP, null, "begood");

		getRidget().setToolTipText("begood");

		verifyPropertyChangeEvents();
		expectNoPropertyChangeEvent();

		getRidget().setToolTipText("begood");

		verifyPropertyChangeEvents();
		expectPropertyChangeEvent(IRidget.PROPERTY_TOOLTIP, "begood", null);

		getRidget().setToolTipText(null);

		verifyPropertyChangeEvents();
	}

	public void testFiresMarkerProperty() {
		if (!(getRidget() instanceof IBasicMarkableRidget)) {
			return;
		}
		IBasicMarkableRidget markableRidget = (IBasicMarkableRidget) getRidget();
		IMarker marker = new MandatoryMarker();
		HashSet<IMarker> before = new HashSet<IMarker>(markableRidget.getMarkers());
		HashSet<IMarker> after = new HashSet<IMarker>(before);
		after.add(marker);

		assertTrue("Fails for " + markableRidget, markableRidget.isEnabled());
		assertEquals("Fails for " + markableRidget, before.size() + 1, after.size());

		expectPropertyChangeEvent(IBasicMarkableRidget.PROPERTY_MARKER, before, after);
		markableRidget.addMarker(marker);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.addMarker(marker);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IBasicMarkableRidget.PROPERTY_MARKER, after, before);
		markableRidget.removeMarker(marker);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.removeMarker(marker);
		verifyPropertyChangeEvents();
	}

	public void testFiresDisabledPropertyUsingSetter() {
		if (!(getRidget() instanceof IBasicMarkableRidget)) {
			return;
		}
		IBasicMarkableRidget markableRidget = (IBasicMarkableRidget) getRidget();
		markableRidget.removePropertyChangeListener(propertyChangeListenerMock);
		markableRidget.addPropertyChangeListener(IRidget.PROPERTY_ENABLED, propertyChangeListenerMock);

		assertTrue("Fails for " + markableRidget, markableRidget.isEnabled());

		expectNoPropertyChangeEvent();
		markableRidget.setEnabled(true);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IRidget.PROPERTY_ENABLED, Boolean.TRUE, Boolean.FALSE);
		markableRidget.setEnabled(false);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.setEnabled(false);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IRidget.PROPERTY_ENABLED, Boolean.FALSE, Boolean.TRUE);
		markableRidget.setEnabled(true);
		verifyPropertyChangeEvents();
	}

	public void testFiresDisabledPropertyUsingAddRemove() {
		if (!(getRidget() instanceof IBasicMarkableRidget)) {
			return;
		}
		IBasicMarkableRidget markableRidget = (IBasicMarkableRidget) getRidget();
		IMarker marker = new DisabledMarker();
		markableRidget.removePropertyChangeListener(propertyChangeListenerMock);
		markableRidget.addPropertyChangeListener(IRidget.PROPERTY_ENABLED, propertyChangeListenerMock);

		assertTrue("Fails for " + markableRidget, markableRidget.isEnabled());

		expectPropertyChangeEvent(IRidget.PROPERTY_ENABLED, Boolean.TRUE, Boolean.FALSE);
		markableRidget.addMarker(marker);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.addMarker(marker);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IRidget.PROPERTY_ENABLED, Boolean.FALSE, Boolean.TRUE);
		markableRidget.removeMarker(marker);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.removeMarker(marker);
		verifyPropertyChangeEvents();
	}

	/**
	 * Check that disabling / enabling works when we don't have a bound control.
	 */
	public void testDisableWithoutUIControl() {
		if (!(getRidget() instanceof IBasicMarkableRidget)) {
			return;
		}
		IBasicMarkableRidget markableRidget = (IBasicMarkableRidget) getRidget();
		markableRidget.setUIControl(null);

		assertTrue("Fails for " + markableRidget, markableRidget.isEnabled());

		markableRidget.setEnabled(false);

		assertFalse("Fails for " + markableRidget, markableRidget.isEnabled());

		markableRidget.setEnabled(true);

		assertTrue("Fails for " + markableRidget, markableRidget.isEnabled());
	}

	public void testFiresOutputPropertyUsingSetter() {
		if (!(getRidget() instanceof IMarkableRidget)) {
			return;
		}
		IMarkableRidget markableRidget = (IMarkableRidget) getRidget();
		markableRidget.removePropertyChangeListener(propertyChangeListenerMock);
		markableRidget.addPropertyChangeListener(IMarkableRidget.PROPERTY_OUTPUT_ONLY, propertyChangeListenerMock);

		assertFalse("Fails for " + markableRidget, markableRidget.isOutputOnly());

		expectNoPropertyChangeEvent();
		markableRidget.setOutputOnly(false);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IMarkableRidget.PROPERTY_OUTPUT_ONLY, Boolean.FALSE, Boolean.TRUE);
		markableRidget.setOutputOnly(true);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.setOutputOnly(true);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IMarkableRidget.PROPERTY_OUTPUT_ONLY, Boolean.TRUE, Boolean.FALSE);
		markableRidget.setOutputOnly(false);
		verifyPropertyChangeEvents();
	}

	public void testFiresOutputPropertyUsingAddRemove() {
		if (!(getRidget() instanceof IMarkableRidget)) {
			return;
		}
		IMarkableRidget markableRidget = (IMarkableRidget) getRidget();
		IMarker marker = new OutputMarker();
		markableRidget.removePropertyChangeListener(propertyChangeListenerMock);
		markableRidget.addPropertyChangeListener(IMarkableRidget.PROPERTY_OUTPUT_ONLY, propertyChangeListenerMock);

		assertFalse("Fails for " + markableRidget, markableRidget.isOutputOnly());

		expectPropertyChangeEvent(IMarkableRidget.PROPERTY_OUTPUT_ONLY, Boolean.FALSE, Boolean.TRUE);
		markableRidget.addMarker(marker);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.addMarker(marker);
		verifyPropertyChangeEvents();

		expectPropertyChangeEvent(IMarkableRidget.PROPERTY_OUTPUT_ONLY, Boolean.TRUE, Boolean.FALSE);
		markableRidget.removeMarker(marker);
		verifyPropertyChangeEvents();

		expectNoPropertyChangeEvent();
		markableRidget.removeMarker(marker);
		verifyPropertyChangeEvents();
	}

	/**
	 * Make sure that enabled setting from ridget is applied to UI control. See
	 * <a href="http://bugs.eclipse.org/270444">Bug #270444 - Case 1</a>.
	 */
	public void testApplyEnabledToUIControl() {
		Object aWidget = createWidget(getShell());
		if (!(aWidget instanceof Control)) {
			return;
		}
		IRidget aRidget = createRidget();
		Control control = (Control) aWidget;

		control.setEnabled(false);
		aRidget.setEnabled(true);
		aRidget.setUIControl(control);

		assertTrue(aRidget.isEnabled());
		assertTrue(control.isEnabled());
		if (aRidget instanceof IBasicMarkableRidget) {
			assertEquals(0, ((IBasicMarkableRidget) aRidget).getMarkersOfType(DisabledMarker.class).size());
		}
	}

	// helping methods
	// ////////////////

	private PropertyChangeEvent createArgumentMatcher(PropertyChangeEvent propertyChangeEvent) {
		return PropertyChangeEventEquals.eqPropertyChangeEvent(propertyChangeEvent);
	}

	protected void assertMarkerIgnored(IMarker marker) {
		AbstractSWTWidgetRidget ridgetImpl = (AbstractSWTWidgetRidget) getRidget();
		Control control = (Control) getWidget();
		Color originalForegroundColor = control.getForeground();
		Color originalBackgroundColor = control.getBackground();

		ridgetImpl.addMarker(marker);

		assertTrue(control.isVisible());
		assertTrue(control.isEnabled());
		assertEquals(originalForegroundColor, control.getForeground());
		assertEquals(originalBackgroundColor, control.getBackground());

		ridgetImpl.removeMarker(marker);

		assertTrue(control.isVisible());
		assertTrue(control.isEnabled());
		assertEquals(originalForegroundColor, control.getForeground());
		assertEquals(originalBackgroundColor, control.getBackground());
	}

	protected boolean isWidgetControl() {
		return getWidget() instanceof Control;
	}

}
