package com.jiva.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jiva.setup.Setup;

public class TestBase implements Setup {

	public WebDriver initializeDriver(String sbrowser) {
		WebDriver driver = null;
		if (driver == null) {
			if (sbrowser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver(ieProfileSetUp());
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
		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return caps;
	}
	
	public void openurl(WebDriver driver, String url)
	{
		driver.get(url);
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
