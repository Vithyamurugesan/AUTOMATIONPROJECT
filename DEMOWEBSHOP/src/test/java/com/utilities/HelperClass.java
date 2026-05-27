package com.utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setUpDriver() {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications");

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        try {

            String headless = ConfigReader.get("headless");

            if (headless != null && headless.equalsIgnoreCase("true")) {

                options.addArguments("--headless=new");

                options.addArguments("--window-size=1920,1080");

                System.out.println("Running in HEADLESS mode");
            }
            else {

            	options.addArguments("--window-size=1920,1080");
            }

        }
        catch (Exception e) {

            System.out.println("headless key not found. Running normal mode.");

            options.addArguments("--start-maximized");
        }

        driver.set(new ChromeDriver(options));

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    public static void tearDown() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}