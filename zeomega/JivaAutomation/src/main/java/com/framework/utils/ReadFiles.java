package com.framework.utils;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;

import com.framework.setup.Setup;

	enum DEMOGRAPHICS
	{
		ENROLL_ID,
		ALT_ENROLL_ID,
		MPI_ID,
		MEMBER_SSN,
		LAST_NAME,
		FIRST_NAME,
		MIDDLE_NAME,
		SUFFIX_CD,
		PRIMARY_CARE_MANAGER,
		ACO_ID,
		EMAIL,
		BIRTH_DATE,
		DEATH_DATE,
		MARITAL_STATUS_CD,
		MEMBER_LANGUAGE_CD,
		ETHNICITY_CD,
		GENDER_CD,
		TIME_ZONE,
		SPECIAL_NEEDS,
		DATA_SOURCE_CD,
		KEYWORDS,
		RECORD_ACTIVE,
		FAMILY_LINK,
		HOH,
		RACE_CD
	}

	public class ReadFiles {

		private static final String FILENAME = Setup.SFILENAME;

		public static void main(String[] args) {
			Map<String, String> demoGraph= new HashMap<String, String>();
			BufferedReader br = null; FileReader fr = null;	String currentLine[];
			ArrayList<String> demovalue= new ArrayList<String>();
			try {

				fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				int i = 0;
				int k=0;

				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					currentLine = sCurrentLine.split("\\|");
					
						
							for (int j = 0; j < currentLine.length; j++) {
								demovalue.add(currentLine[j]);
							}
							
						for (DEMOGRAPHICS dir : DEMOGRAPHICS.values()) {
							System.out.println("----"+k+demovalue.get(k));
						//	demoGraph.put(dir+""+i, demovalue.get(k));
							k++;
						}
						i++;
							
				}	
				for (String string : demovalue) {
					
					System.out.println("@@@"+string);
				}
			}catch (IOException e) {

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
			System.out.println(demoGraph);
		}
	}

