package com.agritrace.edairy.desktop.common.ui.controls;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DateRangeControl extends  Composite implements IComplexComponent {

	public static final int DEFAULT_LABEL_WIDTH = 110;
	
	public static final String DEFAULT_RANGE_LABEL = "Date Range ";
	public static final String DEFAULT_START_LABEL = "Start: ";
	public static final String DEFAULT_END_LABEL = "End: ";
	
	public static final String START_DATE_ID = "start-date";
	public static final String END_DATE_ID = "end-date";
	
	private final List<Control> uiControls = new LinkedList<Control>();
	private final String labelText;
	private final String startId;
	private final String endId;

	public DateRangeControl(Composite parent, int style) {
		this(parent, style, DEFAULT_RANGE_LABEL, START_DATE_ID, END_DATE_ID);
	}
	
	public DateRangeControl(Composite parent, String rangeLabelTxt, String startTxtId, String endTxtId) {
		this(parent, SWT.NULL, rangeLabelTxt, startTxtId, endTxtId);
	}
	
	public DateRangeControl(Composite parent, int style, String rangeLabelTxt, String startTxtId, String endTxtId) {
		super(parent, style);
		
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));		
		setLayout(new GridLayout(7, false));
		
		labelText = rangeLabelTxt;
		startId = startTxtId;
		endId = endTxtId;
		
		createDataRangeSearch();
	}

	public Composite getComposite() {
		return this;
	}

	private void createDataRangeSearch() {
		final Label label = UIControlsFactory.createLabel(this, labelText);

		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, -1);
		labelFactory.applyTo(label);

		final Label startLabel = UIControlsFactory.createLabel(this, DEFAULT_START_LABEL);
		GridDataFactory.defaultsFor(startLabel).applyTo(startLabel);
		
		final DateTime startDateText = UIControlsFactory.createDate(this, SWT.BORDER, startId);
		GridDataFactory.defaultsFor(startDateText).align(SWT.LEFT, SWT.FILL).grab(true, false).applyTo(startDateText);
		addUIControl(startDateText, startId);

		final Label endLabel = UIControlsFactory.createLabel(this, DEFAULT_END_LABEL);
		GridDataFactory.defaultsFor(endLabel).applyTo(endLabel);
		
		final DateTime endDateText = UIControlsFactory.createDate(this, SWT.BORDER, endId);
		GridDataFactory.defaultsFor(endDateText).align(SWT.LEFT, SWT.FILL).grab(true, false).applyTo(endDateText);
		addUIControl(endDateText, endId);
	}
	
	@Override
	public List<Object> getUIControls() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addUIControl(Control control, String bindingId) {
		uiControls.add(control);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, bindingId);
	}

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);		
		
		DateRangeControl control = new DateRangeControl(shell, "Range", "start", "end");
		GridLayoutFactory.fillDefaults().generateLayout(shell);
		
//		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
