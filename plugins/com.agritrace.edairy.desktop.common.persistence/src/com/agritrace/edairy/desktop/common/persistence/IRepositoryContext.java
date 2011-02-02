package com.agritrace.edairy.desktop.common.persistence;

import org.eclipse.emf.ecore.EObject;

public interface IRepositoryContext {
	public <T extends EObject> IRepository<T> getRepository(Class<T> domainClass);
}
