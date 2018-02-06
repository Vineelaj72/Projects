package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;

public class Submit extends WebElements {
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'I am the person listed on this enrollment form or I am simply helping to complete')]")
    @CacheLookup
    private WebElement rbIAmListed;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'I understand that my submission (or submission of the person')]")
    @CacheLookup
    private WebElement rbIUnderstand;
	
	@FindBy(how = How.LINK_TEXT, using = "Submit Enrollment")
    @CacheLookup
    private WebElement lnkSubmitEnrollment;
	
	@FindBy(how = How.XPATH, using = "//h1[text()='Your enrollment was successfully submitted!']")
    @CacheLookup
    private WebElement headerEnrollmentSubmitted;
	
	public Submit(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void submitEnrollment(){
		rbIAmListed.click();
		rbIUnderstand.click();
		SeleniumHelper.moveToElement(driver, lnkSubmitEnrollment);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lnkSubmitEnrollment.click();
		ValidateSuccessfullSubmission();
	}
	private void ValidateSuccessfullSubmission() {
		
		Assert.assertTrue(headerEnrollmentSubmitted.isDisplayed(), "Your enrollment was successfully submitted!");
		
	}
}
