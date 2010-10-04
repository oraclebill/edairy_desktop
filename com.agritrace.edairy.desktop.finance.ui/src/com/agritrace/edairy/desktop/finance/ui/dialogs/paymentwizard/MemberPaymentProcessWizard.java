package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.persistence.finance.IMemberPaymentsRepository;


public class MemberPaymentProcessWizard extends Wizard {

	
	static class PaymentWizardModel {
		public static final String[] MONTHS = new String[] { "January", "February",
			"March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December", };

		private int paymentMonth;
		private int paymentYear;
		private BigDecimal paymentRate;
		private List<AccountTransaction> payments; 
		
		public String[] getMonths() {
			return MONTHS;
		}

		public int getPaymentMonth() {
			return paymentMonth;
		}

		public void setPaymentMonth(int paymentMonth) {
			this.paymentMonth = paymentMonth;
		}

		public int getPaymentYear() {
			return paymentYear;
		}

		public void setPaymentYear(int paymentYear) {
			this.paymentYear = paymentYear;
		}

		public BigDecimal getPaymentRate() {
			return paymentRate;
		}

		public void setPaymentRate(BigDecimal paymentRate) {
			this.paymentRate = paymentRate;
		}

		public List<AccountTransaction> getPayments() {
			return payments;
		}

		public void setPayments(List<AccountTransaction> payments) {
			this.payments = payments;
		}
		
		
	}
	
	private final PaymentWizardModel wizardModel;
	private IMemberPaymentsRepository pmtRepo;
	
	public MemberPaymentProcessWizard(IMemberPaymentsRepository repo) {
		setWindowTitle("Run Member Payments Process");
		wizardModel = new PaymentWizardModel();
		pmtRepo = repo;
	}

	@Override
	public void addPages() {
		addPage(new PWSelectPaymentPeriod(wizardModel, pmtRepo));
		addPage(new PWPaymentRate(wizardModel));
		addPage(new PWPaymentComplete(wizardModel));
	}

	@Override
	public boolean performFinish() {
		return false;
	}

	@Override
	public boolean canFinish() {
		return false;
	}
	

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return super.needsPreviousAndNextButtons();
	}

	@Override
	public boolean needsProgressMonitor() {
		// TODO Auto-generated method stub
		return super.needsProgressMonitor();
	}

	
}
