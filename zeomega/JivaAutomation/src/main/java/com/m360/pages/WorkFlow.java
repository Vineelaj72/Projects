package com.m360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WorkFlow {

	@FindBy(how = How.LINK_TEXT, using = "//label[contains(text(),'Application Entry')]")
    @CacheLookup
    private WebElement lnkApplicationEntry;
	
	
	public void searchForApplicationEntry() {
		lnkApplicationEntry.click();
		
		
	}

}
