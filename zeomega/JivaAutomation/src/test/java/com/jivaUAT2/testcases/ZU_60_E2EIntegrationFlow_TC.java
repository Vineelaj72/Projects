package com.jivaUAT2.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.utils.TestBase;
import com.jiva.TestData.AddressFileInput;
import com.jiva.TestData.CoverageFileInput;
import com.jiva.TestData.DemographicFileInput;
import com.jiva.TestData.PhoneFileInput;
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

public class ZU_60_E2EIntegrationFlow_TC extends TestBase {
	private static Logger logger = Logger.getLogger(ZU_60_E2EIntegrationFlow_TC.class);
	private WebDriver driver;
	private String sTestcaseName = null;
	
	private int lineNumber=1;
	private ArrayList<String> MemberDemographicData;
	private ArrayList<String> MemberAddressData;
	private ArrayList<String> MemberPhoneData;
	private ArrayList<String> MemberCoverageData;	
	
	private MemberOverviewPage memberOverviewPage=null;
	private String sUSERPROFILENAME=null;
	
	
//	@Parameters({"linenumber"})
	@BeforeMethod(description = "Read the Member data files and perform Member Search with Member ID")
		public void verify_MemberSearch(/*String linenumber*/) throws IOException, InterruptedException {
		
		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for --- " + sTestcaseName);		
		
		// ----- Member Demographic file data -----
		MemberDemographicData =DemographicFileInput.mandatoryCheckPoints(MEMBERDEMOGRAPHICFILENAME,lineNumber/*Integer.parseInt(linenumber)*/);   
		logger.info("Member Demographic File Data "+MemberDemographicData);
		
		// ----- Member Address file data -----
		MemberAddressData = AddressFileInput.addressFileCode(MEMBERADDRESSFILENAME, MemberDemographicData.get(ENROLLMENTID)); 
		logger.info("Member Address File Data "+MemberAddressData);	
		
		// ----- Member Phone file data -----
		MemberPhoneData = PhoneFileInput.phoneFileCode(MEMBERPHONEFILENAME,MemberDemographicData.get(ENROLLMENTID));  
		logger.info("Member Phone File Data "+MemberPhoneData);
		
		// ----- Member Coverage file data -----
		MemberCoverageData = CoverageFileInput.coverageFileCode(MEMBERCOVERAGEFILENAME,MemberDemographicData.get(ENROLLMENTID));  
		logger.info("Member Coverage File Data "+MemberCoverageData);
				
		// ----- Initialize browser and open the application url	-----
		driver = initializeDriver(BROWSER); 		
		openurl(driver, JivaUAT2URL);

		// ----- Enter the Login details -----
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(USERNAME);
		loginPage.enterPassword(PASSWORD);
		loginPage.loginbutton();
		
		// ----- Capture User profile name and Member name details -----
		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(), "Logged in Sucessfully");
		sUSERPROFILENAME = dashboard.getuserprofilename();
		logger.info("User Profile Name is " + sUSERPROFILENAME);
		String[] UserFullname = sUSERPROFILENAME.split(",");
		logger.info("User Last name " + UserFullname[0]);
		logger.info("User First name " + UserFullname[1]);
		logger.info("Member Last name "+MemberDemographicData.get(LASTNAME));
		logger.info("Member First name "+MemberDemographicData.get(FIRSTNAME));			
		
