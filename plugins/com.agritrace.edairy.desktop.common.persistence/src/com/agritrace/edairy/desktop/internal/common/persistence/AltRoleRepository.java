package com.agritrace.edairy.desktop.internal.common.persistence;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AltRoleRepository extends RepositoryUtil<Role> implements IRepository<Role> {

	@Inject
	public AltRoleRepository(Provider<Session> provider) {
		super(provider);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Role> all() {
		return getCurrentSession().createQuery("FROM Role").list();
	}

}
