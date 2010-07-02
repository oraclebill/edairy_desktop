package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkCollectionLogFilterPanel extends Composite {

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MilkCollectionLogFilterPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		final Group grpSearch = UIControlsFactory.createGroup(this, "Search");

		final Label lblStartDate = UIControlsFactory.createLabel(grpSearch, "Start Date", SWT.NONE);

		final DateTime startDate = UIControlsFactory.createDate(grpSearch, SWT.MEDIUM);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(startDate,
				ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);

		final Label lblEndDate = UIControlsFactory.createLabel(grpSearch, "End Date");

		final DateTime endDate = UIControlsFactory.createDate(grpSearch, SWT.MEDIUM);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(endDate,
				ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);

		final Combo routeCombo = UIControlsFactory.createCombo(grpSearch);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(routeCombo,
				ViewConstants.COLLECTION_FILTER_ROUTE_COMBO);

		final Label lblRoute = UIControlsFactory.createLabel(grpSearch, "Route");

		final Button btnSearch = UIControlsFactory.createButton(grpSearch);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSearch.setText("Search");
		SWTBindingPropertyLocator.getInstance().setBindingProperty(btnSearch,
				AbstractDirectoryView.BIND_ID_FILTER_SEARCH);

		final Button btnReset = UIControlsFactory.createButton(grpSearch);
		btnReset.setText("Reset");
		SWTBindingPropertyLocator.getInstance()
				.setBindingProperty(btnReset, AbstractDirectoryView.BIND_ID_FILTER_RESET);

		final Label lblMprMissing = new Label(grpSearch, SWT.NONE);
		lblMprMissing.setText("MPR Missing");

		final Button button = UIControlsFactory.createButtonCheck(grpSearch);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button,
				ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);

		final Label lblMprMissing_1 = UIControlsFactory.createLabel(grpSearch, "Suspended");

		final Button button_1 = UIControlsFactory.createButtonCheck(grpSearch);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button_1,
				ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);

		final Label lblRejected = UIControlsFactory.createLabel(grpSearch, "Rejected");

		final Button button_2 = UIControlsFactory.createButtonCheck(grpSearch);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button_2,
				ViewConstants.COLLECTION_FILTER_REJECTED_CHK);

		final GroupLayout gl_grpSearch = new GroupLayout(grpSearch);
		gl_grpSearch
				.setHorizontalGroup(gl_grpSearch.createParallelGroup(GroupLayout.LEADING).add(
						gl_grpSearch
								.createSequentialGroup()
								.addContainerGap()
								.add(gl_grpSearch
										.createParallelGroup(GroupLayout.LEADING)
										.add(GroupLayout.TRAILING,
												gl_grpSearch
														.createSequentialGroup()
														.add(lblStartDate)
														.addPreferredGap(LayoutStyle.RELATED)
														.add(startDate, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.add(18))
										.add(gl_grpSearch.createSequentialGroup().add(lblMprMissing).add(12)
												.add(button).addPreferredGap(LayoutStyle.RELATED)))
								.add(4)
								.add(gl_grpSearch
										.createParallelGroup(GroupLayout.TRAILING)
										.add(gl_grpSearch
												.createSequentialGroup()
												.add(lblEndDate)
												.addPreferredGap(LayoutStyle.RELATED)
												.add(endDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE).add(18))
										.add(gl_grpSearch.createSequentialGroup().add(lblMprMissing_1)
												.addPreferredGap(LayoutStyle.UNRELATED).add(button_1).add(65)))
								.add(gl_grpSearch
										.createParallelGroup(GroupLayout.TRAILING, false)
										.add(gl_grpSearch
												.createSequentialGroup()
												.add(lblRoute)
												.addPreferredGap(LayoutStyle.RELATED)
												.add(routeCombo, GroupLayout.PREFERRED_SIZE, 136,
														GroupLayout.PREFERRED_SIZE).add(33).add(btnSearch))
										.add(gl_grpSearch
												.createSequentialGroup()
												.addPreferredGap(LayoutStyle.RELATED)
												.add(lblRejected)
												.addPreferredGap(LayoutStyle.RELATED)
												.add(button_2)
												.addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE).add(btnReset))).add(24)));
		gl_grpSearch.setVerticalGroup(gl_grpSearch.createParallelGroup(GroupLayout.LEADING).add(
				gl_grpSearch
						.createSequentialGroup()
						.add(21)
						.add(gl_grpSearch
								.createParallelGroup(GroupLayout.LEADING)
								.add(btnSearch)
								.add(routeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_grpSearch.createSequentialGroup().add(4).add(lblRoute))
								.add(gl_grpSearch
										.createParallelGroup(GroupLayout.BASELINE)
										.add(lblStartDate)
										.add(startDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.add(lblEndDate)
										.add(endDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.add(gl_grpSearch
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_grpSearch
										.createSequentialGroup()
										.addPreferredGap(LayoutStyle.RELATED)
										.add(gl_grpSearch
												.createParallelGroup(GroupLayout.LEADING)
												.add(button)
												.add(gl_grpSearch.createParallelGroup(GroupLayout.BASELINE)
														.add(button_1).add(lblMprMissing_1)).add(button_2)
												.add(btnReset)))
								.add(gl_grpSearch.createSequentialGroup().add(8).add(lblMprMissing))
								.add(gl_grpSearch.createSequentialGroup().add(8).add(lblRejected)))
						.addContainerGap(30, Short.MAX_VALUE)));
		grpSearch.setLayout(gl_grpSearch);
		addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				// toolkit.dispose();
			}
		});

	}
}
