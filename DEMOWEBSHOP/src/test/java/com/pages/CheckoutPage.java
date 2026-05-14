package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;

    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    By addToCartButton = By.xpath("(//input[@value='Add to cart'])[2]");
    By shoppingCartLink = By.xpath("//span[text()='Shopping cart']");
    By termsCheckbox =  By.id("termsofservice");
    By checkoutButton = By.id("checkout");
    By warningMessage = By.xpath("//div[@id='terms-of-service-warning-box']");
    By notificationBar = By.id("bar-notification");

    public void addProductToCart() {

        WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addCart.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationBar));
    }


    public void openCartPage() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated( By.id("bar-notification")));
        WebElement cart =wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLink));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cart);
    }

   
    public void clickCheckoutButton() {

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkout.click();
    }

 
    public void selectTermsCheckbox() {

        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        checkbox.click();
    }

   
    public String getWarningMessage() {

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(warningMessage));
        return message.getText();
    }

    
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}