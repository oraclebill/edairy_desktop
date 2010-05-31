package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.List;

import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class CommunicationGroupController implements WidgetController {
	
	private IController controller;
	private Person person;
	private List<ContactMethod> contactMethods;
	
	private ITextRidget emailTxt;
	private ITextRidget phoneTxt;
	private ITextRidget secondPhoneTxt;
	
	public CommunicationGroupController(IController controller){
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		if(controller == null){
			return;
		}
		emailTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.EMAIL_TEXT);
		phoneTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.PHONE_TEXT);
		secondPhoneTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.SECOND_PHONE_TEXT);

	}

	@Override
	public Object getInputModel() {
		return person;
	}

	@Override
	public void setInputModel(Object model) {
		if(model instanceof Person){
			person = (Person)model;
			contactMethods = person.getContactMethods();
		}else if(model instanceof List<?>){
			contactMethods = (List) model;
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
	
//		List<ContactMethod> contacts = person.getContactMethods();
		emailTxt.setText("");
		phoneTxt.setText("");
		secondPhoneTxt.setText("");
		if(contactMethods == null || contactMethods.size() == 0){
			return;
		}
		for(ContactMethod contact :contactMethods){
			if(contact.getCmType()==ContactMethodType.EMAIL){
				emailTxt.setText(contact.getCmValue());
			}else if(contact.getCmType() == ContactMethodType.PHONE){
				if(phoneTxt.getText().isEmpty()){
					phoneTxt.setText(contact.getCmValue());
				}else if(secondPhoneTxt.getText().isEmpty()){
					secondPhoneTxt.setText(contact.getCmValue());
					return;
				}
			}
		}
	 
	}

}
