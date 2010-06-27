package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.DeliveryJournalEditBindContants;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;

public class DeliveryJournalEditPanel extends Composite {
	private Text totalOutputText;
	private Group tableGroup;
	private Table lineItemTable;
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DeliveryJournalEditPanel(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblDate = UIControlsFactory.createLabel(this, "Date");
		
		DateTime dateCombo = UIControlsFactory.createDate(this, SWT.MEDIUM, DeliveryJournalEditBindContants.DATE_COMBO);
		
		Label lblSession = UIControlsFactory.createLabel(this, "Session");
		
		CCombo sessionCombo = UIControlsFactory.createCCombo(this, DeliveryJournalEditBindContants.SESSION_COMBO);
		
		Label lblRoute = UIControlsFactory.createLabel(this, "Route");
		
		CCombo routeCombo = UIControlsFactory.createCCombo(this, DeliveryJournalEditBindContants.ROUTE_COMBO);
		
		Label lblCustomer = UIControlsFactory.createLabel(this, "Customer");
		
		CCombo customerCombo = UIControlsFactory.createCCombo(this, DeliveryJournalEditBindContants.CUSTOMER_COMBO);
		
		Label lblDriver = UIControlsFactory.createLabel(this, "Driver");
		
		CCombo driverCombo = UIControlsFactory.createCCombo(this, DeliveryJournalEditBindContants.DRIVER_COMBO);
		
		Label lblVehicle = UIControlsFactory.createLabel(this, "Vehicle");
		
		CCombo vehicleCombo = UIControlsFactory.createCCombo(this, DeliveryJournalEditBindContants.VEHICLE_COMBO);
		
		Label lblTotal = UIControlsFactory.createLabel(this, "Total: ");
		
		totalOutputText = UIControlsFactory.createText(this, SWT.NONE, DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT);
		
		tableGroup = UIControlsFactory.createGroup(this, "Item Details");
		
		text = new Text(this, SWT.BORDER);
		
		Label lblReferenceNumber = new Label(this, SWT.NONE);
		lblReferenceNumber.setText("Reference Number");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.LEADING)
				.add(groupLayout.createSequentialGroup()
					.addContainerGap()
					.add(groupLayout.createParallelGroup(GroupLayout.LEADING)
						.add(tableGroup, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.add(GroupLayout.TRAILING, groupLayout.createSequentialGroup()
							.add(groupLayout.createParallelGroup(GroupLayout.LEADING)
								.add(lblCustomer)
								.add(lblSession)
								.add(lblDate)
								.add(lblRoute)
								.add(lblDriver)
								.add(lblVehicle))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(groupLayout.createParallelGroup(GroupLayout.LEADING)
								.add(vehicleCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(driverCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(sessionCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(routeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(customerCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(groupLayout.createSequentialGroup()
									.add(groupLayout.createParallelGroup(GroupLayout.TRAILING)
										.add(lblTotal)
										.add(groupLayout.createSequentialGroup()
											.add(dateCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.add(101)
											.add(lblReferenceNumber)))
									.add(18)
									.add(groupLayout.createParallelGroup(GroupLayout.LEADING)
										.add(totalOutputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.add(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.add(1)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.LEADING)
				.add(groupLayout.createSequentialGroup()
					.addContainerGap()
					.add(groupLayout.createParallelGroup(GroupLayout.TRAILING)
						.add(groupLayout.createSequentialGroup()
							.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
								.add(lblDate)
								.add(dateCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(lblReferenceNumber)
								.add(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
								.add(lblSession)
								.add(sessionCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.add(18)
							.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
								.add(lblRoute)
								.add(routeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.add(18)
							.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
								.add(lblCustomer)
								.add(customerCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.add(18)
							.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
								.add(lblDriver)
								.add(driverCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.add(18)
							.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
								.add(lblVehicle)
								.add(vehicleCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.add(32))
						.add(groupLayout.createParallelGroup(GroupLayout.BASELINE)
							.add(lblTotal)
							.add(totalOutputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.add(18)
					.add(tableGroup, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addContainerGap())
		);
		tableGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		lineItemTable = UIControlsFactory.createTable(tableGroup, SWT.NONE, DeliveryJournalEditBindContants.LINE_ITEM_TABLE);
		lineItemTable.setHeaderVisible(true);
		lineItemTable.setLinesVisible(true);
		
		TableColumn tblclmnBinId = new TableColumn(lineItemTable, SWT.CENTER);
		tblclmnBinId.setWidth(50);
		tblclmnBinId.setText("Bin ID");
		
		TableColumn tblclmnQuantity = new TableColumn(lineItemTable, SWT.CENTER);
		tblclmnQuantity.setWidth(75);
		tblclmnQuantity.setText("Quantity");
		
		TableColumn tblclmnDescription = new TableColumn(lineItemTable, SWT.CENTER);
		tblclmnDescription.setWidth(250);
		tblclmnDescription.setText("Description");
		setLayout(groupLayout);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
