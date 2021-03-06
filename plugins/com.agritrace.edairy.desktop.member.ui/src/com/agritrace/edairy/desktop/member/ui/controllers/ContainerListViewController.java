package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IFarmRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractPersistenceDelegate;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.data.ContainerListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ContainerEditDialogController;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(UIPermission.VIEW_CONTAINERS)
public class ContainerListViewController extends BasicDirectoryController<Container> {

	private static class ContainerPersistenceDelegate extends AbstractPersistenceDelegate<Container> {

		final private IRepository<Farm> repository;

		public ContainerPersistenceDelegate(IRepository<Farm> repository) {
			this.repository = repository;
		}

		@Override
		public Container load(Object key) {
			return null;
		}

		@Override
		public void delete(Container obj) {
			Farm farm = obj == null ? null : obj.getOwner();
			if (null != farm) {
				if (farm.getCans().remove(obj)) {
					repository.save(farm);
				} else {
					System.err.println("WARNING: container " + obj + " not found in farm!");
				}
			} else {
				System.err.println("WARNING: container has no owner - unable to delete!");
			}
		}

		@Override
		public void rollback(Object obj) {
			// TODO:
		}

		@Override
		public Container createItem() {
			return TrackingFactory.eINSTANCE.createContainer();
		}

		@Override
		public void persistNew(Container obj) {
			if (obj.getTrackingNumber() == null) {
				// FIXME:
				obj.setTrackingNumber("" + obj.hashCode());
			}
			repository.save(obj);
		}

		@Override
		public Container updateExisting(Container obj) {
			repository.save(obj);
			return obj;
		}
	}

	public static final String ALL_FARM = "All Farms";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected container?";
	public static final String DELETE_DIALOG_TITLE = "Delete Container";

	// table columns
	private final String[] containerColumnHeaders = { "Member No.", "Member Name", "Farm Name", "Container ID",
			"Unit of Measure", "Capacity" };
// private final String[] containerPropertyNames = { "membership.memberNumber", "membership.farmer.formattedName",
// "container.owner.name", "container.trackingNumber", "container.measureType", "container.capacity" };
	private final String[] containerPropertyNames = { "owner.owner.membership.memberNumber", "owner.owner.formattedName",
			"owner.name", "trackingNumber", "measureType", "capacity" };
	
	// filter
	private IComboRidget farmCombo;
	private final List<Farm> farmCombofarms = new ArrayList<Farm>();
	private final List<String> farmNames = new ArrayList<String>();
	private final IFarmRepository farmRepository;
	private IActionRidget memberLookupBtn;
	private ITextRidget memberNameFilter;
	private IActionRidget searchButton;

	// repository
	private Membership selectedMember;

	private final List<ContainerListViewTableNode> tableInput = new ArrayList<ContainerListViewTableNode>();
	private final Provider<MemberLookupDialog> memberSearchProvider;
	private final Provider<ViewContainerDialog> viewContainerProvider;

	final private WritableList availableFarms;
	final private WritableValue selectedFarm;

	@Inject
	public ContainerListViewController(final IFarmRepository farmRepository,
			final Provider<MemberLookupDialog> memberSearchProvider,
			final Provider<ViewContainerDialog> viewContainerProvider) {
		this.farmRepository = farmRepository;
		this.memberSearchProvider = memberSearchProvider;
		this.viewContainerProvider = viewContainerProvider;

		setEClass(TrackingPackage.Literals.CONTAINER);
		setPersistenceDelegate(new ContainerPersistenceDelegate(farmRepository));

		for (int i = 0; i < containerPropertyNames.length; i++) {
			addTableColumn(containerColumnHeaders[i], containerPropertyNames[i], String.class);
		}

		availableFarms = new WritableList();
		selectedFarm = new WritableValue();
	}

	//
	// @Override
	// public void refreshTableContents() {
	// tableInput.clear();
	// tableInput.addAll(getFilteredTableResult());
	// table.updateFromModel();
	// }

// private void updateFarmCombo() {
// farmNames.clear();
// farmNames.add(ALL_FARM);
// if (getSelectedMember() != null) {
// // selectedMember =
// // memberRepository.findByKey(selectedMember.getMemberId());
// farmCombofarms.clear();
// if (farmCombo != null) {
// final String currentSelection = farmCombo.getText();
// final List<Farm> farms = getSelectedMember().getFarmer().getFarms();
// for (final Farm farm : farms) {
// farmNames.add(farm.getName());
// farmCombofarms.add(farm);
// }
// farmCombo.updateFromModel();
// if (MemberUtil.check(currentSelection)) {
// final int index = farmNames.indexOf(currentSelection);
// if (index != -1) {
// farmCombo.setSelection(index);
// return;
// }
// }
// }
// // select the "All Farm" by default
// farmCombo.setSelection(0);
// }
// }

