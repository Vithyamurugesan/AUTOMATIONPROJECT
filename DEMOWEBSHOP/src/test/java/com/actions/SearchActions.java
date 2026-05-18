package com.actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.SearchPage;

public class SearchActions extends BaseAction {

    WebDriver driver;
    WebDriverWait wait;
    SearchPage searchPage;

    public SearchActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.searchPage = new SearchPage();
    }

    public void searchProduct(String keyword) {
        waitForVisibility(searchPage.getSearchBox()).clear();
        type(searchPage.getSearchBox(), keyword);
    }

    public void clickSearch() {
        click(searchPage.getSearchButton());
    }

    public boolean verifySearchResultPage() {
        return waitForVisibility(searchPage.getSearchResult()).isDisplayed();
    }

    public boolean verifyNoProductMessage() {
        return waitForVisibility(searchPage.getNoResultMessage()).isDisplayed();
    }

    public boolean acceptAlertIfPresent() {

        try {
            Alert alert=wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());

            alert.accept();
            return true;
        }
        catch (Exception e) {
            System.out.println("No alert present");
        }
        
        return false;
    }

    public boolean isWarningDisplayed() {

        try {
            return waitForVisibility(searchPage.getWarningMessage()).isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }
}