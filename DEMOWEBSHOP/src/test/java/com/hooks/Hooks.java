package com.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.utilities.DriverFactory;
import com.utilities.PropertyManager;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setup() {

        WebDriver driver = DriverFactory.initDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Integer.parseInt(
                                PropertyManager.getConfigValue("implicitWait")
                        )
                )
        );
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}