package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.booleans.BooleanAdapter;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberAdapter;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition.RelationalOperator;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.FarmSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.services.ui.dialogs.AnimalHealthRequestDialog;
import com.agritrace.edairy.desktop.services.ui.views.AnimalHealthRequestView;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Service Requests view controller
 *
 * @author Hui(Spark) Wan
 *
 */
@PermissionRequired(UIPermission.VIEW_ANIMAL_HEALTH_REQUESTS)
public class AnimalHealthRequestViewController extends AbstractDirectoryController<AnimalHealthRequest> {

	private final class FarmLookupAction implements IActionListener {
		@Override
		public void callback() {
			final FarmSearchDialog farmDialog = farmSearchDialogProvider.get();
			farmDialog.setSelectedMember(condtionsBean.getSelectedMember());

			final int retVal = farmDialog.open();
			if (retVal == Window.OK) {
				condtionsBean.setSelectedFarm(farmDialog.getSelectedFarm());
				farmText.updateFromModel();
			}

		}
	}

	private final class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberLookupDialog dialog = memberSearchDialogProvider.get();
			dialog.setSelectedMember(condtionsBean.getSelectedMember());
			dialog.setSelectedFarm(condtionsBean.getSelectedFarm());
			final int ret = dialog.open();
			if (Window.OK == ret) {
				condtionsBean.setSelectedMember(dialog.getSelectedMember());
				memberText.updateFromModel();
			}

		}
	}

	private static String[] MASTER_HEADERS = { "Log No.", "Date", "Member", "Farm", "Type" };
	private static String[] MASTER_PROPTIES = { RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE.getName() };
	
	private IToggleButtonRidget allRidget;
	private final AnimalHealthRequestCondtionsBean condtionsBean = new AnimalHealthRequestCondtionsBean();
	private IDateTimeRidget endDateText;
	private final FarmLookupAction farmLookupAction = new FarmLookupAction();
	private IActionRidget farmLookupButton;
	private ITextRidget farmText;
	private IToggleButtonRidget inseminationRidget;
	private ITableRidget masterTable;

	private final MemberLookupAction memberLookupAction = new MemberLookupAction();
	private IActionRidget memberLookupButton;
	private ITextRidget memberText;
