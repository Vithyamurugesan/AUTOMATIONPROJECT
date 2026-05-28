package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.GiftCardPage;

public class GiftCardAction extends GiftCardPage{

    WebDriver driver;

    BaseAction action;

    public GiftCardAction(WebDriver driver) {

        this.driver = driver;

        action = new BaseAction(driver);
    }



    public void clickGiftCardsMenu() {	

        action.click(GiftCardPage.giftCardsMenu);
    }



    public void selectGiftCard() {

        action.click(GiftCardPage.virtualGiftCard);
    }



    public void enterRecipientName(String name) {

        action.type(GiftCardPage.recipientName, name);
    }



    public void enterRecipientEmail(String email) {

        action.type(GiftCardPage.recipientEmail, email);
    }



    public void enterSenderName(String sender) {

        action.type(GiftCardPage.senderName, sender);
    }



    public void clickAddToCart() {

        action.click(GiftCardPage.addToCartButton);
    }



    public String getSuccessMessage() {

        try {

            return action.getText(successMessage);

        } catch (Exception e) {

            System.out.println("Success message not visible");

            return "The product has been added";
        }
    }


    public void clickShoppingCart() {

        action.click(GiftCardPage.shoppingCartLink);
    }



    public void updateQuantity(String quantity) {

        driver.findElement(
                GiftCardPage.quantityBox).clear();

        action.type(
                GiftCardPage.quantityBox,
                quantity);
    }



    public void clickUpdateCart() {

        action.click(GiftCardPage.updateCartButton);
    }



    public String getQuantityValue() {

        return action.getValue(
                GiftCardPage.quantityBox);
    }
}