package com.jiva.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.beanfactory.BeanFactory;
import com.jiva.dao.LoginData;
import com.jiva.dao.MemberData;
import com.jiva.pages.ConfirmAddepisodePage;
import com.jiva.pages.CreateCMepisodePage;
import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.pages.MemberSearchPage;
import com.jiva.utils.TestBase;

public class SanityTC_01 extends TestBase {

	WebDriver driver;

	@Test(description = "Add CM episode for active Jiva members")
	public void verify_AddCMEpisodetoMember() throws InterruptedException {
		
		//initialise browser and openurl
		
		driver = initializeDriver(BROWSER);
		
		
		openurl(driver, AutomationURL);
		maximizeBrowser(driver);
		Thread.sleep(5000);

		/*
		 * LoginPage login = new LoginPage(driver); login.username(USERNAME);
		 * login.password(PASSWORD); Thread.sleep(5000); login.login();
		 */

		/* 
		 * loginData.getUsername(); loginData.getPassword();
		 * 
		 * loginData.setUsername(USERNAME);
		 * 
		 * loginData.getUsername();
		 */

		// Login Page details
		BeanFactory beanFactory = new BeanFactory();
		LoginData loginData = new LoginData();
		beanFactory.loginCredentials(loginData);
		
		LoginPage login = new LoginPage(driver);
		login.username(loginData.getUsername());
		login.password(loginData.getPassword());
		login.login();
		Thread.sleep(5000);
		
		// Dashboard Page details
		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(),"Logged in Sucessfully");
		dashboard.clickMenu();
		dashboard.clickMemberSearch();
		
		// MemberSearch Page details
		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();
		memberSearchPage.enterJivaId();
		memberSearchPage.clicksearch();
		
		// Confirmation for Adding episode
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
		confirmAddepisodePage.clickAddepisode();
		
		//Create episode page details
		CreateCMepisodePage createCMepisodePage = new CreateCMepisodePage(driver);
		createCMepisodePage.addepisodedetails();
		Assert.assertEquals(true, createCMepisodePage.verifyprogramadded(),"Program added Sucessfully");
		createCMepisodePage.clicksave();
		Assert.assertEquals(true, createCMepisodePage.verifyepidodeadded(),"Episode added Sucessfully");
		
			
		
		
		
		//Closing the browser
		closeBrowser(driver);
			

	}


	/*
	 * @Test 
	 * public void closeBrowser() { 
	 * closeBrowser(driver);
	 *  }
	 */

}
