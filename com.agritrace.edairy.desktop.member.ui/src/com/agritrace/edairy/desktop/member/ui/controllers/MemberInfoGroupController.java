package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberInfoGroupController implements WidgetController, ISelectionListener {

	private IController controller;

	private Membership selectedMember;

	private ITextRidget appliedDate;
	private ITextRidget effectiveDate;
	private IComboRidget comboStatus;
	private ITextRidget phoneRidget;

	public MemberInfoGroupController(IController controller) {
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		appliedDate = controller.getRidget(ITextRidget.class, ViewWidgetId.memberInfo_applicationDate);
		effectiveDate = controller.getRidget(ITextRidget.class, ViewWidgetId.memberInfo_effectiveDate);
		comboStatus = controller.getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
		phoneRidget = controller.getRidget(ITextRidget.class, ViewWidgetId.memberInfo_phone);

		comboStatus.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class,
				null, new WritableValue());
		comboStatus.updateFromModel();
		comboStatus.addSelectionListener(this);
	}

	@Override
	public Object getInputModel() {
		return selectedMember;
	}

	@Override
	public void setInputModel(Object model) {
		this.selectedMember = (Membership) model;
		if (appliedDate != null) {
			updateBinding();
		}
	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;

	}

	@Override
	public void updateBinding() {
		if (selectedMember == null) {
			phoneRidget.setText("");
			appliedDate.setText("");
			effectiveDate.setText("");
			return;
		}
		if (selectedMember.getMember() != null) {
			phoneRidget.setText(selectedMember.getMember().getPhoneNumber());
		} else {
			phoneRidget.setText("");
		}
		comboStatus.setSelection(selectedMember.getStatus().getValue());

		final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		if (selectedMember.getApplicationDate() != null) {
			bean.setDate(selectedMember.getApplicationDate());
		}
		appliedDate.setText(bean.getFormattedDate());

		if (selectedMember.getEffectiveDate() != null) {
			bean.setDate(selectedMember.getEffectiveDate());
		} else {
			bean.setFormattedDate("");
		}
		effectiveDate.setText(bean.getFormattedDate());

	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == comboStatus) {
			if (selectedMember != null) {
				selectedMember.setStatus((MembershipStatus) event.getNewSelection().get(0));
			}
		}
	}
}
