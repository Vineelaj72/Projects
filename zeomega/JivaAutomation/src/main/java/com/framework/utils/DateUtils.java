package com.framework.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String ymdhmsTime() throws Exception {
		String yyyymmdd = null;
		DateFormat reqFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return yyyymmdd = reqFormat.format(date);
		// System.out.println(yyyymmdd);
	}

	public static String dd_mm_yyyy_currentDate() throws Exception {
		String yyyymmdd = null;
		DateFormat reqFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return yyyymmdd = reqFormat.format(date);
	}

	public static String dateFormatbyFutureDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		final long ONE_MINUTE_IN_MILLIS = 60000; // millisecs
		Date date = new Date();
		long t = date.getTime();
		c.add(Calendar.DATE, 2);
		System.out.println(dateFormat.format(c.getTime()));
		return dateFormat.format(c.getTime());

	}

	public static void main(String[] args) throws Exception {
		System.out.println(DateUtils.dd_mm_yyyy_currentDate());
		System.out.println("Future date " + DateUtils.dateFormatbyFutureDate());
		System.out.println("Current date " + DateUtils.dd_mm_yyyy_currentDate());
		System.out.println("today " + DateUtils.today());
		System.out.println("yesterday " + DateUtils.yesterday());
	}
	
	public static Date today() {
	    final Calendar cal = Calendar.getInstance();
	    return cal.getTime();
	}
	
	public static String today(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
	    final Calendar cal = Calendar.getInstance();
	    return dateFormat.format(cal.getTime());
	}
	
	public static Date yesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	public static String getYesterdayDateString(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(yesterday());
	}
	
	public static String getTodayDateString(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(today());
	}
}
