package com.pages;

import org.openqa.selenium.By;

public class WishlistPage {

    private By addToWishlistButton=By.xpath("//input[@value='Add to wishlist']");
    private By successMessage=By.xpath("//p[@class='content']");
    private By wishlistLink=By.linkText("Wishlist");
    private By wishlistProducts=By.xpath("//table[@class='cart']//td[@class='product']/a");
    private By updateWishlistButton=By.name("updatecart");
    private By emptyWishlistMessage=By.xpath("//div[@class='wishlist-content']");
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

    public By getWishlistProducts() {
        return wishlistProducts;
    }

    public By getUpdateWishlistButton() {
        return updateWishlistButton;
    }

    public By getEmptyWishlistMessage() {
        return emptyWishlistMessage;
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

    public By getAddToCartCheckbox(String productName) {
        return By.xpath( "//a[text()='" +productName+"']/ancestor::tr//input[@name='addtocart']");
    }

    public By getRemoveCheckbox(String productName) {
        return By.xpath("//a[text()='" +productName+"']/ancestor::tr//input[@name='removefromcart']");
    }
}