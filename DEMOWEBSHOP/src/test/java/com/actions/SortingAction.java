package com.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.HomePage;
import com.utilities.HelperClass;

public class SortingAction extends BaseAction {

    private HomePage homePage;
    private static final Map<String, String> ORDER_LABELS = Map.of(
        "AtoZ",           "Name: A to Z",
        "ZtoA",           "Name: Z to A",
        "PriceLowToHigh", "Price: Low to High",
        "PriceHighToLow", "Price: High to Low"
    );

    public SortingAction(WebDriver driver) {
        super(driver);
        this.homePage = new HomePage();
    }

    public void navigateToBooks() {
        click(homePage.getBookLink());
    }

    public void selectOption(String order) {
    	String visibleText = ORDER_LABELS.get(order);
        if (visibleText == null) {
            throw new IllegalArgumentException("Unknown sort order key: " + order);
        }
        Select select = new Select(HelperClass.getDriver().findElement(homePage.getSortingOptions()));
        select.selectByVisibleText(visibleText);
    }

    public boolean isSorted(String order) {

        List<WebElement> products = HelperClass.getDriver().findElements(homePage.getProducts());

        if (order.equalsIgnoreCase("AtoZ") || order.equalsIgnoreCase("ZtoA")) {
            return isSortedByName(products, order);
        } else if (order.equalsIgnoreCase("PriceLowToHigh") || order.equalsIgnoreCase("PriceHighToLow")) {
            return isSortedByPrice(products, order);
        }

        throw new IllegalArgumentException("Unknown sort order key: " + order);
    }

    private boolean isSortedByName(List<WebElement> products, String order) {

        List<String> productNames = new ArrayList<>();
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("h2.product-title a")).getText();
            productNames.add(productName);
        }

        List<String> sortedNames = new ArrayList<>(productNames);

        if (order.equalsIgnoreCase("AtoZ")) {
            sortedNames.sort(String.CASE_INSENSITIVE_ORDER);
        } else {
            sortedNames.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        }

        return productNames.equals(sortedNames);
    }

     private boolean isSortedByPrice(List<WebElement> products, String order) {

        Pattern pricePattern = Pattern.compile("[\\d,]+\\.?\\d*");

        List<Double> productPrices = new ArrayList<>();
        for (WebElement product : products) {
            String priceText = product.findElement(By.cssSelector("span.price.actual-price")).getText();
            Matcher matcher = pricePattern.matcher(priceText);
            if (matcher.find()) {
                String numeric = matcher.group().replace(",", "");
                productPrices.add(Double.parseDouble(numeric));
            }
        }

        List<Double> sortedPrices = new ArrayList<>(productPrices);

        if (order.equalsIgnoreCase("PriceLowToHigh")) {
            Collections.sort(sortedPrices);
        } else {
            sortedPrices.sort(Collections.reverseOrder());
        }

        return productPrices.equals(sortedPrices);
    }

}