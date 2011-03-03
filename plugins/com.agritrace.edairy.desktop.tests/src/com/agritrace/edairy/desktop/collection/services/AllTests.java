package com.agritrace.edairy.desktop.collection.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.agritrace.edairy.desktop.common.persistence.test.DialogCancelTest;
import com.agritrace.edairy.desktop.internal.common.persistence.DairyPersistenceTest;
import com.agritrace.edairy.desktop.internal.common.persistence.MembershipPerformanceTestCase;
import com.agritrace.edairy.desktop.internal.common.persistence.ModelPersistenceTestCase;
import com.agritrace.edairy.desktop.internal.common.persistence.PersistenceManagerTest;
import com.agritrace.edairy.desktop.internal.common.persistence.TransactionRepositoryTest;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.DairyRepoPerfTest;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.DairyRepositoryTest;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.MilkCollectionJournalLineQueryTest;

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
