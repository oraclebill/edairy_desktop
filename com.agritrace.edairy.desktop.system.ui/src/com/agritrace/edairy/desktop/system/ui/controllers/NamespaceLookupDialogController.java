package com.agritrace.edairy.desktop.system.ui.controllers;

import java.util.SortedMap;
import java.util.TreeMap;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.PermissionNamespace;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;

public final class NamespaceLookupDialogController {
	private IRepository<PermissionNamespace> repository;
	
	public NamespaceLookupDialogController() {
		repository = RepositoryFactory.getRepository(PermissionNamespace.class);
	}
	
	public SortedMap<String, PermissionNamespace> findAll() {
		final SortedMap<String, PermissionNamespace> all = new TreeMap<String, PermissionNamespace>();
		
		for (PermissionNamespace ns: repository.all()) {
			all.put(ns.getName(), ns);
		}
		
		return all;
	}
	
	public void add(String namespaceName) {
		if (findAll().containsKey(namespaceName))
			throw new IllegalArgumentException("A namespace with this name already exists");
		
		PermissionNamespace namespace = DairyFactory.eINSTANCE.createPermissionNamespace();
		namespace.setName(namespaceName);
		repository.saveNew(namespace);
	}
	
	public void delete(PermissionNamespace namespace) {
		repository.delete(namespace);
	}
}
