package com.pages;

import org.openqa.selenium.By;

public class SocialMediaLinkPage {
	
	private By faceBook=By.linkText("Facebook");
	private By twitter=By.linkText("Twitter");
	private By youTube=By.linkText("YouTube");
	private By google=By.linkText("Google+");
	
	
	public By getFaceBook() {
		return faceBook;
	}
	
	public By getTwitter() {
		return twitter;
	}
	
	public By getYouTube() {
		return youTube;
	}
	
	public By getGoogle() {
		return google;
	}
	
	
}
