package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jiva.utils.WebElements;

public class Dashboard extends WebElements{

	
	public Dashboard(WebDriver driver) {
		super(driver);
	}
	
	By messagelocator = By.xpath("//*[@title='Messagesasdd']");
	By menulocator=By.partialLinkText("Menu");
	By membersearchlocator = By.linkText("Member Search");
	By worklistslocator = By.partialLinkText("Worklists");
	By userprofilelocator = By.xpath("(//a[@class='dropdown-toggle'])[2]");
	By manageepisodeslocator = By.linkText("Manage Episodes");
	By calenderlocator = By.partialLinkText("Calendar");
	
	
	public void clickMenu()
	{
		//String userprofilename = getText(userprofilelocator);
		//System.out.println(userprofilename);
		clickUsingJs(menulocator);
	}
	
	public void clickMemberSearch()
	{
		clickUsingJs(membersearchlocator);
	}
	public void clickManageEpisodes()
	{
		clickUsingJs(manageepisodeslocator);
	}
	
	public boolean verifyDashboardDisplayed()
	{
		return isDisplayed(messagelocator);
	}
	
	public void clickWorklists()
	{
		clickUsingJs(worklistslocator);
	}
	public String getuserprofilename()
	{
		return getText(userprofilelocator);
		
	}
	public void clickCalender()
	{
		clickUsingJs(calenderlocator);
	}
		
}
