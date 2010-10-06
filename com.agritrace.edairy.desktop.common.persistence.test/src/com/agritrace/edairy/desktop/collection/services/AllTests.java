package com.agritrace.edairy.desktop.collection.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManagerTest;
import com.agritrace.edairy.desktop.common.persistence.test.DairyPersistenceTest;
import com.agritrace.edairy.desktop.common.persistence.test.DairyRepoPerfTest;
import com.agritrace.edairy.desktop.common.persistence.test.DairyRepositoryTest;
import com.agritrace.edairy.desktop.common.persistence.test.DialogCancelTest;
import com.agritrace.edairy.desktop.common.persistence.test.MembershipPerformanceTestCase;
import com.agritrace.edairy.desktop.common.persistence.test.ModelPersistenceTestCase;
import com.agritrace.edairy.desktop.internal.common.persistence.TransactionRepositoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	PersistenceManagerTest.class, 
	DairyPersistenceTest.class,
	DairyRepoPerfTest.class, 
	DairyRepositoryTest.class, 
	ModelPersistenceTestCase.class, 
	MembershipPerformanceTestCase.class,
	MilkCollectionJournalLineQueryTest.class,
	DialogCancelTest.class, 
	TransactionRepositoryTest.class, 
	})
public class AllTests {

}
