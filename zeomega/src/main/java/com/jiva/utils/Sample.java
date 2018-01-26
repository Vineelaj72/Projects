package com.jiva.utils;

public class Sample {
public static void main(String[] args) {
	String aString="000015293^EHI0NA|000015293|||";
			//+ "Radford|Bernetta|D|||||1939-02-16||DIV|||F||||||||";
	String a[]=(aString.split("\\|"));
	for (int i = 0; i < a.length; i++) {
		System.out.println("--"+i+"---"+a[i]);
	}
	
			}
}
