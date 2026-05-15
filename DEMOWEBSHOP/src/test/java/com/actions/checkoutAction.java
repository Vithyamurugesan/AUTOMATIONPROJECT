package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.checkoutPage;

public class checkoutAction {
	
	
	
	WebDriver driver;
    WebDriverWait mywait;
    checkoutPage cp;
    JavascriptExecutor js;
    
    public  checkoutAction(WebDriver driver) {
    	this.driver = driver;
    	mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	 cp = new checkoutPage(driver);
    	 js = (JavascriptExecutor) driver;
    }


	
	 public void productAddInCart() {
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.loginLink)).click();
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.email)).sendKeys("jenny04@gmail.com");
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.password)).sendKeys("123456");
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.loginButton)).click();
			System.out.println("Login Successful");
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.book)).click();
			mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.addToCart)).click();
			
			js.executeScript("arguments[0].click();", mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.cart)));
		
		}
	    
	    public void click_checkBox() {
	    	js.executeScript("arguments[0].click();", mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.checkbox)));
	    	
	    }
	    
	    public void click_checkout() {
	    	js.executeScript("arguments[0].click();", mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.checkoutButton)));
	    	
	    }
	    
	    public String checkoutPage() {
	    	
	    	return mywait.until(ExpectedConditions.visibilityOfElementLocated(cp.checkoutText)).getText();
	
	    }
	
}
