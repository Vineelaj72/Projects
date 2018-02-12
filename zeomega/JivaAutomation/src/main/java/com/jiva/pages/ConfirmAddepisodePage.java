package com.jiva.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.WebElements;

public class ConfirmAddepisodePage extends WebElements {
	
	private WebDriver driver;

	public ConfirmAddepisodePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By addepisodelocator = By.xpath("//*/j-label[contains(text(),'Episode')]");
	By cmlocator = By.xpath("//span[contains(text(),'Case Management')]");
	By membernameloactor = By.xpath("//p[@class='ng-binding']");
	By redirecttoMCVlocator = By.xpath("//button[contains(text(),'Redirect to')]");

	public void clickAddEpisode() {
		driver.findElement(addepisodelocator).click();
	}

	public void clickAddCaseManagement() {
		driver.findElement(cmlocator).click();
	}

	public void clickAddepisode() throws InterruptedException
	{
		
		clickUsingJs(addepisodelocator);
		clickUsingJs(cmlocator);
		existingEpisodeAlert();
	}
	public void existingEpisodeAlert()
	{
		sleep(10000);
		alertBox("A similar Episode has been added in the last 24 hrs.");
	}
	public String getmemberfullname()
	{
		return getText(membernameloactor);
		
	}
	
	public void clickRedirecttoMCV()
	{
		clickUsingJs(redirecttoMCVlocator);
	}
}