		// ----- Perform Member Search with Member ID -----
		dashboard.clickMenu();
		dashboard.clickMemberSearch();		
		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.enterMemberId(MemberDemographicData.get(ALTERNATEID));				
		memberSearchPage.clickMainSearch();
		
	}
		
	public void customReport(String ExpectedResult, String ActualResult, String message)
	{
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		if(ExpectedResult.equalsIgnoreCase(ActualResult))
		{
			Reporter.log("Expected-"+ExpectedResult+"--Actual Result-"+ActualResult +message+"<br>");
			//assertEquals(ExpectedResult, ActualResult,message);
		}
		else
		{
		Reporter.log("<font color='red'>"+"Expected: "+ExpectedResult+" Actual: "+ActualResult+"Not equal "+"</font>");
		Assert.assertEquals(ExpectedResult, ActualResult,message);
		}

	
	}
	
	@Test(description = "Verify Member data from the files with screendata and execute ZU-60 flow for CCM-Unable to reach member")
	public void verify_MemberData_fromfile_toScreen_ZU_60Integrationflow() throws InterruptedException {
		
		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for --- " + sTestcaseName);		
		
		// ----- Verify the person availability and continue -----
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickRedirecttoMCV();			
		memberOverviewPage = new MemberOverviewPage(driver);	
		memberOverviewPage.sleep(3000);
		memberOverviewPage.expandMemberInfo();			
		By grayMemberBanner= By.xpath(".//*[@id='angularcontent']//div[contains(@class,'4d4d4d')]");	
		if(confirmAddepisodePage.isDisplayed(grayMemberBanner))
			Assert.assertFalse(true, "The person is deceased");
		else
			Assert.assertTrue(true, "The person is Alive and happy");
		
		// ----- Verify the file data with screen data -----
		String clientname = memberOverviewPage.getClientName();
		logger.info("Verifying the flow for the Client : "+clientname);
	//	Assert.assertEquals(MemberDemographicData.get(ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against demographic file");
		//Reporter.log("Expected- "+MemberDemographicData.get(ENROLLMENTID)+" , "+"Actual- "+memberOverviewPage.getCoverageId()+ "Member Coverage ID validated against demographic file");
		
		//---------------//
		customReport(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Validation1: Member Coverage ID validated against address file");
	//	Assert.assertEquals(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against address file");
		
		customReport(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getClientName(), "Member Coverage ID validated against address file");
		
		
		
		Assert.assertEquals(MemberCoverageData.get(CVRG_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Coverage file");
		
		Assert.assertEquals(MemberPhoneData.get(PHN_ENROLLMENTID), memberOverviewPage.getCoverageId(), "Member Coverage ID validated against Member Phone file");
		Assert.assertEquals(MemberPhoneData.get(PHONENUMBER), memberOverviewPage.getPhoneNumber(), "Member Phone Number validated against Member Phone file");		
		
		//MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);	
		/*memberOverviewPage.openMemberInformation();
		memberOverviewPage.sleep(5000);			
		Assert.assertEquals(MemberDemographicData.get(LASTNAME), memberOverviewPage.getMemberLastName(), "Member last name validated");
		Assert.assertEquals(MemberDemographicData.get(FIRSTNAME), memberOverviewPage.getMemberFirstName(), "Member first name validated");			
		Assert.assertEquals(MemberDemographicData.get(ALTERNATEID),memberOverviewPage.getAlternateId(),"Member alternate id validated");
		Assert.assertEquals(true,memberOverviewPage.getGender().contains(MemberDemographicData.get(GENDER)),"Member gender validated");		
		String DOBonscreen[] = memberOverviewPage.getMemberDOB().split("/");
		String DOBinFileFormat = DOBonscreen[2]+"-"+DOBonscreen[0]+"-"+DOBonscreen[1];	
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
		
		//memberOverviewPage.deActivate();
		
		// ----- Create Case Management Episode -----
		memberOverviewPage.clickAddEpisode();
		memberOverviewPage.clickCaseManagement();
		memberOverviewPage.similarEpisodeAlert();
		
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails(sUSERPROFILENAME);
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(), "Program added Sucessfully");
		createCMepisodePage.clickSaveEpisode();
		createCMepisodePage.invalidEpisodeCoverageAlert();
		logger.info("Verified creation of episode successfully");
		
		//memberOverviewPage.clickMemberOverview();
		

		// ----- Verify Activity added -----		
		memberOverviewPage.clickCurrentEpisodecogwheel();
		memberOverviewPage.openEpisode();			
		Episodeoverviewpage episodeoverviewpage = new Episodeoverviewpage(driver);
		Assert.assertEquals(episodeoverviewpage.verifyactivityAdded(), "Verbal consent to be received",
				"Activity Added to the list");
		episodeoverviewpage.openActivities();

		// ----- Enter Interaction details -----
		Episodeactivitiespage episodeactivitiespage = new Episodeactivitiespage(driver);
		Assert.assertEquals(true,episodeactivitiespage.verify_OpenInteractionRecordVisible(sUSERPROFILENAME),"Open interaction available");		
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// ----- Add 1st interaction details -----		
		AddInteractionsPage addInteractionsPage = new AddInteractionsPage(driver);
		addInteractionsPage.add1stInteractionforUTC();
		addInteractionsPage.clickSaveInteraction();
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickAddInteraction();

		// ----- Add 2nd interaction details -----	
		episodeactivitiespage.sleep(5000);
		addInteractionsPage.add2ndInteractionforUTC();
		addInteractionsPage.clickSaveInteraction();
		episodeactivitiespage.clickClosedActivities();
		Assert.assertEquals(true,episodeactivitiespage.verify_ClosedInteractionRecordVisible(sUSERPROFILENAME),"Closed interaction available");
		
		// ----- Verify UTC letter generation -----	
		episodeactivitiespage.clickCM();
		episodeactivitiespage.sleep(10000);
		episodeoverviewpage.openCorrespondence();
		Assert.assertEquals(true,episodeoverviewpage.verify_UTCletterGenerated(sUSERPROFILENAME),"UTC letter generated");
		
		// ----- Verify Activity Added and Closed -----	
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickActivities();
		episodeactivitiespage.clickAddActivity();
		episodeactivitiespage.enterActivityDetails();		
		Assert.assertEquals(true, episodeactivitiespage.verify_OpenActivityRecordVisible(sUSERPROFILENAME),
				"Review for Contact Open activity available");		
		episodeactivitiespage.clickCogwheel();
		episodeactivitiespage.clickModifyActivity();
		episodeactivitiespage.modifyActivityDetails();
		episodeactivitiespage.clickClosedActivities();		
		Assert.assertEquals(true, episodeactivitiespage.verify_ClosedActivityRecordVisible(sUSERPROFILENAME),
				"Review for Contact Closed activity available");
		
		// ----- Verify Episode Status Closed -----	
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickChangeStatus();		
		ChangeStatusPage changeStatusPage = new ChangeStatusPage(driver);
		changeStatusPage.changeStatusDetails();		
		Assert.assertEquals(true, episodeactivitiespage.verifyEpisodeStatus_Closed(sUSERPROFILENAME),
				"Closed episode successfully");
		
		// ----- Verify Program Status Closed -----	
		episodeoverviewpage.clickWorkflow();
		episodeoverviewpage.clickPrograms();		
		ProgramsPage programsPage = new ProgramsPage(driver);		
		Assert.assertEquals(true, programsPage.verify_ProgramClosed(),"Program is closed successfully");
		
		logger.info("Successfully completed validating member files integration flow of ZU-60_Unable to reach member");*/
		
		/*
		programsPage.clickMemberOverview();
		memberOverviewPage.clickCurrentEpisodecogwheel();
		memberOverviewPage.performDeactivateEpisode();		*/

	}
	
	
	@AfterMethod(description = "Close the browser")
	public void closeBrowser()
	{
		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for --- " + sTestcaseName);
		
		// ----- Close the browser -----
		closeBrowser(driver);
	}
	
}
			
	