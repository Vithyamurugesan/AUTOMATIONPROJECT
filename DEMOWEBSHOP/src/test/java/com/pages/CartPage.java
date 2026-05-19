package com.pages;

import org.openqa.selenium.By;

public class CartPage {

	private By books = By.linkText("Books");
	private By computingBook = By.linkText("Computing and Internet");
	private By shoppingCart = By.linkText("Shopping cart");
	private By cartQty = By.className("cart-qty");
	private By subtotal = By.xpath("//span[@class='product-price order-total']");
	private By couponBox = By.name("discountcouponcode");
	private By couponButton = By.name("applydiscountcouponcode");
	private By giftCardBox = By.name("giftcardcouponcode");
	private By giftCardButton = By.name("applygiftcardcouponcode");
	private By message = By.cssSelector("div.message");
	private By emptyCartMsg = By.xpath("//div[@class='order-summary-content']");
	private By quantityBox = By.className("qty-input");
	private By updateCartButton = By.name("updatecart");
	private By removeCheckBox = By.name("removefromcart");
	private By addToCartButton = By.xpath("//input[contains(@value,'Add to cart')]");
	private By cartTable = By.cssSelector("table.cart");

	public By getBooks() {
		return books;
	}

	public By getComputingBook() {
		return computingBook;
	}

	public By getShoppingCart() {
		return shoppingCart;
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

	public By getQuantityBox() {
		return quantityBox;
	}

	public By getUpdateCartButton() {
		return updateCartButton;
	}

	public By getRemoveCheckBox() {
		return removeCheckBox;
	}

	public By getAddToCartButton() {
		return addToCartButton;
	}
	
	public By getCartTable() {
		return cartTable;
	}
}