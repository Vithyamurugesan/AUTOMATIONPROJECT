package com.pages;

import org.openqa.selenium.By;

public class CustomerAccountPage {

    public By accountLink = By.xpath("//div[@class='header-links']//a[@class='account']");
    public By firstNameInput = By.id("FirstName");
    public By saveInfoButton = By.name("save-info-button");

}