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

		
		 LoginPage login = new LoginPage(driver);
		 login.username(USERNAME);
		 login.password(PASSWORD); 
		 login.loginbutton();
		 Thread.sleep(5000);
		 

		/* 
		 * loginData.getUsername(); loginData.getPassword();
		 * 
		 * loginData.setUsername(USERNAME);
		 * 
		 * loginData.getUsername();
		 */

		// Login Page details
		/*BeanFactory beanFactory = new BeanFactory();
		LoginData loginData = new LoginData();
		beanFactory.loginCredentials(loginData);
		
		LoginPage login = new LoginPage(driver);
		login.username(loginData.getUsername());
		login.password(loginData.getPassword());
		login.loginbutton();
		Thread.sleep(5000);*/
		
		// Dashboard Page details
		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(),"Logged in Sucessfully");
		dashboard.clickMenu();
		dashboard.clickMemberSearch();
		
		// MemberSearch Page details
		MemberSearchPage memberSearchPage = new MemberSearchPage(driver);
		memberSearchPage.clickAdvSearch();
		memberSearchPage.enterJivaId(JIVAID);
		memberSearchPage.clickSearch();
		
		// Confirmation for Adding episode
		ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
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
