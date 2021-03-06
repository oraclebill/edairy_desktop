package com.agritrace.edairy.desktop.common.persistence.dao;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.FarmRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(FarmRepository.class)
public interface IFarmRepository extends IRepository<Farm> {
	/**
	 * Retrieves the list of all farms from the database. Unlike <code>all()</code>,
	 * it retrieves associated animals via eager fetching.
	 *
	 * @return List of all farms with preloaded animals
	 */
	List<Farm> allWithAnimals();

	List<Farm> allWithAnimalsAndCans();

	List<RegisteredAnimal> findRegisteredAnimals(Membership selectedMember, String farm,
			String species, String status);

	List<Container> findFarmContainers(List<Farm> selectedFarms);
}
