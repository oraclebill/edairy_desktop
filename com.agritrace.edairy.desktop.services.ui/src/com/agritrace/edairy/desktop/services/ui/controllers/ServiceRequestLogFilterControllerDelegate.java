package com.agritrace.edairy.desktop.services.ui.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

import com.agritrace.edairy.desktop.common.ui.controllers.SubModuleControllerDelegate;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestFilterSection;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsPackage;
import com.agritrace.edairy.model.tracking.TrackingPackage;

/**
 * Filter section controller delegatesssss
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestLogFilterControllerDelegate extends SubModuleControllerDelegate {

    public ServiceRequestLogFilterControllerDelegate(SubModuleController controller) {
	super(controller);
    }

    @Override
    public void configureRidgets() {
	final IActionRidget apply = getRidget(IActionRidget.class, ServiceRequestFilterSection.BIND_ID_APPLY);

	if (apply != null) {
	    apply.addListener(new IActionListener() {

		@Override
		public void callback() {
		    filter();

		}
	    });
	}
	final IActionRidget reset = getRidget(IActionRidget.class, ServiceRequestFilterSection.BIND_ID_RESET);

	if (reset != null) {
	    reset.addListener(new IActionListener() {

		@Override
		public void callback() {
		    resetCondtions();

		}
	    });
	}
	resetCondtions();
	// filter();

    }

    private void filter() {
	try {
	    ((ServiceLogViewController) getSubModuleController()).setFilteredResult(getFilteredResult());
	    ((ServiceLogViewController) getSubModuleController())
		    .fireListeners(ServiceLogViewController.EVENT_TYPE_TABLE_INPUT_CHANGED);
	} catch (final ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void resetCondtions() {
	// for date range
	// Start Date Default value
	final ITextRidget startText = getRidget(ITextRidget.class, ServiceRequestFilterSection.STARTE_DATE);
	if (startText != null) {
	    startText.setDirectWriting(true);
	    startText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils.getFirstDayOfMonth(Calendar.getInstance()
		    .getTime())));
	}
	// End date default value
	final ITextRidget endDateText = getRidget(ITextRidget.class, ServiceRequestFilterSection.END_DATE);
	if (endDateText != null) {
	    endDateText.setDirectWriting(true);
	    endDateText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils.getLastDayOfMonth(Calendar.getInstance()
		    .getTime())));

	}
	// Request Type
	final IToggleButtonRidget inseminationRidget = getRidget(IToggleButtonRidget.class,
		ServiceRequestFilterSection.REQUEST_TYPE_INSEMINATION);
	if (inseminationRidget != null) {
	    inseminationRidget.setSelected(false);
	    final IToggleButtonRidget vertRidget = getRidget(IToggleButtonRidget.class,
		    ServiceRequestFilterSection.REQUEST_TYPE_VERTERNARY);
	    vertRidget.setSelected(false);
	    final IToggleButtonRidget allRidget = getRidget(IToggleButtonRidget.class,
		    ServiceRequestFilterSection.REQUEST_TYPE_ALL);
	    allRidget.setSelected(true);
	}

	// Member Look
	final ITextRidget memberText = getRidget(ITextRidget.class, ServiceRequestFilterSection.MEMBER_LOOKUP_TEXT);
	if (memberText != null) {
	    memberText.setDirectWriting(true);
	    memberText.setText("");
	}
	// Farm Look
	final ITextRidget farmText = getRidget(ITextRidget.class, ServiceRequestFilterSection.FARM_LOOKUP_TEXT);
	if (farmText != null) {
	    farmText.setDirectWriting(true);
	    farmText.setText("");
	}

    }

    private List<AnimalHealthRequest> getFilteredResult() throws ParseException {
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
	final ITextRidget memberIdText = getRidget(ITextRidget.class, ServiceRequestFilterSection.STARTE_DATE);
	final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

	SELECT select = null;
	if (memberIdText != null) {
	    // StartDate
	    // memberIdText.updateFromModel();
	    final String startDate = memberIdText.getText();

	    if (!"".equals(startDate)) {
		final Condition startDateCondtion = new NumberCondition<Long>(ServiceUtils.DATE_FORMAT.parse(startDate)
			.getTime(), RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);

		final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE, startDateCondtion);
		condtions.add(startDateCondition);
	    }

	}
	// End Date
	final ITextRidget endDateText = getRidget(ITextRidget.class, ServiceRequestFilterSection.END_DATE);
	if (endDateText != null) {
	    final String endDateStr = endDateText.getText();

	    if (!"".equals(endDateStr)) {
		final Condition startDateCondtion = new NumberCondition<Long>(ServiceUtils.DATE_FORMAT
			.parse(endDateStr).getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);

		final EObjectAttributeValueCondition endDateCondtion = new EObjectAttributeValueCondition(
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE, startDateCondtion);
		condtions.add(endDateCondtion);
	    }
	}

	// Request Type
	// Verterinary
	final IToggleButtonRidget veterinaryRidget = getRidget(IToggleButtonRidget.class,
		ServiceRequestFilterSection.REQUEST_TYPE_VERTERNARY);
	if (veterinaryRidget != null) {
	    final boolean isVerterinaryType = veterinaryRidget.isSelected();
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
	final IToggleButtonRidget inseminationRidget = getRidget(IToggleButtonRidget.class,
		ServiceRequestFilterSection.REQUEST_TYPE_INSEMINATION);
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
	final ITextRidget memberText = getRidget(ITextRidget.class, ServiceRequestFilterSection.MEMBER_LOOKUP_TEXT);
	if (memberText != null) {
	    // String memberName = memberText.getText();
	    // if (!"".equals(memberName)) {
	    // Condition name = new
	    // org.eclipse.emf.query.conditions.strings.StringValue(
	    // memberName);
	    // EObjectCondition partyName = new EObjectAttributeValueCondition(
	    // ModelPackage.Literals.PARTY__NAME, name);
	    // EObjectCondition memberRef = new EObjectReferenceValueCondition(
	    // DairyPackage.Literals.MEMBERSHIP__MEMBER, partyName);
	    // EObjectCondition requestingMember = new
	    // EObjectReferenceValueCondition(
	    // RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER,
	    // memberRef);
	    //
	    // condtions.add(requestingMember);
	    // }
	}

	// Member name field
	final ITextRidget farmText = getRidget(ITextRidget.class, ServiceRequestFilterSection.FARM_LOOKUP_TEXT);
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
	    select = new SELECT(new FROM(((ServiceLogViewController) this.getSubModuleController()).getAllRequests()),
		    new WHERE(ret));

	} else {
	    select = new SELECT(new FROM(((ServiceLogViewController) this.getSubModuleController()).getAllRequests()),
		    new WHERE(EObjectCondition.E_TRUE));
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
    public void fireListener(int eventType) {

    }

}
