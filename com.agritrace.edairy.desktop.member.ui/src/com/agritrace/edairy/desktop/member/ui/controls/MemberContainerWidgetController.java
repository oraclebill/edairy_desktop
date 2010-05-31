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
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.AddContainerDialog;

public class MemberContainerWidgetController implements WidgetController, ISelectionListener{

	private IController controller;
	private Object inputModel;

	private ITableRidget containerTable;
	private IActionRidget containerAddButton;
	private IActionRidget containerRemoveButton;
	private final String[] containerPropertyNames = { "containerId", "owner", "type", "measureType", "capacity" };
	private final String[] containerColumnHeaders = { "ID", "Farm", "Container Type", "Units Of Measure", "Capacity" };
	private final List<Container> containerInput = new ArrayList<Container>();
	private IComboRidget farmFilterCombo;

	public static final String containerRemoveTitle = "Remove Containers";
	public static final String containerRemoveMessage = "Do you want to remove selected containers?";
	public static final String ALL_FARM = "All Farms";

	public MemberContainerWidgetController(IController controller){
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		if(controller == null){
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
				//				final AddContainerDialog dialog = new AddContainerDialog(shell);
				//				dialog.setMemberShip(selectedMember);
				//				if (dialog.open() == Window.OK) {
				//					final Container newContainer = dialog.getNewContainer();
				//					newContainer.getOwner().getCans().add(newContainer);
				//					containerInput.add(newContainer);
				//					List<Container> containers;
				//					try {
				//						containers = getContainerFilteredResult();
				//						containerTable.bindToModel(new WritableList(containers, Container.class), Container.class,
				//								containerPropertyNames, containerColumnHeaders);
				//						containerTable.updateFromModel();
				//					} catch (final ParseException e) {
				//						// TODO Auto-generated catch block
				//						e.printStackTrace();
				//					}
				//
				//				}
			}
		});

		containerRemoveButton = controller.getRidget(IActionRidget.class, ViewWidgetId.CONTAINER_Remove);
		containerRemoveButton.setEnabled(false);
		containerRemoveButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), containerRemoveTitle,
						containerRemoveMessage)) {
					final List<Object> selections = containerTable.getSelection();

					for (final Object selObject : selections) {
						((Container) selObject).getOwner().getCans().remove(selObject);
						containerInput.remove(selObject);
					}
					List<Container> containers;
					try {
						containers = getContainerFilteredResult();
						containerTable.bindToModel(new WritableList(containers, Container.class), Container.class,
								containerPropertyNames, containerColumnHeaders);
						containerTable.updateFromModel();
					} catch (final ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		});
		farmFilterCombo = controller.getRidget(IComboRidget.class, ViewWidgetId.CONTAINER_FarmCombo);
	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}

	@Override
	public void setInputModel(Object model) {
		this.inputModel = model;
		if(containerTable != null){
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
		containerInput.clear();
		final List<String> farmFilterList = new ArrayList<String>();

		if(inputModel != null){
			if(inputModel instanceof Membership){
				Membership selectedMember = (Membership)inputModel;
				final List<Farm> farms = selectedMember.getMember().getFarms();
				farmFilterList.add(ALL_FARM);
				for (final Farm farm : farms) {
					containerInput.addAll(farm.getCans());
					if (!farmFilterList.contains(farm.getName())) {
						farmFilterList.add(farm.getName());
					}
				}
			}else if(inputModel instanceof Farm){
				Farm farm = (Farm)inputModel;
				containerInput.addAll(farm.getCans());
				farmFilterList.add(farm.getName());
			}
		}
		
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

	private List<Container> getContainerFilteredResult() throws ParseException {
		final List<Container> objs = new ArrayList<Container>();
		SELECT select = null;

		final String selectedValue = (String) farmFilterCombo.getSelection();
		if (selectedValue == null || selectedValue.equals(ALL_FARM)) {
			return containerInput;
		}
		final Condition farmName = new org.eclipse.emf.query.conditions.strings.StringValue(selectedValue);
		final EObjectCondition farmNameCondition = new EObjectAttributeValueCondition(
				TrackingPackage.Literals.FARM__NAME, farmName);
		final EObjectCondition farmCondidtion = new EObjectReferenceValueCondition(
				TrackingPackage.Literals.CONTAINER__OWNER, farmNameCondition);

		select = new SELECT(new FROM(containerInput), new WHERE(farmCondidtion));

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
				containerRemoveButton.setEnabled(true);
			} else {
				containerRemoveButton.setEnabled(false);
			}
		}else if(event.getSource() == farmFilterCombo){
			List<Container> filterResults;
			try {
				filterResults = getContainerFilteredResult();
				containerTable.bindToModel(new WritableList(filterResults, Container.class), Container.class,
						containerPropertyNames, containerColumnHeaders);
				containerTable.updateFromModel();
			} catch (ParseException e) {
				e.printStackTrace();
				Activator.getDefault().logError(e, e.getMessage());
			}

		}
	}
}
