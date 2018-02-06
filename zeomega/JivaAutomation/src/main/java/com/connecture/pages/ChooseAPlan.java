package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebElements;

public class ChooseAPlan extends WebElements{
	
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "zipcode")
    @CacheLookup
    private WebElement txtZipCode;
	
	@FindBy(how = How.LINK_TEXT, using = "Submit")
    @CacheLookup
    private WebElement lnkSubmit;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Add To Cart")
    @CacheLookup
    private WebElement lnkFirstAddToCart;
	
	public ChooseAPlan(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void submitZipCode(String zipCode){
		txtZipCode.sendKeys(zipCode);
		lnkSubmit.click();
		/*PageFactory.initElements(Driver.Instance, this);*/
	}
	
	public void selectFirstPlan(){
		lnkFirstAddToCart.click();
	}
}
