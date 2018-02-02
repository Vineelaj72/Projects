package com.jiva.testcases;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jiva.TestData.ReadAddressFile;
import com.jiva.TestData.ReadMemberCoverageFile;
import com.jiva.TestData.ReadMemberDemographicFile;
import com.jiva.TestData.ReadPhoneDetails;
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
import com.jiva.pages.ProgramsPage;
import com.jiva.pages.WorklistsPage;
import com.jiva.utils.TestBase;

public class E2EintegrationflowTC_ZU_61 extends TestBase {
	private static Logger logger = Logger.getLogger(E2EintegrationflowTC_ZU_60.class);
	WebDriver driver;
	private String sTestcaseName = null;
	
	private ArrayList<String> MemberDemographicData;
	int ENROLLMENTID=0,ALTERNATEID=1,LASTNAME=2,FIRSTNAME=3,DOB=4,ACTIVESTATUS=5,GENDER=6;
	
	private ArrayList<String> MemberAddressData;	
	int ADDR_ENROLLMENTID=0,HOME_ADDRESSTYPE=1,HOME_ADDRESS1=2,HOME_CITY=3,HOME_STATE=4,HOME_ZIP=5,HOME_COUNTRY=6,ADDR_ACTIVESTATUS=7,PRIMARY_ADDRESSTYPE=9,PRIMARY_ADDRESS1=10,PRIMARY_CITY=11,PRIMARY_STATE=12,PRIMARY_ZIP=13,PRIMARY_COUNTRY=14;
	
	private ArrayList<String> MemberPhoneData;
	int PHN_ENROLLMENTID=0,PHONENUMBER=1,PHN_ACTIVESTATUS=2;
	
	private ArrayList<String> MemberCoverageData;
	int CVRG_ENROLLMENTID=0;
	
	@BeforeClass
	public void dataSetup() {
		MemberDemographicData =ReadMemberDemographicFile.mandatoryCheckPoints(MEMBERDEMOGRAPHICFILENAME); // demographic file
		logger.info("Member Demographic File Data "+MemberDemographicData);
	
		MemberAddressData =ReadAddressFile.mandatoryCheckPoints(MEMBERADDRESSFILENAME); // address file
		logger.info("Member Address File Data "+MemberAddressData);
		
		MemberPhoneData = ReadPhoneDetails.mandatoryCheckPoints(MEMBERPHONEFILENAME); //Phone file
		logger.info("Member Phone File Data "+MemberPhoneData);
		
		MemberCoverageData = ReadMemberCoverageFile.mandatoryCheckPoints(MEMBERCOVERAGEFILENAME); //Coverage File
		logger.info("Member Coverage File Data "+MemberCoverageData);
	}
	

