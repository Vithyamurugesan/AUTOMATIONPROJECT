package com.pages;

import org.openqa.selenium.By;

public class GiftCardPage {

    public static By giftCardsMenu =
            By.linkText("Gift Cards");

    public static By virtualGiftCard =
            By.linkText("$5 Virtual Gift Card");

    public static By recipientName =
            By.id("giftcard_1_RecipientName");

    public static By recipientEmail =
            By.id("giftcard_1_RecipientEmail");

    public static By senderName =
            By.id("giftcard_1_SenderName");

    public static By addToCartButton =
            By.id("add-to-cart-button-1");

    public By successMessage =
            By.xpath("//p[contains(text(),'The product has been added')]");

    public static By shoppingCartLink =
            By.linkText("Shopping cart");

    public static By quantityBox =
            By.cssSelector("input.qty-input");

    public static By updateCartButton =
            By.name("updatecart");
}