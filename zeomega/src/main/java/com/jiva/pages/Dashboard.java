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
	
	//By Menulink=By.xpath("//li[2]");
	
	By Menulink=By.partialLinkText("Menu");
	By MemberSearchlink = By.linkText("Member Search");
	
	public void clickMenu()
	{
		clickusingjs(Menulink);
		//click(Menulink);
	}
	public void clickMemberSearch()
	{
		clickusingjs(MemberSearchlink);
		//click(MemberSearchlink);
	}
	
	public boolean verifyDashboardDisplayed()
	{
		return isDisplayed(messagelocator);
	}
}
