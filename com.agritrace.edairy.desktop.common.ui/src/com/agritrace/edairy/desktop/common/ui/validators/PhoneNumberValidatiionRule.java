package com.agritrace.edairy.desktop.common.ui.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class PhoneNumberValidatiionRule implements IValidator {

	public static final int MIN_CHARS_AMOUNT = 7;
	
	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			final Pattern pattern = Pattern.compile("[^0-9-+\\x20'\"()]");
			final Matcher m = pattern.matcher((String) value);
			if (m.find()) {
				return ValidationStatus.error("Number contains wrong characters");
			} else {
				if(isDigitsEnough((String)value)){
					return Status.OK_STATUS;
				}
				else{
					return ValidationStatus.error("Number contains too few numeric characters (must be at least "+MIN_CHARS_AMOUNT+")");
				}
			}

		}
		return null;
	}

	private boolean isDigitsEnough(String value){
		if(value == null || value.isEmpty() || value.length() < MIN_CHARS_AMOUNT/*definitely not enough numbers, hah...*/){
			return false;
		}
		int count = 0;
		char[] chars = new char[value.length()];
		value.getChars(0, value.length(), chars, 0);
		
		for(char c:chars){
			if(c >='0' && c<='9'){
				count++;
			}
		}
		
		return count >= MIN_CHARS_AMOUNT;
	}
	
}
