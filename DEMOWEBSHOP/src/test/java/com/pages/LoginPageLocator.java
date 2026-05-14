package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocator {

	public WebDriver driver;

	public LoginPageLocator(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".ico-login")
	public WebElement loginLink;

	@FindBy(id = "Email")
	public WebElement Email;

	@FindBy(id = "Password")
	public WebElement password;

	@FindBy(css = "input[value='Log in']")
	public WebElement loginbtn;

	@FindBy(css = ".header-links .account")
	public WebElement useraccountname;

	@FindBy(css = ".ico-logout")
	public WebElement logoutLink;

	@FindBy(linkText = "Forgot password?")
	public WebElement forgotpasswordlink;

	@FindBy(id = "Email")
	public WebElement recoveryemail;

	@FindBy(css = "input[value='Recover']")
	public WebElement recoverbtn;

	@FindBy(css = ".validation-summary-errors")
	public WebElement loginErrorMessage;

	@FindBy(css = ".result")
	public WebElement recoverySuccessMessage;

	@FindBy(css = ".field-validation-error")
	public WebElement validationMessage;

}