	@Test(description = "Verify Member data from the files with screendata and execute ZU-61 flow for CCM-Member Opts out")
	public void verify_MemberDatafromfile_toScreen() throws InterruptedException {

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
		memberOverviewPage.expandMemberInfo();
		
		logger.info(MemberDemographicData.get(ENROLLMENTID));
		logger.info(memberOverviewPage.getCoverageId());
		
		Assert.assertEquals(MemberDemographicData.get(ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against demographic file");
		Assert.assertEquals(MemberDemographicData.get(ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against demographic file");
		Assert.assertEquals(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against address file");
		Assert.assertEquals(MemberAddressData.get(ADDR_ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against address file");
		Assert.assertEquals(MemberPhoneData.get(PHN_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Member Phone file");
		Assert.assertEquals(MemberPhoneData.get(PHONENUMBER), memberOverviewPage.getPhoneNumber(), "Member Phone Number validated against Member Phone file");
		Assert.assertEquals(MemberPhoneData.get(PHN_ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against Member Phone file");
		Assert.assertEquals(MemberCoverageData.get(CVRG_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Coverage file");
		
		//memberOverviewPage.expandMemberInfo();
		memberOverviewPage.openMemberInformation();
		Thread.sleep(5000);
		
		Assert.assertEquals(MemberDemographicData.get(LASTNAME), memberOverviewPage.getMemberLastName(), "Member last name validated");
		//Thread.sleep(5000);		
		Assert.assertEquals(MemberDemographicData.get(FIRSTNAME), memberOverviewPage.getMemberFirstName(), "Member first name validated");			
		Assert.assertEquals(MemberDemographicData.get(ALTERNATEID),memberOverviewPage.getAlternateId(),"Member alternate id validated");		
		//Assert.assertEquals(MemberDemographicData.get(DOB),memberOverviewPage.getMemberDOB(),"Member DOB validated");       //doubt			
		Assert.assertEquals(true,memberOverviewPage.getGender().contains(MemberDemographicData.get(GENDER)),"Member gender validated");
		
		Assert.assertEquals(MemberAddressData.get(HOME_ADDRESSTYPE).toUpperCase(),memberOverviewPage.getHomeAddressType(),"Home Address type validated");		
		Assert.assertEquals(MemberAddressData.get(HOME_ADDRESS1),memberOverviewPage.getHomeAddressline1(),"Home Address line 1 validated");		
		Assert.assertEquals(MemberAddressData.get(HOME_CITY),memberOverviewPage.getHomeCity(),"Home city validated");
		Assert.assertEquals(MemberAddressData.get(HOME_STATE),memberOverviewPage.getHomeState(),"Home state validated");
		Assert.assertEquals(MemberAddressData.get(HOME_ZIP),memberOverviewPage.getHomeZip(),"Home Zip validated");
		Assert.assertEquals(MemberAddressData.get(HOME_COUNTRY),memberOverviewPage.getHomeCountry(),"Home country validated");
		
		Assert.assertEquals(MemberAddressData.get(PRIMARY_ADDRESSTYPE).toUpperCase(),memberOverviewPage.getPrimaryAddressType(),"PRIMARY Address type validated");		
		Assert.assertEquals(MemberAddressData.get(PRIMARY_ADDRESS1),memberOverviewPage.getPrimaryAddressline1(),"PRIMARY Address line 1 validated");		
		Assert.assertEquals(MemberAddressData.get(PRIMARY_CITY),memberOverviewPage.getPrimaryCity(),"PRIMARY city validated");
		Assert.assertEquals(MemberAddressData.get(PRIMARY_STATE),memberOverviewPage.getPrimaryState(),"PRIMARY state validated");
		Assert.assertEquals(MemberAddressData.get(PRIMARY_ZIP),memberOverviewPage.getPrimaryZip(),"PRIMARY Zip validated");
		Assert.assertEquals(MemberAddressData.get(PRIMARY_COUNTRY),memberOverviewPage.getPrimaryCountry(),"PRIMARY country validated");
				
		Thread.sleep(5000);
		memberOverviewPage.closeMemberInfo();
		memberOverviewPage.expandMemberInfo();
		
		memberOverviewPage.clickAddEpisode();
		memberOverviewPage.clickCaseManagement();
		
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails();
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSave();
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
		addInteractionsPage.add1stInteractionforMemberOptsOut();
		addInteractionsPage.clickSaveInteraction();

		episodeactivitiespage.clickWheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 2nd interaction details
		Thread.sleep(5000);
		addInteractionsPage.add2ndInteractionforMemberOptsOut(userprofilename);
		addInteractionsPage.clickSaveInteraction();
		
		addInteractionsPage.episodeOpenActivitiesAlert();
		
		/*Assert.assertEquals(true, episodeactivitiespage.verifyEpisodeStatus(),
				"Verified Episode status as Closed");*/
		
		Thread.sleep(5000);
		episodeactivitiespage.clickCM();
		Thread.sleep(10000);
		episodeoverviewpage.openCorrespondence();
		Assert.assertEquals(true,episodeoverviewpage.verify_CM_PCP_Mbr_Opt_OutLetterGenerated(userprofilename),"Member Opts out letter generated to PCP");
		Assert.assertEquals(true,episodeoverviewpage.verify_CM_Mbr_Opt_OutLetterGenerated(userprofilename),"Member Opts out letter generated to Member");
		
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickPrograms();
		
		ProgramsPage programsPage = new ProgramsPage(driver);		
		Assert.assertEquals(true, programsPage.verify_ProgramClosed(),"Program is closed successfully");
		
		logger.info("Successfully completed validating member files integration flow of ZU-61_CCM_Member Opts out");
		
		// Closing the browser
		//closeBrowser(driver);
		
		
	}

}
