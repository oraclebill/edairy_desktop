package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.MilkPriceEditDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkPriceJournalController extends BasicDirectoryController<MilkPrice> {

	static class FilterBean extends AbstractBean {
		private static final String START_DATE = "start-date";
		private static final String END_DATE = "end-date";

		private Date startDate;
		private Date endDate;

		public FilterBean() {
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			Object oldValue = this.startDate;
			this.startDate = startDate;
			firePropertyChanged(START_DATE, oldValue, startDate);
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			Object oldValue = this.endDate;
			this.endDate = endDate;
			firePropertyChanged(END_DATE, oldValue, endDate);
		}

	}

	private final IDairyRepository dairyRepo = DairyRepository.getInstance();
	private final FilterBean filterBean = new FilterBean();
	private IDateTimeRidget startDate;
	private IDateTimeRidget endDate;

	public MilkPriceJournalController() {		
		setEClass(DairyPackage.Literals.MILK_PRICE);
		
		addTableColumn("Period", DairyPackage.Literals.MILK_PRICE__PRICE_PERIOD);
		addTableColumn("Date", DairyPackage.Literals.MILK_PRICE__PRICE_DATE);
		addTableColumn("Price", DairyPackage.Literals.MILK_PRICE__VALUE);
		addTableColumn("Entered By", DairyPackage.Literals.MILK_PRICE__ENTERED_BY);
		addTableColumn("Entry Date", DairyPackage.Literals.MILK_PRICE__ENTRY_DATE);
		// addTableColumn("Locked",
		// DairyPackage.Literals.MILK_PRICE__ENTRY_DATE);
	}

	@Override
	protected void configureFilterRidgets() {

		// configure
		ILabelRidget currentPriceLabel = getRidget(ILabelRidget.class, MilkPriceJournalConstants.ID_LBL_CURRENT_MILK_PRICE);
		startDate = getRidget(IDateTimeRidget.class, MilkPriceJournalConstants.ID_DATE_START);
		endDate = getRidget(IDateTimeRidget.class, MilkPriceJournalConstants.ID_DATE_END);

		MilkPrice currentPrice = getCurrentPrice();
		if (currentPrice != null) {
			currentPriceLabel.setText(String.format(MilkPriceJournalConstants.CURRENT_PRICE_LABEL_FMT, currentPrice
					.getPricePeriod().getName(), currentPrice.getPriceDate(), currentPrice.getPriceDate()));
		} else {
			currentPriceLabel.setText(MilkPriceJournalConstants.CURRENT_PRICE_DEFAULT);
		}

		// bind
		startDate.bindToModel(BeansObservables.observeValue(filterBean, "startDate"));
		endDate.bindToModel(BeansObservables.observeValue(filterBean, "endDate"));

		// update
		updateAllRidgetsFromModel();
	}

	/**
	 * Gets the current milk price.
	 * 
	 * Note: (TODO) we may want to cache this...
	 * 
	 * @return
	 */
	private MilkPrice getCurrentPrice() {
		return dairyRepo.getCurrentMilkPrice();
	}

	@Override
	protected List<MilkPrice> getFilteredResult() {
		return dairyRepo.getMilkPrices(filterBean.getStartDate(), filterBean.getEndDate());
	}

	@Override
	protected RecordDialog<MilkPrice, ?> getRecordDialog(Shell shell) {
		return new MilkPriceEditDialog(shell);
	}

	/**
	 * Reset filter dates to show the last year of entries.
	 */
	@Override
	protected void resetFilterConditions() {
		Calendar now = Calendar.getInstance();
		now.roll(Calendar.YEAR, false);
		filterBean.setStartDate( now.getTime() );
		filterBean.setEndDate( new Date() );
		
		startDate.updateFromModel();
		endDate.updateFromModel();
	}

}
