package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.Date;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.validators.PhoneNumberValidatiionRule;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberInfoGroupController implements WidgetController<Object> {

	private IDateTimeRidget appliedDate;


	private IComboRidget comboStatus;
	private IRidgetContainer container;
	private IDateTimeRidget effectiveDate;
	private ITextRidget phoneRidget;
	private Membership selectedMember;

	public MemberInfoGroupController(IController controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		appliedDate = container.getRidget(IDateTimeRidget.class, ViewWidgetId.memberInfo_applicationDate);
		effectiveDate = container.getRidget(IDateTimeRidget.class, ViewWidgetId.memberInfo_effectiveDate);
		comboStatus = container.getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
		phoneRidget = container.getRidget(ITextRidget.class, ViewWidgetId.memberInfo_phone);


		appliedDate.setMandatory(true);
		appliedDate.setOutputOnly(true);
		effectiveDate.setMandatory(true);
		effectiveDate.setOutputOnly(true);
		phoneRidget.setMandatory(true);
//		phoneRidget.set
		phoneRidget.addValidationRule(new PhoneNumberValidatiionRule(), ValidationTime.ON_UI_CONTROL_EDIT);
		phoneRidget.setDirectWriting(true);

	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Object getInputModel() {
		return selectedMember;
	}


	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;

	}

	@Override
	public void setInputModel(Object model) {
		this.selectedMember = (Membership) model;
		if (appliedDate != null) {
			updateBinding();
		}
	}

	@Override
	public void updateBinding() {
		if (selectedMember == null) {
			phoneRidget.setText("");
			appliedDate.setDate(new Date());
			effectiveDate.setDate(new Date());
			return;
		}

		appliedDate.bindToModel(selectedMember, "applicationDate");
		effectiveDate.bindToModel(selectedMember, "effectiveDate");
		phoneRidget.bindToModel(selectedMember, "member.phoneNumber");
		comboStatus.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class,
				null, BeansObservables.observeValue(selectedMember, "status"));


		comboStatus.updateFromModel();
		appliedDate.updateFromModel();
		effectiveDate.updateFromModel();
		phoneRidget.updateFromModel();
		comboStatus.updateFromModel();

//		comboStatus.setSelection(selectedMember.getStatus().getValue());
	}
}