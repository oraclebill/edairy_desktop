package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

/**
 * Base class for standard 'directory' type views. These views contain a filter
 * area, a table area, and a button area. This class overrides
 * createBasicPartControl and manages the creation of these components and
 * provides standard naming for the widgets involved.
 *
 * BIND_ID_TABLE = table widget (w/o view)
 *
 * BIND_ID_NEW_BUTTON = table widget (w/o view) BIND_ID_VIEW_BUTTON = table
 * widget (w/o view)
 *
 * BIND_ID_FILTER_SEARCH = table widget (w/o view) BIND_ID_FILTER_RESET = table
 * widget (w/o view)
 *
 *
 */
public abstract class AbstractDirectoryView extends BaseListView {
	public AbstractDirectoryView() {
	}

	/**
	 * Binding id of the new button {@value} .
	 */
	public static final String BIND_ID_NEW_BUTTON = "list.button.new"; //$NON-NLS-1$
	public static final String BIND_ID_VIEW_BUTTON = "list.button.view"; //$NON-NLS-1$

	/**
	 * Binding id of the table control {@value} .
	 */
	public static final String BIND_ID_TABLE = "list.table"; //$NON-NLS-1$

	/**
	 * Create a list control to be bound to the BIND_ID_TABLE standard binding.
	 *
	 * @param parent
	 */
	@Override
	protected void createListGroup(Composite parent) {
		// Group
//		final Group group = UIControlsFactory.createGroup(parent, "");
//		group.setLayout(new GridLayout());
//		group.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Table
		final Composite result = UIControlsFactory.createGroup(parent, "");
		final TableColumnLayout layout = new TableColumnLayout();
		// We will first create a empty table here
		final Table table = new Table(result, SWT.SINGLE | SWT.FULL_SELECTION);
		result.setLayout(layout);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(result);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		addUIControl(table, BIND_ID_TABLE);

		createButtons(parent);
	}

	/**
	 * Creates a composite and the buttons for directory view By default, 'View'
	 * and 'Add new' buttons are created.
	 *
	 * @param parent
	 * @return
	 */
	protected void createButtons(Composite parent) {
		createButtonPanel(parent, BIND_ID_VIEW_BUTTON, BIND_ID_NEW_BUTTON);
	}

	/**
	 * Creates a composite and the buttons for directory view By default, 'View'
	 * and 'Add new' buttons are created.
	 *
	 * @param parent
	 * @param parent
	 * @param parent
	 * @return
	 */
	@Override
	protected void createButtonPanel(Composite parent, String viewButtonId, String addButtonId) {
		final Composite result = UIControlsFactory.createComposite(parent);
		// result.setBackground(getDisplay().getSystemColor(SWT.COLOR_GREEN));

		result.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.swtDefaults().grab(true, false).align(GridData.END, GridData.BEGINNING).applyTo(result);

		UIControlsFactory.createButton(result, "View", viewButtonId);

		UIControlsFactory.createButton(result, "Add New", addButtonId);

	}

}
