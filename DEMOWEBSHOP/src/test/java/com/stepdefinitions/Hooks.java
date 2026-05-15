package com.stepdefinitions;

import java.time.Duration;

import com.utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        HelperClass.initDriver();
        HelperClass.getDriver().manage().window().maximize();
        HelperClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        HelperClass.quitDriver();
    }
}