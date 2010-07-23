package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.controls.DateRangeSearchWidget;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockFilterWidget {

	private Composite composite;

	public LiveStockFilterWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		final GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		final DateRangeSearchWidget dateRangeWidget = new DateRangeSearchWidget(composite, "Acqusion Date Range: ",
				ViewWidgetId.LIVESTOCK_FILTER_STARTDATE, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE,
				ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false)
				.applyTo(dateRangeWidget.getComposite());

		final Composite filterPanel2 = UIControlsFactory.createComposite(composite, SWT.NULL);
		filterPanel2.setLayout(new GridLayout(3, false));
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(true, false).applyTo(filterPanel2);

		final Combo farmCombo = UIControlsFactory.createCombo(filterPanel2, ViewWidgetId.LIVESTOCK_FarmFilterCombo);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(farmCombo);

		final Combo speciesText = UIControlsFactory.createCombo(filterPanel2,
				ViewWidgetId.LIVESTOCK_ContainerSpeciesFilter);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(speciesText);

		final Combo statusText = UIControlsFactory.createCombo(filterPanel2,
				ViewWidgetId.LIVESTOCK_ContainerStatusFilter);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(statusText);

		// search cancel button
		final Composite searchPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(3, 1).applyTo(searchPanel);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(searchPanel);

		final Button searchButton = UIControlsFactory.createButton(searchPanel, "Search",
				BaseListView.BIND_ID_FILTER_SEARCH);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(searchButton);

		final Button cancelButton = UIControlsFactory.createButton(searchPanel, "Clear", BaseListView.BIND_ID_FILTER_RESET);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(cancelButton);

	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}

}
