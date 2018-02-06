package com.framework.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
	public static boolean isElementPresent(WebDriver driver, By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public static boolean isAlertPresent(WebDriver driver) {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public static String closeAlertAndGetItsText(WebDriver driver, boolean acceptAlert) {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	acceptAlert = true;
	    }
	  }
	
	public static String switchToChildWindowAndGetItsTitle(WebDriver driver){
		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		    String child_window=I1.next();
		    if(!parent.equals(child_window))
			{
		    	driver.switchTo().window(child_window);
		    	return driver.switchTo().window(child_window).getTitle();
			 }
		 }
		return "";
	}
	
	public static void hoverElement(WebDriver driver, By byHover){
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(byHover);
		action.moveToElement(we).build().perform();
	}
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, By by){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement elementAfterWait = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return elementAfterWait;
	}
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, By by, int timeout){
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		WebElement elementAfterWait = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return elementAfterWait;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement elementAfterWait = wait.until(ExpectedConditions.elementToBeClickable(element));
		return elementAfterWait;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeout){
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		WebElement elementAfterWait = wait.until(ExpectedConditions.elementToBeClickable(element));
		return elementAfterWait;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int timeout){
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		WebElement elementAfterWait = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
		return elementAfterWait;
	}
	
	public static boolean clickUntilElementIsVisible(WebDriver driver, By byToClick, By byToFind){
		WebElement elementToFind = null;
		int timeout = 60;
		int timePass = 0;
		int timeJump = 5;
		
		while ((elementToFind == null) && (timePass < timeout)){
			try {
				driver.findElement(byToClick).click();
				WebDriverWait wait = new WebDriverWait(driver, timeJump);
				elementToFind = wait.until(ExpectedConditions.visibilityOfElementLocated(byToFind));
				timePass += timeJump;
			} catch (Exception e) {
				continue;
			}
		}
		
		if (elementToFind != null){
			return true;
		}
		else return false;
		
	}
	
	public static void moveToElement(WebDriver driver, WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static void checkCheckbox(WebDriver instance, WebElement cbNewToMedicare) {
		if	(!cbNewToMedicare.isSelected()){
			cbNewToMedicare.click();
		}
	}

	public static void executeAsyncScriptClick(WebDriver instance, WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor)instance;	
		js.executeAsyncScript("arguments[0].click();", we);
	}
}
