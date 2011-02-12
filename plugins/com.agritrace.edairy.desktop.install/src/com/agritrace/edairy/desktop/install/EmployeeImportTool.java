package com.agritrace.edairy.desktop.install;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;
import com.csvreader.CsvReader;
import com.google.inject.Inject;

/**
 * Create a dairy configuration by importing excel data in standard format.
 *
 * @author bjones
 *
 */
public class EmployeeImportTool extends AbstractImportTool {

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

	private static final Entry[] fieldMap = {
			new Entry(EMPLOYEE_ID, DairyPackage.Literals.EMPLOYEE__EMPLOYEE_NUMBER),
			new Entry(GIVEN_NAME, ModelPackage.Literals.PERSON__GIVEN_NAME),
			new Entry(MIDDLE_NAME, ModelPackage.Literals.PERSON__MIDDLE_NAME),
			new Entry(FAMILY_NAME, ModelPackage.Literals.PERSON__FAMILY_NAME),
			new Entry(JOB_TITLE, DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION),
			new Entry(DATE_STARTED, DairyPackage.Literals.EMPLOYEE__START_DATE),
			new Entry(NATIONAL_ID, ModelPackage.Literals.PERSON__NATIONAL_ID),
			new Entry(NSSF_NUMBER, ModelPackage.Literals.PERSON__NSSF_NUMBER),
			new Entry(NHIF_NUMBER, ModelPackage.Literals.PERSON__NHIF_NUMBER), };

	String[] expectedHeaders = { "employee name","given name","middle name","family name","job title","date started","national name","nssf number","nhif number" };

	private List<Employee> empList;
	Map<String, List<String[]>> errors;
	private Map<String, Object> employeeCache;

	private final IDairyRepository dairyRepo;

	private Reader reader;
	private int count = 0, errCount = 0;

	@Inject
	public EmployeeImportTool(final IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;

	}

	public void processFile(InputStream input, List<Employee> successes,
			Map<String, List<String[]>> errors, IProgressMonitor monitor) throws IOException {
		this.empList = successes;
		this.errors = errors;
		reader = new BufferedReader(new InputStreamReader(input));

		final Dairy dairy = dairyRepo.getLocalDairy();
		employeeCache = new HashMap<String, Object>();
		for (final Employee member : dairy.getEmployees()) {
			employeeCache.put(member.getEmployeeNumber(), member);
		}

		final CsvReader csvReader = new CsvReader(reader);
		csvReader.readRecord();
		final String[] headers = csvReader.getValues();
		validateHeaders(headers);
		while (csvReader.readRecord()) {
			checkCancelled();
			final String[] values = csvReader.getValues();
			try {
				validateCurrentRecord(values);
				final Employee employee = DairyFactory.eINSTANCE.createEmployee();
				// EMFUtil.populate(employee);
				for (final Entry entry : fieldMap) {
					final String value = csvReader.get(entry.field);
					employee.eSet(entry.feature, convert(entry.feature, value));
				}
				employee.setDepartment(EmployeeReference.getDepartmentForPosition(employee.getJobFunction()));
				count++;
				empList.add(employee);

			} catch (final Exception e) {
				errCount++;
				doImportRecordFailed(csvReader.getValues(), e);
			}
			worked(count + errCount);
		}
	}

	protected void validateCurrentRecord(String[] values) {
		final String val = values[EMPLOYEE_ID];
		if (val == null || val.trim().length() == 0) {
			throw new ValidationException("Record has no ID");
		}
		final Object obj = employeeCache.get(val);
		if (obj instanceof Employee) {
			throw new ValidationException("Employee ID already exists in database.");
		}
		if (obj instanceof String[]) {
			throw new ValidationException("Duplicate ID in import batch.");
		}
		employeeCache.put(val, values);
	}

	@Override
	protected void doImportRecordFailed(String[] values, Exception e) {
		List<String[]> recList = errors.get(e.getMessage());
		if (recList == null) {
			recList = new LinkedList<String[]>();
			errors.put(e.getMessage(), recList);
		}
		recList.add(values);
	}


	@Override
	protected void saveImportedEntity(Object entity) {
		// TODO Auto-generated method stub

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
	protected void doImportComplete(int okCount, int failCount) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String[] getExpectedHeaders() {
		return expectedHeaders;
	}

}
