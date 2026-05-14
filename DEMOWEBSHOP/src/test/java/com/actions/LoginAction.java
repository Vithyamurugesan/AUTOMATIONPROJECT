package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPageLocator;

public class LoginAction {

	WebDriver driver;

	LoginPageLocator login;

	public LoginAction(WebDriver driver) {

		this.driver = driver;

		login = new LoginPageLocator(driver);
	}

	public void clicklogin() {

		login.loginLink.click();
	}

	public void userEmail(String userEmail) {

		login.Email.clear();

		login.Email.sendKeys(userEmail);
	}

	public void userPassword(String userPassword) {

		login.password.clear();

		login.password.sendKeys(userPassword);
	}

	public void clickloginbtn() {

		login.loginbtn.click();
	}

	public void waitforhomepage(WebDriverWait wait) {

		wait.until(ExpectedConditions.visibilityOf(login.useraccountname));
	}

	public String loggedUser() {

		return login.useraccountname.getText();
	}

	public boolean logout() {

		return login.logoutLink.isDisplayed();
	}

	public void forgotpasswordclick() {

		login.forgotpasswordlink.click();
	}

	public void recoveryEmail(String email) {

		login.recoveryemail.clear();

		login.recoveryemail.sendKeys(email);
	}

	public void recoverbutton() {

		login.recoverbtn.click();
	}

	public String getLoginErrorMessage() {

		return login.loginErrorMessage.getText();
	}

	public String getRecoverySuccessMessage() {

		return login.recoverySuccessMessage.getText();
	}

	public String getValidationMessage() {

		return login.validationMessage.getText();
	}
}