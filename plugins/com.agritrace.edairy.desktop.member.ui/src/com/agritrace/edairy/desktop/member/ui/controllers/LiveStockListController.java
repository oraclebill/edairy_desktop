package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Comparator;
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
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.AllPermissions;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockFilterWidgetController;
import com.agritrace.edairy.desktop.member.ui.data.LiveStockListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddLiveStockDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewLiveStockDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(AllPermissions.VIEW_LIVESTOCK)
public class LiveStockListController extends BasicDirectoryController<RegisteredAnimal> {

	public static final String ALL_FARM = "All Farms";
	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";

	public static final String liveStockRemoveTitle = "Remove Registered Animales";
	private final String[] columnHeaders = { "Member ID", "Member Name", "Farm Name", "Purpose", "LiveStock Name", "Species", "Breed", "Acquisition Date", "Status" };

	private final IFarmRepository farmRepository;
	private LiveStockFilterWidgetController filterController;
	private final List<LiveStockListViewTableNode> listTableInput = new ArrayList<LiveStockListViewTableNode>();

	private IActionRidget memberLookupBtn;

	// filter group
	private ITextRidget memberNameFilter;

	private final String[] propertyNames = { "membership", "membership", "animal", "animal", "animal", "animal", "animal", "animal", "animal" };

	private Membership selectedMember;
	private final Provider<AddLiveStockDialog> addLiveStockProvider;
	private final Provider<ViewLiveStockDialog> viewLiveStockProvider;
	private final Provider<MemberSearchDialog> memberSearchProvider;

	@Inject
	public LiveStockListController(final IFarmRepository farmRepository,
			final Provider<AddLiveStockDialog> addLiveStockProvider,
			final Provider<ViewLiveStockDialog> viewLiveStockProvider,
			final Provider<MemberSearchDialog> memberSearchProvider) {
		this.farmRepository = farmRepository;
		this.addLiveStockProvider = addLiveStockProvider;
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
		final List<RegisteredAnimal> animals = new ArrayList<RegisteredAnimal>();
		final String farmName = filterController.getFarmCombo().getText();
		final String speciesName = filterController.getSpeciesCombo().getText();
		filterController.getStatusCombo().getText();
		final List<Farm> farms = new ArrayList<Farm>();

		if (selectedMember != null) {
			farms.addAll(selectedMember.getMember().getFarms());
		} else {
			farms.addAll(farmRepository.allWithAnimals());
		}

		for (final Farm farm : farms) {
			if (farmName.equals("All Farms") || farmName.equals(farm.getName())) {
				animals.addAll(farm.getAnimals());
			}
		}

		if (!speciesName.equals("All Species")) {
			for (final RegisteredAnimal animal : animals) {
				if (animal.getAnimalType().getSpecies().equals(speciesName)) {
					selectedAnimals.add(animal);
				}
			}
		}

		// selectedAnimals = filterDate(animals,
		// filterController.getDateSearchController().getStartDate(),
		// filterController.getDateSearchController().getEndDate());
		final DateFilterUtil<RegisteredAnimal> filterUtil = new DateFilterUtil<RegisteredAnimal>(RegisteredAnimal.class, TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION);
		selectedAnimals = filterUtil.filterDate(animals, filterController.getDateSearchController().getStartDate(), filterController.getDateSearchController().getEndDate());

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

	private void setColumnFormatters() {
		// MEMBERID
		table.setColumnFormatter(0, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final Membership membership = ((LiveStockListViewTableNode) element).getMembership();
					if (membership != null) {
						return membership.getMemberId() + "";
					}
				}
				return null;
			}
		});
		table.setComparator(0, new LiveStockListTableComparator(0));
		table.setColumnSortable(0, true);
		// memberName
		table.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final Membership membership = ((LiveStockListViewTableNode) element).getMembership();
					if (membership != null) {
						final Person member = membership.getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
				}
				return null;
			}
		});
		table.setComparator(1, new LiveStockListTableComparator(1));
		table.setColumnSortable(1, true);
		// farm name
		table.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final Farm farm = ((LiveStockListViewTableNode) element).getAnimal().getLocation();
					if (farm != null) {
						return farm.getName();
					}
				}
				return null;
			}
		});
		table.setComparator(2, new LiveStockListTableComparator(2));
		table.setColumnSortable(2, true);
		// purose
		table.setColumnFormatter(3, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						return animal.getPurpose().getLiteral();
					}
				}
				return null;
			}
		});
		// live stock name
		table.setColumnFormatter(4, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						return animal.getGivenName();
					}
				}
				return null;
			}
		});
		table.setComparator(4, new LiveStockListTableComparator(4));
		table.setColumnSortable(4, true);
		// Species
		table.setColumnFormatter(5, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						return animal.getAnimalType().getSpecies();
					}
				}
				return null;
			}
		});

		// breed
		table.setColumnFormatter(6, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						return animal.getAnimalType().getBreed();
					}
				}
				return null;
			}
		});

		// acquisition
		table.setColumnFormatter(7, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final RegisteredAnimal animal = ((LiveStockListViewTableNode) element).getAnimal();
					if (animal != null) {
						final Date acquisitionDate = animal.getDateOfAcquisition();
						final SimpleFormattedDateBean formatter = new SimpleFormattedDateBean();
						formatter.setDate(acquisitionDate);
						return formatter.getFormattedDate();
					}
				}
				return null;
			}
		});
		// status
		table.setColumnFormatter(8, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					return "N/A";
				}
				return null;
			}
		});
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
			setColumnFormatters();
			table.bindToModel(new WritableList(listTableInput, LiveStockListViewTableNode.class), LiveStockListViewTableNode.class, propertyNames, columnHeaders);
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
//		if (selectedMember != null) {
//			if (selectedMember.getMember().getFarms().isEmpty()) {
//				String memberName = MemberUtil.formattedMemberName(selectedMember.getMember());
//				String message = String.format("%s doesn't has any regeistered farm. Can not add a live stock to it.", memberName);
//				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Add LiveStock", message);
//				return;
//			}
			RegisteredAnimal newAnimal = DairyUtil.createAnimal(null, null, "", Gender.FEMALE, DairyUtil.createReferenceAnimal("", ""), Purpose.get(0), RearingMode.get(0), DairyUtil
					.createReferenceAnimal("", ""), "", "", null, null, AcquisitionType.get(0), null);
			newAnimal.setDateOfAcquisition(new Date());
			newAnimal.setDateOfBirth(new Date());
			final AddLiveStockDialog aniamlDialog = addLiveStockProvider.get();
			aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
			final List<Farm> farmList = new ArrayList<Farm>();
			if(selectedMember != null){
			farmList.addAll(selectedMember.getMember().getFarms());
			}

			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST, farmList);

			final int returnCode = aniamlDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED);
				newAnimal.getLocation().getAnimals().add(newAnimal);
				final Farm farmLocation = newAnimal.getLocation();
				if (farmLocation != null && farmLocation.getFarmId() != null) {
					farmRepository.save(newAnimal.getLocation());
				}
				refreshTableContents();
			}
