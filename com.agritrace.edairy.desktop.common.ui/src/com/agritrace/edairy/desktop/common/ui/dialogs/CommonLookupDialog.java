package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

/**
 * Common Search Dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class CommonLookupDialog extends AbstractDialogView {

	public static final String SEARCH_COLUMN_COMBO = "search.column.combo";
	public static final String SEARCH_COLUMN_TEXT = "search.column.text";
	public static final String SEARCH_BUTTON = "search.button";
	public static final String RESULT_LIST = "result.list";
	public static final String SELECT_BUTTON = "select.button";

	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public CommonLookupDialog(Shell shell) {
		super(shell);

	}

	@Override
	protected Control buildView(Composite parent) {
		final Composite composite = UIControlsFactory.createComposite(parent,
				SWT.NULL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(composite);
		composite.setLayout(new GridLayout(4, false));
		UIControlsFactory.createLabel(composite, "Lookup field");

		// Column combo
		UIControlsFactory.createCombo(composite, SEARCH_COLUMN_COMBO);
		// Text value
		Text lookupValue = UIControlsFactory.createText(composite, SWT.NULL
				| SWT.BORDER | SWT.SINGLE, SEARCH_COLUMN_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.grab(true, false).applyTo(lookupValue);

		UIControlsFactory.createButton(composite, "Lookup", SEARCH_BUTTON);

		final Composite panel = new Composite(composite, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		// panel.setLayout(GridLayoutFactory.swtDefaults().create());
		panel.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final TableColumnLayout layout = new TableColumnLayout();
		panel.setLayout(layout);

		Table table = UIControlsFactory.createTable(panel, SWT.FULL_SELECTION
				| SWT.BORDER | SWT.MULTI, RESULT_LIST);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(table);

		createButtons(composite);
		return composite;
	}

	private void createButtons(Composite composite) {
		Button selectBtn = UIControlsFactory.createButton(composite, "&Select",
				SELECT_BUTTON);
		GridDataFactory.swtDefaults().span(4, 1)
				.align(SWT.CENTER, SWT.BEGINNING).applyTo(selectBtn);

	}

}
