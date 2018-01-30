package com.jiva.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {
public static void main(String[] args) {
	/*String aString="000015293^EHI0NA|000015293|||";
			//+ "Radford|Bernetta|D|||||1939-02-16||DIV|||F||||||||";
	String a[]=(aString.split("\\|"));
	for (int i = 0; i < a.length; i++) {
		System.out.println("--"+i+"---"+a[i]);
	}
	*/
	
	Date myDate = new Date();
    System.out.println(myDate);

    //SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Format the date to Strings
    //String mdy = mdyFormat.format(myDate);
    String dmy = dmyFormat.format(myDate);

    // Results...
   // System.out.println(mdy);
    System.out.println(dmy);
    
    
    /*memberSearchPage.enterMemberLastname(sFileData.get("MemberLastname3"));
	memberSearchPage.enterMemberFirstname(sFileData.get("MemberFirstname3"));
	memberSearchPage.clickSearch();

	ConfirmAddepisodePage confirmAddepisodePage = new ConfirmAddepisodePage(driver);
	confirmAddepisodePage.clickRedirecttoMCV();
	
	//Validate the data against the screen
	
	MemberOverviewPage memberOverviewPage = new MemberOverviewPage(driver);
	String coverageidvalue = memberOverviewPage.getCoverageId();
	String Phonenovalue = memberOverviewPage.getPhoneNumber();
	String activestatusvalue = memberOverviewPage.getActiveStatus();
	String lastnamevalue = memberOverviewPage.getMemberLastName();
	String firstnamevalue = memberOverviewPage.getMemberFirstName();
	String alternateidvalue = memberOverviewPage.getAlternateId();
	String memberDOBvalue = memberOverviewPage.getMemberDOB();
	String maritalstatusvalue = memberOverviewPage.getMemberMaritalStatus();
	String gendervalue = memberOverviewPage.getGender();
	
	String HOMEzipvalue = memberOverviewPage.gethomezip();
	String HOMEcityvalue = memberOverviewPage.gethomecity();
	String HOMEaddressline1value = memberOverviewPage.gethomeaddressline1();
	String HOMEaddressline2value = memberOverviewPage.gethomeaddressline2();
	String HOMEstatevalue = memberOverviewPage.gethomestate();
	String HOMEcountryvalue = memberOverviewPage.gethomecountry();
	
	String PRIMARYzipvalue = memberOverviewPage.getprimaryzip();
	String PRIMARYcityvalue = memberOverviewPage.getprimarycity();
	String PRIMARYaddressline1value = memberOverviewPage.getprimaryaddressline1();
	String PRIMARYaddressline2value = memberOverviewPage.getprimaryaddressline2();
	String PRIMARYstatevalue = memberOverviewPage.getprimarystate();
	String PRIMARYcountryvalue = memberOverviewPage.getprimarycountry();
	
	
	Assert.assertEquals(sFileData.get("CoverageId3"),coverageidvalue,"Member coverage id validated");
	Assert.assertEquals(sFileData.get("PhoneNo3"),Phonenovalue,"Member Phone number validated");		
	Assert.assertEquals(sFileData.get("MemberActive3"),activestatusvalue,"Member active status validated");
	
	memberOverviewPage.openMemberInformation();
	
	
	Assert.assertEquals(sFileData.get("MemberLastname3"),lastnamevalue,"Member last name validated");
	Assert.assertEquals(sFileData.get("MemberFirstname3"),firstnamevalue,"Member first name validated");		
	Assert.assertEquals(sFileData.get("MemberAlternateId3"),alternateidvalue,"Member alternate id validated");
	Assert.assertEquals(sFileData.get("MemberDOB3"),memberDOBvalue,"Member DOB validated");
	Assert.assertEquals(sFileData.get("MemberMaritalStatus3"),maritalstatusvalue,"Member marital status validated");
	Assert.assertEquals(sFileData.get("MemberGender3"),gendervalue,"Member gender validated");
	
	Assert.assertEquals(sFileData.get("HOMEzipvalue"),HOMEzipvalue,"Member HOMEzipvalue validated");
	Assert.assertEquals(sFileData.get("HOMEcityvalue"),HOMEcityvalue,"Member HOMEcityvalue validated");		
	Assert.assertEquals(sFileData.get("HOMEaddressline1value"),HOMEaddressline1value,"Member HOMEaddressline1value validated");
	Assert.assertEquals(sFileData.get("HOMEaddressline2value"),HOMEaddressline2value,"Member HOMEaddressline2value validated");
	Assert.assertEquals(sFileData.get("HOMEstatevalue"),HOMEstatevalue,"Member HOMEstatevalue validated");
	Assert.assertEquals(sFileData.get("HOMEcountryvalue"),HOMEcountryvalue,"Member HOMEcountryvalue validated");
	
	Assert.assertEquals(sFileData.get("PRIMARYzipvalue"),PRIMARYzipvalue,"Member PRIMARYzipvalue validated");
	Assert.assertEquals(sFileData.get("PRIMARYcityvalue"),PRIMARYcityvalue,"Member PRIMARYcityvalue validated");		
	Assert.assertEquals(sFileData.get("PRIMARYaddressline1value"),PRIMARYaddressline1value,"Member PRIMARYaddressline1value validated");
	Assert.assertEquals(sFileData.get("PRIMARYaddressline2value"),PRIMARYaddressline2value,"Member PRIMARYaddressline2value validated");
	Assert.assertEquals(sFileData.get("PRIMARYstatevalue"),PRIMARYstatevalue,"Member PRIMARYstatevalue validated");
	Assert.assertEquals(sFileData.get("PRIMARYcountryvalue"),PRIMARYcountryvalue,"Member PRIMARYcountryvalue validated");
			
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
