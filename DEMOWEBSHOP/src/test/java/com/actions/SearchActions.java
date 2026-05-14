package com.actions;

import com.pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class SearchActions {

    SearchPage searchPage;

    public SearchActions(WebDriver driver) {
        searchPage = new SearchPage(driver);
    }

    public void searchProduct(String keyword) {
        searchPage.enterSearchKeyword(keyword);
    }

    public void clickSearch() {
        searchPage.clickSearch();
    }

    public boolean verifySearchResultPage() {
        return searchPage.isSearchResultsPage();
    }

    public boolean verifyNoProductMessage() {
        return searchPage.isNoProductMessageDisplayed();
    }

    public boolean verifyProductsDisplayed() {
        return searchPage.isSearchResultsPage();
    }

    public void acceptAlertIfPresent() {
        searchPage.acceptAlertIfPresent();
    }
}