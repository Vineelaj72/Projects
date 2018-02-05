package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class WorklistsPage extends WebElements {

	 private static Logger logger = Logger.getLogger(WorklistsPage.class);

	public WorklistsPage(WebDriver driver) {
		super(driver);
	}

	By ccmreferrallocator = By.xpath("//div[contains(text(),'CCM Referral')]");
	By cmepisodelocator = By.xpath("(//a[contains(text(),'CM')])[2]");
	By episodeassignlocator = By.xpath("//label/input[@type='checkbox']");
	By okbuttonlocator = By.xpath("//button[@ng-click='goToEpisodedashboard()']");

	By memberlastNameLocator = By.xpath("//input[@placeholder='Member Last Name']");
	By memberFirstNameLocator = By.xpath("//input[@placeholder='Member First Name']");
	By searchLocator = By.xpath("//button[@title='Search Worklist']");
	By advanceSearchLoctor = By.xpath("//button[contains(text(),'Advanced Search')]");
	By csssel = By.cssSelector("strong");

	public void clickAdvanceSearch() {
		clickUsingJs(advanceSearchLoctor);
	}

	public void enterLastName(String lastname) {
		enterText(memberlastNameLocator, lastname);
		sleep(5000);
		clickEnter(memberlastNameLocator);
		//clickUsingJs(csssel);
		// clickEnter(memberlastNameLocator);
	}

	public void enterFirstName(String firstname) {
		enterText(memberFirstNameLocator, firstname);
		sleep(5000);
		clickEnter(memberFirstNameLocator);
		//clickUsingJs(csssel);
		// clickEnter(memberFirstNameLocator);

	}

	public void clickCM(String sLastname) {
		By cmlocator = By.xpath("//*[contains(text(),'" +sLastname+ "')]/../../../..//trans-worklist-result/a[text()='CM']");
		clickUsingJs(cmlocator);

	}

	public String getEpisodeID(String sLastname)
	{
		logger.info("@getEpisodeID of... "+sLastname);
		By episodeid = By.xpath("//*[contains(text(),'"+sLastname+"')]/../../../..//trans-worklist-result/a[contains(@ng-click,'Episode')]");
		logger.info("episode id is..."+getText(episodeid));
		
		return getText(episodeid);

	}

	public void clickSearchButton() {
		clickUsingJs(searchLocator);
	}

	public void clickCCMreferral() {
		clickUsingJs(ccmreferrallocator);
	}

	/*
	 * public void clickCMepisode() { clickUsingJs(cmepisodelocator); }
	 */

	public void assigntoself() {
		clickUsingJs(episodeassignlocator);
		clickUsingJs(okbuttonlocator);
	}

}
