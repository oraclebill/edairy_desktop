package com.agritrace.edairy.desktop.install.dbsetup;

import java.util.Properties;

import org.hibernate.cfg.Environment;

public class DatabaseSetupData
{
	private String	databaseName;
	private String	host;
	private int		port;
	private String	userName;
	private String	password;
	private String	schemaFileName;

	public DatabaseSetupData()
	{
		this("generated", "localhost", 3306, "root", "", "edairy-schema.sql");
	}

	public DatabaseSetupData(	String databaseName,
								String host,
								int port,
								String userName,
								String password,
								String schemaFileName)
	{
		this.databaseName = databaseName;
		this.host = host;
		this.port = port;
		this.userName = userName;
		this.password = password;
		this.schemaFileName = schemaFileName;
	}

	public String getDatabaseName()
	{
		return databaseName;
	}

	public void setDatabaseName(String databaseName)
	{
		this.databaseName = databaseName;
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSchemaFileName()
	{
		return schemaFileName;
	}

	public void setSchemaFileName(String schemaFileName)
	{
		this.schemaFileName = schemaFileName;
	}

	public String getDatabaseURL()
	{
		return String.format("jdbc:mysql://%s:%d/%s", getHost(), getPort(), getDatabaseName());
	}

	public Properties getOptions()
	{
		Properties props = new Properties();

		setDatabaseProperties(props);
		setTeneoProperties(props);
		setHibernateProperties(props);

		return props;
	}

	/**
	 * @param props
	 */
	protected void setDatabaseProperties(Properties props)
	{
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, getUserName());
		props.setProperty(Environment.URL, getDatabaseURL());
	}

	/**
	 * @param props
	 */
	private void setTeneoProperties(Properties props)
	{
		props.setProperty("teneo.naming.default_id_column", "id");
		props.setProperty("teneo.naming.version_column", "opver");
		props.setProperty("teneo.naming.set_foreign_key_name", "false");
		props.setProperty("teneo.mapping.also_map_as_class", "false");
		props.setProperty("teneo.mapping.disable_econtainer", "true");
// props.setProperty("teneo.mapping.cascade_policy_on_non_containment", "ALL");
		props.setProperty("teneo.mapping.default_varchar_length", "60");
		props.setProperty("teneo.mapping.always_map_list_as_bag", "true"); // will
	}

	/**
	 * @param props
	 */
	private void setHibernateProperties(Properties props)
	{
		props.setProperty(Environment.SHOW_SQL, "true");
// props.setProperty(Environment.FORMAT_SQL, "true");
// props.setProperty(Environment.USE_SQL_COMMENTS, "true");
		props.setProperty(Environment.GENERATE_STATISTICS, "true");
		props.setProperty(Environment.HBM2DDL_AUTO, "create");
	}

}