package com.pages;

import org.openqa.selenium.By;

public class ComparePage {

	private By jewelryLink = By.linkText("Jewelry");

	private By addToCompareButton = By.xpath("//input[contains(@value,'Add to compare list')]");

	private By compareProductsLink = By.xpath("//a[contains(text(),'product comparison')]");

	private By removeButton = By.xpath("//input[@value='Update']");

	private By clearListButton = By.linkText("Clear list");

	private By compareProducts = By.xpath("//table[contains(@class,'compare-products')]//td/a");

	private By emptyCompareMessage = By.cssSelector(".page-body");

	public By getJewelryLink() {
		return jewelryLink;
	}

	public By getAddToCompareButton() {
		return addToCompareButton;
	}

	public By getCompareProductsLink() {
		return compareProductsLink;
	}

	public By getRemoveButton() {
		return removeButton;
	}

	public By getClearListButton() {
		return clearListButton;
	}

	public By getCompareProducts() {
		return compareProducts;
	}

	public By getEmptyCompareMessage() {
		return emptyCompareMessage;
	}

	public By getProductLink(String product) {

		return By.xpath("//a[text()='" + product + "']");
	}

	public By getRemoveCheckbox(String product) {

		return By.xpath("//a[text()='" + product + "']/ancestor::tr//input[@name='removefromcompare']");
	}
}