package com.agritrace.edairy.desktop.collections.scaledata.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.csvreader.CsvReader;

public class ScaleImporter {

	
	/**
	 * Map from our field number to the field number in the csv. 
	 * In CSV one row may have multiple (2) logical records, 
	 * each number after our record offset is the position of the corresponding
	 * field in the csv, one per record..
	 * 
	 */
	private static final int SCALE_DATA = 0;
	private static final int CSV_DATA_AM = 1;
	private static int[][] SCALE_TO_RECORD_MAP = {
		{ ScaleRecord.MEMBER_NUMBER, 		0, 	0 },
		{ ScaleRecord.TRANSACTION_DATE, 	1, 	1 },
		{ ScaleRecord.QUANTITY, 			2, 	10 },
		{ ScaleRecord.TRANSACTION_TIME, 	3, 	11 },
		{ ScaleRecord.TRIP_NUMBER, 			4, 	4 },
		{ ScaleRecord.OPERATOR_CODE, 		5, 	5 },
		{ ScaleRecord.NUM_CANS, 			6, 	6 },		// ??
		{ ScaleRecord.SESSION_CODE, 		7, 	15 },
		{ ScaleRecord.CENTER_NUMBER, 		32, 32 },
		{ ScaleRecord.ROUTE_NUMBER, 		43, 43 },		
		{ ScaleRecord.DAIRY_CODE, 			44, 44 },		
		{ ScaleRecord.SCALE_SERIAL, 		45, 45 },		
		{ ScaleRecord.SCALE_TOTAL, 			46, 46 },		
	};
	
	private List<ScaleRecord> records = new LinkedList<ScaleRecord>();
	private File inputFile = null;
	private Reader inputReader = null;
	private long count = 0, invalidCount = 0;

	public ScaleImporter(File inputFile) {
		this.inputFile = inputFile;
	}

	public ScaleImporter readRecords() throws IOException {
		count = 0;
		invalidCount = 0;
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(reader);
	
			CsvReader importer = new CsvReader(bufferedReader);
			while(importer.readRecord()) {
				String[] csvRecord = importer.getValues();
				ScaleRecord scaleRecord = createRecord(CSV_DATA_AM, csvRecord);
				records.add(scaleRecord);

				if (csvRecord[4] != null && csvRecord[4].trim().length() > 0) { // magic number == pm quantity
					scaleRecord = createRecord(CSV_DATA_AM, csvRecord);
					records.add(scaleRecord);
				}
			}
			importer.close();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				}
				catch(Exception e) {}
			}
			if (reader != null) {
				try {
					reader.close();
				}
				catch(Exception e) {}
			}
		}
		return this;
	}
	
	public List<ScaleRecord> getResults() {
		return Collections.unmodifiableList(records);
	}
	
	public long getValidCount() {
		return count - invalidCount;
	}
	
	public long getInvalidCount() {
		return invalidCount;
	}
	
	public long getCount() {
		return count;
	}
	
	private ScaleRecord createRecord(int timeOfDay, String[] csvRecord) {
		ScaleRecord scaleRecord = new ScaleRecord();			
		for (int i = 0; i < SCALE_TO_RECORD_MAP.length; i++) {
			final int[] fieldMap = SCALE_TO_RECORD_MAP[i];
			scaleRecord.setAttr(fieldMap[SCALE_DATA], csvRecord[fieldMap[CSV_DATA_AM]]);
		}
		count++;
		scaleRecord.validate();
		if (!scaleRecord.isValid()) invalidCount++;
		return scaleRecord;
	}

}
