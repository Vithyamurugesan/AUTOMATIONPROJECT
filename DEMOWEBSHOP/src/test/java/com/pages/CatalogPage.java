package com.pages;

import org.openqa.selenium.By;

public class CatalogPage {

    private By computersCategory = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Computers']");
    private By electronicsCategory = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Electronics']");
    private By booksCategory = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Books']");
    private By apparelCategory = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Apparel & Shoes']");
    private By giftCardsCategory = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Gift Cards']");
    private By categoryPageTitle = By.cssSelector("div.page-title h1");
    private By productGrid = By.cssSelector("div.product-grid");
    private By productItems = By.cssSelector("div.product-item");
    private By productTitles = By.cssSelector("div.product-item .product-title a");
    private By breadcrumb = By.cssSelector("div.breadcrumb");
    private By categoryList = By.cssSelector("div.block-category-navigation ul.list li a");

    public By getComputersCategory() {
        return computersCategory;
    }

    public By getElectronicsCategory() {
        return electronicsCategory;
    }

    public By getBooksCategory() {
        return booksCategory;
    }

    public By getApparelCategory() {
        return apparelCategory;
    }

    public By getGiftCardsCategory() {
        return giftCardsCategory;
    }

    public By getCategoryPageTitle() {
        return categoryPageTitle;
    }

    public By getProductGrid() {
        return productGrid;
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