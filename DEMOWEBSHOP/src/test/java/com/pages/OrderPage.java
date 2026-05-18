package com.pages;

import org.openqa.selenium.By;

public class OrderPage {
	
	public static By orderlink=By.xpath("//a[text()='Orders']");
	public static By orders = By.xpath("//div[@class='section order-item']");
	public static By deatilsButton=By.xpath("//input[@value='Details']");
	public static By productname=By.xpath("//td[@class='a-left name']//a");
	public static By Reorder=By.cssSelector("input[value='Re-order']");
	public static By pdf=By.cssSelector(".pdf-order-button");
	public static By productId=By.cssSelector("div[class='order-number'] strong");
    public static By cartproductName=By.cssSelector(".product-name");
}
