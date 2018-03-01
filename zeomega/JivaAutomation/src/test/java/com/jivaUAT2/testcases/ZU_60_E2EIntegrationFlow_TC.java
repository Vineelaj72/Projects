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

public class ZU_60_E2EIntegrationFlow_TC extends TestBase {
	private static Logger logger = Logger.getLogger(ZU_60_E2EIntegrationFlow_TC.class);
	private WebDriver driver;
	private String sTestcaseName = null;
	
	private int linenumber=2;
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
		MemberDemographicData =DemographicFileInput.mandatoryCheckPoints(MEMBERDEMOGRAPHICFILENAME,linenumber/*Integer.parseInt(linenumber)*/);   
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
		
		
	@Test(description = "Verify Member data from the files with screendata and execute ZU-60 flow for CCM-Unable to reach member")
	public void verify_MemberData_fromfile_toScreen_ZU_60Integrationflow() throws InterruptedException {
		
		sTestcaseName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for --- " + sTestcaseName);		
		
		// ----- Verify the person availability and continue -----
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickRedirecttoMCV();			
		memberOverviewPage = new MemberOverviewPage(driver);	
		memberOverviewPage.sleep(3000);
		memberOverviewPage.expandorhideMemberInfo();			
		By grayMemberBanner= By.xpath(".//*[@id='angularcontent']//div[contains(@class,'4d4d4d')]");	
		if(confirmAddepisodePage.isDisplayed(grayMemberBanner))
			Assert.assertFalse(true, "The person is deceased");
		else
			Assert.assertTrue(true, "The person is Alive and happy");
		
		// ----- Verify the file data with screen data -----
		String clientname = memberOverviewPage.getClientName();
		logger.info("Verifying the flow for the Client : "+clientname);
		Reporter.log("Started execution for integration flow of #ZU-60_Unable to reach member# for the member in line #"+linenumber+" holding the Member Id: "+MemberDemographicData.get(ALTERNATEID)+" and for the client: "+clientname+"<br>");
	
		customReport(MemberDemographicData.get(ENROLLMENTID), memberOverviewPage.getCoverageId(), " Validation 1: Member Coverage ID validated against demographic file");
		customReport(MemberAddressData.get(ADDR_ENROLLMENTID), memberOverviewPage.getCoverageId(), " Validation 2: Member Coverage ID validated against address file");
		customReport(MemberCoverageData.get(CVRG_ENROLLMENTID), memberOverviewPage.getCoverageId(), " Validation 3: Member Coverage ID validated against Coverage file");
		customReport(MemberPhoneData.get(PHN_ENROLLMENTID), memberOverviewPage.getCoverageId(), " Validation 4: Member Coverage ID validated against Member Phone file");
		customReport(MemberPhoneData.get(PHONENUMBER), memberOverviewPage.getPhoneNumber(), " Validation 5: Member Phone Number validated against Member Phone file");		
				
		memberOverviewPage.openMemberInformation();
		memberOverviewPage.sleep(5000);	
		
		customReport(MemberDemographicData.get(LASTNAME), memberOverviewPage.getMemberLastName(), " Validation 6: Member last name validated");
		customReport(MemberDemographicData.get(FIRSTNAME), memberOverviewPage.getMemberFirstName(), " Validation 7: Member first name validated");			
		customReport(MemberDemographicData.get(ALTERNATEID),memberOverviewPage.getAlternateId()," Validation 8: Member alternate id validated");
		customReport(true, memberOverviewPage.getGender().contains(MemberDemographicData.get(GENDER))," Validation 9: Member gender validated");
		String DOBonscreen[] = memberOverviewPage.getMemberDOB().split("/");
		String DOBinFileFormat = DOBonscreen[2]+"-"+DOBonscreen[0]+"-"+DOBonscreen[1];	
		customReport(MemberDemographicData.get(DOB),DOBinFileFormat," Validation 10: Member DOB validated");  
		
		customReport(MemberAddressData.get(HOME_ADDRESSTYPE).toUpperCase(),memberOverviewPage.getHomeAddressType()," Validation 11: Home Address type validated");		
		customReport(MemberAddressData.get(HOME_ADDRESS1),memberOverviewPage.getHomeAddressline1()," Validation 12: Home Address line 1 validated");		
		customReport(MemberAddressData.get(HOME_CITY),memberOverviewPage.getHomeCity()," Validation 13: Home city validated");
		customReport(MemberAddressData.get(HOME_STATE),memberOverviewPage.getHomeState()," Validation 14: Home state validated");
		customReport(MemberAddressData.get(HOME_ZIP),memberOverviewPage.getHomeZip()," Validation 15: Home Zip validated");
		customReport(MemberAddressData.get(HOME_COUNTRY),memberOverviewPage.getHomeCountry()," Validation 16: Home country validated");
		
		customReport(MemberAddressData.get(PRIMARY_ADDRESSTYPE).toUpperCase(),memberOverviewPage.getPrimaryAddressType()," Validation 17: PRIMARY Address type validated");		
		customReport(MemberAddressData.get(PRIMARY_ADDRESS1),memberOverviewPage.getPrimaryAddressline1()," Validation 18: PRIMARY Address line 1 validated");		
		customReport(MemberAddressData.get(PRIMARY_CITY),memberOverviewPage.getPrimaryCity()," Validation 19: PRIMARY city validated");
		customReport(MemberAddressData.get(PRIMARY_STATE),memberOverviewPage.getPrimaryState()," Validation 20: PRIMARY state validated");
		customReport(MemberAddressData.get(PRIMARY_ZIP),memberOverviewPage.getPrimaryZip()," Validation 21: PRIMARY Zip validated");
		customReport(MemberAddressData.get(PRIMARY_COUNTRY),memberOverviewPage.getPrimaryCountry()," Validation 22: PRIMARY country validated");		
		
		
		//memberOverviewPage.sleep(5000);
		memberOverviewPage.closeMemberInfo();
		memberOverviewPage.expandorhideMemberInfo();
		
		
		memberOverviewPage.deActivate();
		
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
		
		memberOverviewPage.clickMemberOverview();
		
		
		
	
		

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
		
		Reporter.log("Successfully completed validating integration flow of #ZU-60_Unable to reach member# for the member in line #"+linenumber+" holding the Member Id: "+MemberDemographicData.get(ALTERNATEID)+" and for the client: "+clientname);
		
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
			
	
