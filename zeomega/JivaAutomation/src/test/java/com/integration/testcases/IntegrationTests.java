package com.integration.testcases;

import java.io.BufferedReader;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.m360.pages.IntegrationFlows;
import com.m360.pages.IntegrationFlows.dataSource;

import autoitx4java.AutoItX;

import com.framework.setup.Setup;
import com.framework.utils.DateUtils;
import com.framework.utils.FileUtils;
import com.framework.utils.TestBase;
import com.jacob.com.LibraryLoader;

public class IntegrationTests extends TestBase{
	WebDriver driver;
	public static String dataFile = "test-input/ConnectureData.txt";
	public static String hicn = "";
	public static String applicantFName = "";
	public static String applicantLName = "";
	public static String[] yesterdayEnrollmentData = null;
	
	//REMEMBER : NEED TO MAKE SURE THERE IS A VALIDA DATA RECORD FROM YESTERDAY IN test-input/ConnectureData.TXT
	@Test
	public void test_Connecture_M360_Integration() {
		driver = initializeDriver(BROWSER);
		hicn = DateUtils.today("yyyyMMdd");
		applicantFName = "Shawn";
		applicantLName = "Johnson";
		
		create_Enrollment_In_Connecture_Day_N();
		
		pull_Day_N_Minus_1_Data();
		
		save_New_Connecture_Enrollment_Data();
		
		validate_Enrollment_In_M360_Day_N_Minus_1();
		
	}
	
	public void create_Enrollment_In_Connecture_Day_N(){
		new com.connecture.pages.IntegrationFlows(driver).createDayNNewEnrollment(hicn, applicantFName, applicantLName);
	}
	
	public void pull_Day_N_Minus_1_Data(){
		yesterdayEnrollmentData = FileUtils.getlastLineInFileWithYesterdayDate(dataFile, "|");
	}
	
	public void save_New_Connecture_Enrollment_Data(){
		FileUtils.appendNewLineWithTodayDate(dataFile, hicn + "|" + applicantFName + "|" + applicantLName, "|");
	}
	
	public void validate_Enrollment_In_M360_Day_N_Minus_1(){
		new com.m360.pages.IntegrationFlows(driver).searchAndValidateDayNMinus1PendingEnrollmentsInM360(dataSource.connecture, yesterdayEnrollmentData);
	}
	
}