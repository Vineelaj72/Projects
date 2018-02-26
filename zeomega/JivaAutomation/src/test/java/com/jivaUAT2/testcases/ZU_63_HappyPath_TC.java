package com.jivaUAT2.testcases;

import java.io.IOException;
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
import com.jiva.TestData.AddressFileInput;
import com.jiva.TestData.CoverageFileInput;
import com.jiva.TestData.DemographicFileInput;
import com.jiva.TestData.PhoneFileInput;
import com.jiva.pages.AcceptPOCPage;
import com.jiva.pages.AddInteractionsPage;
import com.jiva.pages.AssessmentsPage;
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

public class ZU_63_HappyPath_TC extends TestBase {
	private static Logger logger = Logger.getLogger(ZU_60_HappyPath_TC.class);
	private WebDriver driver;
	private String sTestcaseName = null;
	
	private ArrayList<String> MemberDemographicData;
	int ENROLLMENTID=0,ALTERNATEID=1,LASTNAME=2,FIRSTNAME=3,DOB=4,ACTIVESTATUS=5,GENDER=6;	
	
	private int lineNumber=1;
	
	private ArrayList<String> MemberAddressData;	
	int ADDR_ENROLLMENTID=0,HOME_ADDRESSTYPE=1,HOME_ADDRESS1=2,HOME_CITY=3,HOME_STATE=4,HOME_ZIP=5,HOME_COUNTRY=6;
	int PRIMARY_ADDRESSTYPE=8,PRIMARY_ADDRESS1=9,PRIMARY_CITY=10,PRIMARY_STATE=11,PRIMARY_ZIP=12,PRIMARY_COUNTRY=13;
	
	private ArrayList<String> MemberPhoneData;
	int PHN_ENROLLMENTID=0,PHONENUMBER=1;
	
	private ArrayList<String> MemberCoverageData;
	int CVRG_ENROLLMENTID=0;
	
	
	@BeforeClass
	public void dataSetup() throws IOException {
			
		MemberDemographicData =DemographicFileInput.mandatoryCheckPoints(MEMBERDEMOGRAPHICFILENAME,lineNumber);   // demographic file
		logger.info("Member Demographic File Data "+MemberDemographicData);
		
		MemberAddressData = AddressFileInput.addressFileCode(MEMBERADDRESSFILENAME, MemberDemographicData.get(ENROLLMENTID));  //Address File
		logger.info("Member Address File Data "+MemberAddressData);	
		
		MemberPhoneData = PhoneFileInput.phoneFileCode(MEMBERPHONEFILENAME,MemberDemographicData.get(ENROLLMENTID));   //Phone file
		logger.info("Member Phone File Data "+MemberPhoneData);
		
		MemberCoverageData = CoverageFileInput.coverageFileCode(MEMBERCOVERAGEFILENAME,MemberDemographicData.get(ENROLLMENTID));  //Coverage File
		logger.info("Member Coverage File Data "+MemberCoverageData);
	}
	
		
	@Test(description = "Verify Member data from the files with screendata and execute ZU-60 flow for CCM-Unable to reach member")
	public void verify_MemberDatafromfile_toScreen_ZU_60flow() throws InterruptedException {

		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for--- " + sTestcaseName);
		
		// initialise browser and openurl
		
		driver = initializeDriver(BROWSER); 		
		openurl(driver, JivaUAT2URL);

		// Login Page details

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(USERNAME);
		loginPage.enterPassword(PASSWORD);
		loginPage.loginbutton();
		
	

		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(), "Logged in Sucessfully");
		String userprofilename = dashboard.getuserprofilename();
		logger.info("User Profile Name is " + userprofilename);
		String[] UserFullname = userprofilename.split(",");
		logger.info("User Last name " + UserFullname[0]);
		logger.info("User First name " + UserFullname[1]);
		logger.info("Member Last name "+MemberDemographicData.get(LASTNAME));
		logger.info("Member First name "+MemberDemographicData.get(FIRSTNAME));		
		dashboard.clickMenu();
		dashboard.clickMemberSearch();
		
		// MemberSearch Page details
		
		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.enterMemberId(MemberDemographicData.get(ALTERNATEID));
		
