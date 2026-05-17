package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/Features/checkout.feature",

        glue = "com.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed_scenarios.txt"
        },
        tags="@scenario_9",
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
