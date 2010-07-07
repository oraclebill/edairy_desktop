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
 * A notification that turns up on top of the SubModuleView. No user interaction
 * is possible and it closes after a few seconds.
 * <p>
 * It is possible to set a message and an icon.
 * 
 * @since 2.0
 */
public interface IInfoFlyoutRidget extends IRidget {

	static final int PROPERTY_FYLOUT_FINISHED = 0;

	void addInfo(InfoFlyoutData info);

	/**
	 * The info displayed in the {@link InfoFlyout}.
	 */
	public class InfoFlyoutData {
		private String message;
		private String icon;

		public InfoFlyoutData(String icon, String message) {
			this.icon = icon;
			this.message = message;
		}

		public String getIcon() {
			return icon;
		}

		public String getMessage() {
			return message;
		}
	}

}
