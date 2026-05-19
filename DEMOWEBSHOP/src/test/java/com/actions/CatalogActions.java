package com.actions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.CatalogPage;

public class CatalogActions extends BaseAction {

    private static final Logger log = LogManager.getLogger(CatalogActions.class);

    private WebDriver driver;
    private CatalogPage catalogPage;

    public CatalogActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.catalogPage = new CatalogPage();
    }

    public void clickComputersCategory() {
        log.info("Clicking on Computers category from top navigation");
        click(catalogPage.getComputersCategory());
    }

    public void clickElectronicsCategory() {
        log.info("Clicking on Electronics category from top navigation");
        click(catalogPage.getElectronicsCategory());
    }

    public void clickBooksCategory() {
        log.info("Clicking on Books category from top navigation");
        click(catalogPage.getBooksCategory());
    }

    public void clickApparelCategory() {
        log.info("Clicking on Apparel & Shoes category from top navigation");
        click(catalogPage.getApparelCategory());
    }

    public void clickGiftCardsCategory() {
        log.info("Clicking on Gift Cards category from top navigation");
        click(catalogPage.getGiftCardsCategory());
    }

    public boolean isCategoryPageTitleDisplayed() {
        try {
            boolean displayed = waitForVisibility(catalogPage.getCategoryPageTitle()).isDisplayed();
            log.info("Category page title displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Category page title not found: {}", e.getMessage());
            return false;
        }
    }

    public String getCategoryPageTitle() {
        String title = getText(catalogPage.getCategoryPageTitle());
        log.info("Category page title is: {}", title);
        return title;
    }

    public boolean isProductGridDisplayed() {
        try {
            boolean displayed = waitForVisibility(catalogPage.getProductGrid()).isDisplayed();
            log.info("Product grid displayed: {}", displayed);
            return displayed;
        }
        catch (Exception e) {
            log.error("Product grid not visible: {}", e.getMessage());
            return false;
        }
    }

    public int getProductCount() {
        List<WebElement> items = driver.findElements(catalogPage.getProductItems());
        log.info("Total products displayed in catalog: {}", items.size());
        return items.size();
    }

    public boolean areProductsDisplayed() {
        int count = getProductCount();
        boolean result = count > 0;
        log.info("Products displayed in catalog: {}", result);
        return result;
    }

    public boolean isBreadcrumbDisplayed() {
        try {
            boolean displayed = waitForVisibility(catalogPage.getBreadcrumb()).isDisplayed();
            log.info("Breadcrumb displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Breadcrumb not found: {}", e.getMessage());
            return false;
        }
    }
}