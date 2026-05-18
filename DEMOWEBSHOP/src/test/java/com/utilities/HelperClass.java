package com.utilities;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class HelperClass {

    private static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        ChromeOptions options = new ChromeOptions();

        String headless = ConfigReader.get("headless");
        
        if (headless != null && headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}