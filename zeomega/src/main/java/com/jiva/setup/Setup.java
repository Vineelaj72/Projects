package com.jiva.setup;

public interface Setup {
	
	String AutomationURL="https://lumerisuat.zeomega.com";
	
	String IEPATH = "../JivaAutomation/drivers/IEDriverServer.exe";	
	String CHROMEPATH = "../JivaAutomation/drivers/chromedriver.exe";
	String FFPATH = "C:\\Softwares\\geckodriver-v0.19.1-win64\\geckodriver.exe";
	
	String USERNAME="vjayavarapu",PASSWORD="Password1!";
	String BROWSER="CHROME";
	String JIVAID = "488526";
	
	String SFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-demographics_20171114_171337~20171114_091506616~.txt";
	
	String MEMBERDEMOGRAPHICFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-demographics_20180129_100001~20180129_100647371~.txt";
	String MEMBERADDRESSFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-address_20180129_100001~20180129_100653424~.txt";
	String MEMBERPHONEFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-phone_20180129_100001~20180129_100655779~.txt";



}


//taskkill /F /IM IEDriverServer.exe
//taskkill /F /IM iexplore.exe


//taskkill /F /IM chrome.exe
//taskkill /F /IM Chromedriver.exe


