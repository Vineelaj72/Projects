package com.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileUtils {
	public  static ArrayList<String> listofFiles(String sFolderPath,String sdateFormatofFiles) {
	  ArrayList<String> listofFiles = new ArrayList<String>();
	  File folder = new File(sFolderPath);
	  File[] listOfFiles = folder.listFiles();
	  String filesLocation=folder.getPath();

	  for (int i = 0; i < listOfFiles.length; i++) {
	   if (listOfFiles[i].isFile()) {
	    if(listOfFiles[i].getName().contains(sdateFormatofFiles));
	   // System.out.println("Directory " + filesLocation+"\\"+listOfFiles[i].getPath());
	    listofFiles.add(filesLocation+"\\"+listOfFiles[i].getPath());
	    
	   }
	  }
	  return listofFiles;
	 }
	
	public static void appendNewLineWithTodayDate(String filePath, String newLine, String delimiter) {
		try {
			newLine = "\n" + newLine + delimiter + DateUtils.getTodayDateString("yyyy-MM-dd");
		    Files.write(Paths.get(filePath), newLine.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
		
	}

	public static String[] getlastLineInFileWithYesterdayDate(String filePath, String delimiter) {
		String lastLine = "";
		String sCurrentLine = "";
		String[] lastLineParts = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((sCurrentLine = br.readLine()) != null) 
			{
			    System.out.println(sCurrentLine);
			    lastLine = sCurrentLine;
			    lastLineParts = lastLine.split(Pattern.quote(delimiter));
			}
			if	(!DateUtils.getYesterdayDateString("yyyy-MM-dd").equals(lastLineParts[3])){
		    	return null;
		    }
		    return lastLineParts;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
