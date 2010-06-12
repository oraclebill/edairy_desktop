package com.agritrace.edairy.desktop.common.ui.validators;

import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;

public interface WidgetCompleteChangeListener {

	public void statusChanged(boolean validate, WidgetController source);
}
