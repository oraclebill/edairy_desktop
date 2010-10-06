package com.agritrace.edairy.desktop.internal.common.persistence;

import java.util.List;

import org.eclipse.emf.teneo.hibernate.HbDataStore;

import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.google.inject.Inject;

public class AltRoleRepository extends RepositoryUtil<Role> implements IRepository<Role> {

	@Inject
	public AltRoleRepository(HbDataStore store) {
		super(store);
	}

	@Override
	public List<Role> all() {
		return getCurrentSession().createQuery("FROM Role").list();
	}

}
