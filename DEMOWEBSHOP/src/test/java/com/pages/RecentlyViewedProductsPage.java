package com.pages;
import org.openqa.selenium.By;

public class RecentlyViewedProductsPage {

	private By recentlyViewedProductsLink = By.linkText("Recently viewed products");

	private By pageTitle = By.xpath("//div[@class='page-title']/h1");

	private By productItems = By.xpath("//div[contains(@class,'product-item')]");

	private By productTitles = By.xpath("//div[contains(@class,'product-item')]//h2[@class='product-title']/a");

	public By getRecentlyViewedProductsLink() {
		return recentlyViewedProductsLink;
	}

	public By getPageTitle() {
		return pageTitle;
	}

	public By getProductItems() {
		return productItems;
	}

	public By getProductTitles() {
		return productTitles;
	}

	public By getProductLink(String product) {
		return By.xpath("//a[text()='" + product + "']");
	}
}
