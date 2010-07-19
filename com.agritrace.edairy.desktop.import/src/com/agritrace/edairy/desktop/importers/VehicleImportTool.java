package com.agritrace.edairy.desktop.importers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
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

	Dairy dairy;

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

	@Override
	protected List<Entry> getFields() {
		return Arrays.asList(
				fieldMap);
	}

	@Override
	protected int[] getMandatoryFieldIndexes() {
		return new int[] { 
				REGISTRATION_NUMBER, MAKE, MODEL, YEAR };
	}

	@Override
	protected void validateEntity(EObject object) {
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		if (dairy != null) {
			dairy.getVehicles().add((Vehicle) entity);
		} else {
			System.out.println(entity);
		}
	}

	@Override
	protected EObject createBlankEntity() {
		return DairyFactory.eINSTANCE.createVehicle();
	}

}
