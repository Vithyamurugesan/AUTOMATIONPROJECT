package com.actions;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pages.checkoutPage;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;

//ActionClass method => actionClick


public class checkoutAction extends BaseAction {

    checkoutPage cp;

    Actions ac;
    CartAction cart;
    LoginAction login;
    Logger log = LogManager.getLogger(checkoutAction.class);
    
    //actionClass
    public void actionClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ac.moveToElement(element).click().perform();
    }
    public void clear(By locator) {
   	 waitForVisibility(locator).clear();
   }

    //constructor
    public checkoutAction(WebDriver driver) {
		super(driver);
		cp = new checkoutPage();
		cart= new CartAction(driver);
		login = new LoginAction(driver);
		ac = new Actions(driver);
		log.info("browser open");
	}

    public void productAddInCart() {

        try {
        	waitForVisibility(cp.loginLink);
            login.clicklogin();
            login.userEmail(ConfigReader.getProperty("app.username"));
            login.userPassword(ConfigReader.getProperty("app.password"));
            login.clickloginbtn();
            log.info("login successful");

            waitForVisibility(cp.book);

            click(cp.book);
            cart.addCart();
            cart.checkCart();

            log.info("product add in cart");        
        }

        catch(Exception e){

            log.error("product add fail",e);
            throw e;
        }
    }
    
    public void click_checkBox() {
        actionClick(cp.checkbox);
    }

    public void click_checkout() {
        actionClick(cp.checkoutButton);
    }

    public String checkoutPage() {
        return getText(cp.checkoutText);
    }

   


    public void addAproductGuest() {
    	try {
    		cart.openBookPage();
            cart.addCart();
            cart.checkCart();
		

		log.info("guest product add");
    	}
    	catch(Exception e) {
    		log.error("guest add fail",e);
    		throw e;
    	}
	}
    

    public void GuestLogin() {
    	try {
    	click(cp.GuestButton);

    	log.info("guest login selected");
    	}
    	catch(Exception e) {
    		log.error("guest login fail",e);
    		throw e;
    	}
    }

    public String ChcikLogin() {
    	return getText(cp.loginPageReDirect);
    }

    public void RegisterButton() {
    	try {
    	click(cp.RegisterButton);
    	log.info("register button click");
    	}
    	catch(Exception e) {
    		log.error("register fail",e);
    		throw e;
    	}
    }

    public void registerFill() {

    	try {

    	String mail = "jeeva" + System.currentTimeMillis() + "@gmail.com";

    	click(cp.gender);
    	type(cp.firestName,"jeeva");
    	type(cp.lastName,"pranesh");
    	type(cp.email,mail);
    	type(cp.Regpassword,"Kiot123");
    	type(cp.conformPassword,"Kiot123");
    	click(cp.regButton);

    	log.info("registration completed");
    	}
    	catch(Exception e) {
    		log.error("registration fail",e);
    		throw e;
    	}
    }

    public String regsiterPage() {
    	waitForVisibility(cp.RegisterPage);
    	return getText(cp.RegisterPage);
    }

    public void contineButton() {
    	try {
    	click(cp.continueButton);
    	log.info("continue clicked");
    	}
    	catch(Exception e) {
    		log.error("continue fail",e);
    		throw e;
    	}
    }

    public String regCompleted() {
    	return getText(cp.regCompleted);
    }

    public void billingForm(String str1,String str2,String str3,String str4,String str5,String str7,String str8,String str9,String str10,String str11,String str12) {

    	try {
    		
    		Select dropdown1 = new Select(waitForVisibility(cp.existAddress));
    		dropdown1.selectByVisibleText("New Address");

    		clear(cp.billFirstName);
    		type(cp.billFirstName,str1);
    		clear(cp.billLastName);
            type(cp.billLastName,str2);
            clear(cp.billEmail);
            type(cp.billEmail,str3); 
    	type(cp.billCompany, str4);

    	Select dropdown = new Select(waitForVisibility(cp.billCountry));
    	dropdown.selectByValue(str5);

	type(cp.billCity,str7);
	type(cp.billAddress1,str8);
    	type(cp.billAddress2,str9);
    	type(cp.billZip, str10);
    	type(cp.billNumber,str11);
    	type(cp.billFax, str12);

    	log.info("billing fill completed");
    	}
    	catch(Exception e) {
    		log.error("billing fail",e);
    		throw e;
    	}
    }

	public void BillContinue() {
		try {
		click(cp.billContinue);

		log.info("billing continue click");
		}
		catch(Exception e) {
			log.error("billing continue fail",e);
			throw e;
		}
	}

	public String shippingText() {
		return getText(cp.shippingText);
	}

	public String  billwrong() {
		return getText(cp.wrongEmail);
	}

