package com.jiva.TestData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadAddress {

	public ArrayList<String> mandatoryCheckPoints(String sFileName) {
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> demovalue = new ArrayList<String>(); // full file reading
		ArrayList<String> fileValue = new ArrayList<String>(); // mandatory recrds
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
							fileValue.add(demovalue.get(j+4));//city
							fileValue.add(demovalue.get(j+5));//statecode
							fileValue.add(demovalue.get(j+6));//zip
							fileValue.add(demovalue.get(j+7));//country
						}
							
					}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileValue;
	}

	public static void main(String[] args) {
		String FILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-address_20171114_171337~20171114_091515211~.txt";
		ReadAddress files = new ReadAddress();
		ArrayList<String> mandatoryData =files.mandatoryCheckPoints(FILENAME);
		System.out.println(mandatoryData);
		System.out.println(mandatoryData.size());
		for (int i = 0; i < mandatoryData.size(); i++) {
				System.out.println("");
		}
	}
}

