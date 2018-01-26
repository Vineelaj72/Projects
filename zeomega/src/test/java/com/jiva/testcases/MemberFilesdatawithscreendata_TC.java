package com.jiva.testcases;

import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.pages.ConfirmAddepisodePage;
import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberOverviewPage;
import com.jiva.pages.MemberSearchPage;
import com.jiva.utils.MemberDemographicFile;
import com.jiva.utils.TestBase;
import org.openqa.selenium.support.Color;

public class MemberFilesdatawithscreendata_TC extends TestBase {
	private static Logger logger = Logger.getLogger(MemberFilesdatawithscreendata_TC.class);
	WebDriver driver;
	private String sTestcaseName = null;

	@Test(description = "Member data validating with Screen data")
	public void verify_fileDatawithScreenData() throws InterruptedException {

		sTestcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for " + sTestcaseName);
		Map<String, String> sFileData = MemberDemographicFile.readdemographicFile(SFILENAME);

		// initialise browser and openurl

		driver = initializeDriver(BROWSER);
		openurl(driver, AutomationURL);
		maximizeBrowser(driver);

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
		memberSearchPage.enterMemberLastname(sFileData.get("MemberLastname3"));
		memberSearchPage.enterMemberFirstname(sFileData.get("MemberFirstname3"));
		memberSearchPage.clickSearch();

		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickRedirecttoMCV();
		
		//Validate the data against the screen
		
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);
		String coverageidvalue = memberOverviewPage.getCoverageId();
		String Phonenovalue = memberOverviewPage.getPhoneNumber();
		String activestatusvalue = memberOverviewPage.getActiveStatus();
		String lastnamevalue = memberOverviewPage.getMemberLastName();
		String firstnamevalue = memberOverviewPage.getMemberFirstName();
		String alternateidvalue = memberOverviewPage.getAlternateId();
		String memberDOBvalue = memberOverviewPage.getMemberDOB();
		String maritalstatusvalue = memberOverviewPage.getMemberMaritalStatus();
		String gendervalue = memberOverviewPage.getGender();
		
		String HOMEzipvalue = memberOverviewPage.gethomezip();
		String HOMEcityvalue = memberOverviewPage.gethomecity();
		String HOMEaddressline1value = memberOverviewPage.gethomeaddressline1();
		String HOMEaddressline2value = memberOverviewPage.gethomeaddressline2();
		String HOMEstatevalue = memberOverviewPage.gethomestate();
		String HOMEcountryvalue = memberOverviewPage.gethomecountry();
		
		String PRIMARYzipvalue = memberOverviewPage.getprimaryzip();
		String PRIMARYcityvalue = memberOverviewPage.getprimarycity();
		String PRIMARYaddressline1value = memberOverviewPage.getprimaryaddressline1();
		String PRIMARYaddressline2value = memberOverviewPage.getprimaryaddressline2();
		String PRIMARYstatevalue = memberOverviewPage.getprimarystate();
		String PRIMARYcountryvalue = memberOverviewPage.getprimarycountry();
		
		
		Assert.assertEquals(sFileData.get("CoverageId3"),coverageidvalue,"Member coverage id validated");
		/*Assert.assertEquals(sFileData.get("PhoneNo3"),Phonenovalue,"Member Phone number validated");		
		Assert.assertEquals(sFileData.get("MemberActive3"),activestatusvalue,"Member active status validated");
		
		memberOverviewPage.openMemberInformation();
		
		
		Assert.assertEquals(sFileData.get("MemberLastname3"),lastnamevalue,"Member last name validated");
		Assert.assertEquals(sFileData.get("MemberFirstname3"),firstnamevalue,"Member first name validated");		
		Assert.assertEquals(sFileData.get("MemberAlternateId3"),alternateidvalue,"Member alternate id validated");
		Assert.assertEquals(sFileData.get("MemberDOB3"),memberDOBvalue,"Member DOB validated");
		Assert.assertEquals(sFileData.get("MemberMaritalStatus3"),maritalstatusvalue,"Member marital status validated");
		Assert.assertEquals(sFileData.get("MemberGender3"),gendervalue,"Member gender validated");
		
		Assert.assertEquals(sFileData.get("HOMEzipvalue"),HOMEzipvalue,"Member HOMEzipvalue validated");
		Assert.assertEquals(sFileData.get("HOMEcityvalue"),HOMEcityvalue,"Member HOMEcityvalue validated");		
		Assert.assertEquals(sFileData.get("HOMEaddressline1value"),HOMEaddressline1value,"Member HOMEaddressline1value validated");
		Assert.assertEquals(sFileData.get("HOMEaddressline2value"),HOMEaddressline2value,"Member HOMEaddressline2value validated");
		Assert.assertEquals(sFileData.get("HOMEstatevalue"),HOMEstatevalue,"Member HOMEstatevalue validated");
		Assert.assertEquals(sFileData.get("HOMEcountryvalue"),HOMEcountryvalue,"Member HOMEcountryvalue validated");
		
		Assert.assertEquals(sFileData.get("PRIMARYzipvalue"),PRIMARYzipvalue,"Member PRIMARYzipvalue validated");
		Assert.assertEquals(sFileData.get("PRIMARYcityvalue"),PRIMARYcityvalue,"Member PRIMARYcityvalue validated");		
		Assert.assertEquals(sFileData.get("PRIMARYaddressline1value"),PRIMARYaddressline1value,"Member PRIMARYaddressline1value validated");
		Assert.assertEquals(sFileData.get("PRIMARYaddressline2value"),PRIMARYaddressline2value,"Member PRIMARYaddressline2value validated");
		Assert.assertEquals(sFileData.get("PRIMARYstatevalue"),PRIMARYstatevalue,"Member PRIMARYstatevalue validated");
		Assert.assertEquals(sFileData.get("PRIMARYcountryvalue"),PRIMARYcountryvalue,"Member PRIMARYcountryvalue validated");*/
				
		
	}

}
