package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperClass {

    private static WebDriver driver;

    public static WebDriver initDriver() {
    	
        if (driver==null) {
            driver=new ChromeDriver();
            System.out.println("Driver Initialized");
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver!=null) {
            driver.quit();
            driver=null;
            System.out.println("Driver Closed");
        }
    }
}