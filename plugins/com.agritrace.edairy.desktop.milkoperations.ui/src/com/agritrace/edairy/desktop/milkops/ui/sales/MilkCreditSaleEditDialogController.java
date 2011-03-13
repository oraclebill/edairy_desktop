package com.agritrace.edairy.desktop.milkops.ui.sales;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeTableRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRowRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.google.inject.Inject;

public class MilkCreditSaleEditDialogController extends RecordDialogController<MilkSaleGroup> {

	/**
	 * Row for a {@link ICompositeTableRidget}.
	 * <p>
	 * Implementation note: class must be public and have a zero-argument public
	 * constructor. Instances will be created by reflection.
	 */
	public static final class RowRidget extends AbstractCompositeRidget implements IRowRidget {
		private MilkSale rowData;
		private static List<Bin> binList = null;


		@Override
		public void setData(final Object rowData) {
			this.rowData = (MilkSale) rowData;
//			EObject container = this.rowData.eContainer();
//			Route journalRoute = null;
//			if (container instanceof MilkSaleGroup) {
//				MilkSaleGroup journal = (MilkSaleGroup) container;
//				journalRoute = journal.getRoute();
//			}
//			binList = dairyRepo.getBinsByRoute(journalRoute);
			// until we have an association between bins and routes (or locations), cache all bins statically
			if (binList == null) {
				binList = dairyRepo.allDairyContainers();
			}
		}

		@Override
		public void configureRidgets() {

			final IRidget binId = getRidget(IComboRidget.class, BindConstants.ID_ROW_BIN_TXT);
			if (binId instanceof ITextRidget) {
				final ITextRidget textBinId = (ITextRidget) binId;
				textBinId.setMandatory(true);
				textBinId.bindToModel(rowData, DairyPackage.Literals.MILK_SALE__BIN.getName());
			}
			else if (binId instanceof IComboRidget) {
				final IComboRidget comboBinId = (IComboRidget) binId;
				comboBinId.setMandatory(true);
				comboBinId.bindToModel(new WritableList(binList, Bin.class), Bin.class, "getContainerId",
					PojoObservables.observeValue(rowData, "bin"));
			}
			binId.updateFromModel();

			final IDecimalTextRidget amount = getRidget(IDecimalTextRidget.class, BindConstants.ID_ROW_AMOUNT_TXT);
			amount.setSigned(false);
			amount.setDirectWriting(true);
			amount.setMandatory(true);
			amount.setModelToUIControlConverter(NumberToStringConverter.fromBigDecimal());
			amount.bindToModel(rowData, DairyPackage.Literals.MILK_SALE__QUANTITY.getName());
			amount.updateFromModel();
			
			final ITextRidget description = getRidget(ITextRidget.class, BindConstants.ID_ROW_DESCRIPTION_TXT); //]
			description.setDirectWriting(true);
			description.bindToModel(rowData, DairyPackage.Literals.MILK_SALE__DESCRIPTION.getName());
			description.updateFromModel();
			description.setMandatory(rowData.isRejected());

			final IToggleButtonRidget rejected = getRidget(IToggleButtonRidget.class, BindConstants.ID_ROW_REJECTED_TXT);
			rejected.bindToModel(EMFObservables.observeValue(rowData, DairyPackage.Literals.MILK_SALE__REJECTED));
			rejected.updateFromModel();
			rejected.addListener(new IActionListener() {
				@Override
				public void callback() {
					description.setMandatory(rejected.isSelected());
				}
			});
		}
	}

	private ICompositeTableRidget lineItemsRidget;

	// HACK, this shouldn't be static
	private static IDairyRepository dairyRepo;
	private final IRepository<CollectionSession> sessionRepo;

	@Inject
	public MilkCreditSaleEditDialogController(final IDairyRepository dairyRepository,
			final IRepository<CollectionSession> sessionRepo) {
		super("Milk Delivery");
		dairyRepo = dairyRepository;
		this.sessionRepo = sessionRepo;
	}

	@Override
	public MilkSaleGroup getWorkingCopy() {
		final MilkSaleGroup working = super.getWorkingCopy();
		if (working.getDate() == null) {
			working.setDate(new Date());
		}
		return working;
	}

	//
	// @Override
	// protected EClass getEClass() {
	// return DairyPackage.Literals.MILK_SALE_GROUP;
	// }

	@Override
	protected void configureUserRidgets() {
		addTextMap(BindConstants.ID_REFERENCE_NUM_TXT,
				DairyPackage.Literals.MILK_SALE_GROUP__REFERENCE_NUMBER);

		addTextMap(BindConstants.ID_DATE_COMBO, DairyPackage.Literals.MILK_SALE_GROUP__DATE);

		final List<CollectionSession> sessions = sessionRepo.all();
		addComboMap(BindConstants.ID_SESSION_COMBO, sessions, "getCode",
				DairyPackage.Literals.MILK_SALE_GROUP__SESSION);

		addComboMap(BindConstants.ID_ROUTE_COMBO, dairyRepo.allRoutes(), "getName",
				DairyPackage.Literals.MILK_SALE_GROUP__ROUTE);

		addComboMap(BindConstants.ID_CUSTOMER_COMBO, dairyRepo.allCustomers(), "getCompanyName",
				DairyPackage.Literals.MILK_SALE_GROUP__CUSTOMER);

		addComboMap(BindConstants.ID_DRIVER_COMBO, dairyRepo.employeesByPosition("Driver"),
				"getFamilyName", DairyPackage.Literals.MILK_SALE_GROUP__DRIVER);

		addComboMap(BindConstants.ID_VEHICLE_COMBO, dairyRepo.allVehicles(), "getRegistrationNumber",
				DairyPackage.Literals.MILK_SALE_GROUP__VEHICLE);

		addTextMap(BindConstants.ID_LINE_ITEM_TOTAL_TXT,
				DairyPackage.Literals.MILK_SALE_GROUP__TOTAL);
		// addRidgetFeatureMap(BindConstants.ID_LINE_ITEM_TABLE,
		// DairyPackage.Literals.MILK_SALE_GROUP__LINES);

		lineItemsRidget = getRidget(ICompositeTableRidget.class, BindConstants.ID_LINE_ITEM_TABLE);
		lineItemsRidget
				.bindToModel(
						BeansObservables.observeList(getWorkingCopy(),
								DairyPackage.Literals.MILK_SALE_GROUP__SALES.getName()), MilkSale.class,
						RowRidget.class);

		lineItemsRidget.addPropertyChangeListener(null, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.err.println(evt.getPropertyName() + ": " + evt.getNewValue());
			}
		});

		final IActionRidget addBttonRidget = getRidget(IActionRidget.class, BindConstants.ID_ADD_ROW_BTN);
		addBttonRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				getWorkingCopy().getSales().add(DairyFactory.eINSTANCE.createMilkSale());
				lineItemsRidget.updateFromModel();
			}
		});

		lineItemsRidget.updateFromModel();
	}

}
