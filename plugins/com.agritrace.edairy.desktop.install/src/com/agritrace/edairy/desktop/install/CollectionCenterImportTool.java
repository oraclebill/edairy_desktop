package com.agritrace.edairy.desktop.install;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.google.inject.Inject;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class CollectionCenterImportTool extends AbstractImportTool {

	public static final int BASE = 0;
	public static final int CENTER_CODE = BASE;
	public static final int CENTER_NAME = BASE + 1;
	public static final int CENTER_DESCRIPTION = BASE + 2;

	private static final Entry[] fieldMap = {
			new Entry(CENTER_CODE, DairyPackage.Literals.DAIRY_LOCATION__CODE),
			new Entry(CENTER_NAME, DairyPackage.Literals.DAIRY_LOCATION__NAME),
			new Entry(CENTER_DESCRIPTION,
					DairyPackage.Literals.DAIRY_LOCATION__DESCRIPTION), };

	private static final int[] mandatoryFields = { CENTER_CODE, CENTER_NAME };

	private Collection<DairyLocation> centers;
	private Map<String, List<String[]>> failedRecords;
	private Map<String, Object> centerCache;

	private int count = 0, errCount = 0;

	@Inject
	public CollectionCenterImportTool(List<DairyLocation> locations) {
		centerCache = new HashMap<String, Object>();
		for (final DairyLocation loc : locations) {
			centerCache.put(loc.getCode(), loc);
		}
	}

	public void processFile(InputStream input, List<DairyLocation> centers,
			Map<String, List<String[]>> errors, IProgressMonitor monitor)
			throws IOException {
		setReader(new InputStreamReader(input));
		setMonitor(monitor);

		this.centers = centers;
		this.failedRecords = errors;

		super.processFile();
	}

	@Override
	protected String[] getExpectedHeaders() {
		return new String[] { "code", "name", null, null, "scale" };
	}

	@Override
	protected void validateRecord(String[] values) {
		super.validateRecord(values);
		final Object center = centerCache.get(values[CENTER_CODE]);

		if (center instanceof DairyLocation) {
			throw new ValidationException(
					"Collection center exists in database.");
		}

		if (center instanceof String[]) {
			throw new ValidationException(
					"Duplicate collection center during import.");
		}

		centerCache.put(values[CENTER_CODE], values);
	}

	@Override
	protected int[] getMandatoryFieldIndexes() {
		return mandatoryFields;
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		count++;
		centers.add((DairyLocation) entity);
	}

	@Override
	protected void doImportRecordFailed(String[] values, Exception e) {
		errCount++;
		final String message = e.getMessage();
		List<String[]> records = failedRecords.get(message);

		if (records == null) {
			records = new LinkedList<String[]>();
			failedRecords.put(message, records);
		}

		records.add(values);
	}

	@Override
	protected EObject createBlankEntity() {
		final DairyLocation loc = DairyFactory.eINSTANCE.createDairyLocation();
		loc.getFunctions().add(DairyFunction.MILK_COLLECTION);
		// TODO: These should be filled from somewhere.
		loc.setLocation(DairyUtil.createLocation(null, null, null));
		return loc;
	}

	@Override
	protected List<Entry> getFields() {
		return Arrays.asList(fieldMap);
	}

	@Override
	protected void doImportComplete(int okCount, int failCount) {

	}
}
