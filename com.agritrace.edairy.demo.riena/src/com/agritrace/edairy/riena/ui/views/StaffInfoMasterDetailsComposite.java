package com.agritrace.edairy.riena.ui.views;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class StaffInfoMasterDetailsComposite extends MasterDetailsComposite {

	public StaffInfoMasterDetailsComposite(Composite parent, int style) {
		super(parent, style);
		setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected Table createTable(Composite tableComposite, TableColumnLayout layout) {
		if(tableComposite.getParent() != null){
			tableComposite.getParent().setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		}
		tableComposite.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		tableComposite.setLayout(layout);

		return super.createTable(tableComposite, layout);
	}
}
