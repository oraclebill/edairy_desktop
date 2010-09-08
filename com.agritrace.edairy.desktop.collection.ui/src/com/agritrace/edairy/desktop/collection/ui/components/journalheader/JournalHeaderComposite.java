package com.agritrace.edairy.desktop.collection.ui.components.journalheader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.util.FieldUtil;

public class JournalHeaderComposite extends Composite implements IComplexComponent {
	private static final int MINIMUM_LABEL_WIDTH = 80;

	private static final String DATE_LABEL = "Date:";
	private static final String DRIVER_LABEL = "Driver:";
	private static final String JOURNAL_TOTAL_LABEL = "Driver Total:";
	private static final String MILK_BOOK_GROUP_TITLE = "Journal Page";
	private static final String MILK_JOURNAL_BOOK_GROUP_TITLE = "Journal Book / Collection Details";
	private static final String ROUTE_LABEL = "Route:";
	private static final String SECTION_LABEL = "Session:";

	private static final String VEHICLE_LABEL = "Truck:";

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
	private Text dateText;
	private TraverseListener traverseListener = new JournalHeaderTraverseListener();

	public JournalHeaderComposite(Composite parent, int style) {
		super(parent, style);
		createHeaderGroup(this);
		createSubHeaderGroup(this);
		GridLayoutFactory.fillDefaults().generateLayout(this);
	}

	@Override
	public List<Object> getUIControls() {
		return Collections.unmodifiableList(uiControls);
	}

	protected Composite createHeaderGroup(Composite parent) {
		final Group group = createGroup(parent, MILK_JOURNAL_BOOK_GROUP_TITLE,
				ViewWidgetId.milkJournalGroup);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(group);

		final Label dateLabel = FieldUtil.createLabel(group, DATE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(dateLabel);

		final Composite dateComposite = UIControlsFactory.createComposite(group);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateComposite);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(2).applyTo(dateComposite);

		dateText = UIControlsFactory.createText(dateComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(dateText);
		addUIControl(dateText, ViewWidgetId.calendarDate);
		dateText.addTraverseListener(traverseListener);

		final Label padComposite = FieldUtil.createLabel(group, "");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).applyTo(padComposite);

		final Label routeLabel = FieldUtil.createLabel(group, ROUTE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(routeLabel);

		// Combo combo = new Combo(group, SWT.BORDER|SWT.DROP_DOWN);
		final Control combo = UIControlsFactory.createText(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo);
		addUIControl(combo, ViewWidgetId.routeCombo);
		combo.addTraverseListener(traverseListener);

		final Label sectionLabel = FieldUtil.createLabel(group, SECTION_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
				.applyTo(sectionLabel);

		final Control combo2 = UIControlsFactory.createText(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo2);
		addUIControl(combo2, ViewWidgetId.sessionCombo);
		combo2.addTraverseListener(traverseListener);

		final Label vehicleLabel = FieldUtil.createLabel(group, VEHICLE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
				.applyTo(vehicleLabel);

		final Control combo3 = UIControlsFactory.createText(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo3);
		combo3.addTraverseListener(traverseListener);
		addUIControl(combo3, ViewWidgetId.vehicleCombo);

		final Label driverLabel = FieldUtil.createLabel(group, DRIVER_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(driverLabel);

		final Control driverCombo = UIControlsFactory.createText(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(driverCombo);
		addUIControl(driverCombo, ViewWidgetId.driverCombo);
		driverCombo.addTraverseListener(traverseListener);

		return group;
	}

	protected Composite createSubHeaderGroup(Composite parent) {
		final Group group = createGroup(parent, MILK_BOOK_GROUP_TITLE, ViewWidgetId.milkGroup);
		GridLayoutFactory.fillDefaults().margins(4, 2).numColumns(7).applyTo(group);
		GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MINIMUM_LABEL_WIDTH, -1).grab(true, false);

		{
			final Label journalLabel = FieldUtil.createLabel(group, "Reference No:");
			GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
					.applyTo(journalLabel);

			final Text journalText = UIControlsFactory.createText(group, SWT.BORDER);
			factory.applyTo(journalText);
			addUIControl(journalText, ViewWidgetId.journalText);
			journalText.addTraverseListener(traverseListener);
		}
		{
			final Label journalNumberLabel = FieldUtil.createLabel(group, "Journal No:");
			GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
					.applyTo(journalNumberLabel);

			final Text journalNumberText = UIControlsFactory.createText(group, SWT.BORDER);
			factory.applyTo(journalNumberText);
			addUIControl(journalNumberText, ViewWidgetId.journalNumberText);
			journalNumberText.addTraverseListener(traverseListener);
		}
		{
			final Label journalTotalLabel = FieldUtil.createLabel(group, JOURNAL_TOTAL_LABEL);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
					.applyTo(journalTotalLabel);

			final Text journalTotalText = UIControlsFactory.createTextDecimal(group);
			factory.applyTo(journalTotalText);
			journalTotalText.addTraverseListener(traverseListener);
			addUIControl(journalTotalText, ViewWidgetId.journalTotalText);
		}
		// filler
		{
			final Label label = new Label(group, SWT.NONE);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH * 2, -1)
					.applyTo(label);
		}
		{
			final Label label = FieldUtil.createLabel(group, "Status: ");
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(label);

			final Text field = UIControlsFactory.createText(group);
			field.setEditable(false);
			factory.applyTo(field);
			field.addTraverseListener(traverseListener);
			addUIControl(field, ViewWidgetId.journalStatus);
		}
		return group;
	}


	private Group createGroup(Composite parent, String title, String bindingId) {
		Group group = new Group(parent, SWT.BORDER);
		group.setText(title);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(group, bindingId);
		group.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		return group;
	}

	private void addUIControl(Control control, String bindingId) {
		uiControls.add(control);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, bindingId);
	}
}