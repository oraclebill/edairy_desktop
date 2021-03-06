package com.agritrace.edairy.desktop.common.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.riena.ui.swt.AbstractRienaUIPlugin;

import com.agritrace.edairy.desktop.common.ui.activator.Activator;

public class DesktopBaseActivator extends AbstractRienaUIPlugin {

	public static final String CALENDAR_ICON = "icons/date.png";

	public static final String FARM_SEARCH_ICON = "icons/find.png";
	public static final String MEMBER_SEARCH_ICON = "icons/find.png";
	public static final String RESOURCE_PLUGIN = "com.agritrace.edairy.desktop.icons";

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		try {
			reg.put(CALENDAR_ICON, imageDescriptorFromPlugin(RESOURCE_PLUGIN, CALENDAR_ICON));
			reg.put(MEMBER_SEARCH_ICON, imageDescriptorFromPlugin(RESOURCE_PLUGIN, MEMBER_SEARCH_ICON));
			reg.put(FARM_SEARCH_ICON, imageDescriptorFromPlugin(RESOURCE_PLUGIN, FARM_SEARCH_ICON));
		} catch (final NullPointerException npe) {
			// null pointers happen when the RESOURCE_PLUGIN does not exist...
			getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, npe.getMessage(), npe));
		}
	}
}
