package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.ProductDetailsPage;

public class ProductDetailsAction extends BaseAction {

	ProductDetailsPage productDetailsPage;
	SearchActions searchActions;

	public ProductDetailsAction(WebDriver driver) {

		super(driver);
		productDetailsPage = new ProductDetailsPage();
		searchActions = new SearchActions(driver);
	}

	public void openCategory(String category) {

		click(By.linkText(category));
	}

	public void selectProduct(String productName) {

		searchActions.searchProduct(productName);
		searchActions.clickSearch();

		click(By.linkText(productName));
	}

	public boolean checkProductPage() {

		return waitForVisibility(productDetailsPage.getProductName()).isDisplayed();
	}

	public boolean checkProductName() {

		return waitForVisibility(productDetailsPage.getProductName()).isDisplayed();
	}

	public boolean checkProductPrice() {

		return waitForVisibility(productDetailsPage.getProductPrice()).isDisplayed();
	}

	public boolean checkProductDescription() {

		return waitForVisibility(productDetailsPage.getProductDesc()).isDisplayed();
	}

	public boolean checkProductImage() {

		return waitForVisibility(productDetailsPage.getProductImage()).isDisplayed();
	}

	public String getAvailabilityLabel() {

		return getText(productDetailsPage.getAvailabilityLabel());
	}

	public String getAvailabilityValue() {

		return getText(productDetailsPage.getAvailabilityValue());
	}

	public void enterQuantity(String qty) {

		waitForVisibility(productDetailsPage.getQuantityBox()).clear();

		type(productDetailsPage.getQuantityBox(), qty);
	}

	public void clickAddToCart() {

		click(productDetailsPage.getAddToCartButton());
	}

	public String getNotificationMessage() {

		return getText(productDetailsPage.getNotificationMessage());
	}
}
