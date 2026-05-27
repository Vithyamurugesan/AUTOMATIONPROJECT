package com.actions;

import java.util.List;
import java.util.Map;

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

		click(comparePage.getRemoveCheckbox(product));
	}

	public void clickRemoveButton() {

		click(comparePage.getRemoveButton());
	}

	

	public boolean verifyRemovedProduct(String product) {

		return HelperClass.getDriver().findElements(comparePage.getProductLink(product)).size() == 0;
	}

	public boolean verifyRemainingProduct(String product) {

		return HelperClass.getDriver().findElements(comparePage.getProductLink(product)).size() > 0;
	}

	public void clearCompareList() {

		click(comparePage.getClearListButton());
	}

	public boolean verifyEmptyCompareList() {

		return getText(comparePage.getEmptyCompareMessage()).toLowerCase().contains("no items");
	}
}