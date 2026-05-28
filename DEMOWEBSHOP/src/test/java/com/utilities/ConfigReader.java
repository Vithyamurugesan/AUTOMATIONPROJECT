package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop =
            new Properties();

    static {

        try {

            FileInputStream fis =
            new FileInputStream(
            "src/test/resources/config.properties");

            prop.load(fis);

        }

        catch(Exception e) {

            e.printStackTrace();

        }

    }


    public static String get(String key) {

        String value =
                prop.getProperty(key);

        if(value==null ||
           value.trim().isEmpty())
        {

            throw new RuntimeException(
              key + " not found"
            );

        }

        return value.trim();

    }
    
    public static Properties loadProperties(String filePath) {

        Properties properties = new Properties();

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            properties.load(fis);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return properties;
    }

}