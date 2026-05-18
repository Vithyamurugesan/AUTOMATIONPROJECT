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

    Logger log = LogManager.getLogger(BaseAction.class);

    public BaseAction(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
    }


    // Wait for element visible
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // Click
    public void click(By locator) {

        wait.until(
                ExpectedConditions.elementToBeClickable(locator))
                .click();

        log.info("Clicked element: " + locator);
    }


    // Type text
    public void type(By locator, String text) {

        WebElement element =
                waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);

        log.info("Entered text");
    }


    // Get text
    public String getText(By locator) {

        return waitForVisibility(locator)
                .getText();
    }


    // JavaScript click
    public void jsClick(By locator) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        WebElement element =
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(locator));

        js.executeScript(
                "arguments[0].click();",
                element);

        log.info("JS clicked element");
    }

}