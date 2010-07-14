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

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.csvreader.CsvReader;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class EmployeeImportTool {

	public static final int BASE = 0;
	public static final int EMPLOYEE_ID = BASE;
	public static final int GIVEN_NAME = BASE + 1;
	public static final int MIDDLE_NAME = BASE + 2;
	public static final int FAMILY_NAME = BASE + 3;
	public static final int JOB_TITLE = BASE + 4;
	public static final int DATE_STARTED = BASE + 5;
	public static final int NATIONAL_ID = BASE + 6;
	public static final int NSSF_NUMBER = BASE + 7;
	public static final int NHIF_NUMBER = BASE + 8;

	private static final Entry[] fieldMap = { new Entry(EMPLOYEE_ID, DairyPackage.Literals.EMPLOYEE__ID),
			new Entry(GIVEN_NAME, ModelPackage.Literals.PERSON__GIVEN_NAME),
			new Entry(MIDDLE_NAME, ModelPackage.Literals.PERSON__MIDDLE_NAME),
			new Entry(FAMILY_NAME, ModelPackage.Literals.PERSON__FAMILY_NAME),
			new Entry(JOB_TITLE, DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION),
			new Entry(DATE_STARTED, DairyPackage.Literals.EMPLOYEE__START_DATE),
			new Entry(NATIONAL_ID, DairyPackage.Literals.EMPLOYEE__NATIONAL_ID),
			new Entry(NSSF_NUMBER, DairyPackage.Literals.EMPLOYEE__NSSF_NUMBER),
			new Entry(NHIF_NUMBER, DairyPackage.Literals.EMPLOYEE__NHIF_NUMBER), };

	private Reader reader;
	private Dairy dairy;
	private int count = 0, errCount = 0;

	public EmployeeImportTool(Dairy dairy, File f) throws FileNotFoundException {
		this(dairy, new FileReader(f));
	}

	public EmployeeImportTool(Dairy dairy, InputStream f) {
		this(dairy, new InputStreamReader(f));
	}

	public EmployeeImportTool(Dairy dairy, Reader reader) {
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
				validateCurrentRecord(values);
				Employee employee = DairyFactory.eINSTANCE.createEmployee();
//				EMFUtil.populate(employee);
				for (Entry entry : fieldMap) {
					String value = csvReader.get(entry.field);
					employee.eSet(entry.feature, convert(entry.feature, value));
				}
				count++;
				validateEmployee(employee);
				doImportRecord(employee);

			} catch (Exception e) {
				errCount++;
				doImportRecordFailed(csvReader.getValues(), e);
			}
		}
		doImportComplete();
	}

	protected void doImportComplete() {
		System.out.printf("Processed %d records with %d failures\n", count + errCount, errCount);
	}

	private void validateHeaders(String[] headers) {
		// TODO Auto-generated method stub

	}

	protected void validateCurrentRecord(String[] values) {
		String val = values[EMPLOYEE_ID];
		if (val == null || val.trim().length() == 0)
			throw new ValidationException("null id");
	}

	protected void validateEmployee(Employee employee) {

	}

	protected void doImportRecord(Employee employee) {
		if (dairy != null) {
			employee.setLocation(DairyUtil.createLocation(null, null,null));
			dairy.getEmployees().add(employee);
		}
		else {
			System.out.println(employee);
		}
	}

	protected void doImportRecordFailed(String[] values, Exception e) {
		e.printStackTrace();
	}

	private Object convert(EStructuralFeature feature, String value) {
		Class<?> instanceClass = feature.getEType().getInstanceClass();
		Object retVal = value;
		if (Date.class.isAssignableFrom(instanceClass)) {
			try {
				retVal = new Date(value);
			} catch (Exception e) {
				retVal = null;
			}
		}
		return retVal;
	}

	public static void main(String[] args) throws Exception {
		new EmployeeImportTool(DairyRepository.getInstance().getLocalDairy(), new File(args[0])).processFile();
	}
}
