package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class ChangeStatusPage extends WebElements{

	public ChangeStatusPage(WebDriver driver1) {
		super(driver1);
		}
	
	By enrolloutcomeunsuccessfullocator = By.xpath("//label/input[contains(@value,'Un-Successful')]");
	By outreachoutcomedd = By.xpath("//label[contains(text(),'Outreach Outcomes')]/../div/select[contains(@name,'status')]");
	By savelocator = By.xpath("(//button[contains(text(),'Save')])[1]");
	By statusdropdown = By.xpath("//select[contains(@name,'status')]");
	By reasonsdropdown = By.xpath("//select[contains(@name,'reasons')]");
	
	public void changeStatusDetails()
	{
		clickUsingJs(enrolloutcomeunsuccessfullocator);
		dropdownSelect(outreachoutcomedd, "Closed");
		clickUsingJs(savelocator);
	}
	public void changeStatusDetailsforIdentifiedNeeds() throws InterruptedException
	{
		Thread.sleep(5000);
		dropdownSelect(statusdropdown, "Closed");
		dropdownSelect(reasonsdropdown, "Identified Needs/Goals Have Been Met");
		clickUsingJs(savelocator);
	}
	public void existingOpenActivitiesforEpisodeAlert() throws InterruptedException
	{
		Thread.sleep(5000);
		alertBox("This Episode has Open Activities");
	}
	
}
