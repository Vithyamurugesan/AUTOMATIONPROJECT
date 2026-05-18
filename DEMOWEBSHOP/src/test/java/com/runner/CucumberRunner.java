package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/Features/",
        glue = "com.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed_scenarios.txt"
        },
<<<<<<< HEAD
        //tags="@scenario_9",
        monochrome = true
=======
        monochrome = true,tags="not @Ignore"
>>>>>>> 52d1f6d5f2217b9ca1bd0d5a85c41a687f3d3cf3
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
