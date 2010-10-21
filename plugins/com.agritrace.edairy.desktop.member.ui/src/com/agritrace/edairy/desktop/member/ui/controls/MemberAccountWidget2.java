package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class MemberAccountWidget2 extends Composite implements IComplexComponent {
	static final String BIND_ID_YEAR_COMBO = "BIND_ID_SUMMARY_YEAR_COMBO";
	static final String BIND_ID_SUMMARY_TABLE = "BIND_ID_SUMMARY_SUMMARY_TABLE";
	static final String BIND_ID_MILK_COLLECTED_TXT = "BIND_ID_MILK_COLLECTED_TXT";
	static final String BIND_ID_CREDIT_DRAWN_TXT = "BIND_ID_CREDIT_DRAWN_TXT";

	public static final String BIND_ID_BALANCE_TXT = "BIND_ID_BALANCE_TXT";

	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;

	private List<Object> controlList = new ArrayList<Object>();

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MemberAccountWidget2(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		Group grpAccountSummary = new Group(this, SWT.NONE);
		grpAccountSummary.setText("Account Summary");
		grpAccountSummary.setLayout(new GridLayout(1, false));
		grpAccountSummary.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite composite_1 = new Composite(grpAccountSummary, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblYear = new Label(composite_1, SWT.NONE);
		GridData gd_lblYear = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblYear.widthHint = 60;
		lblYear.setLayoutData(gd_lblYear);
		lblYear.setText("Year");

		Combo combo = new Combo(composite_1, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_combo.widthHint = 85;
		combo.setLayoutData(gd_combo);
		addUIControl(combo, BIND_ID_YEAR_COMBO);

		table = new Table(grpAccountSummary, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		addUIControl(combo, BIND_ID_SUMMARY_TABLE);

		TableColumn tblclmnPeriod = new TableColumn(table, SWT.NONE);
		tblclmnPeriod.setWidth(64);
		tblclmnPeriod.setText("Period");

		TableColumn tblclmnCollected = new TableColumn(table, SWT.NONE);
		tblclmnCollected.setWidth(87);
		tblclmnCollected.setText("Kg Collected");

		TableColumn tblclmnEarnings = new TableColumn(table, SWT.NONE);
		tblclmnEarnings.setWidth(83);
		tblclmnEarnings.setText("Milk Income");

		TableColumn tblclmnCreditDrawn = new TableColumn(table, SWT.NONE);
		tblclmnCreditDrawn.setWidth(80);
		tblclmnCreditDrawn.setText("Credit Drawn");

		TableColumn tblclmnPaymentRate = new TableColumn(table, SWT.NONE);
		tblclmnPaymentRate.setWidth(100);
		tblclmnPaymentRate.setText("Monthly Earnings");

		Composite composite = new Composite(grpAccountSummary, SWT.BORDER);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1));

		Label lblTotalMilkCollected = new Label(composite, SWT.NONE);
		lblTotalMilkCollected.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		lblTotalMilkCollected.setText("Total Milk Collected");

		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addUIControl(text, BIND_ID_MILK_COLLECTED_TXT);

		Label lblTotalCreditDrawn = new Label(composite, SWT.NONE);
		lblTotalCreditDrawn.setText("Total Credit Drawn");

		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addUIControl(text_1, BIND_ID_CREDIT_DRAWN_TXT);

		Label lblbalance = new Label(composite, SWT.NONE);
		lblbalance.setText("Balance");

		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addUIControl(text_2, BIND_ID_BALANCE_TXT);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void addUIControl(Control control, String id) {
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, id);
		controlList.add(control);
	}

	@Override
	public List<Object> getUIControls() {
		return Collections.unmodifiableList(controlList);
	}
}
