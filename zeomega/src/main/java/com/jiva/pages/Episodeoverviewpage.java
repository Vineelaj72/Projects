package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.testcases.ZU_60_flow;
import com.jiva.utils.WebElements;

public class Episodeoverviewpage extends WebElements{

	 private static Logger logger = Logger.getLogger(Episodeoverviewpage.class);

	public Episodeoverviewpage(WebDriver driver1) {
		super(driver1);
	}
	
	By activitiesopenlocator = By.xpath("//button[contains(@ng-click,'routeActivityDataListing()')]");
	By activitynamelocator = By.xpath("//span[contains(text(),'Verbal consent to be received')]");
	By workflowlocator = By.xpath("//button[contains(text(),'Workflow')]");
	By activitieslinklocator = By.xpath("//a/span[contains(text(),'Activities')]");
	
	
	public void openActivities()
	{
		clickUsingJs(activitiesopenlocator);
	}
	public String verifyactivityAdded()
	{
		return getText(activitynamelocator);
		
	}
	public boolean verify_UTCLetterGenerated(String userProfileName) {
		By correspondencerecordlocator = By.xpath("//span[contains(text(),'CM Unable To Reach')]/../../td/span[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_OpenActivityRecordVisible"+isDisplayed(correspondencerecordlocator));
		return isDisplayed(correspondencerecordlocator);
	}
	public void clickWorkflow()
	{
		clickUsingJs(workflowlocator);
	}
	public void clickActivities()
	{
		clickUsingJs(activitieslinklocator);
	}
}
