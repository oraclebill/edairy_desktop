package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.dao.IFarmRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IMemberRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MemberFarmWidgetController extends WidgetDirectoryController<Farm> implements WidgetController<Object> {

	public static final String farmRemoveMessage = "Do you want to remove selected farms?";

	public static final String farmRemoveTitle = "Remove Farm";

	private final String[] farmColumnHeaders = { "ID", "Name", "Location", "Number of Animals", "Number of Conatiners" };
	private final String[] farmPropertyNames = { "farmId", "name", "location.formattedLocation", "numberOfAnimals", "numberOfContainers" };

	private final IFarmRepository farmRepository;
	private final IMemberRepository memberRepository;
	private final Provider<AddFarmDialog> addDialogProvider;
	private final Provider<ViewFarmDialog> viewDialogProvider;
	private final List<Farm> farms = new ArrayList<Farm>();
	private Membership selectedMember;

	@Inject
	public MemberFarmWidgetController(final IController controller, final IFarmRepository farmRepository,
			final IMemberRepository memberRepository,
			final Provider<AddFarmDialog> addDialogProvider, final Provider<ViewFarmDialog> viewDialogProvider) {
		this.memberRepository = memberRepository;
		this.farmRepository = farmRepository;
		this.controller = controller;
		this.addDialogProvider = addDialogProvider;
		this.viewDialogProvider = viewDialogProvider;
		setEClass(TrackingPackage.Literals.FARM);

		for (int i = 0; i < farmPropertyNames.length; i++) {
			addTableColumn(farmColumnHeaders[i], farmPropertyNames[i], String.class);
		}

		configure();
	}

	@Override
	public void configure() {
		configureRidgets();
	}

	@Override
	public IRidgetContainer getContainer() {
		return controller;
	}

	@Override
	public Object getInputModel() {
		return selectedMember;
	}



	@Override
	public void setInputModel(Object model) {
		selectedMember = (Membership) model;
		if (table != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (selectedMember != null) {
			farms.clear();
			farms.addAll(selectedMember.getMember().getFarms());
			table.updateFromModel();
		}
	}

	private void deleteFarm() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), farmRemoveTitle, farmRemoveMessage)) {
			final List<Object> selections = table.getSelection();
			if (selectedMember != null) {
				for (final Object selObject : selections) {
					selectedMember.getMember().getFarms().remove(selObject);
					((Farm) selObject).getAnimals().clear();
					((Farm) selObject).setLocation(null);
					selectedMember.getMember().getFarms().remove(selObject);
					farms.remove(selObject);
					farmRepository.delete((Farm) selObject);
					memberRepository.update(selectedMember);
				}

				table.updateFromModel();
			}
		}
	}

	@Override
	protected void configureFilterRidgets() {
		// TODO Auto-generated method stub

	}

	@Override
	protected List<Farm> getFilteredResult() {
		updateBinding();
		return farms;
	}

	@Override
	protected RecordDialog<Farm> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleNewItemAction() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
				| SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);
		final Location newFarmLocation = DairyUtil.createLocation(null, null, null);
		final Farm newFarm = DairyUtil.createFarm("", newFarmLocation);
		FarmListViewTableNode newNode = new FarmListViewTableNode(selectedMember, newFarm);
		final AddFarmDialog memberDialog = addDialogProvider.get();
		memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
				newNode);

		final int returnCode = memberDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			newNode = (FarmListViewTableNode) memberDialog.getController().getContext(
					ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
			selectedMember.getMember().getFarms().add(newFarm);
			if (selectedMember.getMemberId() != null) {
				farmRepository.saveNew(newFarm);
				memberRepository.update(selectedMember);
			}

			farms.add(newFarm);
			table.updateFromModel();
		}
	}


	@Override
	protected void handleViewItemAction() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
				| SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);

		final List<Object> selections = table.getSelection();
		if (selections.size() > 0) {
			final Farm selectedFarm = (Farm) selections.get(0);
			FarmListViewTableNode newNode = new FarmListViewTableNode(selectedMember, selectedFarm);
			final ViewFarmDialog memberDialog = viewDialogProvider.get();
			memberDialog.getController().setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM,
					newNode);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				newNode = (FarmListViewTableNode) memberDialog.getController().getContext(
						ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
				farmRepository.update(selectedFarm);
				memberRepository.update(selectedMember);
				table.updateFromModel();
			} else if (returnCode == 2) {
				deleteFarm();

			}
		}
	}
	@Override
	protected List<Farm> getTableContents() {
		return farms;
	}

	@Override
	public String getTableWidgetId() {
		return ViewWidgetId.FARM_TABLE;
	}

	@Override
	public String getViewActionId() {
		return ViewWidgetId.FARM_View;
	}

	@Override
	public String getAddActionId() {
		return ViewWidgetId.FARM_ADD;
	}

}
