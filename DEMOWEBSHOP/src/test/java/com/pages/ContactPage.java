package com.pages;

import org.openqa.selenium.By;

public class ContactPage {

	private static By contactLink =By.xpath("//div[@class='column information']/child::ul/li/a[text()='Contact us']");
	private static By emailField = By.id("Email");
	private static By nameField = By.id("FullName");

	public static By getContactLink() {
		return contactLink;
	}

	public static By getEmailField() {
		return emailField;
	}

	public static By getNameField() {
		return nameField;
	}

}