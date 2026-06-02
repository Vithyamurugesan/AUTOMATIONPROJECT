package com.actions;

import org.openqa.selenium.WebDriver;

import com.utilities.HelperClass;

public class SocialMediaLinkAction extends BaseAction{

	public SocialMediaLinkAction(WebDriver driver) {
		super(driver);
	}
	
	public boolean clickMedia(String media) {
		
		String parentWindow=HelperClass.getDriver().getWindowHandle();
		
		clickLink(media);
		
		switchToNewWindow(parentWindow);
		
		boolean isNavigatedToDestination=false;
		
		if(driver.getCurrentUrl().toLowerCase().contains("nopcommerce")) {
			isNavigatedToDestination=true;
		}
		
		switchToWindow(parentWindow);
		
		return isNavigatedToDestination;
	}

}
