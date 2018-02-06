package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.testcases.E2EintegrationflowTC_ZU_60;
import com.framework.utils.WebElements;

public class ProgramsPage extends WebElements{

	public ProgramsPage(WebDriver driver) {
		super(driver);
		}
	private static Logger logger = Logger.getLogger(ProgramsPage.class);
	
	public boolean verify_ProgramClosed()
	{
		By closedprogramrecordlocator = By.xpath("//span[contains(text(),'Program Closed')]");
		logger.info("Closed program record available "+isDisplayed(closedprogramrecordlocator));
		return isDisplayed(closedprogramrecordlocator);
	}
}
