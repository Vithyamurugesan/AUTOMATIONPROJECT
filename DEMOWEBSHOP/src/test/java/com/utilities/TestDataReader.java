package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

	static Properties prop;

	public static Properties loadProperties() {

		prop = new Properties();

		try {
			FileInputStream fis =
					new FileInputStream("src/test/resources/testData.properties");

			prop.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String get(String key) {

		if (prop == null) {
			loadProperties();
		}

		String value = prop.getProperty(key);

		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException(
					"Key '" + key + "' not found in testData.properties");
		}

		return value.trim();
	}
}