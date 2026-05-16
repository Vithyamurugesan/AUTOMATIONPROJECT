package com.actions;

import java.time.Duration;

import com.pages.SearchPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchActions {

    WebDriver driver;
    WebDriverWait wait;
    SearchPage searchPage;

    public SearchActions(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        this.searchPage=new SearchPage(driver);
    }

    public void searchProduct(String keyword) {
        WebElement box=wait.until(ExpectedConditions.visibilityOfElementLocated(searchPage.getSearchBox()));
        box.clear();
        box.sendKeys(keyword);
    }

    public void clickSearch() {
        WebElement button=wait.until(ExpectedConditions.elementToBeClickable(searchPage.getSearchButton()));
        button.click();
    }

    public boolean verifySearchResultPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By)searchPage.getSearchResult()))
                .isDisplayed();
    }

    public boolean verifyNoProductMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By)searchPage.getNoResultMessage()))
                .isDisplayed();
    }
    
    public void acceptAlertIfPresent() {
    	
        try {
            Alert alert=wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            alert.accept();
        }
        catch (Exception e) {
            System.out.println("No alert present");
        }
    }

    public boolean isWarningDisplayed() {
    	
        try {
            Alert alert=wait.until(ExpectedConditions.alertIsPresent());
            String text=alert.getText();
            return text.equalsIgnoreCase("Please enter some search keyword");
        }
        catch (Exception e) {
            return false;
        }
    }
}