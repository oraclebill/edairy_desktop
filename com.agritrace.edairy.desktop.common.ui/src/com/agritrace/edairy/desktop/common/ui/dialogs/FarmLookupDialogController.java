package com.agritrace.edairy.desktop.common.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;

public class FarmLookupDialogController extends LookupDialogController<Farm> {

	public static final String[] labels = new String[] { "ID", "Name",
			"Location" };
	private SelectItemAction selectAction = new SelectItemAction();

	@Override
	protected EClass getEClass() {
		return TrackingPackage.Literals.FARM;
	}

	@Override
	public void configureRidgets() {

		super.configureRidgets();

		// Column comobo
		IComboRidget columns = null; 
//			getRidget(IComboRidget.class,
//				FarmSearchDialog.SEARCH_COLUMN_COMBO);
		List<String> columnOptions = new ArrayList<String>();
		columnOptions.add("ID");
		columnOptions.add("Name");
		columnOptions.add("Location");
		columns.bindToModel(Observables.staticObservableList(columnOptions),
				String.class, null, new WritableValue());
		columns.updateFromModel();
		columns.setSelection(0);

		ITableRidget listTable = null;
			//getRidget(ITableRidget.class,		FarmSearchDialog.RESULT_LIST);
		listTable.setColumnWidths(new Object[] { new ColumnWeightData(10),
				new ColumnWeightData(40), new ColumnWeightData(40) });
		this.refreshTableContents();
		WritableList list = new WritableList(getTableContents(), Farm.class);
		listTable.bindToModel(list, Farm.class, new String[] {
				TrackingPackage.Literals.FARM__FARM_ID.getName(),
				TrackingPackage.Literals.FARM__NAME.getName(),
				TrackingPackage.Literals.FARM__LOCATION.getName() },
				new String[] { "ID", "Name", "Location" });
		listTable.setColumnFormatter(2, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof Farm) {
					Farm farm = (Farm) element;
					if (farm.getLocation() != null) {
						return "location";
					}

				}
				return super.getText(element);
			}
		});
		listTable.updateFromModel();
		listTable.addSelectionListener(new ISelectionListener() {

			@Override
			public void ridgetSelected(SelectionEvent event) {
				IActionRidget selectButton = getRidget(IActionRidget.class,
						CommonLookupDialog.SELECT_BUTTON);
				selectButton.setEnabled(true);
				if (event.getNewSelection().size() > 0) {
					setSelectedObject((Farm)event.getNewSelection().get(0));
				}
			}
		});
		listTable.addDoubleClickListener(selectAction);
		if (this.getSelectedObject() != null) {
			listTable.setSelection(this.getSelectedObject());
		}

		// Select Button
		IActionRidget selectButton = getRidget(IActionRidget.class,
				CommonLookupDialog.SELECT_BUTTON);
		selectButton.setEnabled(false);
		selectButton.addListener(this.selectAction);

	}

	private class SelectItemAction implements IActionListener {

		@Override
		public void callback() {
			setReturnCode(Window.OK);
			getWindowRidget().dispose();
		}

	}


	@Override
	protected List<Farm> getFilteredResult() {
		IFarmRepository farmRepo = new FarmRepository();
		List<Farm> myFarms = new ArrayList<Farm>();
		myFarms.add(DairyUtil.createFarm("Test Farm",
				DairyUtil.createLocation(null, null, null)));
		myFarms.add(DairyUtil.createFarm("Farm 2",
				DairyUtil.createLocation(null, null, null)));
		return myFarms;
	}
}
