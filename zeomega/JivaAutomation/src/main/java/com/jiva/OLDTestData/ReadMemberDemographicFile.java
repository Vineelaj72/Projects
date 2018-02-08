package com.jiva.OLDTestData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReadMemberDemographicFile {

	
	public static ArrayList<String> mandatoryCheckPoints(String sFileName,int linenumber) throws IOException {
		
		ArrayList<String> fileValue= new ArrayList<String>();
		
		 String[] currentLine = Files.readAllLines(Paths.get(sFileName)).get(linenumber).split("\\|", -1);

						//System.out.println("j--" + j + "--" + demovalue.get(j));
		 for (int j = 0; j < currentLine.length; j++) {
			
					if(currentLine[j].contains("^"))
					{
							fileValue.add(currentLine[j]);
							fileValue.add(currentLine[j+1]);	
							fileValue.add(currentLine[j+4]);
							fileValue.add(currentLine[j+5]);
							fileValue.add(currentLine[j+11]);
							fileValue.add(currentLine[j+21]);
							fileValue.add(currentLine[j+16]);
							
		 }
					}

		
		return fileValue;
	}

	
	
	public static ArrayList<String> mandatoryCheckPoints(String sFileName) {
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> demovalue = new ArrayList<String>(); // full file reading
		ArrayList<String> fileValue = new ArrayList<String>(); // mandatory records
		try {
			fr = new FileReader(sFileName);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null)
				{
					for (int j = 0; j < sCurrentLine.split("\\|", -1).length; j++)  //regular expression
					{
						demovalue.add(sCurrentLine.split("\\|", -1)[j]);
					}
				}
					for (int j = 0; j < demovalue.size(); j++) {
						//System.out.println("j--" + j + "--" + demovalue.get(j));
						if(demovalue.get(j).contains("^"))
						{
							fileValue.add(demovalue.get(j));
							fileValue.add(demovalue.get(j+1));		
							fileValue.add(demovalue.get(j+4));
							fileValue.add(demovalue.get(j+5));
							fileValue.add(demovalue.get(j+11));
							fileValue.add(demovalue.get(j+21));
							fileValue.add(demovalue.get(j+16));
						}
							
					}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileValue;
	}

	public static void main(String[] args) throws IOException {
		String FILENAME = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-demographics_20171114_171337~20171114_091506616~.txt";
	//	ReadMemberDemographicFile files = new ReadMemberDemographicFile();
		ArrayList<String> mandatoryData =ReadMemberDemographicFile.mandatoryCheckPoints(FILENAME,3);
		System.out.println(mandatoryData);
		System.out.println(mandatoryData.size());
		for (int i = 0; i < mandatoryData.size(); i++) {
			System.out.println("mandatory--"+i+"---"+mandatoryData.get(i));
		}
	}
}

