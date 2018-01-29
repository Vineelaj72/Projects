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
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
