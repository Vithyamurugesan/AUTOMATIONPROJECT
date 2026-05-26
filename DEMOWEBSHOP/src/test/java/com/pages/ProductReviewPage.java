package com.pages;

import org.openqa.selenium.By;

public class ProductReviewPage {
	
	public By reviewBtn = By.xpath("//div[@class=\"product-review-links\"]/child::a");
	public By reviewText = By.xpath("//div[@class=\"center-2\"]/descendant::div[@class=\"page-title\"]");
	
	public By reviewFailText = By.xpath("//div[@class=\"validation-summary-errors\"]/descendant::li");
	
	public By productReviewSucces = By.xpath("//div[@class=\"page-body\"]/child::div[@class=\"result\"]");
	public By reviewTitle = By.xpath("//div[@class=\"inputs\"]/child::input[@class=\"review-title\"]");
	public By reviewGText = By.xpath("//div[@class=\"inputs\"]/child::textarea[@class=\"review-text\"]");
	public By submitBTN =By.xpath("//div[@class=\"buttons\"]/child::input[@type=\"submit\"]");
	
}
 