package com.m360.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;

public class HomePage extends WebElements {
	
	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "M360")
    @CacheLookup
    private WebElement lnkM360;
	
	@FindBy(how = How.LINK_TEXT, using = "ELIGIBILITY")
    @CacheLookup
    private WebElement lnkEligibility;
	
	@FindBy(how = How.XPATH, using = "//p[text()='My Enrollment Pending Task']/..")
    @CacheLookup
    private WebElement lnkMyEnrollmentPendingTask;

	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickM360(){
		lnkM360.click();
	}
	
	public void clickEligibility(){
		SeleniumHelper.hoverElement(driver, By.linkText("M360"));
		lnkEligibility.click();
	}
	
	public void clickMyEnrollmentPendingTask(){
		lnkMyEnrollmentPendingTask.click();
	}
}
