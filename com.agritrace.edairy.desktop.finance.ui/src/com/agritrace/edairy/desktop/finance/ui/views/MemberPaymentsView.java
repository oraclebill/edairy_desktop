package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;

public class MemberPaymentsView extends SubModuleView {

	public static final String ID = "com.agritrace.edairy.desktop.finance.ui.views.MemberPaymentsView"; //$NON-NLS-1$
	private Table table;

	public MemberPaymentsView() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void basicCreatePartControl(Composite parent) {
		Composite container = parent;
		container.setLayout(new GridLayout(1, false));
		{
			Composite composite = UIControlsFactory.createComposite(container, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
					false, 1, 1));
		}
		{
			table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
			table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
					1));
			table.setHeaderVisible(true);
			table.setLinesVisible(true);

			TableColumn tblclmnPeriod = new TableColumn(table, SWT.NONE);
			tblclmnPeriod.setWidth(100);
			tblclmnPeriod.setText("Period");

			TableColumn tblclmnRate = new TableColumn(table, SWT.NONE);
			tblclmnRate.setWidth(100);
			tblclmnRate.setText("Rate");

			TableColumn tblclmnFarmers = new TableColumn(table, SWT.NONE);
			tblclmnFarmers.setWidth(67);
			tblclmnFarmers.setText("# Farmers");

			TableColumn tblclmnAvgPaid = new TableColumn(table, SWT.NONE);
			tblclmnAvgPaid.setWidth(100);
			tblclmnAvgPaid.setText("Avg. Paid");

			TableColumn tblclmnTotalPayments = new TableColumn(table, SWT.NONE);
			tblclmnTotalPayments.setWidth(100);
			tblclmnTotalPayments.setText("Total Payments");

			TableColumn tblclmnRunDate = new TableColumn(table, SWT.NONE);
			tblclmnRunDate.setWidth(100);
			tblclmnRunDate.setText("Run Date");

			SWTBindingPropertyLocator.getInstance().setBindingProperty(
					table,
					FinanceBindingConstants.TABLE);
		}
		{
			Composite composite = UIControlsFactory.createComposite(container, SWT.NONE);
			FormLayout fl_composite = new FormLayout();
			fl_composite.spacing = 5;
			fl_composite.marginWidth = 10;
			fl_composite.marginHeight = 5;
			fl_composite.marginBottom = 10;
			composite.setLayout(fl_composite);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
					false, 1, 1));

			Button btnRunMemberPayments = new Button(composite, SWT.FLAT);
			FormData fd_btnRunMemberPayments = new FormData();
			fd_btnRunMemberPayments.top = new FormAttachment(0, 10);
			fd_btnRunMemberPayments.right = new FormAttachment(100, -10);
			btnRunMemberPayments.setLayoutData(fd_btnRunMemberPayments);
			btnRunMemberPayments.setText("Run Member Payments");

			SWTBindingPropertyLocator.getInstance().setBindingProperty(
					btnRunMemberPayments,
					FinanceBindingConstants.BTN_RUN_PAYMENTS);
		}
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
