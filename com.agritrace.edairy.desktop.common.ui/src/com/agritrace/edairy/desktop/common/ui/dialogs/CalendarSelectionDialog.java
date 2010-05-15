package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;

//import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialogController;

public class CalendarSelectionDialog extends AbstractDialogView{
    
    public static String CALENDAR_DATE = "calendar.date";
    public static String CALENDAR_OK = "calendar.ok";
    public static String CALENDAR_CANCEL = "calendar.cancel";
	
	public CalendarSelectionDialog(){
		super(null);
	}
	
	public CalendarSelectionDialog(String dateString){
		super(null);
	}

	@Override
	protected Control buildView(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(2, false));
		DateTime calendar = UIControlsFactory.createCalendar(parent);
		addUIControl(calendar, CALENDAR_DATE);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(createOkCancelButtons(parent));
		return null;
	}

	@Override
	protected AbstractWindowController createController() {
		// TODO Auto-generated method stub
		return new CalendarSelectionDialogController();
	}
	

	private Composite createOkCancelButtons(Composite parent) {

		Composite buttonComposite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(buttonComposite);

		Button okButton = UIControlsFactory.createButton(buttonComposite);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.END, SWT.BEGINNING).applyTo(okButton);
		okButton.setText("Ok"); //$NON-NLS-1$
		addUIControl(okButton, CALENDAR_OK);

		Button cancelButton = UIControlsFactory.createButton(buttonComposite);
		cancelButton.setText("Cancel"); //$NON-NLS-1$
		addUIControl(cancelButton, CALENDAR_CANCEL);

		return buttonComposite;
	}

}
