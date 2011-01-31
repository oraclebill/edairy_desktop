package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.util.Calendar;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.persistence.dao.IMemberPaymentsRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.ITransactionRepository;
import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.finance.payments.MemberCollectionsManager;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.google.inject.Inject;

public class PWSelectPaymentPeriod extends PWPage {

	public static final String[] MONTHS = new String[] { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December", };

	public static final String PAYMENT_MONTH = "paymentMonth";
	public static final String PAYMENT_YEAR = "paymentYear";

	private final IMemberPaymentsRepository paymentsRepo;
	private final ITransactionRepository transactionRepo;
	private final MemberCollectionsManager collectionsManager;

	/**
	 * Create the wizard.
	 *
	 * @param wizardModel
	 * @param pmtRepo
	 */
	@Inject
	public PWSelectPaymentPeriod(IMemberPaymentsRepository pmtRepo, ITransactionRepository transactionRepo,
			MemberCollectionsManager collectionsManager) {
		super("paymentPeriod");
		setTitle("Select Payment Period");
		setDescription("Select the payment period you want to calculate member payments for.");
		this.paymentsRepo = pmtRepo;
		this.transactionRepo = transactionRepo;
		this.collectionsManager = collectionsManager;
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		basicCreateControl(parent);
	}

	private void basicCreateControl(Composite parent) {
		final Composite container = UIControlsFactory.createComposite(parent, SWT.NULL);
		final FormLayout topLayout = new FormLayout();
		topLayout.marginWidth = 10;
		topLayout.marginHeight = 10;
		container.setLayout(topLayout);

		final Composite comp = UIControlsFactory.createComposite(container, SWT.NULL);
		comp.setLayout(new GridLayout(1, false));
		{
			final Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			final Label lbl = UIControlsFactory.createLabel(row, "Year");
			GridDataFactory.defaultsFor(lbl).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lbl);

			final Combo control = UIControlsFactory.createCombo(row, MilkPriceJournalConstants.ID_COMBO_RATEYEAR);
			GridDataFactory.defaultsFor(control).grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(control);
			final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			final String[] items = new String[5];
			int count = 0;
			
			for (int i = currentYear - 2; i < currentYear + 3; i++) {
				items[count++] = String.valueOf(i);
			}
			
			control.setItems(items);
			int paymentYear;
			
			try {
				paymentYear = getInt(PAYMENT_YEAR);
				control.setText(items[currentYear - paymentYear + 2]);
			} catch (final ArrayIndexOutOfBoundsException aioobe) {
				control.setText(items[2]);
				put(PAYMENT_YEAR, items[2]);
			}

			control.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int selected = control.getSelectionIndex();
					if (selected >= 0) {
						selected -= 2;
						put(PAYMENT_YEAR, currentYear + selected);
						validateModel();
					}
				}
			});

		}
		{
			final Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			final Label lblMonth = UIControlsFactory.createLabel(row, "Month");
			GridDataFactory.defaultsFor(lblMonth).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lblMonth);

			final Combo control = UIControlsFactory.createCombo(row, MilkPriceJournalConstants.ID_COMBO_RATEMONTH);
			GridDataFactory.defaultsFor(control).grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(control);
			final int paymentMonth = getInt(PAYMENT_MONTH);
			control.setItems(MONTHS);
			control.setText(MONTHS[paymentMonth]);
			control.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					final int selected = control.getSelectionIndex();
					
					if (selected >= 0) {
						put(PAYMENT_MONTH, selected);
						validateModel();
					}
				}
			});
		}

		final FormData compData = new FormData();
		compData.top = new FormAttachment(20);
		compData.right = new FormAttachment(80);
		compData.bottom = new FormAttachment(80);
		compData.left = new FormAttachment(20);
		comp.setLayoutData(compData);

		setControl(container);
		validateModel();

	}

	private void validateModel() {
		final int paymentYear = getInt(PAYMENT_YEAR);
		final int paymentMonth = getInt(PAYMENT_MONTH);

		final MemberPayment paymentRecord = paymentsRepo.getPaymentForPeriod(paymentYear, paymentMonth);
		
		if (paymentRecord != null) {
			final Employee first = paymentRecord.getEnteredBy();
			setErrorMessage(String.format(
					"A payment run for the selected period was already executed on %s by %s %s (%s).",
					paymentRecord.getEntryDate(), first.getGivenName(), first.getFamilyName(), first.getEmployeeNumber()));
			setPageComplete(false);
			return;
		}
		
		List<Membership> flaggedMembers = collectionsManager.getFlaggedMembers(paymentMonth, paymentYear);
		
		if (!flaggedMembers.isEmpty()) {
			String message = "Some members have flagged deliveries for this month. Please correct them before proceeding.";
			
			for (Membership member: flaggedMembers) {
				message += "\n - " + MemberUtil.formattedMemberName(member.getMember());
			}
			
			setErrorMessage(message);
			setPageComplete(false);
			return;
		}
			
		List<Membership> members = collectionsManager.getActiveMembers(paymentMonth, paymentYear);
		
		if (members.isEmpty()) {
			setErrorMessage("There are no transactions or milk collections for this time period. Please select an active period.");
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);
		}
	}

}
