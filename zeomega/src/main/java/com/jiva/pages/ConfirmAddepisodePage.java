package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class ConfirmAddepisodePage extends WebElements {
	
	
	public ConfirmAddepisodePage(WebDriver driver) {
		super(driver);
		
	}
	By addepisodelocator = By.xpath("//*/j-label[contains(text(),'Episode')]");
	By cmlocator = By.xpath("//span[contains(text(),'Case Management')]");
	By membernameloactor = By.xpath("//p[@class='ng-binding']");
	By redirecttoMCVlocator = By.xpath("//button[contains(text(),'Redirect to')]");
	static By memberinfoexpandlocator = By.id("yui-gen506");
	
	public void clickAddepisode() throws InterruptedException
	{
		
		clickUsingJs(addepisodelocator);
		clickUsingJs(cmlocator);
		existingEpisodeAlert();
	}
	public void existingEpisodeAlert() throws InterruptedException
	{
		Thread.sleep(10000);
		alertBox("A similar Episode has been added in the last 24 hrs.");
	}
	public String getmemberfullname()
	{
		return getText(membernameloactor);
		
	}
	
	public void clickRedirecttoMCV()
	{
		clickUsingJs(redirecttoMCVlocator);
		waitforElementPresent(memberinfoexpandlocator);
	}
}
