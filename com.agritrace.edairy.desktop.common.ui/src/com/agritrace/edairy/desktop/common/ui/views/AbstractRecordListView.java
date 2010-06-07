package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;

/**
 * Common class for directory list view
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class AbstractRecordListView extends SubModuleView {
	public static final String BIND_ID_LIST = "list";
	/**
	 * Binding id of the table control {@value} .
	 */
	public static final String BIND_ID_TABLE = "list.table"; //$NON-NLS-1$

	public static final String BIND_ID_TABLE_GROUP = "list.button.table.group"; //$NON-NLS-1$
	/**
	 * Binding id of the new button {@value} .
	 */
	public static final String BIND_ID_NEW = "list.button.new"; //$NON-NLS-1$
	/**
	 * Binding id of the view button {@value} .
	 */
	public static final String BIND_ID_VIEW = "list.button.view"; //$NON-NLS-1$

	public static final String BIND_ID_FILTER_SEARCH = "filter.button.search";
	public static final String BIND_ID_FILTER_RESET = "filter.button.resets";

	@Override
	protected void basicCreatePartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		final Composite panel = new Composite(parent, SWT.None);
		panel.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).create());
		panel.setLayoutData(new GridData(GridData.FILL_BOTH));
		panel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		createControls(panel);
	}

	protected void createControls(Composite parent) {
		// Create filter
		createFilter(parent);
		// Create table list
		createTable(parent);
		// Create buttons
		createButtons(parent);
	}

	/**
	 * Creates filter
	 * 
	 * @param parent
	 */
	private void createFilter(Composite parent) {
		final Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).equalWidth(true).numColumns(3).create());
		GridDataFactory.swtDefaults().grab(true, false).applyTo(comp);
		// Create filter conditions
		createFilterCondtions(comp);
		// Create filter buttons
		createFilterButtons(comp);
	}

	/**
	 * Create filter condtions
	 * 
	 * @param comp
	 */
	protected void createFilterCondtions(Composite comp) {
		// Subclass should override to create the filter condition

	}

	private void createFilterButtons(Composite parent) {
		// Reset Apply buttons
		final Composite comp = UIControlsFactory.createComposite(parent);
		final GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 40;
		comp.setLayout(layout);
		final GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalAlignment = GridData.CENTER;
		data.horizontalSpan = 3;

		comp.setLayoutData(data);

		// Search Button
		final Button searchBtn = UIControlsFactory.createButton(comp, "Search");
		addUIControl(searchBtn, BIND_ID_FILTER_SEARCH);

		// ResetButton
		final Button resetBtn = UIControlsFactory.createButton(comp, "Reset");
		addUIControl(resetBtn, BIND_ID_FILTER_RESET);
	}

	/**
	 * @param parent
	 */
	private void createTable(Composite parent) {
		// Group
		final Group group = UIControlsFactory.createGroup(parent, "");
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		addUIControl(group, BIND_ID_TABLE_GROUP);

		// Tables
		final Composite result = UIControlsFactory.createComposite(group);
		final TableColumnLayout layout = new TableColumnLayout();
		// We will first create a empty table here
		final Table table = new Table(result, getTableStyle());
		result.setLayout(layout);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(result);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		addUIControl(table, BIND_ID_TABLE);

	}

	/**
	 * Returns the style bits for the 'table'. Subclasses may override, but has
	 * to return a value that is supported by the {@link Table}.
	 * <p>
	 * Never return SWT.MULTI. By design, this widget does not support multiple
	 * selection.
	 * 
	 * @return SWT.SINGLE | SWT.FULL_SELECTION
	 * @since 2.0
	 */
	protected int getTableStyle() {
		return SWT.SINGLE | SWT.FULL_SELECTION;
	}

	/**
	 * Creates the buttons for directory view By default, 'View' and 'Add new'
	 * buttons are created.
	 * 
	 * @param parent
	 * @return
	 */
	protected Composite createButtons(Composite parent) {
		final Composite result = UIControlsFactory.createComposite(parent);
		// result.setBackground(getDisplay().getSystemColor(SWT.COLOR_GREEN));

		result.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.swtDefaults().grab(true, false).align(GridData.END, GridData.BEGINNING).applyTo(result);

		createButtonView(result);

		createButtonNew(result);

		return result;
	}

	/**
	 * Creates the 'Add New' button
	 * 
	 * @param compButton
	 * @return
	 */
	protected Control createButtonNew(Composite compButton) {
		return UIControlsFactory.createButton(compButton, "Add New", BIND_ID_NEW);
	}

	/**
	 * Creates the 'View' Control. Subclasses may override.
	 * 
	 * @param compButton
	 *            the parent composite; never null
	 * 
	 * @return a Control or null. If this returns null you are responsible for
	 *         adding a button with the binding id {@link #BIND_ID_NEW} to this
	 *         composite elsewhere &ndash; otherwise 'New' will not be
	 *         available.
	 */
	protected Control createButtonView(Composite compButton) {
		return UIControlsFactory.createButton(compButton, "View", BIND_ID_VIEW);
	}

}
