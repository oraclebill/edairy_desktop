package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

public class MilkCollectionDetailLog extends AbstractRecordListView {
	
	public static final String ID = "milk-collection-detail-log";
	public static final int STD_LABEL_WIDTH = 120;
	
	private static final GridDataFactory labelGridDataFactory = GridDataFactory.fillDefaults().hint(STD_LABEL_WIDTH, -1);
	private static final String JOURNAL_BOOK_NUMBER = "JOURNAL_BOOK_NUMBER";
	
	public MilkCollectionDetailLog() {
	}


	@Override
	protected void createFilterConditions(Composite comp) {
		comp.setLayout(GridLayoutFactory.fillDefaults().create());
		new MilkCollectionDetailFilterPanel(comp, SWT.NONE);
		comp.pack();
	}
	
	@Override
	protected void createFilterButtons(Composite parent) {
		
		// prevent superclass from updating buttons.
	}
	


}
