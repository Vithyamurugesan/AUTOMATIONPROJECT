package com.actions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.ComparePage;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class CompareAction extends BaseAction {

	ComparePage comparePage;

	public CompareAction(WebDriver driver) {

		super(driver);

		comparePage = new ComparePage();
	}

	public void openJewelryPage() {

		click(comparePage.getJewelryLink());
	}

	public void openProduct(String product) {

		click(comparePage.getProductLink(product));
	}

	public void clickAddToCompare() {

		click(comparePage.getAddToCompareButton());
	}

	public void openCompareProductsPage() {

		HelperClass.getDriver().get(ConfigReader.get("app.url") + "/compareproducts");
	}

	public boolean verifyComparePage() {

		return HelperClass.getDriver().getCurrentUrl().contains("compareproducts");
	}

	public boolean verifyComparedProducts() {

		List<WebElement> products = HelperClass.getDriver().findElements(comparePage.getCompareProducts());

		return products.size() > 0;
	}

	public void addProductsFromExcel(String path, String sheet) {

		List<Map<String, String>> data = ExcelReader.getData(path, sheet);

		for (Map<String, String> row : data) {

			String product = row.get("product");

			HelperClass.getDriver().get(ConfigReader.get("app.url") + "/jewelry");

			openProduct(product);

			clickAddToCompare();

			HelperClass.getDriver().navigate().back();
		}
	}

	public void addProducts(DataTable table) {

		List<Map<String, String>> data = table.asMaps();

		for (Map<String, String> row : data) {

			String product = row.get("product");

			openProduct(product);

			clickAddToCompare();

			HelperClass.getDriver().get(ConfigReader.get("app.url") + "/jewelry");
		}
	}

	public void addSingleProduct(String product) {

		openProduct(product);

		clickAddToCompare();
	}

	public void removeProduct(String product) {
		List<WebElement> removeButtons = HelperClass.getDriver()
				.findElements(By.xpath("//tr[@class='overview']//input[@value='Remove']"));

		System.out.println("Total Remove buttons found: " + removeButtons.size());

		if (product.equalsIgnoreCase("Diamond Tennis Bracelet")) {
			if (removeButtons.size() >= 2) {
				removeButtons.get(1).click();
				System.out.println("Clicked Remove button at index 1");
			}
		} else if (product.equalsIgnoreCase("Black & White Diamond Heart")) {
			if (removeButtons.size() >= 1) {
				removeButtons.get(0).click();
				System.out.println("Clicked Remove button at index 0");
			}
		}

		HelperClass.getDriver().get(ConfigReader.get("app.url") + "/compareproducts");
	}

	public boolean verifyRemovedProduct(String product) {
		List<WebElement> removeButtons = HelperClass.getDriver()
				.findElements(By.xpath("//tr[@class='overview']//input[@value='Remove']"));
		System.out.println("Remove buttons after removal: " + removeButtons.size());
		return removeButtons.size() == 1;
	}

	public boolean verifyRemainingProduct(String product) {
		List<WebElement> removeButtons = HelperClass.getDriver()
				.findElements(By.xpath("//tr[@class='overview']//input[@value='Remove']"));
		return removeButtons.size() >= 1;
	}

	public void clearCompareList() {

		click(comparePage.getClearListButton());
	}

	public boolean verifyEmptyCompareList() {

		return getText(comparePage.getEmptyCompareMessage()).toLowerCase().contains("no items");
	}
}