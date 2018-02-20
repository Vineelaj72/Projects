package com.jiva.TestData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.framework.setup.Setup;

public class PhoneFileInput {
	private static Logger logger = Logger.getLogger(PhoneFileInput.class);

	
	public static ArrayList<String> phoneFileCode(String sFileName,String enrollID) {
		  BufferedReader br = null;
		  FileReader fr = null;
		  ArrayList<String> phonevalue = new ArrayList<String>();
		  ArrayList<String> fileValue = new ArrayList<String>();
		  try {
		   fr = new FileReader(sFileName);
		   br = new BufferedReader(fr);
		   String sCurrentLine;
		   while ((sCurrentLine = br.readLine()) != null) {
		    for (int j = 0; j < sCurrentLine.split("\\|", -1).length; j++) {
		     phonevalue.add(sCurrentLine.split("\\|", -1)[j]);
		    }
		   }
		     for (int k = 0; k < phonevalue.size(); k++) {
		    	 
		      if (phonevalue.get(k).equals(enrollID)) {
		    	 
		       fileValue.add(phonevalue.get(k));
		       fileValue.add(phonevalue.get(k+2));
		      
		      }
		     }
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  return fileValue;
		 }

	public static void main(String[] args) {
		
		String phoneFile=Setup.MEMBERPHONEFILENAME;		
		System.out.println(PhoneFileInput.phoneFileCode(phoneFile,"000000877^EHI0NA"));
	}
}
