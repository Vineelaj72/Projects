package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class Episodeoverviewpage extends WebElements {

	private static Logger logger = Logger.getLogger(Episodeoverviewpage.class);

	public Episodeoverviewpage(WebDriver driver) {
		super(driver);
	}

	By activitiesopenlocator = By.xpath("//button[contains(@ng-click,'routeActivityDataListing()')]");
	By activitynamelocator = By.xpath("//span[contains(text(),'Verbal consent to be received')]");
	By correspondenceopenlocator = By.xpath("//button[contains(@ng-click,'routeCorrespondenceDataListing()')]");
	By workflowlocator = By.xpath("//button[contains(text(),'Workflow')]");
	By activitieslinklocator = By.xpath("//a/span[contains(text(),'Activities')]");
	By changestatuslinklocator = By.xpath("//a/span[contains(text(),'Change Status')]");
	By programslinklocator = By.xpath("//a/span[contains(text(),'Programs')]");
	By assessmentslinklocator = By.xpath("//a/span[contains(text(),'Assessments')]");
	By hamburgerlocator = By.xpath("//button[contains(@ng-click,'openSubLinksPopOverDialog')]");
	By correspondencelinklocator = By.xpath("//a/span[contains(text(),'Correspondence')]");

	public void openActivities() {
		clickUsingJs(activitiesopenlocator);
	}

	public String verifyactivityAdded() {
		return getText(activitynamelocator);

	}
	public boolean verify_UTCletterGenerated(String userProfileName)
	{
		By UTCletterrecordlocator = By.xpath("//span[contains(text(),'CM Unable To Reach')]/../../td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");		
		logger.info("verify_UTCletterGenerated in Letters screen "+isDisplayed(UTCletterrecordlocator));
		return isDisplayed(UTCletterrecordlocator);
	}
	public boolean verify_CM_PCP_Mbr_Opt_OutLetterGenerated(String userProfileName)
	{
		By PCP_Mbr_Opt_Outletterrecordlocator = By.xpath("//span[contains(text(),'CM PCP Mbr Opt Out Ltr')]/../../td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");		
		logger.info("verify_UTCletterGenerated in Letters screen "+isDisplayed(PCP_Mbr_Opt_Outletterrecordlocator));
		return isDisplayed(PCP_Mbr_Opt_Outletterrecordlocator);
	}
	public boolean verify_CM_Mbr_Opt_OutLetterGenerated(String userProfileName)
	{
		By Mbr_Opt_Outletterrecordlocator = By.xpath("//span[contains(text(),'CM Mbr Opt Out')]/../../td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");		
		logger.info("verify_CM_Mbr_Opt_OutLetterGenerated in Letters screen "+isDisplayed(Mbr_Opt_Outletterrecordlocator));
		return isDisplayed(Mbr_Opt_Outletterrecordlocator);
	}
	public boolean verify_CM_PostEnrollmentLetterGenerated(String userProfileName)
	{
		By CM_PostEnrollmentletterrecordlocator = By.xpath("//span[contains(text(),'CM Post Enrollment')]/../../td[contains(text(),'"+userProfileName.split(",")[0].trim()+"')]");		
		logger.info("verify_CM_PostEnrollmentLetterGenerated in Letters screen "+isDisplayed(CM_PostEnrollmentletterrecordlocator));
		return isDisplayed(CM_PostEnrollmentletterrecordlocator);
	}
	
	public void openCorrespondence()
	{
		clickUsingJs(correspondenceopenlocator);
	}
	
	public void clickWorkflow() 
	{
		clickUsingJs(workflowlocator);
	}
	
	public void clickHamBurger() {
		clickUsingJs(hamburgerlocator);
	}

	public void clickActivities() {
		clickUsingJs(activitieslinklocator);
	}
	
	public void clickChangeStatus() {
		clickUsingJs(changestatuslinklocator);
	}
	
	public void clickPrograms() {
		clickUsingJs(programslinklocator);
	}
	public void clickAssessments() {
		clickUsingJs(assessmentslinklocator);
	}
	public void clickCorrespondence() {
		clickUsingJs(correspondencelinklocator);
	}
	
}
