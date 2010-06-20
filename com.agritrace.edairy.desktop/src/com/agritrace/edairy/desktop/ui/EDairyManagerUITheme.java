package com.agritrace.edairy.desktop.ui;

import org.eclipse.riena.ui.swt.lnf.ColorLnfResource;
import org.eclipse.riena.ui.swt.lnf.FontLnfResource;
import org.eclipse.riena.ui.swt.lnf.ILnfCustomizer;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme;
import org.eclipse.swt.graphics.FontData;

public class EDairyManagerUITheme extends RienaDefaultTheme {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#addCustomColors
	 * (java.util.Map)
	 */

	public void customizeLnf(ILnfCustomizer lnf) {
		super.customizeLnf(lnf);
		addCustomColors(lnf);
		addCustomSettings(lnf);

	}

	public void addCustomColors(ILnfCustomizer lnf) {

		lnf.putLnfSetting(LnfKeyConstants.NAVIGATION_BACKGROUND, new ColorLnfResource(231, 244, 211));
		lnf.putLnfSetting(LnfKeyConstants.SUB_MODULE_BACKGROUND, new ColorLnfResource(255, 255, 255));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#addCustomSettings
	 * (java.util.Map)
	 */

	public void addCustomSettings(ILnfCustomizer lnf) {

		lnf.putLnfSetting(LnfKeyConstants.NAVIGATION_WIDTH, 180);
		lnf.putLnfSetting(LnfKeyConstants.MARKER_SUPPORT_ID, "com.agritrace.edairy.desktop.markerSupport");

		// table.put(LnfKeyConstants.STATUSLINE_HEIGHT, 20);
		//
		// table.put(LnfKeyConstants.SUB_APPLICATION_SWITCHER_TOP_MARGIN, 22);
		// table.put(LnfKeyConstants.SUB_APPLICATION_SWITCHER_HEIGHT, 85);
		// table.put(LnfKeyConstants.SUB_APPLICATION_SWITCHER_HORIZONTAL_TAB_POSITION,
		// SWT.CENTER);
		// table.put(LnfKeyConstants.SUB_APPLICATION_SWITCHER_TAB_SHOW_ICON,
		// false);
		// table.put(LnfKeyConstants.SUB_APPLICATION_SWITCHER_TAB_MIN_WIDTH, 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#getSystemFont
	 * ()
	 */
	@Override
	protected FontData getSystemFont() {
		// TODO Auto-generated method stub
		return super.getSystemFont();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#
	 * getPrimaryForeground()
	 */
	@Override
	protected ColorLnfResource getPrimaryForeground() {
		// TODO Auto-generated method stub
		return super.getPrimaryForeground();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#
	 * getPrimaryBackground()
	 */
	@Override
	protected ColorLnfResource getPrimaryBackground() {
		// TODO Auto-generated method stub
		return super.getPrimaryBackground();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#getPrimaryFont
	 * ()
	 */
	@Override
	protected FontLnfResource getPrimaryFont() {
		// TODO Auto-generated method stub
		return super.getPrimaryFont();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultTheme#hideOsBorder
	 * ()
	 */
	@Override
	protected boolean hideOsBorder() {
		// TODO Auto-generated method stub
		return super.hideOsBorder();
	}

}
