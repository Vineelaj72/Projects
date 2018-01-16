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
	
	public void clickAddepisode()
	{
		clickusingjs(addepisodelocator);
		clickusingjs(cmlocator);
	}
}
