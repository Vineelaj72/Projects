package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.jiva.utils.WebElements;

public class LoginPage extends WebElements {

	WebDriver driver;


	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By usernamelocator = By.name("__ac_name");
	By passwordlocator = By.name("__ac_password");
	By loginbuttonlocator = By.name("LogIn");

	
	public void username(String sUsername) {
		enterText(usernamelocator, sUsername);
		Reporter.log("Username Entered"+sUsername);
	}

	public void password(String spassword) {
		enterText(passwordlocator, spassword);
		Reporter.log("Password Entered"+spassword);

	}

		
	public void loginbutton() {
		clickUsingJs(loginbuttonlocator);
		Reporter.log("Login Button Clicked");

	}
	
	

}
