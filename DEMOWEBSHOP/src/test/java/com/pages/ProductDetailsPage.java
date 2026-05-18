package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By booksCategory = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");

    private By product = By.xpath("//h2[@class='product-title']//a[contains(text(),'Computing and Internet')]");

    private By productName = By.xpath("//div[@class='product-name']/h1");
    private By productPrice = By.xpath("//div[@class='product-price']//span");
    private By productDesc = By.xpath("//div[@class='full-description']");
    private By productImage = By.xpath("//div[@class='picture']//img");

    private By availability = By.xpath("//div[contains(@class,'availability')]");

    private By quantity = By.xpath("//input[contains(@id,'EnteredQuantity')]");
    private By addToCart = By.xpath("//input[@value='Add to cart']");

    public By booksCategory() { return booksCategory; }
    public By product() { return product; }
    public By name() { return productName; }
    public By price() { return productPrice; }
    public By desc() { return productDesc; }
    public By image() { return productImage; }
    public By availability() { return availability; }
    public By quantity() { return quantity; }
    public By addToCart() { return addToCart; }
}