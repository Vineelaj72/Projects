package com.jiva.testcases;

import java.util.Map;

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
import com.jiva.utils.ReadFile;
import com.jiva.utils.TestBase;

public class DemographicDataValidation_TC extends TestBase {
	private static Logger logger = Logger.getLogger(DemographicDataValidation_TC.class);
	WebDriver driver;
	private String sTestcaseName = null;

	@Test(description = "Screen Data with Member Demographic File Data")
	public void verify_screenDataWithFileData() throws InterruptedException {

		sTestcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Execution started for " + sTestcaseName);
		Map<String, String> sFileData = MemberDemographicFile.readdemographicFile(SFILENAME);

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
		memberSearchPage.enterMemberLastname(sFileData.get("MemberLastname3"));
		memberSearchPage.enterMemberFirstname(sFileData.get("MemberFirstname3"));
		memberSearchPage.clickSearch();
		
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickRedirecttoMCV();
		
		MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);
		//By namelocator = By.xpath("//a/span[contains(@ng-bind,'memberScope.member_details.mbr_name')]");
		
		Assert.assertEquals(sFileData.get("MemberLastname3"), (memberOverviewPage.getMemberName().split(","))[0], "Member last name validated");
		Thread.sleep(5000);
		Assert.assertEquals(sFileData.get("MemberFirstname3"), (memberOverviewPage.getMemberName().split(","))[1], "Member first name validated");
		
		
		
		
		// Assert.assertEquals(true,
		// sFileData.toString().contains(userprofilename.split(",")[0].toLowerCase()));
		// //check the field in UI available and matches with data in file
	}
}
