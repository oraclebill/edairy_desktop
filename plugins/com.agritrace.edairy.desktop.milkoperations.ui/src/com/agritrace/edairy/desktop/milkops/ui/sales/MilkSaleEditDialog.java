package com.agritrace.edairy.desktop.milkops.ui.sales;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MilkSaleEditDialog extends RecordDialog<MilkSale> {

	public static class MilkSaleEditDialogController extends RecordDialogController<MilkSale> {
		private final MilkSaleEditPanelController panelController;

		@Inject
		public MilkSaleEditDialogController(final MilkSaleEditPanelController panelController) {
			super("Milk Sales");
			this.panelController = panelController;
			setReturnCode(ACTION_CANCEL);
		}

		@Override
		protected void configureUserRidgets() {
			panelController.setModel(getWorkingCopy());
			panelController.setRidgetContainer(this);
		}

		@Override
		protected void handleSaveAction() {
			panelController.checkValid();
			super.handleSaveAction();
		}

		@Override
		public void afterBind() {
			super.afterBind();
			panelController.configureAndBind();
		}

	}

	@Inject
	public MilkSaleEditDialog(final @Named("current") Shell parentShell, final MilkSaleEditDialogController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
//		GridDataFactory.fillDefaults().grab(true, false).applyTo(
				new MilkSaleEditPanel(comp, SWT.NONE);
//				);
	}

}
