package com.jiva.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jiva.setup.Setup;

public class WaitForElements implements Setup {
	long timeOutInSeconds=240;
	WebDriverWait driverWait;
	
	WebDriver driver;
	public WaitForElements(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, timeOutInSeconds);

	}
	
	public void waitforElementPresent(By by)
	{
		driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	

}
