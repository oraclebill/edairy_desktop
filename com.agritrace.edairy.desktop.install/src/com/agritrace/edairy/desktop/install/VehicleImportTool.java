package com.agritrace.edairy.desktop.install;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.csvreader.CsvReader;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class VehicleImportTool {

	public static class Entry {
		int field;
		EStructuralFeature feature;

		Entry(int field, EStructuralFeature feature) {
			this.field = field;
			this.feature = feature;
		}
	}

	public static class ValidationException extends RuntimeException {

		public ValidationException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ValidationException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public ValidationException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public ValidationException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}

	}

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

	private static final Entry[] fieldMap = { 
		new Entry(LOG_BOOK_NUMBER ,  DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER ),
		new Entry(TYPE ,  DairyPackage.Literals.VEHICLE__TYPE ),
		new Entry(REGISTRATION_NUMBER ,  DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER ),
		new Entry(MAKE ,  DairyPackage.Literals.VEHICLE__MAKE ),
		new Entry(MODEL ,  DairyPackage.Literals.VEHICLE__MODEL ),
		new Entry(YEAR ,  DairyPackage.Literals.VEHICLE__YEAR ),
		new Entry(ENGINE_NUMBER ,  DairyPackage.Literals.VEHICLE__ENGINE_NUMBER ),
		new Entry(CHASSIS_NUMBER ,  DairyPackage.Literals.VEHICLE__CHASSIS_NUMBER ),
		new Entry(INSURANCE_NUMBER ,  DairyPackage.Literals.VEHICLE__INSURANCE_POLICY_NUMBER ),
		new Entry(INSURANCE_EXP_DATE ,  DairyPackage.Literals.VEHICLE__INSURANCE_EXPIRATION_DATE ),
//		new Entry(ASSET_TAG_ID ,  DairyPackage.Literals.ASSET__TAG_VALUE ),
//		new Entry(DAMAGE_DATE ,  DairyPackage.Literals.ASSET__DAMAGE_DATE ),
//		new Entry(DAMAGE_DESCRIPTION ,  DairyPackage.Literals.ASSET__DAMAGE_DESCRIPTION ),
//		new Entry(DISPOSAL_DATE ,  DairyPackage.Literals.ASSET__DATE_DISPOSED ),
//		new Entry(DISPOSAL_DESCRIPTION ,  DairyPackage.Literals.ASSET__DISPOSAL_REASON ),
//		new Entry(DISPOSAL_WITNESS ,  DairyPackage.Literals.ASSET__DISPOSAL_WITNESS ),
	};
	
	private static final int[] mandatoryFields = { 
		/* LOG_BOOK_NUMBER, */ TYPE, REGISTRATION_NUMBER, MAKE, MODEL, YEAR
	};
	private Reader reader;
	private Dairy dairy;
	private int count = 0, errCount = 0;

	public VehicleImportTool(Dairy dairy, File f) throws FileNotFoundException {
		this(dairy, new FileReader(f));
	}

	public VehicleImportTool(Dairy dairy, InputStream f) {
		this(dairy, new InputStreamReader(f));
	}

	public VehicleImportTool(Dairy dairy, Reader reader) {
		this.dairy = dairy;
		this.reader = reader;
	}

	public void processFile() throws IOException {
		CsvReader csvReader = new CsvReader(reader);
		String[] headers = csvReader.getHeaders();
		validateHeaders(headers);
		while (csvReader.readRecord()) {
			String[] values = csvReader.getValues();
			try {
				validateRecord(values);
				Vehicle entity = createEntityFromRecord(values);
				validateEntity(entity);
				doImportRecord(entity);
				count++;
			} catch (Exception e) {
				errCount++;
				doImportRecordFailed(csvReader.getValues(), e);
			}
		}
		doImportComplete();
	}

	protected Vehicle createEntityFromRecord(String[] values) {
		Vehicle vehicle = DairyFactory.eINSTANCE.createVehicle();
//		EMFUtil.populate(vehicle);
		for (Entry entry : fieldMap) {
			String value = values[entry.field];
			Object converted = convert(entry.feature, value);
			System.err.printf("Setting %s: '%s'\n", entry.feature.getName(), converted);
			vehicle.eSet(entry.feature, converted);
		}
		return vehicle;
	}

	protected void doImportComplete() {
		System.out.printf("Processed %d records with %d failures\n", count + errCount, errCount);
	}

	private void validateHeaders(String[] headers) {
		// TODO Auto-generated method stub

	}

	protected void validateRecord(String[] values) {
		String val;
		for ( int i : mandatoryFields ) {
			val = values[i];
			if (val == null || val.trim().length() == 0) {
				throw new ValidationException("missing mandatory field " + i);
			}
		}
	}

	protected void validateEntity(Vehicle vehicle) {
		if (vehicle.getMake() == null) { 
			throw new ValidationException();
		}
		System.err.println(vehicle);
	}

	protected void doImportRecord(Vehicle vehicle) {
		if (dairy != null) {
			dairy.getVehicles().add(vehicle);
		}
		else {
			System.out.println(vehicle);
		}
	}

	protected void doImportRecordFailed(String[] values, Exception e) {
		e.printStackTrace();
	}

	protected Object convert(EStructuralFeature feature, String value) {
		Class<?> instanceClass = feature.getEType().getInstanceClass();
		Object retVal = value;
		if (Date.class.isAssignableFrom(instanceClass)) {
			try {
				retVal = new Date(value);
			} catch (Exception e) {
				retVal = null;
			}
		}
		else if (Integer.class.isAssignableFrom(instanceClass)) {
			System.err.println(">> Converting from " + value + " ("+ instanceClass + ") to Integer");
			try {
				retVal = new Integer(value);
			} catch (Exception e) {
				retVal = null;
			}
		}
		return retVal;
	}

	public static void main(String[] args) throws Exception {
		new VehicleImportTool(DairyRepository.getInstance().getLocalDairy(), new File(args[0])).processFile();
	}
}
