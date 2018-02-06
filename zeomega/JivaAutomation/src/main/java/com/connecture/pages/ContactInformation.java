package com.connecture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;

public class ContactInformation extends WebElements{
	
	private WebDriver driver;
	
	/*Personal Info*/ 
	@FindBy(how = How.XPATH, using = "//label[text()= 'Mrs.']")
    @CacheLookup
    private WebElement rbMrs;
	
	@FindBy(how = How.NAME, using = "ApplicantFirstName")
    @CacheLookup
    private WebElement txtFirstName;
	
	@FindBy(how = How.NAME, using = "ApplicantLastName")
    @CacheLookup
    private WebElement txtLastName;
	
	@FindBy(how = How.NAME, using = "ApplicantBirthDate")
    @CacheLookup
    private WebElement txtBirthDate;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Female']")
    @CacheLookup
    private WebElement rbGenderFemale;
	
	@FindBy(how = How.NAME, using = "ApplicantPhone")
    @CacheLookup
    private WebElement txtApplicationPhone;
	
	@FindBy(how = How.NAME, using = "ApplicantEmailAddress")
    @CacheLookup
    private WebElement txtApplicantEmailAddress;
	
	@FindBy(how = How.LINK_TEXT, using = "Continue")
    @CacheLookup
    private WebElement lnkContinue;
	
	/*Permanent Residence*/
	@FindBy(how = How.NAME, using = "ApplicantAddress1")
    @CacheLookup
    private WebElement txtApplicantAddress1;
	
	@FindBy(how = How.NAME, using = "ApplicantCity")
    @CacheLookup
    private WebElement txtApplicantCity;
	
	@FindBy(how = How.NAME, using = "ApplicantState")
    @CacheLookup
    private WebElement txtApplicantState;
	
	@FindBy(how = How.NAME, using = "ApplicantZip")
    @CacheLookup
    private WebElement txtApplicantZip;
	
	/*Mailing Address*/
	
	@FindBy(how = How.XPATH, using = "//input[@name='MailingAddress' and @value='Yes']/following-sibling::label")
    @CacheLookup
    private WebElement rbMailingAddress;
	
	@FindBy(how = How.NAME, using = "MailingAddress1")
    @CacheLookup
    private WebElement txtMailingAddress1;
	
	@FindBy(how = How.NAME, using = "MailingCity")
    @CacheLookup
    private WebElement txtMailingCity;
	
	@FindBy(how = How.NAME, using = "MailingState")
    @CacheLookup
    private WebElement txtMailingState;
	
	@FindBy(how = How.NAME, using = "MailingZip")
    @CacheLookup
    private WebElement txtMailingZip;
	
	/*Other Language*/
	
	/*Emergency Contact*/
	@FindBy(how = How.XPATH, using = "//input[@name='EmergencyContactOption' and @value='Yes']/following-sibling::label")
    @CacheLookup
    private WebElement rbEmergencyContact;
	
	@FindBy(how = How.NAME, using = "EmergencyContact")
    @CacheLookup
    private WebElement txtEmergencyContact;
	
	@FindBy(how = How.NAME, using = "EmergencyRelationship")
    @CacheLookup
    private WebElement txtEmergencyRelationship;
	
	@FindBy(how = How.NAME, using = "EmergencyPhone")
    @CacheLookup
    private WebElement txtEmergencyPhone;
	
	public ContactInformation(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private void enterPersonalInfo(String applicantFName, String applicantLName){
		SeleniumHelper.waitForElementToBeVisible(driver, By.xpath("//label[text()= 'Mrs.']"));
		SeleniumHelper.waitForElementToBeClickable(driver, rbMrs);
		rbMrs.click();
		txtFirstName.sendKeys(applicantFName);
		txtLastName.sendKeys(applicantLName);
		txtBirthDate.sendKeys("04/12/2000");
		rbGenderFemale.click();
		txtApplicationPhone.sendKeys("3426784534");
		txtApplicantEmailAddress.sendKeys("ShawnRJohnson@google.com");
	}
	
	private void enterPermanentResidence(){
		this.txtApplicantAddress1.sendKeys("2501 Olive Blvd");
		this.txtApplicantCity.clear();
		this.txtApplicantCity.sendKeys("St Louis");
		new Select(txtApplicantState).selectByVisibleText("MO");
		this.txtApplicantZip.sendKeys("63141");
	}
	
	private void enterMailingAddress(){
		rbMailingAddress.click();
		this.txtMailingAddress1.sendKeys("235 Ladue Rd");
		this.txtMailingCity.sendKeys("Olivette");
		new Select(txtMailingState).selectByVisibleText("MO");
		this.txtMailingZip.sendKeys("63120");
	}
	
	private void enterOtherLanguage(){
	}
	
	private void enterEmergencyContact(){
		rbEmergencyContact.click();
		txtEmergencyContact.sendKeys("Ben Florez");
		txtEmergencyRelationship.sendKeys("Spouse");
		txtEmergencyPhone.sendKeys("4532347512");
	}
	
	public void enterContactInfo(String applicantFName, String applicantLName){
		enterPersonalInfo(applicantFName, applicantLName);
		enterPermanentResidence();
		enterMailingAddress();
		enterOtherLanguage();
		enterEmergencyContact();
		lnkContinue.click();
		
	}
	
	
}
