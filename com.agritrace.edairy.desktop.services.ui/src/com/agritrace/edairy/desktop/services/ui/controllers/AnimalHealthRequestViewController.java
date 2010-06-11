package com.agritrace.edairy.desktop.services.ui.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.WritableValue;
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
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.FarmSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.LookupDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.services.ui.AnimalHealthRequestRepository;
import com.agritrace.edairy.desktop.services.ui.dialogs.AnimalHealthRequestDialog;
import com.agritrace.edairy.desktop.services.ui.views.AnimalHealthRequestView;

/**
 * Service Requests view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class AnimalHealthRequestViewController extends AbstractRecordListController<AnimalHealthRequest> {

	public static String[] MASTER_PROPTIES = { RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE.getName() };
	public static String[] MASTER_HEADERS = { "ID", "Date", "Member", "Farm", "Type" };

	private IActionRidget farmLookupButton;
	private IActionRidget memberLookupButton;
	private IDateTextRidget startDateText;
	private IDateTextRidget endDateText;
	private SimpleFormattedDateBean startBean;
	private SimpleFormattedDateBean endDateBean;
	private ITableRidget masterTable;
	private IToggleButtonRidget inseminationRidget;
	private IToggleButtonRidget vertRidget;
	private IToggleButtonRidget allRidget;
	private ITextRidget farmText;
	private ITextRidget memberText;

	private WritableValue selectedFarm = new WritableValue(null, Farm.class);
	private WritableValue selectedMember = new WritableValue(null, Membership.class);

	private final MemberLookupAction memberLookupAction = new MemberLookupAction();
	private final FarmLookupAction farmLookupAction = new FarmLookupAction();
	private final IAnimalHealthRequestRepository myDairy = new AnimalHealthRequestRepository();
	private final AnimalHealthRequestCondtionsBean condtionsBean = new AnimalHealthRequestCondtionsBean();
	
	private final class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog dialog = new MemberSearchDialog(new Shell());
			dialog.setSelectedFarm((Farm) selectedFarm.getValue());
			final int ret = dialog.open();
			if (Window.OK == ret) {
				selectedMember.setValue(dialog.getSelectedMember());
//				memberText.updateFromModel();
				memberText.setText(dialog.getSelectedMember().getMember().getFamilyName() +
						", " + dialog.getSelectedMember().getMember().getGivenName());
			}

		}
	}

	private final class FarmLookupAction implements IActionListener {
		@Override
		public void callback() {
			FarmSearchDialog farmDialog = new FarmSearchDialog(Display.getCurrent().getActiveShell());
			LookupDialogController<Farm> controller = ((LookupDialogController<Farm>) farmDialog.getController());
			controller.setSelectedObject(condtionsBean.getSelectedFarm());
			
			int retVal = farmDialog.open();
			if (retVal == FarmSearchDialog.OK) {
				condtionsBean.setSelectedFarm(controller.getSelectedObject());
				farmText.updateFromModel();
			}

		}
	}

	protected EClass getEClass() {
		return RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST;
	}

	@Override
	public void configureTableRidget() {
		masterTable = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
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
						final String name = ((AnimalHealthRequest) element).getRequestingMember().getMember()
								.getGivenName()
								+ " "
								+ ((AnimalHealthRequest) element).getRequestingMember().getMember().getFamilyName();
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
	protected String[] getTableColumnHeaders() {
		return MASTER_HEADERS;
	}

	@Override
	protected String[] getTableColumnPropertyNames() {
		return MASTER_PROPTIES;
	}

	@Override
	protected void resetFilterCondtions() {
		super.resetFilterCondtions();
		// for date range
		// Start Date Default value
		if (startDateText != null) {
			// startDateText.setDirectWriting(true);
			startDateText.setText(DateTimeUtils.DATE_FORMAT.format(DateTimeUtils.getFirstDayOfMonth(Calendar
					.getInstance().getTime())));
		}

		// End date default value
		if (endDateText != null) {
			// endDateText.setDirectWriting(true);
			endDateText.setText(DateTimeUtils.DATE_FORMAT.format(DateTimeUtils.getLastDayOfMonth(Calendar.getInstance()
					.getTime())));
		}

		// Request Type
		if (inseminationRidget != null) {
			inseminationRidget.setSelected(false);
			vertRidget.setSelected(false);
			allRidget.setSelected(true);
		}

		// Member Look
		if (memberText != null) {
			// memberText.setDirectWriting(true);
			// / memberText.setText("");
			selectedMember.setValue(null);
		}
		// Farm Look
		if (farmText != null) {
			// farmText.setDirectWriting(true);
			// farmText.setText("");
			selectedFarm.setValue(null);
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return AnimalHealthRequest.class;
	}

	@Override
	protected List getFilteredResult() {
		try {
			List<AnimalHealthRequest> requests = myDairy.allRequests();

			// shortcut if no requests to filter.
			if (requests.size() == 0)
				return requests;

			final List<AnimalHealthRequest> objs = new ArrayList<AnimalHealthRequest>();
			final NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
				@Override
				public long longValue(Object object) {
					return ((Date) object).getTime();
				}

				@Override
				public Long adapt(Object value) {
					return longValue(value);
				}
			};

			// Start Date
			final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

			SELECT select = null;
			if (startDateText != null) {
				// StartDate
				// memberIdText.updateFromModel();
				final String startDate = startDateText.getText();

				if (!"".equals(startDate)) {
					final Condition startDateCondtion = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
							startDate).getTime(), RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);

					final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE, startDateCondtion);
					condtions.add(startDateCondition);
				}

			}
			// End Date
			if (endDateText != null) {
				final String endDateStr = endDateText.getText();

				if (!"".equals(endDateStr)) {
					final Condition startDateCondtion = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
							endDateStr).getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);

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
							return object.equals(RequestType.VETERINARY);
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AnimalHealthRequest>();
	}

	@Override
	protected RecordDialog<AnimalHealthRequest, AnimalHealthRequestDialogController> getRecordDialog(Shell shell) {
		return new AnimalHealthRequestDialog(shell);
	}

	@Override
	protected void configureFilterRidgets() {
		// super.configureFilterRidgets();
		startBean = new SimpleFormattedDateBean();
		// By default, it is the first day of this month
		startBean.setDate(DateTimeUtils.getFirstDayOfMonth(Calendar.getInstance().getTime()));

		// Start date
		// LookupControllerDelegate delegate = new
		// LookupControllerDelegate(this,
		// PojoObservables.observeValue(startBean,
		// "date"), ServiceRequestView.START_DATE_TEXT,
		// ServiceRequestView.START_DATE_BUTTON);
		// delegate.configureRidgets();

		startDateText = getRidget(IDateTextRidget.class, AnimalHealthRequestView.START_DATE_TEXT);
		startDateText.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		startDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		startDateText.bindToModel(PojoObservables.observeValue(startBean, "date"));
		startDateText.updateFromModel();

		endDateBean = new SimpleFormattedDateBean();
		// By default, it is the first day of this month
		endDateBean.setDate(DateTimeUtils.getLastDayOfMonth(Calendar.getInstance().getTime()));

		// Start date
		// LookupControllerDelegate endDelegate = new
		// LookupControllerDelegate(this, PojoObservables.observeValue(
		// endDateBean, "date"), ServiceRequestView.END_DATE_TEXT,
		// ServiceRequestView.END_DATE_BUTTON);
		// endDelegate.configureRidgets();

		inseminationRidget = getRidget(IToggleButtonRidget.class, AnimalHealthRequestView.REQUEST_TYPE_INSEMINATION);
		vertRidget = getRidget(IToggleButtonRidget.class, AnimalHealthRequestView.REQUEST_TYPE_VERTERNARY);
		allRidget = getRidget(IToggleButtonRidget.class, AnimalHealthRequestView.REQUEST_TYPE_ALL);

		endDateText = getRidget(IDateTextRidget.class, AnimalHealthRequestView.END_DATE_TEXT);
		endDateText.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		endDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		endDateText.bindToModel(PojoObservables.observeValue(endDateBean, "date"));
		endDateText.updateFromModel();

		farmText = getRidget(ITextRidget.class, AnimalHealthRequestView.FARM_LOOKUP_TEXT);
		farmText.bindToModel(new WritableValue(this.condtionsBean,
				AnimalHealthRequestCondtionsBean.class));
		farmText.setModelToUIControlConverter(new IConverter(){

			@Override
			public Object getFromType() {
				return AnimalHealthRequestCondtionsBean.class;
			}

			@Override
			public Object getToType() {
				return String.class;
			}

			@Override
			public Object convert(Object fromObject) {
				if (fromObject instanceof AnimalHealthRequestCondtionsBean)
				{
					return ((AnimalHealthRequestCondtionsBean)fromObject).getSelectedFarm().getName();
				}
				return null;
			}});
		farmText.updateFromModel();
		//farmText.setOutputOnly(true);
		
		farmLookupButton = this.getRidget(IActionRidget.class, AnimalHealthRequestView.FARM_LOOKUP_BUTTON);
		farmLookupButton.addListener(farmLookupAction);

		memberText = getRidget(ITextRidget.class, AnimalHealthRequestView.MEMBER_LOOKUP_TEXT);
		memberText.bindToModel(selectedMember);
		memberText.setOutputOnly(true);
		
		memberLookupButton = this.getRidget(IActionRidget.class, AnimalHealthRequestView.MEMBER_LOOKUP_BUTTON);
		memberLookupButton.addListener(memberLookupAction);

	}

}
