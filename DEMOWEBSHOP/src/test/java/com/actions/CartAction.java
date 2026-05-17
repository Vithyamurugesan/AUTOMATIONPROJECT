package com.actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class CartAction {

    CartPage cartPage;

    public CartAction(WebDriver driver) {

    	cartPage = new CartPage(driver);    }

    public void openProductDetailsPage() {
        cartPage.booksMenu.click();
        cartPage.computingBook.click();
    }

    public void addProductToCart() {

        WebDriver driver = HelperClass.getDriver();

        By addToCart = By.xpath("//input[contains(@value,'Add to cart')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(addToCart));

        driver.findElement(addToCart).click();
    }

    public boolean verifyShoppingCart() {
    	
        WebDriverWait wait =new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.shoppingCart));
        
        cartPage.shoppingCart.click();
        return HelperClass.getDriver().findElements(By.cssSelector("table.cart")).size() > 0;
    }

    public void addMultipleProducts(DataTable dataTable) {

        List<Map<String, String>> products =dataTable.asMaps(String.class, String.class);
        WebDriver driver = HelperClass.getDriver();

        for (Map<String, String> product : products) {
            String productName =product.get("productName");

            driver.get("https://demowebshop.tricentis.com/");

            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOf(cartPage.searchBox));

            cartPage.searchBox.clear();

            cartPage.searchBox.sendKeys(productName);

            cartPage.searchButton.click();

            By productLink =By.partialLinkText(productName);

            wait.until(ExpectedConditions.elementToBeClickable(productLink));

            driver.findElement(productLink).click();

            By addToCart =By.xpath("//input[contains(@value,'Add to cart')]");

            wait.until(ExpectedConditions.elementToBeClickable(addToCart));

            driver.findElement(addToCart).click();
        }
    }
    
    public void openShoppingCart() {
        cartPage.shoppingCart.click();
    }

    public boolean verifyProductsAdded() {
        String qty = cartPage.cartQuantity.getText();
        return !qty.contains("(0)");
    }

    public boolean verifyTotalAmount() {
        return cartPage.subtotal.isDisplayed();
    }

    public void openEmptyCartPage() {
        HelperClass.getDriver().get("https://demowebshop.tricentis.com/cart");
    }

    public String getEmptyCartMessage() {
        return cartPage.emptyCartMessage.getText();
    }

    public void addSingleProduct() {
        openProductDetailsPage();
        addProductToCart();
    }

    public void enterCouponCode(String coupon) {
        cartPage.couponTextBox.clear();
        cartPage.couponTextBox.sendKeys(coupon);
    }

    public void clickApplyCoupon() {
        cartPage.applyCouponButton.click();
    }

    public void enterGiftCardCode(String gift) {
        cartPage.giftCardTextBox.clear();
        cartPage.giftCardTextBox.sendKeys(gift);
    }

    public void clickApplyGiftCard() {
        cartPage.applyGiftCardButton.click();
    }

    public String getValidationMessage() {
        return cartPage.validationMessage.getText();
    }
}