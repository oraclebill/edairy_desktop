package com.agritrace.edairy.desktop.finance.ui.dialogs;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.finance.ui.controls.TransactionEntryPanel;
import com.agritrace.edairy.desktop.finance.ui.controls.TransactionEntryPanelController;

public class TransactionBatchEntryDialog extends BaseDialogView {

	private final class TBEC extends AbstractWindowController {
		@Override
		public void configureRidgets() {
			super.configureRidgets();
			
			final String[] headers = new String[] { "ID", "Source", "Date", "Reference #", "Member ", "Amount" };
			final String[] properties = new String[] { 
					AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID.getName(),
					AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE.getName(),
					AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE.getName(), 
					AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER.getName(),
					AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT.getName(),
					AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT.getName() };

			List<AccountTransaction> transactions = (List<AccountTransaction>) getContext("tranaction-list");
			final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
			if (master != null) {
				master.setDelegate(new TransactionBatchEntryDialogController2());
				master.bindToModel(new WritableList(transactions, AccountTransaction.class), AccountTransaction.class, properties, headers);
				master.updateFromModel();

				final IActionRidget actionApply = master.getRidget(IActionRidget.class,
						AbstractMasterDetailsComposite.BIND_ID_APPLY);
				this.addDefaultAction(master, actionApply);
			}

		}
	}


	private final class TransactionBatchEntryDialogController2 extends AbstractMasterDetailsDelegate {
		private final TransactionEntryPanelController detailController;
		private final AccountTransaction workingCopy = createWorkingCopy();

		public TransactionBatchEntryDialogController2() {
			detailController = new TransactionEntryPanelController();
		}
		
		@Override
		public void configureRidgets(IRidgetContainer container) {
			detailController.setModel(getWorkingCopy());
			detailController.setRidgetContainer(container);	
			detailController.configureAndBind();
		}

		@Override
		public AccountTransaction createWorkingCopy() {
			return AccountFactory.eINSTANCE.createAccountTransaction();
		}

		@Override
		public Object copyBean(Object source, Object target) {
			final AccountTransaction from = source != null ? (AccountTransaction) source : createWorkingCopy();
			final AccountTransaction to = target != null ? (AccountTransaction) target : createWorkingCopy();
			EMFUtil.copy(from, to, 1);
			return to;
		}

		@Override
		public AccountTransaction getWorkingCopy() {
			return workingCopy;
		}
	}

	public TransactionBatchEntryDialog() {
		this(null);
	}

	public TransactionBatchEntryDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		final Composite master = new MasterDetailsComposite(parent, SWT.TOP) {
			@Override
			protected void createDetails(Composite parent) {
				final Composite detailPanel = new TransactionEntryPanel(parent, SWT.NONE);
				GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(detailPanel);
				GridLayoutFactory.fillDefaults().generateLayout(parent);
			}
		};
		addUIControl(master, "master");
		GridLayoutFactory.fillDefaults().generateLayout(master);
	}


	@Override
	protected AbstractWindowController createController() {
		return new TBEC();
	}

}