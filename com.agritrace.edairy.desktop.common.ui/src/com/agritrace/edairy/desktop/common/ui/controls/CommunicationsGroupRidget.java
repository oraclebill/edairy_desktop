/**
 * 
 */
package com.agritrace.edairy.desktop.common.ui.controls;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IComplexRidget;
import org.eclipse.riena.ui.ridgets.ICompositeTableRidget;
import org.eclipse.riena.ui.ridgets.IRowRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;

/**
 * @author oraclebill
 * 
 */
public class CommunicationsGroupRidget extends AbstractCompositeRidget implements IComplexRidget {

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
			contactInfo.bindToModel(rowData, CONTACT_INFO_DETAIL_PROPERTY);
			contactInfo.updateFromModel();
		}
	}

	private IActionRidget addBtn;
	private IActionRidget deleteAllBtn;
	private IActionRidget deleteBtn;
	private ICompositeTableRidget contactTable;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.ui.ridgets.IRidgetContainer#configureRidgets()
	 */
	@Override
	public void configureRidgets() {

		contactTable = getRidget(ICompositeTableRidget.class, CommunicationsGroup.BIND_ID_TABLE);
		System.err.println("contactTable: " + contactTable);
		addBtn = getRidget(IActionRidget.class, CommunicationsGroup.BIND_ID_BTN_ADD);
		deleteBtn = getRidget(IActionRidget.class, CommunicationsGroup.BIND_ID_BTN_DELETE);
		deleteAllBtn = getRidget(IActionRidget.class, CommunicationsGroup.BIND_ID_BTN_DELETEALL);

//		contactTable.addSelectionListener(new ISelectionListener() {
//			@Override
//			public void ridgetSelected(SelectionEvent event) {
//				updateButtonStatus();
//			}
//		});
//		addBtn.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				contactTable.
//				Contactable model = getInputModel();
//				if (model != null) {
//					final ContactMethod method = ModelFactory.eINSTANCE.createContactMethod();
//					method.setCmValue("");
//					model.getContactMethods().add(method);
//					contactTable.updateFromModel();
//					updateButtonStatus();
//				}
//			}
//		});
//
//		deleteBtn.addListener(new IActionListener() {
//
//			@Override
//			public void callback() {
//				Contactable model = getInputModel();
//				if (model != null) {
//					model.getContactMethods().remove(contactTable.getSelectionIndex());
////					contactTable.bindToModel(new WritableList(model.getContactMethods(), ContactMethod.class),
////							ContactMethod.class, columnPropertys, headers);
//					contactTable.updateFromModel();
//					updateButtonStatus();
//				}
//			}
//		});
//		deleteAllBtn.addListener(new IActionListener() {
//
//			@Override
//			public void callback() {
//				Contactable model = getInputModel();
//				if (model != null) {
//					model.getContactMethods().clear();
////					contactTable.bindToModel(new WritableList(model.getContactMethods(), ContactMethod.class),
////							ContactMethod.class, columnPropertys, headers);
//					contactTable.updateFromModel();
//					updateButtonStatus();
//				}
//			}
//		});
		updateButtonStatus();
	}

	public void bindToModel(Object listHolder, String listPropertyName) {
		bindToModel(BeansObservables.observeList(listHolder, listPropertyName, ContactMethod.class));
	}

	public void bindToModel(IObservableList observableList) {
		if (observableList == null) {
			throw new IllegalArgumentException("Null model");
		}
		contactTable.bindToModel(observableList, ContactMethod.class, RowRidget.class);
	}

	private void updateButtonStatus() {
//		this.deleteBtn.setEnabled(contactTable.getSelectionIndex() > -1);
//		this.deleteAllBtn.setEnabled((contactTable.getObservableList() != null)
//				&& (contactTable.getObservableList().size() > 0));
	}
}
