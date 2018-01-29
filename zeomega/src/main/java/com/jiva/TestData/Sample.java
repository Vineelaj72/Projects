package com.jiva.TestData;

public class Sample {

	public static void main(String[] args) {
			String data = "5|6|7||8|9|||";
			String[] split = data.split("\\|",-1);
			System.out.println("--"+split.length);
			for (int i = 0; i < split.length; i++) {
				
				System.out.println(split[i]);
			}
		}
}
