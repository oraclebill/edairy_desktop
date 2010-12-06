package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;

public interface PersistenceDelegate<X extends EObject> {
	public void setItem(X item);
	public X getItem();
	public X createItem();
//	public X getOrCreateItem();
	
	public X load(Object key);
	public void save(X obj);
	public void delete(X obj);
	public void saveRelated(Object obj);
	public void rollback(Object obj);
}
