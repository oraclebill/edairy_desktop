package com.agritrace.edairy.desktop.dairy.locations.ui.dialogs;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.MessageBox;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("unused")
public class AddRouteDialog extends AbstractDialogView {
    private final static int WIDTH_UNIT = 100;

    private Composite contentArea;
    private AbstractWindowController myController;

    public AddRouteDialog(AbstractWindowController controller) {
	super(null);
	myController = controller;
    }

    @Override
    protected Control buildView(Composite parent) {
	parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	contentArea = new Composite(parent, SWT.NONE);
	contentArea.setLayout(new GridLayout(2, false));

	/*
	 * Label idLabel = UIControlsFactory.createLabel(contentArea, "Id",
	 * SWT.LEFT); Text idText = UIControlsFactory.createText(contentArea,
	 * SWT.BORDER| SWT.SINGLE, AddRouteDialogController.RIDGET_ID_ROUTE_ID);
	 * GridData gd = new GridData(); gd.widthHint = WIDTH_UNIT;
	 * idText.setEditable(false); idText.setLayoutData(gd);
	 */

	final Label nameLabel = UIControlsFactory.createLabel(contentArea, "Name", SWT.LEFT);
	final Text nameText = UIControlsFactory.createText(contentArea, SWT.BORDER | SWT.SINGLE,
		AddRouteDialogIDs.RIDGET_ID_NAME);
	GridData gd = new GridData();
	gd.widthHint = WIDTH_UNIT * 3;
	nameText.setLayoutData(gd);

	final Label descriptionLabel = UIControlsFactory.createLabel(contentArea, "Description", SWT.LEFT | SWT.TOP);
	gd = new GridData();
	gd.verticalAlignment = GridData.FILL_VERTICAL;
	descriptionLabel.setLayoutData(gd);

	final Text descriptionText = UIControlsFactory.createTextMulti(contentArea, false, false,
		AddRouteDialogIDs.RIDGET_ID_DESCRIPTION);
	gd = new GridData();
	gd.widthHint = WIDTH_UNIT * 3;
	gd.heightHint = 60;
	descriptionText.setLayoutData(gd);

	final Label codeLabel = UIControlsFactory.createLabel(contentArea, "Code", SWT.LEFT | SWT.TOP);
	gd = new GridData();
	gd.verticalAlignment = GridData.FILL_VERTICAL;
	codeLabel.setLayoutData(gd);

	final Text codeText = UIControlsFactory.createTextMulti(contentArea, false, false,
		AddRouteDialogIDs.RIDGET_ID_CODE);
	gd = new GridData();
	gd.widthHint = WIDTH_UNIT;
	codeText.setLayoutData(gd);

	final Button saveButton = UIControlsFactory.createButton(contentArea, "Save",
		AddRouteDialogIDs.RIDGET_ID_SAVE);
	gd = new GridData();
	gd.widthHint = WIDTH_UNIT;
	saveButton.setLayoutData(gd);

	final Button cancelButton = UIControlsFactory.createButton(contentArea, "Cancel",
		AddRouteDialogIDs.RIDGET_ID_CANCEL);
	gd = new GridData();
	gd.widthHint = WIDTH_UNIT;
	cancelButton.setLayoutData(gd);

	createMessageBoxes();
	return contentArea;
    }

    private void createMessageBoxes() {
	final MessageBox nameErrorMessage = UIControlsFactory.createMessageBox(contentArea);
	this.addUIControl(nameErrorMessage, AddRouteDialogIDs.RIDGET_ID_DUPLICATE_NAME_DIALOG);
    }

    @Override
    protected AbstractWindowController createController() {
	return myController;
    }

}
