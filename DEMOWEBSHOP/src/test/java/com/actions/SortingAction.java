package com.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.HomePage;
import com.utilities.HelperClass;

public class SortingAction extends BaseAction {

	private HomePage homePage;
	
	public SortingAction(WebDriver driver) {
		super(driver);
		this.homePage=new HomePage();
	}
	
	public void navigateToBooks() {
		click(homePage.getBookLink());
	}
	
	public void selectOption(String option) {
		Select select=new Select(HelperClass.getDriver().findElement(homePage.getSortingOptions()));
		select.selectByVisibleText(option);
	}
	
	public boolean isSorted(String order) {

	    List<WebElement> products = HelperClass.getDriver().findElements(homePage.getProducts());

	    List<String> productNames = new ArrayList<>();

	    for (WebElement product : products) {
	        String productName = product.findElement(By.cssSelector("h2.product-title a")).getText();
	        productNames.add(productName);
	    }

	    List<String> sortedNames = new ArrayList<>(productNames);

	    if (order.equalsIgnoreCase("AtoZ")) {
	        sortedNames.sort(String.CASE_INSENSITIVE_ORDER);
	    } 
	    else if (order.equalsIgnoreCase("ZtoA")) {
	        sortedNames.sort(String.CASE_INSENSITIVE_ORDER.reversed());
	    }

	    return productNames.equals(sortedNames);
	}
	
}
