package com.jiva.setup;

public interface Setup {
	
	String AutomationURL="https://lumerisuat.zeomega.com";
	String IEPATH = "../JivaAutomation/drivers/IEDriverServer.exe";
	//String IEPATH = "C:\\Users\\vjayavarapu\\workspace\\JivaAutomation\\drivers\\IEDriverServer.exe";
	//String CHROMEPATH = "C:\\Softwares\\chromedriver_win32\\chromedriver.exe";
	String CHROMEPATH = "../JivaAutomation/drivers/chromedriver.exe";
	String FFPATH = "C:\\Softwares\\geckodriver-v0.19.1-win64\\geckodriver.exe";
	
	String USERNAME="vjayavarapu",PASSWORD="Password1!";
	String PROFILENAME = "Jayavarapu, Vineela";
	
	String BROWSER="IE";
	String JIVAID = "605824";
	

}


//taskkill /F /IM IEDriverServer.exe
//taskkill /F /IM iexplore.exe