package com.agritrace.edairy.demo.riena;

import java.util.Map;

import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.swt.lnf.ILnfMarkerSupportExtension;
import org.eclipse.riena.ui.swt.lnf.ILnfRenderer;
import org.eclipse.riena.ui.swt.lnf.ILnfRendererExtension;
import org.eclipse.riena.ui.swt.lnf.ILnfResource;
import org.eclipse.riena.ui.swt.lnf.ILnfTheme;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.ui.internal.Workbench;

public class EDairyManagerLookAndFeel extends RienaDefaultLnf {

	
	@Override
	public ILnfTheme getTheme() {
		return new EDairyManagerUITheme();
	}

	@Override
	protected String getLnfId() {
		return this.getClass().getName();
	}

	@Override
	public Image getImage(String key) {
//		.. also .. 
//		LnfKeyConstants.TITLELESS_SHELL_BACKGROUND;
//		LnfKeyConstants.TITLELESS_SHELL_BACKGROUND_IMAGE;
		if ( LnfKeyConstants.TITLELESS_SHELL_BACKGROUND.equals(key) ) {
			;;
		}
		else if ( LnfKeyConstants.TITLELESS_SHELL_BACKGROUND_IMAGE.equals(key) ) {
			return ImageStore.getInstance().getImage("edairy_background.gif");
		}			
		else if ( LnfKeyConstants.TITLELESS_SHELL_LOGO.equals(key) ) {
			return ImageStore.getInstance().getImage("edairy_logo.gif");
		}
//		else if ( LnfKeyConstants.SUB_MODULE_BACKGROUND.equals(key) ) {
//			return ImageStore.getInstance().getImage("edairy_logo.gif");
//		}
		
		
		return super.getImage(key);
	}



}
