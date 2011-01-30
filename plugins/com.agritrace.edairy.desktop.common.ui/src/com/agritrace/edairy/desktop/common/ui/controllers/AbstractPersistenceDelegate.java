package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractPersistenceDelegate<P extends EObject> implements PersistenceDelegate<P> {

	private P item;
	private boolean created;

	public abstract P createItem();
	public abstract void persistNew(P obj);
	public abstract P updateExisting(P obj);

	
	public AbstractPersistenceDelegate() {
		created = false;
	}

	public void setItem(P item) {
		this.item = item;
	}

	public P getItem() {
		if (item == null) {
			setItem(createItem());
			created = true;
		}
		return item;
	}

	public void save(P obj) {
		if (created)
			persistNew(obj);
		else
			updateExisting(obj);
	}

}