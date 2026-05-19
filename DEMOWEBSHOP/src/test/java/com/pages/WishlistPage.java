package com.pages;

import org.openqa.selenium.By;

public class WishlistPage {

	private By addToWishlistButton=By.xpath("//input[@value='Add to wishlist']");
    private By successMessage=By.xpath("//p[@class='content']");
    private By wishlistLink=By.linkText("Wishlist");
    private By wishlistProduct=By.xpath("//td[@class='product']/a");
    private By removeCheckbox=By.name("removefromcart");
    private By updateWishlistButton=By.name("updatecart");
    private By emptyWishlistMessage=By.xpath("//div[@class='wishlist-content']");
    private By addToCartCheckbox=By.name("addtocart");
    private By addToCartButton=By.name("addtocartbutton");
    private By shoppingCartLink=By.linkText("Shopping cart");
    private By cartProduct=By.xpath("//td[@class='product']/a");

    public By getProduct(String productName) {
        return By.linkText(productName);
    }

    public By getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public By getSuccessMessage() {
        return successMessage;
    }

    public By getWishlistLink() {
        return wishlistLink;
    }

    public By getWishlistProduct() {
        return wishlistProduct;
    }

    public By getRemoveCheckbox() {
        return removeCheckbox;
    }

    public By getUpdateWishlistButton() {
        return updateWishlistButton;
    }

    public By getEmptyWishlistMessage() {
        return emptyWishlistMessage;
    }

    public By getAddToCartCheckbox() {
        return addToCartCheckbox;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public By getShoppingCartLink() {
        return shoppingCartLink;
    }

    public By getCartProduct() {
        return cartProduct;
    }
}