package com.agritrace.edairy.desktop.birt;

import org.eclipse.riena.ui.swt.IStatusLineContentFactory;
import org.eclipse.riena.ui.swt.Statusline;

public class StatusLineContentFactory implements IStatusLineContentFactory {

	public StatusLineContentFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContent(Statusline statusline) {
		statusline.getMessageComposite().setMessage("Reporting on eDairy");
	}

}
