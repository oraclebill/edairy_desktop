package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.dao.IMilkCollectionRepository;
import com.google.inject.Inject;

public class PaymentRequestViewController extends SubModuleController {

	static class PaymentPeriod {
		enum TYPE {
			MONTHLY, BIWEEKLY, WEEKLY
		};

		private TYPE periodType;
		private int periodNum;
		private int year;

		public TYPE getPeriodType() {
			return periodType;
		}

		public void setPeriodType(TYPE periodType) {
			this.periodType = periodType;
		}

		public int getPeriodNum() {
			return periodNum;
		}

		public void setPeriodNum(int periodNum) {
			this.periodNum = periodNum;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		private static final int[] CALENDAR_FIELDS = new int[] { Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE,
				Calendar.SECOND, Calendar.MILLISECOND };

		public Date getStartDate() {
			Calendar cal = Calendar.getInstance();
			cal.clear();
			cal.set(Calendar.YEAR, getYear());
			switch (getPeriodType()) {
			case WEEKLY:
				cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum());
				break;
			case BIWEEKLY:
				cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum() * 2);
				break;
			case MONTHLY:
				cal.set(Calendar.MONTH, getPeriodNum());
				break;
			default:
				throw new IllegalStateException("Period type not set.");
			}

			for (int field : CALENDAR_FIELDS) {
				cal.set(field, cal.getActualMinimum(field));
			}
			return cal.getTime();
		}