	@Override
	protected void configureFilterRidgets() {
		// search text
		memberNameFilter = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberLookupBtn = getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		memberLookupBtn.addListener(new MemberLookupAction());
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.FARM_LIST_ROUTE_COMBO);
		farmCombo.bindToModel(availableFarms, Farm.class, "getName", selectedFarm);
	}

// @Override
// protected void tableBindToModel() {
// if (table != null) {
// table.bindToModel(new WritableList(tableInput, ContainerListViewTableNode.class),
// ContainerListViewTableNode.class, containerPropertyNames, containerColumnHeaders);
// table.updateFromModel();
// }
// }

// protected List<ContainerListViewTableNode> getFilteredTableResult() {
// final List<ContainerListViewTableNode> results = new ArrayList<ContainerListViewTableNode>();
// final List<Farm> farms = new ArrayList<Farm>();
// if (getSelectedMember() != null) {
// farms.addAll(getSelectedMember().getFarmer().getFarms());
// } else {
// farms.addAll(farmRepository.all());
// }
// if (farmCombo != null) {
// final String farmName = farmCombo.getText();
// for (final Farm farm : farms) {
// if (farmName.isEmpty() || farmName.equals(ALL_FARM) || farmName.equals(farm.getName())) {
// final List<Container> containerList = farm.getCans();
// for (final Container container : containerList) {
// if (getSelectedMember() != null) {
// results.add(new ContainerListViewTableNode(getSelectedMember(), container));
// } else if (container.getOwner().getOwner().eContainer() instanceof Membership) {
// final Membership member = (Membership) container.getOwner().getOwner().eContainer();
// results.add(new ContainerListViewTableNode(member, container));
// }
// }
// }
// }
//
// }
//
// return results;
//
// }

	/**
	 * Open member search dialog, IActionListener for search button
	 * 
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberLookupDialog memberDialog = memberSearchProvider.get();
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				setSelectedMember(memberDialog.getSelectedMember());
				if (getSelectedMember() != null) {
					final String memberName = getSelectedMember().getFarmer().getFormattedName();
					memberNameFilter.setText(memberName);
					availableFarms.clear();
					availableFarms.addAll(getSelectedMember().getFarmer().getFarms());
					if (searchButton != null) {
						searchButton.setEnabled(true);
					}
				}
			} else {
				setSelectedMember(null);
				availableFarms.clear();
			}
			farmCombo.updateFromModel();
		}
	}

	public void setSelectedMember(Membership member) {
		this.selectedMember = member;
	}

	public Membership getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedFarm(Farm farm) {
		this.selectedFarm.setValue(farm);
	}

	public Farm getSelectedFarm() {
		return (Farm) this.selectedFarm.getValue();
	}

// /* (non-Javadoc)
// * @see com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController#getSelectedEObject()
// */
// @Override
// public Container getSelectedEObject() {
// // return ((ContainerListViewTableNode) table.getSelection().get(0)).getContainer();
// return ((ContainerListViewTableNode) table.getSelection().get(0)).getContainer();
// }

	@Override
	protected RecordDialog<Container> getRecordDialog(Shell shell) {
		return new ViewContainerDialog(getShell(), new ContainerEditDialogController(memberSearchProvider));
	}

	@Override
	protected void resetFilterConditions() {
		setSelectedMember(null);
		setSelectedFarm(null);

		memberNameFilter.setText("");
		farmNames.clear();
		farmNames.add(ALL_FARM);
		if (farmCombo != null) {
			farmCombo.setSelection(farmCombo.getEmptySelectionItem());
		}
	}

	@Override
	protected List<Container> getFilteredResult() {
		List<Farm> farms = new ArrayList<Farm>();
		if (getSelectedFarm() != null) {
			farms.add(getSelectedFarm());
		} else if (getSelectedMember() != null) {
			farms.addAll(getSelectedMember().getFarmer().getFarms());
		}
		return farmRepository.findFarmContainers(farms);
	}
}
