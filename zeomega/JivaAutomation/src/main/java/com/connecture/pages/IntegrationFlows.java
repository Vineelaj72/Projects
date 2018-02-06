package com.connecture.pages;

import org.openqa.selenium.WebDriver;

import com.framework.utils.LoginPage;
import com.framework.utils.LoginPageFactory;
import com.framework.utils.LoginPageFactory.appName;
import com.framework.utils.WebElements;

public class IntegrationFlows  extends WebElements {
	
	private WebDriver driver;
	
	public IntegrationFlows(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void createDayNNewEnrollment(String hicn, String applicantFName, String applicantLName){
		LoginPage login = new LoginPageFactory(driver).getLoginPage(appName.connecture);
		login.login();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickGetStarted();
		
		ConnectureShoppingMethod connectureShoppingMethod = new ConnectureShoppingMethod(driver);
		connectureShoppingMethod.clickViewAllPlans();
		
		ChooseAPlan chooseAPlan = new ChooseAPlan(driver);
		chooseAPlan.submitZipCode("63141");
		chooseAPlan.selectFirstPlan();
		
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		shoppingCart.enroll();
		
		ContactInformation contactInformation = new ContactInformation(driver);
		contactInformation.enterContactInfo(applicantFName, applicantLName);
		
		BenefitsInformation benefitsInformation = new BenefitsInformation(driver);
		benefitsInformation.enterBenefitsInfo(hicn);
		
		OtherInformation otherInformation = new OtherInformation(driver);
		otherInformation.enterOtherInfo();
		
		Submit submit = new Submit(driver);
		submit.submitEnrollment();
	}

}
