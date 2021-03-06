package com.framework.setup;

public interface Setup {
	
	//String AutomationURL="https://lumerisuat.zeomega.com";  //UAT 1 url
	
	String JivaUAT2URL="https://lumerisuat2.zeomega.com";  //UAT 2 url
	
	String IEPATH = "../JivaAutomation/drivers/IEDriverServer.exe";	
	String CHROMEPATH = "../JivaAutomation/drivers/chromedriver.exe";
	String FFPATH = "../JivaAutomation/drivers/geckodriver.exe";
	
	String USERNAME="vjayavarapu",PASSWORD="Password3!";
	String BROWSER="CHROME";
	String JIVAID = "610570";
	
	String SFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-demographics_20171114_171337~20171114_091506616~.txt";
	
	/*---JIVA---*/		
	String MEMBERDEMOGRAPHICFILENAME = "../JivaAutomation/Jiva Input files/jiva-eligibility-demographics_20180204_100001~20180204_101341232~.txt";
	String MEMBERADDRESSFILENAME = "../JivaAutomation/Jiva Input files/jiva-eligibility-address_20180204_100001~20180204_101346942~.txt";
	String MEMBERPHONEFILENAME = "../JivaAutomation/Jiva Input files/jiva-eligibility-phone_20180204_100001~20180204_101349906~.txt";
	String MEMBERCOVERAGEFILENAME = "../JivaAutomation/Jiva Input files/jiva-eligibility-coverage_20180204_100001~20180204_101343666~.txt";	
	
	/*String MEMBERDEMOGRAPHICFILENAME = "../JivaAutomation/Jiva Input files/20180129/jiva-eligibility-demographics_20180129_100001~20180129_100647371~.txt";
	String MEMBERADDRESSFILENAME = "../JivaAutomation/Jiva Input files/20180129/jiva-eligibility-address_20180129_100001~20180129_100653424~.txt";
	String MEMBERPHONEFILENAME = "../JivaAutomation/Jiva Input files/20180129/jiva-eligibility-phone_20180129_100001~20180129_100655779~.txt";
	String MEMBERCOVERAGEFILENAME = "../JivaAutomation/Jiva Input files/20180129/jiva-eligibility-coverage_20180129_100001~20180129_100651053~.txt";*/
	
	/*String MEMBERDEMOGRAPHICFILENAME = "../JivaAutomation/Jiva Input files/20180127/jiva-eligibility-demographics_20180127_100001~20180127_100518103~.txt";
	String MEMBERADDRESSFILENAME = "../JivaAutomation/Jiva Input files/20180127/jiva-eligibility-address_20180127_100001~20180127_100523516~.txt";
	String MEMBERPHONEFILENAME = "../JivaAutomation/Jiva Input files/20180127/jiva-eligibility-phone_20180127_100001~20180127_100525747~.txt";
	String MEMBERCOVERAGEFILENAME = "../JivaAutomation/Jiva Input files/20180127/jiva-eligibility-coverage_20180127_100001~20180127_100521363~.txt";*/
	
	
	/*---QA M360---*/
	String m360_url = "https://uatapp.med-adv360.com/mss/quay/homePage.htm";
	String m360_user = "rb0275q";
	String m360_password = "Password2!";
	String m360_feed_files_folder = "DataFiles";
	/*---FACETS---*/
	String facets_citrix_url = "http://ctxweb.essenet.com/Citrix/XenApp/site/default.aspx";
	/*---CONNECTURE---*/
	String connecture_url = "https://essence.staging.destinationrx.com/plancompare/consumer/type3/2018/";
	String connecture_user = "essence_Client";
	String connecture_password = "Essence123!";
	
}



