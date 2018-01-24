package com.jiva.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jiva.utils.WebElements;

public class MemberOverviewPage extends WebElements {
	
	private static Logger logger = Logger.getLogger(Episodeactivitiespage.class);

	public MemberOverviewPage(WebDriver driver1) {
		super(driver1);
	}
	
	By openepisodelinklocator = By.xpath("//li/a/span[contains(text(),'Open')]");
	
	public void clickGear(String episodeId) {
		By gearlocator = By.xpath("//div/div/div/div/div/div/span[contains(text(),'"+episodeId+"')]/../../../../../../../div/a/i[contains(@class,'fa fa-gear')]");
		logger.info(gearlocator);
		clickUsingJs(gearlocator);
		
	}
	
	public void openEpisode()
	{
		clickUsingJs(openepisodelinklocator);
	}

}
