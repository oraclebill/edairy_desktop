package com.agritrace.edairy.desktop.collection.ui.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.nebula.widgets.compositetable.AbstractNativeHeader;
import org.eclipse.swt.nebula.widgets.compositetable.CompositeTable;
import org.eclipse.swt.nebula.widgets.compositetable.ResizableGridRowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.DeliveryJournalEditBindContants;
import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.swtdesigner.SWTResourceManager;

public class DeliveryJournalEditPanel extends Composite {

	private Group tableGroup;
	private Text text;
	private Text totalOutputText;
	private final Composite header;
	private final Composite detail;
	private CompositeTable compositeTable;

	private static final class Header extends AbstractNativeHeader {

		public Header(Composite parent, int style) {
			super(parent, style);
			setWeights(new int[] { 50, 100, 60, 300 });
			setColumnText(new String[] { "Bin #", "Amount", "Rejected", "Description" });
		}
	}

	private static final class Row extends Composite implements IComplexComponent {
		private final List<Object> controls = new ArrayList<Object>();

		/**
		 * Must have a two-arguments constructor.
		 *
		 * @param parent
		 *            the parent Composite; non null
		 * @param style
		 *            the style bits
		 */
		public Row(final Composite parent, final int style) {
			super(parent, style);
			this.setLayout(new ResizableGridRowLayout());
			Text descriptionTxt;
			addUIControl(UIControlsFactory.createCCombo(this), DeliveryJournalEditBindContants.ROW_TXT_BIN_ID);
//			addUIControl(UIControlsFactory.createText(this, SWT.NULL), DeliveryJournalEditBindContants.ROW_TXT_BIN_ID);
			addUIControl(UIControlsFactory.createTextDecimal(this), DeliveryJournalEditBindContants.ROW_TXT_AMOUNT);
			addUIControl(UIControlsFactory.createButtonCheck(this), DeliveryJournalEditBindContants.ROW_TXT_REJECTED);
			addUIControl(descriptionTxt = UIControlsFactory.createText(this, SWT.NULL), DeliveryJournalEditBindContants.ROW_TXT_DESCRIPTION);
			descriptionTxt.addTraverseListener(new TraverseListener() {
				@Override
				public void keyTraversed(TraverseEvent e) {
					System.err.println(e);
					if (e.detail == SWT.TRAVERSE_TAB_NEXT) {
						e.detail = SWT.TRAVERSE_RETURN;
					}
				}
			});
		}

		@Override
		public List<Object> getUIControls() {
			return Collections.unmodifiableList(controls);
		}

