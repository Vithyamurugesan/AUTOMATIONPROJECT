package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox=By.id("small-searchterms");
    private By searchButton=By.xpath("//input[@value='Search']");
    private By searchResult=By.className("product-grid");
    private By noResultMessage=By.xpath("//*[contains(text(),'No products were found')]");

	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public By getSearchBox() {
		return searchBox;
	}
	public void setSearchBox(By searchBox) {
		this.searchBox = searchBox;
	}
	public By getSearchButton() {
		return searchButton;
	}
	public void setSearchButton(By searchButton) {
		this.searchButton = searchButton;
	}
	public By getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(By searchResult) {
		this.searchResult = searchResult;
	}
	public By getNoResultMessage() {
		return noResultMessage;
	}
	public void setNoResultMessage(By noResultMessage) {
		this.noResultMessage = noResultMessage;
	}
}