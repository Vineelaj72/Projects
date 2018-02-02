package com.jiva.testcases;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jiva.TestData.ReadMemberDemographicFile;
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
import com.jiva.utils.TestBase;

public class E2EintegrationflowforMemberDemographicflowTC_ZU_60 extends TestBase {
	private static Logger logger = Logger.getLogger(E2EintegrationflowforMemberDemographicflowTC_ZU_60.class);
	WebDriver driver;
	private String sTestcaseName = null;
	private ArrayList<String> MemberDemographicData;
	//int ENROLLMENTID=7,ALTERNATEID=8,LASTNAME=9,FIRSTNAME=10,DOB=11,ACTIVESTATUS=12,GENDER=13;
	int ENROLLMENTID=0,ALTERNATEID=1,LASTNAME=2,FIRSTNAME=3,DOB=4,ACTIVESTATUS=5,GENDER=6;
	
	@BeforeClass
	public void dataSetup() {
		MemberDemographicData =ReadMemberDemographicFile.mandatoryCheckPoints(MEMBERDEMOGRAPHICFILENAME); // demographic file
		logger.info("Member Demographic File Data "+MemberDemographicData);
	}
	
	@Test(description = "Verify Demographic data from the file with screendata")
	public void verify_Demographics_Datafromfile_toScreen() throws InterruptedException {

		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for--- " + sTestcaseName);

		driver = initializeDriver(BROWSER); 		// initialise browser and openurl
		openurl(driver, AutomationURL);

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
		
		logger.info("Member Last name "+MemberDemographicData.get(LASTNAME));
		logger.info("Member First name "+MemberDemographicData.get(FIRSTNAME));		
		memberSearchPage.enterMemberLastname(MemberDemographicData.get(LASTNAME));// Read Firstrecord lastname from the arraylist
		memberSearchPage.enterMemberFirstname(MemberDemographicData.get(FIRSTNAME));
		memberSearchPage.clickSearch();
		
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		Thread.sleep(5000);
		confirmAddepisodePage.clickRedirecttoMCV();
			
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);
	
		Thread.sleep(3000);
		Assert.assertEquals(MemberDemographicData.get(ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated");
		Assert.assertEquals(MemberDemographicData.get(ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated");
		
		memberOverviewPage.expandMemberInfo();
		memberOverviewPage.openMemberInformation();
		Thread.sleep(5000);
		
		Assert.assertEquals(MemberDemographicData.get(LASTNAME), memberOverviewPage.getMemberLastName(), "Member last name validated");
		Thread.sleep(5000);		
		Assert.assertEquals(MemberDemographicData.get(FIRSTNAME), memberOverviewPage.getMemberFirstName(), "Member first name validated");			
		Assert.assertEquals(MemberDemographicData.get(ALTERNATEID),memberOverviewPage.getAlternateId(),"Member alternate id validated");
		
		//Assert.assertEquals(demographichData.get(ALTRD),ymd,"Member DOB validated");       //doubt
		//Assert.assertEquals(true,memberOverviewPage.getMemberMaritalStatus().toLowerCase().contains(sFileData.get("MemberMaritalStatus3").toLowerCase()),"Member marital status validated");		
		Assert.assertEquals(true,memberOverviewPage.getGender().contains(MemberDemographicData.get(GENDER)),"Member gender validated");
		Thread.sleep(5000);
		memberOverviewPage.closeMemberInfo();
		memberOverviewPage.expandMemberInfo();
		
		memberOverviewPage.clickAddEpisode();
		memberOverviewPage.clickCaseManagement();
		
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails();
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSave();
		//Assert.assertEquals(true, createCMepisodePage.verifyEpidodeAdded(), "Episode added Sucessfully");
		// System.out.println("Verified creation of episode successfully");
		logger.info("Verified creation of episode successfully");

		// Worklists page details

		WorklistsPage worklists = new WorklistsPage(driver);
				
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
