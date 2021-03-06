package com.jivaUAT1.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.jiva.pages.AddInteractionsPage;
import com.jiva.pages.CalenderPage;
import com.jiva.pages.ChangeStatusPage;
import com.jiva.pages.ConfirmAddepisodePage;
import com.jiva.pages.CreateCMepisodePage;
import com.jiva.pages.Dashboard;
import com.jiva.pages.Episodeactivitiespage;
import com.jiva.pages.Episodeoverviewpage;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberOverviewPage;
import com.jiva.pages.MemberSearchPage;
import com.jiva.pages.WorklistsPage;
import com.framework.utils.TestBase;

import com.jiva.pages.ConfirmAddepisodePage;
import com.framework.utils.TestBase;


public class ZU_Calender_flow extends TestBase{
	private static Logger logger = Logger.getLogger(ZU_Calender_flow.class);
	WebDriver driver;
	private String sTestcaseName = null;

	@Test(description = "Add CM episode for active Jiva members and go to worklists-ZU 60 flow")
	public void verify_ZU_Calender_flow() throws InterruptedException {

		sTestcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for " + sTestcaseName);

		// initialise browser and openurl

		driver = initializeDriver(BROWSER);
		openurl(driver, JivaUAT2URL);
		maximizeBrowser(driver);
		
		// Login Page details

		LoginPage login = new LoginPage(driver);
		login.enterUsername(USERNAME);
		login.enterPassword(PASSWORD);
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
		memberSearchPage.clickSearchinAdvancedSearch();

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
		createCMepisodePage.addEpisodeDetails(userprofilename);
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSaveEpisode();
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
		Thread.sleep(5000);
		String cmEpisodeID = worklists.getEpisodeID(MemberLastname_Firstname[0]);
		logger.info(cmEpisodeID);
		worklists.clickCM(MemberLastname_Firstname[0]);
		worklists.assigntoself();

		// Episode overview Page details

		Episodeoverviewpage episodeoverviewpage = new Episodeoverviewpage(driver);

		Assert.assertEquals(episodeoverviewpage.verifyactivityAdded(), "Verbal consent to be received",
				"Activity Added to the list");
		Thread.sleep(10000);

		episodeoverviewpage.openActivities();

		// Episode activities Page details

		Episodeactivitiespage episodeactivitiespage = new Episodeactivitiespage(driver);
		Assert.assertEquals(true, episodeactivitiespage.verify_OpenInteractionRecordVisible(userprofilename),
				"Open activity available");
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 1st interaction details
		AddInteractionsPage addInteractionsPage = new AddInteractionsPage(driver);
		addInteractionsPage.add1stInteractionforUTC();
		addInteractionsPage.clickSaveInteraction();

		// Calender Page details
		dashboard.clickCalender();
		CalenderPage calenderPage = new CalenderPage(driver);
		Assert.assertEquals(true, calenderPage.verifyCalenderRecord(memberfullname),
				"Member record appeared in Calender");

		dashboard.clickMenu();
		//dashboard.clickManageEpisodes();
		dashboard.clickMemberSearch();
		memberSearchPage.clickAdvSearch();
		memberSearchPage.enterMemberLastname(MemberLastname_Firstname[0]);
		memberSearchPage.enterMemberFirstname(MemberLastname_Firstname[1]);
		memberSearchPage.clickSearchinAdvancedSearch();
		
		confirmAddepisodePage.clickRedirecttoMCV();
		
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);
		memberOverviewPage.clickGear(cmEpisodeID);
		memberOverviewPage.openEpisode();
		
		memberOverviewPage.sleep(5000);
		
		episodeoverviewpage.openActivities();
		
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 2nd interaction details
		addInteractionsPage.add2ndInteractionforUTC();
		addInteractionsPage.clickSaveInteraction();
		Assert.assertEquals(true, episodeactivitiespage.verify_ClosedInteractionRecordVisible(userprofilename),
				"Closed interaction available");
		
		
		episodeactivitiespage.clickCM();
		Thread.sleep(10000);
		episodeoverviewpage.openCorrespondence();
		Assert.assertEquals(true,episodeoverviewpage.verify_UTCletterGenerated(userprofilename),"UTC letter generated");
		
		//Thread.sleep(10000);
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickActivities();
		episodeactivitiespage.clickAddActivity();
		episodeactivitiespage.enterActivityDetails();
		
		Assert.assertEquals(true, episodeactivitiespage.verify_OpenActivityRecordVisible(userprofilename),
				"Review for Contact Open activity available");
		
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickModifyActivity();
		episodeactivitiespage.modifyActivityDetails();
		episodeactivitiespage.clickClosedActivities();
		
		Assert.assertEquals(true, episodeactivitiespage.verify_ClosedActivityRecordVisible(userprofilename),
				"Review for Contact Closed activity available");
		
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickChangeStatus();
		
		// Change status page details
		
		ChangeStatusPage changeStatusPage = new ChangeStatusPage(driver);
		changeStatusPage.changeStatusDetails();
		
		Assert.assertEquals(true, episodeactivitiespage.verifyEpisodeStatus_Closed(userprofilename),
				"Closed episode successfully");
		
		// Closing the browser
		//closeBrowser(driver);


	}
}
