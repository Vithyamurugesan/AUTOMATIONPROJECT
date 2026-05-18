package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.OrderPageLocator;

public class OrderAction extends BaseAction {

	WebDriver driver;

	public OrderAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void waitfororderlink() {
		waitForVisibility(OrderPageLocator.orderlink).isDisplayed();
	}
	public void clickOrder() {
		click(OrderPageLocator.orderlink);
	}

	public int countoforders() {
	    return driver.findElements(OrderPageLocator.orders).size();
	}
	
	public void clickDetailsButton() {
	    driver.findElements(OrderPageLocator.deatilsButton).get(0).click();
	}
	
	public void waitforpoductName() {
		waitForVisibility(OrderPageLocator.productname).isDisplayed();
	}
	public String getProductText() {
		return getText(OrderPageLocator.productname);
	}
	
	public void clickReorder() {
		click(OrderPageLocator.Reorder);
	}
	
	public void clickPDF() {
		click(OrderPageLocator.pdf);
	}
	public String getProductId() {
	    return getText(OrderPageLocator.productId);
	} 
    public String cartProductName() {
    	return getText(OrderPageLocator.cartproductName);
    }
}
