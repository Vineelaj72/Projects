package com.connecture.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebElements;

public class HomePage extends WebElements {
	
	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Get Started")
    @CacheLookup
    private WebElement lnkGetStarted;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickGetStarted(){
		lnkGetStarted.click();
	}
}
