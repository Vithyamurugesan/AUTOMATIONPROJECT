package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.ProductReviewPage;

public class ProductReviewAction extends BaseAction {
	
	CartAction cart;
	ProductReviewPage ReviewPage;

	public ProductReviewAction(WebDriver driver) {
		super(driver);
		cart = new CartAction(driver);
		ReviewPage = new ProductReviewPage();
	}
	
	public void OpenReview() {
		cart.openBookPage();
		cart.openComputingBookPage();
	}
	
	public void clickReviewLink() {
		click(ReviewPage.reviewBtn);
	}
	
	public String revieText() {
		return getText(ReviewPage.reviewText);
	}
	public String reviewFailText() {
		return getText(ReviewPage.reviewFailText);
	}
	
	
}
