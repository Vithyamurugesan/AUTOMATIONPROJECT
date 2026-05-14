package com.actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.utilities.DriverFactory;

import io.cucumber.datatable.DataTable;

public class CartAction {

    CartPage cartPage;

    public CartAction(WebDriver driver) {
        cartPage = new CartPage(driver);
    }
    
    public void openCartPage() {
        cartPage.openShoppingCart();
    }

    public void openProductDetailsPage() {
        cartPage.openProductPage();
    }

    public void addProductToCart() {
        cartPage.clickAddToCart();
    }

    public boolean verifyShoppingCart() {
        cartPage.openShoppingCart();
        return cartPage.isCartHasItems();
    }

    public boolean verifyEmptyCart() {
        cartPage.openShoppingCart();
        return cartPage.isEmptyCartMessageDisplayed();
    }

    public void addMultipleProducts(DataTable dataTable) {

        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);

        WebDriver driver = DriverFactory.getDriver();

        for (Map<String, String> product : products) {

            String productName = product.get("productName");

            driver.get("https://demowebshop.tricentis.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));

            driver.findElement(By.id("small-searchterms")).clear();
            driver.findElement(By.id("small-searchterms")).sendKeys(productName);
            driver.findElement(By.xpath("//input[@value='Search']")).click();

            By productLink = By.partialLinkText(productName);
            wait.until(ExpectedConditions.elementToBeClickable(productLink));
            driver.findElement(productLink).click();

            By addToCart = By.xpath("//input[contains(@value,'Add to cart')]");
            wait.until(ExpectedConditions.elementToBeClickable(addToCart));
            driver.findElement(addToCart).click();
        }
    }

    public void updateProductQuantity() {
        cartPage.updateQuantity();
    }

    public void clickUpdateCart() {
        cartPage.clickUpdateCart();
    }

    public void removeCartProduct() {
        cartPage.removeProduct();
    }

    public void enterCouponCode(String coupon) {
        cartPage.enterCoupon(coupon);
    }

    public void applyCouponCode() {
        cartPage.applyCoupon();
    }

    public void enterGiftCardCode(String giftcard) {
        cartPage.enterGiftCard(giftcard);
    }

    public void applyGiftCardCode() {
        cartPage.applyGiftCard();
    }
}