package com.utilities;

import java.util.Properties;

public class PropertyManager {

	static Properties configProp;
	static Properties testDataProp;

	static {
		configProp = ConfigReader.loadProperties("src/test/resources/config.properties");
		testDataProp = ConfigReader.loadProperties("src/test/resources/testdata.properties");
	}

	public static String getConfigValue(String key) {
		return configProp.getProperty(key);
	}

	public static String getTestDataValue(String key) {
		return testDataProp.getProperty(key);
	}
}