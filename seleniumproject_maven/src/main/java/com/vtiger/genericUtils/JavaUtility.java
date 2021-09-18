package com.vtiger.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class contain java specific generic library
 * @author Rakesh
 *
 */
public class JavaUtility {
	/**
	 * this method return random number
	 * @return
	 */
	public int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
	}
	
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	public String getSystmeDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
	public String getSystmeDate_YYYY_MM__DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
        String DD = arr[2];
        String YYYY = arr[5];   
int MM = date.getMonth()+1;

        String finalFromat = YYYY+"-"+MM+"-"+DD;
		return finalFromat;	
	}
	



}
