package com.agritrace.edairy.desktop.finance.ui.beans;

import java.util.ArrayList;
import java.util.List;

public class CreditRecordFactory {

    private CreditRecordFactory() {

    }

    public static List<CreditRecord> createCreditRecords() {
	final List<CreditRecord> records = new ArrayList<CreditRecord>();
	CreditRecord record = new CreditRecord();
	record.setStore("RT2-NG");
	record.setDate("3/24/2010");
	record.setReference("V-4599887");
	record.setMember("#45678");
	record.setAmount(10);
	record.setRecord("1");
	records.add(record);

	record = new CreditRecord();
	record.setStore("RT3-KY");
	record.setDate("3/24/2010");
	record.setReference("V-4534221");
	record.setMember("#45123");
	record.setAmount(40);
	record.setRecord("6");

	records.add(record);

	record = new CreditRecord();
	record.setStore("RT2-NG");
	record.setDate("3/24/2010");
	record.setReference("V-4599887");
	record.setMember("#45678");
	record.setAmount(90);
	record.setRecord("4");

	records.add(record);

	return records;

    }

}
