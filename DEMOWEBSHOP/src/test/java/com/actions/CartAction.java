package com.actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class CartAction extends BaseAction {
	CartPage cartPage;

	public CartAction(WebDriver driver) {
		super(driver);
		cartPage = new CartPage(driver);
	}

	public void openBookPage() {
		click(cartPage.getBooks());
		click(cartPage.getComputingBook());
	}

	public void addCart() {
		By addBtn = By.xpath("//input[contains(@value,'Add to cart')]");
		click(addBtn);
	}

	public boolean checkCart() {
		click(cartPage.getShoppingCart());
		return HelperClass.getDriver()
				.findElements(By.cssSelector("table.cart"))
				.size() > 0;
	}

	public void addManyProducts(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		WebDriver driver = HelperClass.getDriver();

		for (Map<String, String> value : data) {
			String product = value.get("productName");
			driver.get("https://demowebshop.tricentis.com/");

			type(cartPage.getSearchBox(), product);
			click(cartPage.getSearchButton());

			By productLink = By.partialLinkText(product);
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(productLink));
			driver.findElement(productLink).click();
			
			By addBtn = By.xpath("//input[contains(@value,'Add to cart')]");
			click(addBtn);
		}
	}

	public void openCart() {
		click(cartPage.getShoppingCart());
	}

	public boolean checkProducts() {
		String qty = getText(cartPage.getCartQty());
		return !qty.contains("(0)");
	}

	public boolean checkTotal() {
		return waitForVisibility(cartPage.getSubtotal()).isDisplayed();
	}

	public void openEmptyCart() {
		HelperClass.getDriver().get("https://demowebshop.tricentis.com/cart");
	}

	public String getEmptyMsg() {
		return getText(cartPage.getEmptyCartMsg());
	}

	public void addOneProduct() {
		openBookPage();
		addCart();
	}

	public void enterCoupon(String code) {
		type(cartPage.getCouponBox(), code);
	}

	public void clickCoupon() {
		click(cartPage.getCouponButton());
	}

	public void enterGift(String code) {
		type(cartPage.getGiftCardBox(), code);
	}

	public void clickGift() {
		click(cartPage.getGiftCardButton());
	}

	public String getMsg() {
		return getText(cartPage.getMessage());
	}
	
	public void updateQuantity(String qty) {
		waitForVisibility(cartPage.getQuantityBox()).clear();
		type(cartPage.getQuantityBox(), qty);
	}

	public void clickUpdateCart() {
		click(cartPage.getUpdateCartButton());
	}

	public boolean checkUpdatedQty(String expectedQty) {
		String actualQuantity =waitForVisibility(cartPage.getQuantityBox()).getAttribute("value");
		return actualQuantity.equals(expectedQty);
		        
	}

	public void removeProduct() {
		click(cartPage.getRemoveCheckBox());
	}

	public boolean checkRemovedProduct() {
		String message = getText(cartPage.getEmptyCartMsg());
		return message.contains("Your Shopping Cart is empty!");
	}
}