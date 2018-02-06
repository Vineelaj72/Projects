package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebElements;

public class ShoppingCart  extends WebElements {
	
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "btnEnroll")
    @CacheLookup
    private WebElement lnkEnroll;
	
	public ShoppingCart(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enroll(){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lnkEnroll.click();
	}
}
