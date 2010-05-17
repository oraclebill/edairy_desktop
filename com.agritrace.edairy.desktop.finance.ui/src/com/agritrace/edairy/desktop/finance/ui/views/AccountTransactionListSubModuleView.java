package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.navigation.ui.swt.presentation.SwtViewProvider;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.controllers.TransactionRegisterSubModuleController;

public class AccountTransactionListSubModuleView extends AbstractDirectoryView implements ViewConstants {

    public final static String ID = "dairy.transactions.register";

    private Table searchResultTable;

    private Text lastNameText, firstNameText;

    @Override
    public void basicCreatePartControl(Composite parent) {
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	GridLayout masterLayout = new GridLayout();
	masterLayout.numColumns = 2;
	parent.setLayout(masterLayout);
	
	Composite filterPanel 	= UIControlsFactory.createComposite(parent);
	Composite filterButtonsPanel 	= UIControlsFactory.createComposite(parent);
	Composite gridPanel 	= UIControlsFactory.createComposite(parent);
	Composite buttonPanel 	= UIControlsFactory.createComposite(parent);
	
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false)
		.applyTo(filterPanel);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false)
		.applyTo(filterButtonsPanel);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2,1)
		.applyTo(gridPanel);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2,1)
		.applyTo(buttonPanel);
	
	setupFilterPanel(filterPanel);
	setupFilterButtonsPanel(filterButtonsPanel);
	setupListPanel(gridPanel);
	setupButtonPanel(buttonPanel);

	parent.setTabList(new Control[] { filterPanel, gridPanel, buttonPanel } );	
    }
    
    protected void setupFilterPanel(Composite parent) 
    {
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	FormLayout layout = new FormLayout();
	layout.marginWidth = layout.marginHeight = 10;
	parent.setLayout(layout);

	Label lastNameLabel = new Label(parent, SWT.LEFT);
	lastNameLabel.setText("Last Name");
	lastNameLabel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	FormData fd = new FormData();
	fd.top = new FormAttachment(0, 0);
	fd.left = new FormAttachment(0, 0);
	lastNameLabel.setLayoutData(fd);

	lastNameText = new Text(parent, SWT.BORDER | SWT.SINGLE);
	fd = new FormData();
	fd.top = new FormAttachment(lastNameLabel, 0, SWT.CENTER);
	fd.left = new FormAttachment(lastNameLabel, 5, SWT.RIGHT);
	fd.width = FIELD_WIDTH;
	lastNameText.setLayoutData(fd);
	addUIControl(lastNameText, "lastNameRidget");

	Label firstNameLabel = new Label(parent, SWT.LEFT);
	firstNameLabel.setText("First Name");
	firstNameLabel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	fd = new FormData();
	fd.top = new FormAttachment(lastNameText, 0, SWT.CENTER);
	fd.left = new FormAttachment(lastNameText, 20, SWT.RIGHT);
	firstNameLabel.setLayoutData(fd);

	firstNameText = new Text(parent, SWT.BORDER | SWT.SINGLE);
	fd = new FormData();
	fd.top = new FormAttachment(firstNameLabel, 0, SWT.CENTER);
	fd.left = new FormAttachment(firstNameLabel, 5, SWT.RIGHT);
	fd.width = FIELD_WIDTH;
	firstNameText.setLayoutData(fd);
	addUIControl(firstNameText, "firstNameRidget");

    }

    protected void setupFilterButtonsPanel(Composite parent) {
	FormData fd;
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
	parent.setLayout(new FillLayout());
	
	Button clearButton = new Button(parent, 0);
	clearButton.setText("Clear");
	addUIControl(clearButton, "clearAction");

	Button searchButton = new Button(parent, 0);
	searchButton.setText("Search");
	addUIControl(searchButton, "searchAction");


    }

    protected void setupListPanel(Composite parent) 
    {
	parent.setLayout(new FillLayout());
	// create table
	searchResultTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
	searchResultTable.setLinesVisible(true);

	addUIControl(searchResultTable, "tableRidget");
	TableColumn customerNumberColumn = new TableColumn(searchResultTable, SWT.CENTER);
	TableColumn lastNameColumn = new TableColumn(searchResultTable, SWT.LEFT);
	TableColumn firstNameColumn = new TableColumn(searchResultTable, SWT.LEFT);
	TableColumn phoneColumn = new TableColumn(searchResultTable, SWT.CENTER);
	customerNumberColumn.setWidth(80);
	firstNameColumn.setWidth(120);
	lastNameColumn.setWidth(120);
	phoneColumn.setWidth(100);
	searchResultTable.setHeaderVisible(true);	
    }
    
    protected void setupButtonPanel(Composite parent) {
	FormData fd;
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
	parent.setLayout(new RowLayout());
	
	// open button
	Button openButton = new Button(parent, 0);
	openButton.setText("View");
	addUIControl(openButton, "openAction");

    }

    private ISubModuleNode getNode() {
	return SwtViewProvider.getInstance().getNavigationNode(this.getViewSite().getId(),
		this.getViewSite().getSecondaryId(), ISubModuleNode.class);
    }


    @Override
    public void setFocus() {
	super.setFocus();
    }

    @Override
    protected SubModuleController createController(ISubModuleNode subModuleNode) {
	return new TransactionRegisterSubModuleController(getNode());
    }
}
