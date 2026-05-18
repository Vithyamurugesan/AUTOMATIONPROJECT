package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.OrderPage;

public class OrderAction extends BaseAction {

	WebDriver driver;

	public OrderAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void waitfororderlink() {
		waitForVisibility(OrderPage.orderlink).isDisplayed();
	}
	public void clickOrder() {
		click(OrderPage.orderlink);
	}

	public int countoforders() {
	    return driver.findElements(OrderPage.orders).size();
	}
	
	public void clickDetailsButton() {
	    driver.findElements(OrderPage.deatilsButton).get(0).click();
	}
	
	public void waitforpoductName() {
		waitForVisibility(OrderPage.productname).isDisplayed();
	}
	public String getProductText() {
		return getText(OrderPage.productname);
	}
	
	public void clickReorder() {
		click(OrderPage.Reorder);
	}
	
	public void clickPDF() {
		click(OrderPage.pdf);
	}
	public String getProductId() {
	    return getText(OrderPage.productId);
	} 
    public String cartProductName() {
    	return getText(OrderPage.cartproductName);
    }
}
