package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

public abstract class ScrolledSubModuleView extends SubModuleView {

	@Override
	protected void createWorkarea(Composite parent) {
		Color bgColor = LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND);

		ScrolledComposite scrolled = new ScrolledComposite(parent,  SWT.H_SCROLL | SWT.V_SCROLL);
		scrolled.setBackground(bgColor);
		
		Composite newParent = new Composite(parent, SWT.DOUBLE_BUFFERED);
		newParent.setBackground(bgColor);
		
		basicCreatePartControl(newParent);
		afterBasicCreatePartControl(newParent);
		
		scrolled.setContent(newParent);
	}

}
