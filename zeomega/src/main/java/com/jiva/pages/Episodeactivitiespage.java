package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class Episodeactivitiespage extends WebElements {

	public Episodeactivitiespage(WebDriver driver1) {
		super(driver1);
	}

	public boolean verify_OpenActivityRecordVisible(String userProfileName) {
		By activityrecordlocator = By
				.xpath("//*[contains(text(),'Verbal consent to be received')]/..//td[contains(text(),'"
						+ userProfileName + "')]");
		return isDisplayed(activityrecordlocator);
	}
}