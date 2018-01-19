package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

import com.jiva.utils.WebElements;

public class WorklistsPage extends WebElements{

	public WorklistsPage(WebDriver driver1) {
		super(driver1);
	}
	
	By ccmreferrallocator = By.xpath("//div[contains(text(),'CCM Referral')]");
	By cmepisodelocator = By.xpath("(//a[contains(text(),'CM')])[2]");
	By episodeassignlocator = By.xpath("//label/input[@type='checkbox']");
	By okbuttonlocator = By.xpath("//button[@ng-click='goToEpisodedashboard()']");
	
	
	public void clickCCMreferral()
	{
		clickUsingJs(ccmreferrallocator);
	}
	public void clickCMepisode()
	{
		clickUsingJs(cmepisodelocator);
	}
	public void assigntoself()
	{
		clickUsingJs(episodeassignlocator);
		clickUsingJs(okbuttonlocator);
	}
	
}
