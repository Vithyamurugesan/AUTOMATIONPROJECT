package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;

    @FindBy(className = "product-grid")
    private WebElement searchResult;

    @FindBy(xpath = "//*[contains(text(),'No products were found')]")
    private WebElement noResultMessage;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchResult() {
        return searchResult;
    }

    public WebElement getNoResultMessage() {
        return noResultMessage;
    }
}