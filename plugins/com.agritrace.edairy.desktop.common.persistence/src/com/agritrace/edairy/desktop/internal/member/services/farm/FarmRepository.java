package com.agritrace.edairy.desktop.internal.member.services.farm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class FarmRepository extends RepositoryUtil<Farm> implements IFarmRepository {
	@Inject
	protected FarmRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}

	@Override
	public List<Farm> all() {
		return allWithAnimals();
	}


	@Override
	@Transactional
	public List<Farm> allWithAnimals() {
		return allWithEagerFetch("animals");
	}

	@Override
	@Transactional
	public List<Farm> allWithAnimalsAndCans() {
		return allWithEagerFetch("animals", "cans");
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<RegisteredAnimal> findRegisteredAnimals(Membership selectedMember, String farm, String species,
			String status) {
		Criteria query = getCurrentSession().createCriteria("RegisteredAnimal");
		
//		assert selectedMember == null;
//		
//		if (farm != null) {
//			query.add(Restrictions.ilike("location.name", farm));
//		}
//		if (species != null) {
//			query.add(Restrictions.ilike("animalType.species", species));
//		}
		return (List<RegisteredAnimal>) query.list();
	}
	
	@Transactional
	private List<Farm> allWithEagerFetch(final String... paths) {
		final Criteria crit = getCurrentSession().createCriteria("Farm");

		if (paths != null) {
			for (final String path : paths) {
				crit.setFetchMode(path, FetchMode.JOIN);
			}
		}

		@SuppressWarnings("unchecked")
		final List<Farm> result = crit.list();
		return result;
	}


}
