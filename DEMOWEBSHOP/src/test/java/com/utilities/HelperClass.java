package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
