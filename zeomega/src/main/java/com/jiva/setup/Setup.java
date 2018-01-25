package com.jiva.setup;

public interface Setup {
	
	String AutomationURL="https://lumerisuat.zeomega.com";
	
	String IEPATH = "../JivaAutomation/drivers/IEDriverServer.exe";	
	String CHROMEPATH = "../JivaAutomation/drivers/chromedriver.exe";
	String FFPATH = "C:\\Softwares\\geckodriver-v0.19.1-win64\\geckodriver.exe";
	
	String USERNAME="vjayavarapu",PASSWORD="Password1!";
	String BROWSER="IE";
	String JIVAID = "611127";
	String SFILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-demographics_20171114_171337~20171114_091506616~.txt";

	

}


//taskkill /F /IM IEDriverServer.exe
//taskkill /F /IM iexplore.exe



//span[contains(text(),'CM Unable To Reach')]/../../td/span[contains(text(),'"+userprofilename.split(",")[0].trim()+"')]

//span[contains(text(),'CM Unable To Reach')]/../../td[contains(text(),'Jayavarapu')]

//span[contains(text(),'Closed')]/../../../../td/div/span/span[contains(text(),'"+userprofilename.split(",")[0].trim()+"')]



//div/div/div/div/div/div/span[contains(text(),'ID')]/../../../../../../../div/a/i[contains(@class,'fa fa-gear')]

//div/div/div/div/div/div/span[contains(text(),'9396')]/../../../../../../../div/a/i[contains(@class,'fa fa-gear')]

//div/div/div/div/div/div/span[contains(text(),'"+episodeId+"')]/../../../../../../../div/a/i[contains(@class,'fa fa-gear')]

