package com.pages;

import org.openqa.selenium.By;

public class OrderPage {
	
	private static By orderlink=By.xpath("//a[text()='Orders']");
	private static By ordersCount = By.xpath("//div[@class='section order-item']");
	private static By deatilsButton=By.xpath("(//input[@value='Details'])[1]");
	private static By productname=By.xpath("(//td[@class='a-left name']//a)[1]");
	private static By Reorder=By.cssSelector("input[value='Re-order']");
	private static By pdf=By.cssSelector(".pdf-order-button");
	private static By productId=By.cssSelector("div[class='order-number'] strong");
	private static By cartproductName=By.cssSelector(".product-name");
	
    public static By getOrderlink() {
        return orderlink;
    }

    public static By getOrdersCount() {
        return ordersCount;
    }

    public static By getDeatilsButton() {
        return deatilsButton;
    }

    public static By getProductname() {
        return productname;
    }

    public static By getReorder() {
        return Reorder;
    }

    public static By getPdf() {
        return pdf;
    }

    public static By getProductId() {
        return productId;
    }

    public static By getCartproductName() {
        return cartproductName;
    }
}
