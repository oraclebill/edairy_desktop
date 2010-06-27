package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.collection.ui.components.DeliveryJournalFilterPanel;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import org.eclipse.jface.action.Action;

public class DeliveryJournalView extends AbstractDirectoryView {

	public static final String ID = "com.agritrace.edairy.desktop.collection.ui.views.MilkDeliveryLogView"; //$NON-NLS-1$
	private Action action;

	public DeliveryJournalView() {
		
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void basicCreatePartControl(Composite parent) {
		super.basicCreatePartControl(parent);
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			action = new Action("New Action") {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
				}
				
			};
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
		toolbarManager.add(action);
//		toolbarManager.
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	protected void createFilterConditions(Composite comp) {
		DeliveryJournalFilterPanel filterPanel = new DeliveryJournalFilterPanel(comp, SWT.NONE);		
	}
}
