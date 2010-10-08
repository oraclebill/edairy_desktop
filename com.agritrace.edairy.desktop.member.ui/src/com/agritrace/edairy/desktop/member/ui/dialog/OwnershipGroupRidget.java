/**
 *
 */
package com.agritrace.edairy.desktop.member.ui.dialog;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ICompositeTableRidget;
import org.eclipse.riena.ui.ridgets.IRowRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;

/**
 * Ridget for {@link OwnershipGroup}
 */
public class OwnershipGroupRidget extends AbstractCompositeRidget implements IOwnershipGroupRidget {

	private final class DeleteAlAction implements IActionListener {
		@Override
		public void callback() {
			if (ownershipList != null) {
				if (confirm("Are you sure you want to delete all of the ownership history for the animal?")) {
					ownershipList.clear();
					ownershipObjectsList.clear();
					ownershipTable.updateFromModel();
					updateButtonStatus();
				}
			} else {
				System.err.println("ERR: null model during attempt to delete selected ownerships");
			}
		}
	}

	private final class DeleteAction implements IActionListener {
		@Override
		public void callback() {
			if (ownershipList != null) {
				for (final Object method : ownershipTable.getSelection()) {
					if (method instanceof OwnershipBean) {
						ownershipList.remove(((OwnershipBean) method).getIndex());

					}
				}
				updateTable();
				updateButtonStatus();
			} else {
				System.err.println("ERR: null model during attempt to delete selected contacts");
			}
		}
	}

	private final class AddOwnershipAction implements IActionListener {

		int counter;

		@Override
		public void callback() {
			if (ownershipList != null) {
				final String newOwner = "owner" + counter++;
				ownershipList.add(newOwner);
				final OwnershipBean newOwnerObject = createNewOwnership(ownershipList.size() - 1, newOwner);
				ownershipObjectsList.add(newOwnerObject);
				ownershipTable.updateFromModel();
				updateButtonStatus();
				System.err.println("adding new ownership :ownershipList size = " + ownershipList.size());
			}
		}
	}

	public static class RowRidget extends AbstractCompositeRidget implements IRowRidget {

		private OwnershipBean rowData;

		@Override
		public void setData(final Object rowData) {
			this.rowData = (OwnershipBean) rowData;
		}

		@Override
		public void configureRidgets() {
			final ITextRidget ownerName = getRidget(ITextRidget.class, "owner"); //$NON-NLS-1$
			ownerName.setDirectWriting(true);
			ownerName.bindToModel(BeansObservables.observeValue(rowData, OwnershipBean.PROP_OWNERNAME));
			ownerName.updateFromModel();

		}
	}

	private IActionRidget addBtn;
	private IActionRidget deleteAllBtn;
	private IActionRidget deleteBtn;
	private ICompositeTableRidget ownershipTable;
	private List<String> ownershipList;
	private final List<OwnershipBean> ownershipObjectsList = new ArrayList<OwnershipBean>();

	private final IActionListener addContactAction = new AddOwnershipAction();
	private final IActionListener deleteContactAction = new DeleteAction();
	private final IActionListener deleteAllAction = new DeleteAlAction();

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.riena.ui.ridgets.IRidgetContainer#configureRidgets()
	 */
	@Override
	public void configureRidgets() {
		ownershipTable = getRidget(ICompositeTableRidget.class, OwnershipGroup.BIND_ID_TABLE);
		addBtn = getRidget(IActionRidget.class, OwnershipGroup.BIND_ID_BTN_ADD);
		deleteBtn = getRidget(IActionRidget.class, OwnershipGroup.BIND_ID_BTN_DELETE);
		deleteAllBtn = getRidget(IActionRidget.class, OwnershipGroup.BIND_ID_BTN_DELETEALL);

		addBtn.addListener(addContactAction);
		deleteBtn.addListener(deleteContactAction);
		deleteAllBtn.addListener(deleteAllAction);
		ownershipTable.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("Changed !! " + ownershipTable.getSelectionIndex());

			}
		});
		updateButtonStatus();
	}

	/**
	 *
	 *
	 */
	@Override
	public void bindToModel(List<String> ownerships) {
		this.ownershipList = ownerships;
		if (ownerships == null) {
			throw new IllegalArgumentException("Null model");
		}
		ownershipTable.bindToModel(new WritableList(ownershipObjectsList, OwnershipBean.class), OwnershipBean.class, RowRidget.class);
		updateTable();
	}

	private void updateTable() {
		ownershipObjectsList.clear();
		for (int i = 0; i < ownershipList.size(); i++) {
			final OwnershipBean owner = createNewOwnership(i, ownershipList.get(i));
			ownershipObjectsList.add(owner);
		}
		ownershipTable.updateFromModel();
	}

	private OwnershipBean createNewOwnership(int index, String value) {
		final OwnershipBean owner = new OwnershipBean(index, value);
		owner.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof OwnershipBean) {
					final int index = ((OwnershipBean) evt.getSource()).getIndex();
					ownershipList.set(index, (String) evt.getNewValue());
				}
			}
		});
		return owner;
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
		// this.deleteBtn.setEnabled(contactTable.getSelectionIndex() > -1);
		// this.deleteAllBtn.setEnabled(boundContacts != null &&
		// boundContacts.size() > 0);
	}

}
