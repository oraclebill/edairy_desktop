package com.agritrace.edairy.desktop.collections.scaledata.importer;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;

public class ScaleImporterTest {

	@Test
	public void testImportFile() throws Exception {
		final String inputFileName = "/Users/oraclebill/Development/Projects/edairy_desktop/test-data/fwfiles/E00906072010.TRN";
		final File inputFile = new File(inputFileName );
		if ( inputFile.canRead() && inputFile.isFile()) {
			final ScaleImporter scaleImporter = new ScaleImporter(inputFile);
			final List<ScaleRecord> testData = scaleImporter.readRecords().getResults();
			System.out.println( " records: " + testData.size() );
			for ( final ScaleRecord record : testData ) {
				record.convertValues();
				if (record.isValid()) {
					System.out.println( record ) ;
				} else {
					System.err.println( record ) ;
				}
			}
			System.out.println( "external count: " + testData.size() );
			System.out.println( "internal count: " + scaleImporter.getCount() );
			System.out.println( "invalid count: " + scaleImporter.getInvalidCount() );
			System.out.println( "valid count: " + scaleImporter.getValidCount() );
		}
	}

}
