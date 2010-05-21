package com.agritrace.edairy.desktop.common.ui.managers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

public interface IDairyResourceManager extends IAccountTransactionSearch {

    public static final String XMLDB_BASE = System.getProperty("edairy.db.root", "c:/temp/edairy");

    // public static final String XMLDB_BASE = "/tmp";

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

    public abstract void store(EObject updatedObject);

}