package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class Episodeoverviewpage extends WebElements{

	public Episodeoverviewpage(WebDriver driver1) {
		super(driver1);
	}
	
	By activitiesopenlocator = By.xpath("//button[@ng-click='routeActivityDataListing()']");
	By activitynamelocator = By.xpath("//span[contains(text(),'Verbal consent to be received')]");
	
	public void openactivities()
	{
		clickUsingJs(activitiesopenlocator);
	}
	public void verifyactivityadded()
	{
		String activityname = getText(activitynamelocator);
		if(activityname=="Verbal consent to be received")
			System.out.println();
	}
}
