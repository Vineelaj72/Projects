package com.jiva.testcases;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.jiva.TestData.ReadMemberDemographicFile;
import com.jiva.utils.DateUtils;
import com.jiva.utils.MemberDemographicFile;
import com.jiva.utils.TestBase;

public class DataValidation_newTC extends TestBase{

	
		private static Logger logger = Logger.getLogger(DataValidation_newTC.class);
		WebDriver driver;
		private String sTestcaseName = null;
		private String sDateFormat;
		ArrayList<String> sFileName;
		Map<String, String> sFileData;
	
		@BeforeClass
		public void dataSetup() throws Exception {
			sDateFormat=DateUtils.ymdhmsTime();
		//	sFileName=FileUtils.listofFiles(SFILENAME, sDateFormat);
			//sFileData = ReadMemberDemographicFile.(SFILENAME);
			//2.Location Wise pick
			//1. Read 6 Files and written 6 Arry

		}
	
	
	
	
	
	
	
	
}
