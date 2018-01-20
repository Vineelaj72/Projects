package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.testcases.ZU_60_flow;
import com.jiva.utils.WebElements;

public class Episodeactivitiespage extends WebElements {

	 private static Logger logger = Logger.getLogger(Episodeactivitiespage.class);

	public Episodeactivitiespage(WebDriver driver1) {
		super(driver1);
	}
	
	By wheellocator = By.cssSelector("i.fa.fa-cog.font-size-16px");
	By addinteractionlocator = By.xpath("//span[contains(text(),' Add Interaction ')]");
	By closedactivitieslocator = By.xpath("//a[contains(text(),'Closed Activities')]");
	
	
	
	public boolean verify_OpenActivityRecordVisible(String userProfileName) {
		By activityrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_OpenActivityRecordVisible"+isDisplayed(activityrecordlocator));
		return isDisplayed(activityrecordlocator);
	}
	
	public void clickWheel()
	{
		clickUsingJs(wheellocator);
	}
	public void clickAddInteraction()
	{
		clickUsingJs(addinteractionlocator);
	}
	public void clickClosedActivities()
	{
		clickUsingJs(closedactivitieslocator);
	}
	public boolean verify_ClosedActivityRecordVisible(String userProfileName) {
		By activityrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		return isDisplayed(activityrecordlocator);
	}
	
}