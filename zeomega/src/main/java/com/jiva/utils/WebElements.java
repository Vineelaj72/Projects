package com.jiva.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElements {

	WebDriver driver;

	public WebElements(WebDriver driver1) {
		this.driver = driver1;
	}

	public void enterText(By locator, String testData) {

		driver.findElement(locator).sendKeys(testData);

	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void dropdownSelect(By locator, String testdata) {
		Select dd = new Select(driver.findElement(locator));
		dd.selectByVisibleText(testdata);
	}

	public boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public void clickusingjs(By locator) {

		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickEnter(By locator) {

		driver.findElement(locator).sendKeys(Keys.ENTER);
	}

	public void alertBox(String messageonalert) {
		try
		{
			
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("@@@@@@"+alert.getText());
		System.out.println("@@"+messageonalert);
		if ((alert.getText().contains(messageonalert)))

			alert.accept();

		else

			System.out.println("No alert displayed");
		}
		catch (NoAlertPresentException e) {
			System.out.println("No alert displayed");
		}

	}

}
