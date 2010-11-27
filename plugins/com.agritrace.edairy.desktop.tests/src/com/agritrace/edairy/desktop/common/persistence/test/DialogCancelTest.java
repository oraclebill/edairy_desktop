package com.agritrace.edairy.desktop.common.persistence.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;

public class DialogCancelTest extends ModelPersistenceBase {

	@Test
	public void testDialogCancelApproach() throws Exception {
		// approach #1 to dialog cancel -
		//

		Session session = getSessionFactory().openSession();
		final Dairy dairy = (Dairy) session.get("Dairy", 1l);
		final String companyName = dairy.getCompanyName();
		dairy.setCompanyName(companyName + "random 254");
		session.close();

		session = getSessionFactory().openSession();
		session.load(dairy, 1l);

		assertEquals(companyName, dairy.getCompanyName());
	}

	@Test
	public void testDialogCancelAfterFlush() throws Exception {
		// approach #1 to dialog cancel -
		//

		Session session = getSessionFactory().openSession();
		final Dairy dairy = (Dairy) session.get("Dairy", 1l);
		final String companyName = dairy.getCompanyName();
		dairy.setCompanyName(companyName + "random 254");
		session.flush();
		session.close();

		session = getSessionFactory().openSession();
		session.load(dairy, 1l);

		assertEquals(companyName, dairy.getCompanyName());
	}

//	@Test
	public void testDialogCancelTransactionAfterFlush() throws Exception {
		// approach #1 to dialog cancel -
		//

		Session session = getSessionFactory().openSession();
		final Dairy dairy = (Dairy) session.get("Dairy", 1l);

		session.beginTransaction();

		final String companyName = dairy.getCompanyName();
		dairy.setCompanyName(companyName + "random 254");
		session.flush();
		session.close();

		session = getSessionFactory().openSession();
		session.load(dairy, 1l);

		assertEquals(companyName, dairy.getCompanyName());
	}
}
