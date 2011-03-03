package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.testdata.TestDataGenerator;
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
	 * @see com.agritrace.edairy.desktop.testdata.DatabaseSetup#createDataSource()
	 */
	@Override
	protected DataSource createDataSource()
	{
		DataSource ds = new DataSource() {

			@Override
			public PrintWriter getLogWriter() throws SQLException
			{
				return new PrintWriter(System.out);
			}

			@Override
			public int getLoginTimeout() throws SQLException
			{
				return 0;
			}

			@Override
			public void setLogWriter(PrintWriter arg0) throws SQLException
			{
			}

			@Override
			public void setLoginTimeout(int arg0) throws SQLException
			{
			}

			@Override
			public boolean isWrapperFor(Class<?> arg0) throws SQLException
			{
				return false;
			}

			@Override
			public <T> T unwrap(Class<T> arg0) throws SQLException
			{
				return null;
			}

			@Override
			public Connection getConnection() throws SQLException
			{
				return DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
			}

			@Override
			public Connection getConnection(String arg0,
											String arg1) throws SQLException
			{
				return getConnection();
			}

		};

		return ds;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.testdata.DatabaseSetup#setDatabaseProperties(java.util.Properties)
	 */
	@Override
	protected void setDatabaseProperties(Properties props)
	{
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "SA");
		props.setProperty(Environment.URL, "jdbc:hsqldb:memory:test.db");
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
	}

}