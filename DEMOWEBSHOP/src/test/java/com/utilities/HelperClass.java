package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
<<<<<<< HEAD
import org.openqa.selenium.edge.EdgeDriver;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ChromeOptions option = new ChromeOptions();

    public static WebDriver initDriver() {
        WebDriver webDriver = new ChromeDriver(option);
        option.addArguments("--disk-cache-size=0");
        driver.set(webDriver);
        return webDriver;
    }
=======

public class HelperClass {

    private static WebDriver driver;
>>>>>>> 52d1f6d5f2217b9ca1bd0d5a85c41a687f3d3cf3

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