package com.pages;

import org.openqa.selenium.By;

public class CatalogPage {

    private By productGrid = By.cssSelector("div.product-grid");

    private By subCategoryGrid = By.cssSelector("div.sub-category-item, div.category-grid");

    private By productItems = By.cssSelector("div.product-item");

    private By productTitles = By.cssSelector("div.product-item .product-title a");

    private By breadcrumb = By.cssSelector("div.breadcrumb");

    private By categoryList = By.cssSelector("div.block-category-navigation ul.list li a");

    public By getCategory(String categoryName) {
        if (categoryName.contains("&")) {
            String before = categoryName.split("&")[0].trim();
            return By.xpath("//ul[contains(@class,'top-menu')]//a[contains(text(),'" + before + "')]");
        }
        return By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='" + categoryName + "']");
    }

    public By getSubCategory(String name) {
        return By.xpath("//div[contains(@class,'sub-category-item')]//a[normalize-space()='" + name + "']");
    }

    public By getProductGrid() { 
    	return productGrid; 
    	}

    public By getSubCategoryGrid() {
    	return subCategoryGrid; 
    	}

    public By getProductItems() { 
    	return productItems; 
    	}

    public By getProductTitles() { 
    	return productTitles;
    	}

    
    public By getBreadcrumb() {
    	return breadcrumb; 
    	}

    public By getCategoryList() { 
    	return categoryList; 
    	}
}