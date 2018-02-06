package com.jiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.WebElements;

public class AssessmentsPage extends com.framework.utils.WebElements{

	public AssessmentsPage(WebDriver driver) {
		super(driver);
	}
	
	By assessmentselectionlocator = By.xpath("//input[contains(@type,'radio')]");
	By startassessmentlocator =By.xpath("//div/button[contains(text(),'Start')]");
	By mandatoryquestiondropdown = By.xpath("//select[contains(@class,'mandatory')]");
	By communicationquestiongrouplocator = By.xpath("//div[contains(@class,'question-group-label assessments')]/../div/div/div[contains(text(),'Communication')]");
	By communicationquestiondropdown = By.xpath(" //div[contains(text(),'problems communicating your healthcare')]/../../../../../div[contains(@class,'assessment-questionnaire-right')]/div/div[2]/div/div/select");
	By completeassessmentlocator = By.xpath("//button[contains(text(),'Complete')]");
	
	
	public void selectDefaultAssessment()
	{
		clickUsingJs(assessmentselectionlocator);
	}
	
	public void startDefaultAssessment()
	{
		clickUsingJs(startassessmentlocator);
	}
	
	public void answerAssessmentQuestions()
	{
		dropdownSelect(mandatoryquestiondropdown, "Initial Assessment: Complete");
		dropdownSelect(communicationquestiondropdown, "Yes");
	}
	
	public void completeAssessment()
	{
		clickUsingJs(completeassessmentlocator);
	}
}

