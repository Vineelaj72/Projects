package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;

public class BenefitsInformation extends WebElements{
	
	private WebDriver driver;
	
	/*Medicare Information*/
	@FindBy(how = How.NAME, using = "ApplicantHICN")
    @CacheLookup
    private WebElement txtMedicareNumber;
	
	@FindBy(how = How.NAME, using = "PartAEffectiveDate")
    @CacheLookup
    private WebElement txtPartAEffectiveDate;
	
	@FindBy(how = How.NAME, using = "PartBEffectiveDate")
    @CacheLookup
    private WebElement txtPartBEffectiveDate;
	
	/*Annual Enrollment Period*/
	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'I am making my annual enrollment period election.')]")
    @CacheLookup
    private WebElement cbAnnualEnrollmentPeriod;
	
	/*Special Enrollment Period*/
	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'I am new to Medicare.')]")
    @CacheLookup
    private WebElement cbNewToMedicare;
	
	/*End Stage Renal Disease*/
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Do you have End Stage Renal Disease, or ESRD?')]/following-sibling::div//label[text()='No']")
    @CacheLookup
    private WebElement rbEndStageNo;
	
	/*Prescription Drug Coverage*/
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Will you have other prescription drug coverage in addition to this plan?')]/following-sibling::div//label[text()='No']")
    @CacheLookup
    private WebElement rbPrescriptionDrugCoverageNo;
	
	/*Long Term Care*/
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Are you a resident in a long-term care facility, such as a nursing home?')]/following-sibling::div//label[text()='No']")
    @CacheLookup
    private WebElement rbLongTermCareNo;
	
	/*Medicaid Enrollment*/
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Are you enrolled in your state Medicaid program?')]/following-sibling::div//label[text()='No']")
    @CacheLookup
    private WebElement rbMedicaidEnrollmentNo;
	
	/*Employment Information*/
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Do you or your spouse work?')]/following-sibling::div//label[text()='No']")
    @CacheLookup
    private WebElement rbEmploymentInformationNo;
	
	@FindBy(how = How.LINK_TEXT, using = "Continue")
    @CacheLookup
    private WebElement lnkContinue;
	
	public BenefitsInformation(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterBenefitsInfo(String hicn){
		enterMedicareInfo(hicn);
		SeleniumHelper.checkCheckbox(driver, cbNewToMedicare);
		
		rbEndStageNo.click();
		rbPrescriptionDrugCoverageNo.click();
		rbLongTermCareNo.click();
		rbMedicaidEnrollmentNo.click();
		rbEmploymentInformationNo.click();
		
		lnkContinue.click();
		
	}
	private void enterMedicareInfo(String hicn) {
		txtMedicareNumber.sendKeys(hicn);
		txtPartAEffectiveDate.sendKeys("12/12/2010");
		txtPartBEffectiveDate.sendKeys("12/12/2010");
		
	}
}
