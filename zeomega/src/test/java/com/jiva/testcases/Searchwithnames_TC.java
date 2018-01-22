package com.jiva.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberSearchPage;
import com.jiva.utils.TestBase;
import com.jiva.utils.WebElements;

public class Searchwithnames_TC extends TestBase{

	private static Logger logger = Logger.getLogger(Searchwithnames_TC.class);
	WebDriver driver;
	private String sTestcaseName = null;

	@Test(description = "Member Search with Last name and First name")
	public void verify_MemberSearchwithnames() throws InterruptedException {

		sTestcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for " + sTestcaseName);

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
		// System.out.println("User Profile Name is "+userprofilename);
		logger.info("User Profile Name is " + userprofilename);
		String[] UserLastname_Firstname = userprofilename.split(",");
		logger.info("Last name " + UserLastname_Firstname[0]);
		logger.info("First name " + UserLastname_Firstname[1]);
		dashboard.clickMenu();
		dashboard.clickMemberSearch();

		// MemberSearch Page details

		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();
		memberSearchPage.enterMemberLastname("Armwood");
		memberSearchPage.enterMemberFirstname("Linda");
		memberSearchPage.clickSearch();

	}
}