		public Date getEndDate() {
			Calendar cal = Calendar.getInstance();
			cal.clear();
			cal.set(Calendar.YEAR, getYear());
			switch (getPeriodType()) {
			case WEEKLY:
				cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum());
				break;
			case BIWEEKLY:
				cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum() * 2 + 1);
				break;
			case MONTHLY:
				cal.set(Calendar.MONTH, getPeriodNum());
				break;
			default:
				throw new IllegalStateException("Period type not set.");
			}
			for (int field : CALENDAR_FIELDS) {
				cal.set(field, cal.getActualMaximum(field));
			}
			return cal.getTime();
		}

		public String toString() {
			return getYear() + " - " + getPeriodNum() + "(" + getPeriodType() + ")";
		}
	}

	static class RateEntry {
		private BigDecimal rate;
		private BigDecimal gross;

		public RateEntry(BigDecimal rate, BigDecimal gross) {
			this.rate = rate;
			this.gross = gross;
		}

		public BigDecimal getRate() {
			return rate;
		}

		public void setRate(BigDecimal rate) {
			this.rate = rate;
		}

		public BigDecimal getGross() {
			return gross;
		}

		public void setGross(BigDecimal gross) {
			this.gross = gross;
		}
	}

	public static final String PAYMENT_PERIOD_COMBO = "PAYMENT_PERIOD_COMBO";
	public static final String GROSS_COLLECTIONS_TEXT = "GROSS_COLLECTIONS_TEXT";
	public static final String RATE_TABLE = "RATE_TABLE";
	public static final String PAYMENT_RATE_TEXT = "PAYMENT_RATE_TEXT";
	public static final String CALCULATE_BUTTON = "CALCULATE_BUTTON";
	public static final String PRINT_BUTTON = "PRINT_BUTTON";

	private IComboRidget paymentPeriodRidget;
	private ITableRidget rateTableRidget;
	private IActionRidget calculateButtonRidget;
	private IActionRidget printButtonRidget;
	private IDecimalTextRidget paymentRateRidget;
	private IDecimalTextRidget grossCollectionsRidget;

	final private IObservableList observablePaymentPeriods = WritableList.withElementType(PaymentPeriod.class);
	private IMilkCollectionRepository collectionsRepo;

	@Inject
	public PaymentRequestViewController(IMilkCollectionRepository collectionRepo) {
		this.collectionsRepo = collectionRepo;
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		final IObservableValue observableGrossCollections = WritableValue.withValueType(BigDecimal.class);
		final IObservableValue observablePaymentRate = WritableValue.withValueType(BigDecimal.class);
		final IObservableList observablePaymentOptions = WritableList.withElementType(RateEntry.class);
		final IObservableValue selectedPaymentPeriod = WritableValue.withValueType(PaymentPeriod.class);

		paymentPeriodRidget = getRidget(IComboRidget.class, PAYMENT_PERIOD_COMBO);
		paymentPeriodRidget.bindToModel(observablePaymentPeriods, PaymentPeriod.class, "toString",
				selectedPaymentPeriod);
		paymentPeriodRidget.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				PaymentPeriod period = (PaymentPeriod) selectedPaymentPeriod.getValue();
				observableGrossCollections.setValue(queryGrossCollections(period));
			}
		});

		grossCollectionsRidget = getRidget(IDecimalTextRidget.class, GROSS_COLLECTIONS_TEXT);
		grossCollectionsRidget.setSigned(false);
		grossCollectionsRidget.setPrecision(1);
		grossCollectionsRidget.bindToModel(observableGrossCollections);

		paymentRateRidget = getRidget(IDecimalTextRidget.class, PAYMENT_RATE_TEXT);
		paymentRateRidget.setSigned(false);
		paymentRateRidget.setPrecision(1);
		paymentRateRidget.bindToModel(observablePaymentRate);

		rateTableRidget = getRidget(ITableRidget.class, RATE_TABLE);
		rateTableRidget.bindToModel(observablePaymentOptions, RateEntry.class, new String[] { "", "" }, new String[] {
				"", "" });

		calculateButtonRidget = getRidget(IActionRidget.class, CALCULATE_BUTTON);
		calculateButtonRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				BigDecimal rate = (BigDecimal) observablePaymentRate.getValue();
				BigDecimal gross = (BigDecimal) observableGrossCollections.getValue();
				observablePaymentOptions.clear();
				observablePaymentOptions.addAll(calculatePaymentOptions(rate, gross));
				rateTableRidget.updateFromModel();
			}
		});

		printButtonRidget = getRidget(IActionRidget.class, PRINT_BUTTON);
		printButtonRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				printRateOptions(observablePaymentOptions.iterator());
			}
		});
	}

	private void printRateOptions(Iterator<?> iterator) {
		throw new UnsupportedOperationException("Unimplemented");
	}

	protected List<RateEntry> calculatePaymentOptions(BigDecimal rate, BigDecimal gross) {
		ArrayList<RateEntry> list = new ArrayList<RateEntry>();
		BigDecimal checkRate;
		
		if (rate == null) return list;

		checkRate = rate.multiply(new BigDecimal(0.90d));
		list.add(new RateEntry(checkRate, checkRate.multiply(gross)));

		checkRate = rate.multiply(new BigDecimal(0.95d));
		list.add(new RateEntry(checkRate, checkRate.multiply(gross)));

		checkRate = rate;
		list.add(new RateEntry(checkRate, checkRate.multiply(gross)));

		checkRate = rate.multiply(new BigDecimal(1.05d));
		list.add(new RateEntry(checkRate, checkRate.multiply(gross)));

		checkRate = rate.multiply(new BigDecimal(1.10d));
		list.add(new RateEntry(checkRate, checkRate.multiply(gross)));

		return list;
	}

	@Override
	public void afterBind() {
		super.afterBind();
		observablePaymentPeriods.clear();
		observablePaymentPeriods.addAll(getPaymentPeriods());
	}

	private BigDecimal queryGrossCollections(PaymentPeriod period) {
		List<CollectionJournalLine> lines = collectionsRepo.findCollections(null, null, null, period.getStartDate(), period.getEndDate(), false, false,
				false);
		List<?> lines2 = collectionsRepo.filter("CollectionJournalLine",
				new FilterParameter(FilterParameter.Type.GREATER_THAN, "", ""),
				new FilterParameter(FilterParameter.Type.LESS_THAN, "", "")
		);
		return BigDecimal.ONE;
	}

	private List<PaymentPeriod> getPaymentPeriods() {
		return Collections.EMPTY_LIST;
	}

}
