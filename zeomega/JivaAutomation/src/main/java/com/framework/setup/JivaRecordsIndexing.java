package com.framework.setup;



public interface JivaRecordsIndexing {
	//-- Reading Data from Member demographic File 
	int ENROLLMENTID=0,ALTERNATEID=1,LASTNAME=2,FIRSTNAME=3,DOB=4,ACTIVESTATUS=5,GENDER=6;
	
	//-- Reading Data from Member Address File 
		int ADDR_ENROLLMENTID=0,HOME_ADDRESSTYPE=1,HOME_ADDRESS1=2,HOME_CITY=3,HOME_STATE=4,HOME_ZIP=5,HOME_COUNTRY=6;
		int PRIMARY_ADDRESSTYPE=8,PRIMARY_ADDRESS1=9,PRIMARY_CITY=10,PRIMARY_STATE=11,PRIMARY_ZIP=12,PRIMARY_COUNTRY=13;
		
	//-- Reading Data from Member Phone File 
		int PHN_ENROLLMENTID=0,PHONENUMBER=1;
				
	//-- Reading Data from Member Coverage File 
		int CVRG_ENROLLMENTID=0;

}
