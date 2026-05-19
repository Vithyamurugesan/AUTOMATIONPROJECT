package com.actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class CartAction extends BaseAction {

	private static final Logger logger = LogManager.getLogger(CartAction.class);

	CartPage cartPage;
	SearchActions searchActions;

	public CartAction(WebDriver driver) {
		super(driver);
		cartPage = new CartPage();
		searchActions = new SearchActions(driver);
		logger.info("CartAction initialized");
	}

	public void openBookPage() {

		logger.info("Opening Books page");
		click(cartPage.getBooks());
		click(cartPage.getComputingBook());
	}

	public void addCart() {

		logger.info("Clicking Add To Cart button");
		click(cartPage.getAddToCartButton());
	}

	public boolean checkCart() {

		logger.info("Checking shopping cart");
		click(cartPage.getShoppingCart());
		return HelperClass.getDriver().findElements(By.cssSelector("table.cart")).size() > 0;
	}

	public void addManyProducts(DataTable dataTable) {

		logger.info("Adding multiple products to cart");
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		WebDriver driver = HelperClass.getDriver();
		for (Map<String, String> value : data) {
			String product = value.get("productName");

			logger.info("Searching product: " + product);
			driver.get("https://demowebshop.tricentis.com/");

			searchActions.searchProduct(product);
			searchActions.clickSearch();

			By productLink = By.partialLinkText(product);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(productLink));
			driver.findElement(productLink).click();
			logger.info("Adding product to cart: " + product);
			click(cartPage.getAddToCartButton());
		}
	}

	public void openCart() {

		logger.info("Opening shopping cart");
		click(cartPage.getShoppingCart());
	}

	public boolean checkProducts() {

		logger.info("Checking products in cart");
		return waitForVisibility(cartPage.getCartTable())
				.isDisplayed();
	}

	public boolean checkTotal() {

		logger.info("Checking subtotal");
		return waitForVisibility(cartPage.getSubtotal()).isDisplayed();
	}

	public void openEmptyCart() {

		logger.info("Opening empty cart");
		HelperClass.getDriver().get("https://demowebshop.tricentis.com/cart");
	}

	public String getEmptyMsg() {

		logger.info("Getting empty cart message");
		return getText(cartPage.getEmptyCartMsg());
	}

	public void addOneProduct() {

		logger.info("Adding one product");
		openBookPage();
		addCart();
	}

	public void enterCoupon(String code) {

		logger.info("Entering coupon code");
		type(cartPage.getCouponBox(), code);
	}

	public void clickCoupon() {

		logger.info("click coupon");
		click(cartPage.getCouponButton());
	}

	public void enterGift(String code) {
		
		logger.info("Entering gift card code");
		type(cartPage.getGiftCardBox(), code);
	}

	public void clickGift() {
		logger.info("Click gift card");
		click(cartPage.getGiftCardButton());
	}

	public String getMsg() {
		logger.info("Get validation message");
		return getText(cartPage.getMessage());
	}

	public void updateQuantity(String qty) {

		logger.info("Updating quantity to: " + qty);
		waitForVisibility(cartPage.getQuantityBox()).clear();
		type(cartPage.getQuantityBox(), qty);
	}

	public void clickUpdateCart() {

		logger.info("Clicking Update Cart");
		click(cartPage.getUpdateCartButton());
	}

	public boolean checkUpdatedQty(String expectedQty) {

		logger.info("Checking updated quantity");
		String actualQuantity = waitForVisibility(cartPage.getQuantityBox()).getAttribute("value");
		return actualQuantity.equals(expectedQty)&& waitForVisibility(cartPage.getQuantityBox())
				.isDisplayed();
	}

	public void removeProduct() {

		logger.info("Removing product from cart");
		if (waitForVisibility(cartPage.getRemoveCheckBox()).isDisplayed()
				&& waitForVisibility(cartPage.getRemoveCheckBox()).isEnabled()) {
			click(cartPage.getRemoveCheckBox());
		}
	}

	public boolean checkRemovedProduct() {

		logger.info("Checking removed product message");
		String actualMessage = waitForVisibility(cartPage.getEmptyCartMsg()).getText();
		return actualMessage.contains("Your Shopping Cart is empty!");
	}
}