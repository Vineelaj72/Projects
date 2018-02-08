package com.jiva.TestData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.framework.setup.Setup;

public class AddressFileInput {
	private static Logger logger = Logger.getLogger(AddressFileInput.class);

	
	public static ArrayList<String> addressFileCode(String sFileName,String enrollID) {
		  BufferedReader br = null;
		  FileReader fr = null;
		  ArrayList<String> demovalue = new ArrayList<String>();
		  ArrayList<String> fileValue = new ArrayList<String>();
		  try {
		   fr = new FileReader(sFileName);
		   br = new BufferedReader(fr);
		   String sCurrentLine;
		   while ((sCurrentLine = br.readLine()) != null) {
		    for (int j = 0; j < sCurrentLine.split("\\|", -1).length; j++) {
		     demovalue.add(sCurrentLine.split("\\|", -1)[j]);
		    }
		   }
		     for (int k = 0; k < demovalue.size(); k++) {
		    //  System.out.println("@@"+k+"--"+demovalue.get(k)); // to print all the values in the file.
		      if (demovalue.get(k).equals(enrollID)) {
		    	//  logger.info("j value is" + k);
		       fileValue.add(demovalue.get(k));
		       fileValue.add(demovalue.get(k+1));
		       fileValue.add(demovalue.get(k+2));
		       fileValue.add(demovalue.get(k+4));
		       fileValue.add(demovalue.get(k+5));
		       fileValue.add(demovalue.get(k+6));
		       fileValue.add(demovalue.get(k+7));
		     	 
		      }
		     }
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  return fileValue;
		 }

	public static void main(String[] args) {
		
		String Addressfile=Setup.MEMBERADDRESSFILENAME;
		
		System.out.println(AddressFileInput.addressFileCode(Addressfile, "000000877^EHI0NA"));
	}
}
