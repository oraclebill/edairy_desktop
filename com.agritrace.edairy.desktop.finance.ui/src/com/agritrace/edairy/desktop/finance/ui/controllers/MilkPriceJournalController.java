package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.navigation.INavigationContext;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.model.dairy.security.EmployeePrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.IPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.ui.columnformatters.PersonToFormattedName;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.MilkPriceEditDialog;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

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
	
	private final IDairyRepository dairyRepo;
	private final FilterBean filterBean = new FilterBean();
	private ILabelRidget currentPriceLabel;
	private IDateRangeRidget dateRange;

	private static final String[] MONTHS = new String[] { "January",
		"February", "March", "April", "May", "June", "July", "August",
		"September", "October", "November", "December", };

	@Inject
	public MilkPriceJournalController(final IDairyRepository dairyRepo, final IRepository<MilkPrice> repo) {
		this.dairyRepo = dairyRepo;

		setEClass(DairyPackage.Literals.MILK_PRICE);
		setRepository(repo);

		addTableColumn("Month", DairyPackage.Literals.MILK_PRICE__MONTH, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				String ret = "";
				if ( element instanceof MilkPrice ) {
					ret = getMonth(((MilkPrice)element).getMonth());
				}
				return ret;
			}

			private String getMonth(int month) {
				return MONTHS[month];
			}			
		});
		addTableColumn("Year", DairyPackage.Literals.MILK_PRICE__YEAR);
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
		dateRange = getRidget(IDateRangeRidget.class, MilkPriceJournalConstants.ID_COMBO_RATEMONTH);
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
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, currentPrice.getMonth());
			currentPriceLabel.setText(String.format(
					MilkPriceJournalConstants.CURRENT_PRICE_LABEL_FMT, 
					cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()), 
					currentPrice.getYear(), 
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
		milkPrice.setMonth(Calendar.getInstance().get(Calendar.MONTH));
		milkPrice.setYear(Calendar.getInstance().get(Calendar.YEAR));
		return milkPrice;
	}

	@Override
	protected void createEntity(MilkPrice milkPrice) {
		milkPrice.setEnteredBy(getUser());
		milkPrice.setEntryDate(new Date());
		dairyRepo.getLocalDairy().getPriceHistory().add(milkPrice);
		super.createEntity(milkPrice);
	}

	/**
	 * FIXME
	 */
	private Employee getUser() {
		IPrincipal principal = PrincipalManager.getInstance().getPrincipal();
		if (principal instanceof EmployeePrincipal)
			return(((EmployeePrincipal) principal).getEmployee());
		return null;
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
