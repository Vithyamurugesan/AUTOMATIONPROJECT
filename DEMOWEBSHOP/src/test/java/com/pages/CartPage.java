package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Books")
    public WebElement booksMenu;

    @FindBy(linkText = "Computing and Internet")
    public WebElement computingBook;

    @FindBy(id = "add-to-cart-button-13")
    public WebElement addToCartButton;

    @FindBy(linkText = "Shopping cart")
    public WebElement shoppingCart;

    @FindBy(id = "small-searchterms")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    public WebElement searchButton;
}