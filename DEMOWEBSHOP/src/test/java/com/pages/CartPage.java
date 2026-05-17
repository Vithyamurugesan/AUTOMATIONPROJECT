package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private By books = By.linkText("Books");
	private By computingBook = By.linkText("Computing and Internet");
	private By shoppingCart = By.linkText("Shopping cart");
	private By searchBox = By.id("small-searchterms");
	private By searchButton = By.xpath("//input[@value='Search']");
	private By cartQty = By.className("cart-qty");
	private By subtotal = By.xpath("//span[@class='product-price order-total']");
	private By couponBox = By.name("discountcouponcode");
	private By couponButton = By.name("applydiscountcouponcode");
	private By giftCardBox = By.name("giftcardcouponcode");
	private By giftCardButton = By.name("applygiftcardcouponcode");
	private By message = By.cssSelector("div.message");
	private By emptyCartMsg = By.xpath("//div[@class='order-summary-content']");

	public By getBooks() {
		return books;
	}

	public By getComputingBook() {
		return computingBook;
	}

	public By getShoppingCart() {
		return shoppingCart;
	}

	public By getSearchBox() {
		return searchBox;
	}

	public By getSearchButton() {
		return searchButton;
	}

	public By getCartQty() {
		return cartQty;
	}

	public By getSubtotal() {
		return subtotal;
	}

	public By getCouponBox() {
		return couponBox;
	}

	public By getCouponButton() {
		return couponButton;
	}

	public By getGiftCardBox() {
		return giftCardBox;
	}

	public By getGiftCardButton() {
		return giftCardButton;
	}

	public By getMessage() {
		return message;
	}

	public By getEmptyCartMsg() {
		return emptyCartMsg;
	}
}