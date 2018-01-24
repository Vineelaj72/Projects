package com.jiva.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.jiva.setup.Setup;
import com.jiva.utils.WebElements;

public class CreateCMepisodePage extends WebElements{

	public CreateCMepisodePage(WebDriver driver1) {
		super(driver1);
				}
	
	By episodestatusdd = By.name("episodestatus");
	By assigntodd = By.name("assign_to");
	By acuityleveldd = By.name("select1");
	By programnamelocator = By.name("program");
	By programassigntolocator = By.name("I_ASSIGNED_NURSE_IDN");
	By addprogrambutton = By.xpath("(//button[@class='btn btn-primary'])[3]");
	By addprogramverifylocator = By.xpath("//span[contains(text(),'Complex Case Management')]");
	By savebuttonlocator = By.xpath("(//button[@class='btn btn-success'])[1]");
	By membersearchverifylocator = By.xpath("//span[contains(text(),'Search')]");
	By cancelbuttonlocator = By.xpath("//button[@ng-click='addEncCtrl.cancelCreateEpisode()']");
	
	public void addEpisodeDetails() throws InterruptedException
	{
		dropdownSelect(episodestatusdd, "Referral");		
		dropdownSelect(acuityleveldd, "2");
		sleep(5000);
		dropdownSelect(assigntodd, "CCM Referral");
		dropdownSelect(programnamelocator, "Complex Case Management");
		Thread.sleep(5000);
		dropdownSelect(programassigntolocator,"Jayavarapu, Vineela"); //doubt
		clickUsingJs(addprogrambutton);
				
	}
	
	public boolean verifyProgramAdded()
	{
		return isDisplayed(addprogramverifylocator);
		
	}
	
	public void clickSave() throws InterruptedException  //doubt
	{
		clickUsingJs(savebuttonlocator);
		//duplicateCMEpisodeAlert();       // use this for duplicate episodes data
		//clickUsingJs(cancelbuttonlocator);
	}
	
	public boolean verifyEpidodeAdded()
	{
		return isDisplayed(membersearchverifylocator);
	}
	
	public void duplicateCMEpisodeAlert() throws InterruptedException
	{
		Thread.sleep(10000);
		alertBox("Duplicate CM Episode");
		clickUsingJs(cancelbuttonlocator);
	}
	
	public boolean duplicateCM(String username)
	{
		By duplicateCM = By.xpath("//*[contains(text(),'Complex Case Management')]/../..//*[contains(text(),'"+username+"')]");
		return isDisplayed(duplicateCM);
	}
	// if true - click cancel
	// if not, enter episode details and click save
}

