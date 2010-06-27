/*******************************************************************************
 * Copyright © 2009 Florian Pirchner.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of 
 *                    compeople AG)
 * compeople AG     - adjustments for Riena v1.2
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets;

/**
 * The browser ridget displays a html page fetched from a given URL.
 * 
 * @since 1.2
 */
public interface IBrowserRidget extends IValueRidget {

	/**
	 * Property name of the url property ({@value} ).
	 * 
	 * @see #getUrl()
	 * @see #setUrl(String)
	 */
	String PROPERTY_URL = "url"; //$NON-NLS-1$

	/**
	 * Return the url of this ridget or null.
	 * <p>
	 * The default value is null.
	 * 
	 * @return the url as a String. It is not guaranteed that the return value
	 *         is a valid url. For example it may be null, empty or browser
	 *         specific, such as 'about:blank'.
	 */
	String getUrl();

	/**
	 * Return the text last set into the ridget or null.
	 * <p>
	 * The default value is null.
	 * 
	 * @since 2.0
	 */
	String getText();

	/**
	 * Returns true, if an OutputMarker was added.
	 * <p>
	 * If an OutputMarker is added, the browser widget will not allow leaving
	 * the page (i.e. it is not possible to folow a link).
	 */
	boolean isOutputOnly();

	/**
	 * Adds and removes the default OutputMarker.
	 * <p>
	 * If an OutputMarker is added, the browser widget will not allow leaving
	 * the page (i.e. it is not possible to folow a link).
	 * 
	 * @param outputOnly
	 *            <code>true</code> if the ridget should be 'output only'
	 *            (=cannot be edited), <code>false</code> otherwise.
	 */
	void setOutputOnly(boolean outputOnly);

	/**
	 * A html String to show in the ridget.
	 * <p>
	 * Setting the text will also set the url value to null or 'about:blank'.
	 * <p>
	 * Note: currently there is no synchronisation. Invoking setText(...) while a
	 * page is loaded asynchronously from setUrl(...) call may have undefined
	 * results.
	 * 
	 * @param text
	 *            a String of HTML content.
	 * 
	 * @since 2.0
	 */
	void setText(String text);

	/**
	 * Sets the url.
	 * <p>
	 * Setting the url will also set the text value to null.
	 * 
	 * @param newUrl
	 *            a String that conforms to the constraints dictated by the
	 *            underlying widget (for example an SWT Browser with IE or
	 *            Mozilla underneath). May be null, empty, or browser specific,
	 *            such as 'about:blank'.
	 */
	void setUrl(String newUrl);
}
