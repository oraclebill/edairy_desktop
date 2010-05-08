package com.agritrace.edairy.dairy.ui.dialogs;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.dairy.ui.controllers.AddRouteDialogController;
import com.agritrace.edairy.dairy.ui.controllers.DairyLocationController;
import com.agritrace.edairy.dairy.ui.controllers.RouteListDialogController;

public class AddRouteDialog extends AbstractDialogView {
	private final static int WIDTH_UNIT = 100;
	
	private Composite contentArea;
	public AddRouteDialog() {
		super(null);
	}

	@Override
	protected Control buildView(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		contentArea = new Composite(parent, SWT.NONE);
		contentArea.setLayout(new GridLayout(2, false));

		/*Label idLabel = UIControlsFactory.createLabel(contentArea, "Id", SWT.LEFT);
		Text idText = UIControlsFactory.createText(contentArea, SWT.BORDER| SWT.SINGLE, AddRouteDialogController.RIDGET_ID_ROUTE_ID);
		GridData gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		idText.setEditable(false);
		idText.setLayoutData(gd);*/
		
		Label nameLabel = UIControlsFactory.createLabel(contentArea, "Name", SWT.LEFT);
		Text nameText = UIControlsFactory.createText(contentArea, SWT.BORDER| SWT.SINGLE, AddRouteDialogController.RIDGET_ID_NAME);
		GridData gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		nameText.setLayoutData(gd);
		
		Label descriptionLabel = UIControlsFactory.createLabel(contentArea, "Description", SWT.LEFT | SWT.TOP);
		gd = new GridData();
		gd.verticalAlignment = GridData.FILL_VERTICAL;
		descriptionLabel.setLayoutData(gd);
		
		Text descriptionText = UIControlsFactory.createTextMulti(contentArea, false, false, AddRouteDialogController.RIDGET_ID_DESCRIPTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT* 3;
		gd.heightHint = 60;
		descriptionText.setLayoutData(gd);
		
		Label codeLabel = UIControlsFactory.createLabel(contentArea, "Code", SWT.LEFT | SWT.TOP);
		gd = new GridData();
		gd.verticalAlignment = GridData.FILL_VERTICAL;
		codeLabel.setLayoutData(gd);
		
		Text codeText = UIControlsFactory.createTextMulti(contentArea, false, false, AddRouteDialogController.RIDGET_ID_CODE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		codeText.setLayoutData(gd);
		
		Button saveButton = UIControlsFactory.createButton(contentArea, "Save", AddRouteDialogController.RIDGET_ID_SAVE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		saveButton.setLayoutData(gd);
		
		Button cancelButton = UIControlsFactory.createButton(contentArea, "Cancel", AddRouteDialogController.RIDGET_ID_CANCEL);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		cancelButton.setLayoutData(gd);

		createMessageBoxes();
		return contentArea;
	}

	private void createMessageBoxes()
	{
		MessageBox nameErrorMessage = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(nameErrorMessage, AddRouteDialogController.RIDGET_ID_DUPLICATE_NAME_DIALOG);
	}
	@Override
	protected AbstractWindowController createController() {
		return new AddRouteDialogController();
	}

}
