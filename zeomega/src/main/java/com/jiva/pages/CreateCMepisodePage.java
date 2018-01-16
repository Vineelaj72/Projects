package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class CreateCMepisodePage extends WebElements{

	public CreateCMepisodePage(WebDriver driver1) {
		super(driver1);
			}
	
	By episodestatusdd = By.name("episodestatus");
	By assigntodd = By.name("assign_to");
	By acuityleveldd = By.name("select1");
	By programnamelocator = By.name("program");
	By addprogrambutton = By.xpath("(//button[@class='btn btn-primary'])[3]");
	By addprogramverifylocator = By.xpath("//span[contains(text(),'Complex Case Management')]");
	By savebuttonlocator = By.xpath("(//button[@class='btn btn-success'])[1]");
	By msverifylocator = By.xpath("//span[contains(text(),'Search')]");
	
	public void addepisodedetails()
	{
		dropdownselect(episodestatusdd, "Referral");
		dropdownselect(assigntodd, "CCM Referral");
		dropdownselect(acuityleveldd, "2");
		dropdownselect(programnamelocator, "Complex Case Management");
		clickusingjs(addprogrambutton);
				
	}
	
	public boolean verifyprogramadded()
	{
		return isDisplayed(addprogramverifylocator);
	}
	
	public void clicksave()
	{
		clickusingjs(savebuttonlocator);
	}
	public boolean verifyepidodeadded()
	{
		return isDisplayed(msverifylocator);
	}
}

