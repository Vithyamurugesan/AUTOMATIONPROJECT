package com.pages;

import org.openqa.selenium.By;

public class CartPage {

	private By books = By.linkText("Books");

	private By computingAndInternetBook = By.xpath("//h2[@class='product-title']/child::a[normalize-space()='Computing and Internet']");

	private By shoppingCart = By.xpath("//span[text()='Shopping cart']/ancestor::a");

	private By addToCartButton = By.xpath("//input[contains(@value,'Add to cart')]");

	private By cartTable = By.xpath("//form[@action='/cart']/descendant::table");

	private By productList = By.xpath("//table/descendant::tbody/child::tr/child::td[@class='product']");

	private By subtotal = By.xpath("//span[contains(@class,'product-price')]");

	private By couponBox = By.name("discountcouponcode");

	private By couponButton = By.xpath("//input[@name='discountcouponcode']/following-sibling::input");

	private By giftCardBox = By.name("giftcardcouponcode");

	private By giftCardButton = By.xpath("//input[@name='giftcardcouponcode']/following-sibling::input");

	private By message = By.xpath("//div[@class='message']");

	private By emptyCartMsg = By.cssSelector(".order-summary-content");

	private By quantityBox = By.cssSelector("input.qty-input");

	private By updateCartButton = By.xpath("//input[@name='updatecart']");

	private By removeCheckBox = By.xpath("//input[@name='removefromcart']");

	public By getBooks() {
		return books;
	}

	public By getComputingBook() {
		return computingAndInternetBook;
	}

	public By getShoppingCart() {
		return shoppingCart;
	}

	public By getAddToCartButton() {
		return addToCartButton;
	}

	public By getCartTable() {
		return cartTable;
	}

	public By getProductList() {
		return productList;
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

	public By getQuantityBox() {
		return quantityBox;
	}

	public By getUpdateCartButton() {
		return updateCartButton;
	}

	public By getRemoveCheckBox() {
		return removeCheckBox;
	}
}
