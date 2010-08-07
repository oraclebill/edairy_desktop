package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeTableRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRowRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.collection.ui.DeliveryJournalEditBindContants;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkDeliveryJournalEditController extends RecordDialogController<DeliveryJournal> {

	/**
	 * Row for a {@link ICompositeTableRidget}.
	 * <p>
	 * Implementation note: class must be public and have a zero-argument public
	 * constructor. Instances will be created by reflection.
	 */
	public static final class RowRidget extends AbstractCompositeRidget implements IRowRidget {
		private DeliveryJournalLine rowData;
		private static List<DairyContainer> binList = null;


		public void setData(final Object rowData) {
			this.rowData = (DeliveryJournalLine) rowData;
//			EObject container = this.rowData.eContainer();
//			Route journalRoute = null;
//			if (container instanceof DeliveryJournal) {
//				DeliveryJournal journal = (DeliveryJournal) container;
//				journalRoute = journal.getRoute();
//			}
//			binList = dairyRepo.getBinsByRoute(journalRoute);
			// until we have an association between bins and routes (or locations), cache all bins statically
			if (binList == null) {
				binList = DairyRepository.getInstance().allDairyContainers();
			}
		}

		@Override
		public void configureRidgets() {
			
			final IRidget binId = getRidget(IComboRidget.class, DeliveryJournalEditBindContants.ROW_TXT_BIN_ID); //$NON-NLS-1$
			if (binId instanceof ITextRidget) {
				ITextRidget textBinId = (ITextRidget) binId;
				textBinId.setMandatory(true);
				textBinId.bindToModel(rowData, DairyPackage.Literals.DELIVERY_JOURNAL_LINE__BIN.getName());
			}
			else if (binId instanceof IComboRidget) {
				IComboRidget comboBinId = (IComboRidget) binId;
				comboBinId.setMandatory(true);
				comboBinId.bindToModel(new WritableList(binList, DairyContainer.class), DairyContainer.class, "getContainerId", 
					PojoObservables.observeValue(rowData, "bin"));
			}
			binId.updateFromModel();

			final IDecimalTextRidget amount = getRidget(IDecimalTextRidget.class, DeliveryJournalEditBindContants.ROW_TXT_AMOUNT); //$NON-NLS-1$
			amount.setSigned(false);
			amount.setDirectWriting(true);
			amount.setMandatory(true);
			amount.setModelToUIControlConverter(NumberToStringConverter.fromBigDecimal());
			amount.bindToModel(rowData, DairyPackage.Literals.DELIVERY_JOURNAL_LINE__QUANTITY.getName());
			amount.updateFromModel();
			
			final  ITextRidget description =  getRidget(ITextRidget.class, DeliveryJournalEditBindContants.ROW_TXT_DESCRIPTION); //$NON-NLS-1$]
			description.setDirectWriting(true);
			description.bindToModel(rowData, DairyPackage.Literals.DELIVERY_JOURNAL_LINE__DESCRIPTION.getName());
			description.updateFromModel();			
		}		
	}

	private final IDairyRepository dairyRepo = DairyRepository.getInstance();
	private ICompositeTableRidget lineItemsRidget;

	public MilkDeliveryJournalEditController() {
	}

	@Override
	public DeliveryJournal getWorkingCopy() {
		DeliveryJournal working = (DeliveryJournal) super.getWorkingCopy();
		if (working.getDate() == null)
			working.setDate(new Date());
		return working;
	}

	//
	// @Override
	// protected EClass getEClass() {
	// return DairyPackage.Literals.DELIVERY_JOURNAL;
	// }

	@Override
	protected void configureUserRidgets() {
		addTextMap(DeliveryJournalEditBindContants.REFERENCE_NUM,
				DairyPackage.Literals.DELIVERY_JOURNAL__REFERENCE_NUMBER);

		addTextMap(DeliveryJournalEditBindContants.DATE_COMBO, DairyPackage.Literals.DELIVERY_JOURNAL__DATE);

		addComboMap(DeliveryJournalEditBindContants.SESSION_COMBO, Arrays.asList(Session.values()), "getName",
				DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);

		addComboMap(DeliveryJournalEditBindContants.ROUTE_COMBO, dairyRepo.allRoutes(), "getName",
				DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE);

		addComboMap(DeliveryJournalEditBindContants.CUSTOMER_COMBO, dairyRepo.allCustomers(), "getCompanyName",
				DairyPackage.Literals.DELIVERY_JOURNAL__CUSTOMER);

		addComboMap(DeliveryJournalEditBindContants.DRIVER_COMBO, dairyRepo.employeesByPosition("Driver"),
				"getFamilyName", DairyPackage.Literals.DELIVERY_JOURNAL__DRIVER);

		addComboMap(DeliveryJournalEditBindContants.VEHICLE_COMBO, dairyRepo.allVehicles(), "getLogBookNumber",
				DairyPackage.Literals.DELIVERY_JOURNAL__VEHICLE);

		addTextMap(DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT,
				DairyPackage.Literals.DELIVERY_JOURNAL__TOTAL);
		// addRidgetFeatureMap(DeliveryJournalEditBindContants.LINE_ITEM_TABLE,
		// DairyPackage.Literals.DELIVERY_JOURNAL__LINES);

		lineItemsRidget = getRidget(ICompositeTableRidget.class, DeliveryJournalEditBindContants.LINE_ITEM_TABLE);
		lineItemsRidget
				.bindToModel(
						BeansObservables.observeList(getWorkingCopy(),
								DairyPackage.Literals.DELIVERY_JOURNAL__LINES.getName()), DeliveryJournalLine.class,
						RowRidget.class);

		lineItemsRidget.addPropertyChangeListener(null, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.err.println(evt.getPropertyName() + ": " + evt.getNewValue());
			}
		});

		IActionRidget addBttonRidget = getRidget(IActionRidget.class, DeliveryJournalEditBindContants.BTN_ADD_ROW);
		addBttonRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				getWorkingCopy().getLines().add(DairyFactory.eINSTANCE.createDeliveryJournalLine());
				lineItemsRidget.updateFromModel();
			}
		});

		lineItemsRidget.updateFromModel();
	}

}
