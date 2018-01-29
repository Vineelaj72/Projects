package com.jiva.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.dao.LoginData;
import com.jiva.pages.AddInteractionsPage;
import com.jiva.pages.CalenderPage;
import com.jiva.pages.ConfirmAddepisodePage;
import com.jiva.pages.CreateCMepisodePage;
import com.jiva.pages.Dashboard;
import com.jiva.pages.Episodeactivitiespage;
import com.jiva.pages.Episodeoverviewpage;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberSearchPage;
import com.jiva.pages.WorklistsPage;
import com.jiva.utils.TestBase;

public class CMEpisodeCreation_TC extends TestBase {
	private static Logger logger = Logger.getLogger(ZU_01_CalenderActivity.class);
	WebDriver driver;
	private String sTestcaseName = null;

	@Test(description = "Add CM episode for active Jiva members")
	public void verify_AddCMEpisodetoMember() throws InterruptedException {

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
		memberSearchPage.enterJivaId(JIVAID);
		memberSearchPage.clickSearch();
		

		// Confirmation for Adding episode

		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		String memberfullname = confirmAddepisodePage.getmemberfullname();
		// System.out.println("Member Full name is "+memberfullname);
		logger.info("Member Full Name is " + memberfullname);
		String[] MemberLastname_Firstname = memberfullname.split(",");
		logger.info("Member Last name " + MemberLastname_Firstname[0]);
		logger.info("Member First name " + MemberLastname_Firstname[1]);
		confirmAddepisodePage.clickAddepisode();
		

		// Create episode page details

		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails();
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSave();
		Assert.assertEquals(true, createCMepisodePage.verifyEpidodeAdded(), "Episode added Sucessfully");
		// System.out.println("Verified creation of episode successfully");
		logger.info("Verified creation of episode successfully");

	}

}
