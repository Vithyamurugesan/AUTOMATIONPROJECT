package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/Features/Checkout.feature", 
        glue = {"com.stepdefinitions","com.Hooks"},
        plugin = { "pretty", "html:target/cucumber-reports.html"},
        monochrome = true

)

public class CucumberRunner extends AbstractTestNGCucumberTests {

}