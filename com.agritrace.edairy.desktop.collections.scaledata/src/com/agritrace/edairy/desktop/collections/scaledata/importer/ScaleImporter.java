package com.agritrace.edairy.desktop.collections.scaledata.importer;

import java.io.BufferedReader;
import java.io.File;
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
	 * The tables below map from our field number to the field number in the csv. In CSV one row
	 * may have multiple (2) logical records, each number after our record
	 * offset is the position of the corresponding field in the csv, one per
	 * record..
	 * 
	 * Scale records seem to have the following form:
	 *   header: 
	 *      { member, date } (2 fields)
	 *     
	 *   4 X collection record:
	 *      { quantity, time, ?, operator code, ?, am/pm, ?, ? } (8 fields) 
	 * 
	 * 	 footer:
	 *      { ?, route code, dairy code, scale code, line total } 5 fields, where the first one varies with session.
	 * 
	 * 
	 * //	private static int[] HEADER_FIELDS = { 
	 * //		ScaleRecord.MEMBER_NUMBER, 
	 * //		ScaleRecord.TRANSACTION_DATE };
	 */


	private static int[] COLLECTION_RECORD_OFFSETS = { 2, 10, 18, 26 };
	private static int[] COLLECTION_FIELDS = {
		 ScaleRecord.QUANTITY,
		 ScaleRecord.TRANSACTION_TIME,
		 ScaleRecord.TRIP_NUMBER, 
		 ScaleRecord.OPERATOR_CODE, 
		 ScaleRecord.NUM_CANS,  
		 ScaleRecord.SESSION_CODE
	};
	
	private static int FOOTER_OFFSET = 42;
	private static int[] FOOTER_FIELDS = { 
		ScaleRecord.CENTER_NUMBER, 
		ScaleRecord.ROUTE_NUMBER, 
		ScaleRecord.DAIRY_CODE, 
		ScaleRecord.SCALE_SERIAL, 
		ScaleRecord.SCALE_TOTAL 
	};
	
	private List<ScaleRecord> records = new LinkedList<ScaleRecord>();
	private File inputFile = null;
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
			while (importer.readRecord()) {
				String[] csvRecord = importer.getValues();
				for (int recNum = 0; recNum < COLLECTION_RECORD_OFFSETS.length; recNum++ ) {
					if (hasValue(csvRecord[COLLECTION_RECORD_OFFSETS[recNum] + 1])) {
						final ScaleRecord scaleRecord = createRecord(recNum, csvRecord);
						scaleRecord.convertValues();
						records.add(scaleRecord);
					}
				}
			}
			importer.close();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception e) {
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
				}
			}
		}
		return this;
	}

	private boolean hasValue(String s) {
		return s != null && s.trim().length() > 0;
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

	private ScaleRecord createRecord(final int recordNumber, final String[] csvRecord) {
		ScaleRecord scaleRecord = new ScaleRecord();
		
		scaleRecord.setMemberNumber(csvRecord[0]);
		scaleRecord.setTransactionDate(csvRecord[1]);
		
		for (int i = 0; i < COLLECTION_FIELDS.length; i++) {
			int indexInScaleRecord = COLLECTION_RECORD_OFFSETS[recordNumber] + i;
			scaleRecord.setAttr(COLLECTION_FIELDS[i], csvRecord[indexInScaleRecord]);
		}
		for (int i = 0; i < FOOTER_FIELDS.length; i++) {
			int indexInScaleRecord = FOOTER_OFFSET + i;
			scaleRecord.setAttr(FOOTER_FIELDS[i], csvRecord[indexInScaleRecord]);
		}
				
		return scaleRecord;
	}

}
