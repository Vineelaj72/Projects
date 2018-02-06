package com.connecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.setup.Setup;

public class LoginPageConnecture extends com.framework.utils.LoginPage{
	
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "PostData.UserName")
    @CacheLookup
    private WebElement txtUserName;
	
	@FindBy(how = How.NAME, using = "PostData.Password")
    @CacheLookup
    private WebElement txtPassword;
	
	@FindBy(how = How.ID, using = "lnkLogin")
    @CacheLookup
    private WebElement btnLogin;
	
	public LoginPageConnecture(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(){
		String url = Setup.connecture_url;
		String username = Setup.connecture_user;
		String password = Setup.connecture_password;
		
		driver.navigate().to(url);
		
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
