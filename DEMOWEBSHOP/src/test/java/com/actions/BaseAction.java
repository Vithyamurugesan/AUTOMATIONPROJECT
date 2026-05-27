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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void click(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
        catch (Exception e) {
            jsClick(locator);
        }
    }

    public void type(By locator, String text) {
        waitForVisibility(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }
    
    public void jsClick(By locator) {
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}