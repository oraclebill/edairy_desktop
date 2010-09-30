package com.agritrace.edairy.desktop.internal.member.services.farm;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class FarmRepository extends HibernateRepository<Farm> implements IFarmRepository {
	@Inject
	protected FarmRepository(Provider<Session> sessionProvider, @Audit Provider<Session> auditProvider) {
		super(sessionProvider, auditProvider);
	}

	@Override
	protected Class<?> getClassType() {
		return Farm.class;
	}

	@Override
	public List<Farm> allWithAnimals() {
		return allWithEagerFetch("animals");
	}

	@Override
	public List<Farm> allWithAnimalsAndCans() {
		return allWithEagerFetch("animals", "cans");
	}
}
