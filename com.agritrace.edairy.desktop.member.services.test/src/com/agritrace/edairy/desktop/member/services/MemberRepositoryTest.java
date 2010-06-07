package com.agritrace.edairy.desktop.member.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.*;
import static org.junit.Assert.*;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.HsqldbMemoryPersistenceManager;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.services.member.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;


public class MemberRepositoryTest {
	
	static class TestHibernateRepository extends HibernateRepository<Membership> {
		
		public TestHibernateRepository(PersistenceManager pm) {
			super(pm);
		}
		
		@Override
		protected Class<?> getClassType() {
			return Membership.class;
		}
	}

	private PersistenceManager pm;
	private IMemberRepository repo;
	
	@Before
	public void setUp() {
		pm = new HsqldbMemoryPersistenceManager();		
		repo = new MemberRepository( new TestHibernateRepository(pm) );
	}
	
	@After
	public void tearDown() {
		repo = null;
	}
		
	@Test 
	public void testGetMemberFarms() {
		Membership member;
		Farm farm;
		UUID uuid;
		Set<String> uuidSet = new HashSet<String>();
		
		for (int i = 0; i < 50; i++ ) {
			uuid = UUID.randomUUID();
			member = DairyUtil.createMembership(new Date(), new Date(), 
						DairyUtil.createFarmer("Farmer "+ i, "", "", "" + i, 
								DairyUtil.createFarm( uuid.toString(), null)));
			uuidSet.add(uuid.toString());
			repo.saveNew(member);
		}

		List<Farm> memberFarms = repo.getMemberFarms();
		assertEquals( 50, memberFarms.size() );
		for ( Farm f : memberFarms ) 
			assertTrue( uuidSet.contains( f.getName() ));
		
	}
	
	@Test
	public void testRepositorySetup() {
		List<Membership> memberList;
		Membership testEntity;
		
		// create a blank member
		testEntity = DairyUtil.createMembership(null, null, null);
		
		// starting off empty
		memberList = repo.all();
		assertNotNull(memberList);
		assertEquals(0, memberList.size());
		
		// addition works
		repo.saveNew(testEntity);
		memberList = repo.all();
		assertEquals(1, memberList.size());
		testEntity = memberList.get(0);
		assertNotNull(testEntity);
		
		// update works
		long memberId = testEntity.getMemberId();
		memberId += 300;
		testEntity.setMemberId(memberId);
		repo.update(testEntity);
		memberList = repo.all();
		assertEquals(1, memberList.size());
		testEntity = memberList.get(0);
		assertEquals(new Long(memberId), testEntity.getMemberId());

		// delete works
		repo.delete(testEntity);
		memberList = repo.all();
		assertEquals(0, memberList.size());

	}
	
	@Test
	public void testGetFarmOwner() throws Exception {
		Farm farm = DairyUtil.createFarm("unassociated", 
				DairyUtil.createLocation(null, null, null));
		assertNull(farm.eContainer());
		assertNull(farm.eContainingFeature());
		
		Farmer farmer = DairyUtil.createFarmer("owner", "x", "farmer", "", farm);
		assertNotNull(farm.eContainer());
		assertNotNull(farm.eContainingFeature());
		assertSame(farmer, farm.eContainer());

		Membership membership = DairyUtil.createMembership(new Date(), new Date(), farmer);
		assertNotNull(farmer.eContainer());
		assertNotNull(farmer.eContainingFeature());
		assertSame(membership, farmer.eContainer());
		
		repo.save(membership);
		
		assertNotNull(farm.getFarmId());
		
//		Farm copyOfFarm = repo.find();
		
	}
}