package com.jiva.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MemberDemographicFile {

	public static Map<String, String> readdemographicFile(String sFilename) {
		Map<String, String> readdemographicFilemap = new HashMap<String, String>();
		BufferedReader br = null;
		FileReader fr = null;

		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(sFilename);
			br = new BufferedReader(fr);

			String currentLine;
			String fileData[];   //values stored after split by pipe
			int lineno = 1;	// key to embed data into map
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
				fileData = currentLine.split("\\|");
				//String[] eligibilityId = fileData[0].split("^");
				
				readdemographicFilemap.put("EligibilityId"+ lineno, fileData[0]);
				
				/*readdemographicFilemap.put("EnrollId"+ lineno, eligibilityId[0]);
				readdemographicFilemap.put("ClientCode"+ lineno, eligibilityId[1]);*/
				
				readdemographicFilemap.put("MemberId"+ lineno, fileData[1]);
				readdemographicFilemap.put("MemberLastname"+ lineno, fileData[4]);
				readdemographicFilemap.put("MemberFirstname"+ lineno, fileData[5]);
				readdemographicFilemap.put("MemberDOB"+ lineno, fileData[11]);
				readdemographicFilemap.put("MemberMaritalStatus"+ lineno, fileData[13]);
				readdemographicFilemap.put("MemberGender"+ lineno, fileData[16]);
				readdemographicFilemap.put("MemberActive"+ lineno, fileData[21]);
				
				System.out.println(readdemographicFilemap.get("EligibilityId"+ lineno));
				/*System.out.println(readdemographicFilemap.get("EnrollId"+ lineno));
				System.out.println(readdemographicFilemap.get("ClientCode"+ lineno));*/
				System.out.println(readdemographicFilemap.get("MemberAlternateId"+ lineno));
				System.out.println(readdemographicFilemap.get("MemberLastname"+ lineno));
				System.out.println(readdemographicFilemap.get("MemberFirstname"+ lineno));
				System.out.println(readdemographicFilemap.get("MemberDOB"+ lineno));
				System.out.println(readdemographicFilemap.get("MemberMaritalStatus"+ lineno));
				System.out.println(readdemographicFilemap.get("MemberGender"+ lineno));
				System.out.println(readdemographicFilemap.get("MemberActive"+ lineno));
				
				lineno++;
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		return readdemographicFilemap;
	}

	public static void main(String[] args) {
		
		String sFilename = "C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114/jiva-eligibility-demographics_20171114_171337~20171114_091506616~.txt";
		//String sFilename = "C:/Users/vjayavarapu/Desktop/demofile.txt";
			
		//Map<String, String> sFileData = MemberDemographicFile.readdemographicFile(sFilename);
	
	}
}




