package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.IOException;
import java.util.Properties;

import com.google.inject.ImplementedBy;

@ImplementedBy(HbDataStoreProvider.class)
public interface IDbPropertiesManager {
	Properties getProperties();
	void setProperties(Properties props) throws IOException;
}
