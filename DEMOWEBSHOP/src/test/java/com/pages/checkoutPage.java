package com.pages;

import java.time.Duration ;

import org.openqa.selenium.By;
//pages

public class checkoutPage {

	
	public By loginLink = By.xpath("//a[@class='ico-login']");
	public By email = By.xpath("//input[@id='Email']");
	public By password = By.xpath("//input[@id='Password']");
	public By loginButton = By.xpath("//input[@value='Log in']");
	public By book = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']");

	public By addToCart =
			By.xpath("(//input[@value='Add to cart'])[1]");
	public By cart = By.xpath("//a[@class='ico-cart']");
	public By checkbox = By.xpath("//input[@id='termsofservice']");
	public By checkoutButton = By.xpath("//button[@id='checkout']");

	public By checkoutText = By.xpath("//h1[normalize-space()='Checkout']");
	
	public By GuestButton =By.xpath("//input[@value='Checkout as Guest']");
	public By loginPageReDirect =By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");
	
	//scenario 3
	public By RegisterButton = By.xpath("//input[@value='Register']");
	public By RegisterPage= By.xpath("//h1[normalize-space()='Register']");
	public By gender = By.xpath("//input[@id='gender-male']");
	public By firestName =By.xpath("//input[@id='FirstName']");
	public By lastName = By.xpath("//input[@id='LastName']");
	public By Email = By.xpath("//input[@id='Email']");
	public By Regpassword = By.xpath("//input[@id='Password']");
	public By conformPassword = By.xpath("//input[@id='ConfirmPassword']");
	public By regButton = By.xpath("//input[@id='register-button']");
	public By regCompleted = By.xpath("//div[@class='result']");
	public By continueButton = By.xpath("//input[@value='Continue']");
	
	//scenario-4
	public By existAddress= By.xpath("//select[@id='billing-address-select']");
	
	public By billFirstName= By.xpath("//input[@id='BillingNewAddress_FirstName']");
	public By billLastName = By.xpath("//input[@id='BillingNewAddress_LastName']");
	public By billEmail = By.xpath("//input[@id='BillingNewAddress_Email']");
	public By billCompany = By.xpath("//input[@id='BillingNewAddress_Company']");
	public By billCountry= By.xpath("//select[@id='BillingNewAddress_CountryId']");
	public By billstate = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']");
	public By billCity = By.xpath("//input[@id='BillingNewAddress_City']");
	public By billAddress1= By.xpath("//input[@id='BillingNewAddress_Address1']");
	public By billAddress2 =By.xpath("//input[@id='BillingNewAddress_Address2']");
	public By billZip = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	public By billNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	public By billFax = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
	public By billContinue = By.xpath("//input[@onclick='Billing.save()']");
	
	public By shippingText = By.xpath("//label[@for='shipping-address-select']");
	
	public By wrongEmail =By.xpath("//span[@class='field-validation-error']");
	
	
	//scenario -5
	public By ShippingDrop= By.xpath("//select[@id='shipping-address-select']");
	public By shippingContinue =By.xpath("//input[@onclick='Shipping.save()']");
	public By ShippingMethodtext = By.xpath("//label[normalize-space()='Ground (0.00)']");
	public By addSuccess = By.xpath("//p[contains(text(),'The product has been added to your shopping cart')]");
	
	//scenario-6
	public By shippingcheckbox = By.xpath("//input[@id='PickUpInStore']");
	public By paymentext = By.xpath("//label[normalize-space()='Cash On Delivery (COD) (7.00)']");
	
	
	//scenario-8
	public By cashOnMethod = By.xpath("//input[@id='paymentmethod_0']");
	public By paymentMethodcontinue = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
												
	public By paymentInfoText =By.xpath("//p[normalize-space()='You will pay by COD']");
	
	//scenario-9
	public By ClickcreditCart = By.xpath("//input[@id='paymentmethod_2']");
	public By creditPage =By.xpath("//label[normalize-space()='Select credit card']");
	public By cardholdername = By.xpath("//input[@id='CardholderName']");
	public By cardNumber = By.xpath("//input[@id='CardNumber']");
	public By cardCode = By.xpath("//input[@id='CardCode']");
	
	public By continueFinish = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	public By conformOrderPage = By.xpath("//span[@class='nobr'][normalize-space()='Total:']");
	public By payInfoContinue = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	
	//scenario
	public By conformPage_conform = By.xpath("//input[@value='Confirm']");
	public By ThankyText =By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
	
	//scenario-10
	
}