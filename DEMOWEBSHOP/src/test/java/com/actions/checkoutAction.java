package com.actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.checkoutPage;

public class checkoutAction {
	
	
	
	WebDriver driver;
    WebDriverWait mywait;
    checkoutPage cp;
    
    public  checkoutAction(WebDriver driver) {
    	this.driver = driver;
    	mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	 cp = new checkoutPage(driver);
    }


	
	 public void productAddInCart() {
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.loginLink)).click();
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.email)).sendKeys("jenny04@gmail.com");
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.password)).sendKeys("123456");
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.loginButton)).click();
			System.out.println("Login Successful");
			
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.book)).click();
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.addToCart)).click();
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.cart)).click();
		}
	    
	    public void click_checkBox() {
	    	mywait.until(ExpectedConditions.elementToBeClickable(cp.checkbox)).click(); 
	    
	    }
	    
	    public void click_checkout() {
	    	
	    	mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.checkoutButton)).click();
	    	
	    	
	    }
	    
	    public String checkoutPage() {
	    	return driver.findElement(cp.checkoutText).getText();
	    }
	
}
