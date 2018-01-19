package com.jiva.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiva.beanfactory.BeanFactory;
import com.jiva.dao.LoginData;
import com.jiva.pages.Dashboard;
import com.jiva.pages.LoginPage;
import com.jiva.pages.WorklistsPage;
import com.jiva.utils.TestBase;

public class WorklistsTC_01 extends TestBase{
	WebDriver driver;

	@Test(description = "Worklist episodes-assigns to self")
	public void verify_WorklistsEpisodes() throws InterruptedException {
		
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
		
		//Dashboard page details
		Dashboard dashboard = new Dashboard(driver);
		Assert.assertEquals(true, dashboard.verifyDashboardDisplayed(),"Logged in Sucessfully");
		String userprofilename = dashboard.getuserprofilename();
		System.out.println("User Profile Name is "+userprofilename);
		dashboard.clickWorklists();
		
		//Worklists page details
		WorklistsPage worklists = new WorklistsPage(driver);
		worklists.clickCCMreferral();
		worklists.clickCMepisode();
		worklists.assigntoself();
		
		
		
	}
}
