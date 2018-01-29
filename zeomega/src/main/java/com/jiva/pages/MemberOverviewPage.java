package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class MemberOverviewPage extends WebElements {
	
	private static Logger logger = Logger.getLogger(MemberOverviewPage.class);

	public MemberOverviewPage(WebDriver driver1) {
		super(driver1);
	}
	
	By openepisodelinklocator = By.xpath("//li/a/span[contains(text(),'Open')]");
	By namelocator = By.xpath("//a/span[contains(@ng-bind,'memberScope.member_details.mbr_name')]");
	By memberinfoexpandlocator = By.id("yui-gen506");
	By viewallmemberinfolocator = By.xpath("//a/span[contains(text(),'View all')]/../j-label[contains(text(),'Member')]/../span[contains(text(),'information')]/..");
	By currentepisodecogwheellocator = By.xpath(".//*[@id='content-main']/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[1]/a/i");
	
	By memberfirstnamelocator = By.xpath("//div/span[contains(text(),'First Name')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_first_name')]");
	By memberlastnamelocator = By.xpath("//div/span[contains(text(),'Last Name')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_last_name')]");
	By eligibilityidlocator = By.xpath("//td/span[contains(text(),'ELIGIBILITY ID')]/../../td/span[contains(@ng-bind,'record.iden_number')]");
	By alternateidlocator = By.xpath("//td/span[contains(text(),'ALTERNATE ID')]/../../td/span[contains(@ng-bind,'record.iden_number')]");
	By memberDOBlocator = By.xpath("//div/span[contains(text(),'Date of Birth')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_birth_dt')]");
	By maritalstatuslocator = By.xpath("//div[contains(text(),'Marital Status')]/../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_marital_status')]");
	By genderlocator = By.xpath("//div/span[contains(text(),'Sex')]/../../div/span[contains(@ng-bind,'mbrAbstractCtrl.memberDetails.member_gender')]");
	By activestatuslocator = By.xpath("//td/span[contains(text(),'Coverage')]/../i[contains(@class,'fa fa-circle font-color-6cc009')]");
	By coverageidlocator = By.xpath("//span/j-label[contains(text(),'Coverage ID')]/../../span[contains(@ng-bind,'memberScope.member_details.coverage_id')]");
	By phonelocator = By.xpath(".//*[@id='angularcontent']/div[1]/div/div[2]/table/tbody[1]/tr/td[2]/span[4]");
	
	By HOMEziplocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../div/div[contains(text(),'Zip')]/../div/span[contains(@ng-bind,'record.member_zipcode')]");
	By HOMEcitylocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../div/div[contains(text(),'City')]/../div/span[contains(@ng-bind,'record.member_city')]");
	By HOMEaddressline1locator = By.xpath("//div/span[contains(text(),'HOME')]/../../../div/div[contains(text(),'Address Line 1')]/../div/span[contains(@ng-bind,'record.member_addr_1')]");
	By HOMEaddressline2locator = By.xpath("//div/span[contains(text(),'HOME')]/../../../../div/div/div[contains(text(),'Address Line 2')]/../div/span[contains(@ng-bind,'record.member_addr_2')]");
	By HOMEstatelocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../../div/div/div[contains(text(),'State')]/../div/span[contains(@ng-bind,'record.member_state')]");
	By HOMEcountrylocator = By.xpath("//div/span[contains(text(),'HOME')]/../../../../div/div/div[contains(text(),'Country')]/../div/span[contains(@ng-bind,'record.member_country')]");
	
	
	By PRIMARYziplocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../div/div[contains(text(),'Zip')]/../div/span[contains(@ng-bind,'record.member_zipcode')]");
	By PRIMARYcitylocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../div/div[contains(text(),'City')]/../div/span[contains(@ng-bind,'record.member_city')]");
	By PRIMARYaddressline1locator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../div/div[contains(text(),'Address Line 1')]/../div/span[contains(@ng-bind,'record.member_addr_1')]");
	By PRIMARYaddressline2locator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../../div/div/div[contains(text(),'Address Line 2')]/../div/span[contains(@ng-bind,'record.member_addr_2')]");
	By PRIMARYstatelocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../../div/div/div[contains(text(),'State')]/../div/span[contains(@ng-bind,'record.member_state')]");
	By PRIMARYcountrylocator = By.xpath("//div/span[contains(text(),'PRIMARY')]/../../../../div/div/div[contains(text(),'Country')]/../div/span[contains(@ng-bind,'record.member_country')]");
	
	By closememberinfolocator = By.xpath(".//*[@id='cms-body']/div[5]/div/div/div/div[1]/button");
	By addepisodelocator = By.xpath(".//*[@id='angularcontent']/workflow-banner/div/div/div[3]/div[6]/button");
	By CMlocator = By.xpath(".//*[@id='AccessDialog']/div/div[2]/div/div/div/div/div/div/div/a/span");
	
	public void closeMemberInfo()
	{
		clickUsingJs(closememberinfolocator);
	}	
	public void clickAddEpisode()
	{
		clickUsingJs(addepisodelocator);
	}
	public void clickCaseManagement()
	{
		clickUsingJs(CMlocator);
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
	/*public String getMemberName()
	{
		return getText(namelocator);
	}*/
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
		return getText(activestatuslocator);
	}
	public String getCoverageId()
	{
			//System.out.println(getText(coverageidlocator));
		return getText(coverageidlocator);
	}
	public String getPhoneNumber()
	{
		return getText(phonelocator);
	}
	public String gethomeaddressline1()
	{
		return getText(HOMEaddressline1locator);
	}
	public String gethomeaddressline2()
	{
		return getText(HOMEaddressline2locator);
	}
	public String gethomecity()
	{
		return getText(HOMEcitylocator);
	}
	public String gethomestate()
	{
		return getText(HOMEstatelocator);
	}
	public String gethomezip()
	{
		return getText(HOMEziplocator);
	}
	public String gethomecountry()
	{
		return getText(HOMEcountrylocator);
	}
	public String getprimaryaddressline1()
	{
		return getText(PRIMARYaddressline1locator);
	}
	public String getprimaryaddressline2()
	{
		return getText(PRIMARYaddressline2locator);
	}
	public String getprimarycity()
	{
		return getText(PRIMARYcitylocator);
	}
	public String getprimarystate()
	{
		return getText(PRIMARYstatelocator);
	}
	public String getprimaryzip()
	{
		return getText(PRIMARYziplocator);
	}
	public String getprimarycountry()
	{
		return getText(PRIMARYcountrylocator);
	}
}

