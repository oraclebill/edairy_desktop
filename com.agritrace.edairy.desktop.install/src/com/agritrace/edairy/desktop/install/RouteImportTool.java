package com.agritrace.edairy.desktop.install;

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

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class RouteImportTool extends AbstractImportTool {

	public static final int BASE = 0;
	public static final int ROUTE_CODE = BASE;
	public static final int ROUTE_NAME = BASE + 1;
	public static final int ROUTE_DESCRIPTION = BASE + 2;

	private static final Entry[] fieldMap = {
			new Entry(ROUTE_CODE, DairyPackage.Literals.ROUTE__CODE),
			new Entry(ROUTE_NAME, DairyPackage.Literals.ROUTE__NAME),
			new Entry(ROUTE_DESCRIPTION,
					DairyPackage.Literals.ROUTE__DESCRIPTION), };

	private static final int[] mandatoryFields = { ROUTE_CODE, ROUTE_NAME };

	private Collection<Route> routes;
	private Map<String, List<String[]>> failedRecords;
	private Map<String, Object> routeCache;

	private int count = 0, errCount = 0;

	public RouteImportTool(InputStream input, List<Route> routes,
			Map<String, List<String[]>> errors, IProgressMonitor monitor) {
		super(new InputStreamReader(input));
		setMonitor(monitor);
		
		this.routes = routes;
		this.failedRecords = errors;

		Dairy dairy = DairyRepository.getInstance().getLocalDairy();
		routeCache = new HashMap<String, Object>();
		for (Route route : dairy.getRoutes()) {
			routeCache.put(route.getCode(), route);
		}
		
	}
	
	@Override
	protected String[] getExpectedHeaders() {
		return new String[] { "code", "name", null, null, "scale", null };
	}

	protected void validateRecord(String[] values) {
		super.validateRecord(values);
		Object route = routeCache.get(values[ROUTE_CODE]);
		if (route instanceof Route) {
			throw new ValidationException("Transport Route exists in database.");
		}
		if (route instanceof String[]) {
			throw new ValidationException("Duplicate route during import.");
		}
		routeCache.put(values[ROUTE_CODE], values);
	}
	
	protected int[] getMandatoryFieldIndexes() {
		return mandatoryFields;
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		count++;
		routes.add((Route)entity);
	}

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
		return DairyFactory.eINSTANCE.createRoute();
	}

	@Override
	protected List<Entry> getFields() {
		return Arrays.asList(fieldMap);
	}

	@Override
	protected void doImportComplete(int okCount, int failCount) {

	}


}
