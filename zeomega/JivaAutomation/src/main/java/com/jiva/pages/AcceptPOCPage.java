package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.DateUtils;
import com.framework.utils.WebElements;

public class AcceptPOCPage extends WebElements{

	public AcceptPOCPage(WebDriver driver) {
		super(driver);
	}
	
	By problemradiobuttonlocator = By.xpath("//label/span[contains(text(),'Problem')]/../input");
	By goalradiobuttonlocator = By.xpath("//label/span[contains(text(),'Goal')]/../input");
	By interventionradiobuttonlocator = By.xpath("//label/span[contains(text(),'Intervention')]/../input");
	By editPOClocator = By.xpath("//button[contains(@class,'edit_poc')]");
	By problemprioritydropdown = By.xpath("//select[contains(@name,'I_P_PRIORITY')]");
	By problemexpecteddatelocator = By.xpath("//input[contains(@name,'P_EXPECTED_DATE')]");
	By calendercloselocator = By.xpath("//a/span[contains(@class,'calclose')]");
	By calendermonthlocator = By.xpath("//a[contains(@class,'calnav yuilisten')]");
	By calendermonthdropdown = By.xpath("//select[contains(@name,'calendarContainer_nav_month')]");
	By monthsubmitlocator = By.xpath("//button[contains(@id,'calendarContainer_nav_submit')]");
	By dateselectlocator = By.xpath("(//tbody[contains(@class,'m12 calbody')]/tr[contains(@class,'w50')]/td/a)[1]");
	By goalcopylocator = By.xpath("//a[contains(@id,'copy_goal')]");
	By interventioncopylocator = By.xpath("//a[contains(@id,'copy_intrv')]");
	By interventionduedatelocator = By.xpath("//input[contains(@name,'I_next_due_dt')]");
	By savedetailslocator = By.xpath("//button[contains(text(),'Save Details')]");
	By acceptPOClocator = By.xpath("(//button[contains(text(),'Accept Plan of Care')])[1]");
	By closePOCwindowlocator = By.xpath("//span[contains(@title,'Click here to close this window')]");
	static By workflowlocator = By.xpath("//button[contains(text(),'Workflow')]");
	
	public void managePOCDetails() throws InterruptedException
	{
		clickUsingJs(problemradiobuttonlocator);
		clickUsingJs(goalradiobuttonlocator);
		clickUsingJs(interventionradiobuttonlocator);
		clickUsingJs(editPOClocator);
		enterText(problemexpecteddatelocator, DateUtils.dateFormatbyFutureDate());
		clickUsingJs(calendercloselocator);
		dropdownSelect(problemprioritydropdown, "Medium");		
		
		/*clickUsingJs(problemexpecteddatelocator);
		clickUsingJs(calendermonthlocator);
		dropdownSelect(calendermonthdropdown, "December");
		clickUsingJs(monthsubmitlocator);
		clickUsingJs(dateselectlocator);*/
		
		clickUsingJs(goalcopylocator);
		clickUsingJs(interventioncopylocator);
		enterText(interventionduedatelocator, DateUtils.dateFormatbyFutureDate());
		
		/*clickUsingJs(interventionduedatelocator);
		clickUsingJs(calendermonthlocator);
		dropdownSelect(calendermonthdropdown, "December");
		clickUsingJs(monthsubmitlocator);
		clickUsingJs(dateselectlocator);*/
		
		sleep(3000);
		clickUsingJs(savedetailslocator);
		sleep(5000);
		clickUsingJs(problemradiobuttonlocator);
		sleep(1000);
		clickUsingJs(goalradiobuttonlocator);
		sleep(1000);
		clickUsingJs(interventionradiobuttonlocator);
		sleep(10000);
		clickUsingJs(acceptPOClocator);
	}
	public void closePOCWindow()
	{
		clickUsingJs(closePOCwindowlocator);
		waitforElementPresent(workflowlocator);
	}
}
