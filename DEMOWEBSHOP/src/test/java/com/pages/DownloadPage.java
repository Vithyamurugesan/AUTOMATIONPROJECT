package com.pages;

import org.openqa.selenium.By;

public class DownloadPage {
	private static By myaccountLink= By.xpath("//div[@class='column my-account']/descendant::a[@class='account']");
	private static By downloadProductLink=By.xpath("(//div[@class='listbox']/descendant::a[@class='inactive'])[3]");
	private static By productcount=By.xpath("//table[@class='data-table']//tbody");
	private static By ProductName=By.xpath("//table[@class='data-table']//tbody//tr/td[3]");

	public static By getMyaccountLink() {
        return myaccountLink;
	}
    public static By getDownloadProductLink() {
        return downloadProductLink;
    }

    public static By getProductcount() {
        return productcount;
    }

    public static By getProductName() {
        return ProductName;
    }
}
