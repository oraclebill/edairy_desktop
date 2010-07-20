package com.agritrace.edairy.desktop.install;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

public class ScaleImportTool extends AbstractImportTool {

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

	public static final String[] expectedHeaders = new String[] { null, "account-id", "membership-id", "default-route",
			null, null, "given-name", "family-name" };

	static final Entry[] fieldMap = { 
//		new Entry(TRANSACTION_DATE , DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE ), 	// PAGE ATTR
		new Entry(TRANSACTION_TIME , DairyPackage.Literals.SCALE_IMPORT_RECORD__COLLECTION_TIME ),
//		new Entry(DAIRY_CODE , DairyPackage.Literals.NO_MATCHING_ATTRIBUTE ),				// NO MATCHING ATTRIBUTE IN MODEL
		new Entry(SCALE_SERIAL , DairyPackage.Literals.SCALE_IMPORT_RECORD__SCALE_SERIAL ),
		new Entry(OPERATOR_CODE , DairyPackage.Literals.SCALE_IMPORT_RECORD__OPERATOR_CODE ),
		new Entry(TRIP_NUMBER , DairyPackage.Literals.SCALE_IMPORT_RECORD__TRIP_NUMBER ),				// NO MATCHING ATTRIBUTE IN MODEL
//		new Entry(SESSION_CODE , DairyPackage.Literals.SCA ), 	// PAGE ATTR
		new Entry(ROUTE_NUMBER , DairyPackage.Literals.COLLECTION_JOURNAL_LINE__ ),	// PAGE ATTR
		new Entry(CENTER_NUMBER , DairyPackage.Literals.SCALE_IMPORT_RECORD__CENTER_NUMBER ),		
		new Entry(MEMBER_NUMBER , DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER ),
		new Entry(QUANTITY , DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY ),
		new Entry(NUM_CANS , DairyPackage.Literals.SCALE_IMPORT_RECORD__NUM_CANS ),
		new Entry(SCALE_TOTAL , DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL ), // PAGE ATTR
	};
	
	
	@Override
	protected String[] getExpectedHeaders() {
		return expectedHeaders;
	}

	@Override
	
	protected EObject createBlankEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Entry> getFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void validateEntity(EObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void saveImportedEntity(Object entity) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doImportComplete() {
		// TODO Auto-generated method stub

	}

}
