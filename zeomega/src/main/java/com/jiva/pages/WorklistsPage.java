package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

import com.jiva.utils.WebElements;

public class WorklistsPage extends WebElements {

	public WorklistsPage(WebDriver driver1) {
		super(driver1);
	}

	By ccmreferrallocator = By.xpath("//div[contains(text(),'CCM Referral')]");
	By cmepisodelocator = By.xpath("(//a[contains(text(),'CM')])[2]");
	By episodeassignlocator = By.xpath("//label/input[@type='checkbox']");
	By okbuttonlocator = By.xpath("//button[@ng-click='goToEpisodedashboard()']");

	By memberlastNameLocator = By.xpath("//input[@placeholder='Member Last Name']");
	By memberFirstNameLocator = By.xpath("//input[@placeholder='Member First Name']");
	By searchLocator = By.xpath("//button[@title='Search Worklist']");
	By advanceSearchLoctor = By.xpath("//button[contains(text(),'Advanced Search')]");

	public void clickAdvanceSearch() {
		click(advanceSearchLoctor);
	}

	public void enterLastName(String lastname) {
		enterText(memberlastNameLocator, lastname);
		clickEnter(memberlastNameLocator);
	}

	public void enterFirstName(String firstname) {
		enterText(memberFirstNameLocator, firstname);
		clickEnter(memberFirstNameLocator);

	}

	
	public void clickCM(String sLastname)
	{
		By cmlocator=By.xpath("//*[contains(text(),'"+sLastname+"')]/../../../..//trans-worklist-result/a[text()='CM']");
		click(cmlocator);
		
	}
	
	
			public String getEpisodeID(String sLastname)
			{
				By episode= By.xpath("//*[contains(text(),'"+sLastname+"')]/../../../..//trans-worklist-result/a");	
				return getText(episode);
		
			}
	public void clickSearchButton() {
		click(searchLocator);
	}

	public void clickCCMreferral() {
		clickUsingJs(ccmreferrallocator);
	}

	/*public void clickCMepisode() {
		clickUsingJs(cmepisodelocator);
	}*/

	public void assigntoself() {
		clickUsingJs(episodeassignlocator);
		clickUsingJs(okbuttonlocator);
	}

}
