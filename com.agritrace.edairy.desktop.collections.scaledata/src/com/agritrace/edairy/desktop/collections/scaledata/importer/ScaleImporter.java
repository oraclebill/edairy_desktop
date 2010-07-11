package com.agritrace.edairy.desktop.collections.scaledata.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sun.io.Converters;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.csvreader.CsvReader;

public class ScaleImporter {

	private static int[][] AM_SCALE_TO_RECORD_MAP = {
		{ 0, ScaleRecord.MEMBER_NUMBER },
		{ 1, ScaleRecord.TRANSACTION_DATE },
		{ 2, ScaleRecord.QUANTITY },
		{ 3, ScaleRecord.TRANSACTION_TIME },
		{ 4, ScaleRecord.TRIP },
		{ 5, ScaleRecord. },
		{ 6, ScaleRecord. },
		{ 7, ScaleRecord. },
		{ 32, ScaleRecord. },
		{ 43, ScaleRecord. },		
		{ 44, ScaleRecord. },		
		{ 45, ScaleRecord. },		
	};
	
	List<ScaleRecord> records = null;
	File inputFile = null;

	public ScaleImporter(File inputFile) {
		this.inputFile = inputFile;
	}

	public void readRecords() throws IOException {
		Reader reader = null;
		BufferedReader bufferedReader = null;

		reader = new FileReader(inputFile);
		bufferedReader = new BufferedReader(reader);

		CsvReader importer = new CsvReader(bufferedReader);
		while(importer.readRecord()) {
			importer.
		}

	}
/*
	protected void readAndStoreTxns() throws Exception, IOException {
		int numOfTxns = 0;
		Time amTxnTimeDBFormat = null;
		Time pmTxnTimeDBFormat = null;
		if (!UserRoleConfiguration.configureUser(EDairyMasterUser.currentUser).equalsIgnoreCase("admin")) {
			JOptionPane.showMessageDialog(new JFrame(), "You Don't Have Sufficient Privileges!");
			return;
		}
		df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			stmt = conn.prepareStatement(insertQuery);
		} catch (SQLException sqle) {
			logger.error(sqle);
		}
		logger.info("Reading Data From File.");
		java.util.Date trxnDate = null;
		String scaleSerial = "";
		String amTxnTime = "";
		String pmTxnTime = "";
		String amQtyStr = "";
		String pmQtyStr = "";
		String amSession = "";
		String pmSession = "";
		int tripNum = 0;
		String oprCode = "";
		String numCans = "";
		String centerNum = "";
		String dairyCode = "";
		String routeNum = "";
		double amQty = 0.0;
		double pmQty = 0.0;
		while (reader.readRecord()) {
			String memberNumber = reader.get(0);
			try {
				trxnDate = df.parse(reader.get(1));
			} catch (ParseException pe) {
				logger.error(pe);
				continue;
			}
			try {
				amQtyStr = reader.get(2);
				pmQtyStr = reader.get(10);
				if (!amQtyStr.equals("")) {
					amQty = Double.valueOf(Double.parseDouble(amQtyStr));
				}
				if (!pmQtyStr.equals("")) {
					pmQty = Double.valueOf(Double.parseDouble(pmQtyStr));
				}
				amTxnTime = reader.get(3);
				if (amTxnTime.equals("")) {
					amTxnTime = "11:59";
					amTxnTimeDBFormat = Time.valueOf(amTxnTime);
				}
				pmTxnTime = reader.get(11);
				if (pmTxnTime.equals("")) {
					pmTxnTime = "12:00";
					pmTxnTimeDBFormat = Time.valueOf(pmTxnTime);
				}
				tripNum = Integer.parseInt(reader.get(4));
				oprCode = reader.get(5);
				numCans = reader.get(6);
				amSession = reader.get(7);
				if (amSession.equals("")) {
					amSession = "AM";
				}
				if (pmSession.equals("")) {
					pmSession = "PM";
				}
				pmSession = reader.get(15);
				centerNum = reader.get(32);
				routeNum = reader.get(43);
				dairyCode = reader.get(44);
				scaleSerial = reader.get(45);

			} catch (NumberFormatException nfe) {
				logger.error(nfe);
			}
			try {
				// Persist the AM weighments
				stmt.setString(1, Converters.convertNumber(memberNumber));
				stmt.setDate(2, new Date(trxnDate.getTime()));
				stmt.setDouble(3, amQty);
				if (amTxnTimeDBFormat instanceof Time) {
					stmt.setTime(4, amTxnTimeDBFormat);
				} else {
					stmt.setString(4, "11:59");
				}
				stmt.setInt(5, tripNum);
				stmt.setString(6, oprCode);
				stmt.setString(7, numCans);
				stmt.setString(8, amSession);
				stmt.setString(9, centerNum);
				stmt.setString(10, routeNum);
				stmt.setString(11, dairyCode);
				stmt.setString(12, scaleSerial);
				stmt.setInt(13, 0);
				stmt.executeUpdate();
				numOfTxns += 1;
				// Persist the PM weighments
				stmt.setString(1, Converters.convertNumber(memberNumber));
				stmt.setDate(2, new Date(trxnDate.getTime()));
				stmt.setDouble(3, pmQty);
				stmt.setString(8, pmSession);
				if (amTxnTimeDBFormat instanceof Time) {
					stmt.setTime(4, amTxnTimeDBFormat);
				} else {
					stmt.setString(4, "12:00");
					stmt.setString(8, "PM");
				}
				stmt.setInt(5, tripNum);
				stmt.setString(6, oprCode);
				stmt.setString(7, numCans);
				stmt.setString(9, centerNum);
				stmt.setString(10, routeNum);
				stmt.setString(11, dairyCode);
				stmt.setString(12, scaleSerial);
				stmt.setInt(13, 0);
				stmt.executeUpdate();
				numOfTxns += 1;
			} catch (SQLException sqle) {
				logger.error("Database Error Occured While Writting Data. " + memberNumber);
				sqle.printStackTrace();
			}

		}
		logger.info("Added " + numOfTxns + " Transactions For " + scaleSerial + "On " + trxnDate);
		JOptionPane.showMessageDialog(new JFrame(), numOfTxns + " Records Added Successfully!");
		close();
		moveToHistory();
	}
*/
	public void importScaleData(InputStream input) {

	}

}
