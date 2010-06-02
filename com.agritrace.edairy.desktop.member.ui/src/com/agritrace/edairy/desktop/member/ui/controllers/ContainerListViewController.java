package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.services.member.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.ContainerListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddContainerDialog;

public class ContainerListViewController extends BaseListViewController {

	private final IMemberRepository memberRepository;

	private ITableRidget containerListTable;
	private IActionRidget viewRidget;
	private final String[] containerPropertyNames = { "membership", "membership", "container", "container",
			"container", "container", "container" };
	private final String[] containerColumnHeaders = { "Member ID", "Member Name", "Farm Name", "Container ID", "Type",
			"Unit of Measure", "Capacity" };
	private List<Membership> membershipList = new ArrayList<Membership>();
	private List<ContainerListViewTableNode> tableInput = new ArrayList<ContainerListViewTableNode>();

	public static final String DELETE_DIALOG_TITLE = "Delete Container";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected container?";

	public ContainerListViewController() {
		memberRepository = new MemberRepository();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
	}


	protected void configureListGroup() {
		containerListTable = getRidget(ITableRidget.class, ViewWidgetId.CONTAINER_TABLE);

		buildInputList();
		containerListTable.bindToModel(new WritableList(tableInput, ContainerListViewTableNode.class),
				ContainerListViewTableNode.class, containerPropertyNames, containerColumnHeaders);
		setColumnFormatters();

		containerListTable.addSelectionListener(new ISelectionListener() {

			@Override
			public void ridgetSelected(SelectionEvent event) {
				if (event.getSource() == containerListTable) {
					viewRidget.setEnabled(containerListTable.getSelection().size() > 0);
				}
			}

		});
		containerListTable.updateFromModel();
		getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_ADD).addListener(new IActionListener() {

			@Override
			public void callback() {
				Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.LITRE, null, 0.0);
				final AddContainerDialog memberDialog = new AddContainerDialog(Display.getDefault().getActiveShell());
				memberDialog.getController().setContext(
						ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, container);

				int returnCode = memberDialog.open();
				if (returnCode == AbstractWindowController.OK) {
					// container = (Container)
					// memberDialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
					// farmListTableInput.add(newNode);
					// farmListTable.updateFromModel();
				}
			}
		});
		viewRidget = getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_VIEW);
		if (viewRidget != null) {
			viewRidget.setEnabled(false);
			viewRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					ContainerListViewTableNode selectedNode = (ContainerListViewTableNode) containerListTable
							.getSelection().get(0);
					final AddContainerDialog dialog = new AddContainerDialog(Display.getDefault().getActiveShell());
					dialog.getController().setContext(
							ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER,
							selectedNode.getContainer());

					int returnCode = dialog.open();
					if (returnCode == AbstractWindowController.OK) {
						Container container = (Container) dialog.getController().getContext(
								ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
						selectedNode.setContainer(container);
						containerListTable.updateFromModel();
					} else if (returnCode == 2) {
						// confirm for delete
						if (selectedNode != null) {
							if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), DELETE_DIALOG_TITLE,
									DELETE_DIALOG_MESSAGE)) {
								tableInput.remove(selectedNode);
								containerListTable.updateFromModel();
							}
						}
					}
				}
			});
		}
	}

	private void buildInputList() {
		tableInput.clear();
		membershipList.clear();

		membershipList = memberRepository.getMemberships();
		for (Membership membership : membershipList) {
			List<Farm> farms = membership.getMember().getFarms();
			for (Farm farm : farms) {
				List<Container> containerList = farm.getCans();
				for (Container container : containerList) {
					tableInput.add(new ContainerListViewTableNode(membership, container));
				}
			}
		}
	}

	private void setColumnFormatters() {
		// memberId
		containerListTable.setColumnFormatter(0, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Membership membership = ((ContainerListViewTableNode) element).getMembership();
					if (membership != null) {
						return membership.getMemberId() + "";
					}
				}
				return null;
			}
		});
		// memberName
		containerListTable.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Membership membership = ((ContainerListViewTableNode) element).getMembership();
					if (membership != null) {
						Person member = (membership).getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return container.getOwner().getName();
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(3, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return String.valueOf(container.getContainerId());
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(4, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return container.getType().toString();
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(5, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return String.valueOf(container.getMeasureType().toString());
					}
				}
				return null;
			}
		});
		containerListTable.setColumnFormatter(6, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof ContainerListViewTableNode) {
					Container container = ((ContainerListViewTableNode) element).getContainer();
					if (container != null) {
						return String.valueOf(container.getCapacity());
					}
				}
				return null;
			}
		});
	}

	@Override
	protected void configureFilterGroup() {
		// TODO Auto-generated method stub
		
	}

}
