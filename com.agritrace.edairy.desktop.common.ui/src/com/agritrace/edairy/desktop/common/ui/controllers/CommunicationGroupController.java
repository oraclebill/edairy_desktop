package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.Contactable;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.editingsupport.ColumnEditingSupport;
import com.agritrace.edairy.desktop.common.ui.editingsupport.ContactTypeColumnEditingSupport;
import com.agritrace.edairy.desktop.common.ui.ridgets.IEditableTableRidget;

public class CommunicationGroupController implements WidgetController<Contactable> {

	private IActionRidget addBtn;
	private final String[] columnPropertys = new String[] { ModelPackage.Literals.CONTACT_METHOD__CM_TYPE.getName(),
			ModelPackage.Literals.CONTACT_METHOD__CM_VALUE.getName() };

	private IRidgetContainer container;
	private IActionRidget deleteAllBtn;
	private IActionRidget deleteBtn;
	private IEditableTableRidget editTable;
	private final String[] headers = new String[] { "Type", "Value" };
	private Contactable inputModel;

	public CommunicationGroupController(IController controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}
		editTable = container.getRidget(IEditableTableRidget.class, ContactMethodsGroup.BIND_ID_TABLE);
		editTable.setColumnEditingSupport(0, new ContactTypeColumnEditingSupport());
		editTable.setColumnEditingSupport(1, new ColumnEditingSupport());
		editTable.setColumnWidths(new ColumnLayoutData[] { new ColumnWeightData(100), new ColumnWeightData(500), });
		editTable.addSelectionListener(new ISelectionListener() {

			@Override
			public void ridgetSelected(SelectionEvent event) {
				updateButtonStatus();
			}
		});
		addBtn = container.getRidget(IActionRidget.class, ContactMethodsGroup.BIND_ID_BTN_ADD);
		addBtn.addListener(new IActionListener() {
			@Override
			public void callback() {
				Contactable model = getInputModel();
				if (model != null) {
					final ContactMethod method = ModelFactory.eINSTANCE.createContactMethod();
					method.setCmValue("");
					model.getContactMethods().add(method);
					editTable.updateFromModel();
					updateButtonStatus();
				}
			}
		});
		deleteBtn = container.getRidget(IActionRidget.class, ContactMethodsGroup.BIND_ID_BTN_DELETE);
		deleteBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				Contactable model = getInputModel();
				if (model != null) {
					model.getContactMethods().remove(editTable.getSelectionIndex());
//					editTable.bindToModel(new WritableList(model.getContactMethods(), ContactMethod.class),
//							ContactMethod.class, columnPropertys, headers);
					editTable.updateFromModel();
					updateButtonStatus();
				}
			}
		});
		deleteAllBtn = container.getRidget(IActionRidget.class, ContactMethodsGroup.BIND_ID_BTN_DELETEALL);
		deleteAllBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				Contactable model = getInputModel();
				if (model != null) {
					model.getContactMethods().clear();				
//					editTable.bindToModel(new WritableList(model.getContactMethods(), ContactMethod.class),
//							ContactMethod.class, columnPropertys, headers);
					editTable.updateFromModel();
					updateButtonStatus();
				}
			}
		});
		updateButtonStatus();

	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Contactable getInputModel() {
		return inputModel;
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;
	}

	@Override
	public void setInputModel(Contactable model) {
		inputModel = model;
	}

	@Override
	public void updateBinding() {
		Contactable contactable = getInputModel();
		if (null == contactable)
			return;
		
//		List<ContactMethod> contactMethods = contactable.getContactMethods();
//		if (null == contactMethods)
//			return;
//		
		editTable.bindToModel(
				EMFObservables.observeList(contactable, ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS), 
				ContactMethod.class,
				columnPropertys, headers);
		editTable.updateFromModel();
	}

	private void updateButtonStatus() {
		this.deleteBtn.setEnabled(editTable.getSelectionIndex() > -1);
		this.deleteAllBtn.setEnabled((editTable.getObservableList() != null)
				&& (editTable.getObservableList().size() > 0));
	}

}
