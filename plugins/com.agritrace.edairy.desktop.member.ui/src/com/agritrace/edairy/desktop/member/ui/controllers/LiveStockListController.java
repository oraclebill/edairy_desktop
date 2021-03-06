package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.dao.IFarmRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockFilterWidgetController;
import com.agritrace.edairy.desktop.member.ui.data.LiveStockListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.LivestockEditDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(UIPermission.VIEW_LIVESTOCK)
public class LiveStockListController extends BasicDirectoryController<RegisteredAnimal> {

	public static final String ALL_FARM = "All Farms";
	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";

	public static final String liveStockRemoveTitle = "Remove Registered Animales";
	private static final String[] columnHeaders = { "Member ID", "Member Name", "Farm Name", "Purpose", "Animal Name",
			"Species", "Breed", "Acquisition Date" }; // , "Status" };
	private static final String[] propertyNames = { "membership.memberNumber", "membership.farmer.formattedName",
			"animal.location.name", "animal.purpose", "animal.givenName", "animal.animalType.species",
			"animal.animalType.breed", "animal.dateOfAcquisition" }; // , "animal.status" };

	private final IFarmRepository farmRepository;
	private LiveStockFilterWidgetController filterController;
	private final List<LiveStockListViewTableNode> listTableInput = new ArrayList<LiveStockListViewTableNode>();

	private IActionRidget memberLookupBtn;

	// filter group
	private ITextRidget memberNameFilter;

	private Membership selectedMember;
	private final Provider<LivestockEditDialog> viewLiveStockProvider;
	private final Provider<MemberLookupDialog> memberSearchProvider;

	@Inject
	public LiveStockListController(final IFarmRepository farmRepository,
			final Provider<LivestockEditDialog> viewLiveStockProvider,
			final Provider<MemberLookupDialog> memberSearchProvider) {
		this.farmRepository = farmRepository;
		this.viewLiveStockProvider = viewLiveStockProvider;
		this.memberSearchProvider = memberSearchProvider;
		setEClass(TrackingPackage.Literals.REGISTERED_ANIMAL);

		for (int i = 0; i < propertyNames.length; i++) {
			addTableColumn(columnHeaders[i], propertyNames[i], LiveStockListViewTableNode.class);
		}
	}

	@Override
	public void refreshTableContents() {
		listTableInput.clear();
		listTableInput.addAll(getFilteredTableResult());
		table.updateFromModel();
	}

	private List<LiveStockListViewTableNode> getFilteredTableResult() {
		final List<LiveStockListViewTableNode> results = new ArrayList<LiveStockListViewTableNode>();
		List<RegisteredAnimal> selectedAnimals = new ArrayList<RegisteredAnimal>();
// final List<RegisteredAnimal> animals = new ArrayList<RegisteredAnimal>();
// final String farmName = filterController.getFarmCombo().getText();
		String speciesName = filterController.getSpeciesCombo().getText();
		String status = filterController.getStatusCombo().getText();
// final List<Farm> farms = new ArrayList<Farm>();

// if (selectedMember != null) {
// farms.addAll(selectedMember.getMember().getFarms());
// } else {
// farms.addAll(farmRepository.allWithAnimals());
// }
//
// for (final Farm farm : farms) {
// if (farmName.equals("All Farms") || farmName.equals(farm.getName())) {
// animals.addAll(farm.getAnimals());
// }
// }
//
// if (!speciesName.equals("All Species")) {
// for (final RegisteredAnimal animal : animals) {
// if (animal.getAnimalType().getSpecies().equals(speciesName)) {
// selectedAnimals.add(animal);
// }
// }
// }
//
// // selectedAnimals = filterDate(animals,
// // filterController.getDateSearchController().getStartDate(),
// // filterController.getDateSearchController().getEndDate());
// final DateFilterUtil<RegisteredAnimal> filterUtil = new DateFilterUtil<RegisteredAnimal>(
// RegisteredAnimal.class, TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION);
// selectedAnimals = filterUtil.filterDate(animals, filterController.getDateSearchController().getStartDate(),
// filterController.getDateSearchController().getEndDate());

		if (speciesName.equals("All Species")) {
			speciesName = null;
		}

		selectedAnimals = farmRepository.findRegisteredAnimals(selectedMember, filterController.getFarmCombo()
				.getText(), speciesName, status);

		for (final RegisteredAnimal animal : selectedAnimals) {
			if (selectedMember != null) {
				results.add(new LiveStockListViewTableNode(selectedMember, animal));
			} else {
				final EObject membership = animal.getLocation().getOwner().eContainer();
				if (membership instanceof Membership) {
					results.add(new LiveStockListViewTableNode((Membership) membership, animal));

				}
			}

		}

		return results;
	}

	@Override
	protected void configureFilterRidgets() {
		memberNameFilter = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberLookupBtn = getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		memberLookupBtn.addListener(new MemberLookupAction());
		filterController = new LiveStockFilterWidgetController(this);

	}

	@Override
	protected void tableBindToModel() {
		if (table != null) {

			table.bindToModel(new WritableList(listTableInput, LiveStockListViewTableNode.class),
					LiveStockListViewTableNode.class, propertyNames, columnHeaders);
			table.updateFromModel();
		}
	}

