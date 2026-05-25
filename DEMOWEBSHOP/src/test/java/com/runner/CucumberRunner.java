package com.runner;

import org.testng.annotations.DataProvider ;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features ="src/test/resources/Features/",
        glue = "com.stepdefinitions",
<<<<<<< HEAD
	   
=======
	 
>>>>>>> 246a2897ac9c8ff6aa2b92462b761ef26217a70f

        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed_scenarios.txt"
        },

        tags="@productReview_with_login",
		
        monochrome=true
        
     )

public class CucumberRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

	
}
