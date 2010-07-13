package com.agritrace.edairy.desktop.install;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.csvreader.CsvReader;

public abstract class AbstractImportTool {

	protected Reader reader;
	private int count = 0;
	private int errCount = 0;

	public AbstractImportTool() {
		super();
	}

	public void processFile() throws IOException {
		CsvReader csvReader = new CsvReader(reader);
		String[] headers = csvReader.getHeaders();
		validateHeaders(headers);
		while (csvReader.readRecord()) {
			String[] values = csvReader.getValues();
			try {
				validateRecord(values);
				EObject entity = createEntityFromRecord(values);
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

	abstract protected void doImportRecord(Object entity) ;

	protected EObject createEntityFromRecord(String[] values) {
			EObject entity = createBlankEntity();
	//		EMFUtil.populate(vehicle);
			for (Entry entry : getFields()) {
				String value = values[entry.field];
				Object converted = convert(entry.feature, value);
				System.err.printf("Setting %s: '%s'\n", entry.feature.getName(), converted);
				entity.eSet(entry.feature, converted);
			}
			return entity;
		}

	abstract protected EObject createBlankEntity();

	protected abstract List<Entry> getFields();

	protected void doImportComplete() {
		System.out.printf("Processed %d records with %d failures\n", count + errCount, errCount);
	}

	private void validateHeaders(String[] headers) {
		// TODO Auto-generated method stub
	
	}

	protected void validateRecord(String[] values) {
		String val;
		for ( int i : getMandatoryFieldIndexes() ) {
			val = values[i];
			if (val == null || val.trim().length() == 0) {
				throw new ValidationException("missing mandatory field " + i);
			}
		}
	}

	abstract protected int[] getMandatoryFieldIndexes();

	protected void validateEntity(EObject vehicle) {
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

}