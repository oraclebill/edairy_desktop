/**
 * 
 */
package com.agritrace.edairy.desktop.common.ui.controls.contactmethods;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeTableRidget;
import org.eclipse.riena.ui.ridgets.IRowRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.Contactable;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;

/**
 * @author oraclebill
 * 
 */
public class ContactMethodsGroupRidget extends AbstractCompositeRidget implements IContactMethodsGroupRidget {

	private final class DeleteAllContactsAction implements IActionListener {
		@Override
		public void callback() {
			if (boundContacts != null) {
				if (confirm("Are you sure you want to delete all of the contacts for the dairy?")) {
					boundContacts.clear();
					contactTable.updateFromModel();
					updateButtonStatus();
				}
			}
			else {
				System.err.println("ERR: null model during attempt to delete selected contacts");
			}
		}
	}


	private final class DeleteContactAction implements IActionListener {
		@Override
		public void callback() {
			if (boundContacts != null) {
				for (Object method : contactTable.getSelection()) {
					boundContacts.remove(method);
				}
				contactTable.updateFromModel();
				updateButtonStatus();
			}
			else {
				System.err.println("ERR: null model during attempt to delete selected contacts");
			}
		}
	}


	private final class AddContactAction implements IActionListener {
		@Override
		public void callback() {
			if (boundContacts != null) {
				final ContactMethod method = ModelFactory.eINSTANCE.createContactMethod();
				method.setCmValue("");
				boundContacts.add(method);
				contactTable.updateFromModel();
				updateButtonStatus();
				System.err.println("adding new contact");
			}
		}
	}


	public static final class RowRidget extends AbstractCompositeRidget implements IRowRidget {
		static final IObservableList optionValues = Observables.staticObservableList(ContactMethodType.VALUES);
		static final String CONTACT_TYPE_PROPERTY = ModelPackage.Literals.CONTACT_METHOD__CM_TYPE.getName();
		static final String CONTACT_INFO_DETAIL_PROPERTY = ModelPackage.Literals.CONTACT_METHOD__CM_VALUE.getName();

		private ContactMethod rowData;

		public void setData(final Object rowData) {
			this.rowData = (ContactMethod) rowData;
		}

		@Override
		public void configureRidgets() {
			final IComboRidget contactType = getRidget(IComboRidget.class, "contactType"); //$NON-NLS-1$			
			final IObservableValue selectionValue = BeansObservables.observeValue(rowData, CONTACT_TYPE_PROPERTY);
			contactType.bindToModel(optionValues, ContactMethod.class, "getName", selectionValue);
			contactType.updateFromModel();

			final ITextRidget contactInfo = getRidget(ITextRidget.class, "contactInfo"); //$NON-NLS-1$
			contactInfo.setDirectWriting(true);
			contactInfo.bindToModel(rowData, CONTACT_INFO_DETAIL_PROPERTY);
			contactInfo.updateFromModel();
		}
	}

	private IActionRidget addBtn;
	private IActionRidget deleteAllBtn;
	private IActionRidget deleteBtn;
	private ICompositeTableRidget contactTable;
	private List<ContactMethod> boundContacts;
	private final List<ContactMethod> displayContacts = new LinkedList<ContactMethod>();
	private final IActionListener addContactAction = new AddContactAction();
	private final IActionListener deleteContactAction = new DeleteContactAction();
	private final IActionListener deleteAllAction = new DeleteAllContactsAction();
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.ui.ridgets.IRidgetContainer#configureRidgets()
	 */
	@Override
	public void configureRidgets() {
		contactTable = getRidget(ICompositeTableRidget.class, ContactMethodsGroup.BIND_ID_TABLE);		
		addBtn = getRidget(IActionRidget.class, ContactMethodsGroup.BIND_ID_BTN_ADD);
		deleteBtn = getRidget(IActionRidget.class, ContactMethodsGroup.BIND_ID_BTN_DELETE);
		deleteAllBtn = getRidget(IActionRidget.class, ContactMethodsGroup.BIND_ID_BTN_DELETEALL);


//		contactTable.addSelectionListener(new ISelectionListener() {
//			@Override
//			public void ridgetSelected(SelectionEvent event) {
//				updateButtonStatus();
//			}
//		});
		
		addBtn.addListener(addContactAction);
		deleteBtn.addListener(deleteContactAction);
		deleteAllBtn.addListener(deleteAllAction);
		updateButtonStatus();
	}

	/**
	 * (non-Javadoc)
	 * @see com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget#bindToModel(com.agritrace.edairy.desktop.common.model.base.Contactable)
	 */
	public void bindToModel(Contactable contactable) {
		bindToModel(contactable.getContactMethods());
	}

	/**
	 * 
	 * 
	 */
	public void bindToModel(List<ContactMethod> contacts) {		
		this.boundContacts = contacts;
		if (contacts == null) {
			throw new IllegalArgumentException("Null model");
		}
		contactTable.bindToModel(new WritableList(boundContacts, ContactMethod.class), ContactMethod.class, RowRidget.class);
	}
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	private boolean confirm(String string) {
		return MessageDialog.openConfirm(AbstractDirectoryController.getShell(), "Confirm", string);
	}


	private void updateButtonStatus() {
//		this.deleteBtn.setEnabled(contactTable.getSelectionIndex() > -1);
//		this.deleteAllBtn.setEnabled(boundContacts != null && boundContacts.size() > 0);
	}
}
