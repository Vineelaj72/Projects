package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class LoginPage extends WebElements {

	WebDriver driver;

	By username = By.name("__ac_name");
	By password = By.name("__ac_password");
	By loginbutton = By.name("LogIn");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Enter username
	 * 
	 * @param sUsername
	 */
	public void username(String sUsername) {
		enterText(username, sUsername);
	}

	public void password(String spassword) {
		enterText(password, spassword);
	}

		
	public void loginbutton() {
		clickUsingJs(loginbutton);
	}
	
	/*public void verifyUsername()
	{
		
	}*/
	
	

}
