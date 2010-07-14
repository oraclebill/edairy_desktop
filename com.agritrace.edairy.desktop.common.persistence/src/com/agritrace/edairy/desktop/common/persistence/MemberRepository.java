package com.agritrace.edairy.desktop.common.persistence;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class MemberRepository implements IMemberRepository {

	private final IRepository<Membership> driver;
	private final DairyRepository dairyRepo;
	private final Dairy localDairy;

	private final IRepository<AccountTransaction> transactionRepository = new HibernateRepository<AccountTransaction>() {

		@Override
		protected Class<?> getClassType() {
			return AccountTransaction.class;
		}
	};


	/**
	 * No arg constructor for normal case will initialize using static
	 * PersistenceManager.
	 */
	public MemberRepository() {
		this( new HibernateRepository<Membership>() {
			@Override
			protected Class<Membership> getClassType() {
				return Membership.class;
			}
		});
	}

	/**
	 * For testing.
	 * 
	 * @param driver
	 */
	public MemberRepository(IRepository<Membership> driver) {
		this.driver = driver;
		dairyRepo = DairyRepository.getInstance();
		localDairy = dairyRepo.getLocalDairy();
	}

	@Override
	public List<Membership> getMemberships() {
		return localDairy.getMemberships();
//		return driver.all();
	}

	@Override
	public void delete(Membership deletableEntity) throws NonExistingEntityException {
		driver.delete(deletableEntity);
	}

	@Override
	public List<Membership> find(String rawQuery) {
		// TODO Auto-generated method stub
		return (List<Membership>) driver.find(rawQuery);
	}

	@Override
	public List<Membership> find(String query, Object[] params) {
		return (List<Membership>) driver.find(query, params);
	}

	@Override
	public Membership findByKey(long key) {
		return driver.findByKey(key);
	}

	@Override
	public List<Farm> getMemberFarms() {
		return (List<Farm>) driver.find("FROM Farm");
	}

	@Override
	public IRepository<AccountTransaction> getTransactionRepository() {
		return transactionRepository;
	}

	@Override
	public void save(Object obj) {
		driver.save(obj);
	}

	@Override
	public void saveNew(Membership newEntity) throws AlreadyExistsException {
		Account memberAccount = AccountFactory.eINSTANCE.createAccount();
		memberAccount.setMember(newEntity);
		driver.saveNew(newEntity);
	}

	@Override
	public void update(Membership updateableEntity) throws NonExistingEntityException {
		driver.update(updateableEntity);
	}

}
