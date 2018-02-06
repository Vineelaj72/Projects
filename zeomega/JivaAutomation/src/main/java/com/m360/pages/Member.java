package com.m360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebElements;

public class Member extends WebElements{
	
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "searchMemberId")
    @CacheLookup
    private WebElement txtMemberId;
	
	public Member(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchMember(String memberId){
		txtMemberId.sendKeys(memberId);
	}
}
