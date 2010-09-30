package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MemberContainerWidgetController extends BasicDirectoryController<Container> implements WidgetController<Object> {
	public static final String ALL_FARM = "All Farms";

	public static final String containerRemoveMessage = "Do you want to remove selected containers?";
	public static final String containerRemoveTitle = "Remove Containers";
	private final String[] containerColumnHeaders = { "ID", "Farm", "Units Of Measure", "Capacity" };
	private final List<Container> containerInput = new ArrayList<Container>();
	private final String[] containerPropertyNames = { "containerId", "owner", "measureType", "capacity" };
	private final List<Container> containers = new ArrayList<Container>();
	
	// private IComboRidget farmFilterCombo;
	private final IFarmRepository farmRepository;
	private final Provider<AddContainerDialog> addContainerProvider;
	private final Provider<ViewContainerDialog> viewContainerProvider;
	private final List<Farm> farms = new ArrayList<Farm>();
	private Object inputModel;

	@Inject
	public MemberContainerWidgetController(final IController controller, final IFarmRepository farmRepository,
			final Provider<AddContainerDialog> addContainerProvider,
			final Provider<ViewContainerDialog> viewContainerProvider) {
		this.controller = controller;
		this.farmRepository = farmRepository;
		this.addContainerProvider = addContainerProvider;
		this.viewContainerProvider = viewContainerProvider;
		
		setEClass(TrackingPackage.Literals.CONTAINER);
		for (int i = 0; i < containerPropertyNames.length; i++) {
			addTableColumn(containerColumnHeaders[i], containerPropertyNames[i], String.class);
		}
		configure();
	}

	@Override
	public void configure() {
		configureRidgets();
	}

	@Override
	protected void tableBindToModel() {
		if (table != null) {
			table.setColumnFormatter(1, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof Container) {
						return ((Container) element).getOwner().getName();
					}
					return null;
				}
			});
		}
		super.tableBindToModel();
	}

	@Override
	public IRidgetContainer getContainer() {
		return controller;
	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.controller = container;
	}

	@Override
	public void setInputModel(Object model) {
		this.inputModel = model;
		if (inputModel != null) {
			if (inputModel instanceof Membership) {
				final Membership selectedMember = (Membership) inputModel;
				farms.addAll(selectedMember.getMember().getFarms());

			} else if (inputModel instanceof Farm) {
				final Farm farm = (Farm) inputModel;
				farms.add(farm);
			}
		}
		updateBinding();
	}

	@Override
	public void updateBinding() {

		if (inputModel != null) {
			refreshTableContents();
		}

	}

	@Override
	protected void configureFilterRidgets() {
		// TODO Auto-generated method stub

	}

	@Override
	protected List<Container> getFilteredResult() {
		try {
			containers.clear();
			containerInput.clear();
			for (Farm farm : farms) {
				containers.addAll(farm.getCans());
			}
			containerInput.addAll(containers);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return containerInput;
	}

	@Override
	protected RecordDialog<Container> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleNewItemAction() {
		final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX | SWT.APPLICATION_MODAL);
		shell.setSize(550, 450);
		if (farms.size() == 0) {
			MessageDialog.openInformation(shell, "Add Containter", "Farms list is empty, can not create a container without a farm.");
		} else {
			Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.LITRE, null, 0.0);
			final AddContainerDialog memberDialog = addContainerProvider.get();
			memberDialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, container);
			memberDialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, farms);
			memberDialog.getController().setContext(ControllerContextConstant.ENABLE_LOOKUP,"false");

			if (inputModel instanceof Membership) {
				memberDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, inputModel);
			} else if (inputModel instanceof Farm) {
				memberDialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, ((Farm) inputModel).getOwner());
			}
			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				container = (Container) memberDialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
				container.getOwner().getCans().add(container);
				final Farm farm = container.getOwner();
				if (farm.getFarmId() != null) {
					farmRepository.update(farm);
				}
				refreshTableContents();
			}
		}
	}

	@Override
	protected void handleViewItemAction() {
		Container selectedNode = (Container) table.getSelection().get(0);
		final ViewContainerDialog dialog = viewContainerProvider.get();
		final List<Farm> inputFarms = new ArrayList<Farm>();
		inputFarms.add(selectedNode.getOwner());

		dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, selectedNode);
		dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, inputFarms);
		dialog.getController().setContext(ControllerContextConstant.ENABLE_LOOKUP,"false");

		if (inputModel instanceof Membership) {
			dialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, inputModel);
		} else if (inputModel instanceof Farm) {
			dialog.getController().setContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER, ((Farm) inputModel).getOwner());
		}

		final int returnCode = dialog.open();
		if (returnCode == AbstractWindowController.OK) {
			selectedNode = (Container) dialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
			farmRepository.update(selectedNode.getOwner());
			refreshTableContents();
		} else if (returnCode == 2) {
			// confirm for delete
			if (selectedNode != null) {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), containerRemoveTitle, containerRemoveMessage)) {
					final Farm farm = selectedNode.getOwner();
					farm.getCans().remove(selectedNode);
					farmRepository.update(farm);
					refreshTableContents();
				}
			}
		}
	}

	@Override
	public String getTableWidgetId() {
		return ViewWidgetId.CONTAINER_TABLE;
	}

	@Override
	public String getViewActionId() {
		return ViewWidgetId.CONTAINER_Remove;
	}

	@Override
	public String getAddActionId() {
		// TODO Auto-generated method stub
		return ViewWidgetId.CONTAINER_ADD;
	}

}
