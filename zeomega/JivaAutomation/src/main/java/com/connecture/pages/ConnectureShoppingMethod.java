package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebElements;

public class ConnectureShoppingMethod extends WebElements{
	
	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "View All Plans")
    @CacheLookup
    private WebElement lnkViewAllPlans;
	
	@FindBy(how = How.LINK_TEXT, using = "Help Me Choose")
    @CacheLookup
    private WebElement lnkHelpMeChoose;
	
	public ConnectureShoppingMethod(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickViewAllPlans(){
		lnkViewAllPlans.click();
	}
	
	public void clickHelpMeChoose(){
		lnkHelpMeChoose.click();
	}
}