//		} else {
//			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Add LiveStock", "Can not add a Live stock. You must select a Member first");
//		}

	}

	@Override
	protected void handleViewItemAction() {
		if (!table.getSelection().isEmpty()) {
			final LiveStockListViewTableNode selectedNode = (LiveStockListViewTableNode) table.getSelection().get(0);
			final RegisteredAnimal selectedAnimal = selectedNode.getAnimal();
			final ViewLiveStockDialog aniamlDialog = viewLiveStockProvider.get();
			aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, selectedAnimal);
			final List<Farm> farmList = new ArrayList<Farm>();
			farmList.add(selectedAnimal.getLocation());
			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST, farmList);
			aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST, farmList);

			final int returnCode = aniamlDialog.open();
			final Farm farmLocation = selectedAnimal.getLocation();

			if (returnCode == AbstractWindowController.OK) {
				if (farmLocation != null && farmLocation.getFarmId() != null) {
					farmRepository.update(farmLocation);
				}
				refreshTableContents();
			} else if (returnCode == 2) {
				if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), liveStockRemoveTitle, liveStockRemoveMessage)) {
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
			final MemberSearchDialog memberDialog = memberSearchProvider.get();
			final int retVal = memberDialog.open();

			if (retVal == Window.OK) {
				selectedMember = memberDialog.getSelectedMember();

				if (selectedMember != null) {
					final String memberName = MemberUtil.formattedMemberName(selectedMember.getMember());
					memberNameFilter.setText(memberName);
					filterController.setInputModel(selectedMember);
					if (filterController.getSearch() != null) {
						filterController.getSearch().setEnabled(true);
					}
				}

			}
		}
	}

	private class LiveStockListTableComparator implements Comparator<Object> {
		int columnIndex;

		LiveStockListTableComparator(int index) {
			this.columnIndex = index;
		}

		@Override
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Membership && o2 instanceof Membership || o1 instanceof RegisteredAnimal && o2 instanceof RegisteredAnimal) {
				switch (columnIndex) {
				case 0:
					return ((Membership) o1).getMemberId().compareTo(((Membership) o2).getMemberId());
				case 1:
					final Membership node1 = (Membership) o1;
					final Membership node2 = (Membership) o2;
					final Person member1 = node1.getMember();
					final Person member2 = node2.getMember();
					if (member1 != null && member2 != null) {
						final String name1 = member1.getFamilyName() + "," + member1.getGivenName();
						final String name2 = member2.getFamilyName() + "," + member2.getGivenName();
						return name1.compareTo(name2);
					}

					return 0;
				case 2:
					final Farm farm1 = ((RegisteredAnimal) o1).getLocation();
					final Farm farm2 = ((RegisteredAnimal) o2).getLocation();
					if (farm1 != null && farm2 != null) {
						final String name1 = farm1.getName();
						final String name2 = farm2.getName();
						if (name1 != null && name2 != null) {
							return name1.compareTo(name2);
						}
					}

					return 0;
				case 3:
					return 0;
				case 4:
					final String name1 = ((RegisteredAnimal) o1).getGivenName();
					final String name2 = ((RegisteredAnimal) o2).getGivenName();
					if (name1 != null && name2 != null) {
						return name1.compareTo(name2);
					}
				default:
					return 0;
				}
			}
			return 0;
		}

	}
}
