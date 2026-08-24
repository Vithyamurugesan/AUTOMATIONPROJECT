package com.stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.AddressAction;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;

public class AddressStepDefinition {

    AddressAction addressAction = new AddressAction(HelperClass.getDriver());

    String filePath = "src/test/resources/TestData/Address_TestData.xlsx";

    List<Map<String, String>> testData = ExcelReader.getData(filePath, "Address");

    String savedFirstName;
    String savedLastName;

    @Given("user is on the address page")
    public void user_is_on_the_address_page() {

        WebDriver driver = HelperClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(ConfigReader.get("app.url"));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Log in"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("Email"))).clear();

        driver.findElement(By.id("Email"))
                .sendKeys(ConfigReader.get("app.username"));

        driver.findElement(By.id("Password")).clear();

        driver.findElement(By.id("Password"))
                .sendKeys(ConfigReader.get("app.password"));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input.login-button"))).click();

        boolean loginSuccessful = isLoginSuccessful(driver, wait);

        if (!loginSuccessful) {

            String currentUrl = driver.getCurrentUrl();
            String pageTitle = driver.getTitle();
            String pageText = driver.findElement(By.tagName("body")).getText();

            Assert.fail(
                    "Login failed.\n"
                    + "URL: " + currentUrl + "\n"
                    + "Title: " + pageTitle + "\n"
                    + "Username: " + ConfigReader.get("app.username") + "\n"
                    + "The 'Log out' link was not found after login.\n"
                    + "Page message:\n"
                    + pageText.substring(0, Math.min(pageText.length(), 1000))
            );
        }

        driver.get(ConfigReader.get("app.url") + "/customer/addresses");

        wait.until(ExpectedConditions.urlContains("/customer/addresses"));

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.button-1.add-address-button")));
    }

    private boolean isLoginSuccessful(WebDriver driver, WebDriverWait wait) {

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.linkText("Log out")));

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @When("user clicks on Add new button")
    public void user_clicks_on_add_new_button() {
        addressAction.clickAddNewButton();
    }

    @When("user enters address details from excel {string}")
    public void user_enters_address_details_from_excel(String rowNumber) {

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

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );

        wait.until(ExpectedConditions.urlContains(
                "/customer/addresses"
        ));

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL : " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("/customer/addresses"),
                "User is not on the customer addresses page."
        );

        List<WebElement> cards = addressAction.getAddressCards();

        boolean found = false;

        for (WebElement card : cards) {

            String text = card.getText();

            System.out.println("Card Text : " + text);

            if (text.contains(savedFirstName)
                    && text.contains(savedLastName)) {

                found = true;
                break;
            }
        }

        Assert.assertTrue(
                found,
                "Saved address was not found for: "
                + savedFirstName + " "
                + savedLastName
        );
    }

    @Then("address validation should be displayed")
    public void address_validation_should_be_displayed() {

        WebDriver driver = HelperClass.getDriver();

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );

        wait.until(ExpectedConditions.urlContains(
                "/customer/addressadd"
        ));

        List<WebElement> validations =
                addressAction.getValidationMessages();

        Assert.assertFalse(
                validations.isEmpty(),
                "Expected address validation messages, but none were displayed."
        );
    }
}