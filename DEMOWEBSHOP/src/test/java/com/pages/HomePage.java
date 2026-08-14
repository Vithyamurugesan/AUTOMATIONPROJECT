package com.pages;

import org.openqa.selenium.By;

public class HomePage {
    private By book = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Books']");
    private By sortingOptions = By.xpath("//select[@id='products-orderby']");
    private By products = By.xpath("//*[@class=\"product-grid\"]/div");

    public By getBookLink() {
        return this.book;
    }
    public By getSortingOptions() {
        return this.sortingOptions;
    }
    public By getProducts() {
        return this.products;
    }
}