package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class SupplierListView extends AbstractRecordListView {

	public static final String ID = "edairy.supplier.list.view";

	public static final String BIND_ID_FILTER_CATEGORIES = "bind.id.fitler.categories";
	public static final String BIND_ID_FILTER_CONTACT = "bind.id.fitler.contact";
	public static final String BIND_ID_FILTER_STATUS = "bind.id.fitler.status";

	@Override
	protected void createFilterCondtions(Composite parent) {
		parent.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0)
				.numColumns(2).create());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		// Categories
		UIControlsFactory.createLabel(parent, "Categories");

		List categoriesList = UIControlsFactory.createList(parent, false, true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(categoriesList);
		addUIControl(categoriesList, BIND_ID_FILTER_CATEGORIES);

		// Contact name
		UIControlsFactory.createLabel(parent, "Company Name");
		Text contactName = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(contactName);
		addUIControl(contactName, BIND_ID_FILTER_CONTACT);

		// Status
		UIControlsFactory.createLabel(parent, "Status");
		Combo status = UIControlsFactory.createCombo(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(status);
		addUIControl(status, BIND_ID_FILTER_STATUS);

	}

}
