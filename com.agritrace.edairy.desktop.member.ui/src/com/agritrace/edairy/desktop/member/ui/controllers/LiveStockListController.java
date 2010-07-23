package com.agritrace.edairy.desktop.member.ui.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberAdapter;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition.RelationalOperator;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockFilterWidgetController;
import com.agritrace.edairy.desktop.member.ui.data.LiveStockListViewTableNode;
import com.agritrace.edairy.desktop.member.ui.dialog.AddLiveStockDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewLiveStockDialog;

public class LiveStockListController extends BaseListViewController {

	/**
	 * Open member search dialog, IActionListener for search button
	 * 
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = new MemberSearchDialog(null);
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

	private class AddAction implements IActionListener {

		@Override
		public void callback() {
			if (selectedMember != null) {
				RegisteredAnimal newAnimal = DairyUtil.createAnimal(null, null, "", Gender.MALE,
						DairyUtil.createReferenceAnimal("", ""), Purpose.get(0), RearingMode.get(0),
						DairyUtil.createReferenceAnimal("", ""), "", "", null, null, AcquisitionType.get(0), null);
				final AddLiveStockDialog aniamlDialog = new AddLiveStockDialog(AbstractDirectoryController.getShell());
				aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED, newAnimal);
				final List<Farm> farmList = new ArrayList<Farm>();
				farmList.addAll(selectedMember.getMember().getFarms());

				aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
						farmList);

				final int returnCode = aniamlDialog.open();
				if (returnCode == AbstractWindowController.OK) {
					newAnimal = (RegisteredAnimal) aniamlDialog.getController().getContext(
							ControllerContextConstant.DIALOG_CONTXT_SELECTED);
					newAnimal.getLocation().getAnimals().add(newAnimal);
					final Farm farmLocation = newAnimal.getLocation();
					if ((farmLocation != null) && (farmLocation.getFarmId() != null)) {
						farmRepository.save(newAnimal.getLocation());
					}
					refreshList();
				}
			}

		}

	}

	private class FilterAction implements IActionListener {

		@Override
		public void callback() {
			refreshList();
		}

	}

	private class ViewAction implements IActionListener {

		@Override
		public void callback() {
			if (!liveStockListTable.getSelection().isEmpty()) {
				final LiveStockListViewTableNode selectedNode = (LiveStockListViewTableNode) liveStockListTable
						.getSelection().get(0);
				final RegisteredAnimal selectedAnimal = selectedNode.getAnimal();
				final ViewLiveStockDialog aniamlDialog = new ViewLiveStockDialog(AbstractDirectoryController.getShell());
				aniamlDialog.getController().setContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED,
						selectedAnimal);
				final List<Farm> farmList = new ArrayList<Farm>();
				farmList.add(selectedAnimal.getLocation());
				aniamlDialog.getController().setContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST,
						farmList);

				final int returnCode = aniamlDialog.open();
				final Farm farmLocation = selectedAnimal.getLocation();

				if (returnCode == AbstractWindowController.OK) {
					if ((farmLocation != null) && (farmLocation.getFarmId() != null)) {
						farmRepository.update(farmLocation);
					}
					refreshList();
				} else if (returnCode == 2) {
					if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), liveStockRemoveTitle,
							liveStockRemoveMessage)) {
						farmLocation.getAnimals().remove(selectedAnimal);
						if (farmLocation.getFarmId() != null) {
							farmRepository.update(farmLocation);
						}
						refreshList();
					}
				}
			}

		}

	}

	public static final String ALL_FARM = "All Farms";
	public static final String liveStockRemoveMessage = "Do you want to remove selected animals?";

	public static final String liveStockRemoveTitle = "Remove Registered Animales";
	private final String[] columnHeaders = { "Member ID", "Member Name", "Farm Name", "Purpose", "LiveStock Name",
			"Species", "Breed", "Acquisition Date", "Status" };

	private final IFarmRepository farmRepository;
	private LiveStockFilterWidgetController filterController;
	private final List<LiveStockListViewTableNode> listTableInput = new ArrayList<LiveStockListViewTableNode>();
	private ITableRidget liveStockListTable;
	private IActionRidget memberLookupBtn;

	// filter group
	private ITextRidget memberNameFilter;

	private final String[] propertyNames = { "membership", "membership", "animal", "animal", "animal", "animal",
			"animal", "animal", "animal" };

	private Membership selectedMember;

	private IActionRidget viewRidget;
	private IActionRidget addRidget;

	public LiveStockListController() {
		farmRepository = new FarmRepository();

	}

	public void refreshList() {
		listTableInput.clear();
		listTableInput.addAll(getFilteredResult());
		liveStockListTable.updateFromModel();
	}

	private List<RegisteredAnimal> filterDate(List<RegisteredAnimal> inputRecrods, String startDate, String endDate) {
		final List<RegisteredAnimal> objs = new ArrayList<RegisteredAnimal>();
		if ((inputRecrods == null) || inputRecrods.isEmpty()) {
			return objs;
		}
		try {
			final NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
				@Override
				public Long adapt(Object value) {
					return longValue(value);
				}

				@Override
				public long longValue(Object object) {
					return ((Date) object).getTime();
				}
			};

			final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

			SELECT select = null;
			if (startDate != null) {
				// StartDate
				if (!"".equals(startDate)) {
					final Condition startDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
							startDate).getTime(), RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);

					final EObjectAttributeValueCondition startDateAttributeCondition = new EObjectAttributeValueCondition(
							TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION, startDateCondition);
					condtions.add(startDateAttributeCondition);
				}

			}
			// End Date
			if (endDate != null) {
				if (!"".equals(endDate)) {
					final Condition endDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
							endDate).getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);

					final EObjectAttributeValueCondition endDateAttributeCondition = new EObjectAttributeValueCondition(
							TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION, endDateCondition);
					condtions.add(endDateAttributeCondition);
				}
			}

			// AND all conditions
			if (condtions.size() > 0) {
				final EObjectCondition first = condtions.get(0);
				EObjectCondition ret = first;
				for (int i = 1; i < condtions.size(); i++) {
					ret = ret.AND(condtions.get(i));
				}
				for (final RegisteredAnimal record : inputRecrods) {
					select = new SELECT(new FROM(record), new WHERE(ret));
					final IQueryResult result = select.execute();
					if (!result.isEmpty()) {
						objs.add(record);
					}

				}

			} else {
				objs.addAll(inputRecrods);
			}

		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Activator.getDefault().logError(e, e.getMessage());
		}
		return objs;
	}

	private List<LiveStockListViewTableNode> getFilteredResult() {
		final List<LiveStockListViewTableNode> results = new ArrayList<LiveStockListViewTableNode>();
		List<RegisteredAnimal> selectedAnimals = new ArrayList<RegisteredAnimal>();
		final List<RegisteredAnimal> animals = new ArrayList<RegisteredAnimal>();
		final String farmName = filterController.getFarmCombo().getText();
		final String speciesName = filterController.getSpeciesCombo().getText();
		final String statusName = filterController.getStatusCombo().getText();
		final List<Farm> farms = new ArrayList<Farm>();
		if (selectedMember != null) {
			farms.addAll(selectedMember.getMember().getFarms());
			if (addRidget != null) {
				addRidget.setEnabled(farms.size() > 0);
			}
			for (final Farm farm : farms) {
				if (farmName.equals("All Farms") || farmName.equals(farm.getName())) {
					animals.addAll(farm.getAnimals());
				}
			}
		}
		else {
			addRidget.setEnabled(false);
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
		DateFilterUtil<RegisteredAnimal> filterUtil = new DateFilterUtil<RegisteredAnimal>(RegisteredAnimal.class,
				TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION);
		selectedAnimals = filterUtil.filterDate(animals, filterController.getDateSearchController().getStartDate(),
				filterController.getDateSearchController().getEndDate());

		for (final RegisteredAnimal animal : selectedAnimals) {
			results.add(new LiveStockListViewTableNode(selectedMember, animal));
		}
		return results;
	}

	private void setColumnFormatters() {
		// MEMBERID
		liveStockListTable.setColumnFormatter(0, new ColumnFormatter() {
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
		// memberName
		liveStockListTable.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof LiveStockListViewTableNode) {
					final Membership membership = ((LiveStockListViewTableNode) element).getMembership();
					if (membership != null) {
						final Person member = (membership).getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
				}
				return null;
			}
		});
		// farm name
		liveStockListTable.setColumnFormatter(2, new ColumnFormatter() {
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
		// purose
		liveStockListTable.setColumnFormatter(3, new ColumnFormatter() {
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
		liveStockListTable.setColumnFormatter(4, new ColumnFormatter() {
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
		// Species
		liveStockListTable.setColumnFormatter(5, new ColumnFormatter() {
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
		liveStockListTable.setColumnFormatter(6, new ColumnFormatter() {
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
		liveStockListTable.setColumnFormatter(7, new ColumnFormatter() {

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
		liveStockListTable.setColumnFormatter(8, new ColumnFormatter() {

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
		filterController.getSearch().addListener(new FilterAction());
		filterController.getClear().addListener(new IActionListener() {
			@Override
			public void callback() {
				memberNameFilter.setText("");
				listTableInput.clear();
				liveStockListTable.updateFromModel();
			}
		});

	}

	@Override
	protected void configureTableRidgets() {

		liveStockListTable = getRidget(ITableRidget.class, ViewWidgetId.LIVESTOCK_TABLE);
		if (liveStockListTable != null) {
			liveStockListTable.bindToModel(new WritableList(listTableInput, LiveStockListViewTableNode.class),
					LiveStockListViewTableNode.class, propertyNames, columnHeaders);
			setColumnFormatters();

			liveStockListTable.addSelectionListener(new ISelectionListener() {

				@Override
				public void ridgetSelected(SelectionEvent event) {
					if (event.getSource() == liveStockListTable) {
						viewRidget.setEnabled(liveStockListTable.getSelection().size() > 0);
					}
				}

			});
			liveStockListTable.updateFromModel();
			
			addRidget = getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_ADD);
			addRidget.addListener(new AddAction());
			viewRidget = getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_VIEW);
			if (viewRidget != null) {
				viewRidget.setEnabled(false);
				viewRidget.addListener(new ViewAction());
			}
		}
	}

}
