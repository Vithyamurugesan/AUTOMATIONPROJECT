package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.ProductReviewPage;
import com.utilities.ConfigReader;

public class ProductReviewAction extends BaseAction {
	
	CartAction cart;
	ProductReviewPage ReviewPage;

	public ProductReviewAction(WebDriver driver) {
		super(driver);
		cart = new CartAction(driver);
		ReviewPage = new ProductReviewPage();
	}
	
	public void OpenReview() {
		driver.get(ConfigReader.get("app.url") + "/computing-and-internet");
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
	
	public void reviewTitle(String str) {
		type(ReviewPage.reviewTitle,str);
	}
	
	public void RevieGtext(String str) {
		type(ReviewPage.reviewGText,str);
	}
	
	public void SubmitBtn() {
		click(ReviewPage.submitBTN);
	}
	
	public String getReviewSuccess () {
		return getText(ReviewPage.productReviewSucces);
	}
	
	public String getReviewTitleValidation() {
		return getText(ReviewPage.reviewTitleValidation);
	}
	
	public String getReviewTextValidation() {
		return getText(ReviewPage.reviewTextValidation);
	}

	
	
}
