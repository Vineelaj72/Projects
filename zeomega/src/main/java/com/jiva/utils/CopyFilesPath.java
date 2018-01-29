package com.jiva.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CopyFilesPath {
 public String ymdhmsTime() throws Exception {
  String yyyymmdd = null;
  DateFormat reqFormat = new SimpleDateFormat("yyyyMMdd");// 20171114
  Date date = new Date();
  return yyyymmdd = reqFormat.format(date);
  // System.out.println(yyyymmdd);
 }

 public ArrayList<String> listofFiles(String sFolderPath,String sdateFormatofFiles) {
  ArrayList<String> listofFiles = new ArrayList<String>();
  File folder = new File(sFolderPath);
  File[] listOfFiles = folder.listFiles();
  String filesLocation=folder.getPath();

  for (int i = 0; i < listOfFiles.length; i++) {
   if (listOfFiles[i].isFile()) {
    if(listOfFiles[i].getName().contains("20171114"));
   // System.out.println("Directory " + filesLocation+"\\"+listOfFiles[i].getPath());
    listofFiles.add(listOfFiles[i].getPath());
    
   }
  }
  return listofFiles;
 }

 public static void main(String[] args) {
  String sFolderPath="C:/Users/vjayavarapu/Reference Docs/Jiva Input files/20171114";
  String sDateFormat="20171114";

  CopyFilesPath copyFilesPath = new CopyFilesPath();
  ArrayList<String> listofFiles=copyFilesPath.listofFiles(sFolderPath,sDateFormat);
  for (String string : listofFiles) {
   System.out.println(string);
   
  }
 }
}