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
package org.eclipse.riena.ui.ridgets;

import org.eclipse.riena.ui.common.IComplexComponent;

/**
 * A Ridget that contains other ridgets.
 * <p>
 * Implementors are advised to subclass {@link AbstractCompositeRidget} and
 * override the widget-specific protected methods. Implementations are often
 * bound against an IComplexCompontent widget, but do not have to.
 * <p>
 * To enable API-like access to the ridgets contained herein, it is recommended
 * to expose the IDs of the contained ridgets via constants, such as
 * <tt>MyComplexRidget.RIDGET_BTN_DELETE</tt>. These constants can be used with
 * {@link #getRidget(String)} or {@link #getRidget(Class, String)} to obtain a
 * reference to the contained ridget. Example:
 * 
 * <pre>
 * complexRidget.getRidget(MyComplexRidget.RIDGET_BTN_DELETE);
 * </pre>
 * 
 * @see IComplexComponent
 */
public interface IComplexRidget extends IRidget, IRidgetContainer {
}