		memberSearchPage.clickMainSearch();;
		
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickRedirecttoMCV();
		
		/*By deadColor= By.xpath(".//*[@id='angularcontent']//div[contains(@class,'4d4d4d')]");
		confirmAddepisodePage.getAttribute(deadColor).contains("4d4d4d"))*/		
		
		
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);	
		memberOverviewPage.sleep(3000);
		memberOverviewPage.expandMemberInfo();	
		String clientname = memberOverviewPage.getClientName();
		logger.info("Verifying the flow for the Client : "+clientname);
		Assert.assertEquals(MemberDemographicData.get(ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against demographic file");
		//Assert.assertEquals(MemberDemographicData.get(ACTIVESTATUS), memberOverviewPage.getActiveStatus(), "Member Active Status validated against demographic file");
		Assert.assertEquals(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against address file");
		Assert.assertEquals(MemberPhoneData.get(PHN_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Member Phone file");
		Assert.assertEquals(MemberPhoneData.get(PHONENUMBER), memberOverviewPage.getPhoneNumber(), "Member Phone Number validated against Member Phone file");
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
		memberOverviewPage.expandMemberInfo();

		memberOverviewPage.clickAddEpisode();
		memberOverviewPage.clickCaseManagement();
		memberOverviewPage.similarEpisodeAlert();

		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails(userprofilename);
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSaveandContinueEpisode();
		createCMepisodePage.invalidEpisodeCoverageAlert();

		// Episode overview Page details

		Episodeoverviewpage episodeoverviewpage = new Episodeoverviewpage(driver);
		Assert.assertEquals(episodeoverviewpage.verifyactivityAdded(), "Verbal consent to be received",
				"Activity Added to the list");
		episodeoverviewpage.openActivities();

		// Episode activities Page details

		Episodeactivitiespage episodeactivitiespage = new Episodeactivitiespage(driver);
		Assert.assertEquals(true, episodeactivitiespage.verify_OpenInteractionRecordVisible(userprofilename),
				"Open interaction available");

		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// Add 1st interaction details

		AddInteractionsPage addInteractionsPage = new AddInteractionsPage(driver);

		addInteractionsPage.add1stInteractionforCCM(userprofilename);
		addInteractionsPage.clickSaveInteraction();
		addInteractionsPage.changingAssignedUserAlert();	
		addInteractionsPage.sleep(5000);
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickAssessments();

		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.selectDefaultAssessment();
		assessmentsPage.startDefaultAssessment();
		assessmentsPage.answerAssessmentQuestions();
		assessmentsPage.completeAssessment();

		AcceptPOCPage acceptPOCPage = new AcceptPOCPage(driver);
		acceptPOCPage.managePOCDetails();
		acceptPOCPage.sleep(5000);
		acceptPOCPage.closePOCWindow();
		episodeoverviewpage.clickWorkflow();
		acceptPOCPage.sleep(5000);
		episodeoverviewpage.clickChangeStatus();

		ChangeStatusPage changeStatusPage = new ChangeStatusPage(driver);
		changeStatusPage.changeStatusDetailsforIdentifiedNeeds();
		changeStatusPage.existingOpenActivitiesforEpisodeAlert();
		changeStatusPage.sleep(5000);

		episodeoverviewpage.clickHamBurger();
		episodeoverviewpage.clickCorrespondence();
		Assert.assertEquals(true, episodeoverviewpage.verify_CM_PostEnrollmentLetterGenerated(userprofilename),
				"Post Enrollment Letter Generated");

		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickPrograms();

		ProgramsPage programsPage = new ProgramsPage(driver);
		Assert.assertEquals(true, programsPage.verify_ProgramClosed(), "Program is closed successfully");

		logger.info("Successfully completed validating integration flow of ZU-63_CCM_Member_Identified Needs/Goals Have Been Met for the member in line #"+lineNumber+" holding the Member Id: "+MemberDemographicData.get(ALTERNATEID)+" and for the client: "+clientname);

		programsPage.clickMemberOverview();
		memberOverviewPage.clickCurrentEpisodecogwheel();
		memberOverviewPage.performDeactivateEpisode();		
		
		// Closing the browser
		closeBrowser(driver);
		

	}

}
