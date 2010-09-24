package com.agritrace.ediary.desktop.reports.data;

import java.util.ArrayList;
import java.util.List;

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
	
	private static FarmerPayablesYearDao instance;
//	private final IDairyRepository dairyRepo;
	private final IMemberRepository memberRepo;
	private java.text.DecimalFormat floatFormater;
	
	public FarmerPayablesYearDao(){
		super();
//		this.dairyRepo = RepositoryFactory.getDairyRepository();
		this.memberRepo = RepositoryFactory.getMemberRepository();
		this.floatFormater = new java.text.DecimalFormat("0000.00");
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

}
