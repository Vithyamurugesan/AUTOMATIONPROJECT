package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features ="src/test/resources/Features/checkout.feature",
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
       //tags ="@scenario_7",
=======
       
>>>>>>> 495dc23b195007ecc88775bd773b44a099061eb6
        monochrome = true

)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
