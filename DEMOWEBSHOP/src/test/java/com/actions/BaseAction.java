package com.actions;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseAction {

    WebDriver driver;
    WebDriverWait wait;
    
    Logger log = LogManager.getLogger(checkoutAction.class);
    

    public BaseAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
        
    public void click(By locator) {
        waitForVisibility(locator).click();
    }

    public void type(By locator, String text) {
        waitForVisibility(locator).sendKeys(text);
        
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }
    
    public void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        js.executeScript("arguments[0].click();", element);
    }
}