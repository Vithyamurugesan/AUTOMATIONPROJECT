package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    public WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

  

    @FindBy(xpath = "//a[@class='ico-register']")
    public WebElement registerLink;

    @FindBy(id = "FirstName")
    public WebElement firstNameField;

    @FindBy(id = "LastName")
    public WebElement lastNameField;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    public WebElement registrationSuccessMessage;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;
}