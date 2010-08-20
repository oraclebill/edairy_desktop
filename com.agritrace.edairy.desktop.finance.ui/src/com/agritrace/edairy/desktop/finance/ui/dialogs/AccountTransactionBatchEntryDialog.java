package com.agritrace.edairy.desktop.finance.ui.dialogs;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
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
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.ContainerValidator;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanel;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanelController;

public class AccountTransactionBatchEntryDialog extends BaseDialogView {
	private final class TBEC extends BaseDialogController<AccountTransaction> {
		private List<AccountTransaction> transactions;

		@Override
		public void configureRidgets() {
			super.configureRidgets();

			final String[] headers = new String[] { "ID", "Source", "Date", "Reference #", "Member ", "Amount" };
			final String[] properties = new String[] {
					AccountPackage.Literals.TRANSACTION__TRANSACTION_ID.getName(),
					AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE.getName(),
					AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE.getName(),
					AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER.getName(),
					AccountPackage.Literals.TRANSACTION__ACCOUNT.getName(),
					AccountPackage.Literals.TRANSACTION__AMOUNT.getName() };

			@SuppressWarnings("unchecked")
			List<AccountTransaction> transactions = (List<AccountTransaction>) getContext("tranaction-list");
			this.transactions = transactions;
			
			final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
			
			if (master != null) {
				master.setDelegate(new TransactionBatchEntryDialogController());
				master.bindToModel(new WritableList(transactions, AccountTransaction.class), AccountTransaction.class,
						properties, headers);
				master.updateFromModel();

				final IActionRidget actionApply = master.getRidget(IActionRidget.class,
						AbstractMasterDetailsComposite.BIND_ID_APPLY);
				this.addDefaultAction(master, actionApply);
			}

			super.configureButtonsPanel();
			// We are inputting new data, no delete
			getRidget(DialogConstants.BIND_ID_BUTTON_DELETE).setVisible(false);
		}
		
		@Override
		protected boolean validate() {
			return super.validate() && !transactions.isEmpty();
		}
	}

	private final class TransactionBatchEntryDialogController extends AbstractMasterDetailsDelegate {
		private final AccountTransactionEditPanelController detailController;
		private final AccountTransaction workingCopy = createWorkingCopy();

		public TransactionBatchEntryDialogController() {
			detailController = new AccountTransactionEditPanelController();
		}

		@Override
		public void configureRidgets(IRidgetContainer container) {
			detailController.setModel(getWorkingCopy());
			detailController.setRidgetContainer(container);
			detailController.configureAndBind();
		}

		@Override
		public Object copyBean(Object source, Object target) {
			final AccountTransaction from = source != null ? (AccountTransaction) source : createWorkingCopy();
			final AccountTransaction to = target != null ? (AccountTransaction) target : createWorkingCopy();
			EMFUtil.copy(from, to, 1);
			return to;
		}

		@Override
		public AccountTransaction createWorkingCopy() {
			AccountTransaction transaction = AccountFactory.eINSTANCE.createAccountTransaction();
			transaction.setTransactionDate(new Date());
			return transaction;
		}

		@Override
		public AccountTransaction getWorkingCopy() {
			return workingCopy;
		}
		
		@Override
		public String isValid(IRidgetContainer container) {
			Collection<IMarkableRidget> errors = ContainerValidator.validateContainer(container);
			
			return errors.isEmpty() ? null : "There are errors in the form. Please correct them before pressing Apply.";
		}
	}

	public AccountTransactionBatchEntryDialog() {
		this(null);
	}

	public AccountTransactionBatchEntryDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		final Composite master = new MasterDetailsComposite(parent, SWT.TOP) {
			@Override
			protected void createDetails(Composite parent) {
				final Composite detailPanel = new AccountTransactionEditPanel(parent, SWT.NONE);
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