package com.jiva.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.framework.setup.Setup;
import com.framework.utils.WebElements;

public class CreateCMepisodePage extends WebElements{

	public CreateCMepisodePage(WebDriver driver) {
		super(driver);
				}
	
	By episodestatusdd = By.name("episodestatus");
	By assigntodd = By.name("assign_to");
	By acuityleveldd = By.name("select1");
	By sourcedd = By.name("referralsource");
	By programnamelocator = By.name("program");
	By programassigntolocator = By.name("I_ASSIGNED_NURSE_IDN");
	By addprogrambutton = By.xpath("(//button[@class='btn btn-primary'])[3]");
	By addprogramverifylocator = By.xpath("//span[contains(text(),'Complex Case Management')]");
	By savebuttonlocator = By.xpath("(//button[@class='btn btn-success'])[1]");
	By membersearchverifylocator = By.xpath("//span[contains(text(),'Search')]");
	By cancelbuttonlocator = By.xpath("//button[@ng-click='addEncCtrl.cancelCreateEpisode()']");
	By saveandcontinuelocator = By.xpath("(//button[@class='btn btn-success'])[2]");
	
	
	
	public void addEpisodeDetails(String userProfileName)
	{
		dropdownSelect(episodestatusdd, "Referral");	
		dropdownSelect(sourcedd, "Case Management");
		dropdownSelect(acuityleveldd, "2");
		sleep(5000);
		dropdownSelect(assigntodd, userProfileName);
		dropdownSelect(programnamelocator, "Complex Case Management");
		sleep(5000);
		//dropdownSelect(programassigntolocator,"Jayavarapu, Vineela"); 
		clickUsingJs(addprogrambutton);
					
	}
	
	public boolean verifyProgramAdded()
	{
		return isDisplayed(addprogramverifylocator);
		
	}
	
	public void clickSaveEpisode()
	{
		clickUsingJs(savebuttonlocator);
	}
	public void clickSaveandContinueEpisode()
	{
		clickUsingJs(saveandcontinuelocator);
	}
	
	public boolean verifyEpidodeAdded()
	{
		return isDisplayed(membersearchverifylocator);
	}
	
	public void duplicateCMEpisodeAlert()
	{
		sleep(10000);
		alertBox("Duplicate CM Episode");
		clickUsingJs(cancelbuttonlocator);
	}
	
	public void invalidEpisodeCoverageAlert()
	{
		sleep(10000);
		alertBox("Invalid Episode Coverage");
	}
	
	public boolean duplicateCM(String username)
	{
		By duplicateCM = By.xpath("//*[contains(text(),'Complex Case Management')]/../..//*[contains(text(),'"+username+"')]");
		return isDisplayed(duplicateCM);
	}
	
}

