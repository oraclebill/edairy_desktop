package com.agritrace.edairy.desktop.importers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class CollectionsImportTool extends AbstractImportTool {
	// TODO - untested
	public static final int BASE = 0;
	public static final int TRANSACTION_DATE = BASE;
	public static final int TRANSACTION_TIME = BASE + 1;
	public static final int DAIRY_CODE = BASE + 2;
	public static final int SCALE_SERIAL = BASE + 3;
	public static final int OPERATOR_CODE = BASE + 4;
	public static final int TRIP_NUMBER = BASE + 5;
	public static final int SESSION_CODE = BASE + 6;
	public static final int ROUTE_NUMBER = BASE + 7;
	public static final int CENTER_NUMBER = BASE + 8;
	public static final int MEMBER_NUMBER = BASE + 9;
	public static final int QUANTITY = BASE + 10;
	public static final int NUM_CANS = BASE + 11;  // TODO: confirm.. (was NUM_CANS) 
	public static final int SCALE_TOTAL = BASE + 12;  // TODO: confirm.. (was NUM_CANS) 
	public static final int ATTR_COUNT = BASE + 13;


	static final Entry[] fieldMap = { 
//		new Entry(TRANSACTION_DATE , DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE ), 	// PAGE ATTR
		new Entry(TRANSACTION_TIME , DairyPackage.Literals.SCALE_IMPORT_RECORD__COLLECTION_TIME ),
//		new Entry(DAIRY_CODE , DairyPackage.Literals.NO_MATCHING_ATTRIBUTE ),				// NO MATCHING ATTRIBUTE IN MODEL
		new Entry(SCALE_SERIAL , DairyPackage.Literals.SCALE_IMPORT_RECORD__SCALE_SERIAL ),
		new Entry(OPERATOR_CODE , DairyPackage.Literals.SCALE_IMPORT_RECORD__OPERATOR_CODE ),
//		new Entry(TRIP_NUMBER , DairyPackage.Literals.NO_MATCHING_ATTRIBUTE ),				// NO MATCHING ATTRIBUTE IN MODEL
//		new Entry(SESSION_CODE , DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION ), 	// PAGE ATTR
//		new Entry(ROUTE_NUMBER , DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE ),	// PAGE ATTR
		new Entry(CENTER_NUMBER , DairyPackage.Literals.SCALE_IMPORT_RECORD__CENTER_NUMBER ),		
		new Entry(MEMBER_NUMBER , DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER ),
		new Entry(QUANTITY , DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY ),
		new Entry(NUM_CANS , DairyPackage.Literals.SCALE_IMPORT_RECORD__NUM_CANS ),
		new Entry(SCALE_TOTAL , DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL ), // PAGE ATTR
	};

	Dairy dairy;

	public CollectionsImportTool(Dairy dairy, File f) throws FileNotFoundException {
		this(dairy, new FileReader(f));
	}

	public CollectionsImportTool(Dairy dairy, InputStream f) {
		this(dairy, new InputStreamReader(f));
	}

	public CollectionsImportTool(Dairy dairy, Reader reader) {
		this.dairy = dairy;
		this.reader = reader;
	}

	@Override
	protected List<Entry> getFields() {
		return Arrays.asList(
				fieldMap);
	}

	@Override
	protected int[] getMandatoryFieldIndexes() {
		return new int[] {  };
	}

	@Override
	protected void validateEntity(EObject object) {
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		if (dairy != null) {
			dairy.getCollectionJournals().add((CollectionJournalPage) entity);
		} else {
			System.out.println(entity);
		}
	}

	@Override
	protected EObject createBlankEntity() {
		return DairyFactory.eINSTANCE.createVehicle();
	}

}
