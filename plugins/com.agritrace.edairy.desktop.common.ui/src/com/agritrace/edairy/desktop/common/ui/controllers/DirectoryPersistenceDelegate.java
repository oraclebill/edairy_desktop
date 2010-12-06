package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;

public class DirectoryPersistenceDelegate<P extends EObject> implements PersistenceDelegate<P> {
	private P item;
	private AbstractDirectoryController<P> directoryController;

	public DirectoryPersistenceDelegate(AbstractDirectoryController<P> controller) {
		this.directoryController = controller;
	}
	
	@Override
	public void setItem(P item) {
		this.item = item;
	}

	@Override
	public P getOrCreateItem() {
		if (item == null) {
			item = createItem();
		}
		return item;
	}

	@Override
	public P load(Object key) {
		return directoryController.getRepository().findByKey((Long) key);
	}

	@Override
	public void save(P obj) {
		directoryController.getRepository().saveNew(obj);
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
		throw new UnsupportedOperationException("unimplemented");
	}
	
	protected P createItem() {
		return directoryController.createNewModel();
	}

}