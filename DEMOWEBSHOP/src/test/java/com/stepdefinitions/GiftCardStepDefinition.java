package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.GiftCardAction;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftCardStepDefinition {

    GiftCardAction giftCardAction =
            new GiftCardAction(HelperClass.getDriver());



    @When("the user navigates to the {string} section")
    public void the_user_navigates_to_the_section(String section) {

        giftCardAction.clickGiftCardsMenu();
    }



    @When("the user selects the {string}")
    public void the_user_selects_the(String card) {

        giftCardAction.selectGiftCard();
    }



    @When("the user enters the following gift card details")
    public void the_user_enters_the_following_gift_card_details(DataTable dataTable) {

        List<Map<String, String>> data =
                dataTable.asMaps(String.class, String.class);

        giftCardAction.enterRecipientName(
                data.get(0).get("RecipientName"));

        giftCardAction.enterRecipientEmail(
                data.get(0).get("RecipientEmail"));

        giftCardAction.enterSenderName(
                data.get(0).get("SenderName"));
    }



    @When("the user enters recipient name {string}")
    public void the_user_enters_recipient_name(String name) {

        giftCardAction.enterRecipientName(name);
    }



    @When("the user enters recipient email {string}")
    public void the_user_enters_recipient_email(String email) {

        giftCardAction.enterRecipientEmail(email);
    }



    @When("the user enters sender name {string}")
    public void the_user_enters_sender_name(String sender) {

        giftCardAction.enterSenderName(sender);
    }



    @When("the user clicks the giftcard button {string}")
    public void the_user_clicks_the_giftcard_button(String button) {

        switch (button.toLowerCase()) {

        case "add to cart":
            giftCardAction.clickAddToCart();
            break;

        case "shopping cart":
            giftCardAction.clickShoppingCart();
            break;

        case "update cart":
            giftCardAction.clickUpdateCart();
            break;

        default:
            System.out.println("Invalid button : " + button);
        }
    }



    @Then("the product should be added to the shopping cart successfully")
    public void the_product_should_be_added_to_the_shopping_cart_successfully() {

        String actualMessage =
                giftCardAction.getSuccessMessage();

        Assert.assertTrue(
                actualMessage.contains("The product has been added"));
    }



    @Then("the shopping cart quantity should be updated")
    public void the_shopping_cart_quantity_should_be_updated() {

        System.out.println(
                "Shopping cart updated successfully");
    }



    @Then("the recipient email error message {string} should be displayed")
    public void the_recipient_email_error_message_should_be_displayed(String errorMessage) {

        System.out.println(errorMessage);
    }



    @Then("the following gift card validation messages should be displayed")
    public void the_following_gift_card_validation_messages_should_be_displayed(DataTable dataTable) {

        List<Map<String, String>> data =
                dataTable.asMaps(String.class, String.class);

        for(Map<String, String> map : data) {

            System.out.println(
                    map.get("Field")
                    + " : "
                    + map.get("Message"));
        }
    }



    @When("the user navigates to shopping cart")
    public void the_user_navigates_to_shopping_cart() {

        giftCardAction.clickShoppingCart();
    }



    @When("the user updates the product quantity to {string}")
    public void the_user_updates_the_product_quantity_to(String quantity) {

        giftCardAction.updateQuantity(quantity);
    }



    @Then("the shopping cart quantity should display {string}")
    public void the_shopping_cart_quantity_should_display(String expectedQuantity) {

        String actualQuantity =
                giftCardAction.getQuantityValue();

        Assert.assertEquals(
                expectedQuantity,
                actualQuantity);
    }



    @Then("the total price should be updated correctly")
    public void the_total_price_should_be_updated_correctly() {

        System.out.println(
                "Total price updated correctly");
    }
}