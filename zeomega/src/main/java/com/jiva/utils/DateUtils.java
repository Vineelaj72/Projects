package com.jiva.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String ymdhmsTime() throws Exception {
		  String yyyymmdd = null;
		  DateFormat reqFormat = new SimpleDateFormat("yyyyMMdd");// 20171114
		  Date date = new Date();
		  return yyyymmdd = reqFormat.format(date);
		  // System.out.println(yyyymmdd);
		 }

}
