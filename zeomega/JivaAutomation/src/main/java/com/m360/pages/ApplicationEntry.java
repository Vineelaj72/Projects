package com.m360.pages;

import org.testng.asserts.SoftAssert;
import com.framework.utils.SeleniumHelper;
import com.framework.utils.ValidationHelper;
import com.framework.utils.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationEntry extends WebElements{
	
	private WebDriver driver;
	
	public String hicNo;
	public String firstName;
	public String lastName;
	
	@FindBy(how = How.NAME, using = "searchHicNo")
    @CacheLookup
    private WebElement txtMedicareId;
	
	@FindBy(how = How.ID, using = "btnGoGif")
    @CacheLookup
    private WebElement btnGo;
	
	@FindBy(how = How.ID, using = "origButton")
    @CacheLookup
    private WebElement btnOriginalApplication;
	
	@FindBy(how = How.NAME, using = "mbrFirstName")
    @CacheLookup
    private WebElement txtFirstName;
	
	@FindBy(how = How.NAME, using = "mbrLastName")
    @CacheLookup
    private WebElement txtLastName;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Update Comments']")
    @CacheLookup
    private WebElement btnUpdateComments;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Validate Application']")
    @CacheLookup
    private WebElement btnValidateApplication;
	
	public ApplicationEntry(WebDriver driver, String _hicNo, String _firstName, String _lastName){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		hicNo = _hicNo;
		firstName = _firstName;
		lastName = _lastName;
	} 
	
	public void searchApplication(){
		System.out.println("going to search for:"+hicNo + ":" + firstName + ":" + lastName);
		txtMedicareId.clear();
		txtMedicareId.sendKeys(hicNo);
		btnGo.click();
		System.out.println("clicked search button for:"+hicNo + ":" + firstName + ":" + lastName);
		if(firstName == "Rainbow"){
			System.out.println("going to search for:"+hicNo + ":" + firstName + ":" + lastName);
		}
	}
	
	public SoftAssert validateApplication(SoftAssert softAssert){
		String msgFalse = "%s of member "+ hicNo +" was not as expected. expected '%s' actual was '%s'";
		ValidationHelper.AssertTrue(softAssert, hicNo, firstName, txtFirstName, msgFalse, "First Name");
		ValidationHelper.AssertTrue(softAssert, hicNo, lastName, txtLastName, msgFalse, "Last Name");
		return softAssert;
	}	
	
	public SoftAssert clickValidateApplication(SoftAssert softAssert){
		try {
			SeleniumHelper.moveToElement(driver, btnValidateApplication);
			btnValidateApplication.click();
			String alertText = SeleniumHelper.closeAlertAndGetItsText(driver, true);
			softAssert.assertTrue(alertText.contains("Validating Application Done"), "pop up was not displayed with message 'Validating Application Done' as expected, actual message was : "+alertText);
			return softAssert;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return softAssert;
		}
	}
}
