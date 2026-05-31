package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.WishlistPage;

public class WishlistAction extends BaseAction {

    WishlistPage wishlistPage;

    public WishlistAction(WebDriver driver) {
        super(driver);
        this.wishlistPage = new WishlistPage();
    }

    public void openSearchedProduct(String productName) {
        click(wishlistPage.getProduct(productName));
    }

    public void clickAddToWishlist() {
        jsClick(wishlistPage.getAddToWishlistButton());
    }

    public String getSuccessMessage() {
        return getText(wishlistPage.getSuccessMessage());
    }

    public void clickWishlistLink() {
        click(wishlistPage.getWishlistLink());
    }

    public boolean isProductPresentInWishlist(String productName) {
        clickWishlistLink();
        return driver.findElements(By.linkText(productName)).size() > 0;
    }

    public String getEmptyWishlistMessage() {
        return getText(wishlistPage.getEmptyWishlistMessage());
    }

    public void selectProductForAddToCart(String productName) {

        By checkbox=wishlistPage.getAddToCartCheckbox(productName);
        waitForVisibility(checkbox);
        click(checkbox);
    }

    public void clickAddToCartButton() {
        click(wishlistPage.getAddToCartButton());
    }

    public void openShoppingCart() {
        click(wishlistPage.getShoppingCartLink());
    }

    public String getCartProductName() {
        return getText(wishlistPage.getCartProduct());
    }

    public void removeProductFromWishlist(String productName) {
        clickWishlistLink();
        By checkbox=wishlistPage.getRemoveCheckbox(productName);
        waitForVisibility(checkbox);
        click(checkbox);
        click(wishlistPage.getUpdateWishlistButton());
    }
}