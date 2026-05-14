package com.actions;

import com.pages.RegisterPage;
import com.utilities.ConfigReader;

import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterAction {

    WebDriver driver;
    RegisterPage registerPage;

    public RegisterAction(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(driver);
    }

    private String generateUniqueEmail() {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        return "vithya_" + timestamp + "@testmail.com";
    }

  
    public void navigateToRegisterPage() {
        registerPage.clickRegisterLink();
    }

  
    public void enterFirstName(String firstName) {
        registerPage.enterFirstName(firstName);
    }

  
    public void enterLastName(String lastName) {
        registerPage.enterLastName(lastName);
    }

   
    public void enterEmail(String email) {
        registerPage.enterEmail(email);
    }

   
    public void enterUniqueEmail() {
        String uniqueEmail = generateUniqueEmail();
        System.out.println("Generated unique email: " + uniqueEmail);
        registerPage.enterEmail(uniqueEmail);
    }

   
    public void enterPassword(String password) {
        registerPage.enterPassword(password);
    }

    
    public void enterConfirmPassword(String confirmPassword) {
        registerPage.enterConfirmPassword(confirmPassword);
    }

   
    public void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }

   
    public void enterValidRegistrationDetailsFromConfig() {
        enterFirstName(ConfigReader.get("register.valid.firstName"));
        enterLastName(ConfigReader.get("register.valid.lastName"));
        enterUniqueEmail();                                               
        enterPassword(ConfigReader.get("register.valid.password"));
        enterConfirmPassword(ConfigReader.get("register.valid.confirmPassword"));
    }

   
    public void enterExistingEmailRegistrationFromConfig() {
        enterFirstName(ConfigReader.get("register.existing.firstName"));
        enterLastName(ConfigReader.get("register.existing.lastName"));
        enterEmail(ConfigReader.get("register.existing.email"));          // fixed existing email
        enterPassword(ConfigReader.get("register.existing.password"));
        enterConfirmPassword(ConfigReader.get("register.existing.confirmPassword"));
    }

    
    public boolean isRegistrationSuccessful() {
        return registerPage.isSuccessMessageDisplayed();
    }

   
    public String getSuccessMessage() {
        return registerPage.getRegistrationSuccessMessage();
    }

    
    public boolean isExistingEmailErrorDisplayed() {
        return registerPage.isExistingEmailErrorDisplayed();
    }

   
    public String getExistingEmailErrorMessage() {
        return registerPage.getExistingEmailError();
    }

    
    public String getExpectedSuccessMessage() {
        return ConfigReader.get("register.success.message");
    }

    
    public String getExpectedExistingEmailKeyword() {
        return ConfigReader.get("register.existing.error.keyword");
    }
}