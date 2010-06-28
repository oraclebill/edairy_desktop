package com.agritrace.edairy.desktop.finance.ui.views;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class UIDebugUtil {
	
	public static final Color CYAN = PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_CYAN);
	
	public MouseTrackListener mt = new MouseTrackAdapter() {
		HashMap<Object, Color> oldColors = new HashMap<Object, Color>();

		@Override
		public void mouseEnter(MouseEvent e) {
			System.err.println(">> mouseEnter" + e);
			Object o = e.getSource();
			if (o instanceof Control) {
				Control c = (Control) o;
				oldColors.put(c, c.getBackground());
				c.setBackground(CYAN);
			}

		}

		@Override
		public void mouseExit(MouseEvent e) {
			System.err.println(">> mouseExit" + e);
			Object o = e.getSource();
			if (o instanceof Control) {
				Control c = (Control) o;
				Color color = oldColors.get(c);
				if (color != null) {
					c.setBackground(color);
					oldColors.remove(c);
					rpc(c);
				} else {
					System.err.println("no color found for " + c);
				}
			}
		}

		@Override
		public void mouseHover(MouseEvent e) {
			System.err.println(">> mouseHover" + e);
		}

	};

	public void rpc(Control control) {
		rpc(control, 0);
	}
	
	public void rpc(Control control, int level) {
		pc(level, control);
		if (control instanceof Composite) {
			for (Control c : ((Composite) control).getChildren()) {
				rpc(c, level + 1);
			}
		}
	}
	
	public void pc(int level, Control c) {
		System.err.println("[" + level + "]"
				+ " found child: " + c 
				+ ", bounds=" + c.getBounds() 
				+ ", location=" + c.getLocation() 
				+ ", background=" + c.getBackground()
				+ ", foreground=" + c.getForeground()
			);
	}

	public void addListener(Control control) {
		control.addMouseTrackListener(mt);
		if (control instanceof Composite) {
			for (Control c : ((Composite) control).getChildren()) {
				addListener(c);
			}
		}
	}
}
