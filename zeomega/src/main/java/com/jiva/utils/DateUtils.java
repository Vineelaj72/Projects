package com.jiva.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String ymdhmsTime() throws Exception {
		String yyyymmdd = null;
		DateFormat reqFormat = new SimpleDateFormat("yyyyMMdd");// 20171114
		Date date = new Date();
		return yyyymmdd = reqFormat.format(date);
		// System.out.println(yyyymmdd);
	}

	public static String dd_mm_yyyy_currentDate() throws Exception {
		String yyyymmdd = null;
		DateFormat reqFormat = new SimpleDateFormat("MM/dd/yyyy");// 20171114
		Date date = new Date();
		return yyyymmdd = reqFormat.format(date);
	}

	public static String dateFormatbyFutureDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		final long ONE_MINUTE_IN_MILLIS = 60000;// millisecs
		Date date = new Date();
		long t = date.getTime();
		c.add(Calendar.DATE, 2);
		// Date date1 = new Date(t + (-1 * ONE_MINUTE_IN_MILLIS));
		System.out.println(dateFormat.format(c.getTime()));
		return dateFormat.format(c.getTime());

	}

	public static void main(String[] args) throws Exception {
		System.out.println(DateUtils.dd_mm_yyyy_currentDate());
		System.out.println("Fur" + DateUtils.dateFormatbyFutureDate());
	}
}
