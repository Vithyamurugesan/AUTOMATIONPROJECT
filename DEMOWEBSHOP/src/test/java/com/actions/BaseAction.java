package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {

    WebDriver driver;
    WebDriverWait wait;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        waitForVisibility(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }
    
    public void clear(By locator) {
    	 waitForVisibility(locator).clear();
    }
    
    
    
    public void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        js.executeScript("arguments[0].click();", element);
    }
}