package com.pages;

import org.openqa.selenium.By;

public class SearchPage {

    private By searchBox=By.id("small-searchterms");
    private By searchButton=By.xpath("//input[@value='Search']");
    private By searchResult=By.className("product-grid");
    private By noResultMessage=By.xpath("//*[contains(text(),'No products were found')]");
    private By warningMessage=By.cssSelector(".warning");
    
    public By getSearchBox() {
        return searchBox;
    }

    public By getSearchButton() {
        return searchButton;
    }

    public By getSearchResult() {
        return searchResult;
    }

    public By getNoResultMessage() {
        return noResultMessage;
    }

    public By getWarningMessage() {
        return warningMessage;
    }
}