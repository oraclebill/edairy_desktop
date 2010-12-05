package com.agritrace.edairy.desktop.common.ui.controllers;

public interface PersistenceDelegate<X> {
	public void setItem(X item);
//	public X getItem();
	public X getOrCreateItem();
	
	public X load(Object key);
	public void save(X obj);
	public void delete(X obj);
	public void saveRelated(Object obj);
	public void rollback(Object obj);
}
