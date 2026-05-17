package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage {

	public By loginLink = By.xpath("//a[@class='ico-login']");
	public By email = By.xpath("//input[@id='Email']");
	public By password = By.xpath("//input[@id='Password']");
	public By loginButton = By.xpath("//input[@value='Log in']");
	public By book = By.xpath("//h2[@class='product-title']//a");

	public By addToCart = By.xpath("//input[@value='Add to cart']");
	public By cart = By.xpath("//span[normalize-space()='Shopping cart']");

	public By checkbox = By.xpath("//input[@id='termsofservice']");
	public By checkoutButton = By.xpath("//button[@id='checkout']");

	public By checkoutText = By.xpath("//h1[normalize-space()='Checkout']");

}