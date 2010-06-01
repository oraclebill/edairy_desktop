package com.agritrace.edairy.desktop.member.services.member;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class MemberRepository implements IRepository<Membership> {
	
	private final IRepository<Membership> driver;

	public MemberRepository() {
		this.driver = new HibernateRepository<Membership>() {
			@Override
			protected Class<Membership> getClassType() {
				return Membership.class;
			}
		};
	}
	
	public MemberRepository(IRepository<Membership> driver) {
		this.driver = driver;
	}
	
	public List<Membership> getMembers() {
		return driver.all();
	}

	@Override
	public List<Membership> find(String rawQuery) {
		// TODO Auto-generated method stub
		return driver.find(rawQuery);
	}

	@Override
	public List<Membership> find(String query, Object[] params) {
		return driver.find(query, params);
	}

	@Override
	public List<Membership> all() {
		return driver.all();
	}

	@Override
	public Membership findByKey(long key) {
		return driver.findByKey(key);
	}

	@Override
	public void saveNew(Membership newEntity) throws AlreadyExistsException {
		driver.saveNew(newEntity);
	}

	@Override
	public void update(Membership updateableEntity) throws NonExistingEntityException {
		driver.update(updateableEntity);
	}

	@Override
	public void delete(Membership deletableEntity) throws NonExistingEntityException {
		driver.delete(deletableEntity);
	}

	
}
