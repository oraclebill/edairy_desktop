package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.persistence.IPaymentRecord;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.finance.payments.Constants;
import com.agritrace.edairy.desktop.finance.payments.MemberPaymentsProcessor;
import com.agritrace.edairy.desktop.finance.payments.PaymentRecord;
import com.google.inject.Inject;

public class PWPaymentComplete extends PWPage {

	private static final String[] COLUMN_HEADERS = { "ID", "Name", "", "Milk Income", "Credit Sales", "Adjustments",
			"Payment" };
	private static final String[] COLUMN_PROPS = { "member.memberId", "member.member.givenName", "member.member.familyName", "milkIncome",
			"accountCredits", "accountAdjustments", "totalPayment" };

	private Text runDate;
	private Text paymentRate;
	private Text payPeriod;
	private Text paymentAverage;
	private Text paymentCount;
	private Text paymentTotal;

	private Table table;
	private ITableRidget tableRidget;
	private final MemberPaymentsProcessor processor;
	private final IRepository<MemberPayment> paymentRepo;
	private List<PaymentRecord> paymentsList = Collections.emptyList();

	/**
	 * Create the wizard.
	 */
	@Inject
	public PWPaymentComplete(MemberPaymentsProcessor processor, IRepository<MemberPayment> paymentRepo) {
		super("previewAndComplete");
		setTitle("Apply Payments");
		setDescription("This table displays the payments that have been calculated. If you complete the wizard, these payments will be entered.");
		this.processor = processor;
		this.paymentRepo = paymentRepo;
		setPageComplete(false);
	}

	public final int getPaymentMonth() {
		return getInt("paymentMonth");
	}

	public final int getPaymentYear() {
		return getInt("paymentYear");
	}

	public final BigDecimal getPaymentRate() {
		return new BigDecimal(get("paymentRate"));
	}

	public final BigDecimal getPaymentAverage() {
		return new BigDecimal(get("paymentAverage"));
	}

	public final BigDecimal getPaymentTotal() {
		return new BigDecimal(get("paymentTotal"));
	}

	public final int getPaymentCount() {
		return getInt("paymentCount");
	}
	
