package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.LivestockEditDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.ProfilePhotoComposite;

public class LivestockEditDialog extends RecordDialog<RegisteredAnimal> {

	@Inject
	public LivestockEditDialog(@Named("current") final Shell parentShell, final LivestockEditDialogController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		createHeadlineGroup(parent);
		createTabFolderGroup(parent);
	}

	protected void createHeadlineGroup(Composite parent) {
		final Image lookupIcon = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON);

		final Composite headerPanel = UIControlsFactory.createComposite(parent);
		final GridLayout leftColumnLayout = new GridLayout();
		leftColumnLayout.numColumns = 2;
		leftColumnLayout.makeColumnsEqualWidth = false;
		leftColumnLayout.marginTop = 8;
		leftColumnLayout.marginLeft = 8;
		leftColumnLayout.marginRight = 8;
		leftColumnLayout.marginBottom = 8;
		headerPanel.setLayout(leftColumnLayout);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(headerPanel);

		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
				.indent(5, 0);
		final GridDataFactory fieldFactory = GridDataFactory.swtDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT)
				.span(2, 1).grab(false, false);

		// headline label
		final Label titleLabel = UIControlsFactory.createLabel(headerPanel, "Animal Name:");
		addUIControl(titleLabel, ViewWidgetId.LIVE_STOCK_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(3, 1).applyTo(titleLabel);
		final Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		Composite composite = UIControlsFactory.createComposite(headerPanel, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		composite.setLayout(new GridLayout(3, false));

		// body
		//

		// farm name
		final Label farmIdLabel = UIControlsFactory.createLabel(composite, "Name");
		labelFactory.applyTo(farmIdLabel);

		final Text idText = UIControlsFactory.createText(composite, SWT.BORDER | SWT.READ_ONLY,
				ViewWidgetId.LIVE_STOCK_NameText);
		idText.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		fieldFactory.applyTo(idText);

		//
		final Label memberLabel = UIControlsFactory.createLabel(composite, "Owner");
		labelFactory.applyTo(memberLabel);
		// member name text
		final Text searchText = UIControlsFactory.createText(composite, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		searchText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT).grab(false, false).applyTo(searchText);

		final ImageButton lookupButton = UIControlsFactory.createImageButton(composite, SWT.NULL,
				ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		lookupButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		lookupButton.setImage(lookupIcon);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).grab(false, false).applyTo(lookupButton);

		final Label farmLabel = UIControlsFactory.createLabel(composite, "Farm");
		farmLabel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		labelFactory.applyTo(farmLabel);

		final CCombo farmCombo = UIControlsFactory.createCCombo(composite, ViewWidgetId.LIVE_STOCK_FARM_COMBO);
		farmCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		fieldFactory.applyTo(farmCombo);

		final Label purposeLabel = UIControlsFactory.createLabel(composite, "Purpose");
		labelFactory.applyTo(purposeLabel);

		final CCombo purposeCombo = UIControlsFactory.createCCombo(composite, ViewWidgetId.LIVE_STOCK_PURPOSE_COMBO);
		purposeCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		fieldFactory.applyTo(purposeCombo);

		final Label statusLabel = UIControlsFactory.createLabel(composite, "Status");
		labelFactory.applyTo(statusLabel);

		final CCombo statusCombo = UIControlsFactory.createCCombo(composite); // ,
		statusCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		// ViewWidgetId.LIVE_STOCK_STATUS_COMBO);
		statusCombo.setItems(new String[] { "Calf", "Producing", "Dry" });
		fieldFactory.applyTo(statusCombo);

		ProfilePhotoComposite photoComposite = new ProfilePhotoComposite(headerPanel, 2, SWT.BORDER);
		addUIControl(photoComposite, ViewWidgetId.LIVESTOCK_PHOTO);

	}

	/**
	 * 
	 * @param parent
	 */
	protected void createTabFolderGroup(Composite parent) {
		final LiveStockTabFolder tabFolder = new LiveStockTabFolder(parent);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}
