package com.actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;

public class CartAction extends BaseAction {

	CartPage cartPage;

	SearchActions searchActions;

	public CartAction(WebDriver driver) {

		super(driver);

		cartPage = new CartPage();

		searchActions = new SearchActions(driver);
	}

	public void openBookPage() {

		click(cartPage.getBooks());

		click(cartPage.getComputingBook());
	}

	public void addCart() {

		click(cartPage.getAddToCartButton());
	}

	public boolean checkCart() {

		click(cartPage.getShoppingCart());

		return HelperClass.getDriver().findElements(cartPage.getCartTable()).size() > 0;
	}

	public void addProductsFromExcel(String filePath, String sheetName) {

		List<Map<String, String>> products = ExcelReader.getData(filePath, sheetName);

		WebDriver driver = HelperClass.getDriver();

		for (Map<String, String> data : products) {

			String productName = data.get("productName");

			driver.get("https://demowebshop.tricentis.com/");

			searchActions.searchProduct(productName);

			searchActions.clickSearch();

			By productLink = By.partialLinkText(productName);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.elementToBeClickable(productLink));

			driver.findElement(productLink).click();

			click(cartPage.getAddToCartButton());
		}
	}

	public void openShoppingCart() {

		click(cartPage.getShoppingCart());
	}

	public boolean verifyProductsDisplayed() {

		List<WebElement> products = HelperClass.getDriver().findElements(cartPage.getProductList());

		return products.size() > 0;
	}

	public boolean verifyTotalAmount() {

		return waitForVisibility(cartPage.getSubtotal()).isDisplayed();
	}

	public void openEmptyCart() {

		HelperClass.getDriver().get("https://demowebshop.tricentis.com/cart");
	}

	public String getEmptyCartMessage() {

		return getText(cartPage.getEmptyCartMsg());
	}

	public void enterCouponCode(String code) {

		type(cartPage.getCouponBox(), code);
	}

	public void clickApplyCoupon() {

		click(cartPage.getCouponButton());
	}

	public String getValidationMessage() {

		return getText(cartPage.getMessage());
	}

	public void enterGiftCardCode(String code) {

		type(cartPage.getGiftCardBox(), code);
	}

	public void clickApplyGiftCard() {

		click(cartPage.getGiftCardButton());
	}

	public void updateQuantity(String quantity) {

		waitForVisibility(cartPage.getQuantityBox()).clear();

		type(cartPage.getQuantityBox(), quantity);
	}

	public void clickUpdateShoppingCart() {

		click(cartPage.getUpdateCartButton());
	}

	public boolean verifyUpdatedQuantity(String expectedQty) {

		String actualQty = waitForVisibility(cartPage.getQuantityBox()).getAttribute("value");

		return actualQty.equals(expectedQty);
	}

	public void removeProduct() {

		click(cartPage.getRemoveCheckBox());
	}

	public boolean verifyRemovedProduct() {

		return getText(cartPage.getEmptyCartMsg()).contains("Your Shopping Cart is empty!");
	}
	
}