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

		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;
	}
}