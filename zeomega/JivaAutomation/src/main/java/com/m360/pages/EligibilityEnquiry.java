package com.m360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;

public class EligibilityEnquiry extends WebElements{
	
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "strHICNbr")
    @CacheLookup
    private WebElement txtHICNbr;
	
	@FindBy(how = How.NAME, using = "qryLastName")
    @CacheLookup
    private WebElement txtLastName;
	
	@FindBy(how = How.NAME, using = "qryBirthDate")
    @CacheLookup
    private WebElement txtBirthDate;
	
	@FindBy(how = How.NAME, using = "btn_Submit")
    @CacheLookup
    private WebElement btnSubmit;
	
	private String hicNo;
	private String lastName;
	private String birthDate;
	
	public EligibilityEnquiry(WebDriver driver, String _hicNo, String _lastName, String _birthDate){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		hicNo = _hicNo;
		lastName = _lastName;
		birthDate = _birthDate;
	}
	
	public void eligibilityQuery(boolean isNotFoundAlertExpected){
		txtHICNbr.sendKeys(hicNo);
		txtLastName.sendKeys(lastName);
		txtBirthDate.sendKeys(birthDate);
		btnSubmit.click();
		
		boolean isAlertPresent = SeleniumHelper.isAlertPresent(driver);
		Assert.assertEquals(isAlertPresent, isNotFoundAlertExpected);
		if (isAlertPresent){
			String alertMsg = SeleniumHelper.closeAlertAndGetItsText(driver, true);
			System.out.println("An alert was displayed with message:" + alertMsg);
		}
		
	}
}
