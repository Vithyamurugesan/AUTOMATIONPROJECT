package com.actions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.SearchPage;

public class SearchActions extends BaseAction {

    SearchPage searchPage;

    public SearchActions(org.openqa.selenium.WebDriver driver) {
        super(driver);
        this.searchPage = new SearchPage();
    }

    public void searchProduct(String keyword) {
        waitForVisibility(searchPage.getSearchBox()).clear();
        type(searchPage.getSearchBox(), keyword);
    }

    public void clickSearch() {
        click(searchPage.getSearchButton());
    }

    public boolean verifySearchRedirect() {
        return driver.getCurrentUrl().contains("search");
    }

    public boolean verifyResultsNotEmpty() {
        List<WebElement> results=driver.findElements(By.cssSelector(".product-item"));
        return results.size()>0;
    }
    
    
    public boolean verifyResultsContainKeyword(String keyword) {

        List<WebElement> titles=driver.findElements(By.cssSelector(".product-title a"));

        for (WebElement element : titles) {
            String actualText = element.getText().trim().toLowerCase();
            System.out.println("Product Title : " + actualText);
            
            if (actualText.contains(keyword.toLowerCase().trim())) {
                return true;
            }
        }

        return false;
    }

    public boolean verifyNoProductMessage() {
        return waitForVisibility(searchPage.getNoResultMessage()).isDisplayed();
    }

    public boolean isWarningDisplayed() {
        return waitForVisibility(searchPage.getWarningMessage()).isDisplayed();
    }
    
    public boolean handleAlertIfPresent() {

        try {
            Alert alert=wait.until(ExpectedConditions.alertIsPresent());

            String text=alert.getText();
            System.out.println("Alert message: "+text);

            alert.accept();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void openProductFromResults(String productName) {
        driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
    }
    
}