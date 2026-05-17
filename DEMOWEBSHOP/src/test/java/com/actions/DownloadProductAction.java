package com.actions;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.pages.DownloadPageLocator;

public class DownloadProductAction extends BaseAction {

	WebDriver driver;

	public DownloadProductAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void waitforMyAccountlink() {
		waitForVisibility(DownloadPageLocator.myaccountLink).isDisplayed();
	}

	public void clickMyAccount() {
		click(DownloadPageLocator.myaccountLink);
	}

	public void clickDownload() {
		click(DownloadPageLocator.downloadProductLink);
	}

	public int countofordownloadProduct() {
		return driver.findElements(DownloadPageLocator.productcount).size();
	}

	public List<String> getAllProductNames() {

		List<WebElement> products = driver.findElements(DownloadPageLocator.ProductName);

		List<String> productList = new ArrayList<>();

		for (WebElement product : products) {
			productList.add(product.getText());
		}

		return productList;
	}
}
