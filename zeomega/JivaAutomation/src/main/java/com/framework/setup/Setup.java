package com.framework.setup;

public interface Setup {
	
String AutomationURL="https://lumerisuat.zeomega.com";
	
	String IEPATH = "../JivaAutomation/drivers/IEDriverServer.exe";	
	String CHROMEPATH = "../JivaAutomation/drivers/chromedriver.exe";
	String FFPATH = "../JivaAutomation/drivers/geckodriver.exe";
	
	String USERNAME="vjayavarapu",PASSWORD="Password1!";
	String BROWSER="CHROME";
	String JIVAID = "610570";
	
	String SFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-demographics_20171114_171337~20171114_091506616~.txt";
	
	String MEMBERDEMOGRAPHICFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-demographics_20180129_100001~20180129_100647371~.txt";
	String MEMBERADDRESSFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-address_20180129_100001~20180129_100653424~.txt";
	String MEMBERPHONEFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-phone_20180129_100001~20180129_100655779~.txt";
	String MEMBERCOVERAGEFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-coverage_20180129_100001~20180129_100651053~.txt";
	
	/*QA M360*/
	String m360_url = "https://uatapp.med-adv360.com/mss/quay/homePage.htm";
	String m360_user = "rb0275q";
	String m360_password = "Password2!";
	String m360_feed_files_folder = "DataFiles";
	/*FACETS*/
	String facets_citrix_url = "http://ctxweb.essenet.com/Citrix/XenApp/site/default.aspx";
	/*CONNECTURE*/
	String connecture_url = "https://essence.staging.destinationrx.com/plancompare/consumer/type3/2018/";
	String connecture_user = "essence_Client";
	String connecture_password = "Essence123!";
}



