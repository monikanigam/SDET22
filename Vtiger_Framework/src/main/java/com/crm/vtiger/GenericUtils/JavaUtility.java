package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
/*
 * 
 * author @Monika
 */
	/**
	 * This Method is generic random number to avoid duplicates
	 * @return
	 */
	public String getRandomData() {
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ""+ran;
	}
	/**
	 * This method is use to generate currentdate
	 * @return currentdate
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		String currentdate = date.toString();
		return currentdate;
	}
	
	public static String getSystemDate() {
		Date date = new Date();
		return date.toString().replaceAll(" ","_").replace(":", "_");
		
	}
}
