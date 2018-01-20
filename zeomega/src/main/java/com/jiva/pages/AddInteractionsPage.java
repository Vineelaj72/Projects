package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class AddInteractionsPage extends WebElements{

	public AddInteractionsPage(WebDriver driver1) {
		super(driver1);
	}
	//By followuprequiredyeslocator = By.xpath("(//label[contains(text(),'Follow-up Required')]/../../div/div/label)[1]");
	
	By followuprequiredyeslocator = By.xpath("//label[contains(text(),'Follow-up Required')]/../div/label/span[contains(text(),'Yes')]/../input");
	By followuprequirednolocator = By.xpath("//label[contains(text(),'Follow-up Required')]/../div/label/span[contains(text(),'No')]/../input");
	By interactionstatusunsuccessfullocator = By.xpath("//label[contains(text(),'Interaction Status')]/../div/label/span[contains(text(),'Unsuccessful')]/../input");
	By enrollstatusunsuccessfullocator = By.xpath("(//input[@name='Successful'])[2]");
	By notenrolloutcomesreasonsdropdown = By.xpath("//select[@name='reasons']");
	By savelocator = By.xpath("//button[contains(text(),'Save')]");
	
	public void add1stInteractiondetails()
	{
		clickUsingJs(followuprequiredyeslocator);
		clickUsingJs(interactionstatusunsuccessfullocator);
		clickUsingJs(enrollstatusunsuccessfullocator);
		dropdownSelect(notenrolloutcomesreasonsdropdown,"Unable to contact member");
	}
	public void clickSaveInteraction()
	{
		clickUsingJs(savelocator);
	}
	public void add2ndInteraction()
	{
		//clickUsingJs(followuprequirednolocator);  //by default - no
		//clickUsingJs(interactionstatusunsuccessfullocator);	//by default - no --------- doubt
		clickUsingJs(enrollstatusunsuccessfullocator);
		//dropdownSelect(notenrolloutcomesreasonsdropdown,"Unable to contact member"); 	//by default - no
		
	}
	
	
}
