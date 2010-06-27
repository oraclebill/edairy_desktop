/*******************************************************************************
 * Copyright (c) 2008, 2009 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 194734)
 *     compleople AG - modification for use with CompletionCombo
 ******************************************************************************/

package org.eclipse.riena.internal.ui.ridgets.swt;

import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.swt.SWT;

import org.eclipse.riena.ui.swt.CompletionCombo;

/**
 * Based on CComboSelectionProperty from Eclipse Databinding
 */
class CompletionComboSelectionProperty extends WidgetValueProperty {

	public CompletionComboSelectionProperty() {
		super(SWT.Modify);
	}

	protected Object doGetValue(Object source) {
		return ((CompletionCombo) source).getText();
	}

	protected void doSetValue(Object source, Object value) {
		String value1 = (String) value;
		CompletionCombo ccombo = (CompletionCombo) source;
		String items[] = ccombo.getItems();
		int index = -1;
		if (value1 == null) {
			ccombo.select(-1);
		} else if (items != null) {
			for (int i = 0; i < items.length; i++) {
				if (value1.equals(items[i])) {
					index = i;
					break;
				}
			}
			if (index == -1) {
				ccombo.setText(value1);
			} else {
				ccombo.select(index); // -1 will not "unselect"
			}
		}
	}

	public String toString() {
		return "CompletionCombo.selection <String>"; //$NON-NLS-1$
	}

	public Object getValueType() {
		return String.class;
	}

}
