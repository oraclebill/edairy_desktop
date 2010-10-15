package com.agritrace.edairy.desktop.common.ui.controls.profilephoto;

import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;

public interface IProfilePhotoRidget extends IValueRidget {
	void addLinkSelectionListener(ISelectionListener listener);
	void removeLinkSelectionListener(ISelectionListener listener);
}
