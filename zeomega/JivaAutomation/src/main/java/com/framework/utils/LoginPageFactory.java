package com.framework.utils;

import org.openqa.selenium.WebDriver;

import com.connecture.pages.LoginPageConnecture;
import com.m360.pages.LoginPageM360;

public class LoginPageFactory extends WebElements  {
	
	private WebDriver driver;
	
	public LoginPageFactory(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public LoginPage getLoginPage(appName app){
		switch (app){
		case m360:
			return new LoginPageM360(driver);
		case connecture:
			return new LoginPageConnecture(driver);
		/*case facets:
			return new LoginPageFacets();*/
		default:	
			return null;
		}
	}
	
	public enum appName{
		m360,
		facets,
		connecture
	}
}
