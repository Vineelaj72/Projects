package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;

public class OtherInformation  extends WebElements {
	
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "PrimaryCarePhysician")
    @CacheLookup
    private WebElement txtPrimaryCarePhysician;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Get a Bill']")
    @CacheLookup
    private WebElement rbGetABill;
	
	@FindBy(how = How.LINK_TEXT, using = "Continue")
    @CacheLookup
    private WebElement lnkContinue;
	
	@FindBy(how = How.LINK_TEXT, using = "Complete Review")
    @CacheLookup
    private WebElement lnkCompleteReview;
	
	public OtherInformation(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterOtherInfo(){
		txtPrimaryCarePhysician.sendKeys("Janice Brown");
		rbGetABill.click();
		lnkContinue.click();
		SeleniumHelper.moveToElement(driver, lnkCompleteReview);
		SeleniumHelper.waitForElementToBeClickable(driver, lnkCompleteReview);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lnkCompleteReview.click();
	}
}
