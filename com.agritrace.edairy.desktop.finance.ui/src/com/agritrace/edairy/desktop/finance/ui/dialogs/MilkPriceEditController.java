package com.agritrace.edairy.desktop.finance.ui.dialogs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.INumericTextRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.ibm.icu.util.Calendar;

public class MilkPriceEditController extends RecordDialogController<MilkPrice> {
	private static final String[] MONTHS = new String[] { "January",
			"February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December", };

	static class PriceCheckBean extends AbstractBean {
		public static final String PRICE1 = "price1";
		public static final String PRICE2 = "price2";

		private BigDecimal price1;
		private BigDecimal price2;
		private int month;
		private int year;

		public BigDecimal getPrice1() {
			return price1;
		}

		public void setPrice1(BigDecimal price1) {
			Object oldValue = this.price1;
			this.price1 = price1;
			firePropertyChanged(PRICE1, oldValue, price1);
		}

		public BigDecimal getPrice2() {
			return price2;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public void setPrice2(BigDecimal price2) {
			Object oldValue = this.price2;
			this.price2 = price2;
			firePropertyChanged(PRICE2, oldValue, price2);
		}

		boolean isValid() {
			return price1 != null && price2 != null && price1.equals(price2);
		}
	}

	private final PriceCheckBean priceBean = new PriceCheckBean();
	private INumericTextRidget priceText1;
	private INumericTextRidget priceText2;
	private IComboRidget monthCombo, yearCombo;
	private PropertyChangeListener errorMarkerListener = new PropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			boolean matched = priceBean.isValid();
			priceText1.setErrorMarked(!matched);
			priceText2.setErrorMarked(!matched);
		}
	};

	public MilkPriceEditController() {

	}

	@Override
	protected void configureUserRidgets() {

		monthCombo = getRidget(IComboRidget.class,
				MilkPriceJournalConstants.ID_COMBO_RATEMONTH);
		yearCombo = getRidget(IComboRidget.class,
				MilkPriceJournalConstants.ID_COMBO_RATEYEAR);
		priceText1 = getRidget(IDecimalTextRidget.class,
				MilkPriceJournalConstants.ID_TEXT_PRICE1);
		priceText2 = getRidget(IDecimalTextRidget.class,
				MilkPriceJournalConstants.ID_TEXT_PRICE2);

		// configure
		monthCombo.setMandatory(true);
		yearCombo.setMandatory(true);
		priceText1.setMandatory(true);
		priceText2.setMandatory(true);

		priceText1.setDirectWriting(true);
		priceText2.setDirectWriting(true);

		priceText1.setGrouping(true);
		priceText2.setGrouping(true);

		priceText1.setSigned(false);
		priceText2.setSigned(false);

	}

	public void afterBind() {
		super.afterBind();
		// bind
		monthCombo.bindToModel(Observables.staticObservableList(Arrays
				.asList(MilkPriceEditDialog.MONTHS)), String.class, null,
				new WritableValue());
		monthCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				priceBean.setMonth(monthCombo.getSelectionIndex());
			}
		});
		monthCombo.updateFromModel();
		monthCombo.setSelection(Calendar.getInstance().get(Calendar.MONTH));
		
		List<Integer> yearList = new ArrayList<Integer>();
		int start = Calendar.getInstance().get(Calendar.YEAR) - 2;
		for (int i = 0; i < 5; i++) {
			yearList.add(start + i);
		}
		yearCombo.bindToModel(Observables.staticObservableList(yearList),
				Integer.class, null, new WritableValue());
		yearCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				Object selection = yearCombo.getSelection();
				if (selection instanceof Integer) {
					priceBean.setYear((Integer)selection);
				}
			}
		});
		yearCombo.updateFromModel();
		yearCombo.setSelection(2);

		priceText1.bindToModel(BeansObservables.observeValue(priceBean,
				"price1"));
		priceText2.bindToModel(BeansObservables.observeValue(priceBean,
				"price2"));

		for (IRidget r : getRidgets()) {
			r.updateFromModel();
		}
	}

	@Override
	protected boolean validate() {
		boolean superValid = super.validate();
		boolean beanValid = priceBean.isValid();
		if (!beanValid) {
			priceText1.addPropertyChangeListener(errorMarkerListener);
			priceText2.addPropertyChangeListener(errorMarkerListener);
		}
		beanValid = superValid && beanValid;
		if (beanValid) {
			getWorkingCopy().setValue(priceBean.getPrice1());
			getWorkingCopy().setMonth(priceBean.getMonth());
			getWorkingCopy().setYear(priceBean.getYear());
		}
		return beanValid;
	}

}
