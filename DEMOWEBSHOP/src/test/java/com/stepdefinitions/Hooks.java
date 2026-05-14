package com.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        WebDriver driver = HelperClass.initDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
       HelperClass.quitDriver();
    }

	
}