/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.databinding;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts the input String into an String of UPPERCASE characters.
 * <p>
 * Example: {@code "HelloWorld213!"} -&gt; {@code "HELLOWORLD123!"}
 * 
 * @since 2.0
 */
public class StringToUpperCaseConverter extends Converter {

	public StringToUpperCaseConverter() {
		super(String.class, String.class);
	}

	public Object convert(Object fromObject) {
		String result = null;
		if (fromObject != null) {
			String input = (String) fromObject;
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				builder.append(Character.toUpperCase(ch));
			}
			result = builder.toString();
		}
		return result;
	}

}
