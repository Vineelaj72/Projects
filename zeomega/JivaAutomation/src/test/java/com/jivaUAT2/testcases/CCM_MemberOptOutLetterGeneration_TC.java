package com.jivaUAT2.testcases;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jiva.OLDTestData.ReadAddressFile;
import com.jiva.OLDTestData.ReadMemberCoverageFile;
import com.jiva.OLDTestData.ReadMemberDemographicFile;
import com.jiva.OLDTestData.ReadPhoneDetails;
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
import com.framework.utils.TestBase;

public class CCM_MemberOptOutLetterGeneration_TC extends TestBase {
	private static Logger logger = Logger.getLogger(CCM_MemberOptOutLetterGeneration_TC.class);
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
	public void verify_MemberDatafromfile_toScreen_ZU_61flow() throws InterruptedException {

		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for--- " + sTestcaseName);

		driver = initializeDriver(BROWSER); 		// initialise browser and openurl
		openurl(driver, JivaUAT2URL);

		// Login Page details

		LoginPage login = new LoginPage(driver);
		login.enterUsername(USERNAME);
		login.enterPassword(PASSWORD);
		login.loginbutton();
		
		// Dashboard Page details

		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(), "Logged in Sucessfully");
		String userprofilename = dashboard.getuserprofilename();
		logger.info("User Profile Name is " + userprofilename);
		String[] UserFullname = userprofilename.split(",");
		logger.info("User Last name " + UserFullname[0]);
		logger.info("User First name " + UserFullname[1]);
		dashboard.clickMenu();
		dashboard.clickMemberSearch();

		// MemberSearch Page details

		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();		
		memberSearchPage.sleep(5000);		
		logger.info("Member Last name "+MemberDemographicData.get(LASTNAME));
		logger.info("Member First name "+MemberDemographicData.get(FIRSTNAME));		
		memberSearchPage.enterMemberLastname(MemberDemographicData.get(LASTNAME));
		memberSearchPage.enterMemberFirstname(MemberDemographicData.get(FIRSTNAME));
		memberSearchPage.clickSearchinAdvancedSearch();
		
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickRedirecttoMCV();
			
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);	
		memberOverviewPage.sleep(3000);
		memberOverviewPage.expandorhideMemberInfo();
		Assert.assertEquals(MemberDemographicData.get(ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against demographic file");
		Assert.assertEquals(MemberDemographicData.get(ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against demographic file");
		Assert.assertEquals(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against address file");
		Assert.assertEquals(MemberAddressData.get(ADDR_ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against address file");
		Assert.assertEquals(MemberPhoneData.get(PHN_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Member Phone file");
		Assert.assertEquals(MemberPhoneData.get(PHONENUMBER), memberOverviewPage.getPhoneNumber(), "Member Phone Number validated against Member Phone file");
		Assert.assertEquals(MemberPhoneData.get(PHN_ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against Member Phone file");
		Assert.assertEquals(MemberCoverageData.get(CVRG_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Coverage file");
		
		memberOverviewPage.openMemberInformation();
		memberOverviewPage.sleep(5000);			
		Assert.assertEquals(MemberDemographicData.get(LASTNAME), memberOverviewPage.getMemberLastName(), "Member last name validated");
		Assert.assertEquals(MemberDemographicData.get(FIRSTNAME), memberOverviewPage.getMemberFirstName(), "Member first name validated");			
		Assert.assertEquals(MemberDemographicData.get(ALTERNATEID),memberOverviewPage.getAlternateId(),"Member alternate id validated");					
		Assert.assertEquals(true,memberOverviewPage.getGender().contains(MemberDemographicData.get(GENDER)),"Member gender validated");
		logger.info("Member DOB on screen "+memberOverviewPage.getMemberDOB());
		String DOBonscreen[] = memberOverviewPage.getMemberDOB().split("/");
		String DOBinFileFormat = DOBonscreen[2]+"-"+DOBonscreen[0]+"-"+DOBonscreen[1];	
		logger.info("Member DOB on screen changed to File format "+DOBinFileFormat);		
		Assert.assertEquals(MemberDemographicData.get(DOB),DOBinFileFormat,"Member DOB validated");  
		
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
				
		memberOverviewPage.sleep(5000);
		memberOverviewPage.closeMemberInfo();
		memberOverviewPage.expandorhideMemberInfo();
		
		memberOverviewPage.clickAddEpisode();
		memberOverviewPage.clickCaseManagement();
		memberOverviewPage.similarEpisodeAlert();
		
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails(userprofilename);
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSaveEpisode();
		logger.info("Verified creation of episode successfully");

		// Worklists page details

		WorklistsPage worklists = new WorklistsPage(driver);				
		memberOverviewPage.clickCurrentEpisodecogwheel();
		memberOverviewPage.openEpisode();				
		//worklists.assigntoself();  -- assign to self if it is not assigned to you

		// Episode overview Page details
		
		Episodeoverviewpage episodeoverviewpage = new Episodeoverviewpage(driver);
		Assert.assertEquals(episodeoverviewpage.verifyactivityAdded(), "Verbal consent to be received",
				"Activity Added to the list");
		episodeoverviewpage.openActivities();

		// Episode activities Page details

		Episodeactivitiespage episodeactivitiespage = new Episodeactivitiespage(driver);
		Assert.assertEquals(true,episodeactivitiespage.verify_OpenInteractionRecordVisible(userprofilename),"Open interaction available");
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 1st interaction details
		
		AddInteractionsPage addInteractionsPage = new AddInteractionsPage(driver);
		addInteractionsPage.add1stInteractionforMemberOptsOut();
		addInteractionsPage.clickSaveInteraction();

		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 2nd interaction details
		episodeactivitiespage.sleep(5000);
		addInteractionsPage.add2ndInteractionforMemberOptsOut(userprofilename);
		addInteractionsPage.clickSaveInteraction();
		
		addInteractionsPage.episodeOpenActivitiesAlert();				
		addInteractionsPage.sleep(5000);
		episodeactivitiespage.clickCM();
		episodeactivitiespage.sleep(10000);
		episodeoverviewpage.openCorrespondence();
		//Assert.assertEquals(true,episodeoverviewpage.verify_CM_PCP_Mbr_Opt_OutLetterGenerated(userprofilename),"Member Opts out letter generated to PCP");
		Assert.assertEquals(true,episodeoverviewpage.verify_CM_Mbr_Opt_OutLetterGenerated(userprofilename),"Member Opts out letter generated to Member");
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickPrograms();
		
		ProgramsPage programsPage = new ProgramsPage(driver);		
		Assert.assertEquals(true, programsPage.verify_ProgramClosed(),"Program is closed successfully");
		
		logger.info("Successfully completed validating member files integration flow of ZU-61_CCM_Member Opts out");
		

		programsPage.clickMemberOverview();
		memberOverviewPage.clickCurrentEpisodecogwheel();
		memberOverviewPage.performDeactivateEpisode();		
		
		// Closing the browser
		closeBrowser(driver);
		
		
		
	}

}
