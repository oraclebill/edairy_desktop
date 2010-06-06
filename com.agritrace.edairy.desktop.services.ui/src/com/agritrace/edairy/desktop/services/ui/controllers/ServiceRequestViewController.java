package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.controllers.LookupControllerDelegate;
import com.agritrace.edairy.desktop.common.ui.dialogs.FarmSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.services.ui.AnimalHealthRequestRepository;
import com.agritrace.edairy.desktop.services.ui.dialogs.ServiceRequestListDialog;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestView;

/**
 * Service Requests view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestViewController extends AbstractRecordListController<AnimalHealthRequest> {

	private AnimalHealthRequestRepository reqRepo;

	protected EClass getEClass() {
		return RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST;
	}
	
	public static String[] MASTER_PROPTIES = {
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID
					.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER
					.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE.getName() };
	public static String[] MASTER_HEADERS = { "ID", "Date", "Member", "Farm",
			"Type" };

	@Override
	public void configureTableRidget() {
		ITableRidget masterTable = this.getRidget(ITableRidget.class,
				AbstractRecordListView.BIND_ID_TABLE);
		// Configure column formatter
		if (masterTable != null) {

			// Date column
			masterTable.setColumnFormatter(1, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof AnimalHealthRequest) {
						return DateTimeUtils.DATE_FORMAT
								.format(((AnimalHealthRequest) element)
										.getDate());
					}
					return null;
				}

			});
			// Member column
			masterTable.setColumnFormatter(2, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof AnimalHealthRequest) {
						final String name = ((AnimalHealthRequest) element)
								.getRequestingMember().getMember()
								.getGivenName()
								+ " "
								+ ((AnimalHealthRequest) element)
										.getRequestingMember().getMember()
										.getFamilyName();
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
						final String name = ((AnimalHealthRequest) element)
								.getFarm().getName();
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
						final String name = ((AnimalHealthRequest) element)
								.getType().toString();
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
		final ITextRidget startText = getRidget(ITextRidget.class,
				ServiceRequestView.START_DATE_TEXT);
		if (startText != null) {
			startText.setDirectWriting(true);
			startText.setText(DateTimeUtils.DATE_FORMAT.format(DateTimeUtils
					.getFirstDayOfMonth(Calendar.getInstance().getTime())));
		}
		// End date default value
		final ITextRidget endDateText = getRidget(ITextRidget.class,
				ServiceRequestView.END_DATE_TEXT);
		if (endDateText != null) {
			endDateText.setDirectWriting(true);
			endDateText.setText(DateTimeUtils.DATE_FORMAT.format(DateTimeUtils
					.getLastDayOfMonth(Calendar.getInstance().getTime())));

		}
		// Request Type
		final IToggleButtonRidget inseminationRidget = getRidget(
				IToggleButtonRidget.class,
				ServiceRequestView.REQUEST_TYPE_INSEMINATION);
		if (inseminationRidget != null) {
			inseminationRidget.setSelected(false);
			final IToggleButtonRidget vertRidget = getRidget(
					IToggleButtonRidget.class,
					ServiceRequestView.REQUEST_TYPE_VERTERNARY);
			vertRidget.setSelected(false);
			final IToggleButtonRidget allRidget = getRidget(
					IToggleButtonRidget.class,
					ServiceRequestView.REQUEST_TYPE_ALL);
			allRidget.setSelected(true);
		}

		// Member Look
		final ITextRidget memberText = getRidget(ITextRidget.class,
				ServiceRequestView.MEMBER_LOOKUP_TEXT);
		if (memberText != null) {
			memberText.setDirectWriting(true);
			memberText.setText("");
		}
		// Farm Look
		final ITextRidget farmText = getRidget(ITextRidget.class,
				ServiceRequestView.FARM_LOOKUP_TEXT);
		if (farmText != null) {
			farmText.setDirectWriting(true);
			farmText.setText("");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return AnimalHealthRequest.class;
	}

	@Override
	protected List getFilteredResult() {

		try {
			org.hibernate.Session session = PersistenceManager.getDefault()
					.getSession();
			Criteria criteria = session.createCriteria(this.getEntityClass());

			// Start Date
			final ITextRidget memberIdText = getRidget(ITextRidget.class,
					ServiceRequestView.START_DATE_TEXT);

			if (memberIdText != null && !"".equals(memberIdText.getText())) {
				// StartDate
				criteria.add(Restrictions.ge(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE
								.getName(), DateTimeUtils.DATE_FORMAT
								.parse(memberIdText.getText())));
			}
			// End Date
			final ITextRidget endDateText = getRidget(ITextRidget.class,
					ServiceRequestView.END_DATE_TEXT);
			if (endDateText != null && !"".equals(endDateText.getText())) {
				final String endDateStr = endDateText.getText();
				criteria.add(Restrictions.lt(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE
								.getName(), DateTimeUtils.getNextDate(DateTimeUtils.DATE_FORMAT.parse(endDateStr))));
			}

			// Request Type
			// Verterinary
			final IToggleButtonRidget veterinaryRidget = getRidget(
					IToggleButtonRidget.class,
					ServiceRequestView.REQUEST_TYPE_VERTERNARY);
			if (veterinaryRidget != null) {
				final boolean isVerterinaryType = veterinaryRidget.isSelected();
				if (isVerterinaryType) {
					criteria.add(Restrictions
							.eq(RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE
									.getName(), RequestType.VETERINARY));
				}
			}
			// Insemination conditions
			final IToggleButtonRidget inseminationRidget = getRidget(
					IToggleButtonRidget.class,
					ServiceRequestView.REQUEST_TYPE_INSEMINATION);
			if (inseminationRidget != null) {
				final boolean isInsemination = inseminationRidget.isSelected();
				if (isInsemination) {
					criteria.add(Restrictions
							.eq(RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE
									.getName(), RequestType.INSEMINATION));
				}
			}

			// Member name field
			final ITextRidget memberText = getRidget(ITextRidget.class,
					ServiceRequestView.MEMBER_LOOKUP_TEXT);
			if (memberText != null && memberText.getText() != null) {
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
				//
				// criteria.add(Restrictions
				// .eq(DairyPackage.Literals.MEMBERSHIP__MEMBER
				// .getName(), RequestType.INSEMINATION));

			}

			// Member name field
			final ITextRidget farmText = getRidget(ITextRidget.class,
					ServiceRequestView.FARM_LOOKUP_TEXT);
			if (farmText != null) {
				final String farmName = farmText.getText();
				if (!"".equals(farmName)) {
					// final Condition name = new
					// org.eclipse.emf.query.conditions.strings.StringValue(
					// farmName);
					// final EObjectCondition farmNameCond = new
					// EObjectAttributeValueCondition(
					// TrackingPackage.Literals.FARM__NAME, name);
					// final EObjectCondition farmCond = new
					// EObjectReferenceValueCondition(
					// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM,
					// farmNameCond);
					//
					// condtions.add(farmCond);
				}
			}

			return criteria.list();
		} catch (Exception e) {

		}
		return new ArrayList<AnimalHealthRequest>();

	}

	@Override
	protected RecordDialog getEditDialog(int dialogStyle, AnimalHealthRequest selectedObject) {
		return new ServiceRequestListDialog(dialogStyle, new Shell(),
				selectedObject, this.getRepository());
	}

	@Override
	protected void configureFilterRidgets() {
		super.configureFilterRidgets();
		SimpleFormattedDateBean startBean = new SimpleFormattedDateBean();
		// By default, it is the first day of this month
		startBean.setDate(DateTimeUtils.getFirstDayOfMonth(Calendar
				.getInstance().getTime()));
		// Start date
		LookupControllerDelegate delegate = new LookupControllerDelegate(this,
				PojoObservables.observeValue(startBean, "date"),
				ServiceRequestView.START_DATE_TEXT,
				ServiceRequestView.START_DATE_BUTTON);
		delegate.configureRidgets();
		// End date
		SimpleFormattedDateBean endDateBean = new SimpleFormattedDateBean();
		// By default, it is the first day of this month
		endDateBean.setDate(DateTimeUtils.getLastDayOfMonth(Calendar
				.getInstance().getTime()));
		// Start date
		LookupControllerDelegate endDelegate = new LookupControllerDelegate(
				this, PojoObservables.observeValue(endDateBean, "date"),
				ServiceRequestView.END_DATE_TEXT,
				ServiceRequestView.END_DATE_BUTTON);
		endDelegate.configureRidgets();

		// Farm lookup
		IActionRidget farmLookupButton = this.getRidget(IActionRidget.class,
				ServiceRequestView.FARM_LOOKUP_BUTTON);
		farmLookupButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final FarmSearchDialog dialog = new FarmSearchDialog(
						new Shell());
				final int ret = dialog.open();
				if (Window.OK == ret) {
					// Demo code
					// farmText.setText("Farm1");

				}

			}
		});
		
		// Farm lookup
		IActionRidget memberLookupButton = this.getRidget(IActionRidget.class,
				ServiceRequestView.MEMBER_LOOKUP_BUTTON);
		memberLookupButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final MemberSearchDialog dialog = new MemberSearchDialog(
						new Shell());
				final int ret = dialog.open();
				if (Window.OK == ret) {
					// Demo code
					// farmText.setText("Farm1");

				}

			}
		});

	}
	
	/**
	 * Create new model while createing a new record
	 * 
	 * @return
	 */
	protected AnimalHealthRequest createNewModle() {
		AnimalHealthRequest request = (AnimalHealthRequest) EMFUtil.createWorkingCopy(
				this.getEClass(), 3);
		request.setReportedProblem("");
		return request;
	}

	public AnimalHealthRequestRepository getRepository() {
		if (reqRepo == null) {
			reqRepo = new AnimalHealthRequestRepository();
		}
		return reqRepo;
	}
}
