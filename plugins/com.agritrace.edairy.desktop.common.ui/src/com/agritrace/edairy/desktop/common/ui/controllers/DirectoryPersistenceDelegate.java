package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;

public class DirectoryPersistenceDelegate<P extends EObject> implements PersistenceDelegate<P> {
	private P item;
	private boolean created;
	private AbstractDirectoryController<P> directoryController;

	public DirectoryPersistenceDelegate(AbstractDirectoryController<P> controller) {
		this.directoryController = controller;
		this.created = false;
	}
	
	@Override
	public void setItem(P item) {
		this.item = item;
	}

	@Override
	public P getItem() {
		if (item == null) {
			setItem(createItem());
			created =  true;
		}
		return item;
	}

	@Override
	public P load(Object key) {
		return directoryController.getRepository().findByKey((Long) key);
	}

	@Override
	public void save(P obj) {
		if (created)
			directoryController.getRepository().saveNew(obj);
		else
			directoryController.getRepository().save(obj);
	}

	@Override
	public void delete(P obj) {
		directoryController.getRepository().delete( obj);
	}

	@Override
	public void saveRelated(Object obj) {
		directoryController.getRepository().save(obj);
	}

	@Override
	public void rollback(Object obj) {
		// TODO: 
//		throw new UnsupportedOperationException("unimplemented");
	}
	
	@Override
	public P createItem() {
		return directoryController.createNewModel();
	}

}