package com.pages;

import org.openqa.selenium.By;

public class DownloadPage {
	public static By myaccountLink= By.cssSelector("div[class='column my-account'] a[class='account']");
	public static By downloadProductLink=By.xpath("(//a[@class=\"inactive\"])[3]");
	public static By productcount=By.xpath("//table[@class='data-table']//tbody");
	public static By ProductName=By.xpath("//table[@class='data-table']//tbody//tr/td[3]");

}
