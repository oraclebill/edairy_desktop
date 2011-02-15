package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.exceptions.AlreadyExistsException;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MemberRepository extends RepositoryUtil<Membership> implements IMemberRepository {

	private IDairyRepository dairyRepo;
	
	@Inject
	public MemberRepository(Provider<Session> provider, IDairyRepository dairyRepo) {
		super(provider);
		this.dairyRepo = dairyRepo;
	}

	@Transactional
	@Override
	public Membership findByMemberNumber(String memberNumber) {
		Query memberQuery = getCurrentSession().createQuery("FROM Membership where memberNumber = ?");
		memberQuery.setString(0, memberNumber);
		return (Membership) memberQuery.uniqueResult();
	}


	@Transactional
	@Override
	public void delete(Membership member) {
		member.setStatus(MembershipStatus.DELETED);
		save(member);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Membership> all() {
		final Criteria criteria = getCurrentSession().createCriteria("Membership");
//		criteria.setFetchMode("transactions", FetchMode.SELECT);
		criteria.add(
				Restrictions.eq(DairyPackage.Literals.MEMBERSHIP__DAIRY.getName(), getLocalDairy()));
		criteria.add(
				Restrictions.ne(DairyPackage.Literals.MEMBERSHIP__STATUS.getName(), MembershipStatus.DELETED));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Account> allAccounts() {
		final Criteria criteria = getCurrentSession().createCriteria("Account");
		criteria.setFetchMode("transactions", FetchMode.SELECT);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Farm> getMemberFarms() {
		return getCurrentSession().createCriteria(Farm.class).list();
	}

	@Transactional
	@Override
	public void saveNew(Membership newEntity) throws AlreadyExistsException {

		if (newEntity.getMemberNumber() == null || newEntity.getMemberNumber().trim().length() == 0) {
			final int size = getLocalDairy().getMemberships().size();
			final long count = getLocalDairy().getVersion();
			newEntity.setMemberNumber("A" + count + "" + size);
			// throw new RepositoryException("Member number cannot be null");
		}

		if (newEntity.getMemberNumber() == null || newEntity.getMemberNumber().length() < 5) {
			throw new RepositoryException("Invalid member number: '" + newEntity.getMemberNumber() + "'");
		}

		Account memberAccount = newEntity.getAccount();
		if (newEntity.getAccount() == null) {
			memberAccount = AccountFactory.eINSTANCE
					.createAccount();
			memberAccount.setMember(newEntity);
		}
		memberAccount.setAccountNumber("V" + newEntity.getMemberNumber());

		if (!getLocalDairy().getMemberships().contains(newEntity)) {
			getLocalDairy().getMemberships().add(newEntity);
		}
		getDairyRepository().save(getLocalDairy());
	}

	@Transactional
	@Override
	public void update(Membership member) {
		save(member);
	}

	@Transactional
	@Override
	public Account findAccountByMemberNo(String memberNo) {
		final Criteria query = getCurrentSession().createCriteria("Membership").add(
				Restrictions.eq(DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER.getName(), memberNo));
		final Membership member = (Membership) query.uniqueResult();
		return member != null ? member.getAccount() : null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<AccountTransaction> findAccountTransactions(Account account, Date start, Date end, String refNum,
			List<TransactionSource> sources) {
		final Session session = getCurrentSession();
		final Criteria criteria = session.createCriteria("AccountTransaction");

		if (account != null) {
			criteria.add(Restrictions.eq("account", account));
		}
		if (start != null) {
			criteria.add(Restrictions.ge("transactionDate", start));
		}
		if (end != null) {
			criteria.add(Restrictions.le("transactionDate", end));
		}

		if (refNum != null) {
			criteria.add(Restrictions.like("referenceNumber", end));
		}

		if (sources != null && sources.size() > 0) {
			criteria.add(Restrictions.in("source", sources));
		}

		return criteria.list();
	}

	@Transactional
	@Override
	public List<AccountTransaction> findAccountTransactions(Account account, Date start, Date end) {
		return findAccountTransactions(account, start, end, null, null);
	}

	private final Dairy getLocalDairy() {
		return dairyRepo.getLocalDairy();
	}

	private final IDairyRepository getDairyRepository() {
		return dairyRepo;
	}

	@Override
	@Transactional
	public List<String> findAllMemberNumbers(boolean activeOnly) {
		Session session = getCurrentSession();
		Query q = session.createQuery("select memberNumber from Membership where status = 'Active'");
		q.setReadOnly(true);
		q.setComment("a read only query - billjones");
		return q.list();		
	}

}
