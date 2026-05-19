package com.pages;

import org.openqa.selenium.By;

public class ProductDetailsPage {

	private By productName = By.xpath("//div[@class='product-name']/h1");

	private By productPrice = By.xpath("//div[@class='product-price']//span");

	private By productDesc = By.xpath("//div[@class='full-description']");

	private By productImage = By.xpath("//div[@class='picture']//img");

	private By availabilityLabel = By.xpath("//span[@class='label']");

	private By availabilityValue = By.xpath("//span[@class='value']");

	private By quantityBox = By.id("addtocart_13_EnteredQuantity");

	private By addToCartButton = By.xpath("//input[@value='Add to cart']");

	private By notificationMessage = By.cssSelector(".bar-notification");

	public By getProductName() {
		return productName;
	}

	public By getProductPrice() {
		return productPrice;
	}

	public By getProductDesc() {
		return productDesc;
	}

	public By getProductImage() {
		return productImage;
	}

	public By getAvailabilityLabel() {
		return availabilityLabel;
	}

	public By getAvailabilityValue() {
		return availabilityValue;
	}

	public By getQuantityBox() {
		return quantityBox;
	}

	public By getAddToCartButton() {
		return addToCartButton;
	}

	public By getNotificationMessage() {
		return notificationMessage;
	}
}