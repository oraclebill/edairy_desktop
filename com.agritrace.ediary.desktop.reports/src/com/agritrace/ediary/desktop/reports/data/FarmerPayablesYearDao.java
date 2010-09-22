package com.agritrace.ediary.desktop.reports.data;

import java.util.ArrayList;
import java.util.List;

public class FarmerPayablesYearDao {
	
	private static FarmerPayablesYearDao instance;
	
	public FarmerPayablesYearDao(){
		super();
	}
	
	public static FarmerPayablesYearDao instance(){
		if(instance == null){
			instance = new FarmerPayablesYearDao();
		}
		return instance;
	}
	
	public List<FarmerPayablesYearData> getReportValues(String year){
		//TODO apply year!
		List<FarmerPayablesYearData> ret = new ArrayList<FarmerPayablesYearData>();
		
		FarmerPayablesYearData data = new FarmerPayablesYearData("farmer1", "100", "345", "23234", "-200", "0", "12");
		ret.add(data);
		data = new FarmerPayablesYearData("farmer2", "200", "345", "23234", "-200", "0", "12");
		ret.add(data);
		data = new FarmerPayablesYearData("farmer3", "300", "345", "23234", "-200", "0", "12");
		ret.add(data);
		
		return ret;
	}

}
