package com.agritrace.edairy.desktop.finance.ui.dialogs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.INumericTextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.finance.ui.controls.MilkPriceJournalConstants;

public class MilkPriceEditController extends RecordDialogController<MilkPrice> {

	static class PriceCheckBean extends AbstractBean {
		public static final String PRICE1 = "price1";
		public static final String PRICE2 = "price2";

		private BigDecimal price1;
		private BigDecimal price2;

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

		public void setPrice2(BigDecimal price2) {
			Object oldValue = this.price2;
			this.price2 = price2;
			firePropertyChanged(PRICE2, oldValue, price2);
		}

		boolean isValid() {
			return price1 == price2;
		}
	}
	
	private final PriceCheckBean priceBean = new PriceCheckBean();
	private INumericTextRidget priceText1;
	private INumericTextRidget priceText2;
	private IDateTimeRidget dateRidget;
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
		
		dateRidget = getRidget(IDateTimeRidget.class, MilkPriceJournalConstants.ID_DATE_PRICEDATE);
		priceText1 = getRidget(INumericTextRidget.class, MilkPriceJournalConstants.ID_TEXT_PRICE1);
		priceText2 = getRidget(INumericTextRidget.class, MilkPriceJournalConstants.ID_TEXT_PRICE2);

		// configure
		dateRidget.setMandatory(true);		
		priceText1.setMandatory(true);
		priceText2.setMandatory(true);		
		priceText1.setDirectWriting(true);
		priceText2.setDirectWriting(true);
		priceText1.setGrouping(true);
		priceText2.setGrouping(true);
		priceText1.setSigned(false);
		priceText2.setSigned(false);
		
		// bind
		dateRidget.bindToModel(BeansObservables.observeValue(getWorkingCopy(), "priceDate"));
		priceText1.bindToModel(BeansObservables.observeValue(priceBean, "price1"));
		priceText2.bindToModel(BeansObservables.observeValue(priceBean, "price2"));
	}

	@Override
	protected boolean validate() {
		boolean isValid = super.validate();
		if ( ! priceBean.isValid() ) {
			priceText1.addPropertyChangeListener(errorMarkerListener );
			priceText2.addPropertyChangeListener(errorMarkerListener);			
		}
		return isValid && priceBean.isValid();
	}

	
}
