package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ---------- WEB ELEMENTS ----------

    @FindBy(linkText = "Books")
    WebElement booksMenu;

    @FindBy(linkText = "Computing and Internet")
    WebElement computingBook;

    @FindBy(id = "add-to-cart-button-13")
    WebElement addToCartButton;

    @FindBy(linkText = "Shopping cart")
    WebElement shoppingCart;

    @FindBy(className = "qty-input")
    WebElement quantityBox;

    @FindBy(name = "updatecart")
    WebElement updateCartButton;

    @FindBy(name = "removefromcart")
    WebElement removeCheckbox;

    @FindBy(xpath = "//input[@name='discountcouponcode']")
    WebElement couponBox;

    @FindBy(xpath = "//input[@name='applydiscountcouponcode']")
    WebElement applyCouponButton;

    @FindBy(xpath = "//input[@name='giftcardcouponcode']")
    WebElement giftCardBox;

    @FindBy(xpath = "//input[@name='applygiftcardcouponcode']")
    WebElement applyGiftCardButton;

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    // EMPTY CART MESSAGE ONLY
    @FindBy(css = "div.order-summary-content")
    WebElement cartMessage;

    // ---------- ACTIONS ----------

    public void openProductPage() {
        booksMenu.click();
        computingBook.click();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void openShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();
        wait.until(ExpectedConditions.visibilityOf(cartMessage));
    }

    // FIXED: valid only when cart has items
    public boolean isCartHasItems() {
        return driver.findElements(By.cssSelector("table.cart")).size() > 0;
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void openSearchedProduct(String productName) {
        By product = By.partialLinkText(productName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(product));

        driver.findElement(product).click();
    }

    public void addMultipleProductToCart() {
        driver.findElement(By.xpath("//input[contains(@value,'Add to cart')]")).click();
    }

    public void updateQuantity() {
        quantityBox.clear();
        quantityBox.sendKeys("2");
    }

    public void clickUpdateCart() {
        updateCartButton.click();
    }

    public void removeProduct() {
        removeCheckbox.click();
    }

    public void enterCoupon(String coupon) {
        WebElement couponField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='discountcouponcode']")
            )
        );
        couponField.clear();
        couponField.sendKeys(coupon);
    }

    public void applyCoupon() {
        WebElement applyBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='applydiscountcouponcode']")
            )
        );
        applyBtn.click();
    }

    public void enterGiftCard(String giftcard) {
        WebElement giftCardField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='giftcardcouponcode']")
            )
        );
        giftCardField.clear();
        giftCardField.sendKeys(giftcard);
    }

    public void applyGiftCard() {
        WebElement applyBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='applygiftcardcouponcode']")
            )
        );
        applyBtn.click();
    }

    // FIXED EMPTY CART LOGIC
    public boolean isEmptyCartMessageDisplayed() {
        return cartMessage.getText().contains("Your Shopping Cart is empty!");
    }
}