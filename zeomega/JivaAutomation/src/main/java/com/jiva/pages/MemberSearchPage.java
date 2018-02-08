package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.WebElements;

public class MemberSearchPage extends WebElements{

	public MemberSearchPage(WebDriver driver) {
		
		super(driver);
			}
	
	By advancedSearchlocator = By.id("dropdownMenu1");
	By groupnamelocator = By.xpath("//input[@placeholder='Group Name']");
	By groupvaluelocator = By.xpath("//strong[contains(text(),'Blue Advantage 001')]");
	By jivamemberidlocator = By.name("I_CLAIMANT_ID");	
	By groupsearchlocator = By.xpath("//input[@placeholder='Group Name']/../..//span/i[@class='fa fa-search']");
	By searchlocatorinadvancedsearch = By.xpath("(//button[@type='submit'])[2]");
	By mainsearchlocator = By.xpath("//span/button[contains(text(),'Search')]");
	By lastnamelocator = By.xpath("//input[@name='I_LAST_NAME']");
	By firstnamelocator = By.xpath("//input[@name='I_FIRST_NAME']");
	By csssel = By.cssSelector("strong");
	By memberidtextbox = By.xpath("//div/input[contains(@ng-model,'mbrSearchParam.mbrSrchDropDown')]");
	
	public void clickAdvSearch()
	{
		clickUsingJs(advancedSearchlocator);
	}
	public void groupname(String group) throws InterruptedException
	{
		enterText(groupnamelocator, "Blue Advantage 001");
		Thread.sleep(8000);
		clickEnter(groupnamelocator);
		
	}
	public void enterJivaId(String jivaid) throws InterruptedException
	{
		clickUsingJs(jivamemberidlocator);
		Thread.sleep(3000);
		enterText(jivamemberidlocator, jivaid);
	}
	public void clickMainSearch()
	{
		clickUsingJs(mainsearchlocator);
	}
		
	public void clickSearchinAdvancedSearch()
	{
		clickUsingJs(searchlocatorinadvancedsearch);
	}
	public void enterMemberLastname(String sLastname) throws InterruptedException
	{
		enterText(lastnamelocator, sLastname);
		sleep(6000);
		clickEnter(lastnamelocator);
	}
	public void enterMemberFirstname(String sFirstname) throws InterruptedException
	{
		enterText(firstnamelocator, sFirstname);
		sleep(5000);
		clickEnter(firstnamelocator);

	}
	public void enterMemberId(String smemberid) throws InterruptedException
	{
		enterText(memberidtextbox, smemberid);
		sleep(3000);
		//clickEnter(lastnamelocator);
	}
}
