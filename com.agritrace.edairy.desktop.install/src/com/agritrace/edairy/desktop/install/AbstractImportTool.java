package com.agritrace.edairy.desktop.install;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

	public AbstractImportTool(File f) throws FileNotFoundException {
		this(new FileReader(f));
	}

	public AbstractImportTool(InputStream f) {
		this(new InputStreamReader(f));
	}

	public AbstractImportTool(Reader reader) {
		this.reader = reader;
	}

	public void processFile() throws IOException {
		CsvReader csvReader = new CsvReader(reader);
		csvReader.readRecord();
		String[] headers = csvReader.getValues();
		validateHeaders(headers);
		while (csvReader.readRecord()) {
			String[] values = csvReader.getValues();
			try {
				processRecord(values);
				count++;
			} catch (Exception e) {
				errCount++;
				doImportRecordFailed(values, e);
			}
		}
		System.out.printf("Processed %d records with %d failures\n", count + errCount, errCount);
		doImportComplete();
	}

	protected void processRecord(String[] values) {
		validateRecord(values);
		EObject entity = createEntityFromRecord(values);
		validateEntity(entity);
		saveImportedEntity(entity);
	}

	abstract protected void saveImportedEntity(Object entity);

	protected EObject createEntityFromRecord(String[] values) {
		EObject entity = createBlankEntity();
		// EMFUtil.populate(vehicle);
		for (Entry entry : getFields()) {
			String value = values[entry.field];
			Object converted = convert(entry.feature, value);
			// System.err.printf("Setting %s: '%s'\n", entry.feature.getName(),
			// converted);
			entity.eSet(entry.feature, converted);
		}
		return entity;
	}

	/**
	 * create a fresh entity, initialized with any defaults.
	 * 
	 * @return
	 */
	abstract protected EObject createBlankEntity();

	/**
	 * Called from 'createEntityFromRecord', provides the field mappings necessary to construct a new
	 * entity from an import record (string array).
	 * 
	 * @return a list of field to attribute mappings.
	 */
	abstract protected List<Entry> getFields();

	abstract protected void doImportComplete(); 

	protected void validateHeaders(String[] actualHeaders) {
		String errorMessage = null;
		String[] expectedHeaders = getExpectedHeaders();
		if (expectedHeaders != null) {
			if (actualHeaders.length != expectedHeaders.length)
				throw new ValidationException("Number of fields does not match - found " + actualHeaders.length
						+ " expected " + expectedHeaders.length);
			for (int i = 0; i < expectedHeaders.length; i++) {
				if (expectedHeaders[i] == null) continue;
				if (!expectedHeaders[i].equals(actualHeaders[i])) {
					if (errorMessage == null) {
						errorMessage = "Mismatched headers: \n";
					}
					errorMessage += "    " + i + " - was: '" + actualHeaders[i] + "', expected '" + expectedHeaders[i]
							+ "'\n";
				}
			}
			if (errorMessage != null)
				throw new ValidationException(errorMessage);
		}
	}

	abstract protected String[] getExpectedHeaders();

	protected void validateRecord(String[] values) {
		String val;
		for (int i : getMandatoryFieldIndexes()) {
			val = values[i];
			if (val == null || val.trim().length() == 0) {
				throw new ValidationException("missing mandatory field " + i);
			}
		}
	}

	protected int[] getMandatoryFieldIndexes() {
		throw new UnsupportedOperationException("unimplemented");
	}

	abstract protected void validateEntity(EObject obj);

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
		} else if (Integer.class.isAssignableFrom(instanceClass)) {
			System.err.println(">> Converting from " + value + " (" + instanceClass + ") to Integer");
			try {
				retVal = new Integer(value);
			} catch (Exception e) {
				retVal = null;
			}
		}
		return retVal;
	}

}