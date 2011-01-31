package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.IRidgetContainer;

public interface WidgetController<T extends Object> {

	public void configure();

	public IRidgetContainer getContainer();

	public T getInputModel();

	public void setInputModel(T model);

	public void updateBinding();

}
