package com.jiva.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utils.WebElements;

public class MemberOverviewPage extends WebElements {
	
	private static Logger logger = Logger.getLogger(MemberOverviewPage.class);
	WebDriver driver;
	public MemberOverviewPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
	}
	
	By openepisodelinklocator = By.xpath("//li/a/span[contains(text(),'Open')]");
	By namelocator = By.xpath("//a/span[contains(@ng-bind,'memberScope.member_details.mbr_name')]");
	By memberinfoexpandlocator = By.id("yui-gen506");
	By viewallmemberinfolocator = By.xpath("//a/span[contains(text(),'View all')]/../j-label[contains(text(),'Member')]/../span[contains(text(),'information')]/..");
	By currentepisodecogwheellocator = By.xpath(".//*[@id='content-main']/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[1]/a/i");
	By deactivateepisodelink = By.xpath("//a/span[contains(text(),'Deactivate')]");
	By deactivatebuttonlocator = By.xpath("//div/button[contains(text(),'Deactivate')]");
	By CCMstatusclosedlocator = By.xpath("//div[contains(@class,'ng-scope')]//div[contains(@class,'clearfix col-sm-6 padding-left-0px padding-right-0px')]/div/span[contains(text(),'Complex')]/../../../div[contains(@class,'clearfix col-sm-6')]/div[4]/span[contains(text(),'Closed')]");
	By CCMstatusreferrallocator = By.xpath("//div[contains(@class,'ng-scope')]//div[contains(@class,'clearfix col-sm-6 padding-left-0px padding-right-0px')]/div/span[contains(text(),'Complex')]/../../../div[contains(@class,'clearfix col-sm-6')]/div[4]/span[contains(text(),'Referral')]");
	By CCMstatusopenlocator = By.xpath("//div[contains(@class,'ng-scope')]//div[contains(@class,'clearfix col-sm-6 padding-left-0px padding-right-0px')]/div/span[contains(text(),'Complex')]/../../../div[contains(@class,'clearfix col-sm-6')]/div[4]/span[contains(text(),'open')]");
	By episodecountlocator = By.xpath("//div/span[contains(text(),'Episodes')]/../span[contains(@ng-bind,'count')]");
	By memberoverviewlocator = By.xpath("//a[contains(text(),'Member Overview')]");
	
	By memberfirstnamelocator = By.xpath("//div/span[contains(text(),'First Name')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_first_name')]");
	By memberlastnamelocator = By.xpath("//div/span[contains(text(),'Last Name')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_last_name')]");
	By eligibilityidlocator = By.xpath("//td/span[contains(text(),'ELIGIBILITY ID')]/../../td/span[contains(@ng-bind,'record.iden_number')]");
	By alternateidlocator = By.xpath("//td/span[contains(text(),'ALTERNATE ID')]/../../td/span[contains(@ng-bind,'record.iden_number')]");
	By memberDOBlocator = By.xpath("//div/span[contains(text(),'Date of Birth')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_birth_dt')]");
	By maritalstatuslocator = By.xpath("//div[contains(text(),'Marital Status')]/../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_marital_status')]");
	By genderlocator = By.xpath("//div/span[contains(text(),'Sex')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_gender')]");
	By activestatuslocator = By.xpath("//i[contains(@ng-if,'!memberScope.cvgExpired')]");
	By coverageidlocator = By.xpath("//span/j-label[contains(text(),'Coverage ID')]/../../span[contains(@ng-bind,'memberScope.member_details.coverage_id')]");
	By phonelocator = By.xpath("//td/span[contains(text(),'Phone')]/../span[contains(@ng-bind,'preferred_phone')]");
	By homephonelocator = By.xpath("//td/div/div/label[contains(text(),'Home')]/../div/span");
	By clientnamelocator = By.xpath("//label/j-label[contains(text(),'Client')]/../../div/span");
	
	By HOMEaddresstypelocator = By.xpath(".//*[@id='cms-body']/div[5]/div/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/div[3]/span");
	By HOMEziplocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../div/div[contains(text(),'Zip')]/../div/span[contains(@ng-bind,'record.member_zipcode')]");
	By HOMEcitylocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../div/div[contains(text(),'City')]/../div/span[contains(@ng-bind,'record.member_city')]");
	By HOMEaddressline1locator = By.xpath("//div/span[contains(text(),'HOME')]/../../../div/div[contains(text(),'Address Line 1')]/../div/span[contains(@ng-bind,'record.member_addr_1')]");
	By HOMEaddressline2locator = By.xpath("//div/span[contains(text(),'HOME')]/../../../../div/div/div[contains(text(),'Address Line 2')]/../div/span[contains(@ng-bind,'record.member_addr_2')]");
	By HOMEstatelocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../../div/div/div[contains(text(),'State')]/../div/span[contains(@ng-bind,'record.member_state')]");
	By HOMEcountrylocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../../div/div/div[contains(text(),'Country')]/../div/span[contains(@ng-bind,'record.member_country')]");
	
	By PRIMARYaddresstypelocator = By.xpath(".//*[@id='cms-body']/div[5]/div/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[4]/div[3]/span");
	By PRIMARYziplocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../div/div[contains(text(),'Zip')]/../div/span[contains(@ng-bind,'record.member_zipcode')]");
	By PRIMARYcitylocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../div/div[contains(text(),'City')]/../div/span[contains(@ng-bind,'record.member_city')]");
	By PRIMARYaddressline1locator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../div/div[contains(text(),'Address Line 1')]/../div/span[contains(@ng-bind,'record.member_addr_1')]");
	By PRIMARYaddressline2locator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../../div/div/div[contains(text(),'Address Line 2')]/../div/span[contains(@ng-bind,'record.member_addr_2')]");
	By PRIMARYstatelocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../../div/div/div[contains(text(),'State')]/../div/span[contains(@ng-bind,'record.member_state')]");
	By PRIMARYcountrylocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../../div/div/div[contains(text(),'Country')]/../div/span[contains(@ng-bind,'record.member_country')]");
	
	By closememberinfolocator = By.xpath(".//*[@id='cms-body']/div[5]/div/div/div/div[1]/button");
	By addepisodelocator = By.xpath(".//*[@id='angularcontent']/workflow-banner/div/div/div[3]/div[6]/button");
	By casemanagementlocator = By.xpath("(//a/span[contains(text(),'Case Management')])[2]");
	
	
	public void deActivate()
	{
		By episodeCountlocator=By.xpath("//span[@ng-bind='episodeList.episode_count']"); 
		By episodeExpandlocator=By.xpath("//button[@ng-click='routeEpisodeGridView()']/i");
		By closed_CCM_Episodelocator=By.xpath("//*[contains(text(),'Complex Case Management')]/../../..//*[contains(text(),'Closed')]/../../..//a[contains(@class,'dropdown')]");
		By referral_CCM_Episodelocator=By.xpath("//*[contains(text(),'Complex Case Management')]/../../..//*[contains(text(),'Referral')]/../../..//a[contains(@class,'dropdown')]");
		By Open_CCM_Episodelocator=By.xpath("//*[contains(text(),'Complex Case Management')]/../../..//*[contains(text(),'Open')]/../../..//a[contains(@class,'dropdown')]");		
		By deaactivate_EpisodeLocator=By.xpath("//*[contains(text(),'Deactivate')]");

		if (Integer.parseInt(getText(episodeCountlocator)) != 0) {
			click(episodeExpandlocator);
			sleep(5000);
			List<WebElement> episodeList = listofelements(closed_CCM_Episodelocator);
			for (int i = 0; i < episodeList.size(); i++) {
				episodeList.get(i).click();		
				sleep(5000);
				clickUsingJs(deaactivate_EpisodeLocator);
				sleep(5000);
				deactivateEpisodeAlert();

			}
		}
		
	}
	
	
	public void closeMemberInfo()
	{
		clickUsingJs(closememberinfolocator);
	}
	public void clickMemberOverview()
	{
		clickUsingJs(memberoverviewlocator);
	}
	
	public void deactivateEpisodeAlert()
	{
		sleep(5000);
		alertBox("deactivate the episode");
		sleep(5000);
		//driver.findElement(By.className("body")).sendKeys(Keys.ENTER);
	}
		
	public String getEpisodeCount()
	{
		return getText(episodecountlocator);
	}
	public String getClientName()
	{
		return getText(clientnamelocator);
	}
	public void clickAddEpisode()
	{
		clickUsingJs(addepisodelocator);
	}
	public void clickCaseManagement()
	{
		clickUsingJs(casemanagementlocator);
	}
	
	public void clickGear(String episodeId) {
		By gearlocator = By.xpath("//div/div/div/div/div/div/span[contains(text(),'"+episodeId+"')]/../../../../../../../div/a/i[contains(@class,'fa fa-gear')]");
		logger.info(gearlocator);
		clickUsingJs(gearlocator);
		
	}
	public void clickCurrentEpisodecogwheel()
	{
		clickUsingJs(currentepisodecogwheellocator);
	}
	public void performDeactivateEpisode()
	{
		click(deactivateepisodelink);
		click(deactivatebuttonlocator);
	}
	public void performDeactivateEpisodeforClosedEpisodes()
	{
		try
		{
			if(isDisplayed(CCMstatusclosedlocator))
			{
				click(deactivateepisodelink);
				click(deactivatebuttonlocator);
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("No CCM closed episodes available");
		}
	
		
	}
	public void similarEpisodeAlert()
	{
		sleep(10000);
		alertBox("similar episode");
	}
	public void openEpisode()
	{
		clickUsingJs(openepisodelinklocator);
	}
	public void expandMemberInfo()
	{
		clickUsingJs(memberinfoexpandlocator);
	}
	public void openMemberInformation()
	{		
		clickUsingJs(viewallmemberinfolocator);
	}
	
	public String getMemberLastName()
	{
		return getText(memberlastnamelocator);
	}
	public String getMemberFirstName()
	{
		return getText(memberfirstnamelocator);
	}
	public String getEligibilityId()
	{
		return getText(eligibilityidlocator);
	}
	public String getAlternateId()
	{
		return getText(alternateidlocator);
	}
	public String getMemberDOB()
	{
		return getText(memberDOBlocator);
	}
	public String getMemberMaritalStatus()
	{
		return getText(maritalstatuslocator);
	}
	public String getGender()
	{
		return getText(genderlocator);
	}
	public String getActiveStatus()
	{
		String status= getAttribute(activestatuslocator);
		if(status.contains("[6cc009,ff6262]"))
			return "Y";
		else 
			return "N";
	}
	public String getCoverageId()
	{
			logger.info(getText(coverageidlocator));
			return getText(coverageidlocator);
	}
	public String getPhoneNumber()
	{
		return getText(homephonelocator);
	}
	public String getHomeAddressType()
	{
		return getText(HOMEaddresstypelocator);
	}
	public String getHomeAddressline1()
	{
		return getText(HOMEaddressline1locator);
	}
	public String getHomeAddressline2()
	{
		return getText(HOMEaddressline2locator);
	}
	public String getHomeCity()
	{
		return getText(HOMEcitylocator);
	}
	public String getHomeState()
	{
		return getText(HOMEstatelocator);
	}
	public String getHomeZip()
	{
		return getText(HOMEziplocator);
	}
	public String getHomeCountry()
	{
		return getText(HOMEcountrylocator);
	}
	public String getPrimaryAddressType()
	{
		return getText(PRIMARYaddresstypelocator);
	}
	public String getPrimaryAddressline1()
	{
		return getText(PRIMARYaddressline1locator);
	}
	public String getPrimaryAddressline2()
	{
		return getText(PRIMARYaddressline2locator);
	}
	public String getPrimaryCity()
	{
		return getText(PRIMARYcitylocator);
	}
	public String getPrimaryState()
	{
		return getText(PRIMARYstatelocator);
	}
	public String getPrimaryZip()
	{
		return getText(PRIMARYziplocator);
	}
	public String getPrimaryCountry()
	{
		return getText(PRIMARYcountrylocator);
	}
}

