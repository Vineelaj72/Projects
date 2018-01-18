package com.jiva.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.beanfactory.BeanFactory;
import com.jiva.dao.LoginData;
import com.jiva.pages.ConfirmAddepisodePage;
import com.jiva.pages.CreateCMepisodePage;
import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberSearchPage;
import com.jiva.utils.TestBase;

public class SanityTC_03 extends TestBase{
	WebDriver driver;

	@Test(description = "Add CM episode for active Jiva members with episodes in 24hrs, assign program to self")
	public void verify_AddCMEpisodetoMember() throws InterruptedException {
		
		//initialise browser and openurl
		
		driver = initializeDriver(BROWSER);		
		openurl(driver, AutomationURL);
		maximizeBrowser(driver);
		Thread.sleep(5000);
		
		
		// Login Page details
		
		 LoginPage login = new LoginPage(driver);
		 login.username(USERNAME);
		 login.password(PASSWORD); 
		 login.loginbutton();
		 Thread.sleep(5000);
		 
		
		// Dashboard Page details
		 
		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(),"Logged in Sucessfully");
		String userprofilename = dashboard.getuserprofilename();
		System.out.println("User Profile Name is "+userprofilename);
		dashboard.clickMenu();
		dashboard.clickMemberSearch();
		
		// MemberSearch Page details
		
		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();
		memberSearchPage.enterJivaId(JIVAID);
		memberSearchPage.clicksearch();
		
		// Confirmation for Adding episode
		
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		String memberfullname = confirmAddepisodePage.getmemberfullname();
		System.out.println("Member Full name is "+memberfullname);
		confirmAddepisodePage.clickAddepisode();
		
		//Create episode page details
		
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addEpisodeDetails();
		Assert.assertEquals(true, createCMepisodePage.verifyProgramAdded(),"Program added Sucessfully");
		createCMepisodePage.clickSave();
		Assert.assertEquals(true, createCMepisodePage.verifyEpidodeAdded(),"Episode added Sucessfully");
		System.out.println("Verified creation of episode successfully");
		
		
		
		//Closing the browser
		closeBrowser(driver);
			
		
	}

}
