package com.jiva.testcases;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.utils.ReadFile;
import com.jiva.utils.TestBase;

public class ReadTextFile_TC extends TestBase{
	private static Logger logger = Logger.getLogger(ReadTextFile_TC.class);
	WebDriver driver;
	private String sTestcaseName = null;
	
	@Test(description = "Screen Data with File Data")
	public void verify_screenDataWithFileData() throws InterruptedException {

		sTestcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for " + sTestcaseName);
		Map<String, String> sFileData = ReadFile.readtextFile(SFILENAME);

		// initialise browser and openurl

		driver = initializeDriver(BROWSER);
		openurl(driver, AutomationURL);
		maximizeBrowser(driver);
		// Thread.sleep(15000);

		// Login Page details

		LoginPage login = new LoginPage(driver);
		login.username(USERNAME);
		login.password(PASSWORD);
		login.loginbutton();
		Thread.sleep(15000);

		// Dashboard Page details

		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(), "Logged in Sucessfully");
		String userprofilename = dashboard.getuserprofilename();
		logger.info("Split value "+userprofilename.split(",")[0]);
		
		Assert.assertEquals(true, sFileData.toString().contains(userprofilename.split(",")[0].toLowerCase()));
	}
}
