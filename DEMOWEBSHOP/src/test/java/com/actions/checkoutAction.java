package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.pages.checkoutPage;

public class checkoutAction extends BaseAction {

    checkoutPage cp;
    
    public checkoutAction(WebDriver driver) {
		super(driver);
		cp = new checkoutPage();
	}

    public void productAddInCart() {
        click(cp.loginLink);
        type(cp.email, "jenny04@gmail.com");
        type(cp.password, "123456");
        click(cp.loginButton);

        System.out.println("Login Successful");

        click(cp.book);
        click(cp.addToCart);
        jsClick(cp.cart);
    }

    public void click_checkBox() {
        jsClick(cp.checkbox);
    }

    public void click_checkout() {
        jsClick(cp.checkoutButton);
    }

    public String checkoutPage() {
        return getText(cp.checkoutText);
    }
}