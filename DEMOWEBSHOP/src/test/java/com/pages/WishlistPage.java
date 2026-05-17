package com.pages;

import org.openqa.selenium.By;

public class WishlistPage {
	
    private By computersMenu=By.xpath("(//a[contains(text(),'Computers')])[1]");
    private By desktopCategory=By.xpath("(//a[contains(text(),'Desktops')])[1]");
    private By product=By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own cheap computer')]");
    private By addToWishlistButton=By.xpath("//input[@id='add-to-wishlist-button-72']");
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
    
    public By getComputersMenu() {
		return computersMenu;
	}

    public By getDesktopCategory() {
		return desktopCategory;
	}

	public By getProduct() {
        return product;
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