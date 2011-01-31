package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.List;

import org.eclipse.riena.ui.ridgets.IRidgetContainer;
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

	private Membership selectedMember;

	public MemberProfileWidgetController(IController controller, List<DairyLocation> routeList) {
		this.container = controller;
		this.routeList = routeList;
	}

	@Override
	public void configure() {
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
	}

	@Override
	public void updateBinding() {
		mapper.updateAllRidgetsFromModel();
	}
}
