package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;

public class AddFarmDialogController extends BaseDialogController<Farm> {
	
	private class AddPropertyChangedListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			if (arg0.getSource() == farmNameTextRidget) {
				farmNameRidget.setText("Farm " + farmNameTextRidget.getText());
			}
			enableSaveButton(validate());
		}

	}

	public static final String DIALOG_TITLE = "Farm";

	public static final String FARM_ID_LABEL_PREFIX = "Farm Id :";
	public static final String FARM_MEMBER_ID_LABEL_PREFIX = "Member Id :";
	public static final String FARM_MEMBER_NAME_LABEL_PREFIX = "Member Name :";
	public static final String FARM_NAME_LABEL_PREFIX = "Farm Name :";
	

	private ILabelRidget farmIdRidget;

	// upper panel fields
	private ILabelRidget farmNameRidget;
	private ITextRidget farmNameTextRidget;

	// live stock tab
	private LocationProfileWidgetController locationProfileController;

	private ILabelRidget memberIdRidget;
	private ILabelRidget memberNameRidget;

	protected FarmListViewTableNode selectedNode;

	public AddFarmDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		selectedNode = (FarmListViewTableNode) getContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
		configureUpperPanel();
		configureTabs();
		if (selectedNode != null) {
			updateBindings();
		}
		configureButtonsPanel();
		addPropertyChangedListener();
		enableSaveButton(validate());
	}
	
	protected void configureTabs(){
		locationProfileController = new LocationProfileWidgetController(this);

	}

	protected void updateBindings() {
		if (selectedNode != null) {
			final Farm selectedFarm = selectedNode.getFarm();
			if (selectedFarm != null) {
				updateUpperPanelBinding();
				locationProfileController.setInputModel(selectedFarm.getLocation());
			}
		}

	}

	@SuppressWarnings("unchecked")
	protected void addPropertyChangedListener() {
		final AddPropertyChangedListener propertyChangedListener = new AddPropertyChangedListener();
		final Iterator<IRidget> ridgetIterator = (Iterator<IRidget>) getRidgets().iterator();
		while (ridgetIterator.hasNext()) {
			final IRidget ridget = ridgetIterator.next();
			if (ridget instanceof ITextRidget) {
				ridget.addPropertyChangeListener("text", propertyChangedListener);
			} else if (ridget instanceof IComboRidget) {
				ridget.addPropertyChangeListener("selection", propertyChangedListener);
			} else if (ridget instanceof IMarkable) {
				ridget.addPropertyChangeListener("marker", propertyChangedListener);
			}
		}
	}

	@Override
	protected void configureButtonsPanel() {
		final IActionRidget okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(OK);
				setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);
				getWindowRidget().dispose();
			}
		});
		final IActionRidget cancelAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(false);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(2);
				getWindowRidget().dispose();
			}
		});
	}

	protected void configureUpperPanel() {
		farmNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_NAME);
		farmNameTextRidget = getRidget(ITextRidget.class, ViewWidgetId.VIEW_FARM_NAME_TXT);
		farmNameTextRidget.setMandatory(true);
		farmNameTextRidget.setDirectWriting(true);
		farmIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_ID);
		memberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_MEMBER_NAME);
		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_MEMBER_ID);
	}

	protected void updateUpperPanelBinding() {
		if ((selectedNode != null) && (selectedNode.getMembership() != null)) {
			final Farm selectedFarm = selectedNode.getFarm();
			farmNameTextRidget.bindToModel(EMFObservables.observeValue(selectedNode.getFarm(),
					TrackingPackage.Literals.FARM__NAME));
			farmNameTextRidget.updateFromModel();
			if ((farmNameRidget != null) && (selectedFarm.getFarmId() != null)) {
				farmNameRidget.setText("Farm " + farmNameTextRidget.getText());
			}

			if (farmIdRidget != null) {
				if (selectedFarm.getFarmId() != null) {
					farmIdRidget.setText(FARM_ID_LABEL_PREFIX + selectedFarm.getFarmId());
				} else {
					farmIdRidget.setText(FARM_ID_LABEL_PREFIX + "<auto>");
				}

			}
			if (memberIdRidget != null) {
				memberIdRidget.setText(FARM_MEMBER_ID_LABEL_PREFIX + selectedNode.getMembership().getMemberId());
			}
			if (memberNameRidget != null) {
				memberNameRidget.setText(FARM_MEMBER_NAME_LABEL_PREFIX
						+ MemberUtil.formattedMemberName(selectedNode.getMembership().getMember()));
			}
		}
	}

	@Override
	protected boolean validate() {
		for (final IRidget ridget : getRidgets()) {
			IMarkableRidget markable;
			if (ridget instanceof IMarkableRidget) {
				markable = (IMarkableRidget) ridget;
				if (markable.isErrorMarked()) {
					return false;
				}
				if (markable.isMandatory()) {
					if (ridget instanceof ITextRidget) {
						if (((ITextRidget) ridget).getText().isEmpty()) {
							return false;
						}
					} else if (ridget instanceof IComboRidget) {
						if (((IComboRidget) ridget).getSelection() == null) {
							return false;
						}
					}
				}
			}
		}
		return true;

	}
	


}
