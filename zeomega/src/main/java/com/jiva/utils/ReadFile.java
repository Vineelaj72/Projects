package com.jiva.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {

	public static Map<String, String> readtextFile(String sFilename) {
		Map<String, String> readFile = new HashMap<String, String>();
		BufferedReader br = null;
		FileReader fr = null;

		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(sFilename);
			br = new BufferedReader(fr);

			String sCurrentLine;
			String fileData[];
			int lineno = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				fileData = sCurrentLine.split("\\|\\|");
				System.out.println(fileData[0]);
				readFile.put("FirstName" + lineno, fileData[0].split(",")[0]);
				readFile.put("LastName" + lineno, fileData[0].split(",")[1]);
				readFile.put("Jivaid" + lineno, fileData[1]);
				readFile.put("CoverageId" + lineno, fileData[2]);
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
		return readFile;
	}

	public static void main(String[] args) {
		String sFilename = "C:/Users/vjayavarapu/Desktop/textfilesample.txt";
	//	ReadFile file = new ReadFile();
		Map<String, String> sFileData = ReadFile.readtextFile(sFilename);
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