	@Override
	protected List<RegisteredAnimal> getFilteredResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RecordDialog<RegisteredAnimal> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		selectedMember = null;
		memberNameFilter.setText("");
		if (filterController != null) {
			filterController.clearFilters();
		}

	}

	@Override
	protected void handleApplyFilterAction() {
		// Rebind the updateFromModel to refresh the tables
		refreshTableContents();
		table.updateFromModel();
	}

	@Override
	protected void handleNewItemAction() {
		RegisteredAnimal newAnimal = DairyUtil.createAnimal(null, null, "", Gender.FEMALE,
				DairyUtil.createReferenceAnimal("", ""), Purpose.get(0), RearingMode.get(0),
				DairyUtil.createReferenceAnimal("", ""), "", "", null, null, AcquisitionType.get(0), null);
		newAnimal.setDateOfAcquisition(new Date());
		newAnimal.setDateOfBirth(new Date());
		final LivestockEditDialog aniamlDialog = viewLiveStockProvider.get();
		aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
		final List<Farm> farmList = new ArrayList<Farm>();
		if (selectedMember != null) {
			farmList.addAll(selectedMember.getFarmer().getFarms());
		}

		aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST, farmList);

		final int returnCode = aniamlDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(
					ControllerContextConstant.DIALOG_CONTXT_SELECTED);
			newAnimal.getLocation().getAnimals().add(newAnimal);
			final Farm farmLocation = newAnimal.getLocation();
			if (farmLocation != null && farmLocation.getFarmId() != null) {
				farmRepository.save(newAnimal.getLocation());
			}
			refreshTableContents();
		}

	}

	@Override
	protected void handleViewItemAction() {
		if (!table.getSelection().isEmpty()) {
			final LiveStockListViewTableNode selectedNode = (LiveStockListViewTableNode) table.getSelection().get(0);
			final RegisteredAnimal selectedAnimal = selectedNode.getAnimal();
			final LivestockEditDialog aniamlDialog = viewLiveStockProvider.get();
			aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, selectedAnimal);
			final List<Farm> farmList = new ArrayList<Farm>();
			farmList.add(selectedAnimal.getLocation());
			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
					farmList);
			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
					farmList);

			final int returnCode = aniamlDialog.open();
			final Farm farmLocation = selectedAnimal.getLocation();

			if (returnCode == AbstractWindowController.OK) {
				if (farmLocation != null && farmLocation.getFarmId() != null) {
					farmRepository.update(farmLocation);
				}
				refreshTableContents();
			} else if (returnCode == 2) {
				if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), liveStockRemoveTitle,
						liveStockRemoveMessage)) {
					farmLocation.getAnimals().remove(selectedAnimal);
					if (farmLocation.getFarmId() != null) {
						farmRepository.update(farmLocation);
					}
					refreshTableContents();
				}
			}
		}
	}

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
				selectedMember = memberDialog.getSelectedMember();

				if (selectedMember != null) {
					final String memberName = selectedMember.getFarmer().getFormattedName();
					memberNameFilter.setText(memberName);
					filterController.setInputModel(selectedMember);
					if (filterController.getSearch() != null) {
						filterController.getSearch().setEnabled(true);
					}
				}

			}
		}
	}

//	private class LiveStockListTableComparator implements Comparator<Object> {
//		int columnIndex;
//
//		LiveStockListTableComparator(int index) {
//			this.columnIndex = index;
//		}
//
//		@Override
//		public int compare(Object o1, Object o2) {
//			if (o1 instanceof Membership && o2 instanceof Membership || o1 instanceof RegisteredAnimal
//					&& o2 instanceof RegisteredAnimal) {
//				switch (columnIndex) {
//				case 0:
//					return ((Membership) o1).getMemberId().compareTo(((Membership) o2).getMemberId());
//				case 1:
//					final Membership node1 = (Membership) o1;
//					final Membership node2 = (Membership) o2;
//					final Person member1 = node1.getFarmer();
//					final Person member2 = node2.getFarmer();
//					if (member1 != null && member2 != null) {
//						final String name1 = member1.getFamilyName() + "," + member1.getGivenName();
//						final String name2 = member2.getFamilyName() + "," + member2.getGivenName();
//						return name1.compareTo(name2);
//					}
//
//					return 0;
//				case 2:
//					final Farm farm1 = ((RegisteredAnimal) o1).getLocation();
//					final Farm farm2 = ((RegisteredAnimal) o2).getLocation();
//					if (farm1 != null && farm2 != null) {
//						final String name1 = farm1.getName();
//						final String name2 = farm2.getName();
//						if (name1 != null && name2 != null) {
//							return name1.compareTo(name2);
//						}
//					}
//
//					return 0;
//				case 3:
//					return 0;
//				case 4:
//					final String name1 = ((RegisteredAnimal) o1).getGivenName();
//					final String name2 = ((RegisteredAnimal) o2).getGivenName();
//					if (name1 != null && name2 != null) {
//						return name1.compareTo(name2);
//					}
//				default:
//					return 0;
//				}
//			}
//			return 0;
//		}
//
//	}
}
