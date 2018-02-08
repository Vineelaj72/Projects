package com.jiva.OLDTestData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadAddressFile {

	public static ArrayList<String> mandatoryCheckPoints(String sFileName) {
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> demovalue = new ArrayList<String>(); // full file reading
		ArrayList<String> fileValue = new ArrayList<String>(); // mandatory records
		try {
			fr = new FileReader(sFileName);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
					for (int j = 0; j < sCurrentLine.split("\\|", -1).length; j++) { //regular expression
						demovalue.add(sCurrentLine.split("\\|", -1)[j]);
					}
				}
					for (int j = 0; j < demovalue.size(); j++) {
				//		System.out.println("j--" + j + "--" + demovalue.get(j));
						if(demovalue.get(j).contains("^"))
						{
							fileValue.add(demovalue.get(j));
							fileValue.add(demovalue.get(j+1));	//home
							fileValue.add(demovalue.get(j+2));	//address1
							fileValue.add(demovalue.get(j+4));	//city
							fileValue.add(demovalue.get(j+5));	//state code
							fileValue.add(demovalue.get(j+6));	//zip
							fileValue.add(demovalue.get(j+7));	//country
							fileValue.add(demovalue.get(j+10));	//active status
					}
							
					}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileValue;
	}
	
	public static ArrayList<String> otherFilesData(String sFileName) {
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> demovalue = new ArrayList<String>(); // full file reading
		ArrayList<String> fileValue = new ArrayList<String>(); // mandatory records
		try {
			fr = new FileReader(sFileName);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
					for (int j = 0; j < sCurrentLine.split("\\|", -1).length; j++) { //regular expression
						demovalue.add(sCurrentLine.split("\\|", -1)[j]);
					}
				}
					for (int j = 0; j < demovalue.size(); j++) {
							fileValue.add(demovalue.get(j));
					}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileValue;
	}


	public static void main(String[] args) {
		String FILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20180129/jiva-eligibility-address_20180129_100001~20180129_100653424~.txt";
		ReadAddressFile files = new ReadAddressFile();
		ArrayList<String> mandatoryData =files.mandatoryCheckPoints(FILENAME);
		System.out.println(mandatoryData);
		System.out.println(mandatoryData.size());
		for (int i = 0; i < mandatoryData.size(); i++) {
				System.out.println("");
		}
		
		
	}
}

