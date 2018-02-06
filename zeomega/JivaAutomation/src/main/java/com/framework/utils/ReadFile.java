package com.framework.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {

	public static Map<String, String> readtextFile(String sFilename) {
		Map<String, String> readFilemap = new HashMap<String, String>();
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
				//System.out.println(sCurrentLine);
				fileData = currentLine.split("\\|\\|");
				//System.out.println(fileData[0]);
				String[] fullname = fileData[0].split(",");
				readFilemap.put("MemberFullname"+ lineno, fileData[0]);
				readFilemap.put("MemberLastName" + lineno, fullname[0]);				
				readFilemap.put("MemberFirstName" + lineno, fullname[1]);
				readFilemap.put("JivaId" + lineno, fileData[1]);
				readFilemap.put("CoverageId" + lineno, fileData[2]);
				System.out.println(readFilemap.get("MemberFullname"+ lineno));
				System.out.println(fullname[0]);
				System.out.println(fullname[1]);
				System.out.println(readFilemap.get("JivaId" + lineno));
				System.out.println(readFilemap.get("CoverageId" + lineno));
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
		return readFilemap;
	}

	public static void main(String[] args) {
		String sFilename = "C:/Users/vjayavarapu/Desktop/textfilesample.txt";
			//	ReadFile file = new ReadFile();
		Map<String, String> sFileData = ReadFile.readtextFile(sFilename);
		System.out.println("");
		System.out.println(sFileData.get("CoverageId1"));
		
		/*System.out.println("Firstname" + sFileData.get("FirstName"));
		System.out.println("LastName" + sFileData.get("LastName"));
		System.out.println("Jivaid" + sFileData.get("Jivaid"));
		System.out.println("CoverageId" + sFileData.get("CoverageId"));*/
	//	System.out.println("@@@+sFileData"+sFileData.toString().contains("Alex"));
	//	Assert.assertEquals(true, sFileData.toString().contains(new Dashboard(driver).));
	}
}


/*Map<String, String> fileData=ReadFile.readtextFile(sFilename);
fileData.get(arg0);*/


