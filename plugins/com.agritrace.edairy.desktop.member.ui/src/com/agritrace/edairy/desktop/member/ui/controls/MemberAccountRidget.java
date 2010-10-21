package com.agritrace.edairy.desktop.member.ui.controls;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IPaymentRecord;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.agritrace.edairy.desktop.finance.payments.PaymentRecord;
import com.ibm.icu.util.Calendar;

public class MemberAccountRidget extends AbstractCompositeRidget implements IMemberAccountRidget {
	private static final String[] headerNames = new String[] { "Period", "Milk Delivered", "Milk Income",
			"Credit Accrued", "Earnings / Debt" };
	private static final String[] propertyNames = new String[] { "month", "payableMilkQuantity", "milkIncome",
			"accountCredit", "totalPayment" };

	private static final int YEAR_COUNT = 20;
	private static String[] YEARS;

	static {
		YEARS = new String[YEAR_COUNT];
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < YEAR_COUNT; i++) {
			YEARS[i] = Integer.toString(currentYear - i);
		}
	}

	private final WritableList tableModel;
	private IComboRidget yearCombo;
	private ITableRidget summaryTable;
	private IDecimalTextRidget collectionsQty;
	private IDecimalTextRidget creditTotal;
	private IDecimalTextRidget balanceTotal;
	private ITransactionRepository paymentRepo;
	private Membership member;

	public MemberAccountRidget() {
		super();
		tableModel = new WritableList();
	}

	@Override
	public void configureRidgets() {
		yearCombo = getRidget(IComboRidget.class, MemberAccountWidget2.BIND_ID_YEAR_COMBO);
		yearCombo.bindToModel(new WritableList(Arrays.asList(YEARS), String.class), String.class, null,
				new WritableValue());
		yearCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				updateFromModel();
			}
		});

		summaryTable = getRidget(ITableRidget.class, MemberAccountWidget2.BIND_ID_SUMMARY_TABLE);
		summaryTable.bindToModel(tableModel, PaymentRecord.class, propertyNames, headerNames);
		summaryTable.setSortedColumn(0);
//		summaryTable.setComparator(0, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		});

		collectionsQty = getRidget(IDecimalTextRidget.class, MemberAccountWidget2.BIND_ID_MILK_COLLECTED_TXT);
		collectionsQty.setPrecision(2);
		
		creditTotal = getRidget(IDecimalTextRidget.class, MemberAccountWidget2.BIND_ID_CREDIT_DRAWN_TXT);
		creditTotal.setPrecision(2);
		
		balanceTotal = getRidget(IDecimalTextRidget.class, MemberAccountWidget2.BIND_ID_BALANCE_TXT);
		balanceTotal.setPrecision(2);
		balanceTotal.setMarkNegative(true);
		
	}
	
	@Override public void bindToModel(Membership member, ITransactionRepository paymentRepo) {
		this.member = member;
		this.paymentRepo = paymentRepo;
	}

	@Override
	protected void bindUIControl() {
		// TODO Auto-generated method stub
		super.bindUIControl();
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, MemberAccountWidget.class);
	}

	@Override
	public void updateFromModel() {
		int year = Integer.parseInt((String)yearCombo.getSelection());
		List<IPaymentRecord> records = paymentRepo.findPayments(member, year);
		
		tableModel.clear();
		tableModel.addAll(records);
		summaryTable.updateFromModel();
		
		BigDecimal sums[] = new BigDecimal[3];
		for (int i = 0; i < 3; i++) {
			sums[i] = new BigDecimal(0);
		}
		for (IPaymentRecord record : records) {
			sums[0] = sums[0].add(record.getPayableMilkQuantity());
			sums[1] = sums[1].add(record.getAccountCredits());
			sums[2] = sums[2].add(record.getTotalPayment());
		}
		collectionsQty.setText(sums[0].toString());
		creditTotal.setText(sums[1].toString());
		balanceTotal.setText(sums[2].toString());
	}
}
