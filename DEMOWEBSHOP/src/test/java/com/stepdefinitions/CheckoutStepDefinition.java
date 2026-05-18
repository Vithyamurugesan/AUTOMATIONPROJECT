package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.checkoutAction;
import com.pages.checkoutPage;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDefinition {
	
	checkoutAction AC ;
	
	@Given("user is on the demoWebPage website")
	public void user_is_on_the_demo_web_page_website() {
		 AC= new checkoutAction(HelperClass.getDriver());
		 HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
	}

	@Given("user is login the demo web shop website with minium adding of one product")
	public void user_is_login_the_demo_web_shop_website_with_minium_adding_of_one_product() {
	   AC.productAddInCart();
	}

	@When("the user click the checkbox of terms and conditions")
	public void the_user_click_the_checkbox_of_terms_and_conditions() {
    AC.click_checkBox();
	}

	@When("the user click the checkout button")
	public void the_user_click_the_checkout_button() {
		AC.click_checkout();
	}

	@Then("the user redirect to the checkout page and seen the text of checkout")
	public void the_user_redirect_to_the_checkout_page_and_seen_the_text_of_checkout() {
		String exp="Checkout";
		String act=AC.checkoutPage();
		Assert.assertEquals(act, exp);
		System.out.println("Checkout page displayed");
	}
	

@Given("the user adds at least one product to the cart without logging in")
public void the_user_adds_at_least_one_product_to_the_cart_without_logging_in() {
    AC.addAproductGuest();
}

@Then("the user should be redirected to the login page and see the text Welcome, Please Sign In")
public void the_user_should_be_redirected_to_the_login_page_and_see_the_text_welcome_please_sign_in() {
   String act = AC.ChcikLogin();
	String exp = "Welcome, Please Sign In!";
	Assert.assertEquals(act, exp);
	System.out.println("Guest Login page is succesful");
   
}

@When("the user clicks the Checkout as Guest button")
public void the_user_clicks_the_checkout_as_guest_button() {
	 AC.GuestLogin();    
}

@When("the user clicks the Register button")
public void the_user_clicks_the_register_button() {
    AC.RegisterButton();
}

@Then("the user should redirect to the Register page and seen the text of Register")
public void the_user_should_redirect_to_the_register_page_and_seen_the_text_of_register() {
    AC.registerFill();
}

@When("the user fill all the required information")
public void the_user_fill_all_the_required_information() {
   AC.regsiterPage();
}

@Then("the user seen the text of user registeration is completed")
public void the_user_seen_the_text_of_user_registeration_is_completed() {
    String act = AC.regCompleted();
    String exp = "Your registration completed";
    Assert.assertTrue(act.contains(exp));
    
}

@When("the user click continue button")
public void the_user_click_continue_button() {
    AC.contineButton();
}


@Given("the user is in the checkout page")
public void the_user_is_in_the_checkout_page() {
    

    AC.addAproductGuest();      
    AC.click_checkBox();        // accept terms
    AC.click_checkout();        // click checkout
    AC.GuestLogin();            // checkout as guest

    String act = AC.checkoutPage();
    String exp = "Checkout";

    Assert.assertEquals(act, exp);

    System.out.println("User reached checkout page");
}

@When("the user dill the billing address form with valid credentials")
public void the_user_dill_the_billing_address_form_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String,String>> data=dataTable.asMaps(String.class,String.class);
	
	   String firstname = data.get(0).get("FirstName");
	    String lastname = data.get(0).get("LastName");
	    String email = data.get(0).get("Email");
	    String company = data.get(0).get("Company");
	    String country = data.get(0).get("Country");
	    String state  = data.get(0).get("state");
	    String city = data.get(0).get("City");
	    String address1 = data.get(0).get("Address1");
	    String address2 = data.get(0).get("Address2");
	    String zipcode = data.get(0).get("ZipCode");
	    String phone = data.get(0).get("Phone");
	    String fax = data.get(0).get("Fax number");
	    
	    AC.billingForm(firstname, lastname, email, company, country, state, city, address1, address2, zipcode, phone, fax);
	    
	    
}

@When("the user click the Continue button")
public void the_user_click_the_continue_button() {
   AC.BillContinue();
}

@Then("the user should seen the Shipping Addres form with text of Select a shipping address from your address book or enter a new address.")
public void the_user_should_seen_the_shipping_addres_form_with_text_of_select_a_shipping_address_from_your_address_book_or_enter_a_new_address() {
    String act = AC.shippingText();
    String exp="Select a shipping address from your address book or enter a new address.";
    Assert.assertTrue(act.contains(exp));
    System.out.println("Shipping page is displayed");
}


@When("the user dill the billing address form with invalid credentials of email")
public void the_user_dill_the_billing_address_form_with_invalid_credentials_of_email(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String,String>>data =dataTable.asMaps(String.class,String.class);

	   String firstname = data.get(0).get("FirstName");
	    String lastname = data.get(0).get("LastName");
	    String email = data.get(0).get("Email");
	    String company = data.get(0).get("Company");
	    String country = data.get(0).get("Country");
	    String state  = data.get(0).get("state");
	    String city = data.get(0).get("City");
	    String address1 = data.get(0).get("Address1");
	    String address2 = data.get(0).get("Address2");
	    String zipcode = data.get(0).get("ZipCode");
	    String phone = data.get(0).get("Phone");
	    String fax = data.get(0).get("Fax number");
	    AC.billingForm(firstname, lastname, email, company, country, state, city, address1, address2, zipcode, phone, fax);

}

