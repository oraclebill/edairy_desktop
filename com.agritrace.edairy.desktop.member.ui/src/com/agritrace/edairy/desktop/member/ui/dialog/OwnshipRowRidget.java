package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IRowRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

public class OwnshipRowRidget extends AbstractCompositeRidget implements IRowRidget {

	private String rowData;

	public void setData(final Object rowData) {
		this.rowData = (String) rowData;
	}

	@Override
	public void configureRidgets() {
		final ITextRidget contactInfo = getRidget(ITextRidget.class, "owner"); //$NON-NLS-1$
		contactInfo.setDirectWriting(true);
		contactInfo.bindToModel(new WritableValue(rowData, String.class));
		contactInfo.updateFromModel();
	}
}
