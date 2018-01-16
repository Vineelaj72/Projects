package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class ConfirmAddepisodePage extends WebElements{
	
	
	public ConfirmAddepisodePage(WebDriver driver1) {
		super(driver1);
		
	}
	By addepisodelocator = By.xpath("//*/j-label[contains(text(),'Episode')]");
	By cmlocator = By.xpath("//span[contains(text(),'Case Management')]");
	
	public void clickAddepisode() throws InterruptedException
	{
		clickusingjs(addepisodelocator);
		clickusingjs(cmlocator);
		existingEpisodeAlert();
	}
	public void existingEpisodeAlert() throws InterruptedException
	{
		Thread.sleep(10000);
		alertBox("A similar Episode has been added in the last 24 hrs.");
	}
}