	@Transactional
	public void performFinish() {
		BigDecimal total = Constants.BIGZERO;
		
		for (IPaymentRecord record: paymentsList) {
			processor.processPayment(record);
			total = total.add(record.getTotalPayment());
		}

		final MemberPayment memberPayment = DairyFactory.eINSTANCE.createMemberPayment();
		memberPayment.setEntryDate(new Date());
		memberPayment.setMonth(getPaymentMonth());
		memberPayment.setYear(getPaymentYear());
		memberPayment.setPaymentRate(getPaymentRate());
		memberPayment.setPaymentsTotal(total);
		paymentRepo.saveNew(memberPayment);
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		final GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginWidth = 10;
		container.setLayout(gl_container);

		final Composite header = new Composite(container, SWT.NONE);
		header.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		final GridLayout gl_composite = new GridLayout(4, false);
		gl_composite.marginWidth = 10;
		gl_composite.marginHeight = 15;
		gl_composite.horizontalSpacing = 20;
		header.setLayout(gl_composite);

		final GridDataFactory gdf = GridDataFactory.swtDefaults().hint(100, SWT.DEFAULT);

		{
			int paymentMonth = -1, paymentYear = -1;
			try {
				paymentMonth = getPaymentMonth();
				paymentYear = getPaymentYear();
			} catch (final Exception e) {
				e.printStackTrace();
			}

			{
				final Label lblPaymentPeriod = new Label(header, SWT.NONE);
				lblPaymentPeriod.setBounds(0, 0, 59, 14);
				lblPaymentPeriod.setText("Payment Period");
				lblPaymentPeriod.setLayoutData(gdf.create());

				payPeriod = text(header, String.format("%s %s", paymentMonth, paymentYear));
				payPeriod.setLayoutData(gdf.create());
			}
			{
				final Label lblRunDate = new Label(header, SWT.NONE);
				lblRunDate.setText("Run Date");
				lblRunDate.setLayoutData(gdf.create());

				runDate = text(header, String.format("%s", new Date()));
				runDate.setLayoutData(gdf.create());
			}
		}
		{
			{
				final Label lblPaymentRate = new Label(header, SWT.NONE);
				lblPaymentRate.setBounds(0, 0, 59, 14);
				lblPaymentRate.setText("Payment Rate");

				paymentRate = text(header, String.format("%s", get("paymentRate")));
				paymentRate.setLayoutData(gdf.create());

			}
			{

				final Label lblFarmers = new Label(header, SWT.NONE);
				lblFarmers.setBounds(0, 0, 59, 14);
				lblFarmers.setText("# Farmers");

				paymentCount = text(header, String.format("%s", get("paymentRate")));
				paymentCount.setLayoutData(gdf.create());
			}
		}
		{
			{
				final Label lblAvgPayment = new Label(header, SWT.NONE);
				lblAvgPayment.setBounds(0, 0, 59, 14);
				lblAvgPayment.setText("Avg. Payment");

				paymentAverage = text(header, String.format("%s", get("paymentRate")));
				paymentAverage.setLayoutData(gdf.create());

			}
			{

				final Label lblTotalPaidThis = new Label(header, SWT.NONE);
				lblTotalPaidThis.setBounds(0, 0, 59, 14);
				lblTotalPaidThis.setText("Total Paid this Period");

				paymentTotal = text(header, String.format("%s", get("paymentRate")));
				paymentTotal.setLayoutData(gdf.create());
			}
		}

		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableColumn tblclmnMember = new TableColumn(table, SWT.CENTER);
		tblclmnMember.setWidth(40);
		tblclmnMember.setText("ID");

		final TableColumn tblclmnMemberName = new TableColumn(table, SWT.CENTER);
		tblclmnMemberName.setWidth(200);
		tblclmnMemberName.setText(" Name");

		final TableColumn tblclmnMilkIncome = new TableColumn(table, SWT.CENTER);
		tblclmnMilkIncome.setWidth(80);
		tblclmnMilkIncome.setText("Milk Income");

		final TableColumn tblclmnCreditSales = new TableColumn(table, SWT.CENTER);
		tblclmnCreditSales.setWidth(80);
		tblclmnCreditSales.setText("Credit Sales");

		final TableColumn tblclmnAdjustments = new TableColumn(table, SWT.CENTER);
		tblclmnAdjustments.setWidth(80);
		tblclmnAdjustments.setText("Adjustments");

		final TableColumn tblclmnPayment = new TableColumn(table, SWT.CENTER);
		tblclmnPayment.setWidth(100);
		tblclmnPayment.setText("Payment");

		tableRidget = (ITableRidget) SwtRidgetFactory.createRidget(table);

	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			previewPayments();
		}
		
		super.setVisible(visible);
	}

	private Text[] headerWidgets = { runDate, paymentRate, payPeriod, paymentAverage, paymentCount, paymentTotal };
	private final Object[] headerValues = new Object[6];
	
	private void previewPayments() {
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					previewPayments(monitor);
				}
			});
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void previewPayments(final IProgressMonitor monitor) {
		monitor.beginTask("Generating payment records...", 0);

		paymentsList = processor.generatePaymentsList(
				getPaymentRate(),
				getPaymentMonth(),
				getPaymentYear());
		
		headerValues[0] = new Date();
		headerValues[1] = getPaymentRate();
		headerValues[2] = String.format("%s-%s", getPaymentMonth(), getPaymentYear());

		final BigDecimal total = Constants.BIGZERO;
		
		for (final IPaymentRecord record : paymentsList) {
			total.add(record.getTotalPayment());
		}
		
		final int count = paymentsList.size();
		headerValues[3] = count > 0 ? total.divide(new BigDecimal(count), Constants.MONEYCONTEXT) : new BigDecimal(0);
		headerValues[4] = new BigDecimal(paymentsList.size());
		headerValues[5] = total;

		headerWidgets = new Text[] { runDate, paymentRate, payPeriod, paymentAverage, paymentCount, paymentTotal };
		
		for (int i = 0; i < headerWidgets.length; i++) {
			headerWidgets[i].setText( headerValues[i] != null ? headerValues[i].toString() : "");
		}

		tableRidget.bindToModel(Observables.staticObservableList(paymentsList), PaymentRecord.class,
				COLUMN_PROPS, COLUMN_HEADERS);
		tableRidget.updateFromModel();
		monitor.done();
		setPageComplete(true);
	}

	/**
	 *
	 * @param parent
	 * @param s
	 * @return
	 * @wbp.factory
	 */
	private static Text text(Composite parent, String s) {
		final Text text = new Text(parent, SWT.BORDER);

		text.setText(s);
		text.setEditable(false);
		text.setEnabled(false);

		return text;
	}
}
