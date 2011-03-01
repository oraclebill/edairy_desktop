package com.agritrace.edairy.desktop.milkops.ui.sales;

import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDetailPanelController;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;
import com.agritrace.edairy.desktop.common.ui.dialogs.CustomerLookupDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.google.inject.Inject;

/**
 * A controller type thing for the milk sales edit panel.
 * 
 * Lifecycle is - instantiate -
 * 
 * @author oraclebill
 * 
 */
public class MilkSaleEditPanelController extends AbstractDetailPanelController<MilkSale> {

	private final IDairyRepository dairyRepo;

	@Inject
	public MilkSaleEditPanelController(final IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;
	}

	@Override
	public void configureAndBind() {
		super.configureAndBind();
		updateWidgetsForSource(getModel().getSaleType());
	}

	@Override
	protected void bindRidgets() {

		final BindingHelper<MilkSale> mapper = getMapper();

		mapper.addMapping(FinanceBindingConstants.ID_TRANSACTION_DATE, DairyPackage.Literals.MILK_SALE__SALE_DATE);
		mapper.addMapping(FinanceBindingConstants.ID_REF_NUMBER_TEXT, DairyPackage.Literals.MILK_SALE__REFERENCE_NUMBER);
		mapper.addMapping(FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT,
				DairyPackage.Literals.MILK_SALE__DESCRIPTION);
// mapper.addMapping(FinanceBindingConstants.ID_LOOKUP_RESULT_TXT, DairyPackage.Literals.MILK_SALE__CUSTOMER,
// ModelPackage.Literals.COMPANY__COMPANY_NAME);
		mapper.addMapping(BindConstants.ID_PRICE_PER_KG, DairyPackage.Literals.MILK_SALE__UNIT_PRICE);
		mapper.addMapping(BindConstants.ID_QUANTITY, DairyPackage.Literals.MILK_SALE__QUANTITY);
		mapper.addMapping(BindConstants.ID_HAS_CONTRACT, DairyPackage.Literals.MILK_SALE__CONTRACT_SALE);
		mapper.addMapping(BindConstants.ID_SALE_AMOUNT, DairyPackage.Literals.MILK_SALE__SALE_AMOUNT);

		mapper.addComboMapping(FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO, dairyRepo.getLocalDairyLocations(),
				"getCode", DairyPackage.Literals.MILK_SALE__STORE_OR_ROUTE);
		getRidget(IComboRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO).addSelectionListener(
				new ISelectionListener() {
					@Override
					public void ridgetSelected(SelectionEvent event) {
						DairyLocation selected = (DairyLocation) event.getNewSelection().get(0);
						getRidget(ITextRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_TEXT).setText(
								selected.getName());
					}
				});

		mapper.addComboMapping(BindConstants.ID_BIN, getBinList(), "getTrackingNumber",
				DairyPackage.Literals.MILK_SALE__BIN);
		mapper.addComboMapping(BindConstants.ID_GRADE, getMilkGradeList(), "getCode",
				DairyPackage.Literals.MILK_SALE__GRADE);
		mapper.addComboMapping(BindConstants.ID_SALES_CLERK, getSalesClerkList(), "getFormattedName",
				DairyPackage.Literals.MILK_SALE__SALES_CLERK);

		final IRidgetContainer container = getRidgetContainer();
		final MilkSale model = getModel();

		// configure and bind sale type options to choice box
		final ISingleChoiceRidget saleType = container.getRidget(ISingleChoiceRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		saleType.bindToModel(Observables.staticObservableList(MilkSaleType.VALUES, MilkSaleType.class),
				PojoObservables.observeValue(model, "saleType"));
		saleType.updateFromModel();
		saleType.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				updateWidgetsForSource((MilkSaleType) saleType.getSelection());
			}
		});

		// configure total sale amount
		configureSaleAmount(container);
		configureCustomerLookup(container, model);

		container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_TEXT).setOutputOnly(true);
	}

	/**
	 * Configure the customer lookup button.
	 * 
	 * @param container
	 * @param model
	 */
	private void configureCustomerLookup(final IRidgetContainer container, final MilkSale model) {
		// configure member lookup action
		final IActionRidget memberLookup = container.getRidget(IActionRidget.class,
				FinanceBindingConstants.ID_LOOKUP_BTN);

		memberLookup.addListener( //
				new CustomerLookupDialog(AbstractDirectoryController.getShell(), dairyRepo.allCustomers()) {
					@Override
					protected void callback(Customer selectedCustomer) {
						final ITextRidget detail = container.getRidget(ITextRidget.class,
								FinanceBindingConstants.ID_LOOKUP_RESULT_TXT);
						model.setCustomer(selectedCustomer);
						detail.setEnabled(true);
						detail.setText(selectedCustomer != null ? selectedCustomer.getCompanyName() : "");
					}
				});

		// text widgets displaying detail value for selected combo items are read/only ...
		container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_LOOKUP_RESULT_TXT).setOutputOnly(true);
	}

	/**
	 * Configure the same amount widget
	 * 
	 * The sale amount is updated automatically based on the quantity and unit price fields, when either is set.
	 * 
	 * @param container
	 */
	private void configureSaleAmount(final IRidgetContainer container) {
		final IDecimalTextRidget quantity = container.getRidget(IDecimalTextRidget.class, BindConstants.ID_QUANTITY);
		final IDecimalTextRidget unitPrice = container.getRidget(IDecimalTextRidget.class,
				BindConstants.ID_PRICE_PER_KG);
		final IDecimalTextRidget saleAmount = container.getRidget(IDecimalTextRidget.class,
				BindConstants.ID_SALE_AMOUNT);

		IFocusListener focusListener = new IFocusListener() {
			@Override
			public void focusLost(FocusEvent event) {
//				final MilkSale model = getModel();
//				final IRidget ridget = event.getOldFocusOwner();
//
//				System.err.println("************** focusLost");
//				System.err.println("model quantity: " + model.getQuantity());
//				System.err.println("widget quantity: " + quantity.getText());
//				System.err.println("model unit price: " + model.getUnitPrice());
//				System.err.println("widget unit price: " + unitPrice.getText());
//				System.err.println("model amount: " + model.getSaleAmount());
//				System.err.println("widget amount: " + saleAmount.getText());
//				
//				if (model.getQuantity() != null) {
//					if (model.getUnitPrice() != null) {
//						// calculate sale amount from unit price and quantity
//						if (model.getSaleAmount() == null) {
//							saleAmount.setText(model.getQuantity().multiply(model.getUnitPrice()).setScale(2, RoundingMode.HALF_DOWN)
//									.toPlainString());
//						}
//					} else if (model.getSaleAmount() != null) {
//						// calculate unit price from sale amount and quantity
//						String val = model.getSaleAmount().divide(model.getQuantity(), RoundingMode.HALF_DOWN)
//								.setScale(2, RoundingMode.HALF_DOWN).toPlainString();
//						unitPrice.setText(val);
//					}
//				}
//				System.err.println("************** focusLost");
			}

			@Override
			public void focusGained(FocusEvent event) {
				// TODO Auto-generated method stub
			}
		};

		// static properties
		saleAmount.setGrouping(true);
		saleAmount.setPrecision(2);
		saleAmount.setSigned(false);
		// saleAmount.setMandatory(true);

		// dynamic behavior
		quantity.addFocusListener(focusListener);
		unitPrice.addFocusListener(focusListener);
		saleAmount.addFocusListener(focusListener);
	}

	private List<Employee> getSalesClerkList() {
		return dairyRepo.getLocalDairy().getEmployees();
	}

	private List<Bin> getBinList() {
		return dairyRepo.getLocalDairy().getDairyBins();
	}

	private List<MilkGrade> getMilkGradeList() {
		List<MilkGrade> retVal = dairyRepo.getMilkGrades();
		return retVal;
	}

	/**
	 * The milk sales panels widgets depend upon the selected options.
	 * 
	 * If the source is 'CREDIT': - Customer and related fields () are mandatory
	 * 
	 */
	void updateWidgetsForSource(MilkSaleType source) {
		final IRidgetContainer container = getRidgetContainer();
		boolean cashSale = container
				.getRidget(ISingleChoiceRidget.class, FinanceBindingConstants.ID_TRANSACTION_CHOICE).getSelection() == MilkSaleType.CASH;

		// cash sale - enable/disable 'customer' related fields:
		enableMandatoryRidget( //
				container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_LOOKUP_BTN), !cashSale);
		container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_LOOKUP_RESULT_TXT).setEnabled(!cashSale);
		container.getRidget(ILabelRidget.class, BindConstants.ID_LOOKUP_LABEL).setEnabled(!cashSale);

		enableMandatoryRidget( //
				container.getRidget(ILabelRidget.class, BindConstants.ID_HAS_CONTRACT), !cashSale);
		container.getRidget(ILabelRidget.class, BindConstants.ID_HAS_CONTRACT_LABEL).setEnabled(!cashSale);
	}

}
