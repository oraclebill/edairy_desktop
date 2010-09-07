package com.agritrace.edairy.desktop.install;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class VehicleImportTool extends AbstractImportTool {

	public static final int BASE = 0;
	public static final int LOG_BOOK_NUMBER = BASE;
	public static final int TYPE = BASE + 1;
	public static final int REGISTRATION_NUMBER = BASE + 2;
	public static final int MAKE = BASE + 3;
	public static final int MODEL = BASE + 4;
	public static final int YEAR = BASE + 5;
	public static final int ENGINE_NUMBER = BASE + 6;
	public static final int CHASSIS_NUMBER = BASE + 7;
	public static final int INSURANCE_NUMBER = BASE + 8;
	public static final int INSURANCE_EXP_DATE = BASE + 9;
	public static final int ASSET_TAG_ID = BASE + 10;
	public static final int DAMAGE_DATE = BASE + 11;
	public static final int DAMAGE_DESCRIPTION = BASE + 12;
	public static final int DISPOSAL_DATE = BASE + 13;
	public static final int DISPOSAL_DESCRIPTION = BASE + 14;
	public static final int DISPOSAL_WITNESS = BASE + 15;

	static final Entry[] fieldMap = { new Entry(LOG_BOOK_NUMBER, DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER),
			new Entry(TYPE, DairyPackage.Literals.VEHICLE__TYPE),
			new Entry(REGISTRATION_NUMBER, DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER),
			new Entry(MAKE, DairyPackage.Literals.VEHICLE__MAKE),
			new Entry(MODEL, DairyPackage.Literals.VEHICLE__MODEL),
			new Entry(YEAR, DairyPackage.Literals.VEHICLE__YEAR),
			new Entry(ENGINE_NUMBER, DairyPackage.Literals.VEHICLE__ENGINE_NUMBER),
			new Entry(CHASSIS_NUMBER, DairyPackage.Literals.VEHICLE__CHASSIS_NUMBER),
			new Entry(INSURANCE_NUMBER, DairyPackage.Literals.VEHICLE__INSURANCE_POLICY_NUMBER),
			new Entry(INSURANCE_EXP_DATE, DairyPackage.Literals.VEHICLE__INSURANCE_EXPIRATION_DATE),
	// new Entry(ASSET_TAG_ID , DairyPackage.Literals.ASSET__TAG_VALUE ),
	// new Entry(DAMAGE_DATE , DairyPackage.Literals.ASSET__DAMAGE_DATE ),
	// new Entry(DAMAGE_DESCRIPTION ,
	// DairyPackage.Literals.ASSET__DAMAGE_DESCRIPTION ),
	// new Entry(DISPOSAL_DATE , DairyPackage.Literals.ASSET__DATE_DISPOSED ),
	// new Entry(DISPOSAL_DESCRIPTION ,
	// DairyPackage.Literals.ASSET__DISPOSAL_REASON ),
	// new Entry(DISPOSAL_WITNESS ,
	// DairyPackage.Literals.ASSET__DISPOSAL_WITNESS ),
	};

	static final String[] expectedHeaders = new String[] { "log book number", "type", "registration number", "make",
			"model", "year", "engine number", "chassis number", "insurance number", "insurance exp date",
			"asset tag id", "damage date ", "damage description", "disposal date", "disposal description",
			"disposal witness" };

	private Collection<Vehicle> vehicles;
	private Map<String, List<String[]>> failedRecords;
	private Map<String, Object> vehicleCache;

	private int count = 0, errCount = 0;


	public VehicleImportTool(Dairy dairy, File f) throws FileNotFoundException {
		this(dairy, new FileReader(f));
	}

	public VehicleImportTool(Dairy dairy, InputStream f) {
		this(dairy, new InputStreamReader(f));
	}

	public VehicleImportTool(Dairy dairy, Reader reader) {
		this.reader = reader;
	}
	
	public VehicleImportTool(InputStream input, List<Vehicle> vehicles,
			Map<String, List<String[]>> errors, IProgressMonitor monitor) {
		super(new InputStreamReader(input));
		setMonitor(monitor);
		
		this.vehicles = vehicles;
		this.failedRecords = errors;

		Dairy dairy = DairyRepository.getInstance().getLocalDairy();
		vehicleCache = new HashMap<String, Object>();
		for (Vehicle vehicle : dairy.getVehicles()) {
			vehicleCache.put(vehicle.getLogBookNumber(), vehicle);
		}		
	}
	
	@Override
	protected List<Entry> getFields() {
		return Arrays.asList(fieldMap);
	}

	@Override
	protected int[] getMandatoryFieldIndexes() {
		return new int[] { REGISTRATION_NUMBER, MAKE, MODEL, YEAR };
	}

	@Override
	protected String[] getExpectedHeaders() {
		return expectedHeaders;
	}
	
	@Override
	protected void validateRecord(String[] values) {
		super.validateRecord(values);
		Object route = vehicleCache.get(values[REGISTRATION_NUMBER]);
		if (route instanceof Vehicle) {
			throw new ValidationException("Vehicle exists in database.");
		}
		if (route instanceof String[]) {
			throw new ValidationException("Duplicate vehicle during import.");
		}
		vehicleCache.put(values[REGISTRATION_NUMBER], values);
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		Vehicle vehicle = (Vehicle)entity;
		madeConsistent(vehicle);
		count++;
		vehicles.add(vehicle);
	}

	
	
	private void madeConsistent(Vehicle vehicle) {
		String logBookNumber = vehicle.getLogBookNumber();
		if(logBookNumber == null 
				|| logBookNumber.isEmpty()//NOTE! this may clatch with VehicleImpl.LOG_BOOK_NUMBER_EDEFAULT if it will be set to 
				//something different than just empty string!
				){
			vehicle.setLogBookNumber(vehicle.getRegistrationNumber());
		}			
		
	}

	@Override
	protected void doImportRecordFailed(String[] values, Exception e) {
		errCount++;
		String message = e.getMessage();
		List<String[]> records = failedRecords.get(message);
		if (records == null) {
			records = new LinkedList<String[]>();
			failedRecords.put(message, records);
		}
		records.add(values);
	}

	@Override
	protected EObject createBlankEntity() {
		EObject vehicle = DairyFactory.eINSTANCE.createVehicle();
		EMFUtil.populate(vehicle);
		return vehicle;
	}

	@Override
	protected void doImportComplete(int okCount, int failCount) {
	}

}
