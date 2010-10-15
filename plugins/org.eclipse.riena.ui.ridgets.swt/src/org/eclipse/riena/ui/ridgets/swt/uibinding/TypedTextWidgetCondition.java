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
package org.eclipse.riena.ui.ridgets.swt.uibinding;

import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.ui.ridgets.uibinding.IMappingCondition;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.widgets.Text;

/**
 * This condition matches against Text widgets that have a special type
 * identifier in their data properties.
 * 
 * @see Text#setData(String, Object)
 * @see UIControlsFactory#KEY_TYPE
 * @see UIControlsFactory#TYPE_DATE
 * @see UIControlsFactory#TYPE_DECIMAL
 * @see UIControlsFactory#TYPE_NUMERIC
 * @see UIControlsFactory#createTextNumeric(org.eclipse.swt.widgets.Composite)
 */
public final class TypedTextWidgetCondition implements IMappingCondition {

	private final String type;

	/**
	 * Create a new condidition that matches Text widgets against the given type
	 * identifier
	 * 
	 * @param type
	 *            the type indentifier (non-null);
	 */
	TypedTextWidgetCondition(String type) {
		Assert.isNotNull(type);
		this.type = type;
	}

	public boolean isMatch(Object widget) {
		boolean result = false;
		if (widget instanceof Text) {
			Text text = (Text) widget;
			result = type.equals(text.getData(UIControlsFactory.KEY_TYPE));
		}
		return result;
	}
}
