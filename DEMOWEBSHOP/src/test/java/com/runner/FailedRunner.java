package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features =
        "@target/failed_scenarios.txt",

        glue =
        "com.stepdefinitions",

        plugin = {
                "pretty",
                "html:target/rerun-report.html",
                "json:target/rerun.json"
        },

        monochrome = true
)

public class FailedRunner extends AbstractTestNGCucumberTests {

	
}