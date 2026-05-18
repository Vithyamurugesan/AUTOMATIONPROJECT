package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	public static Properties loadProperties(String filePath) {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String get(String key) {
		if (prop == null) {
			loadProperties("src/test/resources/config.properties");
		}
		String value = prop.getProperty(key);
		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException("Key '" + key + "' not found in config.properties");
		}
		return value.trim();
	}
}