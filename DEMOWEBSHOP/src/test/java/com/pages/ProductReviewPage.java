package com.pages;

import org.openqa.selenium.By;

public class ProductReviewPage {
	
	public By reviewBtn = By.xpath("//div[@class=\"product-review-links\"]/child::a");
	public By reviewText = By.xpath("//div[@class=\"center-2\"]/descendant::div[@class=\"page-title\"]");
	
	public By reviewFailText = By.xpath("//div[@class=\"validation-summary-errors\"]/descendant::li");
	

}
 