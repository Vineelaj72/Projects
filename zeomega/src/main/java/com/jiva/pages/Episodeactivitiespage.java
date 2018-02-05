package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class Episodeactivitiespage extends WebElements {

	 private static Logger logger = Logger.getLogger(Episodeactivitiespage.class);

	public Episodeactivitiespage(WebDriver driver) {
		super(driver);
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
	By modifyactivitylocator = By.xpath("//span[contains(text(),'Modify Activity')]");
	By activitystatusdd = By.xpath("//select[contains(@name,'activitystatus')]");
	
	
	
	public boolean verify_OpenInteractionRecordVisible(String userProfileName) {
		By interactionrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_OpenInteractionRecordVisible "+isDisplayed(interactionrecordlocator));
		return isDisplayed(interactionrecordlocator);
	}
	
	public boolean verify_OpenorClosedInteractionRecordVisible() {
		By interactionrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'CCM Referral')]");
		logger.info("verify_OpenorClosedInteractionRecordVisible "+isDisplayed(interactionrecordlocator));
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
	public void clickModifyActivity()
	{
		clickUsingJs(modifyactivitylocator);
	}
	public void clickClosedActivities()
	{
		clickUsingJs(closedactivitieslocator);
	}
	
	public boolean verify_ClosedInteractionRecordVisible(String userProfileName) {
		By interactionrecordlocator = By.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_ClosedInteractionRecordVisible "+isDisplayed(interactionrecordlocator));
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
		dropdownSelect(activitytypesdd, "Follow-up");
		enterText(activitieslocator,"Review for Contact");
		clickUsingJs(cssselector);
		sleep(5000);
		clickUsingJs(saveactivitylocator);
	}
	
	public boolean verify_OpenActivityRecordVisible(String userProfileName) {
		By activityrecordlocator = By.xpath("//*[contains(text(),'Review for Contact')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_OpenActivityRecordVisible in Open Activities tab "+isDisplayed(activityrecordlocator));
		return isDisplayed(activityrecordlocator);
	}
	
	public void modifyActivityDetails()
	{
		dropdownSelect(activitystatusdd, "Closed");
		clickUsingJs(saveactivitylocator);
	}
	
	public boolean verify_ClosedActivityRecordVisible(String userProfileName) {
		By activityrecordlocator = By.xpath("//*[contains(text(),'Review for Contact')]/..//td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify_ClosedActivityRecordVisible in Closed Activities tab "+isDisplayed(activityrecordlocator));
		return isDisplayed(activityrecordlocator);
	}
	public boolean verifyEpisodeStatus_Closed(String userProfileName) {
		By closedepisoderecordlocator = By.xpath("//span[contains(text(),'Closed')]/../../../../td/div/span/span[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");
		logger.info("verify the status of Episode as Closed "+isDisplayed(closedepisoderecordlocator));
		return isDisplayed(closedepisoderecordlocator);
	}
	public boolean verifyEpisodeStatus() {
		By episodestatuslocator = By.xpath("//span[contains(text(),'Closed')]");
		logger.info("verify the status of Episode as Closed "+isDisplayed(episodestatuslocator));
		return isDisplayed(episodestatuslocator);
	}
	
	
}