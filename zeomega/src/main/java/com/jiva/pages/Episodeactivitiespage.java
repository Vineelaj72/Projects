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
	By cmlocator = By.xpath("//a[contains(text(),'CM')]");
	By addactivitylocator = By.xpath("//button[contains(text(),'Add Activity')]");
	By activitieslocator = By.xpath("//textarea[contains(@name,'activities')]");
	By activitytypesdd = By.xpath("//select[contains(@name,'activitytypes')]");
	By saveactivitylocator = By.xpath("(//button[contains(text(),'Save')])[1]");
	By cssselector = By.cssSelector("strong");
	
	
	public boolean verify_OpenInteractionRecordVisible(String userProfileName) {
		By interactionrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_OpenInteractionRecordVisible "+isDisplayed(interactionrecordlocator));
		return isDisplayed(interactionrecordlocator);
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
	public boolean verify_ClosedInteractionRecordVisible(String userProfileName) {
		By interactionrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		return isDisplayed(interactionrecordlocator);
	}
	public void clickCM()
	{
		clickUsingJs(cmlocator);
	}
	public void clickAddActivity()
	{
		clickUsingJs(addactivitylocator);
	}
	public void enterActivityDetails() throws InterruptedException
	{
		enterText(activitieslocator,"Review for Contact");
		clickUsingJs(cssselector);
		wait(5000);
		dropdownSelect(activitytypesdd, "Follow-up");
		clickUsingJs(saveactivitylocator);
	}
	
	public boolean verify_ActivityRecordVisible(String userProfileName) {
		By activityrecordlocator = By.xpath("//*[contains(text(),'Review for Contact')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_ActivityRecordVisible in OpenActivities tab"+isDisplayed(activityrecordlocator));
		return isDisplayed(activityrecordlocator);
	}
}