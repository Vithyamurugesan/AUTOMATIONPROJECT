package com.actions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.RecentlyViewedProductsPage;
import com.utilities.ConfigReader;
import com.utilities.CsvReader;
import com.utilities.HelperClass;

public class RecentlyViewedProductsAction extends BaseAction {

	RecentlyViewedProductsPage recentlyViewedProductsPage;

	List<String> visitedProducts = new ArrayList<>();
	public RecentlyViewedProductsAction(WebDriver driver) {
		super(driver);
		recentlyViewedProductsPage = new RecentlyViewedProductsPage();
	}

	public void openCategory(String category) {
		click(By.linkText(category));
	}

	public void openProduct(String product) {
		click(recentlyViewedProductsPage.getProductLink(product));
	}

	public void openRecentlyViewedProductsPage() {
		click(recentlyViewedProductsPage.getRecentlyViewedProductsLink());
	}

	public void openFirstProductFromCsv(String filePath) {
		List<Map<String, String>> data = CsvReader.getData(filePath);
		Map<String, String> row = data.get(0);
		String category = row.get("category");
		String product = row.get("product");
		visitedProducts.clear();
		HelperClass.getDriver().get(ConfigReader.get("app.url"));
		openCategory(category);
		openProduct(product);
		visitedProducts.add(product);
	}

	public void openAllProductsFromCsv(String filePath) {
		List<Map<String, String>> data = CsvReader.getData(filePath);
		visitedProducts.clear();
		for (Map<String, String> row : data) {
			String category = row.get("category");
			String product = row.get("product");
			HelperClass.getDriver().get(ConfigReader.get("app.url"));
			openCategory(category);
			openProduct(product);
			visitedProducts.add(product);
		}
	}

	public boolean verifyRecentlyViewedProductsPage() {
		try {
			return waitForVisibility(recentlyViewedProductsPage.getPageTitle()).isDisplayed();
		}
		catch (Exception e) {
			System.out.println("Recently Viewed Products page not opened: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyProductDisplayed(String product) {
		List<WebElement> titles = HelperClass.getDriver().findElements(recentlyViewedProductsPage.getProductTitles());
		for (WebElement title : titles) {
			if (title.getText().trim().equalsIgnoreCase(product)) {
				return true;
			}
		}
		return false;
	}

	public boolean verifyProductsDisplayed(List<String> products) {
		List<WebElement> titles = HelperClass.getDriver().findElements(recentlyViewedProductsPage.getProductTitles());
		List<String> actualTitles = new ArrayList<>();
		for (WebElement title : titles) {
			actualTitles.add(title.getText().trim());
		}

		for (String product : products) {
			if (!actualTitles.contains(product)) {
				return false;
			}
		}
		return true;
	}

	public boolean verifyFirstVisitedProductDisplayed() {
		if (visitedProducts.isEmpty()) {
			return false;
		}
		return verifyProductDisplayed(visitedProducts.get(0));
	}


	public int getViewedProductsCount() {
		return HelperClass.getDriver().findElements(recentlyViewedProductsPage.getProductItems()).size();
	}
}
