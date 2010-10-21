package com.agritrace.edairy.desktop.common.ui.columnformatters;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;

public final class BooleanPropertyColumnFormatter extends ColumnFormatter {
	
	private static final ImageDescriptor ACCEPT = AbstractUIPlugin.imageDescriptorFromPlugin(
			DesktopBaseActivator.RESOURCE_PLUGIN, "icons/tick.png");
	
	private static final ImageDescriptor CROSS = AbstractUIPlugin.imageDescriptorFromPlugin(
			DesktopBaseActivator.RESOURCE_PLUGIN, "icons/cross.png");
	
	private static final ImageDescriptor EMPTY = AbstractUIPlugin.imageDescriptorFromPlugin(
			DesktopBaseActivator.RESOURCE_PLUGIN, "icons/bullet_error.png");

	private String propertyName;
	private boolean invertTruthValues;
	
	public BooleanPropertyColumnFormatter(String propertyName, boolean trueIsGood) {
		this.propertyName = propertyName;
		this.propertyName = propertyName;
		this.invertTruthValues = !trueIsGood;
	}
	
	public BooleanPropertyColumnFormatter(String propertyName) {
		this(propertyName, false);
	}

	
	@Override
	public String getText(Object element) {
		return "";
	}


	@Override
	public int getHorizontalAlignment(Object element) {
		return SWT.CENTER;
	}

	@Override
	public Image getImage(Object element) {
		Boolean value = null;
		try {
			value = (Boolean) PropertyUtils.getProperty(element, propertyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (value != null) {
			boolean showGoodIndicator;
			if (invertTruthValues) {
				showGoodIndicator = !value.booleanValue();
			}
			else {
				showGoodIndicator = value.booleanValue();
			}
			
			if (showGoodIndicator) {
				return ACCEPT.createImage();
			}
			else {
				return CROSS.createImage();
			}
		}
		return EMPTY.createImage();
	}

	
}