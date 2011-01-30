package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;

public class DirectoryPersistenceDelegate<P extends EObject> extends AbstractPersistenceDelegate<P> {
	AbstractDirectoryController<P> directoryController;
	
	public DirectoryPersistenceDelegate(AbstractDirectoryController<P> controller) {
		this.directoryController = controller;
	}
	
	@Override
	public P load(Object key) {
		return directoryController.getRepository().findByKey((Long) key);
	}

	@Override
	public void delete(P obj) {
		directoryController.getRepository().delete( obj);
	}

//	@Override
//	public void saveRelated(Object obj) {
//		directoryController.getRepository().save(obj);
//	}

	@Override
	public void rollback(Object obj) {
		// TODO: 
//		throw new UnsupportedOperationException("unimplemented");
	}
	
	@Override
	public P createItem() {
		return directoryController.createNewModel();
	}

	@Override
	public void persistNew(P obj) {
		directoryController.createEntity(obj);
	}

	@Override
	public P updateExisting(P obj) {
		directoryController.updateEntity(obj);
		return obj;
	}

}