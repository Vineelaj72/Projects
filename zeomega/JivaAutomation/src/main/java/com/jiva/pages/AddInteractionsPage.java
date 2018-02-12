package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.WebElements;

public class AddInteractionsPage extends WebElements{

	public AddInteractionsPage(WebDriver driver) {
		super(driver);
	}
		
	By followuprequiredyeslocator = By.xpath("//label[contains(text(),'Follow-up Required')]/../div/label/span[contains(text(),'Yes')]/../input");
	By followuprequirednolocator = By.xpath("//label[contains(text(),'Follow-up Required')]/../div/label/span[contains(text(),'No')]/../input");
	By interactionstatusunsuccessfullocator = By.xpath("//label[contains(text(),'Interaction Status')]/../div/label/span[contains(text(),'Unsuccessful')]/../input");
	By interactionstatussuccessfullocator = By.xpath("//label[contains(text(),'Interaction Status')]/../div/label/span[contains(text(),'Successful')]/../input");
	By enrollstatusunsuccessfullocator = By.xpath("(//input[@name='Successful'])[2]");
	By enrollstatussuccessfullocator = By.xpath("(//input[@name='Successful'])[1]");
	By notenrolloutcomesreasonsdropdown = By.xpath("//select[@name='reasons']");
	By outreachoutcomesdropdown = By.xpath("//select[@name='status']");
	By assigntodropdown = By.xpath("//select[@name='assignTo']");
	By savelocator = By.xpath("//button[contains(text(),'Save')]");
	static By workflowlocator = By.xpath("//button[contains(text(),'Workflow')]");
	
	public void add1stInteractionforUTC() throws InterruptedException
	{
		clickUsingJs(followuprequiredyeslocator);
		clickUsingJs(interactionstatusunsuccessfullocator);
		clickUsingJs(enrollstatusunsuccessfullocator);
		Thread.sleep(5000);
		dropdownSelect(notenrolloutcomesreasonsdropdown,"Unable to contact member");
	}
	public void add1stInteractionforMemberOptsOut() throws InterruptedException
	{
		clickUsingJs(followuprequiredyeslocator);
		clickUsingJs(interactionstatusunsuccessfullocator);
		clickUsingJs(enrollstatusunsuccessfullocator);
		Thread.sleep(5000);
		dropdownSelect(notenrolloutcomesreasonsdropdown,"Appointment Scheduled");
	}
	
	public void add1stInteractionforCCM(String userProfileName) throws InterruptedException
	{
		clickUsingJs(interactionstatussuccessfullocator);
		clickUsingJs(enrollstatussuccessfullocator);
		Thread.sleep(5000);
		dropdownSelect(outreachoutcomesdropdown, "Open");
		Thread.sleep(10000);
		dropdownSelect(assigntodropdown,userProfileName);
		waitforElementPresent(savelocator);
	}
	
	public void clickSaveInteraction()
	{
		clickUsingJs(savelocator);
	}
	public void add2ndInteractionforUTC()
	{
		//clickUsingJs(followuprequirednolocator);  //by default 
		//clickUsingJs(interactionstatusunsuccessfullocator);	//by default  
		clickUsingJs(enrollstatusunsuccessfullocator);
		//dropdownSelect(notenrolloutcomesreasonsdropdown,"Unable to contact member"); 	//by default 
		
	}
	public void add2ndInteractionforMemberOptsOut(String Userprofilename) throws InterruptedException
	{
		
		clickUsingJs(interactionstatussuccessfullocator);	
		clickUsingJs(enrollstatusunsuccessfullocator);
		dropdownSelect(notenrolloutcomesreasonsdropdown,"Refused Services"); 
		dropdownSelect(outreachoutcomesdropdown, "Closed");
		Thread.sleep(3000);
		dropdownSelect(assigntodropdown, Userprofilename);
		
	}
	public void episodeOpenActivitiesAlert() throws InterruptedException
	{
		sleep(5000);
		alertBox("This Episode has Open Activities");
	}
	public void changingAssignedUserAlert() throws InterruptedException
	{
		sleep(10000);
		alertBox("You are changing the assigned user");
		waitforElementPresent(workflowlocator);
	}
	
	
}
