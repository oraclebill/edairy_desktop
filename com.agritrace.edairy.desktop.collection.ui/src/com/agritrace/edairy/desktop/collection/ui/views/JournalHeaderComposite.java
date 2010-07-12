package com.agritrace.edairy.desktop.collection.ui.views;

import java.beans.Beans;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.controllers.JournalHeaderRidget;
import com.agritrace.edairy.desktop.collection.ui.views.JournalHeaderComposite.ControlType;
import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;

public class JournalHeaderComposite extends Composite implements IComplexComponent {

	static {
		SwtControlRidgetMapper.getInstance().addMapping(JournalHeaderComposite.class, JournalHeaderRidget.class);
	}

	public enum ControlType {
		COMBO, TEXT;
	}

	private class JournalHeaderTraverseListener implements TraverseListener {
		@Override
		public void keyTraversed(TraverseEvent e) {
			if (e.detail == SWT.TRAVERSE_RETURN) {
				e.doit = true;
				e.detail = SWT.TRAVERSE_TAB_NEXT;
			}
		}
	}

	private List<Object> uiControls = new LinkedList<Object>();
	private Button calendarButton;
	private DateTime dateText;
	private TraverseListener traverseListener = new JournalHeaderTraverseListener();
	private final ControlType controlType;

	public JournalHeaderComposite(Composite parent, int style) {
		this(parent, style, ControlType.COMBO);
	}

	public JournalHeaderComposite(Composite parent, int style, ControlType controlType) {
		super(parent, style);
		this.controlType = controlType;
		createHeaderGroup(this);
		createSubHeaderGroup(this);
		GridLayoutFactory.fillDefaults().generateLayout(this);
	}

	@Override
	public List<Object> getUIControls() {
		return Collections.unmodifiableList(uiControls);
	}

	private Group createHeaderGroup(Composite parent) {
		final Group group = UIControlsFactory.createGroup(parent,
				MilkCollectionJournalView.MILK_JOURNAL_BOOK_GROUP_TITLE, ViewWidgetId.milkJournalGroup);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(group);

		final Label dateLabel = UIControlsFactory.createLabel(group, MilkCollectionJournalView.DATE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(dateLabel);

		final Composite dateComposite = UIControlsFactory.createComposite(group);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateComposite);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(2).applyTo(dateComposite);

		dateText = UIControlsFactory.createDate(dateComposite, SWT.DATE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(dateText);
		addUIControl(dateText, ViewWidgetId.calendarDate);
		dateText.addTraverseListener(traverseListener);

		calendarButton = new Button(dateComposite, SWT.PUSH);
// 		calendarButton = UIControlsFactory.createButton(group);

// 		Image calendarButtonImage = new Image(parent.getDisplay(), calendar.getImageData().scaledTo(16, 16));
		if (!Beans.isDesignTime()) {
			final Image calendar = Activator.getImage(ImageRegistry.calendar);
			calendarButton.setImage(calendar);
		}
		GridDataFactory.swtDefaults().align(SWT.END, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

//		calendarButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
//				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
//						dateText.getText());
//
//				if (calDialog.open() == AbstractWindowController.OK) {
//					final Date selectedDate = (Date) calDialog.getController().getContext(
//							SimpleFormattedDateBean.DATE_PROR);
//					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
//					bean.setDate(selectedDate);
//					dateText.setText(bean.getFormattedDate());
//				}
//			}
//		});

		final Label padComposite = UIControlsFactory.createLabel(group, "");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).applyTo(padComposite);

		final Label routeLabel = UIControlsFactory.createLabel(group, MilkCollectionJournalView.ROUTE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(routeLabel);

		// Combo combo = new Combo(group, SWT.BORDER|SWT.DROP_DOWN);
		final Control combo = createControl(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo);
		addUIControl(combo, ViewWidgetId.routeCombo);
		combo.addTraverseListener(traverseListener);

		final Label sectionLabel = UIControlsFactory.createLabel(group, MilkCollectionJournalView.SECTION_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(sectionLabel);

		final Control combo2 = createControl(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo2);
		addUIControl(combo2, ViewWidgetId.sessionCombo);
		combo2.addTraverseListener(traverseListener);

//		Composite pane = UIControlsFactory.createComposite(group);
//		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(pane);
//		GridDataFactory.fillDefaults().grab(true, false).span(7, 1).applyTo(pane);

		final Label vehicleLabel = UIControlsFactory.createLabel(group, MilkCollectionJournalView.VEHICLE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(vehicleLabel);

		final Control combo3 = createControl(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo3);
		combo3.addTraverseListener(traverseListener);
		addUIControl(combo3, ViewWidgetId.vehicleCombo);

		final Label driverLabel = UIControlsFactory.createLabel(group, MilkCollectionJournalView.DRIVER_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(driverLabel);

		final Control driverCombo = createControl(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(driverCombo);
		addUIControl(driverCombo, ViewWidgetId.driverCombo);
		driverCombo.addTraverseListener(traverseListener);

		return group;
	}

	private Group createSubHeaderGroup(Composite parent) {
		final Group group = UIControlsFactory.createGroup(parent, MilkCollectionJournalView.MILK_BOOK_GROUP_TITLE,
				ViewWidgetId.milkGroup);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(group);

		final Label journalLabel = UIControlsFactory.createLabel(group, "Reference No:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(journalLabel);

		final Text journalText = UIControlsFactory.createText(group, SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(journalText);
		addUIControl(journalText, ViewWidgetId.journalText);
		journalText.addTraverseListener(traverseListener);

		final Label journalTotalLabel = UIControlsFactory.createLabel(group,
				MilkCollectionJournalView.JOURNAL_TOTAL_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MilkCollectionJournalView.MINIMUM_LABEL_WIDTH, -1).applyTo(journalTotalLabel);

		final Text journalTotalText = UIControlsFactory.createTextDecimal(group);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(journalTotalText);
		journalTotalText.addTraverseListener(traverseListener);
		addUIControl(journalTotalText, ViewWidgetId.journalTotalText);

		return group;
	}

	public ControlType getControlType() {
		return controlType;
	}
	
	/**
	 * 
	 * @param parent
	 * @return
	 * @wbp.factory
	 */
	private Control createControl(Composite parent) {
		switch (controlType) {
		case TEXT:
			return UIControlsFactory.createText(parent, SWT.NONE);
		case COMBO:
			return UIControlsFactory.createCCombo(parent);
		default:
			throw new IllegalArgumentException();
		}
	}

	private void addUIControl(Control control, String bindingId) {
		uiControls.add(control);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, bindingId);
	}
}