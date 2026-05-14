package com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "input[value='Search']")
    WebElement searchButton;

    public void enterSearchKeyword(String keyword) {
        if (keyword==null||keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Search keyword is null/empty");
        }
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void acceptAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public boolean isSearchResultsPage() {

        acceptAlertIfPresent();

        try {
            return wait.until(ExpectedConditions.urlContains("search"));
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean isNoProductMessageDisplayed() {

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'No products were found')]")))
            .isDisplayed();

        }
        catch (Exception e) {
            return false;
        }
    }
}