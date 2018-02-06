package com.m360.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.framework.utils.LoginPage;
import com.framework.utils.LoginPageFactory;
import com.framework.utils.LoginPageFactory.appName;
import com.framework.utils.SeleniumHelper;
import com.framework.utils.WebElements;
import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class IntegrationFlows extends WebElements {

	private WebDriver driver;
	
	public IntegrationFlows(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void searchAndValidateDayNMinus1PendingEnrollmentsInM360(dataSource ds,String[] pendingEnrollmentData) {
		
		String expectedHIcn;
		String expectedFName;
		String expectedLName;
		if (ds == dataSource.DRX_file) {
			expectedHIcn = pendingEnrollmentData[20];
			expectedFName = pendingEnrollmentData[6];
			expectedLName = pendingEnrollmentData[8];
		}
		else{
			expectedHIcn = pendingEnrollmentData[0];
			expectedFName = pendingEnrollmentData[1];
			expectedLName = pendingEnrollmentData[2];
		}

		SoftAssert softAssert = new SoftAssert();

		LoginPage login = new LoginPageFactory(driver).getLoginPage(appName.m360);
		login.login();
		
		driver.switchTo().frame(0);
		driver.switchTo().frame("body_frame");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickMyEnrollmentPendingTask();
		
		try {
		Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File("lib", "jacob-1.18-x64.dll"); //path to the jacob dll
	    System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		AutoItX x = new AutoItX();
		x.winActivate("WorkFLow - Google Chrome","Chrome Legacy Window");
		x.send("{ENTER}!n", false );

		SeleniumHelper.switchToChildWindowAndGetItsTitle(driver);
		

		MedicareSupportServicesMenu medicareSupportServicesMenu = new MedicareSupportServicesMenu(driver);
		medicareSupportServicesMenu.clickApplicationEntryTab();
		
		ApplicationEntry applicationEntry = new ApplicationEntry(driver, expectedHIcn, expectedFName, expectedLName);
		applicationEntry.searchApplication();
		softAssert = applicationEntry.validateApplication(softAssert);		
		
		softAssert = applicationEntry.clickValidateApplication(softAssert);
		
		softAssert.assertAll();
	}
	public enum dataSource{
		connecture,
		DRX_file
	}
}
