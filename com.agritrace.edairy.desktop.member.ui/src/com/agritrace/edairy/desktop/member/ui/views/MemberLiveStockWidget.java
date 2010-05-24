package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.common.ui.views.DateRangeSearchWidget;

public class MemberLiveStockWidget {

	private Composite composite;
	
	public static final String ADD_BUTTON="Add &Live Stock";
	public static final String REMOVE_BUTTON="&Remove";
	public static final String VIEW_BUTTON="&View";

	public MemberLiveStockWidget(Composite parent){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1,true));
		initGUI();
	}

	public void initGUI(){
		// filter panel
		final Composite filterPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterPanel);
		filterPanel.setLayout(new GridLayout(2, false));

		DateRangeSearchWidget dateRangeWidget = new DateRangeSearchWidget(filterPanel, "Acqusion Date Range: ", ViewWidgetId.LIVESTOCK_FILTER_STARTDATE,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON, ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false).applyTo(dateRangeWidget.getComposite());
	
		Composite filterPanel2= UIControlsFactory.createComposite(filterPanel,SWT.NULL);
		filterPanel2.setLayout(new GridLayout(3,false));
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(true, false).applyTo(filterPanel2);
	
		final Combo farmCombo = UIControlsFactory.createCombo(filterPanel2, ViewWidgetId.LIVESTOCK_FarmCombo);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(farmCombo);

		final Combo speciesText = UIControlsFactory.createCombo(filterPanel2, ViewWidgetId.LIVESTOCK_ContainerSpeciesFilter);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(speciesText);

		final Combo breedText = UIControlsFactory.createCombo(filterPanel2,ViewWidgetId.LIVESTOCK_ContainerBreedFilter);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(breedText);

		final Composite containerPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(containerPanel);
		final Table table = UIControlsFactory.createTable(containerPanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.LIVESTOCK_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnID = new TableColumn(table, SWT.LEFT);
		final TableColumn columnFarm = new TableColumn(table, SWT.LEFT);
		final TableColumn columnPurpose = new TableColumn(table, SWT.LEFT);
		final TableColumn columnName = new TableColumn(table, SWT.LEFT);
		final TableColumn columnSpecies = new TableColumn(table, SWT.LEFT);
		final TableColumn columnBreed = new TableColumn(table, SWT.LEFT);
		final TableColumn columnAcquisionDate = new TableColumn(table, SWT.LEFT);
		final TableColumn columnAcquisionType = new TableColumn(table, SWT.LEFT);

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnID, new ColumnWeightData(9));
		layout.setColumnData(columnFarm, new ColumnWeightData(13));
		layout.setColumnData(columnPurpose, new ColumnWeightData(13));
		layout.setColumnData(columnName, new ColumnWeightData(13));
		layout.setColumnData(columnSpecies, new ColumnWeightData(13));
		layout.setColumnData(columnBreed, new ColumnWeightData(13));
		layout.setColumnData(columnAcquisionDate, new ColumnWeightData(13));
		layout.setColumnData(columnAcquisionType, new ColumnWeightData(13));
		containerPanel.setLayout(layout);

		final Composite addbuttonsPanel = UIControlsFactory.createComposite(composite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.BOTTOM).grab(false, false).applyTo(addbuttonsPanel);
		addbuttonsPanel.setLayout(new GridLayout(3, false));

		final Button addButton = UIControlsFactory.createButton(addbuttonsPanel, ADD_BUTTON, ViewWidgetId.LIVESTOCK_ADD);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).grab(true, false).applyTo(addButton);
		
		final Button viewButton = UIControlsFactory.createButton(addbuttonsPanel, VIEW_BUTTON, ViewWidgetId.LIVESTOCK_VIEW);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).grab(true, false).applyTo(viewButton);

		final Button removeButton = UIControlsFactory.createButton(addbuttonsPanel, REMOVE_BUTTON,ViewWidgetId.LIVESTOCK_Remove);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).grab(false, false).applyTo(removeButton);

	}

	public Composite getComposite() {
		return composite;
	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}
}