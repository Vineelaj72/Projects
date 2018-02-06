package com.m360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebElements;

public class MedicareSupportServicesMenu extends WebElements{

	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Application Entry")
    @CacheLookup
    private WebElement lnkApplicationEntry;
	
	@FindBy(how = How.XPATH, using = "td[text()='Application Entry']")
    @CacheLookup
    private WebElement lblApplicationEntry;
	
	@FindBy(how = How.LINK_TEXT, using = "Member")
    @CacheLookup
    private WebElement lnkMember;
	
	public MedicareSupportServicesMenu(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickApplicationEntryTab(){
		lnkApplicationEntry.click();
	}
	
	public void clickMemberTab(){
		try {
			lnkMember.click();
		} catch (Exception e) {
		}
	}
}
