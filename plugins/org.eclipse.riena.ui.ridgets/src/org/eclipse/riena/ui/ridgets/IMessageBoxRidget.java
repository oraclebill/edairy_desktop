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
package org.eclipse.riena.ui.ridgets;

/**
 * Shows messages to the user in a popup window with a selection of buttons that
 * also allows to ask simple questions of the "yes/no"- or the "ok/cancel"-type.
 */
public interface IMessageBoxRidget extends IRidget {

	/**
	 * The type of the message box.
	 */
	enum Type {
		/**
		 * Information message.
		 */
		INFORMATION,
		/**
		 * Warning message.
		 */
		WARNING,
		/**
		 * Error message.
		 */
		ERROR,
		/**
		 * Help message.
		 */
		HELP,
		/**
		 * Message popup to ask a question.
		 */
		QUESTION,
		/**
		 * None of the other types. No icon is shown.
		 */
		PLAIN
	}

	/**
	 * The 'OK' button.
	 */
	MessageBoxOption OK = new MessageBoxOption();

	/**
	 * The 'Cancel' button.
	 */
	MessageBoxOption CANCEL = new MessageBoxOption();

	/**
	 * The 'Yes' button.
	 */
	MessageBoxOption YES = new MessageBoxOption();

	/**
	 * The 'No' button.
	 */
	MessageBoxOption NO = new MessageBoxOption();

	/**
	 * An option that stands for the popup window being closed without pressing
	 * one of the button.
	 */
	MessageBoxOption CLOSED = new MessageBoxOption();

	/**
	 * A predefined combination of options with just an 'OK' button.
	 */
	MessageBoxOption[] OPTIONS_OK = new MessageBoxOption[] { OK };

	/**
	 * A predefined combination of options with 'OK' and 'Cancel'.
	 */
	MessageBoxOption[] OPTIONS_OK_CANCEL = new MessageBoxOption[] { OK, CANCEL };

	/**
	 * A predefined combination of options with 'Yes' and 'No'.
	 */
	MessageBoxOption[] OPTIONS_YES_NO = new MessageBoxOption[] { YES, NO };

	/**
	 * A predefined combination of options with 'Yes', 'No' and 'Cancel'.
	 */
	MessageBoxOption[] OPTIONS_YES_NO_CANCEL = new MessageBoxOption[] { YES, NO, CANCEL };

	/**
	 * Returns the title of the message box.
	 * 
	 * @return The message title.
	 */
	String getTitle();

	/**
	 * Sets the title of the message box.
	 * 
	 * @param title
	 *            The message title.
	 */
	void setTitle(String title);

	/**
	 * Returns the text that is displayed inside the message box.
	 * 
	 * @return The message text.
	 */
	String getText();

	/**
	 * Sets the text that is displayed inside the message box.
	 * 
	 * @param text
	 *            The message text.
	 */
	void setText(String text);

	/**
	 * Returns the type of the message.
	 * 
	 * @return The message type.
	 * @see Type
	 */
	Type getType();

	/**
	 * Set the type of message.
	 * 
	 * @param type
	 *            The message type.
	 * @see Type
	 */
	void setType(Type type);

	/**
	 * Return the options displayed as buttons in the popup window.
	 * 
	 * @return The message options.
	 */
	MessageBoxOption[] getOptions();

	/**
	 * Sets the options displayed as buttons in the popup window. Can be either
	 * a predefined combination or any combination of standard buttons and
	 * custom buttons.
	 * 
	 * @see #OPTIONS_OK
	 * @see #OPTIONS_OK_CANCEL
	 * @see #OPTIONS_YES_NO
	 * @see #OPTIONS_YES_NO_CANCEL
	 * @see MessageBoxOption#MessageBoxOption(String)
	 * @param options
	 *            The message options.
	 */
	void setOptions(MessageBoxOption[] options);

	/**
	 * Shows the message box.
	 * 
	 * @return The selected option.
	 * @see MessageBoxOption
	 */
	MessageBoxOption show();

	/**
	 * An option shown as a button in the popup dialog.
	 */
	class MessageBoxOption {

		private String label;

		private MessageBoxOption() {
			// a default option with a label depending on the UI widget
		}

		/**
		 * Creates a custom option.
		 * 
		 * @param label
		 *            The button label.
		 */
		public MessageBoxOption(String label) {
			this.label = label;
		}

		/**
		 * Return the button label text .
		 * 
		 * @return the button label text.
		 */
		public String getLabel() {
			return label;
		}

	}

}
