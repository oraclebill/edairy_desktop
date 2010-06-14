package com.agritrace.edairy.desktop.member.ui.controls;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
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
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.ContainerListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;

public class MemberContainerWidgetController implements WidgetController, ISelectionListener {

	private IController controller;
	private Object inputModel;

	private ITableRidget containerTable;
	private IActionRidget containerAddButton;
	private IActionRidget containerViewButton;
	private final String[] containerPropertyNames = { "containerId", "owner", "type", "measureType", "capacity" };
	private final String[] containerColumnHeaders = { "ID", "Farm", "Container Type", "Units Of Measure", "Capacity" };
	private final List<Container> containers = new ArrayList<Container>();
	private final List<Container> containerInput = new ArrayList<Container>();
	private IComboRidget farmFilterCombo;

	private List<Farm> farms = new ArrayList<Farm>();
	private List<String> farmFilterList = new ArrayList<String>();
	public static final String containerRemoveTitle = "Remove Containers";
	public static final String containerRemoveMessage = "Do you want to remove selected containers?";
	public static final String ALL_FARM = "All Farms";
	private MemberRepository memberRepository;
	private FarmRepository farmRepository;

	public MemberContainerWidgetController(IController controller) {
		this.controller = controller;
		memberRepository = new MemberRepository();
		farmRepository = new FarmRepository();
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		containerTable = controller.getRidget(ITableRidget.class, ViewWidgetId.CONTAINER_TABLE);
		containerTable.setColumnFormatter(1, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof Container) {
					return ((Container) element).getOwner().getName();
				}
				return null;
			}
		});
		containerTable.bindToModel(new WritableList(containerInput, Container.class), Container.class,
				containerPropertyNames, containerColumnHeaders);
		containerAddButton = controller.getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_ADD);
		containerAddButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final Shell shell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX
						| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);
				Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.LITRE, null, 0.0);
				final AddContainerDialog memberDialog = new AddContainerDialog(Display.getDefault().getActiveShell());
				memberDialog.getController().setContext(
						ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, container);
				memberDialog.getController().setContext(
						ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, farms);
				int returnCode = memberDialog.open();
				if (returnCode == AbstractWindowController.OK) {
					container = (Container) memberDialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
					container.getOwner().getCans().add(container);
					Farm farm = container.getOwner();
					if(farm.getFarmId() != null){
						farmRepository.update(farm);	
					}
					refreshInputList();
				}
			}
		});

		containerViewButton = controller.getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_Remove);
		containerViewButton.setEnabled(false);
		containerViewButton.addListener(new ViewContainerAction());
		farmFilterCombo = controller.getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_FarmCombo);
	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}

	@Override
	public void setInputModel(Object model) {
		this.inputModel = model;
		if (containerTable != null) {
			updateBinding();
		}

	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;
	}

	@Override
	public void updateBinding() {

		createFarmFilterList();
		refreshInputList();
		containerTable.bindToModel(new WritableList(containerInput, Container.class), Container.class,
				containerPropertyNames, containerColumnHeaders);
		containerTable.updateFromModel();
		containerTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
		containerTable.addSelectionListener(this);

		farmFilterCombo.bindToModel(new WritableList(farmFilterList, String.class), String.class, null,
				new WritableValue());
		farmFilterCombo.updateFromModel();
		farmFilterCombo.setSelection(0);
		farmFilterCombo.addSelectionListener(this);
	}

	private void createFarmFilterList(){
		farmFilterList.clear();
		farmFilterList.add(ALL_FARM);
		if (inputModel != null) {
			if (inputModel instanceof Membership) {
				Membership selectedMember = (Membership) inputModel;
				farms.addAll( selectedMember.getMember().getFarms());
				for (final Farm farm : farms) {
					if (!farmFilterList.contains(farm.getName())) {
						farmFilterList.add(farm.getName());
					}
				}
			} else if (inputModel instanceof Farm) {
				Farm farm = (Farm) inputModel;
				farms.add(farm);
				farmFilterList.add(farm.getName());
			}
		}
	}
	

	private List<Container> getContainerFilteredResult() throws ParseException {
		final List<Container> objs = new ArrayList<Container>();
		SELECT select = null;

		final String selectedValue = (String) farmFilterCombo.getSelection();
		if (selectedValue == null || selectedValue.equals(ALL_FARM)) {
			return containers;
		}
		final Condition farmName = new org.eclipse.emf.query.conditions.strings.StringValue(selectedValue);
		final EObjectCondition farmNameCondition = new EObjectAttributeValueCondition(
				TrackingPackage.Literals.FARM__NAME, farmName);
		final EObjectCondition farmCondidtion = new EObjectReferenceValueCondition(
				TrackingPackage.Literals.CONTAINER__OWNER, farmNameCondition);

		select = new SELECT(new FROM(containers), new WHERE(farmCondidtion));

		final IQueryResult result = select.execute();
		for (final EObject object : result.getEObjects()) {
			objs.add((Container) object);
		}

		return objs;
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == containerTable) {
			final List<Object> selection = event.getNewSelection();
			if (selection.size() > 0) {
				containerViewButton.setEnabled(true);
			} else {
				containerViewButton.setEnabled(false);
			}
		} else if (event.getSource() == farmFilterCombo) {
			refreshInputList();
		}
	}

	private final class ViewContainerAction implements IActionListener{

		@Override
		public void callback() {
			Container selectedNode = (Container) containerTable.getSelection().get(0);
			final ViewContainerDialog dialog = new ViewContainerDialog(Display.getDefault().getActiveShell());
			List <Farm> inputFarms =  new ArrayList<Farm>();
			inputFarms.add(selectedNode.getOwner());

			dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, selectedNode);
			dialog.getController().setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST, inputFarms);

			int returnCode = dialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedNode = (Container) dialog.getController().getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
				farmRepository.update(selectedNode.getOwner());
				refreshInputList();
			} else if (returnCode == 2) {
				// confirm for delete
				if (selectedNode != null) {
					if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), containerRemoveTitle, containerRemoveMessage)) {
						Farm farm = selectedNode.getOwner();
						farm.getCans().remove(selectedNode);
						farmRepository.update(farm);
						refreshInputList();
					}
				}
			}
		}
	}

	public void refreshInputList() {
		try{
			containers.clear();
			containerInput.clear();
			for(Farm farm : farms){
				if(farm.getFarmId() != null){
					farm = farmRepository.findByKey(farm.getFarmId());		
				}
				containers.addAll(farm.getCans());
			}
			containerInput.addAll(getContainerFilteredResult());
			containerTable.updateFromModel();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
