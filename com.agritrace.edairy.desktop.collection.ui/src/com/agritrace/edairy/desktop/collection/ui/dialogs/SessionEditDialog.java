package com.agritrace.edairy.desktop.collection.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.collection.ui.controllers.SessionEditDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;

public class SessionEditDialog extends BaseDialogView {
	private class SessionEditPanel extends Composite {
		public SessionEditPanel(Composite parent, int style) {
			super(parent, style);
			
			GridLayoutFactory.fillDefaults().numColumns(2).applyTo(this);
			
			UIControlsFactory.createLabel(this, "Code");
			final Text code = UIControlsFactory.createText(this, SWT.SINGLE, ViewConstants.SESSION_BIND_CODE);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(code);
			
			UIControlsFactory.createLabel(this, "Description");
			final Text desc = UIControlsFactory.createText(this, SWT.MULTI, ViewConstants.SESSION_BIND_DESCRIPTION);
			GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT, 60).applyTo(desc);
			
			UIControlsFactory.createLabel(this, "Time of day");
			final DateTime time = UIControlsFactory.createTime(this, SWT.BORDER | SWT.SHORT, ViewConstants.SESSION_BIND_TIME);
			GridDataFactory.fillDefaults().applyTo(time);
		}
	}
	
	public SessionEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		setTitle("Edit Sessions");

		final Composite master = new MasterDetailsComposite(parent, SWT.TOP) {
			@Override
			protected void createDetails(Composite parent) {
				final Composite detailPanel = new SessionEditPanel(parent, SWT.NONE);
				GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL,
						SWT.FILL).hint(450, SWT.DEFAULT).applyTo(detailPanel);
				GridLayoutFactory.fillDefaults().generateLayout(parent);
			}
		};
		
		addUIControl(master, "master");
		GridLayoutFactory.fillDefaults().generateLayout(master);
	}

	@Override
	protected AbstractWindowController createController() {
		return new SessionEditDialogController();
	}

}
