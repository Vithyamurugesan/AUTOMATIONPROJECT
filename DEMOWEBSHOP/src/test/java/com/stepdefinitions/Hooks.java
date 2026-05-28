package com.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setup() {
        HelperClass.setUpDriver();
      
    }
    
    @After
    public void tearDown(Scenario scenario) {

    	if (scenario.isFailed() && HelperClass.getDriver() != null) {
    	    takeScreenshot(scenario);
    	}

        HelperClass.tearDown();
    }

    private void takeScreenshot(Scenario scenario) {

        WebDriver driver=HelperClass.getDriver();

        if (driver==null) return;

        try {
        	byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        	scenario.attach(screenshot,"image/png","FAILED - " + scenario.getName());

        	String timestamp=new SimpleDateFormat("ddMMMyyyy_HH-mm-ss").format(new Date());

        	String filePath = "screenshots/"+scenario.getName()+"_"+timestamp+".png";

        	File dest = new File(filePath);
        	dest.getParentFile().mkdirs();

        	FileUtils.writeByteArrayToFile(dest, screenshot);

        	System.out.println("Screenshot saved: " + filePath);

        }
        catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}