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

        cartPage = new CartPage();
    }

    public void openProductDetailsPage() {
        cartPage.booksMenu.click();
        cartPage.computingBook.click();
    }

    public void addProductToCart() {
        WebDriverWait wait =new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.addToCartButton));
        
        cartPage.addToCartButton.click();
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
}