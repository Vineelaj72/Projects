package com.jiva.testcases;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jiva.pages.AddInteractionsPage;
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
import com.jiva.utils.DateUtils;
import com.jiva.utils.MemberDemographicFile;
import com.jiva.utils.TestBase;

public class Map_DemographicDataValidation_TC extends TestBase {
	private static Logger logger = Logger.getLogger(Map_DemographicDataValidation_TC.class);
	WebDriver driver;
	private String sTestcaseName = null;
	private String sDateFormat;
	ArrayList<String> sFileName;
	Map<String, String> sFileData;
	@BeforeClass
	public void dataSetup() throws Exception {
		sDateFormat=DateUtils.ymdhmsTime();
	//	sFileName=FileUtils.listofFiles(SFILENAME, sDateFormat);
		sFileData = MemberDemographicFile.readdemographicFile(SFILENAME);
		//2.Location Wise pick
		//1. Read 6 Files and written 6 Arry

	}
	
	
	
	@Test(description = "Screen Data with Member Demographic File Data")
	public void verify_screenDataWithFileData() throws InterruptedException {

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
		logger.info("User Profile Name is " + userprofilename);
		String[] UserLastname_Firstname = userprofilename.split(",");
		logger.info("Last name " + UserLastname_Firstname[0]);
		logger.info("First name " + UserLastname_Firstname[1]);
		dashboard.clickMenu();
		dashboard.clickMemberSearch();

		// MemberSearch Page details

		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();
		
		Thread.sleep(5000);
		
		logger.info("Member Last name "+sFileData.get("MemberLastname3"));
		logger.info("Member First name "+sFileData.get("MemberFirstname3"));		
		memberSearchPage.enterMemberLastname(sFileData.get("MemberLastname3"));
		memberSearchPage.enterMemberFirstname(sFileData.get("MemberFirstname3"));
		memberSearchPage.clickSearch();
		
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		Thread.sleep(5000);
		confirmAddepisodePage.clickRedirecttoMCV();
			
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);
	
		Thread.sleep(3000);
		Assert.assertEquals(sFileData.get("EligibilityId3"), memberOverviewPage.getCoverageId(), "Member Coverage ID validated");
		
		memberOverviewPage.expandMemberInfo();
		memberOverviewPage.openMemberInformation();
		Thread.sleep(5000);
		
		Assert.assertEquals(sFileData.get("MemberLastname3"), memberOverviewPage.getMemberLastName(), "Member last name validated");
		Thread.sleep(5000);		
		Assert.assertEquals(sFileData.get("MemberFirstname3"), memberOverviewPage.getMemberFirstName(), "Member first name validated");			
		Assert.assertEquals(sFileData.get("MemberId3"),memberOverviewPage.getAlternateId(),"Member alternate id validated");
		
		/*SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(memberOverviewPage.getMemberDOB());
		System.out.println(ymd);
		
		Assert.assertEquals(sFileData.get("MemberDOB3"),ymd,"Member DOB validated"); */      //doubt
		
		Assert.assertEquals(true,memberOverviewPage.getMemberMaritalStatus().toLowerCase().contains(sFileData.get("MemberMaritalStatus3").toLowerCase()),"Member marital status validated");		
		Assert.assertEquals(true,memberOverviewPage.getGender().contains(sFileData.get("MemberGender3")),"Member gender validated");
		Thread.sleep(5000);
		memberOverviewPage.closeMemberInfo();
		memberOverviewPage.expandMemberInfo();
		
		memberOverviewPage.clickAddEpisode();
		memberOverviewPage.clickCaseManagement();
		
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails();
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSaveEpisode();
		//Assert.assertEquals(true, createCMepisodePage.verifyEpidodeAdded(), "Episode added Sucessfully");
		// System.out.println("Verified creation of episode successfully");
		logger.info("Verified creation of episode successfully");

		// Worklists page details

		WorklistsPage worklists = new WorklistsPage(driver);
		/*dashboard.clickWorklists();
		worklists.clickCCMreferral();
		worklists.clickAdvanceSearch();
		Thread.sleep(5000);
		worklists.enterLastName(sFileData.get("MemberLastname3"));
		Thread.sleep(5000);
		worklists.enterFirstName(sFileData.get("MemberFirstname3"));
		worklists.clickSearchButton();
		Thread.sleep(5000);
		String cmEpisodeID = worklists.getEpisodeID(sFileData.get("MemberLastname3"));
		logger.info(cmEpisodeID);
		worklists.clickCM(sFileData.get("MemberLastname3"));*/
		
		memberOverviewPage.clickCurrentEpisodecogwheel();
		memberOverviewPage.openEpisode();
		
		
		worklists.assigntoself();

		// Episode overview Page details

		Episodeoverviewpage episodeoverviewpage = new Episodeoverviewpage(driver);

		Assert.assertEquals(episodeoverviewpage.verifyactivityAdded(), "Verbal consent to be received",
				"Activity Added to the list");

		episodeoverviewpage.openActivities();

		// Episode activities Page details

		Episodeactivitiespage episodeactivitiespage = new Episodeactivitiespage(driver);
		Assert.assertEquals(true,episodeactivitiespage.verify_OpenorClosedInteractionRecordVisible(),"Open interaction available");
		
		episodeactivitiespage.clickWheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 1st interaction details
		
		AddInteractionsPage addInteractionsPage = new AddInteractionsPage(driver);
		addInteractionsPage.add1stInteractionforUTC();
		addInteractionsPage.clickSaveInteraction();

		// Calender Page details
		/*
		 * dashboard.clickCalender(); CalenderPage calenderPage = new
		 * CalenderPage(driver); Assert.assertEquals(true,
		 * calenderPage.verifyCalenderRecord(memberfullname)
		 * ,"Member record appeared in Calender");
		 */

		episodeactivitiespage.clickWheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 2nd interaction details
		Thread.sleep(5000);
		addInteractionsPage.add2ndInteractionforUTC();
		addInteractionsPage.clickSaveInteraction();
		episodeactivitiespage.clickClosedActivities();
		Assert.assertEquals(true,episodeactivitiespage.verify_OpenorClosedInteractionRecordVisible(),"Closed interaction available");
		
		
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
		
		episodeactivitiespage.clickWheel();
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
