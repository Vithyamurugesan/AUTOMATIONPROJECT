package com.actions;

import org.openqa.selenium.WebDriver;
import com.pages.ProductDetailsPage;

public class ProductDetailsAction extends BaseAction {

    ProductDetailsPage page;

    public ProductDetailsAction(WebDriver driver) {
        super(driver);
        page = new ProductDetailsPage(driver);
    }

    public void openBooks() {
        click(page.booksCategory());
    }

    public void selectProduct() {
        click(page.product());
    }

    public boolean isNameDisplayed() {
        return waitForVisibility(page.name()).isDisplayed();
    }

    public boolean isPriceDisplayed() {
        return waitForVisibility(page.price()).isDisplayed();
    }

    public boolean isDescDisplayed() {
        return waitForVisibility(page.desc()).isDisplayed();
    }

    public boolean isImageDisplayed() {
        return waitForVisibility(page.image()).isDisplayed();
    }

    public String getAvailability() {
        try {
            return waitForVisibility(page.availability()).getText();
        } catch (Exception e) {
            return "Not Found";
        }
    }

    public void enterQty(String qty) {
        waitForVisibility(page.quantity()).clear();
        type(page.quantity(), qty);
    }

    public void addToCart() {
        click(page.addToCart());
    }

    public boolean isQtyError() {
        return driver.getPageSource().contains("Quantity");
    }
}