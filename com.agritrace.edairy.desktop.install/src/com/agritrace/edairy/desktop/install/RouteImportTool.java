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
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.csvreader.CsvReader;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class RouteImportTool {


	public static final int BASE = 0;
	public static final int ROUTE_CODE = BASE;
	public static final int ROUTE_NAME = BASE + 1;
	public static final int ROUTE_DESCRIPTION = BASE + 2;

	private static final Entry[] fieldMap = { 
		new Entry(ROUTE_CODE ,  DairyPackage.Literals.ROUTE__CODE ),
		new Entry(ROUTE_NAME ,  DairyPackage.Literals.ROUTE__NAME ),
		new Entry(ROUTE_DESCRIPTION ,  DairyPackage.Literals.ROUTE__DESCRIPTION ),
	};
	
	private static final int[] mandatoryFields = { 
		ROUTE_CODE, ROUTE_NAME
	};
	
	private Reader reader;
	private Dairy dairy;
	private int count = 0, errCount = 0;

	public RouteImportTool(Dairy dairy, File f) throws FileNotFoundException {
		this(dairy, new FileReader(f));
	}

	public RouteImportTool(Dairy dairy, InputStream f) {
		this(dairy, new InputStreamReader(f));
	}

	public RouteImportTool(Dairy dairy, Reader reader) {
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
				Route entity = createEntityFromRecord(values);
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

	protected Route createEntityFromRecord(String[] values) {
		Route vehicle = DairyFactory.eINSTANCE.createRoute();
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

	protected void validateEntity(Route vehicle) {
		if (vehicle.getCode() == null || vehicle.getName() == null) { 
			throw new ValidationException();
		}
		System.err.println(vehicle);
	}

	protected void doImportRecord(Route vehicle) {
		if (dairy != null) {
			dairy.getRoutes().add(vehicle);
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
		new RouteImportTool(DairyRepository.getInstance().getLocalDairy(), new File(args[0])).processFile();
	}
}
