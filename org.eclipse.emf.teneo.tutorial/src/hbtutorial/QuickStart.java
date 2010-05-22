/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal
 * </copyright> 
 *
 * $Id: QuickStart.java,v 1.7 2008/03/07 13:14:54 mtaal Exp $
 */

package hbtutorial;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

/**
 * Quick Start Tutorial
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.7 $
 */
public class QuickStart {

	/** The main method */
	public static void main(String[] args) {
		// the name of the database, this database should exist but does not need to contain tables
		String dbName = "edairy";
		doQuickStart(dbName); // ignore return
	}

	/** Methodn which can be called by others */
	public static HbDataStore doQuickStart(String dbName) {
		// the name of the session factory
		String hbName = "eDairy";

		// create the HbDataStore
		HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);

		// The hibernate properties can be set by having a hibernate.properties file in the root of
		// the classpath.
		// Another approach is setting the properties in the HbDataStore. To do this comment out the
		// following lines
		// For more information see section 3.1 of the Hibernate manual
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + dbName);
		//props.setProperty(Environment.PASS, "root");
		props.setProperty(Environment.DIALECT, org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		hbds.setProperties(props);

		// sets its epackages stored in this datastore
		hbds.setEPackages(
			new EPackage[] { 
				AccountPackage.eINSTANCE, 
				DairyPackage.eINSTANCE, 
				ModelPackage.eINSTANCE, 
				RequestsPackage.eINSTANCE, 
				TrackingPackage.eINSTANCE 
				}
			);

		// initialize, also creates the database tables
		hbds.initialize();
		System.err.println(hbds.getMappingXML());

		SessionFactory sessionFactory = hbds.getSessionFactory();

		// Create a session and a transaction
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();

		TestAccountTransactionGenerator gen = TestAccountTransactionGenerator.INSTANCE;
		
		// Start a transaction
		tx.begin();
		
		// create an account and make it persistent
		Account acct = gen.randomAccount();

		// create a transaction, adding it to the account
		AccountTransaction transaction = gen.createTestAccountTransaction(acct, 1);
		acct.getTransactions().add(transaction);

		session.save(acct);
		session.save(transaction);

		// at commit the objects will be present in the database
		tx.commit();
		// and close of, this should actually be done in a finally block
		session.close();

		return hbds;
	}
}