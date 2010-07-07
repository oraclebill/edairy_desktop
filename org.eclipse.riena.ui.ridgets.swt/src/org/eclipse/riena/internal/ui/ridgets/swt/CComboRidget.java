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

import org.eclipse.core.databinding.BindingException;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

import org.eclipse.riena.ui.ridgets.swt.AbstractComboRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;

/**
 * Ridget for {@link CCombo} widgets.
 */
public class CComboRidget extends AbstractComboRidget {

	private ModifyListener modifyListener = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			setText(getUIControlText());
		}
	};

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, CCombo.class);
		if (uiControl != null) {
			int style = ((CCombo) uiControl).getStyle();
			if ((style & SWT.READ_ONLY) == 0) {
				throw new BindingException("Combo must be READ_ONLY"); //$NON-NLS-1$
			}
		}
	}

	@Override
	public CCombo getUIControl() {
		return (CCombo) super.getUIControl();
	}

	@Override
	protected IObservableList getUIControlItemsObservable() {
		return SWTObservables.observeItems(getUIControl());
	}

	@Override
	protected ISWTObservableValue getUIControlSelectionObservable() {
		return SWTObservables.observeSelection(getUIControl());
	}

	@Override
	protected void clearUIControlListSelection() {
		getUIControl().deselectAll();
		// Workaround for an SWT feature: when the user clicks in the list,
		// an asynchronous selection event is added to the end of the event 
		// queue, which will silenty an item. We asynchronously clear the list 
		// as well
		getUIControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				CCombo combo = getUIControl();
				if (combo != null && !combo.isDisposed()) {
					combo.clearSelection(); // this does not change the text
				}
			}
		});
	}

	@Override
	protected String[] getUIControlItems() {
		return getUIControl().getItems();
	}

	@Override
	protected void removeAllFromUIControl() {
		getUIControl().removeAll();
	}

	@Override
	protected int indexOfInUIControl(String item) {
		return getUIControl().indexOf(item);
	}

	@Override
	protected void selectInUIControl(int index) {
		getUIControl().select(index);
	}

	@Override
	protected void setItemsToControl(String[] arrItems) {
		getUIControl().setItems(arrItems);
	}

	@Override
	protected void addTextModifyListener() {
		getUIControl().addModifyListener(modifyListener);
	}

	@Override
	protected void removeTextModifyListener() {
		getUIControl().removeModifyListener(modifyListener);
	}

	@Override
	protected String getUIControlText() {
		return getUIControl().getText();
	}

	@Override
	protected void setTextToControl(String text) {
		getUIControl().setText(text);
	}

}