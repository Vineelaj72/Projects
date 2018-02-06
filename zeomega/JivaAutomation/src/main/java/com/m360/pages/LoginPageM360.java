package com.m360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.framework.setup.Setup;
import com.framework.utils.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageM360 extends LoginPage{

	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "User_id")
    @CacheLookup
    private WebElement txtUserName;
	
	@FindBy(how = How.NAME, using = "User_pwd")
    @CacheLookup
    private WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "submit")
    @CacheLookup
    private WebElement btnLogin;
	
	public LoginPageM360(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(){
		String url = Setup.m360_url;
		String username = Setup.m360_user;
		String password = Setup.m360_password;
		
		driver.navigate().to(url);
		
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}

