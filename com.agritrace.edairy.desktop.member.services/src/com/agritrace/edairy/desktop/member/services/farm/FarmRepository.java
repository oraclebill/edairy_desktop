package com.agritrace.edairy.desktop.member.services.farm;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class FarmRepository extends HibernateRepository<Farm> implements IFarmRepository {

	@Override
	protected Class<?> getClassType() {
		return Farm.class;
	}
	

}
