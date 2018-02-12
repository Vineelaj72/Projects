package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.setup.JivaRecordsIndexing;
import com.framework.setup.Setup;

public class TestBase implements Setup,JivaRecordsIndexing {

	public WebDriver initializeDriver(String sbrowser) {
		WebDriver driver = null;
		if (driver == null) {
			if (sbrowser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver(ieProfileSetUp());
			}
			if (sbrowser.equalsIgnoreCase("CHROME")) {
				driver = new ChromeDriver(chromeProfileSetUp());
			}
			if (sbrowser.equalsIgnoreCase("FF")) {
				driver = new FirefoxDriver(firefoxProfileSetUp());
			}
			
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	public DesiredCapabilities ieProfileSetUp() {
		System.setProperty("webdriver.ie.driver", IEPATH);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability("ignoreProtectedModeSettings", true);
		caps.setCapability("enablePersistentHover", true);
		caps.setCapability("nativeEvents", false);
		caps.setCapability("javascriptEnabled", true);
		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return caps;
	}
	
	
	public DesiredCapabilities chromeProfileSetUp()
	 {
	  System.setProperty("webdriver.chrome.driver", CHROMEPATH);	  
	  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	  chromePrefs.put("credentials_enable_service", Boolean.valueOf(false));
	        chromePrefs.put("profile.password_manager_enabled", Boolean.valueOf(false));
	  chromePrefs.put("profile.default_content_settings.popups", 0);
	  ChromeOptions options = new ChromeOptions();
	  HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	  options.setExperimentalOption("prefs", chromePrefs);
	  options.addArguments("--test-type");
	  DesiredCapabilities caps = DesiredCapabilities.chrome();
	  caps.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	  caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  caps.setCapability(ChromeOptions.CAPABILITY, options);
	  options.addArguments("--always-authorize-plugins");
	  options.addArguments("--ignore-certificate-errors");
	    return caps; 
	 }
	
	public DesiredCapabilities firefoxProfileSetUp() {
		System.setProperty("webdriver.gecko.driver", FFPATH);
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		return caps;
	}
		
	public void openurl(WebDriver driver, String url)
	{
		driver.get(url);
		maximizeBrowser(driver);
	}

	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
