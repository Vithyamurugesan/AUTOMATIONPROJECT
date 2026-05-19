package com.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.CatalogPage;

public class CatalogActions extends BaseAction {

    private WebDriver driver;
    private CatalogPage catalogPage;

    public CatalogActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        catalogPage = new CatalogPage();
    }

    public void clickCategory(String categoryName) {
        click(catalogPage.getCategory(categoryName));
    }

    public void clickSubCategory(String name) {
        click(catalogPage.getSubCategory(name));
    }

    public boolean verifyCurrentUrl(String expectedUrlPart) {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.contains(expectedUrlPart);
    }

    public boolean isProductGridDisplayed() {
        try {
            List<WebElement> grid = driver.findElements(catalogPage.getProductGrid());
            if (grid.size() > 0 && grid.get(0).isDisplayed()) return true;

            List<WebElement> subGrid = driver.findElements(catalogPage.getSubCategoryGrid());
            return subGrid.size() > 0 && subGrid.get(0).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getDisplayedProductCount() {
       
        List<WebElement> products = driver.findElements(catalogPage.getProductItems());
        if (products.size() > 0) return products.size();

     
        List<WebElement> subCategories = driver.findElements(catalogPage.getSubCategoryGrid());
        return subCategories.size();
    }

    public String getBreadcrumbText() {

        return driver.findElement(catalogPage.getBreadcrumb()).getText().trim().toUpperCase();
    }

    public List<String> getDisplayedProducts() {
        List<WebElement> productElements = driver.findElements(catalogPage.getProductTitles());
        List<String> productNames = new ArrayList<>();
        for (WebElement element : productElements) {
            productNames.add(element.getText().trim());
        }
        return productNames;
    }

    public boolean verifyProducts(List<String> expectedProducts) {
        List<String> actualProducts = getDisplayedProducts();
        return actualProducts.containsAll(expectedProducts);
    }

    public List<String> getCategoryList() {
        List<WebElement> categoryElements = driver.findElements(catalogPage.getCategoryList());
        List<String> categories = new ArrayList<>();
        for (WebElement element : categoryElements) {
            categories.add(element.getText().trim());
        }
        return categories;
    }

    public boolean verifyCategoryPresent(String expectedCategory) {
        return getCategoryList().contains(expectedCategory);
    }
}