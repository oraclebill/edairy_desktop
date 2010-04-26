package com.agritrace.edairy.riena.ui.views.data;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.riena.ui.views.data.MilkRecord.TestResult;

public class MilkRecordsFactory {

	private MilkRecordsFactory() {

	}

	public static List<MilkRecord> createMilkRecords(){
		List<MilkRecord> records = new ArrayList<MilkRecord>();
		
		MilkRecord record = new MilkRecord();
		record.setDate("3/10/2010");
		record.setCenterName("Limuru Store");
		record.setClerkName("John Jones");
		record.setScale("#23-Electroic");
		record.setMemberName("Joseph Limuru");
		record.setFarmName("Golden Star");
		record.setCanNumber("#234");
		record.setBinNumber("#11-123");
		record.setAmount(13.0);
		record.setResult(TestResult.PASS);
		records.add(record);

		
		record.setDate("3/10/2010");
		record.setCenterName("Limuru Store");
		record.setClerkName("John Jones");
		record.setScale("#23-Electroic");
		record.setMemberName("Joseph Limuru");
		record.setFarmName("Golden Star");
		record.setCanNumber("#234");
		record.setBinNumber("#11-123");
		record.setAmount(13.0);
		record.setResult(TestResult.PASS);
		
		record = new MilkRecord();
		record.setDate("3/10/2010");
		record.setCenterName("Limuru Store");
		record.setClerkName("John Jones");
		record.setScale("#23-Electroic");
		record.setMemberName("John Smith");
		record.setFarmName("Holkou Farm");
		record.setCanNumber("#56");
		record.setBinNumber("#187");
		record.setAmount(56.0);
		record.setResult(TestResult.PASS);
		records.add(record);
		
		record = new MilkRecord();
		record.setDate("3/10/2010");
		record.setCenterName("Limuru Store");
		record.setClerkName("John Jones");
		record.setScale("#23-Electroic");
		record.setMemberName("Joseph Limuru");
		record.setFarmName("Kimbu");
		record.setCanNumber("#66");
		record.setBinNumber("#18-9");
		record.setAmount(9.0);
		record.setResult(TestResult.PASS);
		records.add(record);
		
		record = new MilkRecord();
		record.setDate("3/10/2010");
		record.setCenterName("Limuru Store");
		record.setClerkName("John Jones");
		record.setScale("#23-Electroic");
		record.setMemberName("David Bar");
		record.setFarmName("Green Farm");
		record.setCanNumber("#298");
		record.setBinNumber("#11-123");
		record.setAmount(7.0);
		record.setResult(TestResult.FAIL);
		records.add(record);
		
		return records;

		
	}
}
