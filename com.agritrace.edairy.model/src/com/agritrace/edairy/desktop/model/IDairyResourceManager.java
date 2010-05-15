package com.agritrace.edairy.desktop.model;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.tracking.Farm;

public interface IDairyResourceManager {

    public static final String XMLDB_BASE = System.getProperty("edairy.db.root", "c:/temp/edairy");

    //	public static final String XMLDB_BASE = "/tmp";

    public abstract void createFarmResource();

    public abstract void createDairyResource() throws ParseException;

    public abstract void createDairyResource(String baseDir) throws ParseException;

    public abstract void loadFarmResources();

    public abstract void loadDairyResources();

    public abstract void reLoadDairyResource();

    public abstract Dairy getLocalDairy();

    public abstract <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type) throws CoreException;

    public abstract void addFarm(Farm newFarm);

    public abstract void saveDairyResource() throws IllegalArgumentException, IOException;

    public abstract void saveFarmResource();

}