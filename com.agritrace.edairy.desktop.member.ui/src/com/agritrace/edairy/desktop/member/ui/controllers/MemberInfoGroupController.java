package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.Date;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberInfoGroupController implements WidgetController, ISelectionListener {

	private IController controller;

	private Membership selectedMember;

	private ITextRidget appliedDate;
	private ITextRidget effectiveDate;
	private IComboRidget comboStatus;
	private ITextRidget phoneRidget;
	private IActionRidget appliedDateBtn;
	private IActionRidget effectiveDateBtn;
	

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

		appliedDateBtn = controller.getRidget(IActionRidget.class, ViewWidgetId.memberInfo_applicationDate_btn);
		appliedDateBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						appliedDate.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					appliedDate.setText(bean.getFormattedDate());
					if(selectedMember != null){
						selectedMember.setApplicationDate(selectedDate);
					}
				}


			}
		});
		effectiveDateBtn = controller.getRidget(IActionRidget.class, ViewWidgetId.memberInfo_effectiveDate_btn);
		effectiveDateBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						effectiveDate.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					effectiveDate.setText(bean.getFormattedDate());
					if(selectedMember != null){
						selectedMember.setEffectiveDate(selectedDate);
					}
				}
			}
		});
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
			phoneRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(), ModelPackage.Literals.PERSON__PHONE_NUMBER));
			phoneRidget.updateFromModel();
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
