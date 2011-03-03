package com.agritrace.edairy.desktop.finance.ui.paymentrequest;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.dao.IMilkCollectionRepository;
import com.google.inject.Inject;

public class PaymentRequestViewController extends SubModuleController {

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
	private Map<PaymentPeriod, BigDecimal> cachedSums = new HashMap<PaymentPeriod, BigDecimal>();
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
				if (period != paymentPeriodRidget.getEmptySelectionItem()) {
					observableGrossCollections.setValue(queryGrossCollections(period));
				}
				grossCollectionsRidget.updateFromModel();
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
		rateTableRidget.bindToModel(observablePaymentOptions, RateEntry.class, new String[] { "rate", "gross" },
				new String[] { "Rate", "Gross" });
		rateTableRidget.setColumnFormatter(0, new ColumnFormatter() {
			NumberFormat numberFormat = NumberFormat.getIntegerInstance();

			@Override
			public String getText(Object element) {
				String text = "";
				if (element instanceof RateEntry) {
					text = numberFormat.format(((RateEntry) element).getRate());
				}
				return text;
			}
		});
		rateTableRidget.setColumnFormatter(1, new ColumnFormatter() {
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

			@Override
			public String getText(Object element) {
				String text = "";
				if (element instanceof RateEntry) {
					text = numberFormat.format(((RateEntry) element).getGross());
				}
				return text;
			}
		});

		calculateButtonRidget = getRidget(IActionRidget.class, CALCULATE_BUTTON);
		calculateButtonRidget.addListener(new IActionListener() {
			@Override public void callback() {
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

	protected List<RateEntry> calculatePaymentOptions(BigDecimal rate,
			BigDecimal gross) {
		ArrayList<RateEntry> list = new ArrayList<RateEntry>();
		BigDecimal checkRate;

		if (rate == null)
			return list;

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
		updateAllRidgetsFromModel();
	}


	BigDecimal queryGrossCollections(PaymentPeriod period) {
		if (cachedSums.containsKey(period))
			return cachedSums.get(period);

		List<CollectionJournalLine> lines2 = collectionsRepo.filter(
				CollectionJournalLine.class,
				new FilterParameter(FilterParameter.Type.GREATER_THAN, "group.journalDate", period
						.getStartDate()),
				new FilterParameter(FilterParameter.Type.LESS_THAN, "group.journalDate", period
						.getEndDate()));

		BigDecimal sum = BigDecimal.ZERO;
		for (CollectionJournalLine line : lines2) {
			// TODO: filter out invalid records
			sum = sum.add(line.getQuantity());
		}
		cachedSums.put(period, sum);
		return sum;
	}

	List<PaymentPeriod> getPaymentPeriods() {
		ArrayList<PaymentPeriod> periodList = new ArrayList<PaymentPeriod>();
		Calendar now = Calendar.getInstance();
		for (int i = 0; i < 12; i++) {
			now.add(Calendar.MONTH, -1);
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH);

			PaymentPeriod period = new PaymentPeriod();
			period.setPeriodNum(month);
			period.setYear(year);
			period.setPeriodType(Frequency.MONTHLY);

			periodList.add(period);
		}

		return periodList;
	}

}
