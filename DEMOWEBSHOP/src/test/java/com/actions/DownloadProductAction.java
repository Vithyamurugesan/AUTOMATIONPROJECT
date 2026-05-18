package com.actions;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.pages.DownloadPage;

public class DownloadProductAction extends BaseAction {

	WebDriver driver;

	public DownloadProductAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void waitforMyAccountlink() {
		waitForVisibility(DownloadPage.myaccountLink).isDisplayed();
	}

	public void clickMyAccount() {
		click(DownloadPage.myaccountLink);
	}

	public void clickDownload() {
		click(DownloadPage.downloadProductLink);
	}

	public int countofordownloadProduct() {
		return driver.findElements(DownloadPage.productcount).size();
	}

	public List<String> getAllProductNames() {

		List<WebElement> products = driver.findElements(DownloadPage.ProductName);

		List<String> productList = new ArrayList<>();

		for (WebElement product : products) {
			productList.add(product.getText());
		}

		return productList;
	}
}
