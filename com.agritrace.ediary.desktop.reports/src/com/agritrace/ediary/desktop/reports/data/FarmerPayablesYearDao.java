package com.agritrace.ediary.desktop.reports.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;

/**
 * class to collect the data needed for the report and to place it into special beans for report presentation.
 * @author rsw
 *
 */
public class FarmerPayablesYearDao {
	
	private static final BigDecimal ZERO = new BigDecimal(0);
	
	private static FarmerPayablesYearDao instance;
//	private final IDairyRepository dairyRepo;
	private final IMemberRepository memberRepo;
	private java.text.DecimalFormat floatFormater;
	
	public FarmerPayablesYearDao(){
		super();
//		this.dairyRepo = RepositoryFactory.getDairyRepository();
		this.memberRepo = RepositoryFactory.getMemberRepository();
		this.floatFormater = new java.text.DecimalFormat("#,#00.0#;(#,#00.0#)");
	}
	
	public static FarmerPayablesYearDao instance(){
		if(instance == null){
			instance = new FarmerPayablesYearDao();
		}
		return instance;
	}
	
	public List<FarmerPayablesYearData> getReportValues(String year, String month){
		
		List<Farm> farms = memberRepo.getMemberFarms();
		List<FarmerPayablesYearData> ret = new ArrayList<FarmerPayablesYearData>();
		
		
		for(Farm farm:farms){
			Membership membership = (Membership) farm.getOwner().eContainer();
			if(membership == null){
				continue;
			}
			Farmer farmer = membership.getMember();
			
			
			//Income = (Total quantity of milk collected - quantity of rejected milk) * Posted Milk Price for that month
			float income = 34588;//TODO implement!
			
			//Credits = 0 - (Sum of all credits attributed to member for current month)
			float credits = -34;
			
			//Adjustments = Sum of all adjustments (debit adds and credit subtracts)
			float adjustments = 0;
			
			//Payables = Sum of Income, credits and adjustments
			float payables = 1;
			
			String name = farmer.getGivenName();
			String memberNumber = membership.getMemberNumber();
			String accountNumber = membership.getAccount().getAccountNumber();
			
			FarmerPayablesYearData data = new FarmerPayablesYearData(name, 
					memberNumber, accountNumber, this.floatFormater.format(income), 
					this.floatFormater.format(credits), this.floatFormater.format(adjustments), this.floatFormater.format(payables));
			ret.add(data);
		}
		
		return ret;
	}

	public List<FarmerPayablesYearData> getReportValuesX(String year, String month){
		
		List<Membership> members = memberRepo.all();
		List<FarmerPayablesYearData> ret = new ArrayList<FarmerPayablesYearData>();		
		
		for(Membership membership:members){
			Farmer farmer = membership.getMember();
						
			//Income = (Total quantity of milk collected - quantity of rejected milk) * Posted Milk Price for that month
			BigDecimal income = calculateMemberMonthlyIncome(membership, month, year);
			
			//Credits = 0 - (Sum of all credits attributed to member for current month)
			BigDecimal credits = calculateMemberMonthlyCredits(membership, month, year);
			
			//Adjustments = Sum of all adjustments (debit adds and credit subtracts)
			BigDecimal adjustments = calculateMemberMonthlyAdjustments(membership, month, year);
			
			//Payables = Sum of Income, credits and adjustments
			BigDecimal payables = calculateMemberMonthlyPayable(membership, month, year);

			if (income.equals(ZERO) && credits.equals(ZERO) && adjustments.equals(ZERO)) 
				continue;
			
			String name = farmer.getGivenName();
			String memberNumber = membership.getMemberNumber();
			String accountNumber = membership.getAccount().getAccountNumber();
			
			FarmerPayablesYearData data = new FarmerPayablesYearData(name, 
					memberNumber, accountNumber, this.floatFormater.format(income), 
					this.floatFormater.format(credits), this.floatFormater.format(adjustments), this.floatFormater.format(payables));
			ret.add(data);
		}
		
		return ret;
	}

	private BigDecimal calculateMemberMonthlyIncome(Membership membership,
			String month, String year) {
		ICollectionJournalLineRepository collectionsRepo = RepositoryFactory.getRegisteredRepository(ICollectionJournalLineRepository.class);
		return ZERO;
	}

	private BigDecimal calculateMemberMonthlyCredits(Membership membership,
			String month, String year) {
		// TODO Auto-generated method stub
		return ZERO;
	}

	private BigDecimal calculateMemberMonthlyAdjustments(Membership membership,
			String month, String year) {
		// TODO Auto-generated method stub
		return ZERO;
	}

	private BigDecimal calculateMemberMonthlyPayable(Membership membership,
			String month, String year) {
		// TODO Auto-generated method stub
		return ZERO;
	}


}
