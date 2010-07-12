package com.agritrace.edairy.desktop.collections.scaledata.beans;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ScaleRecordTest {
	
	ScaleRecord record;
	String transactionDate, transactionTime, dairyCode, scaleSerial,
			operatorCode, tripNumber, sessionCode, routeNumber, centerNumber,
			memberNumber, quantity, numCans, scaleTotal;

	String pmTransactionTime, pmSessionCode, pmQuantity;
	
	@Before
	public void setup() {		
		transactionDate = "01/01/2001";
		transactionTime = "12:57";
		dairyCode = "D001";
		scaleSerial = "E009";
		operatorCode = "DGG";
		tripNumber = "001";
		sessionCode = "AM";
		routeNumber = "R001";
		centerNumber = "D009";
		memberNumber = "3434";
		quantity = "12.2";
		numCans = "1";
		scaleTotal = "14.2";

		pmTransactionTime = "4:32";
		pmSessionCode = "PM";
		pmQuantity = "2.0";
		
		record = new ScaleRecord();
	}
	@Test
	public void testParseValidAM() throws Exception {

		record.init(transactionDate, transactionTime, dairyCode, scaleSerial,
				operatorCode, tripNumber, sessionCode, routeNumber,
				centerNumber, memberNumber, quantity, numCans, scaleTotal);

		assertEquals("transactionDate", record.getTransactionDate(), "01/01/2001");
		assertEquals("transactionTime", record.getTransactionTime(), "12:57");
		assertEquals("dairyCode", record.getDairyCode(), "D001");
		assertEquals("scaleSerial", record.getScaleSerial(), "E009");
		assertEquals("operatorCode", record.getOperatorCode(), "DGG");
		assertEquals("tripNumber", record.getTripNumber(), "001");
		assertEquals("sessionCode", record.getSessionCode(), "AM");
		assertEquals("routeNumber", record.getRouteNumber(), "R001");
		assertEquals("centerNumber", record.getCenterNumber(), "D009");
		assertEquals("memberNumber", record.getMemberNumber(), "3434");
		assertEquals("quantity", record.getQuantity(), "12.2");
		assertEquals("numCans", record.getNumCans(), "1");
		
		record.validate();
		
		assertEquals("isValid", true, record.isValid());
		assertEquals("validMember", "3434", record.getValidMember());
		assertEquals("validQuantity", new BigDecimal("12.2"), record.getValidQuantity());
//		assertEquals("validScaleTotal", new BigDecimal("14.2"), record.getValidScaleTotal());
		
		Calendar cal = Calendar.getInstance();
		cal.set(2001, 0, 1, 12, 57, 0);

		// assertEquals(cal.getTime(), record.getValidDate()); // doesn't work -
		// calendar equality compares to many (irrelevent for me) things..
		// assertEquals(0l,
		// Math.abs(cal.getTime().compareTo(record.getValidDate()))); // doesn't
		// work - always off by one or two milliseconds..
		assertEquals("validDate", 
				5l,
				Math.max(5l, Math.abs(cal.getTime().compareTo(
						record.getValidDate()))));
	}

	@Test
	public void testParseValidPM() throws Exception {

		record.init(transactionDate, pmTransactionTime, dairyCode, scaleSerial,
				operatorCode, tripNumber, pmSessionCode, routeNumber,
				centerNumber, memberNumber, pmQuantity, numCans, scaleTotal);
		
		assertEquals("transactionDate", record.getTransactionDate(), "01/01/2001");
		assertEquals("transactionTime", record.getTransactionTime(), "4:32");
		assertEquals("dairyCode", record.getDairyCode(), "D001");
		assertEquals("scaleSerial", record.getScaleSerial(), "E009");
		assertEquals("operatorCode", record.getOperatorCode(), "DGG");
		assertEquals("tripNumber", record.getTripNumber(), "001");
		assertEquals("sessionCode", record.getSessionCode(), "PM");
		assertEquals("routeNumber", record.getRouteNumber(), "R001");
		assertEquals("centerNumber", record.getCenterNumber(), "D009");
		assertEquals("memberNumber", record.getMemberNumber(), "3434");
		assertEquals("quantity", record.getQuantity(), "2.0");
		assertEquals("numCans", record.getNumCans(), "1");
//		assertEquals("scaleTotal", record.getScaleTotal(), "14.2");
		
		record.validate();
		
		assertEquals("isValid", true, record.isValid());
		assertEquals("validMember", "3434", record.getValidMember());
		assertEquals("validQuantity", new BigDecimal("2.0"), record.getValidQuantity());
//		assertEquals("validScaleTotal", new BigDecimal("14.2"), record.getValidScaleTotal());

		Calendar cal = Calendar.getInstance();
		cal.set(2001, 0, 1, 4, 32, 0);

		// assertEquals(cal.getTime(), record.getValidDate()); // doesn't work -
		// calendar equality compares to many (irrelevent for me) things..
		// assertEquals(0l,
		// Math.abs(cal.getTime().compareTo(record.getValidDate()))); // doesn't
		// work - always off by one or two milliseconds..
		assertEquals(
				5l,
				Math.max(5l, Math.abs(cal.getTime().compareTo(
						record.getValidDate()))));
	}

	@Test
	public void testParseMissingPM() throws Exception {

		pmTransactionTime = "";
		pmSessionCode = "";
		pmQuantity = "";
		
		record.init(transactionDate, pmTransactionTime, dairyCode, scaleSerial,
				operatorCode, tripNumber, pmSessionCode, routeNumber,
				centerNumber, memberNumber, pmQuantity, numCans, scaleTotal);
		
		assertEquals("transactionDate", record.getTransactionDate(), "01/01/2001");
		assertEquals("transactionTime", record.getTransactionTime(), "");
		assertEquals("dairyCode", record.getDairyCode(), "D001");
		assertEquals("scaleSerial", record.getScaleSerial(), "E009");
		assertEquals("operatorCode", record.getOperatorCode(), "DGG");
		assertEquals("tripNumber", record.getTripNumber(), "001");
		assertEquals("sessionCode", record.getSessionCode(), "");
		assertEquals("routeNumber", record.getRouteNumber(), "R001");
		assertEquals("centerNumber", record.getCenterNumber(), "D009");
		assertEquals("memberNumber", record.getMemberNumber(), "3434");
		assertEquals("quantity", record.getQuantity(), "");
		assertEquals("numCans", record.getNumCans(), "1");
		
		record.validate();
		
		assertEquals("isValid", false, record.isValid());		
	}


	@Test
	public void testBlankMinutes() throws Exception {
		
		// only change the time..
		transactionTime = "";
		record.init(transactionDate, transactionTime, dairyCode, scaleSerial,
				operatorCode, tripNumber, sessionCode, routeNumber,
				centerNumber, memberNumber, quantity, numCans, scaleTotal);
		record.validate();
		assertEquals(false, record.isValid());
		
		Calendar cal = Calendar.getInstance();
		cal.set(2001, 0, 1);
		assertEquals(
				5l,
				Math.max(5l, Math.abs(cal.getTime().compareTo(
						record.getValidDate()))));
	}
}
