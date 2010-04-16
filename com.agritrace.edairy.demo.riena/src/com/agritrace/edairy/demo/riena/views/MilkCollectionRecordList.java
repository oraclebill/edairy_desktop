package com.agritrace.edairy.demo.riena.views;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.demo.riena.views.data.MilkCollectionRecord;

public class MilkCollectionRecordList {
	
	private List<MilkCollectionRecord> records = new ArrayList<MilkCollectionRecord>();
	
	private String totalValue;
	
	public String getTotalValue(){
		return "Total :"+getTotal();
	}
	
	public double getTotal(){
		if(records == null||records.isEmpty()){
			return 0;
		}
		double total = 0;
		for(MilkCollectionRecord record :records){
			total += record.getQuantity();
		}
		return total;
	}

	public List<MilkCollectionRecord> getRecords() {
		return records;
	}

	public void setRecords(List<MilkCollectionRecord> records) {
		this.records = records;
	}

}
