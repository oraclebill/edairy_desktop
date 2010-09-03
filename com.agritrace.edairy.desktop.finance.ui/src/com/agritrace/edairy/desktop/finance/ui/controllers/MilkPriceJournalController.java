package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.navigation.INavigationContext;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPricePeriod;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.ui.columnformatters.PersonToFormattedName;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.MilkPriceEditDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

@PermissionRequired(Permission.VIEW_MILK_PRICES)
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

	abstract static class Repo extends HibernateRepository<MilkPrice> implements IRepository<MilkPrice> {
		class LatestMilkPriceQuery extends SessionRunnable<MilkPrice> {
			public void run(Session session) {
				final DetachedCriteria maxDate = DetachedCriteria.forEntityName("MilkPrice").setProjection(
						Property.forName("priceDate").max());
				setResult((MilkPrice) session.createCriteria("MilkPrice")
						.add(Property.forName("priceDate").eq(maxDate)).uniqueResult());
			}
		}

		class MilkPriceDateRangeQuery extends SessionRunnable<List<MilkPrice>> {
			private final Date startDate, endDate;

			public MilkPriceDateRangeQuery(Date startDate, Date endDate) {
				this.startDate = startDate;
				this.endDate = endDate;
			}

			@SuppressWarnings("unchecked")
			public void run(Session session) {
				setResult((List<MilkPrice>) session.createCriteria("MilkPrice")
						.add(Restrictions.between("priceDate", startDate, endDate)).list());
			}
		}
	}
	
	private final IDairyRepository dairyRepo = DairyRepository.getInstance();
	private final FilterBean filterBean = new FilterBean();
	private ILabelRidget currentPriceLabel;
	private IDateRangeRidget dateRange;


	public MilkPriceJournalController() {

		setEClass(DairyPackage.Literals.MILK_PRICE);
		setRepository(RepositoryFactory.getRepository(MilkPrice.class));
		// setRepository(new Repo());

		addTableColumn("Period", DairyPackage.Literals.MILK_PRICE__PRICE_PERIOD);
		addTableColumn("Date", DairyPackage.Literals.MILK_PRICE__PRICE_DATE);
		addTableColumn("Price", DairyPackage.Literals.MILK_PRICE__VALUE);
		addTableColumn("Entered By", DairyPackage.Literals.MILK_PRICE__ENTERED_BY, new PersonToFormattedName(
				"enteredBy"));
		addTableColumn("Entry Date", DairyPackage.Literals.MILK_PRICE__ENTRY_DATE);
		// addTableColumn("Locked",
		// DairyPackage.Literals.MILK_PRICE__ENTRY_DATE);
	}

	@Override
	protected void configureFilterRidgets() {

		currentPriceLabel = getRidget(ILabelRidget.class, MilkPriceJournalConstants.ID_LBL_CURRENT_MILK_PRICE);
		dateRange = getRidget(IDateRangeRidget.class, MilkPriceJournalConstants.ID_DATE_PRICEDATE);
	}

	@Override
	protected void configureViewItemButton(IActionRidget viewButton) {
		// super.configureViewItemButton(viewButton);
		// viewButton.setText("Delete");
		viewButton.setVisible(false);
	}

	@Override
	protected void handleViewItemAction() {
		// MilkPrice selectedObject = getSelectedEObject();
		// boolean doIt = MessageDialog.openConfirm(getShell(),
		// "Confirm Price Deletion",
		// "Are you sure you want to delete this price?");
		// if (doIt) {
		// selectedObject.setStatus("INVALID");
		// selectedObject.setUpdatedBy(currentUser());
		// }
	}
	

	@Override
	public boolean allowsActivate(INavigationNode<?> pNode, INavigationContext context) {
		boolean isOk = super.allowsActivate(pNode, context);
		if (isOk) {
			try {
				updateMilkPrice();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return isOk;
	}

	@Override
	public void afterBind() {

		updateMilkPrice();

		// bind
		dateRange.bindToModel(BeansObservables.observeValue(filterBean, "startDate"),
				BeansObservables.observeValue(filterBean, "endDate"));

		// update
		updateAllRidgetsFromModel();
	}

	/**
	 * Update the milk price that is displayed above the date filter in the list view.
	 * 
	 * 
	 */
	private void updateMilkPrice() {
		MilkPrice currentPrice = getCurrentPrice();
		if (currentPrice != null) {
			currentPriceLabel.setText(String.format(
					MilkPriceJournalConstants.CURRENT_PRICE_LABEL_FMT, 
					currentPrice.getPricePeriod().getName(), 
					currentPrice.getPriceDate(), 
					currentPrice.getValue().toString()));
		} else {
			currentPriceLabel.setText(MilkPriceJournalConstants.CURRENT_PRICE_DEFAULT);
		}
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
		updateMilkPrice();
		return dairyRepo.getMilkPrices(filterBean.getStartDate(), filterBean.getEndDate());
	}

	@Override
	protected RecordDialog<MilkPrice> getRecordDialog(Shell shell) {
		return new MilkPriceEditDialog(shell);
	}

	@Override
	protected MilkPrice createNewModel() {
		final MilkPrice milkPrice = super.createNewModel();
		milkPrice.setPriceDate(new Date());
		milkPrice.setEntryDate(new Date());
		milkPrice.setPricePeriod(MilkPricePeriod.WEEKLY);
		// milkPrice.setEnteredBy(getSecurityContext().getUser());
		milkPrice.setEnteredBy(getDefaultUser());
		return milkPrice;
	}

	@Override
	protected void createEntity(MilkPrice newEntity) {
		DairyRepository.getInstance().getLocalDairy().getPriceHistory().add(newEntity);
		super.createEntity(newEntity);
	}

	/**
	 * FIXME
	 */
	private Employee getDefaultUser() {
		Employee defaultEmp = DairyRepository.getInstance().getLocalDairy().getEmployees().get(0);
		return defaultEmp;
	}

	/**
	 * Reset filter dates to show the last year of entries.
	 */
	@Override
	protected void resetFilterConditions() {
		Calendar now = Calendar.getInstance();
		now.roll(Calendar.YEAR, false);
		filterBean.setStartDate(now.getTime());
		filterBean.setEndDate(new Date());
		dateRange.updateFromModel();
	}

}
