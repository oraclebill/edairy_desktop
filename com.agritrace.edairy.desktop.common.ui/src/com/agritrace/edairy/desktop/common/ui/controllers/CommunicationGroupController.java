package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.Company;
import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.ui.editingsupport.ColumnEditingSupport;
import com.agritrace.edairy.desktop.common.ui.editingsupport.ContactTypeColumnEditingSupport;
import com.agritrace.edairy.desktop.common.ui.ridgets.IEditableTableRidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;

public class CommunicationGroupController implements WidgetController {

	private IController controller;
	private Object inputModel;
	private List<ContactMethod> contactMethods;

	private IEditableTableRidget editTable;
	private IActionRidget addBtn;
	private IActionRidget deleteBtn;
	private IActionRidget deleteAllBtn;
	private String[] columnPropertys = new String[] {
			ModelPackage.Literals.CONTACT_METHOD__CM_TYPE.getName(),
			ModelPackage.Literals.CONTACT_METHOD__CM_VALUE.getName() };

	private String[] headers = new String[] { "Type", "Value" };

	public CommunicationGroupController(IController controller) {
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		editTable = controller.getRidget(IEditableTableRidget.class,
				CommunicationsGroupWidget.BIND_ID_TABLE);
		editTable.setColumnEditingSupport(0, new ContactTypeColumnEditingSupport());
		editTable.setColumnEditingSupport(1, new ColumnEditingSupport());
		editTable.addSelectionListener(new ISelectionListener() {

			@Override
			public void ridgetSelected(SelectionEvent event) {
				updateButtonStatus();
			}
		});
		addBtn = controller.getRidget(IActionRidget.class,
				CommunicationsGroupWidget.BIND_ID_BTN_ADD);
		addBtn.addListener(new IActionListener() {

			@Override
			public void callback() {

				if (getInputModel() instanceof Person
						|| getInputModel() instanceof Company) {
					ContactMethod method = ModelFactory.eINSTANCE
							.createContactMethod();
					method.setCmValue("");
					if (getInputModel() instanceof Person) {
						Person person = (Person) getInputModel();
						person.getContactMethods().add(method);
						editTable.updateFromModel();
						updateButtonStatus();
					} else if (getInputModel() instanceof Company) {
						Company company = (Company) getInputModel();
						company.getContactMethods().add(method);
						editTable.updateFromModel();
						updateButtonStatus();
					}

				}

			}
		});
		deleteBtn = controller.getRidget(IActionRidget.class,
				CommunicationsGroupWidget.BIND_ID_BTN_DELETE);
		deleteBtn.addListener(new IActionListener() {

			@Override
			public void callback() {

				if (getInputModel() instanceof Person
						|| getInputModel() instanceof Company) {
					if (getInputModel() instanceof Person) {
						Person person = (Person) getInputModel();
						person.getContactMethods().remove(
								editTable.getSelectionIndex());
						editTable.bindToModel(
								new WritableList(person.getContactMethods(),
										ContactMethod.class),
								ContactMethod.class, columnPropertys, headers);
					} else if (getInputModel() instanceof Company) {
						Company company = (Company) getInputModel();
						company.getContactMethods().remove(
								editTable.getSelectionIndex());
						editTable.bindToModel(
								new WritableList(company.getContactMethods(),
										ContactMethod.class),
								ContactMethod.class, columnPropertys, headers);
					}

					editTable.updateFromModel();
					updateButtonStatus();
				}
			}
		});
		deleteAllBtn = controller.getRidget(IActionRidget.class,
				CommunicationsGroupWidget.BIND_ID_BTN_DELETEALL);
		deleteAllBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (getInputModel() instanceof Person
						|| getInputModel() instanceof Company) {
					if (getInputModel() instanceof Person) {
						Person person = (Person) getInputModel();
						person.getContactMethods().clear();
						editTable.bindToModel(
								new WritableList(person.getContactMethods(),
										ContactMethod.class),
								ContactMethod.class, columnPropertys, headers);
					} else if (getInputModel() instanceof Company) {
						Company company = (Company) getInputModel();
						company.getContactMethods().clear();
						editTable.bindToModel(
								new WritableList(company.getContactMethods(),
										ContactMethod.class),
								ContactMethod.class, columnPropertys, headers);
					}

					editTable.updateFromModel();
					updateButtonStatus();
				}
				editTable.updateFromModel();
				updateButtonStatus();

			}
		});
		updateButtonStatus();

	}

	private void updateButtonStatus() {
		this.deleteBtn.setEnabled(editTable.getSelectionIndex() > -1);
		this.deleteAllBtn.setEnabled(editTable.getObservableList() != null
				&& editTable.getObservableList().size() > 0);
	}

	@Override
	public Object getInputModel() {
		return inputModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setInputModel(Object model) {
		inputModel = model;
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
		
		if (getInputModel() instanceof Person) {
			contactMethods = ((Person) getInputModel()).getContactMethods();
		} 
		 else if (getInputModel() instanceof Company) {
				contactMethods = ((Company) getInputModel()).getContactMethods();
			}
		else if (getInputModel() instanceof List<?>) {
			contactMethods = (List<ContactMethod>) getInputModel();
		}
		
		// whj: null CM will fail..		
		if (null == contactMethods) return;
		
		editTable.bindToModel(new WritableList(this.contactMethods,
				ContactMethod.class), ContactMethod.class, columnPropertys,
				headers);

		editTable.updateFromModel();
	}

}
