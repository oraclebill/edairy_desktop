package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.finance.payments.Constants;
import com.agritrace.edairy.desktop.finance.payments.MemberPaymentsProcessor;
import com.agritrace.edairy.desktop.finance.payments.PaymentRecord;
import com.google.inject.Inject;

public class PWPaymentComplete extends PWPage {

	private static final String[] COLUMN_HEADERS = { "ID", "Name", "", "Milk Income", "Credit Sales", "Adjustments",
			"Payment" };
	private static final String[] COLUMN_PROPS = { "member.id", "member.givenName", "member.familyName", "milkIncome",
			"accountCredits", "accountAdjustments", "totalPayment" };

	private Text runDate;
	private Text paymentRate;
	private Text payPeriod;
	private Text paymentAverage;
	private Text paymentCount;
	private Text paymentTotal;

	private Table table;
	private ITableRidget tableRidget;
	private MemberPaymentsProcessor processor;

	/**
	 * Create the wizard.
	 */
	@Inject
	public PWPaymentComplete(MemberPaymentsProcessor processor) {
		super("previewAndComplete");
		setTitle("Apply Payments");
		setDescription("This table displays the payments that have been calculated. If you complete the wizard, these payments will be entered.");
		this.processor = processor;
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
	
	
	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginWidth = 10;
		container.setLayout(gl_container);

		Composite header = new Composite(container, SWT.NONE);
		header.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		GridLayout gl_composite = new GridLayout(4, false);
		gl_composite.marginWidth = 10;
		gl_composite.marginHeight = 15;
		gl_composite.horizontalSpacing = 20;
		header.setLayout(gl_composite);

		GridDataFactory gdf = GridDataFactory.swtDefaults().hint(100, SWT.DEFAULT);

		{
			int paymentMonth = -1, paymentYear = -1;
			try {
				paymentMonth = getPaymentMonth();
				paymentYear = getPaymentYear();
			}
			catch( Exception e) {
				e.printStackTrace();
			}
			
			{
				Label lblPaymentPeriod = new Label(header, SWT.NONE);
				lblPaymentPeriod.setBounds(0, 0, 59, 14);
				lblPaymentPeriod.setText("Payment Period");
				lblPaymentPeriod.setLayoutData(gdf.create());

				Text payPeriod = text(header,
						String.format("%s %s", paymentMonth, paymentYear));
				payPeriod.setLayoutData(gdf.create());
			}
			{
				Label lblRunDate = new Label(header, SWT.NONE);
				lblRunDate.setText("Run Date");
				lblRunDate.setLayoutData(gdf.create());

				Text runDate = text(header, String.format("%s", new Date()));
				runDate.setLayoutData(gdf.create());
			}
		}
		{			
			{
				Label lblPaymentRate = new Label(header, SWT.NONE);
				lblPaymentRate.setBounds(0, 0, 59, 14);
				lblPaymentRate.setText("Payment Rate");

				Text paymentRate = text(header, String.format("%s", get("paymentRate")));
				paymentRate.setLayoutData(gdf.create());

			}
			{

				Label lblFarmers = new Label(header, SWT.NONE);
				lblFarmers.setBounds(0, 0, 59, 14);
				lblFarmers.setText("# Farmers");

				Text paymentCount = text(header, String.format("%s", get("paymentRate")));
				paymentCount.setLayoutData(gdf.create());
			}
		}
		{
			{
				Label lblAvgPayment = new Label(header, SWT.NONE);
				lblAvgPayment.setBounds(0, 0, 59, 14);
				lblAvgPayment.setText("Avg. Payment");

				Text paymentAverage = text(header, String.format("%s", get("paymentRate")));
				paymentAverage.setLayoutData(gdf.create());

			}
			{

				Label lblTotalPaidThis = new Label(header, SWT.NONE);
				lblTotalPaidThis.setBounds(0, 0, 59, 14);
				lblTotalPaidThis.setText("Total Paid this Period");

				Text paymentTotal = text(header, String.format("%s", get("paymentRate")));
				paymentTotal.setLayoutData(gdf.create());
			}
		}

		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnMember = new TableColumn(table, SWT.CENTER);
		tblclmnMember.setWidth(40);
		tblclmnMember.setText("ID");

		TableColumn tblclmnMemberName = new TableColumn(table, SWT.CENTER);
		tblclmnMemberName.setWidth(200);
		tblclmnMemberName.setText(" Name");

		TableColumn tblclmnMilkIncome = new TableColumn(table, SWT.CENTER);
		tblclmnMilkIncome.setWidth(80);
		tblclmnMilkIncome.setText("Milk Income");

		TableColumn tblclmnCreditSales = new TableColumn(table, SWT.CENTER);
		tblclmnCreditSales.setWidth(80);
		tblclmnCreditSales.setText("Credit Sales");

		TableColumn tblclmnAdjustments = new TableColumn(table, SWT.CENTER);
		tblclmnAdjustments.setWidth(80);
		tblclmnAdjustments.setText("Adjustments");

		TableColumn tblclmnPayment = new TableColumn(table, SWT.CENTER);
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
	private Object[] headerValues = new Object[6];

	private void previewPayments() {
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Generating paymentRecords", 0);

					List<PaymentRecord> paymentsList = processor.generatePaymentsList(
							getPaymentRate(),
							getPaymentMonth(), 
							getPaymentYear());
					headerValues[0] = new Date();
					headerValues[1] = getPaymentRate();
					headerValues[2] = String.format("%s-%s", getPaymentMonth(), getPaymentYear());

					BigDecimal total = Constants.BIGZERO;
					for (PaymentRecord record : paymentsList) {
						total.add(record.getTotalPayment());
					}
					int count = paymentsList.size();
					headerValues[3] = count > 0 ? total.divide(new BigDecimal(count), Constants.MONEYCONTEXT) : new BigDecimal(0);
					headerValues[4] = new BigDecimal(paymentsList.size());
					headerValues[5] = total;
					
					MilkPrice paymentRecord = DairyFactory.eINSTANCE.createMilkPrice();
					paymentRecord.setEntryDate(new Date());
					paymentRecord.setMonth(getPaymentMonth());
					paymentRecord.setYear(getPaymentYear());
					paymentRecord.setValue(getPaymentRate());					
					
					for (int i = 0; i < headerWidgets.length; i++) {
						headerWidgets[i].setText( headerValues[i].toString() );						
					}
					
					tableRidget.bindToModel(Observables.staticObservableList(paymentsList), PaymentRecord.class,
							COLUMN_PROPS, COLUMN_HEADERS);
					tableRidget.updateFromModel();
					monitor.done();
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param parent
	 * @param s
	 * @return
	 * @wbp.factory
	 */
	private static Text text(Composite parent, String s) {
		Text text = new Text(parent, SWT.BORDER);

		text.setText(s);
		text.setEditable(false);
		text.setEnabled(false);

		return text;
	}
}
