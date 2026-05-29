package com.pages;

import org.openqa.selenium.By;

public class ComparePage {

	private By jewelryLink = By.linkText("Jewelry");

	private By addToCompareButton = By.xpath("//input[contains(@value,'Add to compare list')]");

	private By clearListButton = By.linkText("Clear list");

	private By compareProducts = By.xpath("//table[contains(@class,'compare-products')]//a");

	private By emptyCompareMessage = By.cssSelector(".page-body");

	private By firstRemoveButton = By.xpath("(//tr[@class='overview']//input[@value='Remove'])[1]");

	private By secondRemoveButton = By.xpath("(//tr[@class='overview']//input[@value='Remove'])[2]");

	public By getJewelryLink() {
		return jewelryLink;
	}

	public By getAddToCompareButton() {
		return addToCompareButton;
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

	public By getFirstRemoveButton() {
		return firstRemoveButton;
	}

	public By getSecondRemoveButton() {
		return secondRemoveButton;
	}

	public By getProductLink(String product) {
		return By.xpath("//a[text()='" + product + "']");
	}
}