package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * This is a base class for List view, which has a filter group at the top and a list table at the bottom.
 * @author cin
 *
 */
public abstract class BaseListView extends SubModuleView {
	public BaseListView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		createFilterGroup(parent);
		createListGroup(parent);
		
	}
	/**
	 * Create upper filter group
	 * @param parent
	 */
	protected abstract void createFilterGroup(Composite parent);
	
	/**
	 * Create list table
	 * @param parent
	 */
	protected abstract void createListGroup(Composite parent);
	
	/**
	 * Create button panel, it contains two buttons,View Button and Add Button
	 * @param parent the parent composite
	 * @param viewButtonId the view button id
	 * @param addButtonId the add button id
	 */
	protected void createButtonPanel(Composite parent, String viewButtonId, String addButtonId){
		final Composite buttonsPanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(2, false));

		final Button viewButton = UIControlsFactory.createButton(buttonsPanel, "View", viewButtonId);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(viewButton);

		final Button addButton = UIControlsFactory.createButton(buttonsPanel, "Add", addButtonId);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(addButton);
	}

}