@Then("the user should see the error message of Wrong email")
public void the_user_should_see_the_error_message_of_wrong_email() {
    String act = AC.billwrong();
    
    String exp = "Wrong email";
    
    Assert.assertEquals(act, exp);
    
}

@Given("the user in the checkout pages of shipping section")
public void the_user_in_the_checkout_pages_of_shipping_section() {

    
    the_user_is_in_the_checkout_page();

    // Fill billing address
    AC.billingForm(
            "jeeva",
            "pranesh",
            "jeeva@gmail.com",
            "expleo",
            "1",
            "0",
            "Salem",
            "sivaji nagar",
            "sivaji bagar",
            "636004",
            "9876543210",
            "1234567890"
    );

    // Move to Shipping Address section
    AC.BillContinue();

    String act = AC.shippingText();
    String exp =
    "Select a shipping address from your address book or enter a new address.";

    Assert.assertTrue(act.contains(exp));

    System.out.println("User reached Shipping Address page");
}
//......................
@When("the user select the Address from the dropdown and select {string}")
public void the_user_select_the_address_from_the_dropdown_and_select(String string) {
	int address = Integer.parseInt(string);
	AC.ShippingAddress(address);
}
	
	


@When("the user click the continue button in shipping section")
public void the_user_click_the_continue_button_in_shipping_section() {
    AC.shippingContinuebutton();
}

@Then("the user move to the Shipping method and seen the text of Ground")
public void the_user_move_to_the_shipping_method_and_seen_the_text_of_ground() {
    String act = AC.shippingMethod();
    String exp="Ground (0.00)";
    Assert.assertEquals(act, exp);
    
}

@When("the user click the checkBox of In-Store Pickup")
public void the_user_click_the_check_box_of_in_store_pickup() {
   AC.shippingCheckbox();
}


@Then("the user move to direct to the Payment method")
public void the_user_move_to_direct_to_the_payment_method() {
    String act = AC.paymentText();
    String exp="Cash On Delivery (COD) (7.00)";
    
    Assert.assertEquals(act, exp);
}


@Given("the user is in the checkout page of payment method section")
public void the_user_is_in_the_checkout_page_of_payment_method_section() {

    the_user_in_the_checkout_pages_of_shipping_section();
    AC.shippingCheckbox();
    AC.shippingContinuebutton();

    
}

@When("the user is click the cash On Delivey in the payment section")
public void the_user_is_click_the_cash_on_delivey_in_the_payment_section() {
    AC.payment_cashon();
}

@When("the user click the continue button of payment section")
public void the_user_click_the_continue_button_of_payment_section() {
    AC.paymentContinue();
}

@Then("the user should redirect to the payment information and seen text you will pay by COD")
public void the_user_should_redirect_to_the_payment_information_and_seen_text_you_will_pay_by_cod() {
    String act = AC.payInfoText();
    String exp = "You will pay by COD";
    Assert.assertEquals(act, exp);
    System.out.println("cashon delivery is applied");
}


@When("the user is click the credit card checkout in the payment section")
public void the_user_is_click_the_credit_card_checkout_in_the_payment_section() {
    AC.ClickCredit();
}

@Then("the user should see the select credit card text")
public void the_user_should_see_the_select_credit_card_text() {
    String act = AC.creditPage();
    String exp ="Select credit card";
    Assert.assertEquals(act, exp);
}

@When("the user fill the credit card infomation")
public void the_user_fill_the_credit_card_infomation(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String,String>>data = dataTable.asMaps(String.class,String.class);
	
	String caedholder = data.get(0).get("cardholder_name");
	String cardNumber = data.get(0).get("card_number");
	String card_code = data.get(0).get("card_code");
	
	AC.fillCredit(caedholder, cardNumber, card_code);
	
	
}

@When("the user click the continue After Select the credit card details")
public void the_user_click_the_continue_after_select_the_credit_card_details() {
    
	AC.Finishcredit();
    
}

@Then("the order conformation page is dispayed and seen the  text of total")
public void the_order_conformation_page_is_dispayed_and_seen_the_text_of_total() {
    String act = AC.conformPageText();
    String exp = "Total:";
    Assert.assertEquals(act, exp);
}



@Given("the user is in the conform page")
public void the_user_is_in_the_conform_page() {
	the_user_is_in_the_checkout_page_of_payment_method_section();
	AC.payment_cashon();
	AC.paymentContinue();
	AC.payInfoContinue();
	
}

@When("the user click the conform button")
public void the_user_click_the_conform_button() {
    AC.conformPageConform();
}

@Then("the user is redirect to the Thankyou page with text Your order has been successfully processed!")
public void the_user_is_redirect_to_the_thankyou_page_with_text_your_order_has_been_successfully_processed() {
    String act = AC.ThankyouText();
    String exp ="Your order has been successfully processed!";
    Assert.assertEquals(act, exp);
    System.out.println("the order is placed succesfull");
	
}









}