//	private IRepository<AnimalHealthRequest> myRepo;

	private IDateTimeRidget startDateText;
	private IToggleButtonRidget vertRidget;

	private final Provider<FarmSearchDialog> farmSearchDialogProvider;
	private final Provider<MemberLookupDialog> memberSearchDialogProvider;
	private final Provider<AnimalHealthRequestDialog> dialogProvider;
	private IDairyRepository dairyRepo;

	@Inject
	public AnimalHealthRequestViewController(final IRepository<AnimalHealthRequest> myRepo,
			final IDairyRepository dairyRepo,
			final Provider<FarmSearchDialog> farmSearchDialogProvider,
			final Provider<MemberLookupDialog> memberSearchDialogProvider,
			final Provider<AnimalHealthRequestDialog> dialogProvider) {
		setRepository(myRepo);
		this.dairyRepo = dairyRepo;
		this.farmSearchDialogProvider = farmSearchDialogProvider;
		this.memberSearchDialogProvider = memberSearchDialogProvider;
		this.dialogProvider = dialogProvider;
	}

	@Override
	public void configureTableRidget() {
		masterTable = this.getRidget(ITableRidget.class, AbstractDirectoryView.BIND_ID_TABLE);
		// Configure column formatter
		if (masterTable != null) {
			// Date column
			masterTable.setColumnFormatter(1, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					if (element instanceof AnimalHealthRequest) {
						return DateTimeUtils.DATE_FORMAT.format(((AnimalHealthRequest) element).getDate());
					}
					return null;
				}
			});
			// Member column
			masterTable.setColumnFormatter(2, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof AnimalHealthRequest) {
						final String name = ((AnimalHealthRequest) element).getRequestingMember().getFarmer()
								.getGivenName()
								+ " "
								+ ((AnimalHealthRequest) element).getRequestingMember().getFarmer().getFamilyName();
						return name == null ? "" : name;
					}
					return null;
				}

			});
			// Farm column
			masterTable.setColumnFormatter(3, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof AnimalHealthRequest) {
						final String name = ((AnimalHealthRequest) element).getFarm().getName();
						return name == null ? "" : name;
					}
					return null;
				}

			});

			// Type column
			masterTable.setColumnFormatter(4, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof AnimalHealthRequest) {
						final String name = ((AnimalHealthRequest) element).getType().toString();
						return name == null ? "" : name;
					}
					return null;
				}

			});

		}
		super.configureTableRidget();

	}

	@Override
	protected void configureFilterRidgets() {

		this.condtionsBean.setStartDate(DateTimeUtils.getFirstDayOfMonth(Calendar.getInstance().getTime()));

		startDateText = getRidget(IDateTimeRidget.class, AnimalHealthRequestView.START_DATE_TEXT);
		// startDateText.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		// startDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		startDateText.bindToModel(PojoObservables.observeValue(condtionsBean,
				AnimalHealthRequestCondtionsBean.PROPERTY_STARTDATE));
		startDateText.updateFromModel();

		// By default, it is the first day of this month
		this.condtionsBean.setEndDate(DateTimeUtils.getLastDayOfMonth(Calendar.getInstance().getTime()));

		inseminationRidget = getRidget(IToggleButtonRidget.class, AnimalHealthRequestView.REQUEST_TYPE_INSEMINATION);
		vertRidget = getRidget(IToggleButtonRidget.class, AnimalHealthRequestView.REQUEST_TYPE_VERTERNARY);
		allRidget = getRidget(IToggleButtonRidget.class, AnimalHealthRequestView.REQUEST_TYPE_ALL);
		allRidget.setSelected(true);

		endDateText = getRidget(IDateTimeRidget.class, AnimalHealthRequestView.END_DATE_TEXT);
		// endDateText.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		// endDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		endDateText.bindToModel(PojoObservables.observeValue(condtionsBean,
				AnimalHealthRequestCondtionsBean.PROPERTY_ENDDATE));
		endDateText.updateFromModel();

		farmText = getRidget(ITextRidget.class, AnimalHealthRequestView.FARM_LOOKUP_TEXT);
		farmText.setModelToUIControlConverter(new Farm2StringConverter());
		farmText.bindToModel(condtionsBean, AnimalHealthRequestCondtionsBean.PROPERTY_FARM);
		farmText.updateFromModel();
		farmText.setOutputOnly(true);

		farmLookupButton = this.getRidget(IActionRidget.class, AnimalHealthRequestView.FARM_LOOKUP_BUTTON);
		farmLookupButton.addListener(farmLookupAction);

		memberText = getRidget(ITextRidget.class, AnimalHealthRequestView.MEMBER_LOOKUP_TEXT);
		memberText.setModelToUIControlConverter(new Member2StringConverter());
		memberText.bindToModel(condtionsBean, AnimalHealthRequestCondtionsBean.PROPERTY_MEMBERSHIP);
		memberText.updateFromModel();
		memberText.setOutputOnly(true);

		memberLookupButton = this.getRidget(IActionRidget.class, AnimalHealthRequestView.MEMBER_LOOKUP_BUTTON);
		memberLookupButton.addListener(memberLookupAction);

	}

	@Override
	protected AnimalHealthRequest createNewModel() {
		final AnimalHealthRequest request = super.createNewModel();
		request.setDate(Calendar.getInstance().getTime());
		request.setDairy(dairyRepo.getLocalDairy());

		return request;
	}

	@Override
	protected EClass getEClass() {
		return RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST;
	}

	@Override
	protected List<AnimalHealthRequest> getFilteredResult() {
		final List<AnimalHealthRequest> requests = getRepository().all();

		// shortcut if no requests to filter.
		if (requests.size() == 0) {
			return requests;
		}

		final List<AnimalHealthRequest> objs = new ArrayList<AnimalHealthRequest>();
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

		// Start Date
		final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

		SELECT select = null;
		if (startDateText != null) {
			// StartDate
			// memberIdText.updateFromModel();
			if (null != startDateText.getDate()) {
				final Condition startDateCondtion = new NumberCondition<Long>(startDateText.getDate().getTime(),
						RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);

				final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE, startDateCondtion);
				condtions.add(startDateCondition);
			}

		}
		// End Date
		if (endDateText != null) {
			if (null != endDateText.getDate()) {
				final Condition startDateCondtion = new NumberCondition<Long>(
						endDateText.getDate().getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO,
						dateAdapter);

				final EObjectAttributeValueCondition endDateCondtion = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE, startDateCondtion);
				condtions.add(endDateCondtion);
			}
		}

		// Request Type
		// Verterinary
		if (vertRidget != null) {
			final boolean isVerterinaryType = vertRidget.isSelected();
			if (isVerterinaryType) {
				final BooleanAdapter booleanAdapter = new BooleanAdapter() {

					@Override
					public Boolean getBoolean(Object object) {
						return object.equals(RequestType.CLINICAL);
					}

				};
				final Condition verterinaryCondition = new BooleanCondition(isVerterinaryType, booleanAdapter);

				final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE, verterinaryCondition);
				condtions.add(startDateCondition);
			}
		}
		// Insemination conditions
		if (inseminationRidget != null) {
			final boolean isInsemination = inseminationRidget.isSelected();
			if (isInsemination) {
				final BooleanAdapter booleanAdapter = new BooleanAdapter() {

					@Override
					public Boolean getBoolean(Object object) {
						return object.equals(RequestType.INSEMINATION);
					}

				};
				final Condition verterinaryCondition = new BooleanCondition(isInsemination, booleanAdapter);

				final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE, verterinaryCondition);
				condtions.add(startDateCondition);
			}
		}

		// Member name field
		if (memberText != null) {
			// String memberName = memberText.getText();
			// if (!"".equals(memberName)) {
			// Condition name = new
			// org.eclipse.emf.query.conditions.strings.StringValue(
			// memberName);
			// EObjectCondition partyName = new
			// EObjectAttributeValueCondition(
			// ModelPackage.Literals.PARTY__NAME, name);
			// EObjectCondition memberRef = new
			// EObjectReferenceValueCondition(
			// DairyPackage.Literals.MEMBERSHIP__MEMBER, partyName);
			// EObjectCondition requestingMember = new
			// EObjectReferenceValueCondition(
			// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER,
			// memberRef);
			//
			// condtions.add(requestingMember);
			// }
		}

		// Farm name field
		if (farmText != null) {
			final String farmName = farmText.getText();
			if (!"".equals(farmName)) {
				final Condition name = new org.eclipse.emf.query.conditions.strings.StringValue(farmName);
				final EObjectCondition farmNameCond = new EObjectAttributeValueCondition(
						TrackingPackage.Literals.FARM__NAME, name);
				final EObjectCondition farmCond = new EObjectReferenceValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM, farmNameCond);

				condtions.add(farmCond);
			}
		}

		// AND all conditions
		if (condtions.size() > 0) {
			final EObjectCondition first = condtions.get(0);
			EObjectCondition ret = first;
			for (int i = 1; i < condtions.size(); i++) {
				ret = ret.AND(condtions.get(i));
			}
			select = new SELECT(new FROM(requests), new WHERE(ret));

		} else {
			select = new SELECT(new FROM(requests), new WHERE(EObjectCondition.E_TRUE));
		}
		final IQueryResult result = select.execute();
		for (final EObject object : result.getEObjects()) {
			objs.add((AnimalHealthRequest) object);
		}
		Collections.sort(objs, new Comparator<Object>() {

			@Override
			public int compare(Object arg0, Object arg1) {
				if (arg0 instanceof AnimalHealthRequest && arg1 instanceof AnimalHealthRequest) {
					return (int) (((AnimalHealthRequest) arg0).getRequestId().longValue() - ((AnimalHealthRequest) arg1)
							.getRequestId().longValue());
				}
				return 0;
			}
		});

		return objs;
	}

	@Override
	protected RecordDialog<AnimalHealthRequest> getRecordDialog(Shell shell) {
		return dialogProvider.get();
	}

	@Override
	protected String[] getTableColumnHeaders() {
		return MASTER_HEADERS;
	}

	@Override
	protected String[] getTableColumnPropertyNames() {
		return MASTER_PROPTIES;
	}

	@Override
	protected void resetFilterConditions() {
		// for date range
		// Start Date Default value
		if (startDateText != null) {
			// startDateText.setDirectWriting(true);
			startDateText.setDate(DateTimeUtils.getFirstDayOfMonth(Calendar.getInstance().getTime()));
		}

		// End date default value
		if (endDateText != null) {
			// endDateText.setDirectWriting(true);
			endDateText.setDate(DateTimeUtils.getLastDayOfMonth(Calendar.getInstance().getTime()));
		}

		// Request Type
		if (inseminationRidget != null) {
			inseminationRidget.setSelected(false);
			vertRidget.setSelected(false);
			allRidget.setSelected(true);
		}

		// Member Look
		if (memberText != null) {
			this.condtionsBean.setSelectedMember(null);
			farmText.updateFromModel();
		}
		// Farm Look
		if (farmText != null) {
			this.condtionsBean.setSelectedFarm(null);
			farmText.updateFromModel();
		}
	}

}
