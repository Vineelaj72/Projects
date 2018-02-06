package com.framework.utils;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class ValidationHelper {
	public static SoftAssert AssertTrue(SoftAssert softAssert, String entityId, String feedFileVal, WebElement appField, String msgFalse, String fieldName){
		String appFieldVal = null;
		try {
			appFieldVal = appField.getAttribute("value");
		} catch (Exception e) {
			softAssert.fail("No Information was found for member :"+ entityId);
			System.out.println("No Information was found for member :"+ entityId);
		}
		softAssert.assertTrue(feedFileVal.equals(appFieldVal), String.format(msgFalse, fieldName, feedFileVal, appFieldVal));
		return softAssert;
	}
}

