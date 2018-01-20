package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class CalenderPage extends WebElements{

	public CalenderPage(WebDriver driver1) {
		super(driver1);
	}
	public boolean verifyCalenderRecord(String membername)
	{
		By todolistrecordlocator = By.xpath("//div/table/tbody/tr/td/div/div/div[@class='fc-content-skeleton']/table/tbody/tr/td[@class='fc-event-container']/a"
				+ "/div/span[contains(text(),'"+membername+"')]");
		return  isDisplayed(todolistrecordlocator); 
		
	}
}
