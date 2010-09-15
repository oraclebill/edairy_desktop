package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;

public class AdjustmentTransactionEditPanel extends AbstractTransactionEditPanel {
	public AdjustmentTransactionEditPanel(Composite parent, int style) {
		super(parent, style);
		Group middlePanel = getContentArea();
		middlePanel.setText("Account Adjustment");
		
		addDateField();
		addMemberField();
		addChoiceField("Adjustment type");
		addAmountField();
		addDescriptionField("Reason");
		addSignedField("Signed off by");
		
		final Composite alert = UIControlsFactory.createComposite(middlePanel, SWT.BORDER,
				FinanceBindingConstants.ID_TRANSACTION_ALERT_FRAME);
		final Color background = new Color(getDisplay(), 255, 200, 200);
		alert.setBackground(background);
		GridLayoutFactory.fillDefaults().numColumns(2).margins(6, 6).spacing(12, 0).applyTo(alert);
		GridDataFactory.fillDefaults().grab(true, true).span(3, 1).applyTo(alert);
		
		final Label imageLabel = UIControlsFactory.createLabel(alert, "");
		imageLabel.setBackground(background);
		imageLabel.setImage(getSWTImage(SWT.ICON_WARNING));
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).applyTo(imageLabel);
		
		final String text = "Adjusting this member's account will affect the credit balance. " +
				"This operation cannot be deleted or edited. Only press Save after checking your data for correctness."; 
		final Label label = UIControlsFactory.createLabel(alert, text, SWT.WRAP);
		label.setBackground(background);
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).hint(350, SWT.DEFAULT).applyTo(label);
	}

	private Image getSWTImage(final int imageID) {
		final Display display = getDisplay();
		final Image[] image = new Image[1];
		
		display.syncExec(new Runnable () {
			public void run() {
				image[0] = display.getSystemImage(imageID);
			}
		});
		
		return image[0];
	}
}