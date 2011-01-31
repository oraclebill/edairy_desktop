package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberProfileWidgetController implements WidgetController<Membership> {
	private IRidgetContainer container;
	private BindingHelper<Membership> mapper;
	private List<DairyLocation> routeList;

	private IDateTimeRidget appliedDate;
	private IComboRidget statusCombo;
	private IComboRidget defaultRouteCombo;
	private IDateTimeRidget effectiveDate;
	private ITextRidget phoneRidget;
	private Membership selectedMember;

	public MemberProfileWidgetController(IController controller, List<DairyLocation> routeList) {
		this.container = controller;
		this.routeList = routeList;
	}

	@Override
	public void configure() {
// appliedDate = container.getRidget(IDateTimeRidget.class, ViewWidgetId.memberInfo_applicationDate);
// effectiveDate = container.getRidget(IDateTimeRidget.class, ViewWidgetId.memberInfo_effectiveDate);
// phoneRidget = container.getRidget(ITextRidget.class, ViewWidgetId.memberInfo_phone);
//
// statusCombo = container.getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
// defaultRouteCombo = container.getRidget(IComboRidget.class, ViewWidgetId.memberInfo_defaultRoute);
//
// appliedDate.setMandatory(true);
// appliedDate.setOutputOnly(true);
//
// effectiveDate.setMandatory(true);
// effectiveDate.setOutputOnly(true);
//
// phoneRidget.setMandatory(true);
// // phoneRidget.addValidationRule(new PhoneNumberValidatiionRule(), ValidationTime.ON_UI_CONTROL_EDIT);
// phoneRidget.setDirectWriting(true);
	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Membership getInputModel() {
		return selectedMember;
	}

	@Override
	public void setInputModel(Membership model) {
		selectedMember = model;
		mapper = new BindingHelper<Membership>(container, model);

		mapper.addMapping(ViewWidgetId.memberInfo_applicationDate, DairyPackage.Literals.MEMBERSHIP__APPLICATION_DATE);
		mapper.addMapping(ViewWidgetId.memberInfo_effectiveDate, DairyPackage.Literals.MEMBERSHIP__EFFECTIVE_DATE);
		mapper.addMapping(ViewWidgetId.memberInfo_phone, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__PHONE_NUMBER);
		mapper.addMapping(ViewWidgetId.memberInfo_nationalId, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NATIONAL_ID);
		mapper.addMapping(ViewWidgetId.memberInfo_nssfId, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NSSF_NUMBER);
		mapper.addMapping(ViewWidgetId.memberInfo_nhifId, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NHIF_NUMBER);
		mapper.addMapping(ViewWidgetId.ID_MAZIWA_CARD_NUM, DairyPackage.Literals.MEMBERSHIP__MAZIWA_CARD_NUMBER);
		mapper.addMapping(ViewWidgetId.ID_MAZIWA_CARD_DATE, DairyPackage.Literals.MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE);

		mapper.addComboMapping(ViewWidgetId.memberInfo_status, MembershipStatus.VALUES, "toString",
				DairyPackage.Literals.MEMBERSHIP__STATUS);
		mapper.addComboMapping(ViewWidgetId.memberInfo_defaultRoute, routeList, "getCode",
				DairyPackage.Literals.MEMBERSHIP__DEFAULT_ROUTE);

		mapper.configureRidgets();
		mapper.updateAllRidgetsFromModel();

// if (appliedDate != null) {
// updateBinding();
// }
	}

	@Override
	public void updateBinding() {

		mapper.updateAllRidgetsFromModel();

// if (selectedMember == null) {
// phoneRidget.setText("");
// appliedDate.setDate(new Date());
// effectiveDate.setDate(new Date());
// return;
// }
//
// appliedDate.bindToModel(selectedMember, "applicationDate");
// effectiveDate.bindToModel(selectedMember, "effectiveDate");
// phoneRidget.bindToModel(selectedMember, "member.phoneNumber");
// statusCombo.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class,
// null, BeansObservables.observeValue(selectedMember, "status"));
// defaultRouteCombo.bindToModel(Observables.staticObservableList(routeList), DairyLocation.class,
// "getCode", BeansObservables.observeValue(selectedMember, "defaultRoute"));
//
// appliedDate.updateFromModel();
// effectiveDate.updateFromModel();
// phoneRidget.updateFromModel();
//
// statusCombo.updateFromModel();
// defaultRouteCombo.updateFromModel();
//
// // statusCombo.setSelection(selectedMember.getStatus().getValue());
// // statusCombo.setSelection(selectedMember.getStatus().getValue());
	}
}
