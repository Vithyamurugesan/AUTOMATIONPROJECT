package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriverWait wait;

    public void setup() {
        driver.set(new ChromeDriver());
        getdriver().manage().window().maximize();
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getdriver(), Duration.ofSeconds(20));
    }

    
    public static WebDriver getdriver() {
        return driver.get();
    }

    public void teardown() {
        if (getdriver() != null) {
            getdriver().quit();
            driver.remove();
        }
    }
}