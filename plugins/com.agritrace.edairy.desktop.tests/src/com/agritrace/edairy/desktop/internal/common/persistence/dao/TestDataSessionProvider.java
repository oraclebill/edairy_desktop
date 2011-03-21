package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.util.Properties;

import org.apache.derby.jdbc.EmbeddedDataSource40;
import org.hibernate.Session;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.install.dbsetup.TestDataGenerator;
import com.google.inject.Provider;

public class TestDataSessionProvider extends TestDataGenerator implements Provider<Session>
{
	public TestDataSessionProvider() {
		createDatabase();
		initializeDataStore();
	}

	@Override
	public String getDatabaseName()
	{
		return "test";
	}

	@Override
	public Session get()
	{
		return openSession();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.install.dbsetup.DatabaseSetupUtil#createDataSource()
	 */
	@Override
	public void createDatabase() {
		System.out.format("Creating database [%s]\n", getDatabaseName());
//		String dbURL = getDatabaseURL();
		try {
			EmbeddedDataSource40 dataSource = new EmbeddedDataSource40();	
			dataSource.setDatabaseName("memory:"+getDatabaseName());
			dataSource.setConnectionAttributes("create=true");
			dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create database", e);
		}

	}

	
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.install.dbsetup.DatabaseSetupUtil#setDatabaseProperties(java.util.Properties)
	 */
	@Override
	protected void setDatabaseProperties(Properties props)
	{
		props.setProperty(Environment.DRIVER, "org.apache.derby.jdbc.EmbeddedDriver");
		props.setProperty(Environment.URL, "jdbc:derby:memory:" + getDatabaseName());
		props.setProperty(Environment.USER, "admin");
		props.setProperty(Environment.PASS, "admin");
//		
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.DerbyDialect");
	}

	public static void main(String[] args)  {
		TestDataSessionProvider p = new TestDataSessionProvider();
		try {
			p.createDataSource().getConnection();
			p.get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}