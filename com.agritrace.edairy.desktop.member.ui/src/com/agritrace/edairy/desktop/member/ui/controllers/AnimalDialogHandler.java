package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.dialog.AddLiveStockDialog;

// TODO: Unused, why?
abstract public class AnimalDialogHandler implements IActionListener {
	private String liveStockRemoveTitle = "";
	private String liveStockRemoveMessage = "";
	
	@Override
	public void callback() {
		/*
		RegisteredAnimal newAnimal = getEditAnimal();
		final AddLiveStockDialog aniamlDialog = new AddLiveStockDialog(Display.getDefault().getActiveShell());
		aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
		final List<Farm> farmList = Collections.unmodifiableList(getFarms());
		aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST, farmList);

		final int returnCode = aniamlDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(
					ControllerContextConstant.DIALOG_CONTXT_SELECTED);
			newAnimal.getLocation().getAnimals().add(newAnimal);
			final Farm farmLocation = newAnimal.getLocation();
			if ((farmLocation != null) && (farmLocation.getFarmId() != null)) {
				save(newAnimal);
			}
//			refreshList();
		} else if (returnCode == 2) {
			if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), liveStockRemoveTitle,
					liveStockRemoveMessage)) {
				delete(newAnimal);
			}
		}
		*/
	}
	
	protected RegisteredAnimal getEditAnimal() {
		return DairyUtil.createAnimal(null, null, "", Gender.MALE,
				DairyUtil.createReferenceAnimal("", ""), Purpose.get(0), RearingMode.get(0),
				DairyUtil.createReferenceAnimal("", ""), "", "", null, null, AcquisitionType.get(0), null);
	}
	
	abstract public  List<Farm> getFarms();
	
	abstract public void save(RegisteredAnimal animal);

	abstract public void delete(RegisteredAnimal animal);

}
