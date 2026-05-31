package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.actions.AddressAction;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;

public class AddressStepDefinition {

    AddressAction addressAction=new AddressAction(HelperClass.getDriver());

    String filePath="src/test/resources/TestData/Address_TestData.xlsx";

    List<Map<String, String>> testData=ExcelReader.getData(filePath, "Address");

    String savedFirstName;
    String savedLastName;

    @Given("user is on the address page")
    public void user_is_on_the_address_page() {

        WebDriver driver = HelperClass.getDriver();

        driver.get(ConfigReader.get("app.url"));

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(ConfigReader.get("app.username"));
        driver.findElement(By.id("Password")).sendKeys(ConfigReader.get("app.password"));
        driver.findElement(By.cssSelector("input.login-button")).click();
        driver.get(ConfigReader.get("app.url")+"/customer/addresses");
    }

    @When("user clicks on Add new button")
    public void user_clicks_on_add_new_button() {

        addressAction.clickAddNewButton();
    }

    @When("user enters address details from excel {string}")
    public void user_enters_address_details_from_excel(
            String rowNumber) {

        Map<String, String> data =
                testData.get(Integer.parseInt(rowNumber) - 1);

        savedFirstName = data.get("FirstName");
        savedLastName = data.get("LastName");

        addressAction.enterFirstName(data.get("FirstName"));
        addressAction.enterLastName(data.get("LastName"));
        addressAction.enterEmail(data.get("Email"));
        addressAction.enterCompany(data.get("Company"));
        addressAction.selectCountry(data.get("Country"));
        addressAction.selectState(data.get("State"));
        addressAction.enterCity(data.get("City"));
        addressAction.enterAddress1(data.get("Address1"));
        addressAction.enterAddress2(data.get("Address2"));
        addressAction.enterPostalCode(data.get("PostalCode"));
        addressAction.enterPhone(data.get("Phone"));
        addressAction.enterFax(data.get("Fax"));
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {

        addressAction.clickSave();
    }

    @Then("address should be added successfully")
    public void address_should_be_added_successfully() {

        WebDriver driver = HelperClass.getDriver();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL : " + currentUrl);

        Assert.assertTrue(currentUrl.contains("/customer/addresses"));

        List<WebElement> cards = addressAction.getAddressCards();

        boolean found = false;

        for (WebElement card : cards) {

            String text = card.getText();
            System.out.println("Card Text : " + text);

            if (text.contains(savedFirstName)&& text.contains(savedLastName)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }
    
    @Then("address validation should be displayed")
    public void address_validation_should_be_displayed() {

        Assert.assertTrue(HelperClass.getDriver().getCurrentUrl().contains("/customer/addressadd"));

        List<WebElement> validations=addressAction.getValidationMessages();

        Assert.assertFalse(validations.isEmpty());
    }
}