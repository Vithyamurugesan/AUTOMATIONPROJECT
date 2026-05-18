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
		waitForVisibility(OrderPage.getOrderlink()).isDisplayed();
	}
	public void clickOrder() {
		click(OrderPage.getOrderlink());
	}

	public int countoforders() {
	    return driver.findElements(OrderPage.getOrdersCount()).size();
	}
	
	public void clickDetailsButton() {
	    driver.findElements(OrderPage.getDeatilsButton()).get(0).click();
	}
	
	public void waitforpoductName() {
		waitForVisibility(OrderPage.getProductname()).isDisplayed();
	}
	public String getProductText() {
		return getText(OrderPage.getProductname());
	}
	
	public void clickReorder() {
		click(OrderPage.getReorder());
	}
	
	public void clickPDF() {
		click(OrderPage.getPdf());
	}
	public String getProductId() {
	    return getText(OrderPage.getProductId());
	} 
    public String cartProductName() {
    	return getText(OrderPage.getCartproductName());
    }
}