public void ShippingAddress() {

	try {

		Select dropdown = new Select(waitForVisibility(cp.ShippingDrop));
		dropdown.selectByIndex(1);

		log.info("shipping address selected");
		}
		catch(Exception e) {
			log.error("shipping fail",e);
			throw e;
		}
	}

	public void shippingContinuebutton(){

		try {

		click(cp.shippingContinue);
		log.info("shipping continue click");
		}
		catch(Exception e) {
			log.error("shipping continue fail",e);
			throw e;
		}
	}

	public String shippingMethod() {
		return getText(cp.ShippingMethodtext);
	}

	public void shippingCheckbox() {
		actionClick(cp.shippingcheckbox);
	}

	public String paymentText() {
		waitForVisibility(cp.paymentext);
		return getText(cp.paymentext);
	}

	public void payment_cashon() {

		try {

		actionClick(cp.cashOnMethod);
		log.info("cash on delivery selected");
		}
		catch(Exception e) {
			log.error("payment fail",e);
			throw e;
		}
	}

	public void paymentContinue() {

		try {
		click(cp.paymentMethodcontinue);
		log.info("payment continue click");
		}
		catch(Exception e) {
			log.error("payment continue fail",e);
			throw e;
		}
	}

	public String payInfoText () {
		return getText(cp.paymentInfoText);
	}

	public void ClickCredit() {

		try {

		click(cp.ClickcreditCart);
		log.info("credit selected");
		}
		catch(Exception e) {
			log.error("credit fail",e);
			throw e;
		}
	}

	public String creditPage() {
		return getText(cp.creditPage);
	}

	public void fillCredit(String str,String str2,String str3) {

		try {
		type(cp.cardholdername,str);
		type(cp.cardNumber,str2);
		type(cp.cardCode,str3);

		log.info("credit details filled");
		}
		catch(Exception e) {
			log.error("credit details fail",e);
			throw e;
		}
	}

	public void Finishcredit() {
		click(cp.continueFinish);
	}

	public String conformPageText() {
		return getText(cp.conformOrderPage);
	}

	public void conformPageConform() {

		try {

		click(cp.conformPage_conform);

		log.info("confirm order click");
		}
		catch(Exception e) {
			log.error("confirm fail",e);
			throw e;
		}
	}

	public void payInfoContinue() {

		try {

		click(cp.payInfoContinue);

		log.info("payment info continue");
		}
		catch(Exception e) {
			log.error("payment info fail",e);
			throw e;
		}
	}

	public String ThankyouText() {
		 waitForVisibility(cp.ThankyText);
		return getText(cp.ThankyText);
	}
	
	public void fillBillingFromExcel(String sheet) {

	    List<Map<String,String>> data = ExcelReader.getData( "src\\test\\resources\\TestData\\BillingForm.xlsx",sheet);

	    billingForm(
	    data.get(0).get("First Name"),
	    data.get(0).get("LastName"),
	    data.get(0).get("Email"),
	    data.get(0).get("Company"),
	    data.get(0).get("Country"),
	    data.get(0).get("City"),
	    data.get(0).get("Address1"),
	    data.get(0).get("Address2"),
	    data.get(0).get("ZipCode"),
	    data.get(0).get("Phone"),
	    data.get(0).get("Fax number"));
	}
	
}