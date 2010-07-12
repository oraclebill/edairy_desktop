package com.agritrace.edairy.desktop.collections.scaledata.importer;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.agritrace.edairy.desktop.collections.scaledata.importer.ScaleImporter;

public class ScaleImporterTest {
	
	private static String[] TEST_DATA = new String[] {
		"1251  ,06/07/2010,005.5,05:58,17 ,ANG,001,AM,1    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,1,R017,D001,E009,5.5",
		"1732  ,06/07/2010,005.5,05:58,17 ,ANG,001,AM,1    ,1,003.8,15:46,17 ,ANG,001,PM,2    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,2,R017,D001,E009,9.3",
		"2300  ,06/07/2010,008.0,05:58,17 ,ANG,001,AM,1    ,1,003.2,15:03,17 ,ANG,001,PM,2    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,2,R017,D001,E009,11.2",
		"9568  ,06/07/2010,003.6,05:59,17 ,ANG,001,AM,1    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,1,R017,D001,E009,3.6",
		"3281  ,06/07/2010,012.8,05:59,17 ,ANG,001,AM,1    ,1,004.2,15:37,17 ,ANG,001,PM,2    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,2,R017,D001,E009,17",
		"1619  ,06/07/2010,015.0,05:59,17 ,ANG,001,AM,1    ,1,003.9,15:47,17 ,ANG,001,PM,2    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,2,R017,D001,E009,18.9",
		"4494  ,06/07/2010,003.5,06:00,17 ,ANG,001,AM,1    ,1,003.6,15:32,17 ,ANG,001,PM,2    ,1,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,000.0,     ,   ,   ,000,  ,     , ,2,R017,D001,E009,7.1",
	};
	
	@Test
	public void testImportFile() throws Exception {
		String inputFileName = "/Users/oraclebill/Development/Projects/edairy_desktop/test-data/fwfiles/E00906072010.TRN";
		File inputFile = new File(inputFileName );
		if ( inputFile.canRead() && inputFile.isFile()) {
			ScaleImporter scaleImporter = new ScaleImporter(inputFile);
			List<ScaleRecord> testData = scaleImporter.readRecords().getResults();
			System.out.println( " records: " + testData.size() );
			for ( ScaleRecord record : testData ) {
				record.validate();
				if (record.isValid()) 
					System.out.println( record ) ;
				else 
					System.err.println( record ) ;
			}
			System.out.println( "external count: " + testData.size() );
			System.out.println( "internal count: " + scaleImporter.getCount() );
			System.out.println( "invalid count: " + scaleImporter.getInvalidCount() );
			System.out.println( "valid count: " + scaleImporter.getValidCount() );
		}
	}

}
