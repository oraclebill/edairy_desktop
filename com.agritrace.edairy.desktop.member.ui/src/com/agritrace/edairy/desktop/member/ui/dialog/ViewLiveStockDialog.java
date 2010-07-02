package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewLiveStockDialogController;

public class ViewLiveStockDialog extends BaseDialogView {
	

	public ViewLiveStockDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		createHeadlineGroup(parent);
		createTabFolderGroup(parent);
	}

	@Override
	protected AbstractWindowController createController() {
		// TODO Auto-generated method stub
		return new ViewLiveStockDialogController();
	}
	
	protected void createHeadlineGroup(Composite parent){
		Composite headerPanel = UIControlsFactory.createComposite(parent);
		final GridLayout leftColumnLayout = new GridLayout();
		leftColumnLayout.numColumns = 2;
		leftColumnLayout.makeColumnsEqualWidth = false;
		leftColumnLayout.marginTop = 8;
		leftColumnLayout.marginLeft = 8;
		leftColumnLayout.marginRight = 8;
		leftColumnLayout.marginBottom = 8;
		headerPanel.setLayout(leftColumnLayout);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(headerPanel);
		

		GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT)
				.indent(5, 0);
		GridDataFactory fieldFactory = GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT);


		Label titleLabel = UIControlsFactory.createLabel(headerPanel, "Animal Name:");
		addUIControl(titleLabel, ViewWidgetId.LIVE_STOCK_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2,1).applyTo(titleLabel);
		Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);
		
		Label farmIdLabel = UIControlsFactory.createLabel(headerPanel, "Name:");
		labelFactory.applyTo(farmIdLabel);
		
		
		Text idText = UIControlsFactory.createText(headerPanel,SWT.BORDER|SWT.READ_ONLY,ViewWidgetId.LIVE_STOCK_NameText);
		fieldFactory.applyTo(idText);

		Label memberIdLabel = UIControlsFactory.createLabel(headerPanel, "Farm:");
		labelFactory.applyTo(memberIdLabel);
		
		Combo farmCombo = UIControlsFactory.createCombo(headerPanel, ViewWidgetId.LIVE_STOCK_FARM_COMBO);
		fieldFactory.applyTo(farmCombo);
		
		Label purposeLabel = UIControlsFactory.createLabel(headerPanel, "Purpose:");
		labelFactory.applyTo(purposeLabel);
		
		Combo purposeCombo = UIControlsFactory.createCombo(headerPanel, ViewWidgetId.LIVE_STOCK_PURPOSE_COMBO);
		fieldFactory.applyTo(purposeCombo);
		
		Label statusLabel = UIControlsFactory.createLabel(headerPanel, "Status:");
		labelFactory.applyTo(statusLabel);
		
		Combo statusCombo = UIControlsFactory.createCombo(headerPanel, ViewWidgetId.LIVE_STOCK_STATUS_COMBO);
		fieldFactory.applyTo(statusCombo);
		
	}
	
	protected void createTabFolderGroup(Composite parent){
		LiveStockTabFolder tabFolder = new LiveStockTabFolder(parent);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}
