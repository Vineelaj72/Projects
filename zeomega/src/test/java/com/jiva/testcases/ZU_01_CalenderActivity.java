package com.jiva.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.beanfactory.BeanFactory;
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

public class ZU_01_CalenderActivity extends TestBase {
	private static Logger logger = Logger.getLogger(ZU_01_CalenderActivity.class);
	WebDriver driver;
	private String sTestcaseName = null;

	@Test(description = "Add CM episode for active Jiva members and go to worklists-ZU 60 flow")
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
		memberSearchPage.clicksearch();

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

		// Worklists page details

		WorklistsPage worklists = new WorklistsPage(driver);
		dashboard.clickWorklists();
		worklists.clickCCMreferral();
		worklists.clickAdvanceSearch();
		Thread.sleep(5000);
		worklists.enterLastName(MemberLastname_Firstname[0]);
		Thread.sleep(5000);
		worklists.enterFirstName(MemberLastname_Firstname[1]);
		worklists.clickSearchButton();
		String cmEpisodeID = worklists.getEpisodeID(MemberLastname_Firstname[0]);
		logger.info(cmEpisodeID);
		worklists.clickCM(MemberLastname_Firstname[0]);
		worklists.assigntoself();

		// Episode overview Page details

		Episodeoverviewpage episodeoverviewpage = new Episodeoverviewpage(driver);

		Assert.assertEquals(episodeoverviewpage.verifyactivityAdded(), "Verbal consent to be received",
				"Activity Added to the list");

		episodeoverviewpage.openActivities();

		// Episode activities Page details

		Episodeactivitiespage episodeactivitiespage = new Episodeactivitiespage(driver);
		Assert.assertEquals(true, episodeactivitiespage.verify_OpenActivityRecordVisible(userprofilename),
				"Open activity available");
		episodeactivitiespage.clickWheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 1st interaction details
		AddInteractionsPage addInteractionsPage = new AddInteractionsPage(driver);
		addInteractionsPage.add1stInteractiondetails();
		addInteractionsPage.clickSaveInteraction();

		// Calender Page details
		dashboard.clickCalender();
		CalenderPage calenderPage = new CalenderPage(driver);
		Assert.assertEquals(true, calenderPage.verifyCalenderRecord(memberfullname),
				"Member record appeared in Calender");

		dashboard.clickMenu();
		dashboard.clickManageEpisodes();

	}

}
