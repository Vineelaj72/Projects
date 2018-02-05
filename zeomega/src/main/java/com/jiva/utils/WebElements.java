package com.jiva.utils;

import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElements extends WaitForElements{

	WebDriver driver;
	private static Logger logger = Logger.getLogger(WebElements.class);


	public WebElements(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterText(By locator, String testData) {
		waitforElementPresent(locator);
		driver.findElement(locator).sendKeys(testData);

	}

	public void click(By locator) {
		waitforElementPresent(locator);
		driver.findElement(locator).click();
	}

	public void dropdownSelect(By locator, String testdata) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(testdata);
	}

	public boolean isDisplayed(By locator) {
	boolean flag=false;
		try{
			
			driver.findElement(locator).isDisplayed();
			flag=true;
		}
		catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isEnabled(By locator)
	{
		return driver.findElement(locator).isEnabled();
	}

	public void clickUsingJs(By locator) {

		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickEnter(By locator) {

		driver.findElement(locator).sendKeys(Keys.ENTER);
	}

	public void alertBox(String messageonalert) {
		try {
			Alert alert = driver.switchTo().alert();

			if ((alert.getText().contains(messageonalert)))
				alert.accept();
				
			else
				System.out.println("Different alert");			
			}
		
		catch (NoAlertPresentException e)
		{
			System.out.println("No alert displayed");
		}
	
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	
	}
	
	public String getAttribute(By locator) {
		LinkedList< String> attributeValue = new LinkedList<String>();
		WebElement element = null;
				element = driver.findElement(locator);
				attributeValue.add(element.getAttribute("className"));
				attributeValue.add( element.getAttribute("value"));
				attributeValue.add(element.getAttribute("innerHTML"));
				attributeValue.add(element.getAttribute("outerHTML"));		
				attributeValue.add(element.getAttribute("innerText"));
				attributeValue.add(element.getAttribute("text"));
				attributeValue.add(element.getAttribute("textContent"));
	
			logger.info("Attribute Value" + attributeValue);
		return attributeValue.toString();

	}
	
	public void sleep(int time)
	{
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
