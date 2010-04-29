package com.agritrace.edairy.demo.riena.views;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Table;

public class PersonInfoMDList extends MasterDetailsComposite {

	public PersonInfoMDList(Composite parent, int style) {
		super(parent, style);
		setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		// TODO Auto-generated constructor stub
	}
	
	
//	@Override
//	public void setLayout(Layout layout) {
//		// TODO Auto-generated method stub
//		super.setLayout(org.eclipse.jface.layout.RowLayoutFactory.swtDefaults().create());
//	}


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
