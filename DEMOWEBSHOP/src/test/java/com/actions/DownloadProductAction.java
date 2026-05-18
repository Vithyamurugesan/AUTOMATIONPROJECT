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
		waitForVisibility(DownloadPage.getMyaccountLink()).isDisplayed();
	}

	public void clickMyAccount() {
		click(DownloadPage.getMyaccountLink());
	}

	public void clickDownload() {
		click(DownloadPage.getDownloadProductLink());
	}

	public int countofordownloadProduct() {
		return driver.findElements(DownloadPage.getProductcount()).size();
	}

	public List<String> getAllProductNames() {

		List<WebElement> products = driver.findElements(DownloadPage.getProductName());

		List<String> productList = new ArrayList<>();

		for (WebElement product : products) {
			productList.add(product.getText());
		}

		return productList;
	}
}
