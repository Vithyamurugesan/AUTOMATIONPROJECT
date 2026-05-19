package com.actions;

import org.openqa.selenium.WebDriver;
import com.pages.WishlistPage;

public class WishlistAction extends BaseAction {

    WishlistPage wishlistPage;

    public WishlistAction(WebDriver driver) {
        super(driver);
        this.wishlistPage = new WishlistPage();
    }

    // FIXED FLOW ENTRY POINT
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

    public String getWishlistProductName() {
        return getText(wishlistPage.getWishlistProduct());
    }

    public void removeProductFromWishlist() {
        click(wishlistPage.getRemoveCheckbox());
        click(wishlistPage.getUpdateWishlistButton());
    }

    public String getEmptyWishlistMessage() {
        return getText(wishlistPage.getEmptyWishlistMessage());
    }

    public void selectProductForAddToCart() {
        click(wishlistPage.getAddToCartCheckbox());
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
}