package com.jivaUAT1.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.pages.ConfirmAddepisodePage;
import com.jiva.pages.CreateCMepisodePage;
import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberSearchPage;
import com.framework.utils.TestBase;

public class CreateCMEpisode_TC extends TestBase {

	WebDriver driver;

	@Test(description = "Add CM episode for active Jiva members")
	public void verify_AddCMEpisodetoMember() throws InterruptedException {
		
		//initialise browser and openurl
		
		driver = initializeDriver(BROWSER);
		
		
		openurl(driver, JivaUAT2URL);
		maximizeBrowser(driver);
		Thread.sleep(5000);
		
		 LoginPage login = new LoginPage(driver);
		 login.enterUsername(USERNAME);
		 login.enterPassword(PASSWORD); 
		 login.loginbutton();
				 	
		// Dashboard Page details
		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(),"Logged in Sucessfully");
		dashboard.clickMenu();
		dashboard.clickMemberSearch();
		
		// MemberSearch Page details
		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();
		memberSearchPage.enterJivaId(JIVAID);
		memberSearchPage.clickSearchinAdvancedSearch();
		
		// Confirmation for Adding episode
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickAddepisode();
		
		//Create episode page details
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails("");
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(),"Program added Sucessfully");
		createCMepisodePage.clickSaveEpisode();
		Assert.assertEquals(true, createCMepisodePage.verifyEpidodeAdded(),"Episode added Sucessfully");
		System.out.println("Verified creation of episode successfully");
		
		
		//Closing the browser
		closeBrowser(driver);
			

	}

}
