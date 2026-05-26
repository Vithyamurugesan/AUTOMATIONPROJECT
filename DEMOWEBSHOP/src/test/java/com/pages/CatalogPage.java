package com.pages;

import org.openqa.selenium.By;

public class CatalogPage {

    private By productGrid =By.xpath("//div[@class='product-grid']");

    private By subCategoryGrid =By.xpath("//div[contains(@class,'page-body')]/descendant::div[contains(@class,'sub-category-item') or contains(@class,'category-grid')]");

    private By productItems =By.xpath("//div[contains(@class,'product-item')]");

    private By productTitles =By.xpath("//h2[@class='product-title']/a");

    private By breadcrumb =By.xpath("//div[contains(@class,'breadcrumb')]");

    private By categoryList = By.xpath("//div[contains(@class,'block-category-navigation')]/descendant::a");

    public By getCategory(String categoryName) {
    	    return By.xpath( "//ul[contains(@class,'top-menu')]//a[normalize-space()='"+ categoryName + "']");
    }

    public By getSubCategory(String name) {
        return By.xpath( "//div[contains(@class,'sub-category-item')]"+ "/descendant::a[normalize-space()='"+ name + "']");
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