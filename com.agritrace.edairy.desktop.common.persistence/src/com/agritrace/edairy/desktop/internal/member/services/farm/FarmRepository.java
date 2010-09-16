package com.agritrace.edairy.desktop.internal.member.services.farm;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;

public class FarmRepository extends HibernateRepository<Farm> implements IFarmRepository {
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
