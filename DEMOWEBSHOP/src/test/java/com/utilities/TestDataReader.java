package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static final Properties prop = loadProperties();

    private static Properties loadProperties() {
    	
        Properties p=new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testData.properties");
            p.load(fis);
            fis.close();
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load testData.properties : " + e.getMessage());
        }
        return p;
    }

    public static String get(String key) {
        String value=prop.getProperty(key);
        if (value==null||value.trim().isEmpty()) {
            throw new RuntimeException("Key '" + key + "' not found in testData.properties");
        }
        return value.trim();
    }
}