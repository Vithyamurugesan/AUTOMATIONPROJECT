package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
<<<<<<< HEAD
        features = "src/test/resources/Features/Register.feature",
=======
        features ="src/test/resources/Features/ProductDetails.feature",
>>>>>>> 941507843110fc338244094ef4f99ebd457b35b4
        glue = "com.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
