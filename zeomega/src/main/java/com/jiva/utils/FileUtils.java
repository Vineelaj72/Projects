package com.jiva.utils;

import java.io.File;
import java.util.ArrayList;

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
}