		private void addUIControl(final Object uiControl, final String bindingId) {
			controls.add(uiControl);
			// Set's binding property into the widget.
			// Need this for the widget <-> ridget binding
			SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, bindingId);
		}

	}



	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public DeliveryJournalEditPanel(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		header = UIControlsFactory.createComposite(this, SWT.BORDER_SOLID);
		detail = UIControlsFactory.createComposite(this, SWT.NULL);

		createHeaderGroup(header);
		createTableGroup(detail);

		GridLayoutFactory.fillDefaults().margins(5, 8).generateLayout(this);
		this.pack();
	}

	private void createHeaderGroup(Composite parent) {
		final FormLayout fl_header = new FormLayout();
		fl_header.marginBottom = 8;
		parent.setLayout(fl_header);

		final Label lblDate = UIControlsFactory.createLabel(parent, "Date");
		final FormData fd_lblDate = new FormData();
		lblDate.setLayoutData(fd_lblDate);

		final DateTime dateCombo = UIControlsFactory.createDate(parent, SWT.MEDIUM,
				DeliveryJournalEditBindContants.DATE_COMBO);
		fd_lblDate.top = new FormAttachment(dateCombo, 3, SWT.TOP);
		final FormData fd_dateCombo = new FormData();
		fd_dateCombo.top = new FormAttachment(0, 11);
		fd_dateCombo.width = 100;
		fd_dateCombo.left = new FormAttachment(0, 109);
		dateCombo.setLayoutData(fd_dateCombo);

		final Label lblSession = UIControlsFactory.createLabel(parent, "Session");
		fd_lblDate.left = new FormAttachment(0, 10);
		final FormData fd_lblSession = new FormData();
		fd_lblSession.left = new FormAttachment(lblDate, 0, SWT.LEFT);
		lblSession.setLayoutData(fd_lblSession);

		final CCombo sessionCombo = UIControlsFactory.createCCombo(parent, DeliveryJournalEditBindContants.SESSION_COMBO);
		fd_lblSession.top = new FormAttachment(sessionCombo, 5, SWT.TOP);
		final FormData fd_sessionCombo = new FormData();
		fd_sessionCombo.bottom = new FormAttachment(0, 62);
		fd_sessionCombo.right = new FormAttachment(0, 209);
		fd_sessionCombo.top = new FormAttachment(0, 40);
		fd_sessionCombo.left = new FormAttachment(0, 109);
		sessionCombo.setLayoutData(fd_sessionCombo);

		final Label lblRoute = UIControlsFactory.createLabel(parent, "Transport Route");
		final FormData fd_lblRoute = new FormData();
		fd_lblRoute.left = new FormAttachment(lblDate, 0, SWT.LEFT);
		lblRoute.setLayoutData(fd_lblRoute);

		final CCombo routeCombo = UIControlsFactory.createCCombo(parent, DeliveryJournalEditBindContants.ROUTE_COMBO);
		fd_lblRoute.top = new FormAttachment(routeCombo, 5, SWT.TOP);
		final FormData fd_routeCombo = new FormData();
		fd_routeCombo.bottom = new FormAttachment(0, 95);
		fd_routeCombo.right = new FormAttachment(0, 209);
		fd_routeCombo.top = new FormAttachment(0, 73);
		fd_routeCombo.left = new FormAttachment(0, 109);
		routeCombo.setLayoutData(fd_routeCombo);

		final Label lblCustomer = UIControlsFactory.createLabel(parent, "Customer");
		final FormData fd_lblCustomer = new FormData();
		fd_lblCustomer.left = new FormAttachment(lblDate, 0, SWT.LEFT);
		lblCustomer.setLayoutData(fd_lblCustomer);

		final CCombo customerCombo = UIControlsFactory.createCCombo(parent,
				DeliveryJournalEditBindContants.CUSTOMER_COMBO);
		fd_lblCustomer.top = new FormAttachment(customerCombo, 5, SWT.TOP);
		final FormData fd_customerCombo = new FormData();
		fd_customerCombo.bottom = new FormAttachment(0, 128);
		fd_customerCombo.right = new FormAttachment(0, 209);
		fd_customerCombo.top = new FormAttachment(0, 106);
		fd_customerCombo.left = new FormAttachment(0, 109);
		customerCombo.setLayoutData(fd_customerCombo);

		final Label lblDriver = UIControlsFactory.createLabel(parent, "Driver");
		final FormData fd_lblDriver = new FormData();
		fd_lblDriver.left = new FormAttachment(lblDate, 0, SWT.LEFT);
		lblDriver.setLayoutData(fd_lblDriver);

		final CCombo driverCombo = UIControlsFactory.createCCombo(parent, DeliveryJournalEditBindContants.DRIVER_COMBO);
		fd_lblDriver.top = new FormAttachment(driverCombo, 5, SWT.TOP);
		final FormData fd_driverCombo = new FormData();
		fd_driverCombo.bottom = new FormAttachment(0, 161);
		fd_driverCombo.right = new FormAttachment(0, 209);
		fd_driverCombo.top = new FormAttachment(0, 139);
		fd_driverCombo.left = new FormAttachment(0, 109);
		driverCombo.setLayoutData(fd_driverCombo);

		final Label lblVehicle = UIControlsFactory.createLabel(parent, "Vehicle");
		final FormData fd_lblVehicle = new FormData();
		fd_lblVehicle.left = new FormAttachment(lblDate, 0, SWT.LEFT);
		fd_lblVehicle.bottom = new FormAttachment(100, -2);
		lblVehicle.setLayoutData(fd_lblVehicle);

		final CCombo vehicleCombo = UIControlsFactory.createCCombo(parent, DeliveryJournalEditBindContants.VEHICLE_COMBO);
		fd_lblVehicle.top = new FormAttachment(vehicleCombo, 5, SWT.TOP);
		final FormData fd_vehicleCombo = new FormData();
		fd_vehicleCombo.bottom = new FormAttachment(0, 194);
		fd_vehicleCombo.right = new FormAttachment(0, 209);
		fd_vehicleCombo.top = new FormAttachment(0, 172);
		fd_vehicleCombo.left = new FormAttachment(0, 109);
		vehicleCombo.setLayoutData(fd_vehicleCombo);

		final Label lblTotal = UIControlsFactory.createLabel(parent, "Total: ");
		final FormData fd_lblTotal = new FormData();
		fd_lblTotal.top = new FormAttachment(lblVehicle, 0, SWT.TOP);
		lblTotal.setLayoutData(fd_lblTotal);

		totalOutputText = UIControlsFactory.createText(parent, SWT.NONE,
				DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT);
		final FormData fd_totalOutputText = new FormData();
		fd_totalOutputText.top = new FormAttachment(lblVehicle, -3, SWT.TOP);
		fd_totalOutputText.left = new FormAttachment(lblTotal, 61);
		fd_totalOutputText.right = new FormAttachment(100, -84);
		totalOutputText.setLayoutData(fd_totalOutputText);

		text = UIControlsFactory.createText(parent, SWT.BORDER, DeliveryJournalEditBindContants.REFERENCE_NUM);
		final FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(100, -10);
		fd_text.top = new FormAttachment(lblDate, -2, SWT.TOP);
		fd_text.left = new FormAttachment(0, 344);
		text.setLayoutData(fd_text);

		final Label lblReferenceNumber = UIControlsFactory.createLabel(header, "Reference #");
		fd_lblTotal.left = new FormAttachment(lblReferenceNumber, 0, SWT.LEFT);
		fd_text.left = new FormAttachment(lblReferenceNumber, 100, SWT.LEFT);
		final FormData fd_lblReferenceNumber = new FormData();
		fd_lblReferenceNumber.left = new FormAttachment(0, 0);
		fd_lblReferenceNumber.left = new FormAttachment(dateCombo, 26);
		fd_lblReferenceNumber.top = new FormAttachment(lblDate, 0, SWT.TOP);
		lblReferenceNumber.setLayoutData(fd_lblReferenceNumber);
	}

	private void createTableGroup(Composite parent) {
		parent.setLayout(new FillLayout());

		tableGroup = UIControlsFactory.createGroup(parent, "Item Details");
		tableGroup.setLayout(new GridLayout(1, false));

		compositeTable = new CompositeTable(tableGroup, SWT.NONE);
		final GridData gd_compositeTable = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_compositeTable.heightHint = 150;
		compositeTable.setLayoutData(gd_compositeTable);
//		compositeTable.setNumRowsInCollection(10);
		compositeTable.setTraverseOnTabsEnabled(true);
		compositeTable.setInsertHint("");

		new Header(compositeTable, SWT.NONE);
		new Row(compositeTable, SWT.NONE);
		compositeTable.setRunTime(true);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(compositeTable, DeliveryJournalEditBindContants.LINE_ITEM_TABLE);

		final Composite composite = UIControlsFactory.createComposite(tableGroup, SWT.RIGHT);
		final RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
		composite.setLayout(rl_composite);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));

		UIControlsFactory.createButton(composite, "Delete Row", "BTN_DELETE_ROW");

		UIControlsFactory.createButton(composite, "Add Row", DeliveryJournalEditBindContants.BTN_ADD_ROW);

	}
}
